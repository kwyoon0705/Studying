package kr.human.parser;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class JSOUP_Ex01 {
	public static void main(String[] args) {
		Document doc;
		try {
			doc = Jsoup.connect("https://www.naver.com").get();
			System.out.println(doc.title()); // head 안의 title태그안의 내용읽기
			// 모든 이미지 태그를 읽어서 src속성을 출력해 보겠다.
			Elements imgs = doc.select("img"); // 모든 img태그를 찾는다.
			// 몇개나 찾았을까요?
			System.out.println(imgs.size() + "개 찾음");
			for(Element img : imgs) { // 이미지 태그를 하나하나 반복한다.
				// attr(속성명) : 속성의 값을 읽어온다.
				System.out.println(img.attr("src") + " : " + img.attr("alt"));
				String src = img.attr("src"); // src속성을 읽는다.
				// 속성 값이 http로 시작하고 .png로 끝난다면 이미지이다
				if(src.startsWith("http") && src.endsWith(".png")) {
					// 다운받아보자!!!
					URL url = new URL(src);
					InputStream is = url.openStream(); // URL에서 입력스트림을 만들고
					// 저장할 파일이름을 만들고
					String fileName = "naver/" + src.substring(src.lastIndexOf("/")+1);
					// 출력 스트림을 만들고
					FileOutputStream fos = new FileOutputStream(fileName);
					int len = 0;
					byte[] data = new byte[1024];
					// 저장
					while((len=is.read(data))>0) {
						fos.write(data, 0, len);
					}
					is.close();
					fos.close();
					System.out.println(fileName + "저장 완료!!!");
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
