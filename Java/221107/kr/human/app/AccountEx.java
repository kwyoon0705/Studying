package kr.human.app;

import kr.human.bank1.Account;

public class AccountEx {
	public static void main(String[] args) {
		Account acc = new Account("111-1111-11", "한사람", 3000000);
		System.out.println(acc);
		acc.deposit(500000);
		System.out.println(acc);
		try {
			System.out.println(acc.withdraw(5000000) + "원 출금");
			// 예외 미루기를 한 메소드를 사용하려면 예외처리(try&catch)를 해줘야한다.
			// 여기서 다시 한번 예외미루기를 하면 안된다. 절대절대절대절대
			// 예외미루기를 하여 런타임 에러 메세지가 발생할 경우, 그 메세지는
			// 개발자가 따로 지정한 에러 메세지가 아닌 시스템 자체에서 출력하는 메세지이므로
			// 시스템 관련 정보를 노출하여 보안을 취약하게 만들 수 있다.
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
