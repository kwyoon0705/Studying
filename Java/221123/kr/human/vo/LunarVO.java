package kr.human.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class LunarVO {
	private String solar1; // 그레고리력
	private String lunar; // 음력
	private String ganji; // 간지
	private String week; // 요일
	private String solar2; // 율리우스력
}
