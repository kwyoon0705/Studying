package kr.human.exam;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

/*
제곱 사이클
입력으로 어떤 수가 주어집니다. (예시: 12)
이 수의 각 자릿수의 제곱을 각각 구합니다. (예시: 1, 4)
이 수들을 모두 더합니다. (예시: 5)
한 자리 수가 나오면 그냥 제곱만 하면 됩니다. (예시: 25)
이것을 반복합니다. (예시: 12 - 5 - 25 - 29 ...)
이때, 4처럼 순환하는 경우가 있습니다. (4 - 16 - 37 - 58 - 89 - 145 - 42 - 20 - 4 [무한 반복])
여기에서 순환할 때 지나가는 수의 개수를 출력합니다. 
(4에서는 8개[4, 16, 37, 58, 89, 145, 42, 20])
100번 계산해도 순환되는 것이 나오지 않으면 '100개 이상'을 출력합니다.
input
4
output
8
*/
public class Exam01 {
	public static void main(String[] args) {
		int result = solution(14);
		if(result >= 100)
			System.out.println(result  + "개 이상");
		else
			System.out.println(result);
	}
	@Test
	public void exam01Test() {
		assertEquals(solution(4), 8);
	}
	public static int solution(int n) {
		int answer = 0; // 반복횟수
		int ori = n; // 원본 피신
		do {
			int sum = 0; // 각각의 자리 제곱의 합을 구할 변수
			int t = n; // 각각의 자리를 잘라 계산하기 위해 임시 변수에 피신
			while(t>0) { // 끝까지 반복
				sum += (t%10) * (t%10); // 뒤 1자리 잘라 제곱하고 더한다.
				t/=10; // 뒷자리 버린다.
			}
			n = sum; // 합을 다시 게산하기 위해 N에 대입
			answer++; // 횟수 증가
			// System.out.println(sum + " : " + answer);
		}while(answer<100 && n != ori); // 100회 이상이거나 또는 원래의 수가 될때까지 반복
		return answer;
	}
}
