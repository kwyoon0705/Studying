package kr.human.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import kr.human.vo.TestVO;

public class TestDAO {
//-------------------------------------------------------------------
// Singleton Pattern을 사용한 Class로 만들자.
// 1. 자기 자신의 객체를 정적 멤버로 가진다.
	private static TestDAO instance = new TestDAO();

// 2. 외부에서 객체를 만들지 못하도록 생성자를 private로 작성한다.
	private TestDAO() { // 생성자에 private를 작성하여 접근이 불가능하므로 외부에서 객체 생성이 불가.(new가 불가능)
		; // instance로 접근해야하지만 객체생성이 가능한데, instance에도 private를 접근지정 해놓았으므로
	}

// 3. 외부에서 instance 변수를 사용 가능하도록 메소드를 만들어준다.
	public static TestDAO getInstance() {
		return instance;
	}
//-------------------------------------------------------------------
// 이상 세개의 소스코드는 Singleton Pattern에 필수적으로 작성해야한다.
// DAO(Data Access Object) : 프로그램에 사용될 데이터들의 처리를 담당하는 클래스.

// 시험 문제를 읽어서 리턴해주는 메소드
	public List<TestVO> getTest(String path) {
		List<TestVO> list = null;
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		try (FileReader fr = new FileReader(path)) {
			list = gson.fromJson(fr, new TypeToken<List<TestVO>>() {
			}.getType());
			// list가 List이므로 collections 이니까 TypeToken으로 받아야한다.
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}
// 시험 문제를 저장해주는 메소드 -- 사실상 필요없음.
}
