package com.giit.www.college.controller;

import com.giit.www.college.service.OrderBookBiz;
import com.giit.www.college.service.SectionBiz;
import com.giit.www.college.service.StudentBiz;
import com.giit.www.college.service.TeacherBiz;
import com.giit.www.entity.Section;
import com.giit.www.entity.Student;
import com.giit.www.entity.Teacher;
import com.giit.www.entity.custom.*;
import com.giit.www.system.service.AccountBiz;
import com.giit.www.util.TermContainer;
import org.apache.ibatis.annotations.Param;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Map;

/**
 * 教材订购控制器
 * @author Nocol
 *
 */
@Controller
@RequestMapping("orderbook.do")

public class OrderBookController {
    @Resource(name = "orderBookBizImpl")
    private OrderBookBiz orderBookBiz;

    @Resource(name = "accountBizImpl")
    private AccountBiz accountBiz;

    @Resource(name = "teacherBizImpl")
    TeacherBiz teacherBiz;

    @Resource(name = "sectionBizImpl")
    private SectionBiz sectionBiz;

    @Resource(name = "studentBizImpl")
    private StudentBiz studentBiz;

    @RequiresRoles(value = {"admin", "teacher"}, logical = Logical.OR)
    @RequestMapping("orderbook.view")
    public String orderBookView(Model m, HttpSession httpSession) {

        String staffNo=(String)SecurityUtils.getSubject().getPrincipal();
        String staffId=teacherBiz.findTeacherByStaffNo(staffNo).getStaffId();

        //查询今年已开设的课程
        List<Section> sectionList = orderBookBiz.findSelectedSection(staffId, TermContainer.now());
        int courseCount = sectionList.size();
        m.addAttribute("selectedSectionList", sectionList);
        m.addAttribute("courseCount", courseCount);
        return "/teacher/orderbook";
    }
    
    @RequiresRoles(value = {"admin", "teacher"}, logical = Logical.OR)
    @RequestMapping("orderbook_review.view")
    public String orderBookReviewView(Model m, HttpSession session) {
        
    	//查询出已添加但是还未审核的教材
        session.setAttribute("notReviewedBookList", orderBookBiz.findAllNotReviewedBook());
        //主页秘书审核
        return "/teacher/orderbook_review";
    }

    @RequiresRoles(value = {"admin", "teacher"}, logical = Logical.OR)
    @RequestMapping("orderbook_add.view")
    public String orderBookAddView(Model m) {
    	//添加教材的那个jsp
        return "/teacher/orderbook_add";
    }

    @RequiresRoles(value = {"admin", "teacher"}, logical = Logical.OR)
    @RequestMapping("orderbook_added.view")
    public String orderBookAddedView(Model m, HttpSession session) {
        String staffNo = (String) SecurityUtils.getSubject().getPrincipal();
        //查询已添加的教材
        m.addAttribute("addedBookInfoList", orderBookBiz.findAddedBookInfoList(staffNo));
        //已添加的那个jsp
        return "/teacher/orderbook_added";
    }

    @RequiresRoles(value = {"admin", "teacher"}, logical = Logical.OR)
    @RequestMapping("add")
    public String add(HttpServletRequest request, HttpSession session) {
        Map map = request.getParameterMap();
        OrderBookVo orderBookVo = new OrderBookVo();
        //获取当前登录的教师的姓名
        orderBookVo.setStaffNo((String) SecurityUtils.getSubject().getPrincipal());
        //将添加的图书的信息封装进map集合内（可能是多本书）
        orderBookVo.setMap(map);
        orderBookBiz.add(orderBookVo);
        return "redirect:/orderbook.do/orderbook.view";
    }

    @RequiresRoles(value = {"admin", "teacher"}, logical = Logical.OR)
    @RequestMapping("update")
    @ResponseStatus(value = HttpStatus.OK)
    public void update(@RequestBody ChangedItems changedItems, HttpSession session) {
        orderBookBiz.update(changedItems, (String)SecurityUtils.getSubject().getPrincipal());
    }

