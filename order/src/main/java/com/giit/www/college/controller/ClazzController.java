package com.giit.www.college.controller;

import com.giit.www.college.service.ClazzBiz;
import com.giit.www.util.TermContainer;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * 班级控制器
 * @author Nocol
 *
 */
@Controller
@RequestMapping("clazz.do")
public class ClazzController {

    @Resource(name = "clazzBizImpl")
    private ClazzBiz clazzBiz;

    @RequiresRoles("admin")
    @RequestMapping("add")
    public String add(String deptName, String specName, String year) {
        clazzBiz.add(deptName, specName, year);
        return "redirect:/clazz.do/clazz.view";  //增加后返回班级管理界面
    }

    @RequiresRoles("admin")
    @RequestMapping("delete")
    public String delete(int clazzId) {
        clazzBiz.delete(clazzId);
        return "redirect:/clazz.do/clazz.view";  //删除后返回班级管理界面
    }

    @RequiresRoles("admin")
    @RequestMapping("clazz.view")
    public String findAll(Model m) {
        m.addAttribute("clazzList", clazzBiz.findAll());
        return "/admin/college/clazz";       //班级管理界面
    }

    @RequiresRoles("admin")
    @RequestMapping("clazz_add.view")
    public String findDeptAndSpec(Model m) {
        m.addAttribute("deptAndSpecJson", clazzBiz.findDeptAndSpecJson()); //将查询到的系及专业（json格式）传入下拉框
        m.addAttribute("deptNameList", clazzBiz.findDeptNameList());   //查询所有系
        m.addAttribute("termList", TermContainer.getTermList());      //通过工具类生成学期的集合带下拉框
        return "/admin/college/clazz_add";    //跳转添加班级界面
    }
}
