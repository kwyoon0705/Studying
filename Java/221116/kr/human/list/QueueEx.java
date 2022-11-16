package kr.human.list;

import java.util.LinkedList;

// Queue : First In First Out 선입선출 자료구조, 먼저 들어간 자료가 먼저 출력된다.
// 자료를 넣을때는 add,offer
// 자료를 뺄때는 pop이 아니라 poll
public class QueueEx {
	public static void main(String[] args) {
		LinkedList<String> queue = new LinkedList<>();
		queue.offer("한놈");
		queue.offer("두식이");
		queue.offer("석삼");
		queue.offer("너구리");
		System.out.println(queue.size() + " : " + queue);
		System.out.println(queue.poll()); // 먼저 들어간 놈이 먼저 나온다.
		System.out.println(queue.poll());
		System.out.println(queue.size() + " : " + queue);
		System.out.println(queue.peek());

		// 모두 꺼내기
		while (queue.size() > 0)
			System.out.println(queue.poll());
		System.out.println(queue.size() + " : " + queue);
	}
}
