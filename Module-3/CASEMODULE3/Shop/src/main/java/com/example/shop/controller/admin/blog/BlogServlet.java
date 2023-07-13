package com.example.shop.controller.admin.blog;

import com.example.shop.DAO.blog.BlogDAO;
import com.example.shop.model.Blog;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "blog", value = "/admin/blog")
public class BlogServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private BlogDAO blogDAO = new BlogDAO();

    public void init() {
        blogDAO = new BlogDAO();
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
                    insertBlog(request, response);
                    break;
                case "edit":
                    updateBlog(request, response);
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
                    deleteBlog(request, response);
                    break;
                default:
                    listBlog(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listBlog(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Blog> listBlog = blogDAO.selectAllBlog();
        request.setAttribute("listBlog", listBlog);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/blog.jsp");
        dispatcher.forward(request, response);
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Blog> listBlog = blogDAO.selectAllBlog();
        request.setAttribute("listBlog", listBlog);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/blogcreate.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Blog findBlog = blogDAO.selectBlog(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/blogedit.jsp");
        request.setAttribute("blog", findBlog);
        dispatcher.forward(request, response);
    }

    private void insertBlog(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int image_id = Integer.parseInt(request.getParameter("image_id"));
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        Blog newBlog = new Blog(image_id,title,content);
        blogDAO.insertBlog(newBlog);
        response.sendRedirect("/admin/blog");
    }

    private void updateBlog(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        int image_id = Integer.parseInt(request.getParameter("image_id"));
        String title = request.getParameter("title");
        String content = request.getParameter("content");

        Blog blog = new Blog(id, image_id, title, content);
        blogDAO.updateBlog(blog);
        response.sendRedirect("/admin/blog");
    }

    private void deleteBlog(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        blogDAO.deleteBlog(id);

        List<Blog> listBlog = blogDAO.selectAllBlog();
        request.setAttribute("listBlog", listBlog);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/blog.jsp");
        dispatcher.forward(request, response);
    }
}
