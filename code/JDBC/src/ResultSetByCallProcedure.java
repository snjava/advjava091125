import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Types;
import java.util.Scanner;


public class ResultSetByCallProcedure {
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter City : ");
		String city = scan.next();
		
		String mysqlDriver = "com.mysql.cj.jdbc.Driver";
		String mysqlUrl = "jdbc:mysql://localhost:3306/advjava0911";
		String username = "root";
		String password = "root";
		try {
			Class.forName(mysqlDriver);
			Connection con = DriverManager.getConnection(mysqlUrl, username, password);
			CallableStatement stmt = 
					con.prepareCall("{CALL getEmpByCity(?)}");
			stmt.setString(1, city);
			boolean flag = stmt.execute();
			//ResultSet rs = stmt.executeQuery();
			ResultSet rs = stmt.getResultSet();
			while(rs.next()) {
				System.out.println("Id : " + rs.getInt("eid"));
				System.out.println("Name : " + rs.getString("name"));
				System.out.println("-------------------");
			}
			con.close();
			
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}
}
