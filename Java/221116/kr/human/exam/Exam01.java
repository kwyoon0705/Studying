package kr.human.exam;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

/*
겹치는 선분의 길이
빨간색, 초록색, 파란색 선분이 x축 위에 있습니다. 
세 선분의 x좌표 시작과 끝이 [[start, end], [start, end], [start, end]] 
형태로 들어있는 2차원 배열 lines가 매개변수로 주어질 때, 
두 개 이상의 선분이 겹치는 부분의 길이를return 하도록 solution 함수를 완성해보세요.

lines가 [[0, 2], [-3, -1], [-2, 1]]일 때 그림으로 나타내면 다음과 같습니다.


선분이 두 개 이상 겹친 곳은 [-2, -1], [0, 1]로 2만큼 겹쳐있습니다.

제한사항
lines의 길이 = 3
lines의 원소의 길이 = 2
모든 선분은 길이가 1 이상입니다.
lines의 원소는 [a, b] 형태이며, a, b는 각각 양 끝점 중 하나입니다.
-100 ≤ a < b ≤ 100

입출력 예
lines						result
[[0, 1], [2, 5], [3, 9]]	2
[[-1, 1], [1, 3], [3, 9]]	0
[[0, 5], [3, 9], [1, 10]]	8

입출력 예 #1
초록색과 파란색 선분이 [2, 5], [3, 9]로 [3, 5]만큼 겹쳐있으므로 2를 return 합니다.

입출력 예 #2
겹친 선분이 없으므로 0을 return 합니다.

입출력 예 #3
빨간색과 초록색 선분 [3, 5]부분이 겹칩니다.
빨간색과 파란색 선분 [1, 5]부분이 겹칩니다.
초록색과 파란색 선분이 [3, 9]부분 겹칩니다.
따라서 8을 return 합니다.
*/
public class Exam01 {
	public static void main(String[] args) {
		// int [][]lines = {{0, 1}, {2, 5}, {3, 9}};
		// int [][]lines = {{-1, 1}, {1, 3}, {3, 9}};
		int [][]lines = {{0, 5}, {3, 9}, {1, 10}};
		int answer = 0;
		int[] points = new int[200];
		// 모든 좌표를 다 연결하려고 선택정렬 알고리즘 사용
		for(int i=0;i<lines.length-1;i++) { 
			for(int j=i+1;j<lines.length;j++) {
				int x1 = Math.max(lines[i][0], lines[j][0]); // 시작 좌표의 최대값
				int x2 = Math.min(lines[i][1], lines[j][1]); // 종료 좌표의 최소값
				// 종료좌표의 최소값이 크다면 겹치는 부분이 존재한다.
				if(x2>x1) {
					System.out.println(x2 + "-" + x1 + " : " + (x2-x1));
					for(int k=x1;k<x2;k++) {
						points[k + 100]++;
					}
				}
			}
		}
		for(int n : points) {
			if(n>=1) answer++; 
		}
		System.out.println(answer);
	}
	@Test
	public void test() {
		assertEquals(solution(new int[][] {{0, 1}, {2, 5}, {3, 9}}), 2);
		assertEquals(solution(new int[][] {{-1, 1}, {1, 3}, {3, 9}}), 0);
		assertEquals(solution(new int[][] {{0, 5}, {3, 9}, {1, 10}}), 8);
	}

	public int solution(int[][] lines) {
		int answer = 0;
		int[] points = new int[200];
		// 모든 좌표를 다 연결하려고 선택정렬 알고리즘 사용
		for(int i=0;i<lines.length-1;i++) { 
			for(int j=i+1;j<lines.length;j++) {
				int x1 = Math.max(lines[i][0], lines[j][0]); // 시작 좌표의 최대값
				int x2 = Math.min(lines[i][1], lines[j][1]); // 종료 좌표의 최소값
				// 종료좌표의 최소값이 크다면 겹치는 부분이 존재한다.
				if(x2>x1) {
					for(int k=x1;k<x2;k++) {
						points[k + 100]++;
					}
				}
			}
		}
		for(int n : points) {
			if(n>=1) answer++; 
		}
		return answer;
    }
}
