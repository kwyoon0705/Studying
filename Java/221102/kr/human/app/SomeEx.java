package kr.human.app;

import kr.human.exam.Some;
// JDK 1.5에 추가된 정적 임포트
import static java.lang.System.out; //system을 생략할 수 있다.

//package의 이름이 다르고 class명이 같은 경우
public class SomeEx {
	public static void main(String[] args) {
		Some some1 = new kr.human.exam.Some(); // 자주 쓰는 클래스는 import하여 참조변수 선언이 가능하다.
		System.out.println(some1.x);
		kr.human.vo.Some some2 = new kr.human.vo.Some(); // 자주 안쓰는 녀석은 package경로까지 입력하여 참조변수 선언 가능
		System.out.println(some2.x);
		out.println(); // static을 import하여 system 없이 사용
		out.println(some1.x);
		out.println(some2.x);
	}

}
