package kr.human.parser;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class JsoupEx05 {
	public static void main(String[] args) {
		// Elements(복수) 와 Element(단수)
		Document doc = null;
		try {
			doc = Jsoup.connect("https://naver.com/").get();
			// id로 찾기 : Element(단수)
			Element element = doc.getElementById("timesquare");
			System.out.println("안의 글자만 : " + element.text());
			System.out.println("안의 내용 : " + element.html());
			System.out.println("태그명 : " + element.tagName());

			// tagName으로 찾기 : Elements(복수)
			Elements elements = doc.getElementsByTag("a");
			System.out.println(elements.size() + "개의 a태그 발견됨");

			for (Element e : elements) {
				System.out.println("링크주소 : " + e.attr("href"));
				System.out.println("링크텍스트 : " + e.text());
				System.out.println("##################################");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
