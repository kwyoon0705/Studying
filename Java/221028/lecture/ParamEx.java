class Data {
	int x;

}

public class ParamEx {
	public static void main(String[] args) {
		Data data = new Data();
		data.x = 100;
		System.out.println("메소드 호출 전 : data.x = " + data.x);
		change(data.x);
		System.out.println("메소드 호출 후 : data.x = " + data.x);
		change(data); //객체인 data를 호출
		System.out.println("메소드 호출 후 : data.x = " + data.x);
	}

	// Call By Value
	// 값이 복사되어 새로운 x라는 변수가 생겼다가 사라진다.
	static void change(int x) {
		x = 1000;
		System.out.println("change 메소드 x = " + x);
	}

// Call By Reference :참조에 의한 호출
	// 값이 복사되는것이 아니라 객체의 주소가 복사된다.
	static void change(Data d) {
		d.x = 1000;
		System.out.println("change 메소드 x = " + d.x);
	}
}
