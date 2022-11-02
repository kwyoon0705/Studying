package kr.human.vo;

public class Human {
	private String name;
	public Human() {
		name="무명";
	}
	public Human(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return name;
	}
	
	public void thinking() {
		System.out.println("오늘 점심 뭐먹지~~~~~");
	}
	
}
