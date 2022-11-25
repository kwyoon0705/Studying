package kr.human.parser;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class JsoupEx07 {
	public static void main(String[] args) {
		// Elements(복수) 와 Element(단수)
		Document doc = null;
		try {
			doc = Jsoup.connect(
					"https://search.daum.net/search?w=tot&DA=YZR&t__nil_searchbox=btn&sug=&sugo=&sq=&o=&q=%EC%8B%A4%EC%8B%9C%EA%B0%84+%EC%9D%B4%EC%8A%88")
					.get();
			Elements elements = doc.select("#randomCategoryCollDetail>div");
			System.out.println("탭 : " + elements.size() + "개");

			String[] categories = elements.get(0).text().split(" ");
			for (int i = 0; i < categories.length; i++) {
				System.out.println("########################");
				System.out.println(categories[i]);
				System.out.println("########################");
				Element element = elements.get(i + 1);
				Elements lis = element.select("ol>li");
				for(Element li : lis) {
					System.out.println(li.text());
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
