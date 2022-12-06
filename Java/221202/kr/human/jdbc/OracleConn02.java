package kr.human.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OracleConn02 {
	public static void main(String[] args) {
		String serverIP = "127.0.0.1";
		String port = "1521";
		String dbName = "xe";
		String driverClass = "oracle.jdbc.OracleDriver";
		// jdbc:oracle:thin://서버ip:포트번호/DB명
		// String url = "jdbc:oracle:thin:@localhost:1521/xe";
		String url = "jdbc:oracle:thin:@" + serverIP + ":" + port + "/" + dbName;
		String user = "javauser";
		String password = "123456";
		// 1. 변수를 준비
		Connection conn = null; // 연결객체변수
		Statement stmt = null; // 명령객체변수
		ResultSet rs = null; // 결과객체변수
		try {
			// 2. 드라이버 클래스를 로드
			Class.forName(driverClass);
			// 3. 연결한다.
			conn = DriverManager.getConnection(url, user, password);
			System.out.println("Connection Success : " + conn);
			System.out.println("#######################");
			// 4. 사용한다.
			String sql = "select SYSDATE from dual";
			stmt = conn.createStatement(); //명령객체 생성
			rs = stmt.executeQuery(sql); // sql명령을 실행하여 결과를 받자.
			// sql명령의 결과가 여러 행인 경우는 executeQuery()로 실행하고 ResultSet으로 결과를 받는다.
			// sql명령의 결과가 숫자 1개일 경우는 executeUpdate()로 실행하고 int로 받는다.
			if(rs.next()) { // rs.next()를 호출하면 결과 있을 경우 다음결과로 이동하고 없으면 while문 이탈
				System.out.println("DB TIME : " + rs.getString(1));
			}else System.out.println("NO DATA");
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
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
