package kr.human.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// 1일이 음력데이터 1개를 저장하는 VO
@AllArgsConstructor
@NoArgsConstructor
@Data
public class LunarVO {
	private String solar1; // 그레고리력
	private String lunar;  // 음력
	private String ganji;  // 간지
	private String week;   // 요일
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
	public int getLunarMonth() {
		return Integer.parseInt(lunar.substring(6, 8));
	}
	// 음력의 일을 읽어오는 메서드
	public int getLunarDate() {
		return Integer.parseInt(lunar.substring(10, 12));
	}
	
	// 요일을 String으로  읽어오는 메서드
	public String getWeekDateToString() {
		return week.charAt(0)+"";
	}
	// 요일을 int으로  읽어오는 메서드
	public int getWeekDateToInteger() {
		String w = "일월화수목금토";
		return w.indexOf(week.charAt(0)+"");
	}
	
	// 임인(壬寅)년 신해(辛亥)월 무오(戊午)일
	public String getGanjiYearK() { // 년도 한글
		return ganji.substring(0,2);
	}
	
	public String getGanjiYearH() { // 년도 한자
		return ganji.substring(3,5);
	}
	
	public String getGanjiMonthK() { // 월 한글
		return ganji.substring(8,10);
	}
	
	public String getGanjiMonthH() { // 월 한자
		return ganji.substring(11,13);
	}
	
	public String getGanjiDateK() { // 일 한글
		return ganji.substring(16,18);
	}
	
	public String getGanjiDateH() { // 일 한자
		return ganji.substring(19,21);
	}
}
