package com.example.shop.controller.admin.order;

import com.example.shop.DAO.order.OrderDAO;
import com.example.shop.model.Order;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "order", value = "/admin/order")
public class OrderServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private OrderDAO orderDAO = new OrderDAO();

    public void init() {
        orderDAO = new OrderDAO();
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
                    insertOrder(request, response);
                    break;
                case "edit":
                    updateOrder(request, response);
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
                    deleteOrder(request, response);
                    break;
                default:
                    listOrder(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listOrder(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Order> orderList = orderDAO.selectAllOrder();
        request.setAttribute("orderList", orderList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/order.jsp");
        dispatcher.forward(request, response);
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Order> orderList = orderDAO.selectAllOrder();
        request.setAttribute("orderList", orderList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/ordercreate.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Order order = orderDAO.selectOrder(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/orderedit.jsp");
        request.setAttribute("order", order);
        dispatcher.forward(request, response);
    }

    private void insertOrder(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int user_id = Integer.parseInt(request.getParameter("user_id"));
        String date = request.getParameter("date");
        float total_amount = Float.parseFloat(request.getParameter("total_amount"));
        int status_id = Integer.parseInt(request.getParameter("status_id"));
        Order order = new Order(user_id,date,total_amount,status_id);
        orderDAO.insertOrder(order);
        response.sendRedirect("/admin/order");
    }

    private void updateOrder(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        int user_id = Integer.parseInt(request.getParameter("user_id"));
        String date = request.getParameter("date");
        float total_amount = Float.parseFloat(request.getParameter("total_amount"));
        int status_id = Integer.parseInt(request.getParameter("status_id"));

        Order order = new Order(id, user_id, date, total_amount,status_id);
        orderDAO.updateOrder(order);
        response.sendRedirect("/admin/order");
    }

    private void deleteOrder(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        orderDAO.deleteOrder(id);

        List<Order> listOrder= orderDAO.selectAllOrder();
        request.setAttribute("listOrder", listOrder);
        response.sendRedirect("/admin/order");
    }
}
