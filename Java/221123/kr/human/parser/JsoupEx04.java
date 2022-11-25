package kr.human.parser;

import java.io.File;

import java.io.IOException;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class JsoupEx04 {
	public static void main(String[] args) {
		// 파일로부터 HTML parsing하기
		// Jsoup.parse(파일객체, 인코딩, 기본URL주소).get();
		// 파일이 없을 경우를 위해 try/catch처리
		Document doc = null;
		try {
			File input = new File("src/main/resource/001.html");
			doc = Jsoup.parse(input, "UTF-8", "http://example.com/");
			Elements elements = doc.select("img");
			System.out.println("그림이 " + elements.size() + "개 있다.");
			for(Element e : elements) {
				System.out.println(e.attr("src"));
			}
		} catch (IOException e) {
			e.printStackTrace();
		} 
	}
}
