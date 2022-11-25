package kr.human.vo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
// VO를 만들때 구현주면 좋은 인터페이스들
// Serializable 인터페이스는 직렬화/역직렬화가 가능하게 하는 표시 인터페이스이다. 저장/읽기/전송
// Cloneable 인터페이스는 깊은복사가 가능하게 하는 인터페이스이다.
// Comparable 인터페이스는 대소관계를 가능하게 하는 인터페이스이다.
public class PersonVO implements Serializable, Cloneable, Comparable<PersonVO> {
	private static final long serialVersionUID = 6677509397994274290L;
	private String name;
	private int age;
	private boolean gender;
	@Override
	public int compareTo(PersonVO o) { // Comparable대한 구현
		// 이름 오름차순, 나이 오름차순
		return this.name.compareTo(o.name)==0 ? this.age-o.age : this.name.compareTo(o.name);
	}
	@Override // 이클립스가 만들어 주는 코드에서 접근 지정자만 protected를 public으로 변경
	public Object clone() throws CloneNotSupportedException { // Cloneable에 대한 오버라이딩
		return super.clone();
	}
	
}
