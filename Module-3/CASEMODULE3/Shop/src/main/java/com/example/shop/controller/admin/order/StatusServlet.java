package com.example.shop.controller.admin.order;

import com.example.shop.DAO.order.StatusDAO;
import com.example.shop.model.Status;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "status", value = "/admin/status")
public class StatusServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private StatusDAO statusDAO = new StatusDAO();

    public void init() {
        statusDAO = new StatusDAO();
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
                    insertStatus(request, response);
                    break;
                case "edit":
                    updateStatus(request, response);
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
                    deleteStatus(request, response);
                    break;
                default:
                    listStatus(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listStatus(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Status> statusList = statusDAO.selectAllStatus();
        request.setAttribute("statusList", statusList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/status.jsp");
        dispatcher.forward(request, response);
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Status> statusList = statusDAO.selectAllStatus();
        request.setAttribute("statusList", statusList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/statuscreate.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Status status = statusDAO.selectStatus(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/statusedit.jsp");
        request.setAttribute("status", status);
        dispatcher.forward(request, response);
    }

    private void insertStatus(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String st = request.getParameter("status");
        Status status = new Status(st);
        statusDAO.insertStatus(status);
        response.sendRedirect("/admin/status");
    }

    private void updateStatus(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        String st = request.getParameter("status");

        Status status = new Status(id, st);
        statusDAO.updateStatus(status);
        response.sendRedirect("/admin/status");
    }

    private void deleteStatus(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        statusDAO.deleteStatus(id);

        List<Status> statusList= statusDAO.selectAllStatus();
        request.setAttribute("statusList", statusList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/status.jsp");
        dispatcher.forward(request, response);
    }
}
