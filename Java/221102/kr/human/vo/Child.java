package kr.human.vo;

public class Child extends Parent {
	public int x = 50;

	public void show() {
		System.out.println("x = " + x);
		System.out.println("this.x = " + this.x);
		System.out.println("super.x = " + super.x);
	}
}
