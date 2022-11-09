package kr.human.app;

import java.util.Vector;

public class BoxingUnboxingEx {
	public static void main(String[] args) {
		// Boxing : 기본 자료형을 객체형으로 만든다.
		// unBoxing : 객체 자료형을 기본 자료형으로 만든다.
		// JDK 1.5부터 자동으로 처리된다.

		int i = 100;
		Integer ii = new Integer(i); // Boxing
		int j = ii.intValue(); // unBoxing

		Integer jj = j; // Auto Boxing
		int k = jj; // Auto unBoxing

		// Collection Framework에서는 기본 자료형은 사용하지 못한다.
		// 반드시반드시 객체형!! EX) Integer, Long, Short, Character etc.를 사용해야 한다
		Vector<Integer> v1 = new Vector<Integer>(); // JDK. 1.5까지 사용
		Vector<Integer> v2 = new Vector<>(); // JDK. 1.6부터 사용
		// Vector<int> v3 = new Vector<>();//에러발생... 기본 자료형은 사용불가하다.

	}
}
