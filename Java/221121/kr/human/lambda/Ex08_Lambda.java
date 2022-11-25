package kr.human.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.UnaryOperator;

// 메서드 1개 만으로 구성된 인터페이스는 람다식으로 표현이 가능하다.
// java.util.function 패키지에 있는 인터페이스들을 람다로 표현 가능하다.

// 매개변수의 타입과 반환타입이 일치하는 함수형 인터페이스
// UnaryOperator<T>  :  인수 1개 리턴 1개
// BinaryOperator<T> :  인수 2개 리턴 1개
public class Ex08_Lambda {
	public static void main(String[] args) {
		// 인수의 값을 2배로 돌려주는 람다식
		Function<Integer, Integer> doubleValue = (a)->2*a;
		UnaryOperator<Integer> doubleValue2 = (a)->2*a;
		for(int i=1;i<10;i++) {
			System.out.println(doubleValue.apply(i) + " : " + doubleValue2.apply(i));
		}
		
		// 리스트에 저장된 숫자 중에서 최대값과 최소값을 구해서 출력하시오!!!
		List<Integer> list = new ArrayList<>();
		for(int i=0;i<10;i++) list.add((int)(Math.random()*101));
		System.out.println(list);
		
		int max = list.get(0), min= list.get(0);
		for(int i : list) {
			if(i>max) max = i;
			if(i<min) min = i;
		}
		System.out.println(max + ", " + min);
		
		max = list.get(0); min= list.get(0);
		for(int i : list) {
			max = Math.max(max, i);
			min = Math.min(min, i);
		}
		System.out.println(max + ", " + min);
		
		// 람다를 써보자!!
		BinaryOperator<Integer> maxFn = (n, m)->n<m ? m : n;
		BinaryOperator<Integer> minFn = (n, m)->n>m ? m : n;
		max = list.get(0); min= list.get(0);
		for(int i : list) {
			max = maxFn.apply(max, i);
			min = minFn.apply(min, i);
		}
		System.out.println(max + ", " + min);
	}
}
