package kr.human.jdbc;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class JDBCUtil {
	// DB에 연결해서 Connection을 리턴해주는 메소드
	public static Connection getConnection(String driverClass, String url, String user, String password) {
		Connection conn = null;
		try {
			Class.forName(driverClass);
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	public static Connection getConnection(Properties properties) {
		Connection conn = null;
		try {
			Class.forName(properties.getProperty("driverClass"));
			conn = DriverManager.getConnection(properties.getProperty("url"), properties);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

	public static Connection getConnection(String dbName) {
		String fileName = "";
		switch (dbName) {
		case "oracle":
			fileName = "src/main/resources/oracle.properties";
			break;

		case "mariadb":
			fileName = "src/main/resources/mariadb.properties";
			break;
		case "sqlite":
			fileName = "src/main/resources/sqlite.properties";
			break;
		case "hanja2":
			fileName = "src/main/resources/hanja2.properties";
			break;
		}
		Connection conn = null;
		try {
			Properties properties = new Properties();
			properties.load(new FileReader(fileName));
			Class.forName(properties.getProperty("driverClass"));
			conn = DriverManager.getConnection(properties.getProperty("url"), properties);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return conn;
	}

	// 객체 닫기
	public static void close(Connection conn) {
		try {
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void close(Statement stmt) {
		try {
			if (stmt != null)
				stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void close(ResultSet rs) {
		try {
			if (rs != null)
				rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	// 명령어를 취소시키는 메소드
	public static void rollback(Connection conn) {
		try {
			if (conn != null)
				conn.rollback();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
