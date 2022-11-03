package kr.human.vo2;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
public class Buyer {
	private int money;
	private int bonusPoint;

//tv를 구매하는 메소드
	public void buy(Tv tv) {
		if (money - tv.getPrice() >= 0) {
			money -= tv.getPrice();
			bonusPoint += tv.getBonusPoint();
			System.out.println("현재 잔액 : " + money);
			System.out.println("현재 포인트 : " + bonusPoint);
		} else {
			System.out.println("돈이 없다!!");
		}
	}

//computer 구매 메소드
	public void buy(Computer computer) {
		if (money - computer.getPrice() >= 0) {
			money -= computer.getPrice();
			bonusPoint += computer.getBonusPoint();
			System.out.println("현재 잔액 : " + money);
			System.out.println("현재 포인트 : " + bonusPoint);
		} else {
			System.out.println("돈이 없다!!");
		}
	}

//audio 구매하는 메소드
	public void buy(Audio audio) {
		if (money - audio.getPrice() >= 0) {
			money -= audio.getPrice();
			bonusPoint += audio.getBonusPoint();
			System.out.println("현재 잔액 : " + money);
			System.out.println("현재 포인트 : " + bonusPoint);
		} else {
			System.out.println("돈이 없다!!");
		}
	}

}
