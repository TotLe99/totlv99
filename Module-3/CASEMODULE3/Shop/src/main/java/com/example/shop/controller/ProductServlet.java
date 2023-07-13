package com.example.shop.controller;

import com.example.shop.DAO.account.AccountDAO;
import com.example.shop.DAO.view.ViewShoeDAO;
import com.example.shop.model.Image;
import com.example.shop.model.Shoe;
import com.example.shop.model.view.ViewShoe;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "product", value = "/product")
public class ProductServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ViewShoeDAO viewShoeDAO = new ViewShoeDAO();

    public void init() {
        viewShoeDAO = new ViewShoeDAO();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<ViewShoe> viewShoeList = viewShoeDAO.selectAllShoe();
        request.setAttribute("viewShoeList", viewShoeList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("product.jsp");
        dispatcher.forward(request, response);
    }
}
