package kr.human.parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class JsoupEx01 {
	public static void main(String[] args) {
		// 문자열로부터 파싱하기
		String html = "<html><head><title>First parse</title></head>"
				+ "<body><p>Parsed <b>HTML</b> into a doc.</p></body></html>";
		// Jsoup.parse(HTML문자열)
		Document doc = Jsoup.parse(html);
		System.out.println(doc);
		System.out.println("제목 : " + doc.title());
		System.out.println("p태그를 가져오고 싶다.");
		// document.select("CSS선택자") : 선택자로 선택된 요소를 가져온다.
		System.out.println(doc.select("p"));
		System.out.println(doc.select("p").get(0).text());
		System.out.println(doc.select("p").get(0).outerHtml());
		System.out.println(doc.select("p").get(0).html());
	}
}
