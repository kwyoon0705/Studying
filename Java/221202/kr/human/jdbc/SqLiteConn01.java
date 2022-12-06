package kr.human.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
//SqLite는 개인용 dbms이므로 드라이버도 필요없고 계정과 패스워드 전부 필요없다.
public class SqLiteConn01 {
	public static void main(String[] args) {
		String serverIP = "127.0.0.1";
		String port = "3306";
		String dbName = "classicmodels";
		String driverClass = "";
		// jdbc:mariadb:서버ip:포트번호/DB명
		//String url = "jdbc:sqlite:sample.db";
		// String url = "jdbc:mariadb://" + serverIP + ":" + port + "/" + dbName;
		String user = "";
		String password = "";
		// 1. 변수를 준비
		Connection conn = null; // 연결객체변수
		Statement stmt = null; // 명령객체변수
		ResultSet rs = null; // 결과객체변수
		try {
			// 2. 드라이버 클래스를 로드
			// Class.forName(driverClass);
			// 3. 연결한다.
			conn = DriverManager.getConnection("jdbc:sqlite:sample.db");
			System.out.println("Connection Success : " + conn);
			// 4. 사용한다.
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// 5.닫기 : 여는 순서와 반대로 닫아준다.
			try {
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (stmt != null)
					stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			try {
				if (conn != null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
