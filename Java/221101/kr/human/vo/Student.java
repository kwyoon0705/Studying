package kr.human.vo;

public class Student extends Human {
	private int stuNum;

	public Student(String name, int stuNum) {
		super(name);
		this.stuNum = stuNum;
	}

	public int getStuNum() {
		return stuNum;
	}

	public void setStuNum(int stuNum) {
		this.stuNum = stuNum;
	}

	@Override // 오버라이딩 메서드를 재정의 해서 사용한다.
	public String toString() {
		return getName() + "(" + stuNum + ")";
	}

	@Override // 기능을 변경해서 사용 ==> 오버라이딩
	public void thinking() {
		System.out.println("기말고사 잘 봐야 할텐데....");
	}
	
	// 기능을 추가
	public void study() {
		System.out.println("하늘천 땅지 검을현 누룰황 .....");
	}

	
}
