package kr.human.app;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import kr.human.vo.PersonVO;

public class PersonEx {
	public static void main(String[] args) throws ClassNotFoundException {
		PersonVO vo1 = new PersonVO("한사람", 22, false);
		PersonVO vo2 = new PersonVO("두사람", 36, true);
		PersonVO vo3 = new PersonVO("두사람", 36, true);

		System.out.println(vo1); // toString을 오버라이딩 해놔서 주소값이 안나오고
		System.out.println(vo2); // toString 메소드에 작성해 놓은 리턴값을 따르는 결과가 출력된다.
		System.out.println(vo3);

		System.out.println(vo1.hashCode());
		System.out.println(vo2.hashCode());
		System.out.println(vo3.hashCode());

		System.out.println(vo1.equals(vo2));
		System.out.println(vo2.equals(vo3)); // equal을 PersonVO 클래스에서 오버라이딩 해놨기에 내용이
												// 같으면 TRUE로 나온다. 오버라이딩 부분을 지우면 FALSE로 바뀜.

		// 리플렉션은 구체적인 클래스 타입을 알지 못해도
		// 그 클래스의 메소드, 타입, 변수들에 접근할 수 있도록 해주는 자바 API

		// 아래 세개는 같은 기능을 가진 명령어
		// Class classInfo = vo1.getClass();
		// Class classInfo = PersonVO.class; // 클래스 이름 뒤에 .class만 해줘도 getClass와 같은 기능이다.
		Class<?> classInfo = Class.forName("kr.human.vo.PersonVO");

		System.out.println(classInfo); // 클래스이름
		System.out.println(classInfo.getName());
		System.out.println(classInfo.getCanonicalName());
		System.out.println(classInfo.getFields()); // 필드정보

		Field[] fields = classInfo.getFields();
		System.out.println("필드개수 : " + fields.length + "개");

		for (Field field : fields) {
			System.out.print(field.getName() + ' ');
		}

		// 메서드 정보
		Method[] methods = classInfo.getMethods();
		System.out.println("메소드 개수 : " + methods.length + "개");

		for (Method method : methods) {
			System.out.println(method.getName() + " : " + method.getModifiers() + "," + method.getParameterCount());
		}

	}
}
