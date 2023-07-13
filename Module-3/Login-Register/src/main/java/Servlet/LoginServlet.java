package Servlet;

import manager.Manager;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String user = req.getParameter("user");
        String password = req.getParameter("password");

        boolean check = false;
        for (int i = 0; i < Manager.logins.size(); i++) {
            if ((user.equals(Manager.logins.get(i).getUser()) || user.equals(Manager.logins.get(i).getEmail()))
                    && password.equals(Manager.logins.get(i).getPassword())) {
                resp.sendRedirect("/checkLogin.jsp");
                check = true;
                break;
            }
        }
        if (!check) {
            resp.sendRedirect("/login.jsp");
        }
    }
}
