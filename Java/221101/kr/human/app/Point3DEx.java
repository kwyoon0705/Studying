package kr.human.app;

import kr.human.vo.Point3D;

public class Point3DEx {
	public static void main(String[] args) {
		Point3D p1 = new Point3D();
		System.out.println(p1);

		Point3D p2 = new Point3D(10,15,8);
		System.out.println(p2);
		System.out.println(p2.getX());
		System.out.println(p2.getY());
		System.out.println(p2.getZ());
	}
}
