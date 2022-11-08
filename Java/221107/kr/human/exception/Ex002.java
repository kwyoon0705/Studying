package kr.human.exception;

import java.util.Scanner;

public class Ex002 {
	public static void main(String[] args) {
		// 가장 전통적인 예외 처리 방법은 if문을 사용하는 것이다.
		Scanner sc = new Scanner(System.in);
		boolean flag = true;
		String temp = null;
		loop1: while (flag) {
			System.out.print("첫번째 정수 입력 : ");
			temp = sc.nextLine();
			for (char c : temp.toCharArray()) {
				if (c < '0' || c > '9') {
					System.out.println("숫자만 입력하세요!!!");
					continue loop1;
				}
			}
			flag = false;
		}
		int x = Integer.parseInt(temp);
		flag = true;
		loop2: while (flag) {
			System.out.print("두번째 정수 입력 : ");
			temp = sc.nextLine(); // 문자열로 입력받는다.
			for (char c : temp.toCharArray()) {
				if (c < '0' || c > '9') { // 1글자라도 0~9사이가 아니면
					System.out.println("숫자만 입력하세요!!!"); // 에러 메세지 출력
					continue loop2; // 다시 입력받으러 간다.
				}
			}
			flag = false; // 모두 숫자면 반복문 탈출
		}
		int y = Integer.parseInt(temp); // 숫자로 바꾼다.

		if (y != 0) {
			int result = x / y;
			System.out.println(x + " / " + y + " = " + result);
		} else {
			System.out.println("0으로 나눌 수 없습니다.");
		}

		sc.close();
		/*
		 * 이 프로그램의 문제점 1. 나누는 수에 0을 입력하면 ArithmeticException 예외발생 2. 문자를 입력하면
		 * InputMismatchException 예외 발생
		 */
	}
}
