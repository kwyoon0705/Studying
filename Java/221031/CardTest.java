import kr.human.vo.Card;

public class CardTest {
	public static void main(String[] args) {
		// 번호가 없는 카드는 없으므로 에러.
		// 그래서 기본 생성자를 만들지 않았다.
		// Card card = new Card(); 
		
		Card c1 = new Card(1);
		Card c2 = new Card(11);
		Card c3 = new Card(26);
		Card c4 = new Card(39);
		
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c3);
		System.out.println(c4);
	}
}
