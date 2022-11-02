package kr.human.vo;

// 클래스 이름 앞에 final이 붙으면 상속금지
final class FinalClass {

}

class FinalChild extends FinalClass { // complie error =>클래스 FinalClass는 final이 붙어서 상속이 금지되어 있다.

}

class FinalMethod {
	// method앞에 final이 붙으면 overriding 금지!!! 고쳐쓸 수 없다
	final void show() {
		System.out.println("오버라이딩 금지!");
	}
}

class FinalMethodChild extends FinalMethod {
	void show() { // final이 붙은 method는 오버라이딩이 불가능하다.
		System.out.println("오버라이딩 금지!");
	}
}

class FinalVar {
	// 변수 앞에 final을 붙이면 변경금지. 변경할 수 없다는 의미.
	// 변경할 수 없다는 의미로 모두 대문자로 표기.
	// 복합단어의 경우 단어와 단어 사이에 _언더바를 삽입.
	// 일반적으로 static과 같이 사용한다. 값이 불변하므로 메모리에 한번만 올리면 되니까.
	final static double PI = 3.14;
	static final double MAX_VALUE = 1000000;

}

public class FinalEx {
	public static void main(String[] args) {
		System.out.println(FinalVar.MAX_VALUE);
		System.out.println(FinalVar.PI);
		FinalVar.MAX_VALUE = 999999; //final이 붙은 변수는 고칠 수 없으므로 error가 발생한다. 그냥 그 값을 가져다가 써야한다.
									// 즉 final이 붙은 변수는 상수이다.
	}
}

// 즉 final은 제한하는 용도이다. 변경불가.오버라이딩 불가.상속불가.