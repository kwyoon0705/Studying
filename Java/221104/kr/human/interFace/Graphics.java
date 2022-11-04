package kr.human.interFace;

//interface가 interface를 상속받을 수 있다. 이때는 extends를 사용한다.
// interface상속은 다중상속이 가능하다.
public interface Graphics extends Shape, Shape2 {
	void remove();
}
