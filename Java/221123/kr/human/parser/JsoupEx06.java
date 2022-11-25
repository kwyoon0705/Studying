package kr.human.parser;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class JsoupEx06 {
	public static void main(String[] args) {
		// Elements(복수) 와 Element(단수)
		Document doc = null;
		try {
			doc = Jsoup.connect("https://movie.naver.com/movie/running/current.naver#").get();
			Elements elements = doc.select("ul.lst_detail_t1 li");
			System.out.println("상영작 목록 개수 : " + elements.size() + "개");

			// 반복
			for (Element e : elements) {
				Element element = e.select("dl dt a").get(0);
				System.out.println("상영작 제목 : " + element.text());
				try {
					System.out.println("개요 : " + e.select("dl dd").get(2).select("dl dd").get(0).text());
				} catch (Exception e1) {
					;
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
