package kr.human.map;

import java.util.HashMap;
import java.util.Map;

public class MapEx01 {
	public static void main(String[] args) {
		Map<Integer, String> map = new HashMap<>();
		map.put(1, "한사람");
		map.put(2, "두사람");
		map.put(3, "세사람");
		map.put(4, "네사람");
		map.put(5, "댓사람");
		System.out.println(map.size() + " :  " + map);

		// key는 Set으로 중복을 허용하지 않는다.
		// 수정
		map.put(1, "한사람");
		map.put(2, "두식이"); // 같은 키에 다른 값을 넣으면 그 값으로 수정된다.
		map.put(3, "세사람");
		map.put(4, "네사람");
		map.put(5, "댓사람");
		System.out.println(map.size() + " :  " + map);

		// 얻기
		System.out.println(map.get(1));
		System.out.println(map.get(2));
		System.out.println(map.get(3));
		System.out.println(map.get(4));
		System.out.println(map.get(5));

		// 삭제
		System.out.println(map.remove(4));
		System.out.println(map.size() + " :  " + map);

		// 키만 얻기 : .keyset()
		for (int key : map.keySet()) {
			System.out.println(key);
		}

		// 값만 얻기 : .values()
		for (String value : map.values()) {
			System.out.println(value);
		}

		// 키와 값 둘다 얻는 방법
		for (int key : map.keySet()) {
			System.out.println(key + " : " + map.get(key));
		}

		// 검색 : .containsKey(key) => 해당 key값을 가졌는지 판단가능.
		System.out.println("5번 학생은 " + (map.containsKey(5) ? map.get(5) + "이다." : "없다."));
		System.out.println("4번 학생은 " + (map.containsKey(4) ? map.get(4) + "이다." : "없다."));
		
		
	}
}
