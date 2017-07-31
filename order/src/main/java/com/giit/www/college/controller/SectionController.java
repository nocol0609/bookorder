package com.giit.www.college.controller;

import com.giit.www.college.service.SectionBiz;
import com.giit.www.entity.Section;
import com.giit.www.entity.Timetable;
import com.giit.www.util.TermContainer;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * 课程安排控制器
 * @author Nocol
 *
 */
@Controller
@RequestMapping("section.do")
public class SectionController {
    @Resource(name = "sectionBizImpl")
    private SectionBiz sectionBiz;

    @RequiresRoles("admin")
    @RequestMapping("section.view")
    public String sectionView(Model m) {
        m.addAttribute("sectionList", sectionBiz.findAllCustom()); //课程安排界面显示所有已开设的课程
        return "/admin/college/section";  
    }

    @RequiresRoles("admin")
    @RequestMapping("section_add.view")
    public String sectionAddView(Model m) {
        m.addAttribute("courseTitleList", sectionBiz.findAllCourseTitle());   //查询所有已经添加的课程
        m.addAttribute("staffList", sectionBiz.findAllStaff());   //查询所有任课老师（数据库只插了一个）
        m.addAttribute("termList", TermContainer.getTermList());  //所有学期
        return "/admin/college/section_add";   //跳转开设新课程的界面
    }

    @RequiresRoles("admin")
    @RequestMapping("section_timetable_add.view")
    public String sectionTimetableAdd(Model m) {
        return "/admin/college/section_timetable_add"; //跳转添加时段界面
    }

    @RequiresRoles("admin")
    @RequestMapping("add")
    public String add(Section section, HttpSession session) {
        sectionBiz.add(section);
        return "redirect:section.view";    //开设新课程后跳转课程安排界面
    }

    @RequiresRoles("admin")
    @RequestMapping("addTimetable")
    public String addTimetable(Timetable timetable) {
        sectionBiz.addTimetable(timetable);
        return "redirect:section.view";   //添加课程时段后跳转课程安排界面
    }

    @RequiresRoles("admin")
    @RequestMapping("delete")
    public String delete(int secId) {
        sectionBiz.delete(secId);
        return "redirect:section.view";
    }
}
