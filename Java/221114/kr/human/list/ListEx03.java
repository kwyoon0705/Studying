package kr.human.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Vector;

public class ListEx03 {
	public static void main(String[] args) {
		// List : 입력된 순서가 중요한 경우에 사용한다.
		// Vector : 싱글스레드 환경을 지원하는 리스트. 검색은 빠르나 삽입 삭제가 느리다.
		List<Integer> v = new ArrayList<>();

		// ArrayList를 멀티쓰레드 환경에서 사용하려면
		// 다음과 같이 동기화를 하면 된다.
		Collections.synchronizedCollection(v); // <== 이걸 쓰면 멀티쓰레드에서도 동기화

		Random rnd = new Random();
		System.out.println("용량 : " + "\n크기 : " + v.size() + "\n" + v);

		// 추가
		for (int i = 0; i < 15; i++)
			v.add(rnd.nextInt(10));
		System.out.println("용량 : " + "\n크기 : " + v.size() + "\n" + v);

		// 삽입
		v.add(0, 88);
		v.add(1, 77);
		System.out.println("용량 : " + "\n크기 : " + v.size() + "\n" + v);

		// 수정
		v.set(2, 66);
		System.out.println("용량 : " + "\n크기 : " + v.size() + "\n" + v);

		v.remove(0);
		v.remove(0);
		v.remove(0);
		v.remove(0);
		v.remove(0);
		v.remove(0);
		System.out.println("용량 : " + "\n크기 : " + v.size() + "\n" + v);

		// 1개 가져오기
		System.out.println(v.get(6));
		System.out.println(v.get(2));
		System.out.println(v.get(8));
		System.out.println(v.get(10));

		v.retainAll(Arrays.asList(1, 2, 3, 4, 5)); // retainAll() 괄호안의 리스트와 교집합에 속하는 값
		System.out.println("용량 : " + "\n크기 : " + v.size() + "\n" + v);

		// 반복 1
		for (int i = 0; i < v.size(); i++) {
			System.out.printf("%3d", v.get(i));
		}
		System.out.println();

		// 반복 2
		for (int n : v) {
			System.out.printf("%3d", n);
		}
		System.out.println();

		// 반복 3
		Iterator<Integer> it = v.iterator();
		while (it.hasNext()) {
			System.out.printf("%3d", it.next());
		}
		System.out.println();

		/*
		 * // 반복 4 Enumeration<Integer> em = v.elements(); while (em.hasMoreElements())
		 * { System.out.printf("%3d", em.nextElement()); } System.out.println();
		 */
	}
}
