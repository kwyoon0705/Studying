package kr.human.app;

class OuterClass {
	private int oi = 111;
	private static int os = 222;
	
	// 내부 인스턴스 클래스 : 이 클래스 내부에서만 유효하다. 외부 클래스 멤버에 자유로운 접근이 가능하다.
	class InnerClass {
		public void show() {
			System.out.println("outer instance var oi = " + oi);
			System.out.println("outer static var os = " + os);
		}
	}

//내부 정적 클래스
	static class StaticInnerClass {
		public void show() {// 외부 클래스의 정적 멤버만 접근 가능
			System.out.println("outer static var os = " + os);
		}
	}

	public void show() {
		System.out.println("outer instance var io = " + oi);
		System.out.println("outer static var os = " + os);
		// 로컬 내부 클래스 : 메소드 안에서도 클래스 선언이 가능하다. 메소드 안에서 선언한 후에만 사용가능.
		class LocalInnerClass {
			int x = 333;

			public void show() {
				System.out.println("outer instance var io = " + oi);
				System.out.println("outer static var os = " + os);
				System.out.println("local inner var x = " + x);
			}
		}
		// 로컬 내부 클래스를 사용했다.
		LocalInnerClass lic = new LocalInnerClass();
		lic.show();
	}
}

public class InnerClassEx {
	public static void main(String[] args) {
		OuterClass.StaticInnerClass sic = new OuterClass.StaticInnerClass();
		sic.show();
		System.out.println("*".repeat(50));
		OuterClass oc = new OuterClass();
		oc.show();
		System.out.println("*".repeat(50));
		//내부 인스턴스 클래스의 객체 선언을 위해서 외부 클래스의 객체를 선언하고, 
		//그 객체를 통해 내부 인스턴스 클래스에 접근 가능.
		OuterClass.InnerClass ic = oc.new InnerClass();
		ic.show();
	}
}
