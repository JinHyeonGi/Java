package JIn.java.exam02;

import java.sql.*;

public class JdbcEx1 {
	public static void main(String[] args) {
		Connection con = null;	// 연결 변수 선언 및 초기화
		Statement stmt = null;	//
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");	// 드라이버 검색
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/XEPDB1", "mytest", "mytest");	// 데이터베이스 연결
			stmt = con.createStatement();	// 데이터베이스로 SQL문을 보내기 위한 작업
			StringBuffer sql = new StringBuffer();	// 문자열을 추가하거나 변경할 때 사용하는 작업
			// SQL문 작성
			sql.append("insert into department ");
			sql.append("values (203, '제어계측공학과',200, '7호관')");
			int result = stmt.executeUpdate(sql.toString());	// SELECT문 이외의 문을 사용할 때 쓰게 되는 구문
			System.out.println(result + " 개의 행이 추가되었습니다");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
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
