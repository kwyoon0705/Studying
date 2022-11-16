package kr.human.exam;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/*
평행
점 네 개의 좌표를 담은 이차원 배열  dots가 다음과 같이 매개변수로 주어집니다.
[[x1, y1], [x2, y2], [x3, y3], [x4, y4]]
주어진 네 개의 점을 두 개씩 이었을 때, 
두 직선이 평행이 되는 경우가 있으면 1을 없으면 0을 return 하도록 solution 함수를 완성해보세요.

제한사항
0 ≤ dots의 원소 ≤ 100
dots의 길이 = 4
dots의 원소의 길이 = 2

dots의 원소는 [x, y] 형태이며 x, y는 정수입니다.
서로 다른 두개 이상의 점이 겹치는 경우는 없습니다.
두 직선이 겹치는 경우(일치하는 경우)에도 1을 return 해주세요.
임의의 두 점을 이은 직선이 x축 또는 y축과 평행한 경우는 주어지지 않습니다.

입출력 예
dots								result
[[1, 4], [9, 2], [3, 8], [11, 6]]	1
[[3, 5], [4, 1], [2, 4], [5, 10]]	0

입출력 예 #1
점 [1, 4], [3, 8]을 잇고 [9, 2], [11, 6]를 이으면 두 선분은 평행합니다.

입출력 예 #2
점을 어떻게 연결해도 평행하지 않습니다.

※ 공지 - 2022년 9월 30일 제한 사항 및 테스트케이스가 수정되었습니다.
※ 공지 - 2022년 10월 27일 제한 사항 및 테스트케이스가 수정되었습니다.
*/
public class Exam02 {
	public static void main(String[] args) {
		// int[][] dots = {{1, 4}, {9, 2}, {3, 8},{11, 6}};
		int[][] dots = { { 3, 5 }, { 4, 1 }, { 2, 4 }, { 5, 10 } };
		int answer = 0;
		List<Double> list = new ArrayList<>();
		for (int i = 0; i < dots.length - 1; i++) {
			for (int j = i + 1; j < dots.length; j++) {
				// 기울기 = y좌표의 차이 / x좌표의 차이
				double inclination = (double) (dots[i][1] - dots[j][1]) / (dots[i][0] - dots[j][0]);
				if (list.contains(inclination)) {
					answer = 1;
				}
				list.add(inclination);
			}
		}
		System.out.println(answer);
	}

	@Test
	public void test() {
		assertEquals(solution(new int[][] { { 1, 4 }, { 9, 2 }, { 3, 8 }, { 11, 6 } }), 1);
		assertEquals(solution(new int[][] { { 3, 5 }, { 4, 1 }, { 2, 4 }, { 5, 10 } }), 0);
	}

	public int solution(int[][] dots) {
		int answer = 0;
		List<Double> list = new ArrayList<>();
		loop: for (int i = 0; i < dots.length - 1; i++) {
			for (int j = i + 1; j < dots.length; j++) {
				// 기울기 = y좌표의 차이 / x좌표의 차이
				double inclination = (double) (dots[i][1] - dots[j][1]) / (dots[i][0] - dots[j][0]);
				// list에 저장한 기울기 값중에 현재 기울기 값이 있다면 기울기가 같은 선분이 존재한다는 의미.
				if (list.contains(inclination)) {
					answer = 1; // 1을 answer에 반환하고
					break loop; // 반복문 탈출
				}
				list.add(inclination); // 나온 기울기값을 list에 넣어준다.
			}
		}
		return answer;
	}
}
