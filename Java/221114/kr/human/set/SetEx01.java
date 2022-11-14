package kr.human.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetEx01 {
	// Set : 순서가 중요하지않고 중복을 허용하지 않으려면 Set을 만들어 사용한다.
	// Set은 인터페이스이므로 사용할 때에는 HashSet이나 TreeSet을 사용해야한다.
	public static void main(String[] args) {
		Set<Integer> set = new HashSet<>();
		set.add(123);
		set.add(23);
		set.add(7);
		set.add(99);
		System.out.println(set.size() + "개" + set);
		set.add(123);
		set.add(23);
		set.add(7); // 여기까지 3개는 중복을 허용하지 않아 add가 안된다.
		set.add(88);
		System.out.println(set.size() + "개" + set);

		set.remove(99); // 괄호안의 값을 지워라.
		System.out.println(set.size() + "개" + set);

		set.clear(); // 모두 지워라.
		System.out.println(set.size() + "개" + set);

		for (int i = 0; i < 4; i++) {
			set.add((i + 1) * 3 + 5);
		}
		System.out.println(set.size() + "개" + set);
		// 반복
		Iterator<Integer> it = set.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
		for(int n:set) {
			System.out.printf("%3d",n);
		}
	}
}
