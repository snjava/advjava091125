import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class SelectQuery {
	public static void main(String[] args) {
		try {
			
			Scanner scan = new Scanner(System.in);
			System.out.println("Enter City : ");
			String city = scan.next();
			
			String mysqlDriver = "com.mysql.cj.jdbc.Driver"; 
			String mysqlUrl = "jdbc:mysql://localhost:3306/advjava0911";
			String username = "root";
			String password = "root";
			String selectSql = "select * from employee";
			String groupBySql = "select city, count(*) AS total FROM employee group by city;";
			String selectByCity = "select * from employee WHERE city = ?";
			Class.forName(mysqlDriver);
			Connection con = 
					DriverManager.getConnection(mysqlUrl, username, password);
			PreparedStatement stmt = con.prepareStatement(selectByCity);
			stmt.setString(1, city);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getInt("eid"));
				System.out.println(rs.getString("name"));
				System.out.println(rs.getString("city"));
				//System.out.println(rs.getString("total"));
				System.out.println("--------------------------------");
			}
			con.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
