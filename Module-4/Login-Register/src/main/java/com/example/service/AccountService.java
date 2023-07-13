package com.example.service;

import com.example.dao.AccountDAO;
import com.example.dao.RoleDAO;
import com.example.model.Account;
import com.example.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {
    @Autowired
    AccountDAO accountDAO;
    @Autowired
    RoleDAO roleDAO;

    public List<Account> getAccounts() {
        return accountDAO.getAllAccount();
    }

    public Account findAccountByID(int idAccount) {
        return accountDAO.findAccountByID(idAccount);
    }

    public int findIndexAccount(int idAccount) {
        return accountDAO.findIndexAccount(idAccount);
    }

    public int findIndexRole(int idRole) {
        return roleDAO.findIndexRole(idRole);
    }

    public void save(Account account, int idRole) {
        Role role = roleDAO.findRoleByID(idRole);
        account.setRole(role);
        accountDAO.save(account);
    }

    public void edit(Account account, int idRole) {
        Role role = roleDAO.findRoleByID(idRole);
        account.setRole(role);
        accountDAO.edit(account);
    }

    public void delete(int idAccount) {
        Account account = accountDAO.findAccountByID(idAccount);
        accountDAO.delete(account);
    }

    public boolean checkLoginAdmin(String username, String password) {
        for (Account account : getAccounts()) {
            if (username.equals(account.getUsername()) && password.equals(account.getPassword()) && (account.getRole().getId() == 1)) {
                return true;
            }
        }
        return false;
    }

    public boolean checkLoginUser(String username, String password) {
        for (Account account : getAccounts()) {
            if (username.equals(account.getUsername()) && password.equals(account.getPassword()) && (account.getRole().getId() == 2)) {
                return true;
            }
        }
        return false;
    }

    public List<Role> getRoles() {
        return roleDAO.getAllRole();
    }
}
