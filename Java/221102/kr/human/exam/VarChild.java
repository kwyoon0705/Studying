package kr.human.exam;

import kr.human.vo.Var;

public class VarChild extends Var {
	public void show() {
		Var var = new Var();
		//System.out.println("private 접근자 : " + var.priVar); // private멤버는 class밖에서는 접근 불가능
		//System.out.println("default 접근자 : " + var.defVar);//다른 package이므로 접근 불가능
		System.out.println("protected 접근자 : " + proVar); //Var의 자식을 지정하면 var.을 떼고 접근 가능하다
		System.out.println("public 접근자 : " + var.pubVar);
	}
}
