package com.giit.www.college.controller;

import com.giit.www.college.service.SpecBiz;
import com.giit.www.college.service.TeacherBiz;
import com.giit.www.entity.Teacher;
import org.apache.ibatis.annotations.Param;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.io.IOException;

/**
 * 学生控制器
 * @author Nocol
 *
 */
@Controller
@RequestMapping("teacher.do")
public class TeacherController {

    @Resource(name = "teacherBizImpl")
    TeacherBiz teacherBiz;

    @Resource(name = "specBizImpl")
    SpecBiz specBiz;

    @RequiresRoles("admin")
    @RequestMapping("teacher.view")
    public String studentView(Model m) {
        //TODO 
        m.addAttribute("teacherList", teacherBiz.teacherView());
        return "/admin/college/teacher";
    }

    @RequiresRoles("admin")
    @RequestMapping("teacher_add.view")
    public String studentAddView(Model m) {

        m.addAttribute("deptNameList", specBiz.findDpet());  //将所有学院带到下拉框
        return "/admin/college/teacher_add";   //跳转增加教师界面
    }

    @RequiresRoles("admin")
    @RequestMapping("teacher_updata.view")
    public String studentUpdateView(Model m, @Param("staffNo") String staffNo) {
        m.addAttribute("deptNameList", specBiz.findDpet());
        Teacher teacher=teacherBiz.findTeacherByStaffNo(staffNo);
        m.addAttribute("teacher",teacher);
        return "/admin/college/teacher_updata";  //跳转修改教师界面
    }

    @RequiresRoles("admin")
    @RequestMapping("add")
    public String add(Teacher teacher) throws IOException {
        teacherBiz.add(teacher);//图片暂不可用
        return "redirect:/teacher.do/teacher.view";   //增加学生后跳转学生管理界面
    }

    @RequiresRoles("admin")
    @RequestMapping("delete")
    public String delete(@Param("staffNo") String staffNo) {
        teacherBiz.delete(staffNo);
        return "redirect:/teacher.do/teacher.view";
    }

    @RequiresRoles("admin")
    @RequestMapping("update")
    public String update(Teacher teacher) {
        teacherBiz.update(teacher);
        return "redirect:/teacher.do/teacher.view";
    }
}
