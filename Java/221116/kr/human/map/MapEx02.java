package kr.human.map;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MapEx02 {
	public static void main(String[] args) {
		Map<String, String[]> map = getChunja();
		System.out.println(map.size() + "개 한자 정보 읽기 성공");
		System.out.println("\n\n천자문 검색 프로그램 Ver 0.009");
		Scanner sc = new Scanner(System.in);
		String searchStr = "";
		do {
			System.out.println("찾고자 하는 한자를 입력하세요.");
			searchStr = sc.nextLine();
			if (map.containsKey(searchStr)) {
				System.out.println(searchStr + " : " + Arrays.toString(map.get(searchStr)));
			} else {
				System.out.println(searchStr + "는 천자문에 없는 한자입니다.");
			}
		} while (searchStr != null && !searchStr.equals(""));
		sc.close();
	}

	public static Map<String, String[]> getChunja() {
		Map<String, String[]> map = new HashMap<>();
		Scanner sc;
		try {
			sc = new Scanner(new File("src/main/resources/chunja.txt"));
			while (sc.hasNextLine()) {
				String line[] = sc.nextLine().split("\\|");
				map.put(line[2], line);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;
	}
}
