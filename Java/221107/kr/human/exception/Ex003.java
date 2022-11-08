package kr.human.exception;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Ex003 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try { // 예외가 발생할 소지가 있는 코드는 try로 감싼다.
			System.out.println("첫번째 정수 입력 : ");
			int x = sc.nextInt();
			System.out.println("두번째 정수 입력 : ");
			int y = sc.nextInt();
			int result1 = x / y;
			double result2 = (double) x / (double) y;
			System.out.println(x + " / " + y + " = " + result1);
			System.out.println(x + " / " + y + " = " + result2);
			// 예외가 발생할 모든 경우에 대하여 catch block으로 감싼다.
		} catch (InputMismatchException e) {
			System.out.println("숫자만 입력 가능합니다");
		} catch (ArithmeticException e) {
			System.out.println("0으로는 나눌 수 없습니다.");
		} catch (Exception e) { // Exception은 모든 다른 예외의 부모이므로 가장 아래에 사용해줘야
								// 중복 적용으로 인한 에러를 막을 수 있다.
			System.out.println("알 수 없는 예외입니다.");
		} finally { // 예외의 발생 여부와 상관없이 반드시 실행해야 하는 코드는 여기에 쓴다.
		}
		sc.close();
		// JAVA에서 예외처리는 NECESSARY이다. 반드시 해야함 필수.
	}
}