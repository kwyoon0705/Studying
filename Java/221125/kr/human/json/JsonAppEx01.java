package kr.human.json;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import kr.human.vo.Chunja;

public class JsonAppEx01 {
	public static void main(String[] args) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		try(FileReader fr = new FileReader("src/main/resources/chunja.json")){
			List<Chunja> list = gson.fromJson(fr, new TypeToken<List<Chunja>>() {}.getType());
			System.out.println(list.size() + "개 읽음!");
			for(Chunja c : list) {
				System.out.println(c.getIndex() + ". " + c.getH() + "(" + c.getM() + ")");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
