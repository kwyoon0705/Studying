
public class VarEx {
public static void main(String[] args) {
	System.out.println("클래스변수 sv = " + Variables.sv);//클래스변수는 클래스를 통해서 접근가능하다.
	//System.out.println("인스턴스변수 iv = " + Variables.iv); 이 두개는 에러가 난다.
	//System.out.println("지역변수 lv = " + Variables.lv);
	
	Variables v =new Variables(); //객체 생성
	System.out.println("인스턴수 변수 = " + v.iv); // 객체를 생성하면 클래스에 접근가능한 참조변수v를 통해 iv는 기능한다.
	
	v.method();
}
}
