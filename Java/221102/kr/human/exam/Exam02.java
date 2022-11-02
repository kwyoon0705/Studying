package kr.human.exam;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

/*
소수 만들기
주어진 숫자 중 3개의 수를 더했을 때 소수가 되는 경우의 개수를 구하려고 합니다. 
숫자들이 들어있는 배열 nums가 매개변수로 주어질 때, 
nums에 있는 숫자들 중 서로 다른 3개를 골라 더했을 때 
소수가 되는 경우의 개수를 return 하도록 solution 함수를 완성해주세요.

제한사항
nums에 들어있는 숫자의 개수는 3개 이상 50개 이하입니다.
nums의 각 원소는 1 이상 1,000 이하의 자연수이며, 중복된 숫자가 들어있지 않습니다.

입출력 예
nums		result
[1,2,3,4]	1
[1,2,7,6,4]	4

입출력 예 #1
[1,2,4]를 이용해서 7을 만들 수 있습니다.

입출력 예 #2
[1,2,4]를 이용해서 7을 만들 수 있습니다.
[1,4,6]을 이용해서 11을 만들 수 있습니다.
[2,4,7]을 이용해서 13을 만들 수 있습니다.
[4,6,7]을 이용해서 17을 만들 수 있습니다.
 */
public class Exam02 {
	@Test
	public void examTest() {
		assertEquals(solution(new int[] { 1, 2, 3, 4 }), 1);
		assertEquals(solution(new int[] { 1, 2, 7, 6, 4 }), 4);
		assertEquals(solution(new int[] { 1, 2, 7, 6, 4, 9, 13, 16 }), 17);
	}

	public static boolean isPrime(int n) { // 소수임을 판단하는 메소드
		for (int i = 2; i * i <= n; i++) { // i * i는 어째서??? 연산 경우의 수 줄이는 용도인가?
			if (n % i == 0)
				return false;
		}
		return true;
	}

	public static int solution(int[] nums) {
		int answer = 0;
		for (int i = 0; i < nums.length - 2; i++)
			for (int j = i + 1; j < nums.length - 1; j++)
				for (int k = j + 1; k < nums.length; k++) {
					int primeNum = nums[i] + nums[j] + nums[k];
					if (isPrime(primeNum))
						answer++;
					/*
					 * int a = 1; while (primeNum % ++a != 0); //a로 primeNum이 나누어 떨어질 때 while문 탈출 if
					 * (primeNum == a) { //while문을 탈출 했을때 a가 primeNum과 같다면 나를 answer++;
					 */
				}
		System.out.println(answer);
		return answer;
	}
}
