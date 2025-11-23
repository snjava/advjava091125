import jakarta.servlet.ServletException;
import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/firstservlet")
public class FirstServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        // To response in the Text Format
        PrintWriter out = resp.getWriter();
        // To response in the Binary Format
        //ServletOutputStream outputStream = resp.getOutputStream();
        out.print("Welcome To First Servlet Text Response ");
        out.print("<h1>Welcome To First Servlet HTML Response</h1>");
    }
}
