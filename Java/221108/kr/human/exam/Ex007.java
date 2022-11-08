package kr.human.exam;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//사이냅소프트 면접문제

//주어진 문자열(공백 없이 쉼표로 구분되어 있음)을 가지고 아래 문제에 대한 프로그램을 작성하세요.

//이유덕,이재영,권종표,이재영,박민호,강상희,이재영,김지완,최승혁,이성연,박영서,박민호,전경헌,송정환,김재성,이유덕,전경헌

//김씨와 이씨는 각각 몇 명 인가요?
//"이재영"이란 이름이 몇 번 반복되나요?
//중복을 제거한 이름을 출력하세요.
//중복을 제거한 이름을 오름차순으로 정렬하여 출력하세요.

public class Ex007 {
	static String[] names = "이유덕,이재영,권종표,이재영,박민호,강상희,이재영,김지완,최승혁,이성연,박영서,박민호,전경헌,송정환,김재성,이유덕,전경헌".split(",");

	public static void main(String[] args) {
		// 1.김씨와 이씨는 각각 몇명인가요?
		int kim = 0, lee = 0;
		for (String name : names) {
			if (name.startsWith("김"))
				kim++;
			if (name.startsWith("이"))
				lee++;

		}
		System.out.println("김씨는 " + kim + "명 입니다");
		System.out.println("이씨는 " + lee + "명 입니다");

		// 2. 이재영이란 이름은 몇번 반복되나요?
		int ljy = 0;
		for (String name : names) {
			if (name.equals("이재영"))
				ljy++;
		}
		System.out.println("이재영이란 이름은 " + ljy + "번 반복됩니다.");

		// 3. 중복을 제거한 이름을 출력하세요.
		Set<String> set = new HashSet<>(); // 중복을 제거해주는 자료구조
		for (String name : names) {
			set.add(name);
		}
		System.out.println(set);

		// 4. 중복을 제거한 이름을 오름차순으로 정렬하여 출력하세요.

		List<String> list = new ArrayList<>(set); // List는 순차 자료구조이다.
		list.sort(null);
		System.out.println(list);

		// 5. 중복을 제거한 이름을 내림차순으로 정렬하여 출력하세요.
		list.sort(new Comparator<String>() {
			@Override // 같으면 0 앞의 것이 크면 1 뒤의 것이 크면 -1을 리턴하도록 만들어준다.
			public int compare(String o1, String o2) {
				return o2.compareTo(o1); // 내림차순
				//return o1.compareTo(o2); // 오름차순
			}
		});
		System.out.println(list);
	}
}
