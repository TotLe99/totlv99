package com.example.shop.controller.admin.product;

import com.example.shop.DAO.product.ShoeDetailDAO;
import com.example.shop.model.ShoeDetail;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "shoedetail", value = "/admin/shoedetail")
public class ShoeDetailServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ShoeDetailDAO shoeDetailDAO = new ShoeDetailDAO();

    public void init() {
        shoeDetailDAO = new ShoeDetailDAO();
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
                    insertShoeDetail(request, response);
                    break;
                case "edit":
                    updateShoeDetail(request, response);
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
                    deleteShoeDetail(request, response);
                    break;
                default:
                    listShoeDetail(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listShoeDetail(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<ShoeDetail> shoeDetailList = shoeDetailDAO.selectAllShoeDetail();
        request.setAttribute("shoeDetailList", shoeDetailList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/shoedetail.jsp");
        dispatcher.forward(request, response);
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<ShoeDetail> shoeDetailList = shoeDetailDAO.selectAllShoeDetail();
        request.setAttribute("shoeDetailList", shoeDetailList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/shoedetailcreate.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        ShoeDetail shoedetail = shoeDetailDAO.selectShoeDetail(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/shoedetailedit.jsp");
        request.setAttribute("shoedetail", shoedetail);
        dispatcher.forward(request, response);
    }

    private void insertShoeDetail(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int shoe_id = Integer.parseInt(request.getParameter("shoe_id"));
        int color_id = Integer.parseInt(request.getParameter("color_id"));
        int size_id = Integer.parseInt(request.getParameter("size_id"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        ShoeDetail shoeDetail = new ShoeDetail(shoe_id,color_id,size_id,quantity);
        shoeDetailDAO.insertShoeDetail(shoeDetail);
        response.sendRedirect("/admin/shoedetail");
    }

    private void updateShoeDetail(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        int shoe_id = Integer.parseInt(request.getParameter("shoe_id"));
        int color_id = Integer.parseInt(request.getParameter("color_id"));
        int size_id = Integer.parseInt(request.getParameter("size_id"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        ShoeDetail shoeDetail = new ShoeDetail(id,shoe_id,color_id,size_id,quantity);
        shoeDetailDAO.updateShoeDetail(shoeDetail);
        response.sendRedirect("/admin/shoedetail");
    }

    private void deleteShoeDetail(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        shoeDetailDAO.deleteShoeDetail(id);

        List<ShoeDetail> shoeDetailList = shoeDetailDAO.selectAllShoeDetail();
        request.setAttribute("shoeDetailList", shoeDetailList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/shoedetail.jsp");
        dispatcher.forward(request, response);
    }
}
