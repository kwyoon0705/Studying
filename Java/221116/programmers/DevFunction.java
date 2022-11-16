package programmers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DevFunction {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new int[] { 93, 30, 55 }, new int[] { 1, 30, 5 })));
		System.out.println(
				Arrays.toString(solution(new int[] { 95, 90, 99, 99, 80, 99 }, new int[] { 1, 1, 1, 1, 1, 1 })));

	}

//먼저 시작한 기능개발이 끝나서 배포가 되어야 그 다음 기능이 같이 배포되던 어떻든간에 나갈 수 있다.
	// 선입선출. queue 자료구조
	public static int[] solution(int[] progresses, int[] speeds) {

		int day[] = new int[progresses.length];
		for (int i = 0; i < progresses.length; i++) {
			int p = progresses[i];
			while (p < 100) {
				day[i]++;
				p += speeds[i];
			}
		}
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < day.length; i++) {
			if (day[i] == 999)
				continue;
			int count = 1;
			for (int j = i + 1; j < day.length; j++) {
				if (day[i] >= day[j]) {
					count++;
					day[j] = 999;
				} else {
					break;
				}
			}
			day[i] = 999;
			list.add(count);
		}
		int[] answer = new int[list.size()];
		for (int i = 0; i < list.size(); i++)
			answer[i] = list.get(i);
		return answer;
	}
}