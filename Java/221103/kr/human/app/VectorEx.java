package kr.human.app;

import java.util.Vector;

//vector는 크기를 지정해도 사실 의미 없다. 크기 제한 없이 값을 넣을 수 있음.
//메모리 관리가 매우 유동적이다. 배열 개쓰레기
//Vector를 Collection Framework라고 한다.
//요즘에는 ArrayList를 쓴다고 한다.
public class VectorEx {
	public static void main(String[] args) {
		Vector<Integer> v = new Vector<>(5);
		show(v);
		System.out.println("*".repeat(50));
		v.add(11);
		v.add(22);
		v.add(33);
		show(v);
		System.out.println("*".repeat(50));
		Vector<Integer> v2 = new Vector<>();
		for (int i = 0; i < 20; i++) {
			v2.add((i + 1) * 5);
		}
		System.out.println("*".repeat(50));
		show(v2);
		v2.add(19, 99);
		System.out.println("*".repeat(50));
		show(v2);
		v2.remove(19);
		System.out.println("*".repeat(50));
		show(v2);
		v2.set(0, 0);
		System.out.println("*".repeat(50));
		show(v2);
		v2.clear();
		System.out.println("*".repeat(50));
		show(v2);
		v2.trimToSize();
		System.out.println("*".repeat(50));
		show(v2);
	}

	public static void show(Vector<Integer> v) {
		System.out.println("용량 : " + v.capacity());
		System.out.println("개수 : " + v.size());
		System.out.println("내용 : " + v);
	}
}
