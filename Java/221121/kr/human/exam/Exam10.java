package kr.human.exam;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Test;

/*
배열 회전시키기
정수가 담긴 배열 numbers와 문자열 direction가 매개변수로 주어집니다. 
배열 numbers의 원소를 direction방향으로 
한 칸씩 회전시킨 배열을 return하도록 solution 함수를 완성해주세요.

제한사항
3 ≤ numbers의 길이 ≤ 20
direction은 "left" 와 "right" 둘 중 하나입니다.

입출력 예
numbers						direction	result
[1, 2, 3]					"right"		[3, 1, 2]
[4, 455, 6, 4, -1, 45, 6]	"left"		[455, 6, 4, -1, 45, 6, 4]

입출력 예 #1
numbers 가 [1, 2, 3]이고 direction이 "right" 이므로 
오른쪽으로 한 칸씩 회전시킨 [3, 1, 2]를 return합니다.

입출력 예 #2
numbers 가 [4, 455, 6, 4, -1, 45, 6]이고 direction이 
"left" 이므로 왼쪽으로 한 칸씩 회전시킨 [455, 6, 4, -1, 45, 6, 4]를 return합니다.
*/
public class Exam10 {
	@Test
	public void test() {
		assertArrayEquals(solution(new int[] {1,2,3}, "right"), new int[] {3,1,2});
		assertArrayEquals(solution(new int[] {4, 455, 6, 4, -1, 45, 6}, "left"), new int[] {455, 6, 4, -1, 45, 6, 4});
	}
	
	public int[] solution(int[] numbers, String direction) {
        int[] answer = new int[numbers.length];
        switch (direction) {
		case "left":
			//               원본,  시작위치, 사본, 시작위치, 개수
			System.arraycopy(numbers, 1, answer, 0, numbers.length-1);
			answer[numbers.length-1] = numbers[0];
			break;
		case "right":
			System.arraycopy(numbers, 0, answer, 1, numbers.length-1);
			answer[0] = numbers[numbers.length-1];
			break;
		}
        return answer;
    }
}
