package JIn.java.exam05;

import java.io.*;
import java.sql.*;

import JIn.java.common.ConnUtil;

public class JdbcEx9 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("SQL 입력: ");
		String sql = br.readLine();
		Connection con = ConnUtil.getConnection();
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		ResultSetMetaData rsmd = rs.getMetaData();
		System.out.println("컬럼의 갯수: " + rsmd.getColumnCount());
		
		for(int i = 1; i <= rsmd.getColumnCount(); i++) {
			System.out.println(rsmd.getColumnName(i) + "\t");
		}
		System.out.println();
		for(int i = 1; i <= rsmd.getColumnCount(); i++) {
			System.out.println(rsmd.getColumnTypeName(i) + "\t");
		}
		System.out.println();
		
		int 컬럼갯수 = rsmd.getColumnCount();
		while(rs.next()) {
			for(int 컬럼번호 = 1; 컬럼번호 <= 컬럼갯수; 컬럼번호++) {
				int 컬럼타입 = rsmd.getColumnType(컬럼번호);
				switch(컬럼타입) {
				case Types.NUMERIC:
					System.out.println(rs.getInt(컬럼번호) + "\t");
					break;
				case Types.VARCHAR:
					System.out.println(rs.getInt(컬럼번호) + "\t");
					break;
				case Types.DATE:
					System.out.println(rs.getInt(컬럼번호) + "\t");
					break;
				}
			}
			System.out.println();
		}
		br.close();	rs.close();	pstmt.close();	con.close();	
	}
}
