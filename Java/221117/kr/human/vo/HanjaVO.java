package kr.human.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class HanjaVO implements Comparable<HanjaVO> {
	private int index;
	private String h;
	private String k;
	private String m;
	private String d;

	@Override
	public int compareTo(HanjaVO o) {
		return this.index - o.index;
	}
}
