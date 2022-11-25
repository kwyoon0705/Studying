package kr.human.lambda;

import java.util.function.Predicate;

// 메서드 1개 만으로 구성된 인터페이스는 람다식으로 표현이 가능하다.
// java.util.function 패키지에 있는 인터페이스들을 람다로 표현 가능하다.
// Predicate : 임의의 타입 인수 1개를 받아서 boolean을 리턴하는 Function인터페이스이다.
public class Ex04_Lambda {
	public static void main(String[] args) {
		// 문자열의 길이가 0인지 판단하는 메서드를 만들어서 사용하고 싶다.
		// 기존
		Predicate<String> predicate = new Predicate<String>() {
			@Override
			public boolean test(String t) {
				return t.trim().length()==0;
			}
		};
		
		System.out.println(predicate.test("한사람")); // false
		System.out.println(predicate.test(" ")); // true
		System.out.println(predicate.test("")); // true
		System.out.println();
		
		// 람다식으로 바꾸면
		Predicate<String> predicate2 = (s)->s.trim().length()==0;
		
		System.out.println(predicate2.test("한사람")); // false
		System.out.println(predicate2.test(" ")); // true
		System.out.println(predicate2.test("")); // true
		
		// 짝수인지를 판단해주는 람다식
		Predicate<Integer> isEven =(n)->n%2==0;
		System.out.println("4는" + (isEven.test(4) ? "짝":"홀") + "수");
		System.out.println("9는" + (isEven.test(9) ? "짝":"홀") + "수");
		
		// 년도를 받아 윤/평년을 판단하는 람다식
		Predicate<Integer> isLeapYear =(n)->n%400==0 || n%4==0 && n%100!=0;
		for(int i=2020;i<=2040;i++)
			System.out.println(i + "년은 " + (isLeapYear.test(i) ? "윤":"평") + "년");

	}
}
