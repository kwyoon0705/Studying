package kr.human.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;


public class DBConnectionEx01 {
	public static void main(String[] args) {
		// 1. 변수를 준비
		Connection conn = null; // 연결객체변수
		Statement stmt = null; // 명령객체변수
		ResultSet rs = null; // 결과객체변수
		
		conn = JDBCUtil.getConnection("oracle");
		System.out.println("Connection Success : "+ conn);
		JDBCUtil.close(rs);
		JDBCUtil.close(stmt);
		JDBCUtil.close(conn);
		
		conn = JDBCUtil.getConnection("mariadb");
		System.out.println("Connection Success : "+ conn);
		JDBCUtil.close(rs);
		JDBCUtil.close(stmt);
		JDBCUtil.close(conn);
	}
}
