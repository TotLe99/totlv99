package com.example.service;

import com.example.dao.AccountDAO;
import com.example.dao.RoleDAO;
import com.example.model.Account;
import com.example.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
public class AccountService {
    @Autowired
    AccountDAO accountDAO;
    @Autowired
    RoleDAO roleDAO;

    public Account findAccountByID(int idAccount) {
        return accountDAO.findByID(idAccount);
    }

    public void save(Account account, int idRole, MultipartFile multipartFile) {
        String avatar = multipartFile.getOriginalFilename();
        try {
            multipartFile.transferTo(new File("C:\\Users\\Admin\\Desktop\\Learn-in-Codegym\\Module-4\\CSDL-Account\\src\\main\\webapp\\img\\" + avatar));
        } catch (IOException e) {
            e.printStackTrace();
        }
        account.setAvatar("/img/" + avatar);
        Role role = roleDAO.findByID(idRole);
        account.setRole(role);
        accountDAO.save(account);
    }

    public void edit(Account account, int idRole, MultipartFile multipartFile) {
        if (!multipartFile.isEmpty()) {
            String avatar = multipartFile.getOriginalFilename();
            try {
                multipartFile.transferTo(new File("C:\\Users\\Admin\\Desktop\\Learn-in-Codegym\\Module-4\\CSDL-Account\\src\\main\\webapp\\img\\" + avatar));
            } catch (IOException e) {
                e.printStackTrace();
            }
            account.setAvatar("/img/" + avatar);
        }
        Role role = roleDAO.findByID(idRole);
        account.setRole(role);
        accountDAO.edit(account);
    }

    public void delete(int id) {
        Account account = accountDAO.findByID(id);
        accountDAO.delete(account);
    }

    public List<Account> getAll() {
        return accountDAO.getAll();
    }
}
