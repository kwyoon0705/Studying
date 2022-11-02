import kr.human.vo.Card;
import kr.human.vo.Deck;

public class DeckTest {
	public static void main(String[] args) {
		Deck deck = new Deck();
		System.out.println(deck);
		
		System.out.println(deck.nextCard());
		System.out.println(deck.nextCard());
		System.out.println(deck.nextCard());
		
		for(int i=0;i<52;i++) {
			Card card = deck.nextCard();
			if(card==null) {
				System.out.println("더이상 카드 없어요!!!");
			}else {
				System.out.println(card);
			}
		}
	}
}
