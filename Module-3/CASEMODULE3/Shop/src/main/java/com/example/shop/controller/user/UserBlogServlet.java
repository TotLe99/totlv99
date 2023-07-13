package com.example.shop.controller.user;

import com.example.shop.model.Account;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "userblog", value = "/user/blog")
public class UserBlogServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Account account = (Account) session.getAttribute("account");
        request.setAttribute("account", account);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/user/userblog.jsp");
        dispatcher.forward(request, response);
    }
}
