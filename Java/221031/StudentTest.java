import kr.human.vo.StudentVO;

public class StudentTest {
	public static void main(String[] args) {
		StudentVO vo1 = new StudentVO("한사람");
		System.out.println(vo1);

		vo1.setKor(78);
		vo1.setEng(56);
		vo1.setMat(89);
		vo1.setEdps(100);
		vo1.setRank(1);
		System.out.println(vo1);
		
		StudentVO vo2 = new StudentVO("이순신",89,98,79,98);
		System.out.println(vo2);
		// 학부모가 총점과 평균만 알고싶다.
		System.out.println(vo2.getTotal() + "점");
		System.out.println(vo2.getAvg() + "점");
	}
}
