package com.magaki.mainFrame;

import javax.swing.*;

import com.magaki.login.TitlePanel;

import java.awt.*;

public class DisplayFrame_sub extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DisplayFrame_sub() {
		// TODO Auto-generated constructor stub
		init();
	}
	
	public void init() {
		setTitle("Giao diện bán hàng");
		this.setLayout(new BorderLayout());
		
		//Thanh tieu de
		this.setUndecorated(true);
		JPanel title = new TitlePanel(this);
		//Menu on the right
		JPanel right = new LeftMenu_cach2();
		// Content on the center
		JPanel center = new ContentPanel_LeftMenu();
		
		
		
		
		
		
		
		
		
		
		
		
		this.add(right, BorderLayout.WEST);
		this.add(title, BorderLayout.NORTH);
		this.add(center, BorderLayout.CENTER);
		this.setResizable(false);
		this.setSize(new Dimension(1280, 720));
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	public static void main(String[] args) {
		new DisplayFrame_sub();
	}

}
