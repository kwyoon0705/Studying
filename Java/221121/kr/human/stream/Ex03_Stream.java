package kr.human.stream;

import java.util.Random;
import java.util.stream.Stream;

public class Ex03_Stream {
	public static void main(String[] args) {
		// 중간 연산

		// 20~30을 출력
		// limit(개수) : 개수제한 중간 연산
		Stream.iterate(20, n->n+1).limit(11).forEach(n->System.out.print(n + " "));
		System.out.println();
		
		// 21부터 홀수 10개 출력
		Stream.iterate(21, n->n+2).limit(10).forEach(n->System.out.print(n + " "));
		System.out.println();
		
		// 21부터 홀수 10개 출력
		Stream.iterate(21, n->n+1) // 무한스트림
		.filter(n->n%2==1) // 람다식으로 걸러서 : 중간연산
		.limit(10)
		.forEach(n->System.out.print(n + " "));
		System.out.println();

		Stream
		.iterate(21, n->n+1) // 무한스트림
		.filter(Ex03_Stream::isOdd) // 정적 메서드를 이용하여 걸러서 : 중간연산
		.limit(10)
		.forEach(n->System.out.print(n + " "));
		System.out.println();
		
		// 1부터 홀수중 100번째 부터 10개 중에서 3의 배수만
		Stream
		.iterate(1, n->n+2) // 무한스트림
		.skip(100) // 건너띄기
		.limit(10) // 10개
		.filter(n->n%3==0) // 걸러서 : 중간연산
		.forEach(n->System.out.print(n + " "));
		System.out.println();
		
		// 실수 난수 10개
		Stream
		.generate(Math::random)
		.limit(10)
		.forEach(n->System.out.print(n + " "));
		System.out.println();
		
		// 사용자가 만든 정적메서드르 이용하여 generate하기
		Stream
		.generate(Ex03_Stream::next)
		.limit(10)
		.forEach(n->System.out.print(n + " "));
		System.out.println();
		
		// 객체의 메서드를 호출하여 generate하기
		Stream
		.generate(new Random()::nextInt)
		.limit(10)
		.forEach(n->System.out.print(n + " "));
		System.out.println();
		
		new Random().ints().limit(10).forEach(n->System.out.print(n + " "));
		System.out.println();

		new Random().ints(1, 101).limit(10).forEach(n->System.out.print(n + " "));
		System.out.println();
		
		new Random().ints(5, 100,201).forEach(n->System.out.print(n + " "));
		System.out.println();
	}
	
	static int count = 1;
	public static int next() {
		count *= 2;
		return count;
	}
	
	public static boolean isOdd(int n) {
		return n%2==1;
	}

}
