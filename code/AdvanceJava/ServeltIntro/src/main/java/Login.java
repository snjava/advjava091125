import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
@WebServlet("/user-login")
public class Login extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.print("<h1> User Login </h1>");
        out.print("<form>");
        out.print("Enter User name : <input type='text' name='uname'><br/><br/>");
        out.print("Enter User Password : <input type='password' name='upass'><br/><br/>");
        out.print("<button type='submit'>Login</button>");
        out.print("</form>");

    }
}
