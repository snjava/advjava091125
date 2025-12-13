import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/auth-user")
public class UserAuth extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("uname");
        String userPassword = req.getParameter("upass");
        if("Admin".equals(userName) && "admin@123".equals(userPassword)) {
            // 1. Create Session
            HttpSession session = req.getSession();
            // 2. set User Name inside session
            session.setAttribute("name", userName);
            // 3. Redirect to home.jsp Page
            resp.sendRedirect("home.jsp");
        } else {
            resp.sendRedirect("login.jsp?msg=invalid");
        }
    }
}
