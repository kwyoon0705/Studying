package kr.human.exam;

import java.util.StringTokenizer;

public class Ex02_StringTokenizer {
	public static void main(String[] args) {
		String str1 = "한놈 두식이 석삼 너구리 오징어";
		String str2 = "한놈,두식이,석삼,너구리,오징어";
		String str3 = "한놈,두식이.석삼-너구리/오징어";
		String str4 = "사과=100,배=400,딸기=600,감=300";

		StringTokenizer st1 = new StringTokenizer(str1);
		System.out.println(st1.countTokens() + "개");
		while (st1.hasMoreTokens()) {
			System.out.println(st1.nextToken());
		}
		System.out.println("=====================================");

		StringTokenizer st2 = new StringTokenizer(str2, ",");
		System.out.println(st2.countTokens() + "개");
		while (st2.hasMoreElements()) {
			System.out.println(st2.nextElement());
		}
		System.out.println("=====================================");

		StringTokenizer st3 = new StringTokenizer(str3, ",.-/"); // 정규표현식을 사용할 수 없으므로 ,/ 이런식으로 연달아 쓰면 구분할 수 없다.
		System.out.println(st3.countTokens() + "개");
		while (st3.hasMoreTokens()) {
			System.out.println(st3.nextToken());
		}
		System.out.println("=====================================");

		StringTokenizer st4 = new StringTokenizer(str4, ",=");
		System.out.println(st4.countTokens() + "개");
		while (st4.hasMoreTokens()) {
			System.out.println(st4.nextToken());
		}
		System.out.println("=====================================");

		StringTokenizer st5 = new StringTokenizer(str4, ",=", true);
		// 세번째 인수로 true를 지정하면 구분자도 토큰으로 불러온다.
		while (st5.hasMoreTokens()) {
			System.out.println(st5.nextToken());
		}
		System.out.println("=====================================");

		StringTokenizer st6 = new StringTokenizer(str4, ",=", true);
		while (st6.hasMoreTokens()) {
			String token = st6.nextToken();
			if (token.equals("=")) // token도 string이므로 equals를 사용한다
				System.out.print("(");
			else if (token.equals(","))
				System.out.println("원)");
			else
				System.out.print(token);
		}
		System.out.println("원)");
		System.out.println("=====================================");

	}
}
