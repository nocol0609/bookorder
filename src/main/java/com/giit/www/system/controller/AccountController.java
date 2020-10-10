package com.giit.www.system.controller;

import com.giit.www.system.service.AccountBiz;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * 
 * @author Nocol
 *
 */
@Controller

@RequestMapping("account.do")
public class AccountController {
    @Resource(name = "accountBizImpl")
    private AccountBiz accountBiz;

    @RequestMapping("profile.view")
    public String profileView() {
        return "/admin/system/account/profile";
    }

    @RequestMapping("update")
    public String update(HttpSession session, String password) {
        String userId = (String) session.getAttribute("username");
        accountBiz.updatePassword(userId, password);
        return "redirect:/logout";
    }
}
