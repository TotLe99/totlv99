package servlet;

import dao.ClassDAO;
import dao.StudentDAO;
import manager.StudentManager;
import model.Class;
import model.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet("/create")
public class CreateServlet extends HttpServlet {
    StudentDAO studentDAO = new StudentDAO();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("/create.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        LocalDate dateOfBirth = LocalDate.parse(req.getParameter("dateofbirth"));
        String email = req.getParameter("email");
        String address = req.getParameter("address");
        String phone = req.getParameter("phone");
        StudentManager.students.add(new Student(id, name, dateOfBirth, email, address, phone));
//        studentDAO.save(new Student(0, name, dateOfBirth, email, address, phone));
        resp.sendRedirect("/index");
    }
}
