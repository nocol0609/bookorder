package com.giit.www.supplier.controller;

import com.giit.www.supplier.service.SupplierBiz;
import com.giit.www.system.service.AccountBiz;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

/**
 * 
 * @author Nocol
 *
 */

@Controller

@RequestMapping("supplier.do")
public class SupplierController {

    @Resource(name = "supplierBizImpl")
    SupplierBiz supplierBiz;

    @Resource(name = "accountBizImpl")
    private AccountBiz accountBiz;

    @RequiresRoles(value = {"admin", "supplier"}, logical = Logical.OR)
    @RequestMapping("supplier.view")
    public String supplierView(Model m) {
        m.addAttribute("reviewedBookList", supplierBiz.findAllReviewedBook());
        return "/supplier/supplier";
    }

    @RequiresAuthentication
    @RequiresRoles(value = {"admin", "supplier"}, logical = Logical.OR)
    @RequestMapping("changePass_sup.view")
    public String changePass(Model m) {
        return "/supplier/changepass_sup";
    }

    @RequiresRoles(value = {"admin", "supplier"}, logical = Logical.OR)
    @RequestMapping("updatePass")
    public String update(HttpSession session, String password) {
        String userId = (String) session.getAttribute("username");
        accountBiz.updatePassword(userId, password);
        return "redirect:/logout";
    }

    @RequestMapping(value = "/exportOrderBook" ,method = RequestMethod.GET )
    public Object downOrder(){
        OrderBookExport orderBookExport=new OrderBookExport();
        orderBookExport.setSupplierBiz(supplierBiz);
        return new ModelAndView(orderBookExport);
    }
}
