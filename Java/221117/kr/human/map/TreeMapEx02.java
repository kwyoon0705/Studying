package kr.human.map;

import java.util.Map;
import java.util.TreeMap;

import kr.human.vo.PersonVO;

public class TreeMapEx02 {
	public static void main(String[] args) {
		Map<String, PersonVO> map = new TreeMap<>();
		map.put("한사람", new PersonVO("한사람", 22, true));
		map.put("두사람", new PersonVO("두사람", 18, false));
		map.put("세사람", new PersonVO("세사람", 19, true));
		map.put("네사람", new PersonVO("네사람", 34, false));
		System.out.println(map);
		Map<PersonVO, Integer> map2 = new TreeMap<>();
		map2.put(new PersonVO("한사람", 22, true), 500);
		map2.put(new PersonVO("두사람", 18, false), 1000);
		map2.put(new PersonVO("세사람", 19, true), 2000);
		map2.put(new PersonVO("네사람", 34, false), 3000);
		map2.put(new PersonVO("네사람", 44, false), 3000);
		System.out.println(map2);
		for (PersonVO vo : map2.keySet()) {
			System.out.println(vo);
		}
	}
}
