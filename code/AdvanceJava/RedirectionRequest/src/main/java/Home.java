import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/home")
public class Home extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        String user = req.getParameter("uname");
        UserInfo info =(UserInfo) req.getAttribute("addtionalInfo");
        out.print("<h1>Welcome User</h1>");
        out.print("<h1>User : "+user+"</h1>");
        out.print("<h2>Email : "+info.getEmail()+"</h2>");
        out.print("<h2>Contact : "+info.getContact()+"</h2>");
    }
}
