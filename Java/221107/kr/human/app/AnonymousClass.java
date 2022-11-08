package kr.human.app;

//익명 클래스 : 이름이 없는 클래스

//메세지를 출력해주는 인터페이스 작성
interface Message {
	void show(String message);
}

// Message를 구현한 MyMessag클래스
class MyMessage implements Message {

	@Override
	public void show(String message) {
		System.out.println("[" + message + "]");
	}

}

public class AnonymousClass {
	public static void main(String[] args) {
		MyMessage myMessage = new MyMessage();
		myMessage.show("오마이깠");
		// 여기서만 사용한다면 별도의 클래스를 만들 필요 없이 다음과 같이 사용할 수 있다.
		Message message = new Message() {

			@Override
			public void show(String message) {
				System.out.println("-=[" + message + "]=-");

			}
		};
		message.show("d여기서만b");

		// 1회용이라면 변수를 선언할 필요도 없다. 선언과 동시에 객체를 생성해서 메소드를 호출한다.
		// 익명 클래스를 사용한다.
		new Message() {

			@Override
			public void show(String message) {
				System.out.println("]=-=[" + message + "]=-=[");

			}
		}.show("1회용");

	}
}
