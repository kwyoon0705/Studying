package kr.human.parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class JsoupEx02 {
	public static void main(String[] args) {
		String html = "<div><p>Lorem ipsum1.</p><p>Lorem ipsum2.</p>";
		// Document 객체는 html 문서 자체
		// 완전하지 않은 html문자열을 parsing할 때에는 parseBodyFragment()를 사용하라.
		Document doc = Jsoup.parseBodyFragment(html);
		// Element는 태그 1개
		// Elements는 태그 여러개
		Element body = doc.body(); // body태그를 가져와라.
		System.out.println(body);
		System.out.println(body.select("div p").get(0).text());
		System.out.println(body.select("div p").get(1).text());
	}
}
