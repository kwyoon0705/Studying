package kr.study.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import org.jsoup.select.Elements;

public class CalendarUtil {
	public static List<LunarVO> readLunarData(int year, int month) {
		List<LunarVO> list = new ArrayList<>();
		// 음력데이터를 가져와보자
		Document doc = null;
		try {
			String urlAddress = "https://astro.kasi.re.kr/life/pageView/5?search_dp=2&search_check=G";
			urlAddress += String.format("&search_year=%04d&search_month=%02d", year, month);
			doc = Jsoup.connect(urlAddress).get();
			Elements days = doc.select("table tbody tr");
			// System.out.println("일수 : " + days.size() + "일");
			for (Element day : days) {
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

	// 클래스인데 데이터가 없이 기능만을 가지는 클래스는 모든 메소드를 static으로 만들면 편하다.
	// 1. 윤년을 판단하는 메소드
	public static boolean isLeapYear(int year) {
		return year % 400 == 0 || year % 4 == 0 && year % 100 != 0;
	}

	// 2. 해당 년/월의 마지막 날짜를 구하는 메소드.

	// 3. 해당 년/월/일 까지의 총 일수를 구하는 메소드.

	// 4. 해당 년월일의 요일을 구하는 메소드
	// 총일수를 7로 나눈 나머지에 0~6에 따라 일,월...토가 정해진다.

}
