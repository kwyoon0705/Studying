package kr.human.lambda;
// 메서드 1개 만으로 구성된 인터페이스는 람다식으로 표현이 가능하다.
public class Ex02_Lambda {
	public static void main(String[] args) {
		// 2초 후에 HelloWorld!!!출력하고 싶다. ----> 스레드를 이용
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(2000); // 일정시간 동안 잠시 대기(시간은 ms로 입력)
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("HelloWorld!!!");				
			}
		}).start();
		
		new Thread(()->{System.out.println("나는 언제 실행될까?");}).start();
		
	}
}
