package kr.human.parser;

import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class WebPageView {
	public static void main(String[] args) {
		String urlAddress = "https://www.naver.com";
		
		try(FileWriter fw = new FileWriter("index.html")){
			URL url = new URL(urlAddress);
			Scanner sc = new Scanner(url.openStream());
			while(sc.hasNextLine()) {
				String line = sc.nextLine();
				fw.write(line + "\n");
				System.out.println(line);
			}
			System.out.println("저장 완료!!!");
			sc.close();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
