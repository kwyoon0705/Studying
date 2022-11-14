package kr.human.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListEx05 {
	public static void main(String[] args) {
		int[] numlist = { 1, 2, 3, 4, 5, 6 };
		int n = 4;
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < numlist.length; i++) {
			list.add(numlist[i]);
		}
		list.sort(Collections.reverseOrder());
		System.out.println(list.size() + "개 : " + list);
		List<Integer> list2 = new ArrayList<Integer>();
		for (int i = 0; i < numlist.length; i++) {
			list2.add(Math.abs(n - list.get(i)));
		}
		System.out.println(list2.size() + "개 : " + list2);
		List<Integer> list3 = new ArrayList<Integer>();
		for (int i = 0; i < list.size(); i++) {
			int min = list2.get(0);
			int index = 0;
			for (int j = 0; j < list2.size(); j++) {
				if (min > list2.get(j)) {
					min = list2.get(j);
					index = j;
				}
			}
			list2.set(index, 10001);
			list3.add(list.get(index));
		}

		System.out.println(list3.size() + "개 : " + list3);
	}
}