    @RequiresRoles(value = {"admin", "teacher"}, logical = Logical.OR)
    @RequestMapping("audit")
    public String audit(HttpSession session) {
        List<OrderBookReviewVo> orderBookReviewVoList = (List<OrderBookReviewVo>) session.getAttribute("notReviewedBookList");
        orderBookBiz.audit(orderBookReviewVoList);
        return "redirect:/orderbook.do/orderbook_review.view";
    }

    @RequiresAuthentication
    @RequiresRoles(value = {"admin", "teacher"}, logical = Logical.OR)
    @RequestMapping("changePass_tea.view")
    public String changePass(Model m) {
        return "/teacher/changepass_tea";
    }

    @RequiresRoles(value = {"admin", "teacher"}, logical = Logical.OR)
    @RequestMapping("updatePass")
    public String update(HttpSession session, String password) {
        String userId = (String) session.getAttribute("username");
        accountBiz.updatePassword(userId, password);
        return "redirect:/logout";
    }

    @RequiresRoles(value = {"admin", "teacher"}, logical = Logical.OR)
    @RequestMapping("/staffInfo.view")
    public String staffInfo(Model m) {
        //获取当前用户
        Subject subject = SecurityUtils.getSubject();
        Teacher teacher=teacherBiz.findTeacherByStaffNo((String)subject.getPrincipal());
        m.addAttribute("teacher", teacher);
        return "/teacher/teacherInfo";
    }

    @RequiresRoles(value = {"admin", "teacher"}, logical = Logical.OR)
    @RequestMapping("/teachedCourse.view")
    public String teachedCourse(Model m) {
        Subject subject = SecurityUtils.getSubject();
        List<TeachedCourseVo> teachedCourseVoList=teacherBiz.findTeachedCourse(teacherBiz.findTeacherByStaffNo((String)subject.getPrincipal()).getStaffId()); //staffId
        m.addAttribute("teachedCourseVoList", teachedCourseVoList);
        return "/teacher/teachedCourse";
    }

    @RequiresRoles(value = {"admin", "teacher"}, logical = Logical.OR)
    @RequestMapping("/grade.view")
    public String grade(@Param("courseTitle") String courseTitle,Model m) throws Exception {

        courseTitle=new String(courseTitle.getBytes("iso8859-1"),"utf-8");
        String secId=sectionBiz.findSecIdByCourseTitle(courseTitle);

        List<MarkVo> markVoList=teacherBiz.findStudentMarkBySecId(secId);
        for(MarkVo markVo:markVoList){
            markVo.setCourseTitle(courseTitle);
        }
        m.addAttribute("markVoList", markVoList);
        return "/teacher/studentMark";
    }

    @RequiresRoles(value = {"admin", "teacher"}, logical = Logical.OR)
    @RequestMapping("/toMark.view")
    public ModelAndView ToMark(@Param("studentId" )String studentId, @Param("courseTitle") String courseTitle) throws Exception{
        courseTitle=new String(courseTitle.getBytes("iso8859-1"),"utf-8");
        Student student=studentBiz.findStudentByStudentId((studentId));
        ModelAndView view=new ModelAndView("/teacher/markForStudent");
        view.addObject("courseTitle", courseTitle);
        view.addObject("studentId", student.getStudentId());
        view.addObject("studentName",student.getStudentName());
        return view;
    }

    @RequiresRoles(value = {"admin", "teacher"}, logical = Logical.OR)
    @RequestMapping(value = "/commitScore")
    public String ToMark(MarkVo markVo){
        String secId=sectionBiz.findSecIdByCourseTitle(markVo.getCourseTitle());
        markVo.setSecId(secId);
        teacherBiz.updateStudentMark(markVo);
        return "redirect:/orderbook.do/teachedCourse.view";
    }
}
