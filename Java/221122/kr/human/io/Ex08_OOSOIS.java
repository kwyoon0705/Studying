package kr.human.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Ex08_OOSOIS {
	// ObjectOutputStream : 객체를 저장한다.
	// ObjectInputStream : 객체를 읽기한다.
	public static void main(String[] args) {
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("data6.dat"));){
			oos.writeObject(new Date()); // 시간 저장
			System.out.println("data6.dat 저장완료!!!");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			Thread.sleep(2000); // 2초동안 잠시 대기
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		
		try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("data6.dat"));){
			Date date1 = (Date) ois.readObject();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			System.out.println("저장 시간 : " + sdf.format(date1));
			System.out.println("읽기 시간 : " + sdf.format(new Date()));
			
			System.out.println("data6.dat 읽기완료!!!");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}
}
