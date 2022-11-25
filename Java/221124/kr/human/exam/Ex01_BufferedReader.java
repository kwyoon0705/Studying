package kr.human.exam;

import java.io.BufferedReader;

import java.io.IOException;
import java.io.InputStreamReader;

public class Ex01_BufferedReader {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		// System의 in은 InputStream이므로 InputStreamReader로 읽어주고 다시 BufferedReader로 읽어준다.

		String line = br.readLine();

		String ar[] = line.split(" ");
		int a = Integer.parseInt(ar[0]);
		int b = Integer.parseInt(ar[1]);
		int c = Integer.parseInt(ar[2]);
		
		System.out.println(a*b*c);
		
	}
}
