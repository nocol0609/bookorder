package com.giit.www.college.controller;

import com.giit.www.college.service.DeptBiz;
import com.giit.www.entity.Dept;
import org.apache.ibatis.annotations.Param;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.List;

/**
 * 学院控制器
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
        List<Dept> deptList= deptBiz.findAll();
        m.addAttribute("deptList", deptList);
        return "/admin/college/dept";
    }

    @RequiresRoles("admin")
    @RequestMapping("dept_add.view")
    public String deptAddView(Model m) {
        return "/admin/college/dept_add";    //跳转增加界面
    }

    @RequiresRoles("admin")
    @RequestMapping("dept_update.view")
    public ModelAndView deptUpdateView(@Param("deptId") String deptId,@Param("deptName") String deptName) throws Exception {
        deptName = new String(deptName .getBytes("iso8859-1"),"utf-8");
        ModelAndView modelAndView=new ModelAndView("/admin/college/dept_update");
        modelAndView.addObject("deptId",deptId);
        modelAndView.addObject("deptName",deptName);
        return modelAndView;  //跳转修改界面
    }

    @RequiresRoles("admin")
    @RequestMapping("add")
    public String add(String deptName) {
        deptBiz.add(deptName);
        return "redirect:/dept.do/dept.view";  //增加学院后经controler返回系部管理页面
    }

    @RequiresRoles("admin")
    @RequestMapping("update")
    public String update(@Param("deptId") String deptId, @Param("deptName") String deptName) throws Exception {
        deptName = new String(deptName .getBytes("iso8859-1"),"utf-8");
        deptBiz.update(deptId,deptName);
        return "redirect:/dept.do/dept.view";  //修改学院后经controler返回系部管理页面
    }

    @RequiresRoles("admin")
    @RequestMapping("delete")
    public String delete(int deptId) {
        deptBiz.delete(deptId);
        return "redirect:/dept.do/dept.view";  //删除系后经controler返回系部管理页面
    }


}
