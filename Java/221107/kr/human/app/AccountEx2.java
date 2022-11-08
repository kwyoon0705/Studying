package kr.human.app;

import kr.human.bank1.Account;

class MyAccount extends Account {

	public MyAccount(String accountNo, String ownerName, int balance) {
		super(accountNo, ownerName, balance);
	}

	public MyAccount(String accountNo, String ownerName) {
		super(accountNo, ownerName);
	}

	@Override
	public int withdraw(int amount) {
		try {
			return super.withdraw(amount);
		} catch (Exception e) {
			// 예외 포장하기
			// Checked Exception을 Unchecked Exception으로 바꿔준다.
			// 이렇게 하면 이 메서드를 사용하는 곳에서 try-catch가 선택적인 사항이 되어
			// 예외가 발생하지 않는다.
			new RuntimeException(e.getMessage());
		}
		return 0;
	}

}

public class AccountEx2 {
	public static void main(String[] args) {
		MyAccount acc = new MyAccount("111-1111-11", "한사람", 3000000);
		System.out.println(acc);
		acc.deposit(500000);
		System.out.println(acc);
		System.out.println(acc.withdraw(5000000) + "원 출금");

	}
}
