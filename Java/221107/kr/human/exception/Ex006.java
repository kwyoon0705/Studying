package kr.human.exception;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.InputMismatchException;

public class Ex006 {
	public static void main(String[] args) {
		// 1. try(자원열기) : 자동닫기가 되는 파일 읽기
		try (FileInputStream fis = new FileInputStream("src/kr/human/bank1/Account.java")) {

			// 3. 사용
			int n = 0;
			while ((n = fis.read()) > 0) {
				System.out.print((char) n);
			}
			// 예외를 여러개 한번에 | 연산자로 지정 가능하다. JDK 1.7에 추가됨.
		} catch (IOException | NullPointerException | InputMismatchException e) {
			System.out.println(e.getMessage());
			System.out.println("읽으려는 파일이 없습니다.");
			// e.printStackTrace();
		}

	}
}
