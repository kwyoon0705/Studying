import java.util.Arrays;
import java.util.Random;

/* -----------------------------------------------------------------------
정적 변수든 인스턴스 변수든 초기화가 간단하다면 변수 선언시 초기화 해라!!!
변수의 초기화 과정이 복잡하다면 
정적 변수 ststic{}(정적 초기화 영역)에서 초기화를 하고
인스턴스 변수는 생성자에서 초기화 해라!!!!
------------------------------------------------------------------------ */

class StaticInit{
	// 예를 들어 정적 배열에 난수로 10개를 만들어 초기화 하고 싶다.
	int iar[] = new int[10];
	static int sar[] = new int[10];
	/*
	에러다!!!! 선언부에 명령을 쓸 수가 없다. 이렇게 초기화는 안됨!!!!
	Random r = new Random();
	for(int i=0;i<iar.length;i++) {
		iar[i] = r.nextInt(101);
	}
	*/
	static {
		// 생성자에서 초기화해 보자
		Random r = new Random();
		for(int i=0;i<sar.length;i++) {
			sar[i] = r.nextInt(101); // 여기서 초기화하면 생성자 호출 후에나 적용 
		}
	}
	public StaticInit() {
		// 생성자에서 초기화해 보자
		Random r = new Random();
		for(int i=0;i<iar.length;i++) {
			iar[i] = r.nextInt(101);
			sar[i] = r.nextInt(101); // 여기서 초기화하면 생성자 호출 후에나 적용 
		}
	}
}
public class InitBlock2 {
	public static void main(String[] args) {
		// 지금 사용자가 원하는 것은 객체 생성 전에도 사용이 가능했으면 한다.
		System.out.println(Arrays.toString(StaticInit.sar));
		
		// 생성자 호출 후에는 가능하다.
		StaticInit init = new StaticInit();
		System.out.println(Arrays.toString(StaticInit.sar));
		System.out.println(Arrays.toString(init.iar));
	}
}
