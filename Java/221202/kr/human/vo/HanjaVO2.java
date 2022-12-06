package kr.human.vo;

import lombok.Data;

// {
// "index":1,
// "h":"天地玄黃",
// "k":"천지현황",
// "m":"天(하늘 천)地(땅 지)玄(검을 현)黃(누를 황)",
// "t":"하늘은 위에 있어 그 빛이 검고 땅은 아래 있어서 그 빛이 누르다."
// }
@Data
public class HanjaVO2 {
	private int index;
	private String h;
	private String k;
	private String m;
	private String t;
}
