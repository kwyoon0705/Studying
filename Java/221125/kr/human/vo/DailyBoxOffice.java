package kr.human.vo;

import java.util.List;

import lombok.Data;

@Data
public class DailyBoxOffice {
	private BoxOfficeResult boxOfficeResult;

	@Data
	public static class BoxOfficeResult {
		private String boxofficeType;
		private String showRange;
		private List<DailyBoxOfficeList> dailyBoxOfficeList;
	}

	@Data
	public static class DailyBoxOfficeList {
		private int rank;
		private String movieNm;
		private String openDt;
		private int audiAcc;
	}
}
