package kr.human.graphic;

//추상 클래스 : 추상 메소드를 1개 이상 포함한 클래스이다. 미완성 클래스이기에 객체 생성 불가.
abstract class Shape { // but, 부모로써는 기능할 수 있다.
	static double PI = 3.14;

	abstract void draw(); // 추상 메소드 : 내용이 없는 메소드. 자식한테 오버라이딩을 강제하는 메소드이다.
	// 다형성 구현을 위해 추상 메소드는 오버라이딩을 필수로 요구하기에, 컴파일 단계에서 오버라이딩을 검증한다.

	void move() {
		System.out.println("이동합니다.");
	}
}

class Point extends Shape {
	void draw() { // 추상클래스의 자식으로 추상메소드를 오버라이딩. 여기서 메소드 이름이 부모클래스 안의 추상메소드 이름과 달라지면 컴파일 에러 메세지를
					// 띄운다. 즉 반드시 오버라이딩하게 강제한다.
		System.out.println("점을 그립니다.");
	}

}

class Line extends Shape {
	void draw() {
		System.out.println("선을 그립니다.");
	}

}

class Circle extends Shape {
	void draw() {
		System.out.println("원을 그립니다.");
	}

}

class Rectangle extends Shape {
	void draw() {
		System.out.println("사각형을 그립니다.");
	}

}

public class GraphicsEx {
	public static void main(String[] args) {

		Shape[] shapes = { new Point(), new Line(), new Circle(), new Rectangle() };

		for (int i = 0; i < shapes.length; i++) {
			// 다형성 : 1개가 여러개로 발현된다.
			// draw메소드를 호출했는데 왜 여러개가 나올까? 이게 바로 다형성이다.
			// 다형성을 구현하기 위한 3가지 전제조건.
			// 1. 동일한 부모클래스를 사용한다. => Shape클래스가 부모역할
			// 2. 부모의 메소드를 오버라이딩 해야한다. => Shape클래스의 draw()메소드가 오버라이딩 되었다.
			// 3. 부모변수에 자식들을 대입해서 호출해줘야한다. =>Shape클래스의 배열변수 shapes[]에 대입되었다.
			shapes[i].draw();
			// 다형성 설명 ex)그림판에서 마우스로 그림을 그릴때, 마우스로 클릭-드래그-클릭떼기 라는
			// 한 종류의 행동만 해도 선,사각형,원 등을 다양하게 그릴 수 있다.

		}
		System.out.println();
		Shape shape = new Circle();
		shape.draw();
		shape = new Line();
		shape.draw();
		shape = new Rectangle();
		shape.draw();

	}
}
