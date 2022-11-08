package kr.human.vo;

import java.util.Objects;

//clone()메소드를 사용하기 위해선 사전작업이 필요하다.
// 1. Cloneable 인터페이스를 implements 해줘야한다.
// 2. clone()메소드를 오버라이딩 해줘야한다.
public class PersonVO implements Cloneable {
	private String name;
	private int age;
	private boolean gender;

	public PersonVO() {
		this("", 0, false);
	}

	public PersonVO(String name, int age, boolean gender) {
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
	public int hashCode() {
		return Objects.hash(age, gender, name);
	}

	@Override
	public boolean equals(Object obj) {
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
	public String toString() {
		return name + "(" + age + "세," + (gender ? "남" : "여") + ")";
	}

	// clone()메소드를 오버라이딩 해줘야한다. == public으로 해줘야한다.
	@Override
	public Object clone() {
		Object obj = null;
		try {
			obj = super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return obj;
	}

}
