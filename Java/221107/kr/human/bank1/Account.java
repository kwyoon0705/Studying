package kr.human.bank1;

//은행 계좌 클래스

public class Account {
	private String accountNo; // 계좌번호
	private String ownerName; // 예금주
	protected int balance; // 잔액

	// 생성자를 만든다.
	public Account(String accountNo, String ownerName) {
		this(accountNo, ownerName, 0);
	}

	public Account(String accountNo, String ownerName, int balance) {
		this.accountNo = accountNo;
		this.ownerName = ownerName;
		this.balance = balance;
	}
	// Getter & Setter => Getter만 만들어야한다. Setter로 접근해서 수정하게 하면 안되기 때문
	// 계좌번호와 예금주는 수정변경이 필요없는 값이므로 Getter만 필요.
	// 잔액은 변경이 이루어지는 값이긴하나 외부에서 함부로 접근하면 XXXXXXXXXXX.
	// 수정은 반드시 정해진 메소드로만 제한적으로 이루어져야한다.

	public String getAccountNo() {
		return accountNo;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public int getBalance() {
		return balance;
	}

	// 입금
	public void deposit(int amount) {
		balance += amount;
	}

	// 출금
	// 메소드명 뒤에 throw Exception을 쓰면 예외 미루기이다.
	// 예외 미루기를 하면 이 메소드를 사용하는 곳에서 예외 처리를 하라는 의미이다.
	public int withdraw(int amount) throws Exception {
		if (balance < amount) { // 내가 일부러 만든 예외구문이다.
			// 잔액이 출금요청액보다 작을때 발생하는 예외
			throw new Exception("잔액이 부족합니다."); // 예외발생.
		}
		balance -= amount;
		return amount;
	}

	@Override
	public String toString() {
		return accountNo + "(" + ownerName + ") : " + balance + "원";
	}

}
