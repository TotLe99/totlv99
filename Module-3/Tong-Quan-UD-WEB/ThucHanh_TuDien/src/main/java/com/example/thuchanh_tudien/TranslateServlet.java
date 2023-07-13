package com.example.thuchanh_tudien;
import java.io.*;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "TranslateServlet", value = "/translate")
public class TranslateServlet  extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        Map<String, String> dictionary = new HashMap<>();
        dictionary.put("hello", "xin chao");
        dictionary.put("what", "cai gi");
        dictionary.put("how", "the nao");
        dictionary.put("book", "quyen sach");

        String search = request.getParameter("txt");
        PrintWriter writer = response.getWriter();
        writer.println("<html>");

        String result = dictionary.get(search);
        if (result != null){
            writer.println("Word: " + search);
            writer.println("Result: " + result);
        } else {
            writer.println("Not found");
        }

        writer.println("</html>");
    }
    
}