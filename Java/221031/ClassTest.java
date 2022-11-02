import kr.human.vo.ClassVO;
import kr.human.vo.StudentVO;

public class ClassTest {
	public static void main(String[] args) {
		ClassVO classVO = new ClassVO();
		System.out.println(classVO);

		// 학생추가
		classVO.addStudent(new StudentVO("한사람", 85, 98, 45, 87));
		classVO.addStudent(new StudentVO("두사람", 67, 45, 37, 66));
		classVO.addStudent(new StudentVO("세사람", 85, 80, 65, 88));
		classVO.addStudent("네사람", 55,66,77, 88);
		classVO.addStudent("오사람", 44,45,67,81);
		classVO.addStudent("육사람", 55,66,77, 88);
		System.out.println(classVO);
		
	}
}
