package kr.study.poll;

import lombok.Data;

@Data // getter setter 처리를 안해주면 값이 안 읽힌다.
public class TripVO {
	private String title;
	private String[] items;
	private int[] counts;

	// 총 추표수를 리턴하는 메소드 추가
	public int getTotalCount() {
		int total = 0;
		for (int i : counts)
			total += i;
		return total;
	}

	// 해당 항목의 투표가 몇 %인지를 알려주는 메소드 추가
	public String getPercent(int index) {
		if (getTotalCount() == 0) {
			return "0%";
		} else
			return String.format("%2d%%", (int) ((double) counts[index] / getTotalCount() * 100));
		// 퍼센트 값을 구하기 위해 double로 형변환 후, format에서 d를 썼으므로 그 값을 다시 int로 형변환 해준다
	}
}
