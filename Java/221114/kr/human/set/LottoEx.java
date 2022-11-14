package kr.human.set;

import java.util.Arrays;
import java.util.Random;
import java.util.TreeSet;

public class LottoEx {
	public static void main(String[] args) {
		// 배열 이용
		int lotto[] = new int[6];
		Random rnd = new Random();
		for (int i = 0; i < lotto.length; i++) {
			lotto[i] = rnd.nextInt(45) + 1;
			for (int j = 0; j < i; j++) {
				if (lotto[i] == lotto[j]) {
					i--;
					break;
				}
			}
		}
		Arrays.sort(lotto);
		System.out.println(Arrays.toString(lotto));

		// Collection Framework를 이용한 로또 번호 뽑기
		// 위와 비교했을 때 굉장히 짧다.]
		// Collection Framework 중 set을 사용
		TreeSet<Integer> setLotto = new TreeSet<>();
		while (setLotto.size() < 6)
			setLotto.add(rnd.nextInt(45) + 1);
		System.out.println(setLotto);
		
		// 스트림을 이용하여 로또 번호 뽑기를 만들었다.
		new Random().ints(6, 1, 45).sorted().forEachOrdered(LottoEx::printLotto);
		System.out.println();
	}

	public static void printLotto(int n) {
		System.out.printf("%3d", n);
	}
}
