package kr.human.interFace;

public class Graphic extends Point implements Shape {

	@Override
	public void draw() {
		System.out.println(getX() + ", " + getY() + "에 그린다.");
	}

	@Override
	public void move() {
		System.out.println(getX() + ", " + getY() + "로 이동한다.");
	}

}
