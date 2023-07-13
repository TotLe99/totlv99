package com.example.shop.controller.admin.product;

import com.example.shop.DAO.product.ShoeDAO;
import com.example.shop.model.Shoe;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "shoe", value = "/admin/shoe")
public class ShoeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ShoeDAO shoeDAO = new ShoeDAO();

    public void init() {
        shoeDAO = new ShoeDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    insertShoe(request, response);
                    break;
                case "edit":
                    updateShoe(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    showCreateForm(request, response);
                    break;
                case "edit":
                    showEditForm(request, response);
                    break;
                case "delete":
                    deleteShoe(request, response);
                    break;
                default:
                    listShoe(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listShoe(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Shoe> shoeList = shoeDAO.selectAllShoe();
        request.setAttribute("shoeList", shoeList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/shoe.jsp");
        dispatcher.forward(request, response);
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Shoe> shoeList = shoeDAO.selectAllShoe();
        request.setAttribute("shoeList", shoeList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/shoecreate.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Shoe shoe = shoeDAO.selectShoe(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/shoeedit.jsp");
        request.setAttribute("shoe", shoe);
        dispatcher.forward(request, response);
    }

    private void insertShoe(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int image_id = Integer.parseInt(request.getParameter("image_id"));
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        String time = request.getParameter("time");
        float price = Float.parseFloat(request.getParameter("price"));

        Shoe shoe = new Shoe(image_id,name,description,time,price);
        shoeDAO.insertShoe(shoe);
        response.sendRedirect("/admin/shoe");
    }

    private void updateShoe(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        int image_id = Integer.parseInt(request.getParameter("image_id"));
        String name = request.getParameter("name");
        String description = request.getParameter("description");
        String time = request.getParameter("time");
        float price = Float.parseFloat(request.getParameter("price"));

        Shoe shoe = new Shoe(id,image_id,name,description,time, price);
        shoeDAO.updateShoe(shoe);
        response.sendRedirect("/admin/shoe");
    }

    private void deleteShoe(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        shoeDAO.deleteShoe(id);

        List<Shoe> shoeList = shoeDAO.selectAllShoe();
        request.setAttribute("shoeList", shoeList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/shoe.jsp");
        dispatcher.forward(request, response);
    }
}
