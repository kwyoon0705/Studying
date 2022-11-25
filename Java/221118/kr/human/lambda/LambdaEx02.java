package kr.human.lambda;

public class LambdaEx02 {
	// Thread : 동시에 여러 작업을 할 때 사용
	// 메소드 1개만으로 구성된 인터페이스는 람다식으로 표현이 가능하다.
	public static void main(String[] args) {
		// 2초 후에 Hello World! 를 출력하고 싶다. --> 스레드를 이용
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(2000); // 일정 시간동안 잠시 sleep. 시간 단위는 millisec.
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Hello World!");
			}
		}).start();

		new Thread(() -> {
			System.out.println("나는 언제 실행될까?");
		}).start();
	}
}
