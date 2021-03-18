package JIn.java.exam02;

import java.sql.*;

import JIn.java.common.ConnUtil;

public class JdbcEx6 {
	public static void main(String[] args) {
		StringBuffer sql = new StringBuffer();
		sql.append("update profeddor ");
		sql.append("set sal = ? ");
		sql.append("where name = ? ");
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con  = ConnUtil.getConnection();
			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1,  500);
			pstmt.setString(2,  "");
			int i = pstmt.executeUpdate();
			System.out.println(i + "개의 행의 변경되었습니다.");
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
