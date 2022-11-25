package kr.human.lambda;

// 메서드 1개 만으로 구성된 인터페이스는 람다식으로 표현이 가능하다.
// java.util.function 패키지에 있는 인터페이스들을 람다로 표현 가능하다.
// Runnable : 인수도 없고 리턴도 없을때 사용
public class Ex05_Lambda {
	public static void main(String[] args) {
		Runnable yes = ()->System.out.println("--==[{(성공!!!)}]==--");
		Runnable no = ()->System.out.println("--==[{(실패!!!)}]==--");
		
		yes.run();
		no.run();
		no.run();
		yes.run();
		
		Runnable line = ()->System.out.println("-".repeat(80));
		
		line.run();
		line.run();
		line.run();
	}
}
