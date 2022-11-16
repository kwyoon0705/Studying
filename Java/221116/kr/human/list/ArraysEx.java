package kr.human.list;

import java.util.Arrays;
import java.util.Random;

public class ArraysEx {
	public static void main(String[] args) {
		int[] ar1 = new int[10];
		int[] ar2 = new int[10];

		System.out.println(Arrays.toString(ar1));
		System.out.println(Arrays.toString(ar2));

		// 2로 모두 채우고 싶다.
		Arrays.fill(ar1, 2);
		Arrays.fill(ar2, 2);
		System.out.println(Arrays.toString(ar1));
		System.out.println(Arrays.toString(ar2));

		// 0~100의 난수로 채우고 싶을때는
		Random rd = new Random();
		for (int i = 0; i < ar1.length; i++)
			ar1[i] = rd.nextInt(101);
		System.out.println(Arrays.toString(ar1));
		Arrays.setAll(ar1, (i) -> rd.nextInt(101));
		System.out.println(Arrays.toString(ar1));
		Arrays.setAll(ar2, (i) -> (int) (Math.random() * 101));
		System.out.println(Arrays.toString(ar2));
	}
}
