package kr.human.parser;

import java.io.IOException;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class JsoupEx03 {
	public static void main(String[] args) {
		// URL로부터 HTML parsing하기
		// Jsoup.connect("URL주소").get(); => 네트워크 연결상태에 따라 접근이 안되므로 try/catch를 해줘야한다.
		Document doc = null;
		try {
			doc = Jsoup.connect("https://www.naver.com/").get();
			String title = doc.title();
			System.out.println(title);
		} catch (IOException e) {
			e.printStackTrace();
		}
		/*
		 * Document doc = Jsoup.connect("URL주소")
  						  .data("query", "Java") // 요청값 : 변수, 값
  						  .userAgent("Mozilla") // 웹 브라우저 종류
  						  .cookie("auth", "token") // 쿠키값
  			 			  .timeout(3000) // 최대대기시간
  						  .post(); // 전송방식
		 */
	}
}
