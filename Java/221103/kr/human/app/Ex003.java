package kr.human.app;

import kr.human.vo3.Audio;
import kr.human.vo3.Buyer;
import kr.human.vo3.Computer;
import kr.human.vo3.Tv;
import kr.human.vo3.Video;

public class Ex003 {
	public static void main(String[] args) {
		// 물건준비
		Tv tv = new Tv("LG TV",2000, 200);
		Computer computer = new Computer("삼성 Computer",3500, 35);
		Audio audio = new Audio("야마하", 34500, 345);
		Video video = new Video("대우", 3000, 30);
		
		// 손님이 왔네요
		Buyer buyer1 = new Buyer(500000, 0);
		buyer1.buy(tv);
		buyer1.buy(computer);
		buyer1.buy(video);
		buyer1.buy(audio);
		buyer1.buy(audio);
		
		// Product라는 부모클래스를 만들어 각각의 상품 클래스가 상속받게 만들고
		// Buyer 클래스에는 Product 클래스만 적용시킨 메소드 하나만 있으면
		// Product 클래스를 상속받은 상품 클래스들이 알아서 적용된다.
		
	}
}
