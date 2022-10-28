
class Some {
	int iv = 123;
	static int sv = 456;

	// 인스턴스 메소드
	// 객체 참조 변수로 접근한다. 인스턴스 변수와 클래스 변수 모두 사용가능하다.
	public void method() {
		System.out.println("인스턴스변수 : " + iv);
		System.out.println("클래스변수 : " + sv);
	}

//메소드에서도 static을 붙일수있다.
	// 클래스 이름으로 접근한다.
	// static 변수만 사용가능하다.
	public static void staticMethod() { // static 메소드에서는 인스턴스 변수를 사용할 수 없다.
		System.out.println("클래스변수 : " + sv);
	}

}

public class StaticMethodEx {
	public static void main(String[] args) {
		Some.staticMethod(); // static메소드는 클래스이름으로 접근한다.
		Some s = new Some(); // 인스턴스 메소드는 먼저 객체참조변수를 선언한다.
		s.method(); // 그 후 객체참조변수로 접근한다.
	}
}
