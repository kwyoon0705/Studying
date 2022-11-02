package kr.human.exam;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

/*
단어 s의 가운데 글자를 반환하는 함수, solution을 만들어 보세요. 
단어의 길이가 짝수라면 가운데 두글자를 반환하면 됩니다.

재한사항
s는 길이가 1 이상, 100이하인 스트링입니다.

입출력 예
s			return
"abcde"		"c"
"qwer"		"we"
 */
public class Exam {
	public static void main(String[] args) {
		System.out.println(solution("abcde"));
		System.out.println(solution("qwer"));
	}
	// JUNIT 라이브러리를 추가해야 한다.
	@Test // 테스트를 수행할 메서드 
	// 반드시 public  void 메서드(){}
	public void test() {
		assertEquals(solution("abcde"), "c");
		assertEquals(solution("qwer"), "we");
		assertEquals(solution(""), "");
	}
	
	public static String solution(String s) {
		//return s.length()%2==0 ? s.substring(s.length()/2-1, s.length()/2+1) : s.charAt(s.length()/2)+"";
		String answer="";
		int len = s.length();
		if(len==0) {
			answer="";
		}else if(len%2==0) {
			answer = s.substring(len/2-1, len/2+1);
		}else {
			//answer = s.substring(len/2-1, len/2);
			answer = s.charAt(len/2)+"";
		}
		return answer;
	}
}
