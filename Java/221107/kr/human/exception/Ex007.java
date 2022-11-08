package kr.human.exception;

//Exception, RuntimeException을 상속받아 사용자 예외를 만들 수 있다.

class NotFoundException extends Exception {
	private static final long serialVersionUID = 1L;

	// 생성자를 오버라이딩 해라. 그래야 나만의 예외 메세지를 만들 수 있다.
	public NotFoundException(String message) {
		super(message);
	}

}

public class Ex007 {
	public static void main(String[] args) {
		try {
			throw new NotFoundException("글이 존재하지 않습니다.");
		} catch (NotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
}
