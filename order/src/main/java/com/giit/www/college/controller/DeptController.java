package com.giit.www.college.controller;

import com.giit.www.college.service.DeptBiz;
import com.giit.www.entity.Dept;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

/**
 * 系控制器
 * @author Nocol
 *
 */
@Controller
@RequestMapping("dept.do")
public class DeptController {

    @Resource(name = "deptBizImpl")
    private DeptBiz deptBiz;

    @RequiresRoles("admin")
    @RequestMapping("dept.view")
    public String deptView(Model m) {
        m.addAttribute("deptList", deptBiz.findAll());
        return "/admin/college/dept";
    }

    @RequiresRoles("admin")
    @RequestMapping("dept_add.view")
    public String deptAddView(Model m) {
        return "/admin/college/dept_add";    //跳转增加界面
    }

    @RequiresRoles("admin")
    @RequestMapping("dept_update.view")
    public String deptUpdateView(Model m) {
        return "/admin/college/dept_update";  //跳转修改界面
    }

    @RequiresRoles("admin")
    @RequestMapping("add")
    public String add(String deptName) {
        deptBiz.add(deptName);
        return "redirect:/dept.do/dept.view";  //增加系后经controler返回系部管理页面
    }

    @RequiresRoles("admin")
    @RequestMapping("update")
    public String update(Dept dept) {
        deptBiz.update(dept);
        return "redirect:/dept.do/dept.view";  //修改系后经controler返回系部管理页面
    }

    @RequiresRoles("admin")
    @RequestMapping("delete")
    public String delete(int deptId) {
        deptBiz.delete(deptId);
        return "redirect:/dept.do/dept.view";  //删除系后经controler返回系部管理页面
    }


}
