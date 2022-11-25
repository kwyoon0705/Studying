package kr.human.exam;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/*
제곱수 판별하기
어떤 자연수를 제곱했을 때 나오는 정수를 제곱수라고 합니다. 
정수 n이 매개변수로 주어질 때, n이 제곱수라면 1을 아니라면 2를 return하도록 solution 함수를 완성해주세요.

제한사항
1 ≤ n ≤ 1,000,000

입출력 예
n		result
144		1
976		2

입출력 예 #1
144는 12의 제곱이므로 제곱수입니다. 따라서 1을 return합니다.

입출력 예 #2
976은 제곱수가 아닙니다. 따라서 2를 return합니다.
 */
public class Exam04 {
	@Test
	public void test() {
		assertEquals(solution(144), 1);
		assertEquals(solution(976), 2);
	}
	
	public int solution(int n) {
		/*
        // 제곱수는 약수의 개수가 홀수다.
		int answer = 0;
        for(int i=1;i<=n;i++) if(n%i==0) answer++; // 약수의 개수
        return answer%2==1 ? 1 : 2; // 약수의 개수가 홀수면 제곱수이므로 1 아니면 2
        */
		// 루트값을 구했을때 소수이하가 없다면 제곱수이다.
		return Math.sqrt(n) == (int)Math.sqrt(n) ? 1 : 2;
    }
}
