package frame;

import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class FrameBase extends JFrame{
	
	private static FrameBase instance;
	
	private FrameBase(JPanel e) {

		//�ػ�
		Toolkit tk=Toolkit.getDefaultToolkit(); 
		
		//�⺻ JFrame ȯ�漳��
		setTitle("��ȭ ���� ���α׷�");
		setLayout(null);
		setBounds(((int)tk.getScreenSize().getWidth())/2-300, 
				  ((int)tk.getScreenSize().getHeight())/2-400, 
				  600, 800);
		
		add(e);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //x��ư 
	}//������
	
	//�̱������� ������� �޼���
	static public void getInstance(JPanel e) {
		instance = new FrameBase(e);
		
		instance.getContentPane().removeAll();
		instance.getContentPane().add(e);
		
		instance.revalidate();
		instance.repaint(); //�׸���
		
		
		
	}
	
	

}
