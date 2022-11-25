package kr.human.lambda;

import java.util.function.Function;

// 메서드 1개 만으로 구성된 인터페이스는 람다식으로 표현이 가능하다.
// java.util.function 패키지에 있는 인터페이스들을 람다로 표현 가능하다.
// Function인터페이스 : 인수가 1개 리턴이 1개인 경우에 사용
public class Ex06_Lambda {
	public static void main(String[] args) {
		// 정수를 받아 문자열로 바꾸는 람다식
		Function<Integer, String> int2String = (a)->a+"";
		System.out.println(int2String.apply(12) + int2String.apply(34));
		
		// 문자열를 받아 정수로 바꾸는 람다식
		Function<String, Integer> string2int = (a)->Integer.parseInt(a);
		System.out.println(string2int.apply("123") + string2int.apply("456"));
		
		// 반지름을 입력받아 원의 둘레를 출력하는 람다식을 만드시오!!!
		Function<Integer, Double> circumference = (a)->a*2*Math.PI;
		System.out.println("반지름 7인 원의 둘레 : " + circumference.apply(7));
	}
}
