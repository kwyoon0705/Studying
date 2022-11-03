package kr.human.app;

import kr.human.bank1.CardAccount;

public class BankEx02 {
	public static void main(String[] args) {
		CardAccount acc1 = new CardAccount("101-111-11111", "박문수", 340000, "9410-0000-5555-0820");
//통장출금과 카드출금 모두 성공이다.
		try {
			System.out.println(acc1.withdraw(100000) + "원 출금");
			System.out.println(acc1.pay("9410-0000-5555-0820", 10000) + "원 출금");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			;
		}
		System.out.println(acc1);
		
		//입금
		
		acc1.deposit(400000);
		System.out.println(acc1);
		
		//통장출금 실패
		try {
			System.out.println(acc1.withdraw(1000000) + "원 출금");
			System.out.println(acc1.pay("9410-0000-5555-0820", 10000) + "원 출금");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			;
		}
		System.out.println(acc1);
		
		//카드출금 실패
		try {
			System.out.println(acc1.pay("9410-1111-5555-0820", 100000) + "원 출금");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			;
		}
		System.out.println(acc1);
	}
}
