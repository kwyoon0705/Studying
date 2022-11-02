package kr.human.vo;

public class GrandChild extends Child {
	public GrandChild() {
		// 이자리에 컴파일러가 자동으로 super()를 삽입해 준다.
		System.out.println("손자의 생성자 호출");
	}
}
