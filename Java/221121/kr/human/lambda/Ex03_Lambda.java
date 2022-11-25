package kr.human.lambda;
// 메서드 1개 만으로 구성된 인터페이스는 람다식으로 표현이 가능하다.

interface MyFunction{
	int max(int a, int b);
}

public class Ex03_Lambda {
	public static void main(String[] args) {
		// 기본의 방식
		System.out.println(new MyFunction() {
			@Override
			public int max(int a, int b) {
				return a>b ? a : b;
			}
		}.max(5, 6));
		// 람다를 구현하면
		MyFunction mf = (a,b)-> a > b ? a : b;
		System.out.println(mf.max(5,  6));
	}
}
