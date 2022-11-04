package kr.human.interFace;

public interface Shape {
	double PI = 3.1415; // interface에서는 무조건 public final이 내재되어 있다.
	void draw(); // interface에서는 무조건 public abstract가 내재되어 있다.
	void move();
	
}
