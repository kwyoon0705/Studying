package kr.human.list;


import java.util.Random;
import java.util.Vector;

public class ListEx02 {
	public static void main(String[] args) {
		// List : 입력된 순서가 중요한 경우에 사용한다.
		// Vector : 멀티스레드 환경을 지원하는 리스트. 검색은 빠르나 삽입 삭제가 느리다.
		Vector<Integer> v = new Vector<>();
		Random rnd = new Random();
		System.out.println("용량 : " + v.capacity() + "\n크기 : " + v.size() + "\n" + v);

		for (int i = 0; i < 15; i++)
			v.add(rnd.nextInt(101));
		System.out.println("용량 : " + v.capacity() + "\n크기 : " + v.size() + "\n" + v);

		for (int i = 0; i < v.size(); i++) {
			System.out.printf("%3d", v.get(i));
		}
		System.out.println();

		// 50 이하의 숫자를 모두 제거하시오.
		for (int i = 0; i < v.size(); i++) {
			if (v.get(i) >= 50)
				v.remove(i); // ==> 앞에서부터 지우면 인덱스가 땡겨져서 제대로 안지워진다.
		}
		System.out.println("용량 : " + v.capacity() + "\n크기 : " + v.size() + "\n" + v);

		// 80이하의 숫자를 모두 제거하시오.
		for (int i = v.size() - 1; i >= 0; i--) { // ==> 이렇게 뒤에서 지워준다.
			if (v.get(i) >= 80)
				v.remove(i);
		}
		System.out.println("용량 : " + v.capacity() + "\n크기 : " + v.size() + "\n" + v);

	}
}
