import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

@WebServlet("/save-data")
public class SaveInfo extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String contact = req.getParameter("contact");
        String city = req.getParameter("city");
        String pincode = req.getParameter("pin");
        String state = req.getParameter("state");
        boolean flag = false;
        try {
            String driver = "com.mysql.cj.jdbc.Driver";
            String url = "jdbc:mysql://localhost:3306/advjava0911";
            String userName = "root";
            String password = "root";
            String query = "INSERT INTO userinfo VALUES(?,?,?,?,?,?)";
            Class.forName(driver);
            Connection con = DriverManager.getConnection(url, userName, password);
            PreparedStatement stmt = con.prepareStatement(query);
                stmt.setString(1, name);
                stmt.setString(2, email);
                stmt.setString(3, contact);
                stmt.setString(4, city);
                stmt.setString(5, pincode);
                stmt.setString(6, state);
            int count = stmt.executeUpdate();
            flag = count > 0;
            con.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        if(flag) {
            resp.sendRedirect("PersonalInfo.jsp?msg=success");
        } else {
            resp.sendRedirect("PersonalInfo.jsp?msg=error");
        }
    }
}
