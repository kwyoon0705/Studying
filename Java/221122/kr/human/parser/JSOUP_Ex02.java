package kr.human.parser;

import java.io.FileWriter;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class JSOUP_Ex02 {
	public static void main(String[] args) {
		Document doc;
		try {
			doc = Jsoup.connect("http://huggiescomics.blogspot.com/2016/09/1_34.html").get();
			System.out.println(doc.title()); // head 안의 title태그안의 내용읽기
			// 모든 이미지 태그를 읽어서 src속성을 출력해 보겠다.
			Elements imgs = doc.select("div#post-body-961539150409341825 a img"); // 모든 img태그를 찾는다.
			// 몇개나 찾았을까요?
			System.out.println(imgs.size() + "개 찾음");
			FileWriter fw = new FileWriter("001.html");
			for(Element e : imgs) {
				System.out.println(e.outerHtml()); // 밖의 태그를 찾는다.
				fw.write(e.outerHtml() + "\n");
			}
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
