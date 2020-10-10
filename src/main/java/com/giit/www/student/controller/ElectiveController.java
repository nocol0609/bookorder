package com.giit.www.student.controller;

import com.giit.www.college.service.SectionBiz;
import com.giit.www.college.service.StudentBiz;
import com.giit.www.entity.Student;
import com.giit.www.entity.Takes;
import com.giit.www.entity.custom.SectionCustom;
import com.giit.www.entity.custom.SelectedCourseCustom;
import com.giit.www.student.service.ElectiveBiz;
import com.giit.www.system.service.AccountBiz;
import org.apache.ibatis.annotations.Param;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
@RequestMapping("elective.do")
public class ElectiveController {

    @Resource(name = "electiveBizImpl")
    private ElectiveBiz electiveBiz;

    @Resource(name = "studentBizImpl")
    private StudentBiz studentBiz;

    @Resource(name = "accountBizImpl")
    private AccountBiz accountBiz;

    @Resource(name = "sectionBizImpl")
    private SectionBiz sectionBiz;

    @RequiresRoles(value = {"admin", "student"}, logical = Logical.OR)
    @RequestMapping("elective.view")
    public String electiveView(Model m) {
        //��ȡ��ǰѧ��id
        String studentId=(String) SecurityUtils.getSubject().getPrincipal();
        List<SectionCustom> sectionList=electiveBiz.findAllSection();
        for (SectionCustom sectionCustom:sectionList){
            Takes takes=electiveBiz.findTakesByStuIdAndSecId(studentId,sectionCustom.getTimetableList().get(0).getSecId());
            if(takes!=null){
                sectionCustom.setFlag("1"); //��ʾ��ѧ���Ѿ�ѡ����ſγ�
            }else {
                sectionCustom.setFlag("0"); //��ʾ��ѧ��δѡ����ſγ�
            }
        }
        m.addAttribute("sectionList", sectionList);
        return "/student/elective";
    }

    @RequiresRoles(value = {"admin", "student"}, logical = Logical.OR)
    @RequestMapping("studentInfo.view")
    public String studentInfo(Model m) {
        //��ȡ��ǰ�û�
        Subject subject = SecurityUtils.getSubject();
        Student student=studentBiz.findStudentByStudentId((String) subject.getPrincipal());
        m.addAttribute("student", student);
        return "/student/studentInfo";
    }


    @RequiresRoles(value = {"admin", "student"}, logical = Logical.OR)
    @RequestMapping("selectedCourse.view")
    public String selectedCourse(Model m) {

        //��ȡ��ǰ�û���
        Subject subject = SecurityUtils.getSubject();

        List<SelectedCourseCustom> selectedCourseList = electiveBiz.findStudentAndSelectCourseListByName((String) subject.getPrincipal());

        m.addAttribute("selectedCourseList", selectedCourseList);

        return "/student/selectCourse";
    }

    /**
     * ���޿γ̣������Ѵ��
     * @param m
     * @return
     */
    @RequiresRoles(value = {"admin", "student"}, logical = Logical.OR)
    @RequestMapping("playedCourse.view")
    public String playedCourse(Model m) {

        //��ȡ��ǰ�û���
        Subject subject = SecurityUtils.getSubject();

        List<SelectedCourseCustom> playedCourseList = electiveBiz.findHasPlayedCourse((String) subject.getPrincipal());

        m.addAttribute("playedCourseList", playedCourseList);

        return "/student/playedCourse";
    }

    @RequiresAuthentication
    @RequiresRoles(value = {"admin", "student"}, logical = Logical.OR)
    @RequestMapping("changepass_stu.view")
    public String changePass(Model m) {
        return "/student/changepass_stu";
    }

    @RequiresRoles("student")
    @RequestMapping("update")
    public String update(HttpSession session, String password) {
        String userId = (String) session.getAttribute("username");
        accountBiz.updatePassword(userId, password);
        return "redirect:/logout";
    }


    @RequiresRoles(value = {"admin", "student"}, logical = Logical.OR)
    @RequestMapping("add")
    public String add(int secId, HttpSession session) {
        String stdId = (String) session.getAttribute("username");
        electiveBiz.add(secId, stdId);
        return "redirect:/elective.do/elective.view";
    }

    @RequiresRoles(value = {"admin", "student"}, logical = Logical.OR)
    @RequestMapping("delete")
    public String delete(int secId, HttpSession session) {
        String stdId = (String) session.getAttribute("username");
        electiveBiz.delete(secId, stdId);
        return "redirect:/elective.do/elective.view";
    }

    /**
     * ��ѡ�γ�
     * @param courseTitle
     * @return
     */
    @RequiresRoles(value = {"admin", "student"}, logical = Logical.OR)
    @RequestMapping("back")
    public String back(@Param("courseTitle") String courseTitle) throws Exception{
        courseTitle=new String(courseTitle .getBytes("iso8859-1"),"utf-8");
        String studentId=(String)SecurityUtils.getSubject().getPrincipal();
        //ͨ���γ�����ȡsec_id
        String secId=sectionBiz.findSecIdByCourseTitle(courseTitle);
        electiveBiz.delete(Integer.parseInt(secId), studentId);

        return "redirect:/elective.do/selectedCourse.view";
    }
}
