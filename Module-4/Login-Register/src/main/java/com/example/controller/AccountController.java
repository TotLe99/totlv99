package com.example.controller;

import com.example.dao.RoleDAO;
import com.example.model.Account;
import com.example.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AccountController {
    @Autowired
    AccountService accountService;

    @GetMapping("/accounts")
    public ModelAndView showAccounts() {
        ModelAndView modelAndView = new ModelAndView("accounts");
        modelAndView.addObject("accounts", accountService.getAccounts());
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreate() {
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("account", new Account());
        return modelAndView;
    }

    @PostMapping("/create")
    public String create(Account account, int idRole) {
        accountService.save(account, idRole);
        return "redirect:/accounts";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEdit(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("edit");
        modelAndView.addObject("account", accountService.findAccountByID(id));
        return modelAndView;
    }

    @PostMapping("/edit/{id}")
    public String edit(Account account, int idRole) {
        accountService.edit(account, idRole);
        return "redirect:/accounts";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        accountService.delete(id);
        return "redirect:/accounts";
    }

    @GetMapping("/register")
    public ModelAndView showRegister() {
        ModelAndView modelAndView = new ModelAndView("register");
        modelAndView.addObject("account", new Account());
        return modelAndView;
    }

    @PostMapping("/register")
    public String register(int idRole, Account account) {
        accountService.save(account, idRole);
        return "checkRegister";
    }

    @GetMapping("/login")
    public ModelAndView showLogin() {
        ModelAndView modelAndView = new ModelAndView("/login.html");
        return modelAndView;
    }

    @PostMapping("/login")
    public String login(String username, String password) {
        if (accountService.checkLoginAdmin(username, password)) {
            return "redirect:/accounts";
        } else if (accountService.checkLoginUser(username,password)) {
            return "home";
        } else {
            return "redirect:/login";
        }
    }


}
