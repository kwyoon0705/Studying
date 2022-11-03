package kr.human.app;

import kr.human.bank1.MinusAccount;

public class BankEx03 {
	public static void main(String[] args) {
		MinusAccount acc1 = new MinusAccount("111-1111", "이몽룡", 2500000, "9410-0000-1111-0820", 1000000);
		System.out.println(acc1);
		
		
		//잔액 이상의 금액을 인출해보자.

		try {
			System.out.println(acc1.withdraw(3000000) + "원 출금");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());;
		}
		System.out.println(acc1);
		try {
			System.out.println(acc1.withdraw(1000000) + "원 출금");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());;
		}
		System.out.println(acc1);
		try {
			System.out.println(acc1.withdraw(500000) + "원 출금");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());;
		}
		System.out.println(acc1);
		
	}
}
