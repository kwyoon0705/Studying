package kr.human.app;

class Parent {
	void show() {
		System.out.println("나는 부모입니다.");
	}
}

class Child extends Parent {
	void show() {
		System.out.println("나는 자식입니다.");
	}

}

public class UpDownEx {
	public static void main(String[] args) {
		Parent parent = new Parent();
		parent.show();
		Child child = new Child();
		child.show();

		// Up Casting : 자식타입의 객체를 부모변수에 저장하는것(allowed)
		Parent parent2 = new Child();

		// Down Casting : 부모타입의 객체를 자식변수에 저장하는것.(not allowed)
		// Child child2 = new Parent();
		// 형변환해서는 대입이 가능하다. 하지만 예외를 발생시킨다.
		// Child child2 = (Child)(new Parent());

		// 이건 가능하다. 왜? parent2는 실제 누구를 가리킬까? 바로child를 가진다.
		Child child2 = (Child) parent2; // 위에 부모변수에 자식타입의 객체가 저장되었다.
		// 그렇다면 parent2에서 show()를 호출하면 이건 부모일까요 자식일까요?
		parent2.show(); // 부모변수에서 메서드를 호출하면 부모타입이 아닌 부모타입의 변수가 실제로 가리키는 객체의 메소드가 호출된다.
						// 여기서는 자식의 show()가 호출된다.
		child2.show();
	}
}
