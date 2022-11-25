package kr.human.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import kr.human.vo.PersonVO;

public class Ex09_OOSOIS {
	// ObjectOutputStream : 객체를 저장한다.
	// ObjectInputStream : 객체를 읽기한다.
	
	// 내가 만든 객체를 읽거나 저장을 하려면 반드시 구현해 주어야 하는 인터페이스가 존재한다.
	// 직렬화 : 객체를 스트림으로 만든는 과정
	// 역직렬화 : 스트림을 객체로 만드는 과정
	// Serializable 인터페이스는 직렬화/역직렬화가 가능하게 하는 표시 인터페이스이다.
	public static void main(String[] args) {
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("data7.dat"));){
			oos.writeObject(new PersonVO("한사람",22,true)); // 내가 만든객체 저장
			System.out.println("data7.dat 저장완료!!!");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("data7.dat"));){
			PersonVO vo = (PersonVO) ois.readObject(); // 객체 읽기
			System.out.println(vo);
			System.out.println("data7.dat 읽기완료!!!");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
}
