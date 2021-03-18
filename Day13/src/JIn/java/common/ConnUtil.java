package JIn.java.common;

import java.sql.*;

public class ConnUtil {
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracelDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	public static Connection getConnection()throws SQLException {
		return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XEPDB1", "mytest", "mytest");
	}
}
