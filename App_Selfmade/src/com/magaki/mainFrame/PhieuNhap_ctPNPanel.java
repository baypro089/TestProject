

package com.magaki.mainFrame;


import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;

import java.awt.*;

import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;

public class PhieuNhap_ctPNPanel extends JPanel implements MouseListener, ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel category;
	private JPanel btnField;
	private JButton preBtn;
	private JButton nextBtn;
	private JPanel contentField;
	private JTextField nameFindText;
	private JTextField priceFrom;
	private JTextField priceTo;
	private JTextField idPNTxt;
	private JTextField idNCCTxt;
	private JTextField idStaffCreatePNTxt;
	private JTextField totalPricePNTxt;
	private JDateChooser datePNChooser;
	private JComboBox sortCbb;
	private JPanel deltailOrderPanel;
	private JTable ctPNTable;
	private DefaultTableModel detailTableModel;
	private JScrollPane ctpnScrollPane;
	private JTextField idCTPNTxt;
	private JTextField nameCTPNTxt;
	private JTextField soLuongNhapTxt;
	private JTextField priceCTPNTxt;
	private JLabel vndSign1;
	private JSeparator separator_3;
	private JButton subFindBtn;
	private JButton rmFindBtn;
	private JTextField idPN_CTPNLabelTxt;
	private JButton addCtpnBtn;
	private JButton fixCtpnBtn;
	private JButton delCtpnBtn;
	private DefaultTableCellRenderer centerRenderer;
	/**
	 * Create the panel.
	 */
	public PhieuNhap_ctPNPanel() {
		init();
	}
	private void init() {
		this.setLayout(new BorderLayout());
		this.setPreferredSize(new Dimension(1080, 700));
		
		centerRenderer = new DefaultTableCellRenderer();
		centerRenderer.setHorizontalAlignment( JLabel.CENTER );
		
		//Tìm kiếm
		category = new JPanel(null);
		category.setPreferredSize(new Dimension(1080, 100));
		category.setBackground(new Color(204, 153, 51));
		this.add(category, BorderLayout.NORTH);
		
		
		JLabel findLabel = new JLabel("TÌM KIẾM");
		findLabel.setForeground(new Color(255, 255, 255));
		findLabel.setBounds(0, 30, 120, 40);
		category.add(findLabel);
		findLabel.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 15));
		findLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		JLabel findNameProduct = new JLabel("Tìm...");
		findNameProduct.setBounds(160, 10, 73, 30);
		category.add(findNameProduct);
		findNameProduct.setFont(new Font("Arial", Font.BOLD, 13));
		
		nameFindText = new JTextField();
		nameFindText.setBounds(243, 10, 167, 30);
		category.add(nameFindText);
		nameFindText.setFont(new Font("Arial", Font.PLAIN, 13));
		nameFindText.setColumns(10);
		
		JLabel sortProducts = new JLabel("Sắp xếp");
		sortProducts.setBounds(440, 10, 73, 30);
		category.add(sortProducts);
		sortProducts.setFont(new Font("Arial", Font.BOLD, 13));
		
		sortCbb = new JComboBox();
		sortCbb.setBounds(522, 10, 120, 30);
		category.add(sortCbb);
		sortCbb.setFont(new Font("Arial", Font.PLAIN, 13));
		
		JLabel priceProduct = new JLabel("Giá ~");
		priceProduct.setBounds(686, 36, 47, 30);
		category.add(priceProduct);
		priceProduct.setFont(new Font("Arial", Font.BOLD, 13));
		
		priceFrom = new JTextField();
		priceFrom.setBounds(743, 10, 120, 30);
		category.add(priceFrom);
		priceFrom.setFont(new Font("Arial", Font.PLAIN, 13));
		priceFrom.setColumns(10);
		
		priceTo = new JTextField();
		priceTo.setBounds(743, 59, 120, 30);
		category.add(priceTo);
		priceTo.setFont(new Font("Arial", Font.PLAIN, 13));
		priceTo.setColumns(10);
		
		subFindBtn = new JButton("Tìm kiếm");
		subFindBtn.setBounds(950, 9, 90, 35);
		category.add(subFindBtn);
		subFindBtn.setForeground(new Color(255, 255, 255));
		subFindBtn.setBackground(new Color(0, 102, 255));
		subFindBtn.setFont(new Font("Arial", Font.BOLD, 13));
		subFindBtn.setBorder(null);
		subFindBtn.addMouseListener(this);
		subFindBtn.setFocusPainted(false);
		
		rmFindBtn = new JButton("Hủy");
		rmFindBtn.setBounds(950, 54, 90, 35);
		category.add(rmFindBtn);
		rmFindBtn.setForeground(new Color(255, 255, 255));
		rmFindBtn.setBackground(new Color(0, 102, 255));
		rmFindBtn.setFont(new Font("Arial", Font.BOLD, 13));
		rmFindBtn.setBorder(null);
		rmFindBtn.setFocusPainted(false);
		rmFindBtn.addMouseListener(this);
		
		vndSign1 = new JLabel("(VNĐ)");
		vndSign1.setBounds(873, 36, 37, 30);
		category.add(vndSign1);
		
		JLabel MutualCategoryLabel = new JLabel("Foods/Drinks");
		MutualCategoryLabel.setFont(new Font("Arial", Font.BOLD, 13));
		MutualCategoryLabel.setBounds(160, 59, 100, 30);
		category.add(MutualCategoryLabel);
		
		JComboBox MutualCategoryCbb = new JComboBox();
		MutualCategoryCbb.setFont(new Font("Arial", Font.PLAIN, 13));
		MutualCategoryCbb.setBounds(290, 59, 120, 30);
		category.add(MutualCategoryCbb);
		
		JComboBox categoryCbb = new JComboBox();
		categoryCbb.setFont(new Font("Arial", Font.PLAIN, 13));
		categoryCbb.setBounds(522, 59, 120, 30);
		category.add(categoryCbb);
		
		JLabel categoryLabel = new JLabel("Phân loại");
		categoryLabel.setFont(new Font("Arial", Font.BOLD, 13));
		categoryLabel.setBounds(440, 59, 73, 30);
		category.add(categoryLabel);
		//End
		
		    
		// Panel chứa chi tiết và chọn món
		contentField = new JPanel(null);
		contentField.setBackground(Color.white);	
		this.add(contentField, BorderLayout.CENTER);
	   
        //Panel chi tiết hóa đơn
        deltailOrderPanel = new JPanel(null);
        deltailOrderPanel.setBounds(0, 0, 1080, 360);
        
        contentField.add(deltailOrderPanel, "hello2");
        
        detailTableModel = new DefaultTableModel(new Object[]{"Mã phiếu nhập", "Mã nguyên liệu", "Tên nguyên liệu", "Số lượng nhập", "Giá"}, 0);		
        ctPNTable = new JTable(detailTableModel);
        ctPNTable.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		int row = ctPNTable.getSelectedRow();
        		idPN_CTPNLabelTxt.setText(detailTableModel.getValueAt(row, 0).toString());        		
        		idCTPNTxt.setText(detailTableModel.getValueAt(row, 1).toString());
        		nameCTPNTxt.setText(detailTableModel.getValueAt(row, 2).toString());
        		soLuongNhapTxt.setText(detailTableModel.getValueAt(row, 3).toString());
        		priceCTPNTxt.setText(detailTableModel.getValueAt(row, 4).toString());
        	}
        });
        ctPNTable.setDefaultRenderer(String.class, centerRenderer);
	    ctPNTable.setRowHeight(30);
	    for(int i = 0; i < 5; i++) {
	    	if(i == 2) {
	    		ctPNTable.getColumnModel().getColumn(i).setPreferredWidth(300);
	    		ctPNTable.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
	    	}
	    	else {
	    		ctPNTable.getColumnModel().getColumn(i).setPreferredWidth(125);
	    		ctPNTable.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
	    	}
	    }
	    
        ctpnScrollPane = new JScrollPane(ctPNTable);
        ctpnScrollPane.setBounds(0, 0, 800, 360);
        deltailOrderPanel.add(ctpnScrollPane);
        
        JPanel infoDetailOrderPanel = new JPanel(null);
        infoDetailOrderPanel.setBackground(new Color(255, 255, 255));
        infoDetailOrderPanel.setBounds(800, 0, 280, 360);
        deltailOrderPanel.add(infoDetailOrderPanel);
        
        JLabel idCTPNLabel = new JLabel("Mã n.liệu");
        idCTPNLabel.setFont(new Font("Arial", Font.BOLD, 13));
        idCTPNLabel.setBounds(10, 104, 73, 30);
        infoDetailOrderPanel.add(idCTPNLabel);
        
        idCTPNTxt = new JTextField();
        idCTPNTxt.setFont(new Font("Arial", Font.PLAIN, 13));
        idCTPNTxt.setColumns(10);
        idCTPNTxt.setBounds(93, 104, 167, 30);
        infoDetailOrderPanel.add(idCTPNTxt);
        
        JLabel nameCTPNLabel = new JLabel("Tên n.liệu");
        nameCTPNLabel.setFont(new Font("Arial", Font.BOLD, 13));
        nameCTPNLabel.setBounds(10, 156, 73, 30);
        infoDetailOrderPanel.add(nameCTPNLabel);
        
        nameCTPNTxt = new JTextField();
        nameCTPNTxt.setFont(new Font("Arial", Font.PLAIN, 13));
        nameCTPNTxt.setColumns(10);
        nameCTPNTxt.setBounds(93, 156, 167, 30);
        infoDetailOrderPanel.add(nameCTPNTxt);
        
        JLabel soLuongNhapLabel = new JLabel("Số lượng nhập");
        soLuongNhapLabel.setFont(new Font("Arial", Font.BOLD, 13));
        soLuongNhapLabel.setBounds(10, 212, 140, 30);
        infoDetailOrderPanel.add(soLuongNhapLabel);
        
        soLuongNhapTxt = new JTextField();
        soLuongNhapTxt.setFont(new Font("Arial", Font.PLAIN, 13));
        soLuongNhapTxt.setColumns(10);
        soLuongNhapTxt.setBounds(210, 212, 50, 30);
        infoDetailOrderPanel.add(soLuongNhapTxt);
        
        JLabel priceCTPNLabel = new JLabel("Giá nhập");
        priceCTPNLabel.setFont(new Font("Arial", Font.BOLD, 13));
        priceCTPNLabel.setBounds(10, 264, 73, 30);
        infoDetailOrderPanel.add(priceCTPNLabel);
        
        priceCTPNTxt = new JTextField();
        priceCTPNTxt.setFont(new Font("Arial", Font.PLAIN, 13));
        priceCTPNTxt.setColumns(10);
        priceCTPNTxt.setBounds(93, 264, 167, 30);
        infoDetailOrderPanel.add(priceCTPNTxt);
        
        JLabel thongtinHDLabel_1 = new JLabel("THÔNG TIN NGUYÊN LIỆU");
        thongtinHDLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        thongtinHDLabel_1.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 14));
        thongtinHDLabel_1.setBounds(53, 11, 176, 30);
        infoDetailOrderPanel.add(thongtinHDLabel_1);
        
        separator_3 = new JSeparator();
        separator_3.setBounds(0, 359, 280, 1);
        infoDetailOrderPanel.add(separator_3);
        
        JLabel idPN_CTPNLabel = new JLabel("Mã n.liệu");
        idPN_CTPNLabel.setFont(new Font("Arial", Font.BOLD, 13));
        idPN_CTPNLabel.setBounds(10, 50, 73, 30);
        infoDetailOrderPanel.add(idPN_CTPNLabel);
        
        idPN_CTPNLabelTxt = new JTextField();
        idPN_CTPNLabelTxt.setFont(new Font("Arial", Font.PLAIN, 13));
        idPN_CTPNLabelTxt.setColumns(10);
        idPN_CTPNLabelTxt.setBounds(93, 50, 167, 30);
        infoDetailOrderPanel.add(idPN_CTPNLabelTxt);
        
        addCtpnBtn = new JButton("Thêm");
        addCtpnBtn.setForeground(Color.WHITE);
        addCtpnBtn.setFont(new Font("Arial", Font.BOLD, 13));
        addCtpnBtn.setFocusPainted(false);
        addCtpnBtn.setBorder(null);
        addCtpnBtn.setBackground(new Color(0, 102, 255));
        addCtpnBtn.setBounds(10, 313, 75, 35);
        addCtpnBtn.addMouseListener(this);
        addCtpnBtn.addActionListener(this);
        infoDetailOrderPanel.add(addCtpnBtn);
        
        fixCtpnBtn = new JButton("Cập nhật");
        fixCtpnBtn.setForeground(Color.WHITE);
        fixCtpnBtn.setFont(new Font("Arial", Font.BOLD, 13));
        fixCtpnBtn.setFocusPainted(false);
        fixCtpnBtn.setBorder(null);
        fixCtpnBtn.setBackground(new Color(0, 102, 255));
        fixCtpnBtn.setBounds(98, 313, 75, 35);
        fixCtpnBtn.addMouseListener(this);
        infoDetailOrderPanel.add(fixCtpnBtn);
        
        delCtpnBtn = new JButton("Xóa");
        delCtpnBtn.setForeground(Color.WHITE);
        delCtpnBtn.setFont(new Font("Arial", Font.BOLD, 13));
        delCtpnBtn.setFocusPainted(false);
        delCtpnBtn.setBorder(null);
        delCtpnBtn.setBackground(new Color(0, 102, 255));
        delCtpnBtn.setBounds(185, 313, 75, 35);
        delCtpnBtn.addMouseListener(this);
        delCtpnBtn.addActionListener(this);
        infoDetailOrderPanel.add(delCtpnBtn);
   
        //End
        
       
        
        
        
        
        
        
        
        
        //Tạo hóa đơn
		JLabel orderInfoLabel = new JLabel("THÔNG TIN PHIẾU NHẬP");
		orderInfoLabel.setFont(new Font("Arial", Font.BOLD, 15));
		orderInfoLabel.setBounds(10, 370, 200, 20);
		contentField.add(orderInfoLabel);
		
		JLabel idPNLable = new JLabel("Mã phiếu nhập");
		idPNLable.setFont(new Font("Arial", Font.BOLD, 13));
		idPNLable.setBounds(30, 421, 120, 30);
		contentField.add(idPNLable);
		
		idPNTxt = new JTextField();
		idPNTxt.setFont(new Font("Arial", Font.PLAIN, 13));
		idPNTxt.setBounds(160, 421, 178, 30);
		contentField.add(idPNTxt);
		idPNTxt.setColumns(10);
		
		JLabel datePNLabel = new JLabel("Ngày tạo phiếu");
		datePNLabel.setFont(new Font("Arial", Font.BOLD, 13));
		datePNLabel.setBounds(30, 473, 120, 30);
		contentField.add(datePNLabel);
		
		datePNChooser = new JDateChooser();
		datePNChooser.setBounds(160, 473, 178, 30);
		contentField.add(datePNChooser);
		
		JLabel idNCCLabel = new JLabel("Mã nhà cung cấp");
		idNCCLabel.setFont(new Font("Arial", Font.BOLD, 13));
		idNCCLabel.setBounds(370, 421, 120, 30);
		contentField.add(idNCCLabel);
		
		idNCCTxt = new JTextField();
		idNCCTxt.setFont(new Font("Arial", Font.PLAIN, 13));
		idNCCTxt.setColumns(10);
		idNCCTxt.setBounds(532, 421, 178, 30);
		contentField.add(idNCCTxt);
		
		JLabel idStaffCreateOrderLabel = new JLabel("Mã nhân viên tạo phiếu");
		idStaffCreateOrderLabel.setFont(new Font("Arial", Font.BOLD, 13));
		idStaffCreateOrderLabel.setBounds(370, 473, 150, 30);
		contentField.add(idStaffCreateOrderLabel);
		
		idStaffCreatePNTxt = new JTextField();
		idStaffCreatePNTxt.setFont(new Font("Arial", Font.PLAIN, 13));
		idStaffCreatePNTxt.setColumns(10);
		idStaffCreatePNTxt.setBounds(530, 473, 180, 30);
		contentField.add(idStaffCreatePNTxt);
		
		JLabel totalPriceLabel = new JLabel("Tổng tiền");
		totalPriceLabel.setFont(new Font("Arial", Font.BOLD, 13));
		totalPriceLabel.setBounds(758, 421, 102, 30);
		contentField.add(totalPriceLabel);
		
		totalPricePNTxt = new JTextField();
		totalPricePNTxt.setFont(new Font("Arial", Font.PLAIN, 13));
		totalPricePNTxt.setColumns(10);
		totalPricePNTxt.setBounds(870, 421, 178, 30);
		contentField.add(totalPricePNTxt);
        
        
        //Nút chuyển tiến trình
		btnField = new JPanel();
		btnField.setPreferredSize(new Dimension(1080, 70));
		btnField.setLayout(null);
		btnField.setBackground(new Color(255, 255, 255));
		this.add(btnField, BorderLayout.SOUTH);
		
		preBtn = new JButton("Quay lại");
		preBtn.setForeground(new Color(255, 255, 255));
		preBtn.setFont(new Font("Arial", Font.BOLD, 17));
		preBtn.setBounds(70, 10, 100, 50);
		preBtn.setBackground(new Color(0, 102, 255));
		preBtn.setBorder(null);
		preBtn.setFocusPainted(false);
		preBtn.addMouseListener(this);
		btnField.add(preBtn);
		
		nextBtn = new JButton("Tiếp");
		nextBtn.setForeground(new Color(255, 255, 255));
		nextBtn.setBackground(new Color(0, 102, 255));
		nextBtn.setFont(new Font("Arial", Font.BOLD, 17));
		nextBtn.setBounds(910, 10, 100, 50);
		nextBtn.setBorder(null);
		nextBtn.setFocusPainted(false);
		nextBtn.addMouseListener(this);
		nextBtn.addActionListener(this);
		nextBtn.addActionListener(this);
		btnField.add(nextBtn);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(0, 0, 1080, 1);
		btnField.add(separator);
		//End
		
		
		
	}
	
	 class CheckboxRenderer extends JCheckBox implements TableCellRenderer {
	        /**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
	            setSelected((value != null && ((Boolean) value).booleanValue()));
	            return this;
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
		if(e.getSource() == nextBtn) {
			nextBtn.setBackground(new Color(129, 178, 252));			
		}
		else if(e.getSource() == preBtn) {
			preBtn.setBackground(new Color(129, 178, 252));			
		}
		else if(e.getSource() == subFindBtn) {
			subFindBtn.setBackground(new Color(129, 178, 252));			
		}
		else if(e.getSource() == rmFindBtn) {
			rmFindBtn.setBackground(new Color(129, 178, 252));			
		}	
		else if(e.getSource() == addCtpnBtn) {
			addCtpnBtn.setBackground(new Color(129, 178, 252));			
		}
		else if(e.getSource() == fixCtpnBtn) {
			fixCtpnBtn.setBackground(new Color(129, 178, 252));			
		}
		else if(e.getSource() == delCtpnBtn) {
			delCtpnBtn.setBackground(new Color(129, 178, 252));			
		}
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == nextBtn) {
			nextBtn.setBackground(new Color(0, 102, 255));			
		}
		else if(e.getSource() == preBtn) {
			preBtn.setBackground(new Color(0, 102, 255));			
		}
		else if(e.getSource() == subFindBtn) {
			subFindBtn.setBackground(new Color(0, 102, 255));			
		}
		else if(e.getSource() == rmFindBtn) {
			rmFindBtn.setBackground(new Color(0, 102, 255));			
		}		
		else if(e.getSource() == addCtpnBtn) {
			addCtpnBtn.setBackground(new Color(0, 102, 255));			
		}
		else if(e.getSource() == fixCtpnBtn) {
			fixCtpnBtn.setBackground(new Color(0, 102, 255));			
		}
		else if(e.getSource() == delCtpnBtn) {
			delCtpnBtn.setBackground(new Color(0, 102, 255));			
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == nextBtn) {
			if(idPNTxt.getText().equals("") || idNCCTxt.getText().equals("") || totalPricePNTxt.getText().equals("") 
					|| idStaffCreatePNTxt.getText().equals("") || soLuongNhapTxt.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Thong tin chua day du!!!", "Quan com java", JOptionPane.WARNING_MESSAGE);
			}
			else {
				JOptionPane.showMessageDialog(null, "Tao phieu nhap thanh cong!!!", "Quan com java", JOptionPane.INFORMATION_MESSAGE);
			}
		}
		if(e.getSource() == preBtn) {
			if(!idPNTxt.getText().equals("") || !idNCCTxt.getText().equals("") || !totalPricePNTxt.getText().equals("")
					|| !idStaffCreatePNTxt.getText().equals("") || !soLuongNhapTxt.getText().equals("")) {
				JOptionPane.showConfirmDialog(null, "Mot so du lieu van chua duoc luu, ban co muon quay lai?", "Quan com java", JOptionPane.YES_NO_OPTION);
			}
		}
		if(e.getSource() == addCtpnBtn) {
			JOptionPane.showMessageDialog(null, "Them thanh cong!", "Quan com java", JOptionPane.PLAIN_MESSAGE);
		}
		if(e.getSource() == delCtpnBtn) {
			int selection = JOptionPane.showConfirmDialog(null, "Xac nhan ban muon xoa?", "Quan com java", JOptionPane.YES_NO_OPTION);
			if(selection == 0) {
				//co
				JOptionPane.showMessageDialog(null, "Xoa thanh cong!", "Quan com java", JOptionPane.PLAIN_MESSAGE);
			}
		}
	}
}
