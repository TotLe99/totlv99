package com.example.controller;

import com.example.model.Account;
import com.example.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AccountController {
    @Autowired
    AccountService accountService;

    @GetMapping("/accounts")
    public String getAll(Model model) {
        model.addAttribute("accounts", accountService.getAll());
        return "accounts";
    }

    @GetMapping("/create")
    public ModelAndView toCreate() {
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("account", new Account());
        return modelAndView;
    }

    @PostMapping("/create")
    public String create(Account account, int idRole, @RequestParam MultipartFile multipartFile) {
        accountService.save(account, idRole, multipartFile);
        return "redirect:/accounts";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView toEdit(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("edit");
        modelAndView.addObject("account", accountService.findAccountByID(id));
        return modelAndView;
    }

    @PostMapping("/edit/{id}")
    public String edit(Account account, int idRole, @RequestParam MultipartFile multipartFile) {
        accountService.edit(account,idRole,multipartFile);
        return "redirect:/accounts";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable int id) {
        accountService.delete(id);
        return "redirect:/accounts";
    }
}
