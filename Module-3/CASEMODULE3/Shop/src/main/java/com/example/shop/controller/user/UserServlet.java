package com.example.shop.controller.user;

import com.example.shop.model.Account;
import com.example.shop.model.view.ViewShoeDetail;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "user", value = "/user")
public class UserServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Account account = (Account) session.getAttribute("account");
        request.setAttribute("account", account);
        List<ViewShoeDetail> viewShoeDetailList = new ArrayList<>();
        session.setAttribute("viewShoeDetailList", viewShoeDetailList);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/user/user.jsp");
        dispatcher.forward(request, response);
    }
}
