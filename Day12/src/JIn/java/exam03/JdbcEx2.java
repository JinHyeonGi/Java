package JIn.java.exam03;

import java.sql.*;

public class JdbcEx2 { // update예제
	public static void main(String[] ar) {
		StringBuffer sql = new StringBuffer();
		sql.append("update department ");
		sql.append("set dname = '전자계산학과' ");
		sql.append("where deptno = 203 ");
		Connection con = null;
		Statement stmt = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/XEPDB1", "mytest", "mytest");

			stmt = con.createStatement();
//update문은 executeUpdate()를 사용한다.
			int i = stmt.executeUpdate(sql.toString());
			System.out.println(i + " 개의 행이 변경되었습니다.");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
//Connection, Statement 자원반납처리...
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException e) {
			}
			try {
				if (con != null)
					con.close();
			} catch (SQLException e) {
			}
		}
	}
}
