import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/prod-info")
public class ProductInfo extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.print("<form action='display-prod'>");
        out.print("Enter Product Name : <input type='text' name='pname'>");
        out.print("<br/><br/>");
        out.print("Enter Product Quantity : <input type='text' name='quantity'>");
        out.print("<br/><br/>");
        out.print("Enter Product Price : <input type='text' name='price'>");
        out.print("<button type='submit'>Send</button>");
        out.print("</form>");
    }
}
