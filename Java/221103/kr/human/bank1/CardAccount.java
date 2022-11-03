package kr.human.bank1;

//카드를 등록하고 카드로 출금할 수 있도록 추가해보자!

public class CardAccount extends Account {
	private String cardNo;

	public CardAccount(String accountNo, String ownerName, String cardNo) {
		this(accountNo, ownerName, 0, cardNo);
		// TODO Auto-generated constructor stub
	}

	public CardAccount(String accountNo, String ownerName, int balance, String cardNo) {
		super(accountNo, ownerName, balance);
		this.cardNo = cardNo;
		// TODO Auto-generated constructor stub
	}

	public String getCardNo() {
		return cardNo;
	}

	public void setCardNo(String cardNo) {
		this.cardNo = cardNo;
	}

	public int pay(String cardNo, int amount) throws Exception {
		if (!cardNo.equals(this.cardNo) || getBalance() < amount) {
			throw new Exception("지불이 불가능합니다");
		}
		return withdraw(amount);
	}
}
