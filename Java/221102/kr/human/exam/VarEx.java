package kr.human.exam;

import kr.human.vo.Var; //package가 다르므로 import해줘야한다.

public class VarEx  {
//같은 클래스내에서 선언되었으므로 접근 모디파이어에 상관없이 모두 접근 가능하다.
	public void show() {
		Var var = new Var();
		//System.out.println("private 접근자 : " + var.priVar); // private멤버는 class밖에서는 접근 불가능
		//System.out.println("default 접근자 : " + var.defVar);//다른 package이므로 접근 불가능
		//System.out.println("protected 접근자 : " + var.proVar); //protected 접근자는 다른 package에서는 자식 클래스로만 접근가능하다.
		System.out.println("public 접근자 : " + var.pubVar);
	}
}
