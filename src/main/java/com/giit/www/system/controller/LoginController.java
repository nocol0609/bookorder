package com.giit.www.system.controller;

import com.giit.www.entity.User;
import com.giit.www.system.service.UserBiz;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

        Logger logger= LoggerFactory.getLogger(LoginController.class.getName());

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
        //System.out.println(subject.getPrincipal());
        boolean isAuthenticated = subject.isAuthenticated();

        System.out.println("当前用户是否通过认证："+isAuthenticated);
        
        if (isAuthenticated) {
        	//获取用户名
            String principal = (String) subject.getPrincipal();
            session.setAttribute("username", principal);

            User user=userBiz.findById(principal);
            String roleId=String.valueOf(user.getRoleIds().get(0));
            switch (roleId) {
                case "1":
                    return "/admin/main"; //返回管理员主页
                case "3":
                    return "/teacher/main"; //返回教师主页
                case "2":
                    return "/student/main"; //返回学生主页
                case "4":
                    return "/supplier/main"; //经controller返回供应商主页
            }
        }

        return "redirect:login.jsp";
    }


}
