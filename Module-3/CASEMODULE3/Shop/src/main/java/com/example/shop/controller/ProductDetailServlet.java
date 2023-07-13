package com.example.shop.controller;

import com.example.shop.DAO.view.ViewShoeDAO;
import com.example.shop.model.view.ViewShoe;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "productdetail", value = "/productdetail")
public class ProductDetailServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ViewShoeDAO viewShoeDAO = new ViewShoeDAO();

    public void init() {
        viewShoeDAO = new ViewShoeDAO();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        ViewShoe viewShoe = viewShoeDAO.selectViewShoeById(id);
        request.setAttribute("viewShoe", viewShoe);
        RequestDispatcher dispatcher = request.getRequestDispatcher("productdetail.jsp");
        dispatcher.forward(request, response);
    }
}
