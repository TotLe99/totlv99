package com.example.shop.controller.admin.product;

import com.example.shop.DAO.product.SizeDAO;
import com.example.shop.model.Size;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "size", value = "/admin/size")
public class SizeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private SizeDAO sizeDAO = new SizeDAO();

    public void init() {
        sizeDAO = new SizeDAO();
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
                    insertSize(request, response);
                    break;
                case "edit":
                    updateSize(request, response);
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
                    deleteSize(request, response);
                    break;
                default:
                    listSize(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listSize(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Size> sizeList = sizeDAO.selectAllSize();
        request.setAttribute("sizeList", sizeList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/size.jsp");
        dispatcher.forward(request, response);
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Size> sizeList = sizeDAO.selectAllSize();
        request.setAttribute("sizeList", sizeList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/sizecreate.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Size size = sizeDAO.selectSize(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/sizeedit.jsp");
        request.setAttribute("size", size);
        dispatcher.forward(request, response);
    }

    private void insertSize(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int s = Integer.parseInt(request.getParameter("size"));
        Size size = new Size(s);
        sizeDAO.insertSize(size);
        response.sendRedirect("/admin/size");
    }

    private void updateSize(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        int s = Integer.parseInt(request.getParameter("size"));
        Size size = new Size(id, s);
        sizeDAO.updateSize(size);
        response.sendRedirect("/admin/size");
    }

    private void deleteSize(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        sizeDAO.deleteSize(id);

        List<Size> sizeList = sizeDAO.selectAllSize();
        request.setAttribute("sizeList", sizeList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/size.jsp");
        dispatcher.forward(request, response);
    }
}
