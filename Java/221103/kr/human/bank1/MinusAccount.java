package kr.human.bank1;

//춘향이 앞에서 가오가 상한 몽룡이를 위해 마통을 뚫어주자.

public class MinusAccount extends CardAccount {
	private int creditLine; // 신용도에 따라 마이너스 통장을 뚫어주자.

	// 생성자
	public MinusAccount(String accountNo, String ownerName, int balance, String cardNo, int creditLine) {
		super(accountNo, ownerName, balance, cardNo);
		this.creditLine = creditLine;
		// TODO Auto-generated constructor stub
	}

//creditLine은 변화해야하는 값이므로 setter도 설정해준다.
	public int getCreditLine() {
		return creditLine;
	}

	public void setCreditLine(int creditLine) {
		this.creditLine = creditLine;
	}

//출금 기능을 오버라이딩. why? 통장한도를 음수까지 뚫어줘야한다.
	@Override
	public int withdraw(int amount) throws Exception {
		if (getBalance() + creditLine < amount) {
			throw new Exception("인출불가!");
		}
		balance -= amount; // balance 변수는 접근 지정자가 protected라서 자식인 MinusAccount 클래스에서 접근 가능하다.
		return amount;
	}

}
