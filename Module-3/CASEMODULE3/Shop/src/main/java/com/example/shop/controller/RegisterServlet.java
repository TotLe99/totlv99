package com.example.shop.controller;

import com.example.shop.DAO.account.AccountDAO;
import com.example.shop.model.Account;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(name = "register", value = "/register")
public class RegisterServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private AccountDAO accountDAO = new AccountDAO();

    public void init() {
        accountDAO = new AccountDAO();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("register.jsp");
        dispatcher.forward(request, response);
    }
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String gender = request.getParameter("gender");
        String birthday = request.getParameter("birthday");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        Account account = new Account(name, gender, birthday, phone, address, email, password, "USER");
        try {
            accountDAO.insertAccount(account);
        } catch (Exception e) {
            e.printStackTrace();
        }
        response.sendRedirect("/login");
    }
}
