package kr.human.io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import kr.human.vo.MyData;

public class Ex10_OOSOIS {
	// ObjectOutputStream : 객체를 저장한다.
	// ObjectInputStream : 객체를 읽기한다.
	
	// 내가 만든 객체를 읽거나 저장을 하려면 반드시 구현해 주어야 하는 인터페이스가 존재한다.
	// 직렬화 : 객체를 스트림으로 만든는 과정
	// 역직렬화 : 스트림을 객체로 만드는 과정
	// Serializable 인터페이스는 직렬화/역직렬화가 가능하게 하는 표시 인터페이스이다.
	public static void main(String[] args) {
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("data8.dat"));){
			// 객체가 저장될때는 인스턴스 변수만 저장된다.
			// 메서드나 static변수는 모든 객체가 공유하는 내용이므로 저장할 이유가 없다.
			// transient 지시어가 붙은 필드도 제외된다.
			
			// 자바는 클래스를 수정할때마다 자동으로 버전 번호를 붙여준다.
			// 저장할떄의 버전번호와 읽을때 객체의 버전 번호가 다르면 읽지 못한다.
			// 이런 사태를 방지하기 위해서는 버번아이디를 일치시켜줘야만 한다.
			oos.writeObject(new MyData(11,"1234")); // 내가 만든객체 저장
			System.out.println("data8.dat 저장완료!!!");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
