package programmers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NoSameNumber {
	public static void main(String[] args) {
		int[] arr = new int[] { 1, 1, 3, 3, 0, 1, 1 };
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < arr.length; i++)
			set.add(arr[i]);
		System.out.println(set);
	}

	public static int[] solution(int[] arr) {
		int[] answer = {};
		List<Integer> list = new ArrayList<>();
		list.add(arr[0]);
		for (int i = 1; i < arr.length; i++) {
			if (arr[i - 1] == arr[i])
				continue;
			list.add(arr[i]);
		}
		answer = new int[list.size()];
		for (int i = 0; i < answer.length; i++) {
			answer[i] = list.get(i);
		}
		return answer;
	}
}
