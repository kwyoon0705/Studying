package kr.human.json;

import java.io.FileNotFoundException;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import kr.human.vo.Hanja4;

public class JsonAppEx03 {
	public static void main(String[] args) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		try(FileReader fr = new FileReader("src/main/resources/data.json")){
			List<Hanja4> list = gson.fromJson(fr, new TypeToken<List<Hanja4>>() {}.getType());
			System.out.println(list.size() + "개 읽음!");
			for(Hanja4 c : list) {
				System.out.println(c.getH() + "(" + c.getK() + ") : " + c.getT());
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
