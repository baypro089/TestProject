package com.magaki.mainFrame;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class ProductsPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * Create the panel.
	 */
	public ProductsPanel() {
		init();
	}
	public void init() {
		this.setPreferredSize(new Dimension(1030, 700));
		JLabel hello2 = new JLabel("Hello 2");
        this.add(hello2);
	}

}
