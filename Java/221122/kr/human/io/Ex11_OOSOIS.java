package kr.human.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import kr.human.vo.MyData;

public class Ex11_OOSOIS {
	// ObjectOutputStream : 객체를 저장한다.
	// ObjectInputStream : 객체를 읽기한다.
	
	// 내가 만든 객체를 읽거나 저장을 하려면 반드시 구현해 주어야 하는 인터페이스가 존재한다.
	// 직렬화 : 객체를 스트림으로 만든는 과정
	// 역직렬화 : 스트림을 객체로 만드는 과정
	// Serializable 인터페이스는 직렬화/역직렬화가 가능하게 하는 표시 인터페이스이다.
	public static void main(String[] args) {
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("data8.dat"));){
			MyData vo = (MyData) ois.readObject(); // 객체 읽기
			System.out.println(vo);
			System.out.println("data8.dat 읽기완료!!!");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
}
