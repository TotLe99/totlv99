package servlet;

import manager.StudentManager;
import model.Student;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet("/edit")
public class EditServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        Student student = findById(id);
        req.setAttribute("student", student);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/edit.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        LocalDate dateOfBirth = LocalDate.parse(req.getParameter("dateofbirth"));
        String email = req.getParameter("email");
        String address = req.getParameter("address");
        String phone = req.getParameter("phone");
        Student student = findById(id);
        if (student != null) {
            student.setName(name);
            student.setDateOfBirth(dateOfBirth);
            student.setEmail(email);
            student.setAddress(address);
            student.setPhone(phone);
        }
        resp.sendRedirect("/index");
    }

    public Student findById(int id){
        for (Student student: StudentManager.students) {
            if (student.getId() == id) {
                return student;
            }
        }
        return null;
    }
}
