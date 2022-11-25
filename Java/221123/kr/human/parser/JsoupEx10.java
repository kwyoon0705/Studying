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

public class JsoupEx10 {
	public static void main(String[] args) {
		// 1950년부터 2050년12월까지의 데이터를 저장해보자.
		Gson gson = new Gson();
		for (int year = 1950; year <= 2050; year++) {
			for (int month = 1; month <= 12; month++) {

				try {
					PrintWriter pw = new PrintWriter(String.format("%04d%02d.json", year, month));
					gson.toJson(readLunarData(year, month), pw);
					pw.close();
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
				System.out.println(String.format("%04d%02d.json", year, month) + " 저장성공!");
			}
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
