package com.giit.www.college.controller;

import com.giit.www.college.service.SpecBiz;
import com.giit.www.college.service.StudentBiz;
import com.giit.www.entity.Student;
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
@RequestMapping("student.do")
public class StudentController {

    @Resource(name = "studentBizImpl")
    StudentBiz studentBiz;

    @Resource(name = "specBizImpl")
    SpecBiz specBiz;

    @RequiresRoles("admin")
    @RequestMapping("student.view")
    public String studentView(Model m) {
        //TODO 
        m.addAttribute("studentList", studentBiz.studentView());
        return "/admin/college/student";
    }

    @RequiresRoles("admin")
    @RequestMapping("student_add.view")
    public String studentAddView(Model m) {
        m.addAttribute("deptNameList", specBiz.findDpet());
        return "/admin/college/student_add";   //跳转增加学生界面
    }

    @RequiresRoles("admin")
    @RequestMapping("student_update.view")
    public String studentUpdateView(Model m ,@Param("studentId") String studentId) {
        m.addAttribute("deptNameList", specBiz.findDpet());
        Student student=studentBiz.findStudentByStudentId(studentId);
        m.addAttribute("student",student);
        return "/admin/college/student_update";  //跳转修改学生界面
    }

    @RequiresRoles("admin")
    @RequestMapping("add")
    public String add(Student student) throws IOException {
        studentBiz.add(student);//图片暂不可用
        return "redirect:/student.do/student.view";   //增加学生后跳转学生管理界面
    }

    @RequiresRoles("admin")
    @RequestMapping("delete")
    public String delete(String studentId) {
        studentBiz.delete(studentId);
        return "redirect:/student.do/student.view";
    }

    @RequiresRoles("admin")
    @RequestMapping("update")
    public String update(Student student) {
        studentBiz.update(student);
        return "redirect:/student.do/student.view";
    }
}
