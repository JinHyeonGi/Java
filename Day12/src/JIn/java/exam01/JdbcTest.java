package JIn.java.exam01;

import java.sql.*;
import java.util.Scanner;

public class JdbcTest {
	public static void main(String[] args) {
		try {	// 드라이버 검색
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 검색 성공");
		} catch (ClassNotFoundException e) {
			System.err.println("드라이버 검색 실패");
			System.exit(0);
		}
		Connection conn = null;	// 연결 변수 선언 및 초기화
		try {	// 데이터베이스 연결
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/XEPDB1", "mytest", "mytest");
			System.out.println("데이터베이스 연결 성공");
		} catch (SQLException sqle) {	// 연결 실패시 바로 종료
			System.err.println("데이터베이스 연결 실패");
			System.exit(0);
		}
		// 각종 변수 선언 및 초기화
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			/* 정적쿼리
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from mytable");
			*/
			
			/* 동적쿼리  */
			// 나이를 입력 받아서 ? 부분에 대입해 조건에 맞는 정보를 가져온다
			System.out.print("나이 = ");
			Scanner scan = new Scanner(System.in);
			int intage = scan.nextInt();
			pstmt = conn.prepareStatement("select * from mytable where age > ?");	// 쿼리문을 pstmt에 저장
			pstmt.setInt(1, intage);	// 쿼리문에 ? 부분에 대입할 값을 설정
			rs = pstmt.executeQuery();	// 쿼리문에 의해 가져온 값을 rs에 대입
			
			while(rs.next()) {	// rs에 에러가 나면 반복문 중단
				int num = rs.getInt(1);
				String name = rs.getString(2);
				int age = rs.getInt("age");
				String address = rs.getString("address");
				if(address == null) address = " ";
				java.sql.Date date = rs.getDate("birth");
				java.util.Date d = new java.util.Date(date.getTime());
				System.out.println(num + "\t" + name + "\t" + age + "\t" + address + "\t" + 
						date.toString() + "\t" + d.toString() + "\t");
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
			System.err.println("쿼리문 오류");

		} finally {
			try {
				if (rs != null)
					rs.close();
			} catch (SQLException sqle) {
			}
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException sqle) {
			}
			try {
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException sqle) {
			}
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException sqle) {
			}

		}
	}
}
