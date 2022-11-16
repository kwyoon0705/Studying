package kr.human.list;

import java.util.LinkedList;

// Dequeue : Double-ended Queue의 약자로 데이터의 입출력이 양방향으로 가능하다.
// 즉 stack처럼 후입선출이 가능하고 queue처럼 선입선출이 가능한 자료구조이다.
public class DequeueEx {
	public static void main(String[] args) {
		LinkedList<String> dequeue = new LinkedList<>();
		dequeue.offer("한놈");
		dequeue.offerFirst("두식이");
		dequeue.offerLast("석삼");
		System.out.println(dequeue.size() + " : " + dequeue);
		dequeue.offer("너구리");
		dequeue.offer("오징어");
		System.out.println(dequeue.size() + " : " + dequeue);
		dequeue.addFirst("육개장");
		dequeue.addLast("칠면조");
		dequeue.add(0, "팔불출");
		dequeue.add("구공탄");
		System.out.println(dequeue.size() + " : " + dequeue);
		System.out.println(dequeue.pollFirst());
		System.out.println(dequeue.pollLast());
		System.out.println(dequeue.size() + " : " + dequeue);
	}
}
