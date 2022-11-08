package kr.human.exception;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Ex005 {
	public static void main(String[] args) {
		FileInputStream fis = null;
		try {
			// 2. 열기
			fis = new FileInputStream("src/kr/human/bank1/Account.java");
			// 3. 사용
			int n = 0;
			while ((n = fis.read()) > 0) {
				System.out.print((char) n);
			}
			// fis.close(); 여기서 닫아버리면 위에서 예외발생시 바로 catch 블럭으로 가므로
			// DB접속이 종료되지 않는다.
		} catch (FileNotFoundException e) {
			System.out.println(e.getMessage());
			System.out.println("읽으려는 파일이 없습니다.");
			// e.printStackTrace();
		} catch (IOException e) {
			System.out.println("읽기 실패");
			// e.printStackTrace();
		} finally {
			// 4.닫기
			try {
				if (fis != null)
					fis.close();
			} catch (IOException e) {
				System.out.println("닫기 실패!");
				// e.printStackTrace();
			}
		}

	}
}
