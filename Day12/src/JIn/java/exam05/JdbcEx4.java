package JIn.java.exam05;

import java.sql.*;

public class JdbcEx4 {
	public static void main(String[] ar) { // select 예제
		StringBuffer sql = new StringBuffer();
		sql.append("select deptno, dname, college, loc");
		sql.append(" from department ");
		Connection con = null;
		Statement stmt = null;
		// select쿼리의 수행결과집합과 결과집합에서 데이타를
		// 추출할 수 있는 메소드를 가지고 있는 객체
		ResultSet rs = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// thin Type jdbc 드라이버 :
			// 자체 네트웤 protocol가지고 있는 jdbc 드라이버...
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/XEPDB1", "mytest", "mytest");

			stmt = con.createStatement();
			// 실행하고자하는 sql이 select 쿼리인 경우
			// 쿼리실행의 결과집합를 리턴 받을 수 있는
			// executeQueryO를 사용한다.
			rs = stmt.executeQuery(sql.toString());
			// resultset객체로부터 데이타 추출하기
			// resultset의 next()메소드는 커서를 다음행으로 이동시킴
			// 이동된 위치에 row가 존재하면 true, 존재하지 않으면
			// false를 반환한다.
			// rs.next()가 참인 동안, 즉 결과집합에 행이 존재하는 동안
			// ResultSet으로부터 데이타 추출....
			while (rs.next()) {
				// 커서가 위치한 row의 각각의 column에서 값 추출하기
				// resultset의 getXXX(컬럼위치)，getXXX(컬럼이름)
				// 을 사용해서 column의 값 추출
				int i = rs.getInt(1); // rs.getlnt("deptno1*)；
				String s1 = rs.getString(2);
				int j = rs.getInt("college");
				String s2 = rs.getString("loc");
				System.out.println(i + "\t" + s1 + "\t" + j + "\t" + s2);
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
			}
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