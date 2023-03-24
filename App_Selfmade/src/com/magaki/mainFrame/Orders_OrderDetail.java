package com.magaki.mainFrame;

import javax.swing.*;
import java.awt.*;

public class Orders_OrderDetail extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel category;
	private JPanel btnField;
	private JButton preBtn;
	private JButton nextBtn;
	/**
	 * Create the panel.
	 */
	public Orders_OrderDetail() {
		init();
	}
	private void init() {
		this.setLayout(new BorderLayout());
		this.setPreferredSize(new Dimension(1080, 700));
		
		category = new JPanel();
		category.setPreferredSize(new Dimension(1080, 100));
		category.setLayout(null);
		category.setBackground(Color.black);
		this.add(category, BorderLayout.NORTH);
		
		
		
		
		
		
		btnField = new JPanel();
		btnField.setPreferredSize(new Dimension(1080, 70));
		btnField.setLayout(null);
		btnField.setBackground(Color.BLUE);
		this.add(btnField, BorderLayout.SOUTH);
		
		preBtn = new JButton("PREVIOUS");
		preBtn.setBounds(70, 0, 100, 50);
		btnField.add(preBtn);
		
		nextBtn = new JButton("NEXT");
		nextBtn.setBounds(910, 0, 100, 50);
		btnField.add(nextBtn);
		
	}
}
