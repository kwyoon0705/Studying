package kr.human.exam;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

/*
핸드폰 번호 가리기
프로그래머스 모바일은 개인정보 보호를 위해 고지서를 보낼 때 고객들의 전화번호의 일부를 가립니다.
전화번호가 문자열 phone_number로 주어졌을 때, 
전화번호의 뒷 4자리를 제외한 나머지 숫자를 전부 *으로 가린 문자열을 리턴하는 함수, 
solution을 완성해주세요.

제한 조건
phone_number는 길이 4 이상, 20이하인 문자열입니다.

입출력 예
phone_number	return
"01033334444"	"*******4444"
"027778888"		"*****8888"
 */
public class Exam01 {
	@Test
	public void solutionTest() {
		assertEquals(Exam01.solution("01033334444"), "*******4444");
		assertEquals(Exam01.solution("027778888"), "*****8888");
		assertEquals(Exam01.solution2("111111-1111111"), "111111-*******");
		assertEquals(Exam01.solution2("222222-2222222"), "222222-*******");
	}
	
	public static String solution2(String jumin_number) {
		return jumin_number.substring(0, 7) + "*******";
	}
	public static String solution(String phone_number) {
		String answer = "";
		// 전체 길이보다 4글자 적게 *을 붙인다.
		for(int i=0;i<phone_number.length()-4;i++) answer += "*";
		// 뒤에서 4개 잘라서 붙이기
		answer += phone_number.substring(phone_number.length()-4);
		//System.out.println(answer);
		return answer;
	}
}
