package kr.human.poll;

import java.io.FileReader;

import java.io.FileWriter;
import java.io.IOException;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

// json파일을 읽어 PollVO로 리턴하는 메소드 1개
// 일반 클래스에서는 서버의 절대경로를 알 수 있는 방법이 없다.
// THEREFORE, 인수를 변수로 받아 처리해야한다.
// pollVO를 받아서 JSON파일로 저장하는 메소드 1개.
public class PollUtil {
	// json을 읽어 PollVO로 리턴
	public static PollVO readPoll(String path) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		FileReader fr = null;
		PollVO pollVO = null;
		try {
			fr = new FileReader(path);
			pollVO = gson.fromJson(fr, PollVO.class);
		} catch (Exception e) {
			e.printStackTrace(); // 예외 추적
		} finally {
			try {
				if (fr != null)
					fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return pollVO;
	}

	// pollVO를 읽어 JSON파일로 저장
	public static void savePoll(String path, PollVO pollVO) {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		FileWriter fw = null;
		try {
			fw = new FileWriter(path);
			gson.toJson(pollVO, fw);
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
