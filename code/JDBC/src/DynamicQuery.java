import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class DynamicQuery {
	public static void main(String[] args) {
		try {
			
			Scanner scan = new Scanner(System.in);
			System.out.println("Enter Employee Id : ");
			int empId = scan.nextInt();
			System.out.println("Enter Employee Name : ");
			String empName = scan.next();
			System.out.println("Enter Employee City : ");
			String empCity = scan.next();
			
			
			String oracleDriver = "oracle.jdbc.driver.OracleDriver";
			String mysqlDriver = "com.mysql.cj.jdbc.Driver"; 
			String oraclelUrl ="jdbc:oracle:thin:@localhost:1521:xe";
			String mysqlUrl = "jdbc:mysql://localhost:3306/advjava0911";
			String username = "root";
			String password = "root";
			String insertSql = "INSERT INTO employee VALUES(?,?,?)";
			String deleteSql = "DELETE FROM employee where eid=?";
			String updateSql = "UPDATE employee SET city=? where eid=?";
			String dropTable = "DROP TABLE stud";
			Class.forName(mysqlDriver);
			Connection con = 
					DriverManager.getConnection(mysqlUrl, username, password);
			PreparedStatement stmt = con.prepareStatement(updateSql);
			
			stmt.setString(1, empCity);
			stmt.setInt(2, empId);
			int count = stmt.executeUpdate();
			con.close();
			System.out.println(count + " : Rows Affected...");
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
}






