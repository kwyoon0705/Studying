package kr.human.exam;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

/*
n의 배수 고르기
정수 n과 정수 배열 numlist가 매개변수로 주어질 때, 
numlist에서 n의 배수가 아닌 수들을 제거한 배열을 return하도록 
solution 함수를 완성해주세요.

제한사항
1 ≤ n ≤ 10,000
1 ≤ numlist의 크기 ≤ 100
1 ≤ numlist의 원소 ≤ 100,000
입출력 예
n	numlist	result
3	[4, 5, 6, 7, 8, 9, 10, 11, 12]	[6, 9, 12]
5	[1, 9, 3, 10, 13, 5]	[10, 5]
12	[2, 100, 120, 600, 12, 12]	[120, 600, 12, 12]
*/
public class Exam01 {
	@Test
	public void test() {
		assertArrayEquals(solution(3, new int[] { 4, 5, 6, 7, 8, 9, 10, 11, 12 }), new int[] { 6, 9, 12 });
		assertArrayEquals(solution(5, new int[] { 1, 9, 3, 10, 13, 5 }), new int[] { 10, 5 });
		assertArrayEquals(solution(12, new int[] { 2, 100, 120, 600, 12, 12 }), new int[] { 120, 600, 12, 12 });
	}

	public int[] solution(int n, int[] numlist) {
		int cnt = 0;
		// 배수의 개수를 구해야 정답 배열의 크기를 결정할 수 있다.
		// 1. 배수의 개수 구하기
		for (int t : numlist)
			if (t % n == 0)
				cnt++;
		// 2. 정답 배열의 크기 결정
		int[] answer = new int[cnt];
		// 3. 배수만 정답 배열에 넣는다.
		cnt = 0;
		for (int t : numlist)
			if (t % n == 0)
				answer[cnt++] = t;
		return answer;
	}
}
