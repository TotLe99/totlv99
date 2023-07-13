package com.codegym.service;

import com.codegym.model.Account;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AccountService {
    List<Account> accounts;

    public AccountService() {
       accounts = new ArrayList<>();
       accounts.add(new Account("1", "1", "https://www.freeiconspng.com/thumbs/account-icon/account-profile-icon-1.png", "1999-03-29"));
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public int findIndexByID(int id) {
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getId() == id) {
                return i;
            }
        }
        return -99;
    }

    public Account findAccountByID(int id) {
        for (Account account : accounts) {
            if (account.getId() == id) {
                return account;
            }
        }
        return null;
    }

    public void createAccount(Account account) {
        accounts.add(account);
    }

    public void editAccount(int id, Account account) {
        accounts.set(findIndexByID(id), account);
    }

    public void deleteAccount(int id) {
        accounts.remove(findAccountByID(id));
    }
}
