package kr.human.app;

import kr.human.vo.Human;
import kr.human.vo.Student;

public class HumanEx {
	public static void main(String[] args) {
		Human human = new Human("박문수");
		System.out.println(human);
		human.thinking();
		
		Student student = new Student("한석봉", 1004);
		System.out.println(student);
		student.thinking();
		student.study();
		
	}
}
