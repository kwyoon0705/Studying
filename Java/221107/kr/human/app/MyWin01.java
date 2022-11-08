package kr.human.app;

import javax.swing.JFrame;

public class MyWin01 {
	public static void main(String[] args) {
		JFrame frame = new JFrame("날 종료할 순 없어"); // 윈도우 만들고
		frame.setSize(400, 300); // 윈도우 크기 지정하고
		frame.setLocationRelativeTo(null); // 나타날 위치 지정하고
		frame.setVisible(true);// 화면에 보여줘
	}
}
// 이렇게 만들어진 윈도우는 창을 닫아도 백그라운드에서 계속 실행되고 있음.