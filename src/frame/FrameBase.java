package frame;

import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class FrameBase extends JFrame{
	
	private static FrameBase instance;
	
	private FrameBase(JPanel e) {

		//해상도
		Toolkit tk=Toolkit.getDefaultToolkit(); 
		
		//기본 JFrame 환경설정
		setTitle("영화 예매 프로그램");
		setLayout(null);
		setBounds(((int)tk.getScreenSize().getWidth())/2-300, 
				  ((int)tk.getScreenSize().getHeight())/2-400, 
				  600, 800);
		
		add(e);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //x버튼 
	}//생성자
	
	//싱글톤기법을 사용위한 메서드
	static public void getInstance(JPanel e) {
		instance = new FrameBase(e);
		
		instance.getContentPane().removeAll();
		instance.getContentPane().add(e);
		
		instance.revalidate();
		instance.repaint(); //그리기
		
		
		
	}
	
	

}
