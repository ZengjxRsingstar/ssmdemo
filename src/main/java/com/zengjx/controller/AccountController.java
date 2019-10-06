package com.zengjx.controller;

import com.zengjx.domain.Account;
import com.zengjx.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * 帐户
 */
@Controller
@RequestMapping("/account")
public class AccountController {
   private  final    static   String   SUCCESS="success";
  @Autowired
    private AccountService accountService;

    /**
     * 查询所有
     * @return
     */
 @RequestMapping("/findAll")
    public String findAll(Model  model) {
        System.out.println("表现层：查询所有账户...");
        List<Account> list = accountService.findAll();
        for (Account account : list) {
            System.out.println(account);
        }

        model.addAttribute("list",list);
        return "success";
    }

    /**
     * 保存
     * @return
     */
   @RequestMapping("/save")
    public String saveAccount( Model   model,  Account account) {
   System.out.println("表现层：保存账户...");
        accountService.saveAccount(account);
        // 重定向
      //  return "redirect:/account/findAll";
       //请求转发
       return "forward:/account/findAll";
    }

}