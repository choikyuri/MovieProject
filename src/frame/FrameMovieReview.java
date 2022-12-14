package frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.TitledBorder;

import movieDAO.MovieDAO;

public class FrameMovieReview extends JPanel{
	
	public FrameMovieReview() {
		// JPanel 기본 구조
		setBackground(new Color(0xFFD700));
		setLayout(null);
		setSize(600, 800);
		
		// 상단부 이미지
		ImageIcon popcon = new ImageIcon("popcon2.png");
		JLabel lblPopcon = new JLabel(popcon);
		lblPopcon.setSize(600, 280);
		lblPopcon.setLocation(0, 0);
		add(lblPopcon);
		
		// 후기 남길 영화 선택(라디오버튼)
		JPanel dis2 = new JPanel(); // 평점 패널 생성
		dis2.setLayout(new GridLayout(3, 3));
		dis2.setBounds(0, 280, 600, 220);
		
		dis2.setBorder(new TitledBorder(null, //테두리 없음 
				"평점 영화 선택", // 내용
				TitledBorder.LEADING, //양쪽정렬 
				TitledBorder.TOP, // 내용이 표시될 위치
				null, //폰트설정
				new Color(255,122,144) ));//색상
		
		JRadioButton movio1=new JRadioButton("라라랜드");
		JRadioButton movie2 = new JRadioButton("말할수없는비밀");
		JRadioButton movie3 = new JRadioButton("인사이드아웃");
		JRadioButton movie4 = new JRadioButton("겨울왕국");
		JRadioButton movie5 = new JRadioButton("당신거기있어줄래요");
		JRadioButton movie6 = new JRadioButton("스파이더맨");
		JRadioButton movie7 = new JRadioButton("어벤져스");
		JRadioButton movie8 = new JRadioButton("부산행");
		
		add(dis2);
		
		//평점 점수 받기
		JPanel dis1=new JPanel(); //라이오 버튼 한줄평 받을 패널 생성
		dis1.setSize(600,120);
		dis1.setLocation(0, 500);
		
		dis1.setBorder(new TitledBorder(null, //테두리 없음 
				"리뷰남기기", // 내용
				TitledBorder.LEADING, //양쪽정렬 
				TitledBorder.TOP, // 내용이 표시될 위치
				null, //폰트설정
				null ));//색상
		//버튼 만들기
		dis1.add(new JLabel("평점"));
		JRadioButton point1 = new JRadioButton("1점");
		JRadioButton point2 = new JRadioButton("2점");
		JRadioButton point3 = new JRadioButton("3점");
		JRadioButton point4 = new JRadioButton("4점");
		JRadioButton point5 = new JRadioButton("5점");
		//버튼 패널에 붙이기
		dis1.add(point1);
		dis1.add(point2);
		dis1.add(point3);
		dis1.add(point4);
		dis1.add(point5);
		
		//배타적 라디오버튼 구현
		ButtonGroup group2= new ButtonGroup();
		group2.add(point1);
		group2.add(point2);
		group2.add(point3);
		group2.add(point4);
		group2.add(point5);
		
		
		
		//작성자 이름
		TextField reviewName=new TextField("작성자 이름",40);
		reviewName.setBounds(0, 430, 50, 100);
		dis1.add(reviewName);
		
		// 한줄 평 입력받기
		TextField review = new TextField("한줄평을 입력해주세요.(30 글자 미만)", 50);
		review.setBounds(0, 430, 400, 100);
		dis1.add(review);
		
		JButton btn = new JButton("완료");
		btn.setBounds(400, 430, 200, 100);
		dis1.add(btn);
		btn.setEnabled(false);
		
		//Frame에 Panel 붙이기
		add(dis1);
		dis1.setVisible(false);
		
		//영화 라디오버튼 정보
		String nName[]= { "라라랜드", "말할수없는비밀", "인사이드아웃", 
				"겨울왕국", "당신거기있어줄래요", "스파이더맨", 
				"어벤져스", "부산행" };
		
		ButtonGroup group1=new ButtonGroup();
		JRadioButton movie[]=new JRadioButton[8];
		
		for(int i=0;i<nName.length;i++) {
			movie[i]=new JRadioButton(nName[i]);
			movie[i].setFont(new Font("나눔고딕코딩", Font.BOLD, 16));
			
			dis2.add(movie[i]);//패널에 붙이기
			group1.add(movie[i]);//배타적
			
			movie[i].addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					dis1.setVisible(true); //확인버튼 활성화
					
				String[] movieurl = { 
						"라라랜드.png", "말할수없는비밀.jpg", "인사이드아웃.png", 
						"겨울왕국.png", "당신거기있어줄래요.png", "스파이더맨.png", 
						"어벤져스.png", "부산행.png" };	
				
				int movieIndex = 0;
				if (e.getActionCommand().equals("라라랜드")) {
					movieIndex = 0;
				} else if (e.getActionCommand().equals("말할수없는비밀")) {
					movieIndex = 1;
				} else if (e.getActionCommand().equals("인사이드아웃")) {
					movieIndex = 2;
				} else if (e.getActionCommand().equals("겨울왕국")) {
					movieIndex = 3;
				} else if (e.getActionCommand().equals("당신거기있어줄래요")) {
					movieIndex = 4;
				} else if (e.getActionCommand().equals("스파이더맨")) {
					movieIndex = 5;
				} else if (e.getActionCommand().equals("어벤져스")) {
					movieIndex = 6;
				} else if (e.getActionCommand().equals("부산행")) {
					movieIndex = 7;
				}
			}//actionPerformed
				
		}); //Action
			
	  }//for
		
		
		review.addTextListener(new TextListener() {
			
			@Override
			public void textValueChanged(TextEvent e) {

				if(review.getText().equals("")) {
					btn.setEnabled(false);
				}else if(review.getText().length()>30) {
					btn.setEnabled(false);
				}else if(review.getText().equals("한줄평을 입력해주세요.(30 글자 미만)")) {
					btn.setEnabled(false);
				}else {
					//1~30자 범위의 평가가 있을때만 완료버튼 활성화
					btn.setEnabled(true);
				}
			}
		});
		
		//작성자 이름이라는 힌트글 제거
		reviewName.addFocusListener(new FocusListener() {
			
			@Override
			public void focusGained(FocusEvent e) {
				if(reviewName.getText().equals("작성자 이름")) {
					reviewName.setText("");
				}
				
			}

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		//작성자 이름이라는 힌트글 제거
		review.addFocusListener(new FocusListener() {
			
			@Override
			public void focusGained(FocusEvent e) {
				if(reviewName.getText().equals("한줄평을 입력해주세요.(30 글자 미만)")) {
					reviewName.setText("");
				}
				
			}

			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		//완료 버튼
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				if(point1.isSelected() ||point2.isSelected()||
						point3.isSelected()||point4.isSelected()||
						point5.isSelected()) {
					if(reviewName.getText().equals("")) {
						reviewName.setText("익명");
					}else if(reviewName.getText().equals("작성자 이름")) {
						reviewName.setText("익명");
					}
					
					//몇점인지 확인
					int num=0;
					if (point1.isSelected()) {
						num = 1;
					} else if (point2.isSelected()) {
						num = 2;
					} else if (point3.isSelected()) {
						num = 3;
					} else if (point4.isSelected()) {
						num = 4;
					} else if (point5.isSelected()) {
						num = 5;
					}
					
					for(int i=0;i<movie.length;i++) {
						if(movie[i].isSelected()) {
							new MovieDAO().inputReview(movie[i].getText(), reviewName.getText(), review.getText(), num);
						}
					}//for
					
					JOptionPane.showMessageDialog(
							null, "리뷰 작성을 완료하였습니다.");
					FrameBase.getInstance(new FrameBegin());
				}else {
					//점수를 주지 않았을 경우
					JOptionPane.showMessageDialog(
							null, "평점을 입력해주세요.");
					
				}
				
			}//actionPerfermed
		});//Action
		
		//뒤로가기 버튼
		JPanel bottomSet = new JPanel();
		bottomSet.setBounds(0, 660, 600, 100);
		bottomSet.setLayout(null);
		bottomSet.setBackground(new Color(0xFFD700));
		JButton btnBack = new JButton("처음으로");
		btnBack.setBackground(new Color(0xA6A6A6));
		btnBack.setSize(183, 87);
		btnBack.setLocation(5, 0);
		btnBack.setFont(new Font("나눔고딕코딩", Font.BOLD, 22));
		bottomSet.add(btnBack);
		
		btnBack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				FrameBase.getInstance(new FrameBegin());
			}
		});
		
		add(bottomSet, BorderLayout.SOUTH);
		
	}

}
