package kr.human.vo;

import java.util.Random;

// 카드 1묶을을 저장하는 용도의 클래스
public class Deck {
	private Card[] cards = new Card[52]; // 카드 1묶음
	private int index;
	// 생성자
	public Deck() {
		shuffle(); // 카드 섞기
	}

	// 카드 1장씩을 주는 메서드
	public Card nextCard() {
		if(index==cards.length) { // 카드가 더이상 없다면 null을 리턴
			return null;
		}
		return cards[index++];
	}
	
	// 카드를 섞어주는 메서드
	public void shuffle() {
		Random rnd = new Random();
		for(int i=0;i<cards.length;i++) {
			int temp = 0;
			do {
				temp = rnd.nextInt(cards.length); // 위치값을 만수로 생성
			}while(cards[temp]!=null); // 값이 null인 위치를 찾아
			cards[temp] = new Card(i); // 그곳에 객체를 생성해서 담는다.
		}
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		for(int i=0;i<cards.length;i++) {
			builder.append(cards[i].getKind() + "" + cards[i].getNumber());
			if((i+1)%13==0) builder.append("\n");
		}
		return builder.toString();
	}
}

