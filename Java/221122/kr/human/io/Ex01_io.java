package kr.human.io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Ex01_io {
	public static void main(String[] args) {
		// 1. 준비
		OutputStream os = null;
		try {
			// 2. 열기
			os = new FileOutputStream("test1.dat");
			// 3. 사용
			os.write(new byte[] {1,2,3,4,5,6,7,8,9,10});
			os.write(65);
			os.write(97);
			System.out.println("저장 완료!!!");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 4. 닫기
			if(os!=null)
				try {
					os.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
		}
	}
}
