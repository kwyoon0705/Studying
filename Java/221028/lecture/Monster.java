
public class Monster {
	int count = 0;//인스턴스변수

	static int sCount = 0; //클래스변수

	public Monster() {
		count++;
		sCount++;
	}
}
