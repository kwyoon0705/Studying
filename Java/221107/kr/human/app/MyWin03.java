package kr.human.app;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

//윈도우를 종료하는 클래스를 내부에 클래스로 만들어보자.

public class MyWin03 {
	static class WinClose extends WindowAdapter {
//main에서 사용할 수 있게 static 추가
		@Override
		public void windowClosing(WindowEvent e) {
			// TODO Auto-generated method stub
			super.windowClosing(e);
			System.exit(0);// 프로그램 강제종료
		}

	}

	public static void main(String[] args) {
		JFrame frame = new JFrame("날 종료할 수 있어"); // 윈도우 만들고
		frame.setSize(400, 300); // 윈도우 크기 지정하고
		frame.setLocationRelativeTo(null); // 나타날 위치 지정하고
		frame.setVisible(true);// 화면에 보여줘
		frame.addWindowListener(new WinClose());
		// main이 static이므로 WinClose 클래스에도 static화 해줘야 접근가능하다.

		frame.setVisible(true);
	}
}
//WinClose 클래스는 단 한번 쓰니까 굳이 클래스를 만들 필요가 없다.
// 04에서 익명클래스로 만들어보자.
