package controller;

import model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.StudentService;

@Controller
public class StudentController {
    @Autowired
    StudentService studentService;

    @GetMapping("/students")
    public String showStudent(Model model) {
        model.addAttribute("student", studentService.getStudents());
        return "showStudent";
    }

    @GetMapping("/editStudent")
    public String editStudent(int id, Model model) {
        model.addAttribute("student", studentService.findByID(id));
        return "editStudent";
    }

    @PostMapping("/editStudent")
    public String editStudent(Student student) {
        studentService.editStudent(student.getId(), student);
        return "redirect:/students";
    }

    @GetMapping("/deleteStudent")
    public String deleteStudent(int id, Model model) {
        model.addAttribute("student", studentService.deleteStudent(id));
        return "/showStudent";
    }

    @GetMapping("/createStudent")
    public String createStudent() {
        return "createStudent";
    }

    @PostMapping("/createStudent")
    public String createStudent(@RequestParam String name, String img) {
        studentService.createStudent(name,img);
        return "redirect:/students";
    }
}
