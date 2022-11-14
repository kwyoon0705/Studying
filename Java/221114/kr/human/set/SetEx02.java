package kr.human.set;

import java.util.Arrays;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetEx02 {
	public static void main(String[] args) {

		String names[] = "이유덕,이재영,권종표,이재영,박민호,강상희,이재영,김지완,최승혁,이성연,박영서,박민호,전경헌,송정환,김재성,이유덕,전경헌".split(",");
		System.out.println(names.length + "명 : " + Arrays.toString(names));

		Set<String> nameSet = new HashSet<>();
		for (String name : names)
			nameSet.add(name); // set은 중복 데이터를 비허용하므로 add로 붙이면 중복 데이터는 다 제거된다.
		System.out.println(nameSet.size() + "명 : " + nameSet);

		Set<String> nameSortSet = new TreeSet<>(nameSet);
		System.out.println(nameSortSet.size() + "명 : " + nameSortSet);
	}
}
