package kr.human.map;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import kr.human.vo.HanjaVO;

public class TreeMapEx03_Hanja {
	public static void main(String[] args) {
		Map<String, HanjaVO> hanjaMap = readHanja();
		/*
		 * System.out.println(hanjaMap.size() + "개 읽음."); for (String hanja :
		 * hanjaMap.keySet()) { System.out.println(hanja + "(" +
		 * hanjaMap.get(hanja).getH() + ") : " + hanjaMap.get(hanja).getM() + " : " +
		 * hanjaMap.get(hanja).getD()); }
		 */
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("천자문 네글자를 입력하세요.(0은 종료)");
			String search = sc.nextLine();
			if (search.charAt(0) == '0')
				break;
			if (hanjaMap.containsKey(search)) {
				HanjaVO vo = hanjaMap.get(search);
				System.out.println(vo.getH() + "(" + vo.getK() + ") : " + vo.getD());
			}
		}
		sc.close();
	}

	public static Map<String, HanjaVO> readHanja() {
		Map<String, HanjaVO> hanjaMap = new TreeMap<>();
		// Files.readAllLines() : 텍스트 파일의 모든 라인을 읽어 리스트로 리턴.
		try {
			List<String> list = Files.readAllLines(Paths.get("src/main/resources/chunja2.txt"));
			for (String line : list) {
				String[] t = line.split("\\|");
				HanjaVO vo = new HanjaVO(Integer.parseInt(t[0]), t[1], t[2], t[3], t[4]);
				hanjaMap.put(vo.getK(), vo);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return hanjaMap;
	}
}
