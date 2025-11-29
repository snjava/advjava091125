import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/loging")
public class Login extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.print("<form method='GET' action='auth'>");
        out.print("Enter User Name : <input type='text' name='uname'>");
        out.print("<br/><br/>");
        out.print("Enter Password  : <input type='password' name='upass'>");
        out.print("<br/><br/>");
        out.print("<button type='submit'>Login</button>");
        out.print("</form>");
    }
}
