package kr.human.app;

interface MessageSender {
	void send();
}

class SMSSender implements MessageSender {

	@Override
	public void send() {
		System.out.println("SMS를 전송합니다.");
	}

}

class MMSSender implements MessageSender {

	@Override
	public void send() {
		System.out.println("MMS를 전송합니다.");
	}

}

class EmailSender implements MessageSender {

	@Override
	public void send() {
		System.out.println("email을 전송합니다");
	}

}

public class SenderEx {
	public static void main(String[] args) {
		MessageSender[] member = { new SMSSender(), new MMSSender(), new EmailSender() };
		for (MessageSender sender : member)
			sender.send();
	}
}