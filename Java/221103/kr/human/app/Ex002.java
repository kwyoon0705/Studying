package kr.human.app;

import kr.human.vo2.Audio;
import kr.human.vo2.Buyer;
import kr.human.vo2.Computer;
import kr.human.vo2.Tv;

public class Ex002 {
	public static void main(String[] args) {
		// 물건준비
		Tv tv = new Tv(2000, 200);
		Computer computer = new Computer(3500, 35);
		Audio audio = new Audio(34500, 345);

		// 손님이 왔네요
		Buyer buyer1 = new Buyer(50000, 0);
		buyer1.buy(tv);
		buyer1.buy(computer);
		buyer1.buy(audio);
		buyer1.buy(audio);

		// 이렇게 작성을 하면 제품 클래스를 만들때 마다 Buyer클래스에
		// 제품을 구매하는 메서드를 제품수만큼 만들어 주어야한다
		// 즉 품목이 늘어나면 늘어날 수록 계속해서 Buyer클래스에 메소드를 만들어주어야한다.
	}
}
