import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import util.UserModel;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

@WebServlet("/auth-user")
public class UserAuth extends HttpServlet {
    private Connection connection;
    @Override
    public void init(ServletConfig config) throws ServletException {
        connection = DbUtil.getConnection();
        System.out.println("DB CONNECTION AVAILABLE");
    }
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("uname");
        String userPassword = req.getParameter("upass");
        boolean flag = false;
        UserModel model = new UserModel();
        try {
            String query = "SELECT * FROM USERAUTH WHERE email=? AND password=?";
            PreparedStatement pstmt = connection.prepareStatement(query);
                pstmt.setString(1, userName);
                pstmt.setString(2, userPassword);
            ResultSet rs = pstmt.executeQuery();
            flag = rs.next();
            if(flag) {
                model.setId(rs.getInt("id"));
                model.setName(rs.getString("name"));
                model.setEmail(rs.getString("email"));
                model.setCity(rs.getString("city"));
                model.setContact(rs.getString("contact"));
            }
            pstmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if(flag) {
            // 1. Create Session
            HttpSession session = req.getSession();
            // 2. set User Info inside session
            session.setAttribute("userinfo", model);
            // 3. Redirect to home.jsp Page
            resp.sendRedirect("home.jsp");
        } else {
            resp.sendRedirect("login.jsp?msg=100");
        }
    }
}
