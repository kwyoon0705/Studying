package kr.human.vo3;

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

	// Product를 구매하는 메소드.
	// Product 클래스를 각각의 상품 클래스들이 상속받아 있으므로
	// 이거 하나면 모든 상품에 대응가능하다.
	public void buy(Product product) {
		if (money - product.getPrice() >= 0) {
			money -= product.getPrice();
			bonusPoint += product.getBonusPoint();
			System.out.println(product.getName() + "을(를) 구매했다.");
			System.out.println("현재 잔액 : " + money);
			System.out.println("현재 포인트 : " + bonusPoint);
		} else {
			System.out.println("돈이 없다!!");
		}
	}

}
