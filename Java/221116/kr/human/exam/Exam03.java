package kr.human.exam;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/*
두 수의 차
정수 num1과 num2가 주어질 때, num1에서 num2를 뺀 값을 return하도록 soltuion 함수를 완성해주세요.

제한사항
-50000 ≤ num1 ≤ 50000
-50000 ≤ num2 ≤ 50000

입출력 예
num1	num2	result
2		3		-1
100		2		98

입출력 예 #1
num1이 2이고 num2가 3이므로 2 - 3 = -1을 return합니다.
입출력 예 #2
num1이 100이고 num2가 2이므로 100 - 2 = 98을 return합니다.
 */
public class Exam03 {
	@Test
	public void test() {
		assertEquals(solution(2,  3), -1);
		assertEquals(solution(100, 2), 98);
	}
	
	public int solution(int num1, int num2) {
        return num1-num2;
    }
}