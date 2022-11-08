package kr.human.exception;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class Ex004 {
	public static void main(String[] args) {
		String urlAddress = "https://www.naver.com";

		try {
			URL url = new URL(urlAddress);
			Scanner sc = new Scanner(url.openStream(), "UTF-8");
			while (sc.hasNextLine()) {
				System.out.println(sc.nextLine());
			}
			sc.close();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
