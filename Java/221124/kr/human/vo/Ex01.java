package kr.human.vo;

import java.util.List;

public class Ex01 {
	public static void main(String[] args) {
		List<LunarVO> list = DateUtil.readLunarData(2022, 11);
		for(LunarVO vo : list) {
			System.out.println("양력 : " + vo.getSolarYear() + "년 " + vo.getSolarMonth() + "월 " + vo.getSolarDate() + "일");
			System.out.println("음력 : " + vo.getLunarYear() + "년 " + vo.getLunarMonth() + "월 " + vo.getLunarDate() + "일");
			System.out.println("한글간지 : " + vo.getGanjiYearK() + "년 " + vo.getGanjiMonthK() + "월 " + vo.getGanjiDateK() + "일");
			System.out.println("한자간지 : " + vo.getGanjiYearH() + "년 " + vo.getGanjiMonthH() + "월 " + vo.getGanjiDateH() + "일");
			System.out.println("요일 : " + vo.getWeekDateToInteger() + ", " + vo.getWeekDateToString());
			System.out.println("---------------------------------------------");
		}
	}
}
