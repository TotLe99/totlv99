package com.example.servlet;

import com.example.manager.EmployeeManager;
import com.example.model.Employee;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteE")
public class DeleteServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        for (int i = 0; i < EmployeeManager.employees.size(); i++) {
            if (EmployeeManager.employees.get(i).getId() == id) {
                EmployeeManager.employees.remove(i);
            }
        }
        resp.sendRedirect("/home");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }
}
