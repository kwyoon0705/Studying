package kr.human.list;

import java.util.Stack;

public class StackEx01 {
	public static void main(String[] args) {
		Stack<String> stack = new Stack<>(); // Last In First Out : 후입선출
		// Stack은 Vector의 자식으로 내부적으로 배열 사용
		// 넣기
		stack.push("한놈");
		stack.push("두식이");
		stack.push("석삼");
		stack.push("너구리");
		stack.push("오징어");
		System.out.println(stack.size() + " : " + stack);

		// 간보기 : peek()메소드는 스택의 가장 위의 데이터를 삭제하지 않고 가져온다.
		System.out.println(stack.peek());
		System.out.println(stack.peek());
		System.out.println(stack.peek());
		System.out.println(stack.size() + " : " + stack);

		// 스택에서 맨위의 데이터를 꺼내오고 삭제한다.
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.size() + " : " + stack);
		
		while(!stack.isEmpty()) {
			System.out.println(stack.pop());
			System.out.println(stack.size() + " : " + stack);
		}
		stack.add(0, "한놈");
		stack.add(0,"두식이");
		stack.add(0, "석삼");
		System.out.println(stack.size() + " : " + stack);
	}
}
