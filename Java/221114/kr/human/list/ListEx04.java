package kr.human.list;

import java.util.ArrayList;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class ListEx04 {
	public static void main(String[] args) {
		// List : 입력된 순서가 중요한 경우에 사용한다.
		// Vector : 싱글스레드 환경을 지원하는 리스트. 검색은 빠르나 삽입 삭제가 느리다.
		List<Integer> v = new ArrayList<>();

		// ArrayList를 멀티쓰레드 환경에서 사용하려면
		// 다음과 같이 동기화를 하면 된다.
		Collections.synchronizedCollection(v); // <== 이걸 쓰면 멀티쓰레드에서도 동기화

		Random rnd = new Random();
		System.out.println("크기 : " + v.size() + "\n" + v);

		// 추가
		for (int i = 0; i < 15; i++)
			v.add(rnd.nextInt(101));
		System.out.println("크기 : " + v.size() + "\n" + v);

		// Arrays.sort(v); v는 배열이 아니므로 sort가 안된다.

		v.sort(null);
		System.out.println("크기 : " + v.size() + "\n" + v);

		v.sort(Collections.reverseOrder()); // ==> Collections를 사용하여 역순 정렬도 가능하다.
		System.out.println("크기 : " + v.size() + "\n" + v);

		v.sort(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				// 오름차순 => 앞에 것이 크면 양수, 뒤에 것이 크면 음수 : 앞값은 뒤로 이동하고 뒷값은 앞으로 이동
				return o1 - o2;
			}
		});
		System.out.println("크기 : " + v.size() + "\n" + v);
	}
}
