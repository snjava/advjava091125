import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/user-info")
public class UserInfo extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.print("<form action='display-info'>");
            out.print("Enter Name : <input type='text' name='username'>");
            out.print("<br/><br/>");
        out.print("Select Gender : <input type='radio' name='gender' value='M'>Male");
        out.print("<input type='radio' name='gender' value='F'>Female");
        out.print("<br/><br/>");
        out.print("<button type='submit'>Send</button>");
        out.print("</form>");
    }
}
