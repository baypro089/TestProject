package com.magaki.mainFrame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.magaki.mainFrame.Orders_OrderDetail.CheckboxRenderer;
import com.magaki.roundComponent.RoundedBorderBtn;


public class LeftMenu_cach2 extends JPanel implements ActionListener, MouseListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Create the panel.
	 */
	private JButton[] funcBtn = new JButton[5];
	private String [] BtnText = {"Functionality1", "Functionality2", "Functionality3", "Functionality4", "Functionality5"};
	private JButton[] funcBtn_ad = new JButton[4];
	private String [] BtnText_ad = {"Profile", "Dark mode", "Support", "Log out"};
	private int x = 10, y = 200;
	private int w = 230, h = 50;
	private JPanel leftMenu;
	private JPanel container;
	JPanel orders;
	JPanel supliers;
	public LeftMenu_cach2() {
		init();
	}
	
	private void init() {
		this.setPreferredSize(new Dimension(1280, 700));
		this.setLayout(new BorderLayout());	
		//Tao left menu
		leftMenu = new JPanel(null);
		leftMenu.setBackground(Color.white);
		leftMenu.setPreferredSize(new Dimension(250, 700));
		//logo
		JLabel logo = new JLabel();
		logo.setIcon(new ImageIcon("Image/—Pngtree—rice mealtime rice_7390543.png"));
		logo.setBounds(50, 20, 130, 130);	
		JSeparator separator1 = new JSeparator(SwingConstants.HORIZONTAL);
		separator1.setBounds(x, y-10, w, 1);	
		for(int i = 0; i < BtnText.length; i++) {
			funcBtn[i] = new RoundedBorderBtn(BtnText[i]);
			funcBtn[i].setBounds(x, y, w, h);
			funcBtn[i].setBackground(Color.white);
			funcBtn[i].setForeground(Color.black);
			funcBtn[i].setFocusPainted(false);
			funcBtn[i].setBorder(null);
			funcBtn[i].setFont(new Font("Arial", Font.BOLD, 13));
			funcBtn[i].addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					for(int j = 0; j < BtnText.length; j++) {
						if(funcBtn[j].getBackground().getRGB() == Color.LIGHT_GRAY.getRGB()) {
							funcBtn[j].setBackground(Color.white);
							funcBtn[j].setEnabled(true);
						}
					}
					for(int i = 0; i < BtnText.length; i++) {
						if(e.getSource() == funcBtn[i]) {
							funcBtn[i].setBackground(Color.LIGHT_GRAY);
							funcBtn[i].setEnabled(false);
						}
					}
				}				
			});
			funcBtn[i].addActionListener(this);
			funcBtn[i].addMouseListener(this);
			leftMenu.add(funcBtn[i]);
			y = y + h;
		}	
		JSeparator separator2 = new JSeparator(SwingConstants.HORIZONTAL);
		separator2.setBounds(x, y+ 10, w, 1);
		y = y + 20;	
		for(int i = 0; i < BtnText_ad.length; i++) {
			funcBtn_ad[i] = new RoundedBorderBtn(BtnText_ad[i]);
			funcBtn_ad[i].setBounds(x, y, w, h);
			funcBtn_ad[i].setBackground(Color.white);
			funcBtn_ad[i].setForeground(Color.black);
			funcBtn_ad[i].setFocusPainted(false);
			funcBtn_ad[i].setFont(new Font("Arial", Font.BOLD, 13));
			funcBtn_ad[i].setBorder(null);
			leftMenu.add(funcBtn_ad[i]);
			y = y + h;
		}	
		JSeparator separator3 = new JSeparator(SwingConstants.HORIZONTAL);
		separator3.setBounds(x, y + 10, w, 1);	
		//version name
		JLabel verName = new JLabel("patch_v1.1_openbeta");
		verName.setBounds(x	, y + 12, w, 15);
		leftMenu.add(logo);
		leftMenu.add(separator1);
		leftMenu.add(separator2);
		leftMenu.add(separator3);
		leftMenu.add(verName);
		// end left menu
		//Tao content panel
		container = new JPanel(new BorderLayout());
		container.setPreferredSize(new Dimension(1280-250, 700));
		
		
		orders = new OrdersPanel();
		//orders.setVisible(false);
		container.add(orders, BorderLayout.CENTER);
		supliers = new SuplierPanel();
		//supliers.setVisible(false);
		container.add(supliers, BorderLayout.CENTER);
		
		
		
		
		
		
		this.add(leftMenu, BorderLayout.WEST);
		this.add(container, BorderLayout.CENTER);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		for(int i = 0; i < BtnText.length; i++) {
			if(e.getSource() == funcBtn[i] && funcBtn[i].getText().equalsIgnoreCase("Functionality1")) {
				//JPanel orders = new OrdersPanel();
				//container.add(orders, BorderLayout.CENTER);
				//container.revalidate();
				orders.setVisible(true);
				supliers.setVisible(false);
			}
			else if(e.getSource() == funcBtn[i] && funcBtn[i].getText().equalsIgnoreCase("Functionality2")) {
				//JPanel supliers = new SuplierPanel();
				//container.add(supliers, BorderLayout.CENTER);
				//container.revalidate();
				supliers.setVisible(true);
				orders.setVisible(false);
			}
		}	
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		 
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		for(int i = 0; i < BtnText.length; i++) {
			if(e.getSource() == funcBtn[i]) {
				funcBtn[i].setBackground(Color.yellow);
			}
			if(!funcBtn[i].isEnabled()) {
				funcBtn[i].setBackground(Color.LIGHT_GRAY);
			}
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		for(int i = 0; i < BtnText.length; i++) {
			if(e.getSource() == funcBtn[i]) {
				funcBtn[i].setBackground(Color.white);
			}
		}
	}
	
	
}
