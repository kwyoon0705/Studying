package kr.human.app;

//값이 없는 상수(final 변수)의 초기화
public class FinalInit {
	// 값을 주지 않은 상수를 선언하는 경우는 상수성을 가지면서 객체에 따라 다른 값을 가지고 싶을 때 사용
	// EX) PI를 어떨때는 3.14, 어떨때는 3.1415 어떨때는 3.141592로 사용하고 싶을때
	// 이때는 메모리에 여러번 올라가야하므로 static을 겸용하면 안된다.
	final double PI;

	// 이때는 상수값을 받아 초기화하는 생성자를 만들어주면 된다.
	public FinalInit(double pI) {
		super();
		PI = pI;
	}

}
