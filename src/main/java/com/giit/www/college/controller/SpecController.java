package com.giit.www.college.controller;

import com.giit.www.college.service.SpecBiz;
import com.giit.www.entity.Spec;
import org.apache.ibatis.annotations.Param;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;

/**
 * 专业控制器
 * @author Nocol
 *
 */
@Controller
@RequestMapping("spec.do")
public class SpecController {

    @Resource(name = "specBizImpl")
    SpecBiz specBiz;

    @RequiresRoles("admin")
    @RequestMapping("spec_add.view")
    public String specAddView(Model m) {
        m.addAttribute("deptNameList", specBiz.findDpet());  //将所有学院带到下拉框
        return "/admin/college/spec_add";    //跳转增加专业界面
    }

    @RequiresRoles("admin")
    @RequestMapping("spec.view")
    public String specView(Model m) {
        m.addAttribute("deptAndSpec", specBiz.findDeptAndSpec());
        return "/admin/college/spec";
    }
    
    @RequiresRoles("admin")
    @RequestMapping("spec_update.view")
    public ModelAndView specUpdateView(@Param("specName") String specName) throws Exception {
        specName=new String(specName .getBytes("iso8859-1"),"utf-8");
        ModelAndView modelAndView=new ModelAndView("/admin/college/spec_update");
        modelAndView.addObject("specName",specName);
        return modelAndView;  //跳转修改专业界面
    }
    
    @RequiresRoles("admin")
    @RequestMapping("update")
    public String update(@Param("specName") String specName, @Param("newSpecName") String newSpecName) throws Exception {
        specName = new String(specName .getBytes("iso8859-1"),"utf-8");
        newSpecName = new String(newSpecName .getBytes("iso8859-1"),"utf-8");
        specBiz.update(specName, newSpecName);
        return "redirect:/spec.do/spec.view";
    }
    
    @RequiresRoles("admin")
    @RequestMapping("add")
    public String add(Spec spec) {
        System.out.println("添加的专业---"+spec);
        specBiz.add(spec);
        return "redirect:/spec.do/spec.view";
    }
    
    @RequiresRoles("admin")
    @RequestMapping("delete")
    public String delete(String specName)throws  Exception {
        specName = new String(specName .getBytes("iso8859-1"),"utf-8");
        specBiz.delete(specName);
        return "redirect:/spec.do/spec.view";
    }

}

