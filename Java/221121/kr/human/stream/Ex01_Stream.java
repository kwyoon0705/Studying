package kr.human.stream;

import java.util.Random;

public class Ex01_Stream {
	public static void main(String[] args) {
		// 정수 스트림 만들기
		new Random()
		.ints(1, 45)
		// 중간연산
		.distinct()  // 중복제거
		.limit(6)    // 6개만
		.sorted()    // 정렬
		// 최종 연산
		.forEach(n->System.out.printf("%3d", n)); // 출력
		System.out.println();

		// 정수 스트림 만들기
		new Random()
		.ints() // 난수 무한스트림
		// 중간연산
		.filter(n -> n>=1 && n<=45) // 걸러서
		.distinct()  // 중복제거
		.limit(6)    // 6개만
		.sorted()    // 정렬
		// 최종 연산
		.forEach(n->System.out.printf("%3d", n)); // 출력
		System.out.println();
	}
	

}
