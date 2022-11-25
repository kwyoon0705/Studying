package kr.human.vo;

import java.util.List;

import lombok.Data;

@Data
public class MovieListVO {

	/*
	 * companys: [ { companyCd: "20229422", companyNm: "㈜형설앤", }, { companyCd:
	 * "20229501", companyNm: "㈜새한프로덕션", }, ],
	 */
	@Data
	public static class Company {
		private String companyCd;
		private String companyNm;
	}

	/*
	 * directors: [ { peopleNm: "송정율" }, { peopleNm: "송요한" }, ]
	 */
	@Data
	public static class Director {
		private String peopleNm;
	}

	/*
	 * { movieCd: "20227756", movieNm: "킹덤2: 아득한 대지로", movieNmEn: "Kingdom2",
	 * prdtYear: "2022", openDt: "20221116", typeNm: "장편", prdtStatNm: "개봉",
	 * nationAlt: "미국", genreAlt: "액션,전쟁", repNationNm: "미국", repGenreNm: "액션",
	 * directors: [ { peopleNm: "사토 신스케" } ], companys: [ ], }
	 */
	@Data
	public static class Movie {
		private String movieNm;
		private String movieNmEn;
		private String openDt;
		private String nationAlt;
		private String genreAlt;
		private List<Director> directors;
		private List<Company> companys;
	}

	/*
	 * { totCnt: 93190, source: "영화진흥위원회",movieList: []
	 */
	@Data
	public static class MovieList {
		private int totCnt;
		private String source;
		private List<Movie> movieList;
	}

	private MovieList movieListResult;
}
