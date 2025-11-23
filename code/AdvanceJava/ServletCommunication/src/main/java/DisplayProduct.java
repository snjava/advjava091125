import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/display-prod")
public class DisplayProduct extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        String name = req.getParameter("pname");
        String qty = req.getParameter("quantity");
        String price = req.getParameter("price");
        int quantity = Integer.parseInt(qty);
        double prodPrice = Double.parseDouble(price);
        double totalPrice = quantity * prodPrice;
        out.print("<h1>Product Name : "+name+"</h1>");
        out.print("<h2> Total Price : " + totalPrice +" </h2>");
    }
}