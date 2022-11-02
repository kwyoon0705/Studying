package kr.human.app;

public class FinalInitEx {
	public static void main(String[] args) {
		// FinalInit init1 = new FinalInit(); //error. 반드시 상수를 초기화하는 값을 넘겨줘야한다.
		FinalInit init2 = new FinalInit(3.14);
		FinalInit init3 = new FinalInit(3.1415);
		FinalInit init4 = new FinalInit(3.141592);

		// PI가 상수임에도 불구하고 값이 다 다르게 나온다.
		// 그리고 static이 아니므로 참조변수로 접근하여 사용한다.

		System.out.println(init2.PI);
		System.out.println(init3.PI);
		System.out.println(init4.PI);

		init2.PI = 3.141; // 상수(final)이므로 변경할수 없다.
	}
}
