package kr.human.json;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import kr.human.vo.DailyBoxOffice;

public class JsonAppEx06 {
	public static void main(String[] args) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		InputStreamReader isr = null;
		String urlAddress = "http://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json";
		urlAddress += "?key=f5eef3421c602c6cb7ea224104795888";
		urlAddress += "&targetDt=20221124";
		try {
			URL url = new URL(urlAddress);
			isr = new InputStreamReader(url.openStream());
			DailyBoxOffice dailyBoxOffice = gson.fromJson(isr, DailyBoxOffice.class);
			System.out.println(dailyBoxOffice.getBoxOfficeResult().getBoxofficeType());
			System.out.println(dailyBoxOffice.getBoxOfficeResult().getShowRange());
			for (DailyBoxOffice.DailyBoxOfficeList dailyBoxOfficeList : dailyBoxOffice.getBoxOfficeResult()
					.getDailyBoxOfficeList()) {
				System.out.println(dailyBoxOfficeList.getRank() + "위 " + dailyBoxOfficeList.getMovieNm());
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				isr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
