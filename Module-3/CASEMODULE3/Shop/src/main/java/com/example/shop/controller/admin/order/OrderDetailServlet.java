package com.example.shop.controller.admin.order;

import com.example.shop.DAO.order.OrderDetailDAO;
import com.example.shop.model.OrderDetail;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "orderdetail", value = "/admin/orderdetail")
public class OrderDetailServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private OrderDetailDAO orderDetailDAO = new OrderDetailDAO();

    public void init() {
        orderDetailDAO = new OrderDetailDAO();
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
                    insertOrderDetail(request, response);
                    break;
                case "edit":
                    updateOrderDetail(request, response);
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
                    deleteOrderDetail(request, response);
                    break;
                default:
                    listOrderDetail(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listOrderDetail(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<OrderDetail> orderDetailList = orderDetailDAO.selectAllOrderDetail();
        request.setAttribute("orderDetailList", orderDetailList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/orderdetail.jsp");
        dispatcher.forward(request, response);
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<OrderDetail> orderDetailList = orderDetailDAO.selectAllOrderDetail();
        request.setAttribute("orderDetailList", orderDetailList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/orderdetailcreate.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        OrderDetail orderDetail = orderDetailDAO.selectOrderDetail(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/orderdetailedit.jsp");
        request.setAttribute("orderDetail", orderDetail);
        dispatcher.forward(request, response);
    }

    private void insertOrderDetail(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int order_id = Integer.parseInt(request.getParameter("order_id"));
        int shoedetail_id = Integer.parseInt(request.getParameter("shoedetail_id"));
        int quantity_buy = Integer.parseInt(request.getParameter("quantity_buy"));
        OrderDetail orderDetail = new OrderDetail(order_id,shoedetail_id,quantity_buy);
        orderDetailDAO.insertOrderDetail(orderDetail);
        response.sendRedirect("/admin/orderdetail");
    }

    private void updateOrderDetail(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        int order_id = Integer.parseInt(request.getParameter("order_id"));
        int shoedetail_id = Integer.parseInt(request.getParameter("shoedetail_id"));
        int quantity_buy = Integer.parseInt(request.getParameter("quantity_buy"));

        OrderDetail orderDetail = new OrderDetail(id, order_id, shoedetail_id, quantity_buy);
        orderDetailDAO.updateOrderDetail(orderDetail);
        response.sendRedirect("/admin/orderdetail");
    }

    private void deleteOrderDetail(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        orderDetailDAO.deleteOrderDetail(id);

        List<OrderDetail> listOrderDetail = orderDetailDAO.selectAllOrderDetail();
        request.setAttribute("listOrderDetail", listOrderDetail);
        response.sendRedirect("/admin/orderdetail");
    }
}

