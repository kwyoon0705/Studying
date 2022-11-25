package kr.human.stream;

import java.util.Arrays;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Ex02_Stream {
	public static void main(String[] args) {
		// 스트림 만들기
		
		// 1. 리스트로 부터 스트림 만들기
		Stream<Integer> intStream = Arrays.asList(11,22,33,44,55).stream();
		System.out.println(intStream); // toString이 오버라이딩 되어있지 않다.
		intStream.forEach(System.out::println); // 최종연산
		// 스트림은 1회용이다. 한번 최종연산을 했으면 다시 만들어야 한다.
		intStream = Arrays.asList(11,22,33,44,55).stream();
		// 정적메서드를 호출하려면 "클래스이름::정적메서드명" 호출 가능
		intStream.forEach(Ex02_Stream::intStreamPrint); // 최종연산
		System.out.println();
		// forEach메서드에는 람다식이 가능하다.
		intStream = Arrays.asList(11,22,33,44,55).stream();
		intStream.forEach(n -> System.out.printf("%4d", n));
		System.out.println();
		
		// 2. 배열로 부터 스트림 만들기
		Stream<String> stringStream = Stream.of("한놈,두식이,석삼,너구리".split(","));
		stringStream.forEach(n -> System.out.printf("%5s", n));
		System.out.println();
		
		// 3. iterate()메서드로 스트림 만들기
		intStream = Stream.iterate(10, n->n+2); // 10부터 짝수 무한 스트림 생성
		intStream.limit(10).forEach(n -> System.out.printf("%4d", n));
		System.out.println();
		// 1 부터 홀수 10개
		Stream.iterate(1, n->n+2).limit(10).forEach(n -> System.out.printf("%4d", n));
		System.out.println();
		
		// 4. generate()를 이용한 스트림 생성
		Stream<Double> randStream = Stream.generate(Math::random);
		randStream.limit(5).forEach(n -> System.out.printf("%.2f ", n));
		System.out.println();
		
		// 5. Random클래스를 이용한 스트림 생성
		IntStream intStream2 = new Random().ints(); // 무한스트림
		intStream2.
		filter(n-> n>=0 && n<=100).
		limit(5).
		forEach(n -> System.out.printf("%4d", n));
		System.out.println();
		
		// 6. 값으로부터 스트림 만들기
		stringStream = Stream.of("정말", "재미없는", "스트림");
		stringStream.forEach(s->System.out.println(s));
		
		// 7. builder()를 이용한 스트림 생성
		stringStream = Stream.<String>builder()
					  .add("한놈")
					  .add("두식이")
					  .add("석삼")
					  .add("너구리")
					  .build();
		stringStream.forEach(s->System.out.println(s));
		
		// 8. range()를 이용한 스트림 생성
		intStream2 = IntStream.range(1, 10);
		intStream2.forEach(n -> System.out.printf("%4d", n));
		System.out.println();

		intStream2 = IntStream.rangeClosed(1, 10);
		intStream2.forEach(n -> System.out.printf("%4d", n));
		System.out.println();
		
		// 9. empty()를 이용한 스트림 생성 : 빈 스트림
		Stream<String> strStream5 = Stream.empty();
		strStream5.forEach(System.out::println);
		
	}
	public static void intStreamPrint(int n) {
		System.out.printf("%4d", n);
	}

}
