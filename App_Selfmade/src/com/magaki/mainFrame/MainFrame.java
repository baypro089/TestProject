package com.magaki.mainFrame;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.magaki.login.TitlePanel;

public class MainFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		init();
	}
	
	public void init() {
		setTitle("Giao diện bán hàng");
		this.setSize(new Dimension(1280, 720));
		this.setLayout(new BorderLayout());
		
		//Thanh tieu de
		this.setUndecorated(true);
		JPanel title = new TitlePanel(this);
		// Content on the center
		JPanel center = new ContentPanel_LeftMenu();
		
		
		
		
		
		
		
		
		
		
		
		
		this.add(title, BorderLayout.NORTH);
		this.add(center, BorderLayout.CENTER);
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
}
