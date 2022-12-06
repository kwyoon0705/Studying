package kr.study.util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// 1일이 음력데이터 1개를 저장하는 VO
@AllArgsConstructor
@NoArgsConstructor
@Data
public class LunarVO {
	private String solar1; // 그레고리력
	private String lunar; // 음력
	private String ganji; // 간지
	private String week; // 요일
	private String solar2; // 율리우스력

	// 2022년 11월 01일
	// 양력의 년도를 읽어오는 메서드
	public int getSolarYear() {
		return Integer.parseInt(solar1.substring(0, 4));
	}

	// 양력의 월을 읽어오는 메서드
	public int getSolarMonth() {
		return Integer.parseInt(solar1.substring(6, 8));
	}

	// 양력의 일을 읽어오는 메서드
	public int getSolarDate() {
		return Integer.parseInt(solar1.substring(10, 12));
	}

	// 2022년 10월 08일
	// 음력의 년도를 읽어오는 메서드
	public int getLunarYear() {
		return Integer.parseInt(lunar.substring(0, 4));
	}

	// 음력의 월을 읽어오는 메서드
	public String getLunarMonth() {
		// 윤년이라면 월 앞에 "윤"을 붙여주자.
		// 윤년은 월건이 없다.
		// 세차 월건 일진
		// 계묘(癸卯)년 을묘(乙卯)월 무인(戊寅)일 : 평년 간지
		// 계묘(癸卯)년 기묘(己卯)일 : 윤년 간지 (월건이 없음)
		if (ganji.split(" ").length == 3) {
			// 빈칸으로 split했을때 ganji가 평년은 3개로 나누어지고 윤년은 2개로 나누어진다.
			// 그러므로 ganji.length()가 3이면 평년, 그렇지않으면 윤년이다.
			return lunar.substring(6, 8);
		} else
			return "(윤)" + lunar.substring(6, 8);
	}

	// 음력의 일을 읽어오는 메서드
	public int getLunarDate() {
		return Integer.parseInt(lunar.substring(10, 12));
	}

	// 요일을 String으로 읽어오는 메서드
	public String getWeekDateToString() {
		return week.charAt(0) + "";
	}

	// 요일을 int으로 읽어오는 메서드
	public int getWeekDateToInteger() {
		String w = "일월화수목금토";
		return w.indexOf(week.charAt(0) + "");
	}

	// 임인(壬寅)년 신해(辛亥)월 무오(戊午)일
	// 윤년은 월건이 없다.
	// 세차 월건 일진
	// 계묘(癸卯)년 을묘(乙卯)월 무인(戊寅)일 : 평년 간지
	// 계묘(癸卯)년 기묘(己卯)일 : 윤년 간지 (월건이 없음)
	public String getGanjiYearK() { // 년도 한글
		return ganji.substring(0, 2);
	}

	public String getGanjiYearH() { // 년도 한자
		return ganji.substring(3, 5);
	}

	public String getGanjiMonthK() { // 월 한글
		if (ganji.split(" ").length == 3) // 윤년이 아니라면
			return ganji.substring(8, 10); // 이렇게 리턴
		else
			return ""; // 윤년이라면 아무것도 리턴하지 않는다.
	}

	public String getGanjiMonthH() { // 월 한자
		if (ganji.split(" ").length == 3)
			return ganji.substring(11, 13);
		else
			return "";
	}

	public String getGanjiDateK() { // 일 한글
		if (ganji.split(" ").length == 3)
			return ganji.substring(16, 18);
		else
			return ganji.substring(8, 10);
	}

	public String getGanjiDateH() { // 일 한자
		if (ganji.split(" ").length == 3)
			return ganji.substring(19, 21);
		else
			return ganji.substring(11, 13);
	}
}
