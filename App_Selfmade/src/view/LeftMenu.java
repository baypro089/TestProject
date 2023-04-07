package view;
import javax.swing.*;

import com.magaki.mainFrame.OrdersPanel;
import com.magaki.mainFrame.Orders_OrderDetail;
import com.magaki.mainFrame.PhieuNhap_ctPNPanel;

import controller.food_action;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class LeftMenu extends JPanel implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//private static final long serialVersionUID = 1L;
	public JButton[] funcBtn = new JButton[8];
	String [] BtnText = {"Đơn hàng", "Nhập hàng", "Món ăn", "Nguyên liệu", "Công thức"
			, "Tài khoản", "Nhân viên", "Nhà cung cấp"};
	int x = 0, y = 180;
	int w = 200, h = 65;
	GiaoDien a;
	public LeftMenu() {
		
		init();
	}
	private void init() {
		this.setPreferredSize(new Dimension(200, 700));
		this.setLayout(null);
		food_action action = new food_action(this);

		for(int i = 0; i < BtnText.length; i++) {
			funcBtn[i] = new JButton(BtnText[i]);
			funcBtn[i].setBounds(x, y, w, h);
			funcBtn[i].setBackground(Color.darkGray);
			funcBtn[i].setForeground(Color.white);
			funcBtn[i].setOpaque(true);
			funcBtn[i].setFocusPainted(false);
			funcBtn[i].setBorder(null);
			funcBtn[i].setFont(new Font("Arial", Font.BOLD, 15));
			funcBtn[i].addMouseListener(action);
			funcBtn[i].addActionListener(this);
			this.add(funcBtn[i]);
			y = y + h;
		}

				
	}
	public void mouseEntered(){

		for(int i = 0; i < funcBtn.length; i++){
			funcBtn[i].setBackground(Color.orange);
		}
		
	}
	
	public void mouseExited(){
		for(int i = 0 ; i < funcBtn.length; i++){
			funcBtn[i].setBackground(Color.DARK_GRAY);
		}

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JPanel taoDon = new Orders_OrderDetail();
		JPanel don = new OrdersPanel();
		JPanel nhap = new PhieuNhap_ctPNPanel();
		JFrame a = new GiaoDien(taoDon, don, nhap);
		for(int i = 0; i < funcBtn.length; i++) {
			if(e.getSource() == funcBtn[i] && funcBtn[i].getText().equals("Món ăn")) {		
				taoDon.setVisible(true);
				don.setVisible(false);
				nhap.setVisible(false);
				a.revalidate();
			}
			else if(e.getSource() == funcBtn[i] && funcBtn[i].getText().equals("Nhân viên")) {		
				taoDon.setVisible(false);
				don.setVisible(true);
				nhap.setVisible(false);
				a.revalidate();
			}
			else if(e.getSource() == funcBtn[i] && funcBtn[i].getText().equals("Nhập hàng")) {		
				taoDon.setVisible(false);
				don.setVisible(false);
				nhap.setVisible(true);
				a.revalidate();
			}
		}
	}
	

		
		
		

}
