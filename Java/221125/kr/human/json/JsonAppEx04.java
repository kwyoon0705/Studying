package kr.human.json;

import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import kr.human.vo.UserVO;

public class JsonAppEx04 {
	public static void main(String[] args) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		InputStreamReader isr = null;
		try {
			URL url = new URL("https://jsonplaceholder.typicode.com/todos/1");
			isr = new InputStreamReader(url.openStream());
			UserVO userVO = gson.fromJson(isr, UserVO.class);
			System.out.println(userVO);
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
