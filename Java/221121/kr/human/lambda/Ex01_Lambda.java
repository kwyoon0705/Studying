package kr.human.lambda;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Ex01_Lambda {
	public static void main(String[] args) {
		List<String> list = Arrays.asList("일식이","두식이","삼식이","간나새끼");
		System.out.println(list);
		// 정렬해서 출력해보자
		Collections.sort(list);
		System.out.println(list);
		// 역순으로 정렬해서 출력해라
		Collections.sort(list, Collections.reverseOrder());
		System.out.println(list);
		// 기존의 컬렉션을 정렬하는 방법
		Collections.sort(list, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				return o1.compareTo(o2);
			}
		});
		// 람다식을 이용하여 표현이 가능하다.
		Collections.sort(list, (o1, o2)-> o1.compareTo(o2));
		System.out.println(list);
		
	}
}
