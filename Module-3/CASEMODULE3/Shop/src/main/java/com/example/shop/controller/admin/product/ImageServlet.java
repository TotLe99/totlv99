package com.example.shop.controller.admin.product;

import com.example.shop.DAO.product.ImageDAO;
import com.example.shop.model.Image;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "image", value = "/admin/image")
public class ImageServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ImageDAO imageDAO = new ImageDAO();

    public void init() {
        imageDAO = new ImageDAO();
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
                    insertImage(request, response);
                    break;
                case "edit":
                    updateImage(request, response);
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
                    deleteImage(request, response);
                    break;
                default:
                    listImage(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listImage(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Image> imageList = imageDAO.selectAllImage();
        request.setAttribute("imageList", imageList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/image.jsp");
        dispatcher.forward(request, response);
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Image> imageList = imageDAO.selectAllImage();
        request.setAttribute("imageList", imageList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/imagecreate.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Image image = imageDAO.selectImage(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/imageedit.jsp");
        request.setAttribute("image", image);
        dispatcher.forward(request, response);
    }

    private void insertImage(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String url = request.getParameter("url");
        Image image = new Image(url);
        imageDAO.insertImage(image);
        response.sendRedirect("/admin/image");
    }

    private void updateImage(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        String url = request.getParameter("url");
        Image image = new Image(id, url);
        imageDAO.updateImage(image);
        response.sendRedirect("/admin/image");
    }

    private void deleteImage(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        imageDAO.deleteImage(id);

        List<Image> imageList = imageDAO.selectAllImage();
        request.setAttribute("imageList", imageList);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/image.jsp");
        dispatcher.forward(request, response);
    }
}
