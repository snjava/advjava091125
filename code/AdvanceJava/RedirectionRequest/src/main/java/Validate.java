import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;

@WebServlet("/auth")
public class Validate extends HttpServlet {
    HashMap<String, String> users = new HashMap<>();
    @Override
    public void init(ServletConfig config) throws ServletException {
        users.put("Admin", "admin@123");
        users.put("Abc", "abc@123");
        users.put("Xyz", "xyz@123");
    }
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("uname");
        String pass = req.getParameter("upass");
        boolean validationFlag = false;
        if(users.containsKey(name)) {
            String actualPass = users.get(name);
            if(actualPass.equals(pass)) {
                validationFlag = true;
            }
        }

        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.print("<h1>I am from validate Class</h1>");

        if(validationFlag) {
            UserInfo info = new UserInfo();
            info.setEmail("test@gmail.com");
            info.setContact("999999999999");
            // resp.sendRedirect("home");
            req.setAttribute("addtionalInfo", info);
            RequestDispatcher dis = req.getRequestDispatcher("home");
            dis.include(req, resp);
        } else {
            resp.sendRedirect("invalid");
            //resp.sendRedirect("https://www.google.com");
            //RequestDispatcher dis = req.getRequestDispatcher("invalid");
            //dis.forward(req, resp);
        }

    }
}
