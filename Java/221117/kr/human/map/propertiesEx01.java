package kr.human.map;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class propertiesEx01 {
	public static void main(String[] args) {
		// Properties는 Object,Object타입의 Map이다.
		// 주로 환경설정 파일을 다룰때 많이 사용한다.
		Properties properties = new Properties();
		properties.setProperty("url", "jdbc:mariadb://localhost:3306/mydb");
		properties.setProperty("driverClass", "org.mariadb.jdbc.Driver");
		properties.setProperty("user", "hr");
		properties.setProperty("password", "123456");

		System.out.println(properties);

		// 파일로 저장
		try {
			properties.store(new FileWriter("mariadb.properties"), "MariaDB 연결 설정 파일");
			properties.storeToXML(new FileOutputStream("mariadb.xml"), "MariaDB 연결 설정 파일");
		} catch (IOException e) {
			e.printStackTrace();
		}
		// 파일에서 읽기
		try {
			Properties prop1 = new Properties();
			prop1.load(new FileReader("mariadb.properties"));
			System.out.println(prop1);

			Properties prop2 = new Properties();
			prop2.loadFromXML(new FileInputStream("mariadb.xml"));
			System.out.println(prop2);
			System.out.println("DB 연결 문자 : " + prop2.getProperty("url"));
			System.out.println("DB 사용자 : " + prop2.getProperty("user"));
			System.out.println("DB 비밀번호 : " + prop2.getProperty("password"));
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
