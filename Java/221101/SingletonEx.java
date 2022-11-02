class NonSinglton{
	
}
// 애플리케이션이 시작될 때 어떤 클래스가 최초 한번만 메모리를 할당하고(Static) 
// 그 메모리에 인스턴스를 계속 사용하는 디자인패턴. 프로그램 종료시까지 1개만 유지된다.
// 1. 자기 자신의 객체를 static멤버로 가진다.
// 2. 생성자를 private으로 만든다.
// 3. 이미 만들어진 객체를 얻는 메서드를 만든다.
class Singleton{
	private static Singleton instance = new Singleton(); // 1번
	private Singleton() { // 2번
		;
	}
	public static Singleton getInstance() {
		return instance;
	}
}

public class SingletonEx {
	public static void main(String[] args) {
		// 객체가 2개 생긴다.
		NonSinglton ns1 = new NonSinglton(); 
		NonSinglton ns2 = new NonSinglton();
		
		// 해시코드가 다르다.
		System.out.println("객체를 구분하는 해시코드 : " + ns1.hashCode());
		System.out.println("객체를 구분하는 해시코드 : " + ns2.hashCode());
		System.out.println();
		// Singleton s1 = new Singleton(); // 에러다!! 왜? 생성자가 private이라 생성자를 호출할 수 없다.
		Singleton s1 = Singleton.getInstance();
		Singleton s2 = Singleton.getInstance();
		Singleton s3 = Singleton.getInstance();
		System.out.println("객체를 구분하는 해시코드 : " + s1.hashCode());
		System.out.println("객체를 구분하는 해시코드 : " + s2.hashCode());
		System.out.println("객체를 구분하는 해시코드 : " + s3.hashCode());
	}
}
