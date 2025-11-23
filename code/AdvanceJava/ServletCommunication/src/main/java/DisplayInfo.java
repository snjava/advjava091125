import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/display-info")
public class DisplayInfo extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        String name = req.getParameter("username");
        String gender = req.getParameter("gender");

        String prefix = "M".equals(gender) ? "MR. " : "MS. ";

        out.print("<h1>Welcome User </h1>");
        out.print("<h2>" + prefix + name +" </h2>");
    }
}
