package com.giit.www.system.controller;

import com.giit.www.system.service.UserBiz;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * 用户登录控制器
 * @author Nocol
 *
 */
@Controller
public class LoginController {

    @Resource(name = "userBizImpl")
    UserBiz userBiz;

    @RequestMapping("login")
    public String login(HttpServletRequest req, Model model, HttpSession session) {
    	
        String exceptionClassName = (String) req.getAttribute("shiroLoginFailure");
        String error = null;
        if (UnknownAccountException.class.getName().equals(exceptionClassName)) {
            error = "用户名/密码错误";
        } else if (IncorrectCredentialsException.class.getName().equals(exceptionClassName)) {
            error = "用户名/密码错误";
        } else if (exceptionClassName != null) {
            error = "其他错误：" + exceptionClassName;
        }

        //TODO 
        Subject subject = SecurityUtils.getSubject();
        boolean isAuthenticated = subject.isAuthenticated();
        
        System.out.println("当前用户是否通过认证："+isAuthenticated);
        
        if (isAuthenticated) {
        	//获取用户名
            String principal = (String) subject.getPrincipal();
            session.setAttribute("username", principal);
            
            //此处有bug,应该根据用户名查询用户RoleId,根RoleId来进行跳转
            //userBiz.findRoles()这个方法写的太麻烦了,需重写
            
            switch (principal) {
                case "admin":
                    return "/admin/main"; //返回管理员主页
                case "teacher":
                    return "/teacher/main"; //返回教师主页
                case "student":
                    return "/student/main"; //返回学生主页
                case "supplier":
                    return "redirect:supplier.do/supplier.view"; //经controller返回供应商主页
            }
        }

        return "redirect:login.jsp";
    }


}
