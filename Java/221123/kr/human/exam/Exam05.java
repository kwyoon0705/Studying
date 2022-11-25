package kr.human.exam;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/*
구슬을 나누는 경우의 수
머쓱이는 구슬을 친구들에게 나누어주려고 합니다. 
구슬은 모두 다르게 생겼습니다. 
머쓱이가 갖고 있는 구슬의 개수 balls와 친
구들에게 나누어 줄 구슬 개수 share이 매개변수로 주어질 때, 
balls개의 구슬 중 share개의 구슬을 고르는 
가능한 모든 경우의 수를 return 하는 solution 함수를 완성해주세요.

제한사항
1 ≤ balls ≤ 30
1 ≤ share ≤ 30
구슬을 고르는 순서는 고려하지 않습니다.
share ≤ balls

입출력 예
balls	share	result
3		2		3
5		3		10

입출력 예 #1
서로 다른 구슬 3개 중 2개를 고르는 경우의 수는 3입니다. 

입출력 예 #2
서로 다른 구슬 5개 중 3개를 고르는 경우의 수는 10입니다.
Hint
서로 다른 n개 중 m개를 뽑는 경우의 수 공식은 다음과 같습니다.
※ 공지 - 2022년 10월 11일 제한 사항 및 테스트케이스가 수정되었습니다.
*/
public class Exam05 {
	public static void main(String[] args) {
		int balls = 30;
		int share = 29;
		long upper = 1;
		long under = 1;
		for (long i = share; i > 0; i--) {
			upper *= balls--;
			System.out.println(upper);
			under *= share--;
			System.out.println(under);
		}
		System.out.println(upper / under);
	}

	@Test
	public void test() {
		assertEquals(solution(3, 2), 3);
		assertEquals(solution(5, 3), 10);
		assertEquals(solution(5, 3), 10);
	}

	public int solution(int balls, int share) {
		int upper = 1;
		int under = 1;
		for (int i = share; i > 0; i--) {
			upper *= balls--;
			under *= share--;
		}
		return upper / under;
	}
}
