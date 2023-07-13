package com.example.shop.filter.author;

import com.example.shop.model.Account;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter({"/admin", "/admin/*"})
public class AuthorAdmin extends HttpFilter {
    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpSession session = req.getSession();
        Account account = (Account) session.getAttribute("account");
        if (account != null) {
            if (account.getRole().equals("ADMIN")) {
                chain.doFilter(req, res);
            } else {
                res.sendRedirect("/403.jsp");
            }
        }
    }
}