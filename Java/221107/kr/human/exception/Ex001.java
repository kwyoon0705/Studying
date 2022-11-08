package kr.human.exception;

import java.util.Scanner;

public class Ex001 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("첫번째 정수 입력 : ");
		int x = sc.nextInt();
		System.out.println("두번째 정수 입력 : ");
		int y = sc.nextInt();
		int result1 = x / y;
		double result2 = (double) x / (double) y;
		System.out.println(x + " / " + y + " = " + result1);
		System.out.println(x + " / " + y + " = " + result2);

		sc.close();
		//잘만든..것 같지만 잘만든게 아니다.
		//입력값에 숫자가 아닌 문자를 넣으면 InputMismatchException 예외 발생
		// 나누는 수에 0을 넣으면 ArithmeticException 예외 발생
	} 
}