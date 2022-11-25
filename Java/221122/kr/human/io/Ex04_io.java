package kr.human.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Ex04_io {
	public static void main(String[] args) {
		// 1. try에서 열기를 수행하면 자동닫기가 된다.(JDK 1.7이상 지원)
		try(
				OutputStream os= new FileOutputStream("test3.dat");
				InputStream is= new FileInputStream("test3.dat");
			) {
			// 2. 사용
			// String을 byte배열로 변환
			byte[] data = "정말재미없는 자바!!!!".getBytes();
			os.write(data);
			byte[] readData = new byte[data.length];
			int n=0;
			// read(byte배열) : 배열 크기 만큼씩 읽는다.
			while((n=is.read(readData))>0) {
				// byte배열을 String으로 변환
				System.out.print(new String(readData, 0, n));
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
