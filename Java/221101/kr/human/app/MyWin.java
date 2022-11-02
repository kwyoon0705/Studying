package kr.human.app;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MyWin extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = -9033858893204052741L;

	public MyWin() {
		super("내가 만든 첫번째 윈도우");
		setSize(600, 400); // 크기 지정
		setLocationRelativeTo(null); // 나타날 위치 지정 : 화면의 정 중앙
		setDefaultCloseOperation(EXIT_ON_CLOSE); // X를 누르면 윈도우를 닫으면 프로그램도 종료해라
		
		setLayout(new BorderLayout());// 컴포넌트 배치 관리자 지정 : 동서남북가운데로 배치하라!!!
		
		JButton button = new JButton("눌러봐!!!"); // 버튼 만들고
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(button, "왜누르고 그래!!!");
			}
		});
		add(button, BorderLayout.SOUTH); // 버튼을 윈도우에 붙이고
		
		setVisible(true); // 보여줘
	}
	
	public static void main(String[] args) {
		new MyWin();
	}
}
