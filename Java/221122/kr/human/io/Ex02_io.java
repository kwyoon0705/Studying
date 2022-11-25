package kr.human.io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Ex02_io {
	public static void main(String[] args) {
		// 1. try에서 열기를 수행하면 자동닫기가 된다.(JDK 1.7이상 지원)
		try(OutputStream os= new FileOutputStream("test2.dat");) {
			// 2. 사용
			os.write(new byte[] {1,2,3,4,5,6,7,8,9,10});
			os.write(65);
			os.write(97);
			System.out.println("저장 완료!!!");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
