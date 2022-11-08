package kr.human.app;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class MyWin04 {

	public static void main(String[] args) {
		JFrame frame = new JFrame("날 종료할 수 있어"); // 윈도우 만들고
		frame.setSize(400, 300); // 윈도우 크기 지정하고
		frame.setLocationRelativeTo(null); // 나타날 위치 지정하고
		frame.setVisible(true);// 화면에 보여줘

		// 익명 내부 클래스 : 재사용이 불가능. 어디서 상속도 객체참조도 안되고 여기서만 쓰이고 끝.
		frame.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				super.windowClosing(e);
				System.exit(0);
			}

		});
		// 이런식으로 단발적으로 사용할 때에는 익명클래스로 만드는 것이 좋다.
		// 관리가 용이하고 작성에도 편리하다.
		frame.setVisible(true);
	}
}
