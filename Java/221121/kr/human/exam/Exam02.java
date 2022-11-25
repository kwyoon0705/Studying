package kr.human.exam;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;

import org.junit.Test;

/*
문자열 정렬하기 (1)
문자열 my_string이 매개변수로 주어질 때, 
my_string 안에 있는 숫자만 골라 
오름차순 정렬한 리스트를 return 하도록 solution 함수를 작성해보세요.

제한사항
1 ≤ my_string의 길이 ≤ 100
my_string에는 숫자가 한 개 이상 포함되어 있습니다.
my_string은 영어 소문자 또는 0부터 9까지의 숫자로 이루어져 있습니다. - - -

입출력 예
my_string	result
"hi12392"	[1, 2, 2, 3, 9]
"p2o4i8gj2"	[2, 2, 4, 8]
"abcde0"	[0]

입출력 예 #1
"hi12392"에 있는 숫자 1, 2, 3, 9, 2를 오름차순 정렬한 [1, 2, 2, 3, 9]를 return 합니다.
입출력 예 #2
"p2o4i8gj2"에 있는 숫자 2, 4, 8, 2를 오름차순 정렬한 [2, 2, 4, 8]을 return 합니다.
입출력 예 #3
"abcde0"에 있는 숫자 0을 오름차순 정렬한 [0]을 return 합니다.
*/
public class Exam02 {
	@Test
	public void test() {
		assertArrayEquals(solution("hi12392"), new int[] { 1, 2, 2, 3, 9 });
		assertArrayEquals(solution("p2o4i8gj2"), new int[] { 2, 2, 4, 8 });
		assertArrayEquals(solution("abcde0"), new int[] { 0 });
	}

	public int[] solution(String my_string) {
		// 1. 영문자만 지운다. 숫자만 남긴다.
		my_string = my_string.replaceAll("[a-zA-Z]", "");
		// 2. 1글자씩 잘라 배열로 만든다.
		String[] ar = my_string.split("");
		// 3. 길이가 배열의 크기이다.
		int[] answer = new int[ar.length];
		// 4. 정렬
		Arrays.sort(ar);
		// 5. 문자 배열이 아니라 숫자 배열이 정답이다. 숫자로 바꿔 배열에 저장
		for (int i = 0; i < ar.length; i++)
			answer[i] = ar[i].charAt(0) - '0';
		return answer;
	}
}
