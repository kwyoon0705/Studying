package kr.human.dao;

import java.util.List;

import kr.human.vo.TestVO;

public class DaoTest {
	public static void main(String[] args) {
		TestDAO dao = TestDAO.getInstance(); // 싱글톤 클래스의 객체 얻기.
		//System.out.println(dao.getTest("src/main/webapp/json/test68.json"));
		List<TestVO> list = dao.getTest("src/main/webapp/json/test68.json");
		for(TestVO vo : list) {
			System.out.println(vo);
		}
	}
}
