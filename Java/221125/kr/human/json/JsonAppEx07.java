package kr.human.json;

import java.io.IOException;

import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.MalformedURLException;
import java.net.URL;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import kr.human.vo.MovieListVO;

public class JsonAppEx07 {
	public static void main(String[] args) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		InputStreamReader isr = null;
		String urlAddress = "http://kobis.or.kr/kobisopenapi/webservice/rest/movie/searchMovieList.json";
		urlAddress += "?key=f5eef3421c602c6cb7ea224104795888";
		urlAddress += "&itemPerPage=100";
		urlAddress += "&curPage=1";
		try {
			URL url = new URL(urlAddress);
			isr = new InputStreamReader(url.openStream());
			MovieListVO movieListVO = gson.fromJson(isr, MovieListVO.class);
			int totalCount = movieListVO.getMovieListResult().getTotCnt();
			System.out.println("전체 영화 : " + totalCount + "개");
			int totalPage = (totalCount - 1) / 100 + 1;
			System.out.println(totalPage + "페이지");
			// 저장
			PrintWriter pw = new PrintWriter("MovieList_Page001.json");
			gson.toJson(movieListVO, pw);
			pw.close();
			System.out.println("저장완료");
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
