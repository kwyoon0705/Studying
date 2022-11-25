package kr.human.lambda;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

// 메서드 1개 만으로 구성된 인터페이스는 람다식으로 표현이 가능하다.
// java.util.function 패키지에 있는 인터페이스들을 람다로 표현 가능하다.
// 리스트를 다룰때 람다를 사용하면 편리하다!!!!
public class Ex09_Lambda {
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<Integer>();
		for(int i=0;i<10;i++) list.add(new Random().nextInt(11));
		System.out.println(list);
		
		// 각각의 요소에 10을 곱하고 나누기 2를 한 결과를 출력해라!!!
		// 일반식
		for(int n : list) System.out.printf("%5d", n*10/2);
		System.out.println();
		// 람다식
		list.forEach((n)->System.out.printf("%5d", n*10/2));
		System.out.println();
		
		// 리스트의 내용을 각각 3배를 해서 바꿔라!!!!
		// 일반식
		for(int i=0;i<list.size();i++) list.set(i, list.get(i)*3);
		System.out.println(list);
		// 람다식
		list.replaceAll((n)->n*3);
		System.out.println(list);
		
		// 50이상인 수를 모두 지워라
		// 일반식
		for(int i=list.size()-1;i>=0;i--) {
			if(list.get(i)>=50) list.remove(i);
		}
		System.out.println(list);
		// 30이상인 수를 모두 지워라
		// 람다식
		list.removeIf(n -> n>=30);
		System.out.println(list);
		
		Map<String, String> map = new HashMap<String, String>();
		map.put(".-", "a");			map.put("-...", "b");
		map.put("-.-.", "c");		map.put("-..", "d");
		map.put(".", "e");			map.put("..-.", "f");
		map.put("--.", "g");		map.put("....", "h");
		map.put("..", "i");			map.put(".---", "j");
		map.put("-.-", "k");		map.put(".-..", "l");
		map.put("--", "m");			map.put("-.", "n");
		map.put("---", "o");		map.put(".--.", "p");
		map.put("--.-", "q");		map.put(".-.", "r");
		map.put("...", "s");		map.put("-", "t");
		map.put("..-", "u");		map.put("...-", "v");
		map.put(".--", "w");		map.put("-..-", "x");
		map.put("-.--", "y");		map.put("--..", "z");
		// 람다전 출력
		for(String key : map.keySet()) {
			System.out.println(map.get(key) + " : " + key);
		}
		System.out.println();
		// 람다식을 이용한 출력
		map.forEach((k,v)->{System.out.println(v + " : " + k);});
		
		
	}
}
