package com.example.shop.controller.admin.product;

import com.example.shop.DAO.product.ColorDAO;
import com.example.shop.model.Color;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "color", value = "/admin/color")
public class ColorServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ColorDAO colorDAO = new ColorDAO();

    public void init() {
        colorDAO = new ColorDAO();
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
                    insertColor(request, response);
                    break;
                case "edit":
                    updateColor(request, response);
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
                    deleteColor(request, response);
                    break;
                default:
                    listColor(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listColor(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Color> listColor = colorDAO.selectAllColor();
        request.setAttribute("listColor", listColor);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/color.jsp");
        dispatcher.forward(request, response);
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Color> listColor = colorDAO.selectAllColor();
        request.setAttribute("listColor", listColor);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/colorcreate.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Color findColor = colorDAO.selectColor(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/coloredit.jsp");
        request.setAttribute("color", findColor);
        dispatcher.forward(request, response);
    }

    private void insertColor(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String code = request.getParameter("code");
        Color newColor = new Color(code);
        colorDAO.insertColor(newColor);
        response.sendRedirect("/admin/color");
    }

    private void updateColor(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        String code = request.getParameter("code");
        Color color = new Color(id, code);
        colorDAO.updateColor(color);
        response.sendRedirect("/admin/color");
    }

    private void deleteColor(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        colorDAO.deleteColor(id);

        List<Color> listColor = colorDAO.selectAllColor();
        request.setAttribute("listColor", listColor);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/color.jsp");
        dispatcher.forward(request, response);
    }
}
