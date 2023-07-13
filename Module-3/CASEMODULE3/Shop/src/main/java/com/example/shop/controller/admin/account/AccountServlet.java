package com.example.shop.controller.admin.account;

import com.example.shop.DAO.account.AccountDAO;
import com.example.shop.model.Account;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "account", value = "/admin/account")
public class AccountServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private AccountDAO accountDAO = new AccountDAO();

    public void init() {
        accountDAO = new AccountDAO();
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
                    insertAccount(request, response);
                    break;
                case "edit":
                    updateAccount(request, response);
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
                    deleteAccount(request, response);
                    break;
                default:
                    listAccount(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    private void listAccount(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Account> listAccount = accountDAO.selectAllAccount();
        request.setAttribute("listAccount", listAccount);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/account.jsp");
        dispatcher.forward(request, response);
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Account> listAccount = accountDAO.selectAllAccount();
        request.setAttribute("listAccount", listAccount);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/accountcreate.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Account findAccount = accountDAO.selectAccount(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/accountedit.jsp");
        request.setAttribute("account", findAccount);
        dispatcher.forward(request, response);
    }

    private void insertAccount(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        String name = request.getParameter("name");
        String gender = request.getParameter("gender");
        String birthday = request.getParameter("birthday");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        Account newAccount = new Account(name, gender, birthday, phone, address, email, password, "USER");
        accountDAO.insertAccount(newAccount);
        response.sendRedirect("/admin/account");
    }

    private void updateAccount(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String gender = request.getParameter("gender");
        String birthday = request.getParameter("birthday");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String role = request.getParameter("role");

        Account account = new Account(id, name, gender, birthday, phone, address, email, password, role);
        accountDAO.updateAccount(account);
        response.sendRedirect("/admin/account");
    }

    private void deleteAccount(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        accountDAO.deleteAccount(id);

        List<Account> listAccount = accountDAO.selectAllAccount();
        request.setAttribute("listAccount", listAccount);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/account.jsp");
        dispatcher.forward(request, response);
    }

}
