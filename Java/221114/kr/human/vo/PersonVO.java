package kr.human.vo;

import java.util.Objects;
//TreeSet은 중복을 제거하고 정렬을 지원하는 Set이므로 정렬기준을 제시해줘야한다.
//만든 클래스에 대소관계를 비교하는 기능을 추가해줘야한다. 그래야 정렬이 가능하므로.

public class PersonVO implements Comparable<PersonVO> { // Comparable 인터페이스를 구현하여 정렬기준을 제시.
	private String name;
	private int age;
	private boolean gender;

	public PersonVO() {
		this("이름없음", 0, true);
	}

	public PersonVO(String name, int age, boolean gender) {
		super();
		this.name = name;
		this.age = age;
		this.gender = gender;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public boolean isGender() {
		return gender;
	}

	public void setGender(boolean gender) {
		this.gender = gender;
	}

	@Override
	public String toString() {
		return "PersonVO [name=" + name + ", age=" + age + ", gender=" + gender + "]";
	}

	@Override
	public int hashCode() { // 해쉬코드를 비교하는 메소드와
		return Objects.hash(age, gender, name);
	}

	@Override
	public boolean equals(Object obj) { // 객체 값이 같은지 비교하는 메소드를 통해 Set의 중복제거 기능을 구현한다.
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PersonVO other = (PersonVO) obj;
		return age == other.age && gender == other.gender && Objects.equals(name, other.name);
	}

	@Override
	public int compareTo(PersonVO o) {
		// 대소관계를 결정해주는 메소드 : 같으면 0, 앞에것이 크면 양수,
		// 뒷값이 크면 음수를 리턴하도록 만들어주어야한다.
		// 이름 오름차순
		// return this.name.compareTo(o.name);
		// 이름 내림차순
		// return o.name.compareTo(this.name);
		// 나이 오름차순
		// return this.age-o.age;
		// 나이 내림차순
		// return o.age - this.age;

		// 이름 오름차순에 이름이 같다면 나이 내림차수로 정렬되게 값을 리턴
		/*
		 * if (this.name.compareTo(o.name) == 0) return o.age - this.age; else return
		 * this.name.compareTo(o.name);
		 */
		return this.name.compareTo(o.name) == 0 ? o.age - this.age : this.name.compareTo(o.name);
	}

}
