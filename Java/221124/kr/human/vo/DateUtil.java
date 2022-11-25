package kr.human.vo;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

// 달력을 출력할떄 사용하면 좋은 클래스
public class DateUtil {
	// 음력 데이터를 읽어오는 정적 메서드 
	public static List<LunarVO> readLunarData(int year, int month){
		List<LunarVO> list = new ArrayList<>();
		// 음력데이터를 가져와보자
		Document doc= null;
		try {
			String urlAddress="https://astro.kasi.re.kr/life/pageView/5?search_dp=2&search_check=G";
			urlAddress += String.format("&search_year=%04d&search_month=%02d", year, month);
			doc = Jsoup.connect(urlAddress).get();
			Elements days = doc.select("table tbody tr");
			// System.out.println("일수 : " + days.size() + "일");
			for(Element day : days) {
				Elements info = day.select("td"); // 1줄을 td로 구분하여
				LunarVO vo = new LunarVO(); // vo를 만들고
				// 각각의 필드에 맞춰 데이터를 넣어주고
				vo.setSolar1(info.get(0).text());
				vo.setLunar(info.get(1).text());
				vo.setGanji(info.get(2).text());
				vo.setWeek(info.get(3).text());
				vo.setSolar2(info.get(4).text());
				// 리스트에 추가하자
				list.add(vo);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}		
		return list;
	}
	// 윤년을 판단하는 정적 메서드
	public static boolean isLeapYear(int year) {
		return year%400==0 || year%4==0 && year%100!=0;
	}
	// 월의 마지막 날짜를 읽어오는 정적 메서드
	public static int getLastday(int year, int month) {
		int[] m = {31,28,31,30,31,30,31,31,30,31,30,31};
		m[1] = isLeapYear(year) ? 29 : 28;
		return m[month-1];
	}
	// 해당 년/월/일의 총일수를 구하는 정적 메서드
	public static int getSumday(int year,int month, int day) {
		int sumday = (year-1)*365 + (year-1)/4 - (year-1)/100 + (year-1)/400;
		for(int i=1;i<month;i++) sumday += getLastday(year, i);
		return sumday + day;
	}
	
	// 해당 년/월/일의 요일을 숫자로 구하는 정적 메서드
	public static int getWeekday(int year,int month, int day) {
		return getSumday(year, month, day)%7;
	}
	
	// 해당 년/월/일의 요일을 숫자로 구하는 정적 메서드
	public static String getWeekdayToString(int year,int month, int day) {
		String[] week = "일월화수목금토일".split("");
		return week[getSumday(year, month, day)%7];
	}
}
