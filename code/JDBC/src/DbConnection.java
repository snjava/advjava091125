import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 * URL : 
 * 	Protocol: jdbc:mysql (oracle-jdbc:oracle)
 *  Host(IP/DNS): localhost
 *  Port: 3306 (oracle-1521/1522)
 *  resource/service: advjava0911 (oracle-xe)
 *	Mysql URL: jdbc:mysql://localhost:3306/advjava0911
 *  Oracle URL: jdbc:oracle:thin:@localhost:1521:xe
 */

public class DbConnection {
	public static void main(String[] args) {
		try {
			String oracleDriver = "oracle.jdbc.driver.OracleDriver";
			String mysqlDriver = "com.mysql.cj.jdbc.Driver"; 
			String oraclelUrl ="jdbc:oracle:thin:@localhost:1521:xe";
			String mysqlUrl = "jdbc:mysql://localhost:3306/advjava0911";
			String username = "root";
			String password = "root";
			//1. Register Driver	
			Class.forName(mysqlDriver);
			// 2. Create Connection
			Connection con = 
					DriverManager.getConnection(mysqlUrl,username,password);
			
			con.setAutoCommit(false);
			
			//3. Create statement (Statement, PreparedStatement, CallableStatement)
			PreparedStatement insertStmt = con.prepareStatement("INSERT INTO employee values(6, 'Y', 'Mumbai')");
			//PreparedStatement stmt = con.prepareStatement("UPDATE employee SET city ='Delhi' WHERE eid=3");
			PreparedStatement deleteStmt = con.prepareStatement("DELETE FROM employee WHERE eid=3");
			
			//4. Execute Statement (execute():boolean, executeUpdate():int, executeQuery():ResultSet)
			int insertCount = insertStmt.executeUpdate();
			int deleteCount = deleteStmt.executeUpdate();
			
			System.out.println(insertCount + " : Rows inserted...");
			System.out.println(deleteCount + " : Rows Deleted...");

			if(deleteCount>0) {
				con.commit();
			} else {
				con.rollback();
			}
			//5. close connection
			con.close();
			
			
			
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
}
