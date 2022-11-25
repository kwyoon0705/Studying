package kr.human.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;

public class Ex05_ioCopy {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("원본 파일 입력 : ");
		String src = sc.nextLine();
		System.out.print("사본 파일 입력 : ");
		String dest = sc.nextLine();
		// 1. try에서 열기를 수행하면 자동닫기가 된다.(JDK 1.7이상 지원)
		try(
				OutputStream os= new FileOutputStream(dest);
				InputStream is= new FileInputStream(src);
			) {
			// 2. 사용
			// String을 byte배열로 변환
			byte[] data = new byte[2048];
			int n =0;
			while((n=is.read(data))>0) {
				os.write(data, 0, n);
			}
			System.out.println(src + "를 " + dest + "로 복사 완료!!!");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		sc.close();
	}
}
