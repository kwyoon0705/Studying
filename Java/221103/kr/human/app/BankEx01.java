package kr.human.app;

import kr.human.bank1.Account;

public class BankEx01 {
	public static void main(String[] args) {
		Account acc1 = new Account("111-11-01001", "이몽룡", 350000);
		Account acc2 = new Account("111-11-01002", "성춘향", 50000);

		System.out.println(acc1);
		System.out.println(acc2);

		// 이체
		try {
			acc2.deposit(acc1.withdraw(50000));
			System.out.println(acc1);
			System.out.println(acc2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			;
		}
		try {
			acc2.deposit(acc1.withdraw(500000));
			System.out.println(acc1);
			System.out.println(acc2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			;
		}
		System.out.println(acc1);
		System.out.println(acc2);

		acc1.deposit(500000);
		System.out.println(acc1);
		try {
			acc2.deposit(acc1.withdraw(500000));
			System.out.println(acc1);
			System.out.println(acc2);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
			;
		}
		try {
			System.out.println(acc2.withdraw(100000) + "원을 송금합니다.");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(acc2);
	}
}
