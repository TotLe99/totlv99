package com.example.shop.controller;

import com.example.shop.DAO.account.AccountDAO;
import com.example.shop.model.Account;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "login", value = "/login")
public class LoginServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private AccountDAO accountDAO = new AccountDAO();

    public void init() {
        accountDAO = new AccountDAO();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        Account account = accountDAO.selectAccount(email, password);
        if (account != null){
            HttpSession session = request.getSession();
            session.setAttribute("account", account);
            if (account.getRole().equals("ADMIN")){
                response.sendRedirect("/admin");
            }else{
                response.sendRedirect("/user");
            }
        } else {
            response.sendRedirect("/login");
        }
    }
}
