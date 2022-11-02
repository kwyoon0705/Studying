package kr.human.vo;

// 1명의 학생 성적을 저장하기 위한 클래스
public class StudentVO {
	private String name; // 이름
	private int kor,eng,mat,edps, rank; //국어 , 영어, 수학, 전산, 석차
	// 생성자 작성
	public StudentVO(String name) {
		this.name = name;
	}
	public StudentVO(String name, int kor, int eng, int mat, int edps) {
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
		this.edps = edps;
		this.rank = 1;
	}
	// Getter & Setter를 만든다.
	public int getKor() {
		return kor;
	}
	public void setKor(int kor) {
		this.kor = kor;
	}
	public int getEng() {
		return eng;
	}
	public void setEng(int eng) {
		this.eng = eng;
	}
	public int getMat() {
		return mat;
	}
	public void setMat(int mat) {
		this.mat = mat;
	}
	public int getEdps() {
		return edps;
	}
	public void setEdps(int edps) {
		this.edps = edps;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public String getName() {
		return name;
	}
	
	// 추가적인 메서드를 만든다.
	// 합계를 얻는 메서드
	public int getTotal() {
		return kor+eng+mat+edps;
	}
	
	public double getAvg() {
		return getTotal()/4.0;
	}
	
	@Override
	public String toString() {
		return String.format("%-5s %7d %7d %7d %7d %7d %7.2f %5d", 
				              name, kor,eng,mat, edps, getTotal(), getAvg(), rank);
	}
}






