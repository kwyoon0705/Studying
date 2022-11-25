package kr.human.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class Ex03_io {
	public static void main(String[] args) {
		// 1. try에서 열기를 수행하면 자동닫기가 된다.(JDK 1.7이상 지원)
		try(InputStream is= new FileInputStream("test1.dat");) {
			// 2. 사용
			int n=0;
			while((n=is.read())>0) {
				System.out.println(n + " : " + (char)n);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
