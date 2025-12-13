import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/result")
public class Result extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userQuery = req.getParameter("query");
        userQuery = userQuery.replace(" ","_");
        Cookie cookie = new Cookie("usersearch1",userQuery);
        Cookie cookie1 = new Cookie("testcookie","THIS_IS_NON_PERSISTED_COOKIE");
        cookie.setMaxAge(7*24*60*60); // presisted cookie
        resp.addCookie(cookie);
        resp.addCookie(cookie1);
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.print("<h1>Your Search For "+userQuery+" </h1>");
    }
}
