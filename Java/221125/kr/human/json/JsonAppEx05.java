package kr.human.json;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import kr.human.vo.PostVO;

public class JsonAppEx05 {
	public static void main(String[] args) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		InputStreamReader isr = null;
		try {
			URL url = new URL("https://jsonplaceholder.typicode.com/posts");
			isr = new InputStreamReader(url.openStream());
			List<PostVO> list = gson.fromJson(isr, new TypeToken<List<PostVO>>() {
			}.getType());
			for (PostVO p : list) {
				System.out.println(p.getBody());
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
