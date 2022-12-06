package kr.human.jdbc;

import java.io.FileReader;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import kr.human.vo.HanjaVO2;

public class DBConnectionEx04 {
	public static void main(String[] args) {
		// 1. 변수를 준비
		Connection conn = null; // 연결객체변수
		PreparedStatement stmt = null; // 명령객체변수
		ResultSet rs = null; // 결과객체변수

		try {
			conn = JDBCUtil.getConnection("hanja2");
			System.out.println("Connection Success : " + conn);
			conn.setAutoCommit(false); // 자동 커밋 취소
			// ***********************************************
			// 데이터를 읽기 : 일단 chunja2.json을 읽자.
			Gson gson = new GsonBuilder().setPrettyPrinting().create();
			List<HanjaVO2> hanjaList = gson.fromJson(new FileReader("src/main/resources/chunja2.json"),
					new TypeToken<List<HanjaVO2>>() {
					}.getType());
			// 테이블 생성 : 생성하면 생성코드를 주석처리하여 다시 실행되지 못하게 한다.
			/*String sql = "create table chunja2(idx int primary key, h varchar(20), k varchar(20)"+ ", m varchar(50), t varchar(1000))";
			conn.createStatement().executeUpdate(sql); // 테이블 생성*/
			// db 테이블에 데이터 삽입 : 데이터를 삽입했다면 코드를 주석처리하여 다시 실행되지 못하게 한다.
			/*for (HanjaVO2 vo : hanjaList) {
				String sql = "insert into chunja2 values(?,?,?,?,?)";
				stmt = conn.prepareStatement(sql);
				stmt.setInt(1, vo.getIndex());
				stmt.setString(2, vo.getH());
				stmt.setString(3, vo.getK());
				stmt.setString(4, vo.getM());
				stmt.setString(5, vo.getT());
				stmt.executeUpdate();
				conn.commit();
			}*/
			// 데이터 조회
			rs = conn.createStatement().executeQuery("select * from chunja2");
			if (rs.next()) {
				do {
					System.out.println(rs.getString("h") + "(" + rs.getString("k") + ") : " + rs.getString("t"));
				} while (rs.next());
			} else
				System.out.println("Nothing");
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
