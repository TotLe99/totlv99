package com.codegym.controller;

import com.codegym.model.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.codegym.service.AccountService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Controller
public class AccountController {
    @Autowired
    AccountService accountService;

    @GetMapping("/account")
    public String showAccount(Model model) {
        model.addAttribute("accounts", accountService.getAccounts());
        return "account";
    }

    @GetMapping("/create")
    public String toCreateAccount() {
        return "create";
    }

    @PostMapping("/create")
    public String createAccount(Account account, @RequestParam MultipartFile multipartFile) throws IOException {
        String avatar = multipartFile.getOriginalFilename();
        multipartFile.transferTo(new File("C:\\Users\\Admin\\Desktop\\Learn-in-Codegym\\Module-4\\Quan-Ly-Account\\src\\main\\webapp\\img\\" + avatar));
        account.setAvatar("/img/" + avatar);
        accountService.createAccount(account);
        return "redirect:/account";
    }

    @GetMapping("/edit/{id}")
    public String toEditAccount(@PathVariable int id, Model model) {
        model.addAttribute("account", accountService.findAccountByID(id));
        return "edit";
    }

    @PostMapping("/edit/{id}")
    public String editAccount(@PathVariable int id, Account account, @RequestParam MultipartFile multipartFile) throws IOException {
        if (!multipartFile.isEmpty()) {
            String avatar = multipartFile.getOriginalFilename();
            multipartFile.transferTo(new File("C:\\Users\\Admin\\Desktop\\Learn-in-Codegym\\Module-4\\Quan-Ly-Account\\src\\main\\webapp\\img\\" + avatar));
            account.setAvatar("/img/" + avatar);
            accountService.editAccount(id, account);
        } else {
            accountService.editAccount(id, account);
        }
        return "redirect:/account";
    }

    @GetMapping("/delete/{id}")
    public String deleteAccount(@PathVariable int id) {
        accountService.deleteAccount(id);
        return "redirect:/account";
    }
}
