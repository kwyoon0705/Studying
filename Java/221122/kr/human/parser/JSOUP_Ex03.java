package kr.human.parser;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class JSOUP_Ex03 {
	public static void main(String[] args) {
		Document doc;
		try {
			// doc = Jsoup.connect("http://huggiescomics.blogspot.com/2016/09/1_34.html").get();
			doc = Jsoup.connect("http://huggiescomics.blogspot.com/2016/09/2_7.html").get();
			System.out.println(doc.title()); // head 안의 title태그안의 내용읽기
			// 모든 이미지 태그를 읽어서 src속성을 출력해 보겠다.
			Elements imgs = doc.select("div#post-body-961539150409341825 a img"); // 모든 img태그를 찾는다.
			// 몇개나 찾았을까요?
			System.out.println(imgs.size() + "개 찾음");
			int count = 0;
			for(Element e : imgs) {
				String fileName = String.format("dunk/%03d.jpg", ++count); // 저장할 파일명
				URL url = new URL(e.attr("src"));  // 원본의 위치 url 주소
				InputStream is = url.openStream(); // 입력스트림으로 만들기
				FileOutputStream fos = new FileOutputStream(fileName); // 저장할 출력스트림 만들기
				byte[] data = new byte[2048*2]; // 1번에 읽을 크기
				int length = 0; // 읽은 길이를 저장할 변수
				while((length=is.read(data))>0) { // 파일의 끝까지 읽을때까지 반복
					// 저장
					fos.write(data, 0, length);// 읽은 만큼만 저장
				}
				// 닫기
				is.close();
				fos.close();
			}
			System.out.println("저장 완료");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
