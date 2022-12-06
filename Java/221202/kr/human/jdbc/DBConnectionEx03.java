package kr.human.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class DBConnectionEx03 {
	public static void main(String[] args) {
		// 1. 변수를 준비
		Connection conn = null; // 연결객체변수
		Statement stmt = null; // 명령객체변수
		ResultSet rs = null; // 결과객체변수

		try {
			conn = JDBCUtil.getConnection("sqlite");
			System.out.println("Connection Success : " + conn);
			conn.setAutoCommit(false); // 자동 커밋 취소
			// ***********************************************
			String sql = "select * from bible where bookid=1 and chapter=1";
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			if (rs.next()) {
				do {
					System.out.println(rs.getString("content"));
				} while (rs.next());
			}
			/* 이 부분만 변경한다. */

			// ***********************************************
			conn.commit(); // 모든 명령이 정상적으로 수행되었다면 DB에 적용
		} catch (Exception e) {
			JDBCUtil.rollback(conn); // 에러가 발생한다면 모든 명령 취소
		} finally {
			// 닫기 : 자원 반납.
			JDBCUtil.close(rs);
			JDBCUtil.close(stmt);
			JDBCUtil.close(conn);
		}

	}
}
