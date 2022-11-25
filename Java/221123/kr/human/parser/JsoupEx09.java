package kr.human.parser;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.google.gson.Gson;

import kr.human.vo.LunarVO;

public class JsoupEx09 {
	public static void main(String[] args) {
		List<LunarVO> list202211 = readLunarData(2022, 11);
		List<LunarVO> list202212 = readLunarData(2022, 12);
		System.out.println("11월 음력데이터");
		for (LunarVO vo : list202211) {
			System.out.println(vo.getSolar1() + "(" + vo.getLunar() + ")");
		}
		System.out.println("12월 음력데이터");
		for (LunarVO vo : list202212) {
			System.out.println(vo.getSolar1() + "(" + vo.getLunar() + ")");
		}

		// list를 JSON파일로 저장해보자.
		Gson gson = new Gson();
		try {
			PrintWriter pw = new PrintWriter("2022011.json");
			gson.toJson(list202211, pw);
			pw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			PrintWriter pw = new PrintWriter("2022012.json");
			gson.toJson(list202212, pw);
			pw.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static List<LunarVO> readLunarData(int year, int month) {
		List<LunarVO> list = new ArrayList<>();
		Document doc = null;
		try {
			String urlAddress = "https://astro.kasi.re.kr/life/pageView/5?search_dp=2&search_check=G";
			urlAddress += String.format("&search_year=%04d&search_month=%02d", year, month);
			doc = Jsoup.connect(urlAddress).get();
			Elements elements = doc.select("table tbody tr");
			System.out.println("일수 : " + elements.size() + "일");
			for (Element day : elements) {
				LunarVO vo = new LunarVO();
				Elements info = day.select("td");
				vo.setSolar1(info.get(0).text());
				vo.setLunar(info.get(1).text());
				vo.setGanji(info.get(2).text());
				vo.setWeek(info.get(3).text());
				vo.setSolar2(info.get(4).text());

				list.add(vo);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;

	}
}
