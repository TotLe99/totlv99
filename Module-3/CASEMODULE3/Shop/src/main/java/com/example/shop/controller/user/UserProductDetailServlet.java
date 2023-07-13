package com.example.shop.controller.user;

import com.example.shop.DAO.view.ViewShoeDAO;
import com.example.shop.model.Account;
import com.example.shop.model.view.ViewShoe;
import com.example.shop.model.view.ViewShoeDetail;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "userproductdetail", value = "/user/productdetail")
public class UserProductDetailServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ViewShoeDAO viewShoeDAO = new ViewShoeDAO();

    public void init() {
        viewShoeDAO = new ViewShoeDAO();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Account account = (Account) session.getAttribute("account");
        request.setAttribute("account", account);

        int id = Integer.parseInt(request.getParameter("id"));
        ViewShoe viewShoe = viewShoeDAO.selectViewShoeById(id);
        request.setAttribute("viewShoe", viewShoe);

        RequestDispatcher dispatcher = request.getRequestDispatcher("/user/userproductdetail.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        ViewShoe viewShoe = viewShoeDAO.selectViewShoeById(id);
        request.setAttribute("viewShoe", viewShoe);
        String code = request.getParameter("code");

        int size = Integer.parseInt(request.getParameter("size"));
        int quantity_buy = Integer.parseInt(request.getParameter("quantity_buy"));
        ViewShoeDetail viewShoeDetail = new ViewShoeDetail(viewShoe.getId(), viewShoe.getName(),
                viewShoe.getPrice(), viewShoe.getUrl(),code, size, quantity_buy);
        HttpSession session = request.getSession();
        List<ViewShoeDetail> viewShoeDetailList = (List<ViewShoeDetail>) session.getAttribute("viewShoeDetailList");
        viewShoeDetailList.add(viewShoeDetail);
        response.sendRedirect("/user/product");
    }
}
