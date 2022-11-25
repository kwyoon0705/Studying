package kr.human.lambda;
// 메소드 1개만으로 구성된 인터페이스는 람다식으로 표현이 가능하다.
interface MyFunction {
	int max(int a, int b);
}

public class LambdaEx03 {
	public static void main(String[] args) {
		// 기존의 방식
		System.out.println(new MyFunction() {

			@Override
			public int max(int a, int b) {
				return a > b ? a : b;
			}

		}.max(5, 6));
		// 람다를 구현하면 이렇게 표현가능하다.
		MyFunction mf = (a, b) -> a > b ? a : b;
		System.out.println(mf.max(5, 6));
	}
}
