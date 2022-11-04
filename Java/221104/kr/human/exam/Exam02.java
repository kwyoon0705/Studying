package kr.human.exam;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;
import java.util.Collections;

import org.junit.jupiter.api.Test;

/*
자연수 리스트(홀수와 짝수의 개수가 같음)가 주어집니다.
(예외 처리 필요) 이 리스트를 정렬해야 합니다. 
순서는 홀-짝-홀-짝-...으로 오게 해야 하며, 
홀수는 오름차순 정렬로, 짝수는 내림차순 정렬로 배치해야 합니다.

sample input
4 1 3 2 6 5

sample output
1 6 3 4 5 2
*/
public class Exam02 {
	
	@Test
	public void exam01Test() {
		assertArrayEquals(solution(new int[] {4, 1, 3, 2, 6, 5}), new int[] {1, 6, 3, 4, 5, 2});
	}
	public static int[] solution(int []ar) {
		int[] answer = new int[ar.length]; // 결과 배열의 크기는 원본 크기와 같다.
		Integer[] odd = new Integer[ar.length/2];  // 홀수 배열
		Integer[] even = new Integer[ar.length/2]; // 짝수 배열
		int index = 0;
		for(int data : ar) if(data%2==0) even[index++] = data; // 짝수 만 배열에 저장
		Arrays.sort(even, Collections.reverseOrder()); // 역순 정렬
		index = 0;
		for(int data : ar) if(data%2==1) odd[index++] = data; // 홀수만 배열에 저장
		Arrays.sort(odd); // 오름 차순 정렬
		
		index = 0;
		for(int i=0;i<even.length;i++) { // 번갈아 넣기
			answer[index] = odd[i];
			index++;
			answer[index] = even[i];
			index++;
		}
		//System.out.println(Arrays.toString(odd));
		//System.out.println(Arrays.toString(even));
		//System.out.println(Arrays.toString(answer));
		return answer;
	}
}
