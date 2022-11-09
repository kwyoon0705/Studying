package kr.human.app;

public class StringBufferEx {
	public static void main(String[] args) {
		StringBuffer sBuffer = new StringBuffer();
		System.out.println(sBuffer);
		System.out.println("용량 : " + sBuffer.capacity());
		System.out.println("길이 : " + sBuffer.length());
		sBuffer.append("어디가 좋을까?");
		sBuffer.append("어디가 좋을까?");
		sBuffer.append("어디가 좋을까?");
		sBuffer.append("어디가 좋을까?");
		System.out.println(sBuffer);
		System.out.println("용량 : " + sBuffer.capacity());
		System.out.println("길이 : " + sBuffer.length());
		sBuffer.reverse();
		System.out.println(sBuffer);
		sBuffer.reverse();
		System.out.println(sBuffer);
		sBuffer.replace(8, 16, "대천 키조개 삼합!");
		sBuffer.replace(26, 34, "대천 키조개 삼합!");
		System.out.println(sBuffer);
	}
}
