package kr.study.poll;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


public class TripUtil {
// 1. json파일의 경로를 주면 json파일을 읽어오는 메소드
	public static TripVO readVO(String path) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create(); // gson객체 생성
		FileReader fr = null; // file reader 객체 변수만 일단은 생성.
		TripVO vo = null; // TripVO 클래스의 객체 변수만 일단 생성.
		// try-catch문 밖에 이렇게 선언해 두어야 메소드 변수로써 기능.
		// try-catch문 안에서 선언되면 로컬 변수가 되어 try-catch문 밖에서는 사용이 불가능하다.
		try {
			fr = new FileReader(path); // 파일 리더 객체에 path를 읽는 메소드를 저장.
			vo = gson.fromJson(fr, TripVO.class);
			// fr을 TripVO.class 자료형으로 읽어서 json을 불러오는 gson 메소드를 vo에 저장
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (fr != null) // fr이 null이 아니라면 fr을 종료한다.
					fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return vo;
	}
	// TripVO를 읽어 JSON파일로 저장
	public static void saveVO(String path, TripVO vo) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		FileWriter fw = null;
		try {
			fw = new FileWriter(path);
			gson.toJson(vo, fw);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fw != null)
					fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
