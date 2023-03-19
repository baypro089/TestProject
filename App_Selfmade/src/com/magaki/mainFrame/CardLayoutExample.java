package com.magaki.mainFrame;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class CardLayoutExample extends JFrame implements ActionListener {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel panelContainer;
    CardLayout cardLayout;
    JButton btnPanel1, btnPanel2, btnPanel3;

    public CardLayoutExample() {
        setTitle("CardLayout Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);

        panelContainer = new JPanel();
        cardLayout = new CardLayout();
        panelContainer.setLayout(cardLayout);

        JPanel panel1 = new JPanel();
        panel1.add(new JLabel("This is Panel 1"));

        JPanel panel2 = new JPanel();
        panel2.add(new JLabel("This is Panel 2"));

        JPanel panel3 = new JPanel();
        panel3.add(new JLabel("This is Panel 3"));

        panelContainer.add(panel1, "Panel 1");
        panelContainer.add(panel2, "Panel 2");
        panelContainer.add(panel3, "Panel 3");

        btnPanel1 = new JButton("Panel 1");
        btnPanel1.addActionListener(this);
        btnPanel2 = new JButton("Panel 2");
        btnPanel2.addActionListener(this);
        btnPanel3 = new JButton("Panel 3");
        btnPanel3.addActionListener(this);

        JPanel panelButtons = new JPanel();
        panelButtons.add(btnPanel1);
        panelButtons.add(btnPanel2);
        panelButtons.add(btnPanel3);

        Container container = getContentPane();
        container.add(panelContainer, BorderLayout.CENTER);
        container.add(panelButtons, BorderLayout.SOUTH);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnPanel1) {
            cardLayout.show(panelContainer, "Panel 1");
        } else if (e.getSource() == btnPanel2) {
            cardLayout.show(panelContainer, "Panel 2");
        } else if (e.getSource() == btnPanel3) {
            cardLayout.show(panelContainer, "Panel 3");
        }
    }

    public static void main(String[] args) {
        new CardLayoutExample();
    }
}
