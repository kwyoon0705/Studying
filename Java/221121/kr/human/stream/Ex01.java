package kr.human.stream;

import java.util.stream.Collectors;
import java.util.stream.IntStream;
/*
1부터 10,000까지 8이라는 숫자가 총 몇번 나오는가?
8이 포함되어 있는 숫자의 갯수를 카운팅 하는 것이 아니라 8이라는 숫자를 모두 카운팅 해야 한다.
(※ 예를들어 8808은 3, 8888은 4로 카운팅 해야 함)
 */
public class Ex01 {
	public static void main(String[] args) {
		long count = IntStream.rangeClosed(1, 10000) // 1~10000까지의 스트림
		.mapToObj(n->n+"") // 문자열로 변환
		.filter(str->str.contains("8")) // 8이 들어있는것만 걸르고 
		.map(str->str.chars())  // 1글자씩 잘라서
		.flatMap(intStream -> intStream.mapToObj(n->(char)n)) // char로 만들고 
		.filter(n->n=='8') // 값이 8인것만 골라서
		//.forEach(System.out::println);
		.count(); // 개수세기
		System.out.println("8의 개수 : " + count + "개");
		
		count = IntStream.rangeClosed(1, 10000)
		.mapToObj(n->n+"") // 문자열로 변환
		.collect(Collectors.joining()) // 모두 붙여서
		.chars() // 1글자씩 잘라서
		.filter(n->(char)n=='8')  // 값이 8인것만 골라서
		//.forEach(System.out::println);
		.count();// 개수세기
		System.out.println("8의 개수 : " + count + "개");
	}
}
