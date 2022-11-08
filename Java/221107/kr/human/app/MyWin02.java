package kr.human.app;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

//윈도우를 종료하는 클래스를 외부에 클래스로 만들어보자.
class WinClose extends WindowAdapter {

	@Override
	public void windowClosing(WindowEvent e) {
		// TODO Auto-generated method stub
		super.windowClosing(e);
		System.exit(0);// 프로그램 강제종료
	}

}

public class MyWin02 {
	public static void main(String[] args) {
		JFrame frame = new JFrame("날 종료할 수 있어"); // 윈도우 만들고
		frame.setSize(400, 300); // 윈도우 크기 지정하고
		frame.setLocationRelativeTo(null); // 나타날 위치 지정하고
		frame.setVisible(true);// 화면에 보여줘
		// 윈도우 종료지정
		/*
		 * WinClose close = new WinClose(); frame.addWindowListener(close);
		 */ // 위 코드를 줄여보자. close라는 변수를 1회만 사용해보자.
		frame.addWindowListener(new WinClose());

		frame.setVisible(true);
	}
}
//윈도우를 종료하는 클래스는 이곳 main에서만 사용한다. 굳이 외부에 만들 필요가 있을까?
// 내부에 만들어보자. 03에서 계속.
