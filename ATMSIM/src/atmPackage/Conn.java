package atmPackage;
import java.sql.*;

public class Conn {
	public Connection c;
	public Statement s;
	static String databaseName = "mydb";
	static String url = "jdbc:mysql://localhost:3306/" + databaseName;
	
	static String username = "root";
	static String password = "root";
	
	
	public Conn() throws SQLException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			c = DriverManager.getConnection(url,username,password);
			s = c.createStatement();
		}
		catch (Exception ex){
			System.out.println(ex);
		}
	}
}
