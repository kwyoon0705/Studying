package kr.human.vo;

public class ClassVO {
	//private StudentVO[] students = new StudentVO[30]; // 인원이 고정이되어버린다.
	private StudentVO[] students;
	private int count; // 학생수를 저장한 변수
	
	// 생성자에서 인원을 받아서 처리한다면 인원 수에 구애받지 않는다.
	public ClassVO() {
		students = new StudentVO[30]; // 기본값 지정
	}
	public ClassVO(int count) {
		students = new StudentVO[count]; // 인원수를 받아 인원수 만큼의 배열을 할당하자!!
	}
	// 학생을 추가하는 메서드
	public void addStudent(StudentVO vo) {
		if(count < students.length) {
			students[count] = vo;
			count++; // 학생수 증가
		}else {
			System.out.println("과밀학급이라 더이상 학생을 추가할 수 없어요!!!");
		}
	}
	public void addStudent(String name, int kor, int eng, int mat, int edps) {
		addStudent(new StudentVO(name, kor, eng, mat, edps));
	}
	
	@Override
	public String toString() {
		String result = "전체 학생수 : " + count + "명\n";
		ranking(); // 석차 구하기
		for(int i=0;i<count;i++) {
			result += students[i] + "\n";
		}
		return result;
	}
	
	// 석차를 구하는 메서드
	private void ranking() {
		for(int i=0;i<count;i++) students[i].setRank(1); // 일단은 모두 1등으로 만든다.
		
		for(int i=0;i<count-1;i++) {
			for(int j=i+1;j<count;j++) {
				if(students[i].getTotal()<students[j].getTotal()) {
					students[i].setRank(students[i].getRank()+1);
				}else if(students[i].getTotal()>students[j].getTotal()) {
					students[j].setRank(students[j].getRank()+1);
				}
			}
		}
		
	}
}
