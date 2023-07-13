package com.example.servlet;

import com.example.manager.EmployeeManager;
import com.example.model.Employee;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/editE")
public class EditServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Employee employee = findById(id);
        req.setAttribute("employee", employee);
        RequestDispatcher dispatcher = req.getRequestDispatcher("editE.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String img = req.getParameter("img");
        Employee employee = findById(id);
        if (employee != null) {
            employee.setName(name);
            employee.setImg(img);
        }
        resp.sendRedirect("/home");
    }

    public Employee findById(int id){
        for (Employee employee: EmployeeManager.employees) {
            if (employee.getId() == id) {
                return employee;
            }
        }
        return null;
    }
}
