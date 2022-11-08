package kr.human.app;

import kr.human.vo.PersonVO;

public class CloneEx {
	public static void main(String[] args) {
		// clone() 깊은 복사를 지원해주는 메소드이다.
		// 깊은 복사를 많이할 필요가 있을 때 쓰는것이 좋다.

		PersonVO vo1 = new PersonVO("한사람", 21, false);
		PersonVO vo2 = vo1; // 얕은 복사

		System.out.println(vo1);
		System.out.println(vo2);
		System.out.println();

		vo2.setAge(33);
		System.out.println(vo1);
		System.out.println(vo2); // 같은 값이 나온다. 즉 얕은 복사란 변수만 다르고 같은 객체이다.
		System.out.println();

		System.out.println("*".repeat(50));

		PersonVO vo3 = new PersonVO();
		vo3.setName(vo1.getName());
		vo3.setAge(vo1.getAge());
		vo3.setGender(vo1.isGender());

		System.out.println(vo1);
		System.out.println(vo3);
		System.out.println();

		vo3.setAge(88);

		System.out.println(vo1);
		System.out.println(vo3); // 한개만 바뀐다. 깊은 복사로 서로 다른 객체이다.
		System.out.println(); // 하지만 위 방식은 많이 귀찮다.

		System.out.println("*".repeat(50));

		// clone메소드를 통한 깊은 복사
		// clone()메소드를 사용하기 위해선 사전작업이 필요하다.
		PersonVO vo4 = (PersonVO) vo1.clone();

		System.out.println(vo1);
		System.out.println(vo4);
		System.out.println();

		vo4.setAge(99);

		System.out.println(vo1);
		System.out.println(vo4); // 서로 값이 다른걸 보니 clone()을 이용한 깊은 복사가 성공
		System.out.println();

	}
}
