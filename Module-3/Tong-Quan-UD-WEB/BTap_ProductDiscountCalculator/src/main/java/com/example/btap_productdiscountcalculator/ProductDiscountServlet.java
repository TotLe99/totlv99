package com.example.btap_productdiscountcalculator;

import java.io.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "ProductDiscountServlet", value = "/calculator")
public class ProductDiscountServlet extends HttpServlet {
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        String product = request.getParameter("product");
        double price = Double.parseDouble(request.getParameter("price"));
        double discount = Double.parseDouble(request.getParameter("discount"));
        double amount = price * discount * 0.01;
        double discountPrice = price - amount;

        PrintWriter writer = response.getWriter();
        writer.println("<html>");
        writer.println("<h1>" + product + "</h1>");
        writer.println("<p>Lượng chiết khấu: " + amount + "</p>");
        writer.println("<p>Giá sau CK: " + discountPrice + "</p>");
        writer.println("</html>");
    }

}