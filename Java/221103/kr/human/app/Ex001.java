package kr.human.app;

import kr.human.vo.Child;
import kr.human.vo.Parent;

public class Ex001 {
//상속관계에서 변수와 메서드가 중복 선언되면 어떻게 될까
	public static void main(String[] args) {
		Parent parent = new Parent();
		System.out.println("Parent x = " + parent.x);
		parent.show();
		System.out.println();

		Child child = new Child();
		System.out.println("Child = " + child.x);
		child.show();
		System.out.println();

		// 부모변수에 자식을 대입해서 호출하면 어떻게될까

		Parent parent2 = child; // 변수는 타입의 변수가 나온다. parent의 변수값
		System.out.println("Parent2 x = " + parent2.x); 
		parent2.show(); // but 메소드는 가리키는 실제 객체(자식)의 메소드가 호출된다.
	}
}
