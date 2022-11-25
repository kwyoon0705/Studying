package kr.human.parser;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class CoronaEx01 {
	public static void main(String[] args) {
		// Elements(복수) 와 Element(단수)
		Document doc = null;
		try {
			doc = Jsoup.connect("https://m.news.naver.com/covid19/index").get();
			Elements elements = doc.select("#randomCategoryCollDetail>div");
			System.out.println("탭 : " + elements.size() + "개");

			String[] categories = elements.get(0).text().split(" ");
			for (int i = 0; i < categories.length; i++) {
				System.out.println("########################");
				System.out.println(categories[i]);
				System.out.println("########################");
				Element element = elements.get(i + 1);
				Elements lis = element.select("ol>li");
				for (Element li : lis) {
					System.out.println(li.text());
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
