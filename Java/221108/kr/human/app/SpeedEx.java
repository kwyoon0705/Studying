package kr.human.app;

public class SpeedEx {
	public static void main(String[] args) {
		String str = "";
		StringBuffer sBuffer = new StringBuffer();
		StringBuilder sBuilder = new StringBuilder();

		// String 객체는 불변객체이다. 변할 수 없다. 연산을하면 항상 새로운 객체를 만들어서 리턴한다.
		long start = System.currentTimeMillis();
		for (int i = 0; i < 10000; i++) { // "꽝"을 붙여서 10000개를 만들어 보자 ===> 10000개의 객체가 생긴다.
			str += "꽝";
		}
		System.out.println("실행시간 : " + (System.currentTimeMillis() - start) + "ms");

		// StringBuffer나 StringBuilder는 가변객체로 연산을하면 자기 자신이 변경된다.
		// StringBuffer는 멀티스레드 프로그램에 안전하게 설계되어있고
		// StringBuilder는 싱글 스레드 프로그램에만 안전하게 설계되어 나중에 발표됨!!!
		start = System.currentTimeMillis();
		for (int i = 0; i < 500000; i++) { // "꽝"을 붙여서 10000개를 만들어 보자 ==> 1개의 객체가 생긴다.
			sBuffer.append("꽝");
		}
		System.out.println("실행시간 : " + (System.currentTimeMillis() - start) + "ms");

		start = System.currentTimeMillis();
		for (int i = 0; i < 500000; i++) { // "꽝"을 붙여서 10000개를 만들어 보자 ==> 1개의 객체가 생긴다.
			sBuilder.append("꽝");
		}
		System.out.println("실행시간 : " + (System.currentTimeMillis() - start) + "ms");
	}
}
// 싱글쓰레드 프로그램에서는 builder를 사용한다. => 싱글쓰레드에서 속도가 더 빠름
// 멀티쓰레드 프로그램에서는 buffer를 사용한다.