package kr.human.app;

import kr.human.vo.Point;

public class PointEx {
	public static void main(String[] args) {
		Point p1 = new Point(8, 15);
		System.out.println(p1);
		Point p2 = new Point(18, 25);
		System.out.println(p2);
		Point p3 = new Point(8, 15);
		
		System.out.println(p1.equals(p2) ? "같은점":"다른점");
		System.out.println(p1.equals(p3) ? "같은점":"다른점");
		
		p1.setX(45);
		p1.setY(55);
		System.out.println(p1);
		System.out.println("x좌표 : " + p1.getX());
		System.out.println("y좌표 : " + p1.getY());
	}
}
