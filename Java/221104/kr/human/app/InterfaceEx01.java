package kr.human.app;

import kr.human.interFace.Shape;

//interface를 구현할 때에는 extends가 아닌 implements를 사용한다.
class Shapes implements Shape {
	@Override
	public void draw() {
		// TODO Auto-generated method stub
		System.out.println("그려라");
	}

	@Override
	public void move() {
		// TODO Auto-generated method stub
		System.out.println("이동해라");
	}
}

public class InterfaceEx01 {
	public static void main(String[] args) {
		Shape shape = new Shapes();
		System.out.println(Shape.PI);// interface에서는 무조건 public final이 내재되어 있다.
		shape.draw();
		shape.move();
	}
}
