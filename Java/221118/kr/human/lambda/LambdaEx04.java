package kr.human.lambda;

import java.util.function.Predicate;

// 메소드 1개만으로 구성된 인터페이스는 람다식으로 표현이 가능하다.
// java.util.function 패키지에 있는 인터페이스들을 람다식으로 표현할 수 있다.
// predicate : 임의의 타입 인수 1개를 받아서 boolean을 리턴하는 Function 인터페이스이다.
public class LambdaEx04 {
	public static void main(String[] args) {
		// 문자열의 길이가 0인지 판단하는 메소드를 만들어서 사용하고 싶다.

		// 기존 방식
		Predicate<String> predicate = new Predicate<String>() {

			@Override
			public boolean test(String t) {
				return t.length() == 0;
			}
		};
		System.out.println(predicate.test("한사람")); // false
		System.out.println(predicate.test(" ")); // false
		System.out.println(predicate.test("")); // true

		// 람다식으로 바뀌면
		Predicate<String> predicate2 = (s) -> s.length() == 0;
		System.out.println(predicate2.test("한사람")); // false
		System.out.println(predicate2.test(" ")); // false
		System.out.println(predicate2.test("")); // true

		// 짝수인지를 판단해주는 람다식
		Predicate<Integer> isEven = (n) -> n % 2 == 0;
		System.out.println("4는 " + (isEven.test(4) ? "짝" : "홀") + "수이다.");
		System.out.println("6는 " + (isEven.test(6) ? "짝" : "홀") + "수이다.");
		System.out.println("13는 " + (isEven.test(13) ? "짝" : "홀") + "수이다.");

		// 년도를 받아 윤/평년을 판단하는 람다식
		Predicate<Integer> isLeapYear = (n) -> n % 400 == 0 || n % 4 == 0 && n % 100 != 0;
		for (int i = 2020; i <= 2040; i++)
			System.out.println(i + "년은" + (isLeapYear.test(i) ? "윤" : "평") + "년이다.");
	}
}
