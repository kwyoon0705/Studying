package kr.human.lambda;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Supplier;

// 메서드 1개 만으로 구성된 인터페이스는 람다식으로 표현이 가능하다.
// java.util.function 패키지에 있는 인터페이스들을 람다로 표현 가능하다.
// 인수가 없고 리턴값이 1개인 함수 ==> Supplier 인터페이스 구현
// 인수가 1개고 리턴값이 없는 함수 ==> Consumer 인터페이스 구현
// 인수가 2개고 리턴값이 1개인 함수 ==> BiFunction 인터페이스 구현
// 인수가 2개고 리턴값이 없는 함수 ==> BiConsumer 인터페이스 구현
public class Ex07_Lambda {
	public static void main(String[] args) {
		// 0~100사이의 정수 난수를 구하는 람다식
		Supplier<Integer> rand100 = ()->(int)(Math.random()*101);
		for(int i=0;i<10;i++) {
			System.out.printf("%4d", rand100.get());
		}
		System.out.println();
		// 출력 전용
		Consumer<String> printMessage = (a)->System.out.println("★" + a + "★" );
		printMessage.accept("꿈은 이루어진다.");
		
		// 정수2개를 받아 String으로 결합해서 리턴해주는 람다식
		BiFunction<Integer, Integer, String> concat = (a,b)->a+""+b;
		System.out.println(concat.apply(123, 567));
		
		// 합계와 개수를 입력받아 평균을 소수이하 2자리까지만 구해서 String으로 
		// 리턴하는 람다식을 만드시오
		BiFunction<Integer, Integer, String> avg = (a,b)->String.format("%.2f", (double)a/b);
		System.out.println(avg.apply(245, 9));
		
		BiConsumer<String, Integer> repeat = (a,b)->System.out.println(a.repeat(b));
		
		repeat.accept("바보", 4);
		repeat.accept("짝", 3);
		repeat.accept("짝", 3);
		repeat.accept("짝", 7);
		
	}
}
