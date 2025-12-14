import java.sql.Connection;
import java.sql.DriverManager;

public final class DbUtil {
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String URL = "jdbc:mysql://localhost:3306/advjava0911";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
    public static final Connection getConnection() {
        Connection con = null;
        try {
            Class.forName(DRIVER);
            con = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch(Exception ex) {
            ex.printStackTrace();
        }
        return con;
    }

}
