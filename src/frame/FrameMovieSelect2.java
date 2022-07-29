package frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import movieDAO.MovieDAO;
import movieVo.Movie;

public class FrameMovieSelect2 extends JPanel{
	
	public FrameMovieSelect2() {
		//JPanel 구조
		setBackground(new Color(0xFFD700));
		setLayout(null);
		setSize(600,2000);
		
		ImageIcon movie1 = new ImageIcon("당신거기있어줄래요.png");
		JButton btnMovie1 = new JButton(movie1);
		btnMovie1.setName("당신거기있어줄래요");
		
		btnMovie1.setSize(185,250);
		btnMovie1.setLocation(72,30);
		add(btnMovie1);
		
		btnMovie1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Movie movie5=new MovieDAO().searchMovie("당신거기있어줄래요");
				FrameBase.getInstance(new FrameMovieInfo(movie5));
		
			}
		});
		
		//----------------------------------------------------
		//영화2의 정보
		ImageIcon movie2 = new ImageIcon("스파이더맨.png");
		JButton btnMovie2 = new JButton(movie2);
		btnMovie2.setName("스파이더맨");

		btnMovie2.setSize(185,250);
		btnMovie2.setLocation(320,30);
		add(btnMovie2);
		
		
		btnMovie2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Movie movie6=new MovieDAO().searchMovie("스파이더맨");
				FrameBase.getInstance(new FrameMovieInfo(movie6));
				
			}
		});
		
		//-------------------------------------------
		
		//영화3의 정보
		ImageIcon movie3 = new ImageIcon("어벤져스.png");
		JButton btnMovie3 = new JButton(movie3);
		btnMovie3.setName("어벤져스");

		btnMovie3.setSize(185,250);
		btnMovie3.setLocation(72,340);
		add(btnMovie3);
		
		btnMovie3.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Movie movie7=new MovieDAO().searchMovie("어벤져스");
				FrameBase.getInstance(new FrameMovieInfo(movie7));
				
			}
		});
		
		// ------------------------------------------------
		
		//영화4의 정보
		ImageIcon movie4 = new ImageIcon("부산행.png");
		JButton btnMovie4 = new JButton(movie4);
		btnMovie4.setName("부산행");

		btnMovie4.setSize(185,250);
		btnMovie4.setLocation(320,340);
		add(btnMovie4);
		
		btnMovie4.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Movie movie8=new MovieDAO().searchMovie("부산행");
				FrameBase.getInstance(new FrameMovieInfo(movie8));

			}
		});
		
		// 하단
		JPanel bottomSet = new JPanel();

		bottomSet.setBounds(0, 660, 600, 100);
		bottomSet.setLayout(null);
		bottomSet.setBackground(new Color(0xFFD700));

		JButton btnBack = new JButton("뒤로가기");

		btnBack.setBackground(new Color(0xA6A6A6));
		btnBack.setSize(183, 87);
		btnBack.setLocation(5, 0);
		btnBack.setFont(new Font("나눔고딕코딩", Font.BOLD, 22));
		bottomSet.add(btnBack);
		
		btnBack.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				FrameBase.getInstance(new FrameMovieSelect());
				
			}
		});
		
		JButton btnNext = new JButton("처음 화면으로");

		btnNext.setBackground(new Color(0xA6A6A6));
		btnNext.setSize(183, 87);
		btnNext.setLocation(391, 0);
		btnNext.setFont(new Font("나눔고딕코딩", Font.BOLD, 22));
		bottomSet.add(btnNext);
		
		btnNext.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				FrameBase.getInstance(new FrameBegin());
				
			}
		});
		
		JButton btnBuy = new JButton("예매하기");

		btnBuy.setBackground(new Color(0xA6A6A6));
		btnBuy.setSize(183, 87);
		btnBuy.setLocation(391, 0);
		btnBuy.setFont(new Font("나눔고딕코딩", Font.BOLD, 22));
		bottomSet.add(btnBuy);
		
		btnBuy.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		
		add(bottomSet, BorderLayout.SOUTH);
	}

}
