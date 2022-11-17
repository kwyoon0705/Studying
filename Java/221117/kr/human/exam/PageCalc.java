package kr.human.exam;

public class PageCalc {
	public static void main(String[] args) {
		int sizeOfPage = 10;
		// 글의 개수별 페이지 수 구하기
		int page = 0;
		// if문 2개쓰기
		for (int i = 1; i <= 30; i++) {
			if (i % sizeOfPage == 0) {
				page = i / sizeOfPage;
			} else {
				page = i / sizeOfPage + 1;
			}
			System.out.println(i + " : " + page);
		}

		System.out.println("*******************");
		// if문 1개 쓰기
		for (int i = 1; i <= 30; i++) {
			page = i / sizeOfPage;
			if (i % sizeOfPage != 0) {
				page += 1;
			}
			System.out.println(i + " : " + page);
		}

		System.out.println("*******************");
		// 삼항연산자 사용하기
		for (int i = 1; i <= 30; i++) {
			page = i % sizeOfPage == 0 ? i / sizeOfPage : i / sizeOfPage + 1;
			System.out.println(i + " : " + page);
		}

		System.out.println("*******************");
		// 그냥 계산식으로 풀기
		for (int i = 1; i <= 30; i++) {
			page = (i - 1) / sizeOfPage + 1;
			System.out.println(i + " : " + page);
		}
	}
}
