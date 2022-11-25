package kr.human.lambda;

// 메소드 1개만으로 구성된 인터페이스는 람다식으로 표현이 가능하다.
// java.util.function 패키지에 있는 인터페이스들을 람다식으로 표현할 수 있다.
// predicate : 임의의 타입 인수 1개를 받아서 boolean을 리턴하는 Function 인터페이스이다.
public class LambdaEx05 {
	public static void main(String[] args) {
		Runnable yes = () -> System.out.println("\\성공/");
		Runnable no = () -> System.out.println("실패");

		yes.run();
		no.run();
	}
}
