package com.example.shop.controller;

import com.example.shop.DAO.product.ImageDAO;
import com.example.shop.DAO.product.ShoeDAO;

import com.example.shop.model.Account;
import com.example.shop.model.Image;
import com.example.shop.model.Shoe;

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

@WebServlet(name = "index", value = "/index")
public class IndexServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ShoeDAO shoeDAO = new ShoeDAO();
    private ImageDAO imageDAO = new ImageDAO();

    public void init() {
        shoeDAO = new ShoeDAO();
        imageDAO = new ImageDAO();
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Shoe> shoeList = shoeDAO.selectAllShoe();
        request.setAttribute("shoeList", shoeList);
        List<Image> imageList = new ArrayList<>();
        for (Shoe shoe : shoeList) {
            imageList.add(imageDAO.selectImage(shoe.getImage_id()));
        }
        Account account = null;
        HttpSession session = request.getSession();
        session.setAttribute("account", account);
        request.setAttribute("imageList", imageList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }
}
