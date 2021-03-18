package JIn.java.exam04;

import java.sql.*;

import JIn.java.common.ConnUtil;

public class JdbcEx8 {
	public static void main(String[] args) {
		StringBuffer sql1 = new StringBuffer();
		sql1.append("insert into department ");
		sql1.append("values(?,?,?,?)");
		StringBuffer sql2 = new StringBuffer();
		sql2.append("update department ");
		sql2.append("set dname = ?, loc = ? ");
		sql2.append("where deptno = ?");
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = ConnUtil.getConnection();
			con.setAutoCommit(false);

			pstmt = con.prepareStatement(sql1.toString());
			pstmt.setInt(1, 255);
			pstmt.setString(2, "핵물리학과");
			pstmt.setInt(3, 200);
			pstmt.setString(4, "9호관");
			pstmt.executeUpdate();

			pstmt = con.prepareStatement(sql2.toString());
			pstmt.setString(1, "생명공학과");
			pstmt.setString(2, "8호관");
			pstmt.setInt(3, 255);
			pstmt.executeUpdate();

			con.commit();
			System.out.println("DB에 반영됨!");
		} catch (SQLException e) {
			try {
				con.rollback();
				System.out.println("DB에 반영이 취소됨!");
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
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
