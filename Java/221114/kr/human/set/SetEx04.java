package kr.human.set;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import kr.human.vo.PersonVO;

public class SetEx04 {
	public static void main(String[] args) {
		Set<LocalDate> set = new TreeSet<>();

		set.add(LocalDate.of(2022, 1, 5));
		set.add(LocalDate.of(2022, 4, 15));
		set.add(LocalDate.of(2022, 3, 9));
		set.add(LocalDate.of(2022, 2, 8));
		set.add(LocalDate.of(2022, 11, 25));
		set.add(LocalDate.of(2022, 12, 25));

		System.out.println(set.size() + " : " + set);

		// 어떤 타입이든 Set을 사용하여 처리가 가능하다.
		// 그렇다면 내가 만든 클래스도 Set에서 저장 가능할까?

		// 내가 만든 클래스를 Set에 저장하여 중복을 제거하려면 반드시 같은지를 비교하는
		// 메소드를 오버라이딩 해야한다. ==> 클래스에 equals & hashCode 오버라이딩 메소드 생성.
		Set<PersonVO> personSet = new HashSet<>();
		personSet.add(new PersonVO("한사람", 22, false));
		personSet.add(new PersonVO());
		personSet.add(new PersonVO("한사람", 22, false));
		personSet.add(new PersonVO());

		System.out.println(personSet.size() + " 명 : " + personSet);

		// 트리셋으로 해보자.
		// TreeSet은 중복을 제거하고 정렬을 지원하는 Set이므로 정렬기준을 제시해줘야한다.
		// 만든 클래스에 대소관계를 비교하는 기능을 추가해줘야한다. 그래야 정렬이 가능하므로.
		Set<PersonVO> personTreeSet = new TreeSet<>();
		personTreeSet.add(new PersonVO("한사람", 22, false));
		personTreeSet.add(new PersonVO());
		personTreeSet.add(new PersonVO("한사람", 22, false));
		personTreeSet.add(new PersonVO("한사람", 18, false));
		personTreeSet.add(new PersonVO("한사람", 50, false));
		personTreeSet.add(new PersonVO()); // 비

		System.out.println(personTreeSet.size() + " 명 : " + personTreeSet);
	}
}
