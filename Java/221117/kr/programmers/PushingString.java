package kr.programmers;

public class PushingString {
	public static void main(String[] args) {
		String A = "hello";
		String B = "olhel";
		String copyA = "";
		String temp = "";
		int answer = 0;

		for (int i = 0; i < A.length(); i++) {
			temp = A.substring(A.length() - 1);
			copyA = temp + A.substring(0, A.length() - 1);
			A = copyA;
			if (A.equals(B)) {
				answer = i + 1;
				System.out.println(answer);
			}
			if (i == A.length() - 1 && !A.equals(B))
				answer = -1;
		}

	}

	public int solution(String A, String B) {
		String copyA = "";
		String temp = "";
		int answer = 0;
		if (A.equals(B)) {
			answer = 0;
		} else {
			for (int i = 0; i < A.length(); i++) {
				temp = A.substring(A.length() - 1);
				copyA = temp + A.substring(0, A.length() - 1);
				A = copyA;
				if (A.equals(B)) {
					answer = i + 1;
				}
			}
		}
		return answer;
	}
}
