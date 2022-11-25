package kr.human.exam;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/*
합성수 찾기
약수의 개수가 세 개 이상인 수를 합성수라고 합니다. 
자연수 n이 매개변수로 주어질 때 n이하의 
합성수의 개수를 return하도록 solution 함수를 완성해주세요.

제한사항
1 ≤ n ≤ 100

입출력 예
n	result
10	5
15	8

입출력 예 #1
10 이하 합성수는 4, 6, 8, 9, 10 로 5개입니다. 따라서 5를 return합니다.

입출력 예 #1
15 이하 합성수는 4, 6, 8, 9, 10, 12, 14, 15 로 8개입니다. 따라서 8을 return합니다.
*/
public class Exam02 {
	@Test
	public void test() {
		assertEquals(solution(10), 5);
		assertEquals(solution(15), 8);
	}

	public int solution(int n) {
        int answer = 0;
        for(int i=4;i<=n;i++) { // 1, 2, 3은 합성수가 아니다.
        	// i가 합성수이면 개수 증가!!!
        	int j = 1;
        	while(i%++j != 0); // 1씩 증가하면서 나누어 떨어질때까지
        	if(i!=j) { // 나누어졌을때 나누는 수가 자기 자신이면 소수 아니면 합성수!!!
        		answer++;
        	}
        }
        return answer;
    }
}
