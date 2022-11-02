// 클래스에 있는 변수들의 초기화 과정을 탐구해보자!!!
class VarInit{
	// 실행순서 : 1
	public int iv = 123;
	public static int sv = 345;
	
	{ // 인스턴스 초기화 블록 : 생성시 초기화 하지 않았다면 여기서 인스턴스 변수를 초기화 할 수 있다.
	  // 잘 사용하지 않는다. 왜? 생성자에서 초기화가 가능하기 때문이다.
		// 실행순서 : 3
		System.out.println("인스턴스 초기화 블록 시작");
		System.out.println("iv = " + iv);
		System.out.println("sv = " + sv);
		iv = 222;
		sv = 333;
	}
	static { // 정적 초기화 블록 : 정적변수들의 초기화를 할 수 있다. 
		     // 변수의 초기화 방법이 복잡해서 1줄에 못쓸경우 사용
		// 실행순서 : 2
		System.out.println("정적 초기화 블록 시작");
		System.out.println("sv = " + sv);
		sv = 444;
	}
	public VarInit() {
		// 실행순서 : 4
		System.out.println("생성자 시작");
		System.out.println("iv = " + iv);
		System.out.println("sv = " + sv);
		iv = 666;
		sv = 777;
	}
}
public class InitBlock {
	public static void main(String[] args) {
		VarInit vi = new VarInit();
		System.out.println("메인");
		System.out.println("iv = " + vi.iv);
		System.out.println("sv = " + VarInit.sv);
	}
}
