package kr.human.vo;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor  // 모든 멤버 변수를 인수로 받는 생성자 생성 
@Setter // 셑터를 만들어라
@Getter // 겟터를 만들어라
// @ToString // toString()을 만들어라
@EqualsAndHashCode // equals() 와 hsahCode()를 만들어라.
public class Card { // 카드 1장을 저장하기 위한 용도의 클래스
	private int num;
	
	// 필요한 메서드 들을 만들어 보자
	// 무늬얻기
	public String getKind() {
		String[] kind = "◆♠♥♣".split("");
		return kind[num/13];
	}
	// 숫자를 얻는 메서드를 만들어보자
	public String getNumber() {
		String []numbers = "1,2,3,4,5,6,7,8,9,10,J,Q,K".split(",");
		return numbers[num%13];
	}
	@Override
	public String toString() {
		return getKind() + getNumber();
	}
	
}
