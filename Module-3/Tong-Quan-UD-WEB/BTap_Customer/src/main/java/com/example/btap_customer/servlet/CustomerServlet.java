package com.example.btap_customer.servlet;

import com.example.btap_customer.manager.CustomerManager;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/home")
public class CustomerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("customers", CustomerManager.customers);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/home.jsp");
        dispatcher.forward(req, resp);
    }
}
