import java.util.Arrays;
import java.util.Collections;
/*
숫자 짝꿍
문제 설명
두 정수 X, Y의 임의의 자리에서 공통으로 나타나는 정수 k(0 ≤ k ≤ 9)들을 이용하여 
만들 수 있는 가장 큰 정수를 두 수의 짝꿍이라 합니다
(단, 공통으로 나타나는 정수 중 서로 짝지을 수 있는 숫자만 사용합니다). 
X, Y의 짝꿍이 존재하지 않으면, 짝꿍은 -1입니다. 
X, Y의 짝꿍이 0으로만 구성되어 있다면, 짝꿍은 0입니다.

예를 들어, X = 3403이고 Y = 13203이라면, X와 Y의 짝꿍은 
X와 Y에서 공통으로 나타나는 3, 0, 3으로 만들 수 있는 가장 큰 정수인 330입니다. 
다른 예시로 X = 5525이고 Y = 1255이면 X와 Y의 짝꿍은 X와 Y에서 공통으로 나타나는 
2, 5, 5로 만들 수 있는 가장 큰 정수인 552입니다
(X에는 5가 3개, Y에는 5가 2개 나타나므로 남는 5 한 개는 짝 지을 수 없습니다.)
두 정수 X, Y가 주어졌을 때, X, Y의 짝꿍을 return하는 solution 함수를 완성해주세요.

제한사항
3 ≤ X, Y의 길이(자릿수) ≤ 3,000,000입니다.
X, Y는 0으로 시작하지 않습니다.
X, Y의 짝꿍은 상당히 큰 정수일 수 있으므로, 문자열로 반환합니다.

입출력 예
X		Y			result
"100"	"2345"		"-1"
"100"	"203045"	"0"
"100"	"123450"	"10"
"12321"	"42531"		"321"
"5525"	"1255"		"552"
 */
public class Exam {
	public static void main(String[] args) {
		System.out.println(solution("100", "2345"));
		System.out.println(solution("100", "203045"));
		System.out.println(solution("100", "123450"));
		System.out.println(solution("12321", "42531"));
		System.out.println(solution("5525", "1255"));
		System.out.println(solution("12345", "54321"));
		System.out.println(solution("87658", "58678"));
	}

	public static String solution(String X, String Y) {
		String answer = ""; // answer에 답을 저장할 예정이니 항등하게 초기화.
		char[] yy = Y.toCharArray(); // 문자열 참조변수 Y를 char타입의 배열로 만들어 yy에 저장.
		for (char c : X.toCharArray()) { // 문자열 참조변수 X를 char타입 배열로 만들고 배열 안의 임의의 char 변수 c를 둔다.
			for (int i = 0; i < yy.length; i++) {
				if (yy[i] == c) { // yy배열 요소중에 X배열의 요소와 같은게 있다면(짝이 지어졌다면)
					answer += c; // 그 요소를 미리 준비해둔 ANSWER에 저장.
					yy[i] = 'X'; // 짝을 지어서 나갔으므로 그 자리는 숫자가 아닌 아무 문자를 채워준다.
					break;
				}
			}
		}
		if (answer.length() == 0) // 만약 answer배열 길이가 0(짝이 맞는 숫자가 없었다면)
			return "-1"; // -1을 반환하고
		String[] t = answer.split(""); // 문자열 배열 참조변수 t에 answer를 스플릿하여 배열화하기 위해 저장한다.
		Arrays.sort(t, Collections.reverseOrder()); // 배열 t를 큰 수가 앞에 오게 sort하고
		answer = String.join("", t); // 배열t의 각 요소들을 join해주고 answer에 저장
		if (Integer.parseInt(answer) == 0) // 정수화한 answer가 0이라면 0을 return한다.
			return "0";
		return (String) answer; // answer를 return
	}
	// **************************************************************************************
	// 런타임 에러 발생. string연산이라 오래걸림 + 최대 300만까지 가능한 수의 범위에서 이중 for문은 300만^2이라는 최악의 수도
	// 나올 수 있음.

	
	
	//인터넷에서 긁어온거.
	public static String solution2(String X, String Y) {
		StringBuilder answer = new StringBuilder();

		int[] arrX = new int[10];
		int[] arrY = new int[10];

		countNumInArr(X, arrX); 
		countNumInArr(Y, arrY);

		for (int i = arrX.length - 1; i >= 0; i--) {
			while (arrX[i] >= 1 && arrY[i] >= 1) {
				arrX[i]--;
				arrY[i]--;

				answer.append(i);
			}
		}

		if (answer.toString().equals("")) {
			return "-1";
		} else if (answer.toString().startsWith("0")) {
			return "0";
		} else {
			return answer.toString();
		}
	}

	private static void countNumInArr(String str, int[] arr) { 
		for (int i = 0; i < str.length(); i++) {
			int index = str.charAt(i) - '0'; // char타입을 정수변환하기 위해 0을 빼주었다.

			arr[index]++;  // 이 메소드는 문자열 각 숫자가 어떤 숫자인지 파악하고 그 수를 센것이다.
		}      // ex) "15571601"이라면 0은 1개 1은 3개 5는 2개 6은 1개 7은 1개이므로
	}          // arr[] = {1,3,0,0,0,2,1,1,0,0}가 되는것이다.
}
