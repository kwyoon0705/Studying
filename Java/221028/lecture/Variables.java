
public class Variables {
	int iv = 1; // instance variables : 객체 생성 후 참조변수로 사용가능.
	static int sv = 2; // static variables or class variables : 객체 생성을 하지 않고도 사용가능한 변수.
						// 클래스 이름으로 접근가능. 모든 객체가 공유한다.
	public void method() {
		int lv = 3; // local variables : 메소드 내에서만 사용가능한 변수
	}
}
