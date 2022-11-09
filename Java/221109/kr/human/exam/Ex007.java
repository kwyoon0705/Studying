package kr.human.exam;
/*
3진법 뒤집기
자연수 n이 매개변수로 주어집니다. 
n을 3진법 상에서 앞뒤로 뒤집은 후, 이를 다시 10진법으로 표현한 수를 return 하도록 solution 함수를 완성해주세요.

제한사항
n은 1 이상 100,000,000 이하인 자연수입니다.

입출력 예
 n		result
 45		  7
125		229

입출력 예 #1
답을 도출하는 과정은 다음과 같습니다.
n (10진법)	n (3진법)	앞뒤 반전(3진법)	10진법으로 표현
45			1200		0021				7
따라서 7을 return 해야 합니다.

입출력 예 #2
답을 도출하는 과정은 다음과 같습니다.
n (10진법)	n (3진법)	앞뒤 반전(3진법)	10진법으로 표현
125			11122		22111				229
따라서 229를 return 해야 합니다.
 */
public class Ex007 {
	public static void main(String[] args) {
		System.out.println(convert(45, 3));
		System.out.println(convert(125, 3));
		System.out.println(convert(255, 2));
		System.out.println(convert(255, 16));
		System.out.println(convertDec("1200", 3));
		System.out.println(convertDec("FF", 16));
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println(convertDec(new StringBuffer(convert(45, 3)).reverse().toString(), 3));
		System.out.println(convertDec(new StringBuffer(convert(125, 3)).reverse().toString(), 3));
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		
		// convertDec(new StringBuffer(convert(45, 3)).reverse().toString(), 3) 를 풀어쓰면
		String t = convert(45, 3);
		StringBuffer sb = new StringBuffer(t);
		sb.reverse();
		int answer = convertDec(sb.toString(), 3);
		System.out.println("답 : " + answer);
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		
		t = Integer.toString(45, 3); // 3진법 문자열로 만들어라
		sb = new StringBuffer(t); // 버퍼 생성
		sb.reverse(); // 뒤집기
		answer = Integer.parseInt(sb.toString(), 3); // 문자열이 3진수로 되어 있으니 10진법으로 바꿔라
		System.out.println("답 : " + answer);
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		
		// 위의 식을 1줄로 쓰면
		System.out.println("답 : " + Integer.parseInt(new StringBuffer(Integer.toString(45,3)).reverse().toString(), 3));
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	}
	// n을 base 진법으로 바꾸는 메서드
	public static String convert(int n, int base) {
		String result = "";
		while(n>=base) {
			String t = "" + ((n%base)<10 ? (n%base) :(char)('A' + (n%base-10))+""); 
			result = t  + result; 
			n = n / base;
		}
		result = (n<10 ? n : (char)('A' + (n-10))+"") + result; 
		return result;
	}
	// base진수 n을 10진법으로 바꾸는 메서드
	public static int convertDec(String n, int base) {
		int result = 0;
		int t = 1;
		for(int i=n.length()-1;i>=0;i--) {
			if(n.charAt(i)>='0' && n.charAt(i)<='9') { // 10이하의 숫자라면
				result += (n.charAt(i)-'0') * t;
				// System.out.println((n.charAt(i)-'0') + " * " +  t + " = "+  (n.charAt(i)-'0') * t);
			}else {
				result += (n.charAt(i)-'A'+10) * t;
				// System.out.println(n.charAt(i)-'A'+10 + " * " +  t + " = "+  (n.charAt(i)-'A'+10) * t);
			}
			
			t *= base;
		}
		return result;
	}
}
