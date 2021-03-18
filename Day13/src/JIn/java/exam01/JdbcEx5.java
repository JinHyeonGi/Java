package JIn.java.exam01;

import java.sql.*;

import JIn.java.common.ConnUtil;

public class JdbcEx5 {
	public static void main(String[] args) {
		StringBuffer sql = new StringBuffer();
		sql.append("insert into professor ");
		sql.append("values(?, ?, ?, ?, ?, sysdate, ?, ?)");
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ConnUtil.getConnection();
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1,  9920);
			pstmt.setString(2,  "홍길동");
			pstmt.setString(3,  "gildong");
			pstmt.setString(4,  "전임교수");
			pstmt.setInt(5,  450);
			pstmt.setInt(6,  40);
			pstmt.setInt(7,  203);
			int i = pstmt.executeUpdate();
			System.out.println(i + " 개의 행이 추가되었습니다.");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null)
					pstmt.close();
			} catch(SQLException e) {}
			try {
				if(con != null)
					con.close();
			} catch(SQLException e) {}
		}
	}
}
