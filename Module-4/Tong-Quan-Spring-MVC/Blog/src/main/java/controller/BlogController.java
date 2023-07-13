package controller;

import model.Blog;
import org.omg.PortableInterceptor.ServerRequestInfo;
import org.springframework.aop.interceptor.SimpleTraceInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import service.BlogService;

import java.time.LocalDate;

@Controller
public class BlogController {
    @Autowired
    BlogService blogService;

    @GetMapping("/blogs")
    public String showBlogs(Model model) {
        model.addAttribute("blog", blogService.getBlogs());
        return "index";
    }

    @GetMapping("/create")
    public String createBlogs() {
        return "create";
    }

    @PostMapping("/create")
    public String createBlogs(String title, String img, String content) {
        blogService.createBlog(title,img,content);
        return "redirect:/blogs";
    }

    @GetMapping("/edit")
    public String editBlogs(int id, Model model) {
        model.addAttribute("blog", blogService.findByID(id));
        return "edit";
    }

    @PostMapping("/edit")
    public String editBlogs(Blog blog) {
        blogService.editBlog(blog.getId(), blog);
        return "redirect:/blogs";
    }


    @GetMapping("/delete")
    public String deleteBlogs(int id, Model model) {
        model.addAttribute("blog", blogService.deleteBlog(id));
        return "/index";
    }
}
