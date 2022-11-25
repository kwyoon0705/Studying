package kr.human.parser;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class JsoupEx08 {
	public static void main(String[] args) {
		// Elements(복수) 와 Element(단수)
		Document doc = null;
		try {
			String urlAddress = "https://astro.kasi.re.kr/life/pageView/5?search_dp=2&search_check=G";
			int year = 2022;
			int month = 11;
			urlAddress += String.format("&search_year=%04d&search_month=%02d", year, month);
			doc = Jsoup.connect(urlAddress).get();
			Elements elements = doc.select("table tbody tr");
			System.out.println("일수 : " + elements.size() + "일");
			for (Element day : elements) {
				System.out.println("그레고리력 : " + day.select("td").get(0).text());
				System.out.println("양력 : " + day.select("td").get(1).text());
				System.out.println("간지 : " + day.select("td").get(2).text());
				System.out.println("요일 : " + day.select("td").get(3).text());
				System.out.println("율리우스력 : " + day.select("td").get(4).text());
				System.out.println("*****************************");
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
