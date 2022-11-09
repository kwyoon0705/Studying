package kr.human.app;

public class MathEx {
	public static void main(String[] args) {
		double d = 3.567;
		System.out.println(Math.ceil(d)); // 천장
		System.out.println(Math.floor(d)); // 바닥

		d = -3.567;
		System.out.println(Math.ceil(d));
		System.out.println(Math.floor(d));

		System.out.println("*".repeat(50));
		d = 25;
		System.out.println(Math.sqrt(d)); // 제곱근
		System.out.println(Math.sqrt(d) * Math.sqrt(d) == d); // 제곱근을 판단하는 방법

		d = 24;
		System.out.println(Math.sqrt(d));
		System.out.println(Math.sqrt(d) * Math.sqrt(d) == d);
	}
}
