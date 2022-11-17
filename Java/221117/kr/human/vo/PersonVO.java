package kr.human.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class PersonVO implements Comparable<PersonVO> {
	private String name;
	private int age;
	private boolean gender;

	@Override
	public int compareTo(PersonVO o) {
		// 내가 크면 양수, 같으면 0. o가 크면 음수를 리턴하도록 해야한다.
		// 이름 내림차순에 이름이 같을 시 나이 내림차순
		return o.name.compareTo(this.name) == 0 ? o.age - this.age : o.name.compareTo(this.name);
	}
}
