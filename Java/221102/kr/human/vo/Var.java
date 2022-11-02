package kr.human.vo;

public class Var {
	private int priVar = 123;
	int defVar = 456;
	protected int proVar = 789;
	public int pubVar = 999;
//같은 클래스내에서 선언되었으므로 접근 모디파이어에 상관없이 모두 접근 가능하다.
	public void show() {
		System.out.println("private 접근자 : " + priVar);
		System.out.println("default 접근자 : " + defVar);
		System.out.println("protected 접근자 : " + proVar);
		System.out.println("public 접근자 : " + pubVar);
	}
}
