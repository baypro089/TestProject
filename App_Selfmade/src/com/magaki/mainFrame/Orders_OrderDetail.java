package com.magaki.mainFrame;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import java.awt.*;

import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;

public class Orders_OrderDetail extends JPanel implements MouseListener, ActionListener, ItemListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel category;
	private JPanel btnField;
	private JButton preBtn;
	private JButton nextBtn;
	private JPanel contentField;
	private JScrollPane itemSelectedScrollPane;
	private JTable ordersSelectedTable;
	private DefaultTableModel model;
	private JTextField nameFindText;
	private JTextField priceFrom;
	private JTextField priceTo;
	private JTextField idOrderTxt;
	private JTextField unknownTxt;
	private JTextField idStaffCreateOrderTxt;
	private JTextField totalPriceOrderTxt;
	private JPanel switchPanel;
	private JPanel selectItemPanel;
	private JDateChooser orderDateChooser;
	private JTextField idItemSelectedTxt;
	private JTextField nameItemSelectedTxt;
	private JTextField remainItemSelectedTxt;
	private JTextField priceItemSelectedTxt;
	private JTextField amountInputItemSelectedTxt;
	private JLabel thongtinHDLabel;
	private JComboBox sortCbb;
	private CardLayout switchTable;
	private JPanel deltailOrderPanel;
	private JTable detailOrdersTable;
	private DefaultTableModel detailTableModel;
	private JScrollPane detailOrderScrollPane;
	private JTextField idDetailOrderTxt;
	private JTextField nameDetailOrderTxt;
	private JTextField soLuongMuaTxt;
	private JTextField priceDetailOrderTxt;
	private JLabel vndSign1;
	private JSeparator separator_1;
	private JSeparator separator_3;
	private JButton subFindBtn;
	private JButton rmFindBtn;
	private JButton turnToSelectedItemTableBtn;
	private JButton backToDetailOrderTableBtn;
	private DefaultTableCellRenderer centerRenderer;
	private JCheckBox selection;
	/**
	 * Create the panel.
	 */
	public Orders_OrderDetail() {
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
		subFindBtn.addMouseListener(this);
		subFindBtn.setForeground(new Color(255, 255, 255));
		subFindBtn.setBackground(new Color(0, 102, 255));
		subFindBtn.setFont(new Font("Arial", Font.BOLD, 13));
		subFindBtn.setBorder(null);
		subFindBtn.setFocusPainted(false);
		category.add(subFindBtn);
		
		
		rmFindBtn = new JButton("Hủy");
		rmFindBtn.setBounds(950, 54, 90, 35);		
		rmFindBtn.setForeground(new Color(255, 255, 255));
		rmFindBtn.setBackground(new Color(0, 102, 255));
		rmFindBtn.setFont(new Font("Arial", Font.BOLD, 13));
		rmFindBtn.setBorder(null);
		rmFindBtn.setFocusPainted(false);
		rmFindBtn.addMouseListener(this);
		category.add(rmFindBtn);
		
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
		
		switchTable = new CardLayout(0, 0);
        switchPanel = new JPanel(switchTable);
        switchPanel.setBounds(0, 0, 1080, 360);
        contentField.add(switchPanel);
	    
        //Panel chi tiết hóa đơn
        deltailOrderPanel = new JPanel(null);
		switchPanel.add(deltailOrderPanel, "hello2");
        
        detailTableModel = new DefaultTableModel(new Object[]{"Mã đơn", "Mã món", "Tên món", "Số lượng mua", "Giá"}, 0);		
        detailOrdersTable = new JTable(detailTableModel);
        detailOrdersTable.setFont(new Font("Tahoma", Font.PLAIN, 11));
	    detailOrdersTable.setDefaultRenderer(String.class, centerRenderer);
	    detailOrdersTable.setRowHeight(30);
	    for(int i = 0; i < 5; i++) {
	    	if(i == 2) {
	    		detailOrdersTable.getColumnModel().getColumn(i).setPreferredWidth(300);
	    		detailOrdersTable.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
	    	}
	    	else {
	    		detailOrdersTable.getColumnModel().getColumn(i).setPreferredWidth(125);
	    		detailOrdersTable.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
	    	}
	    }
	    detailOrdersTable.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		int row = ordersSelectedTable.getSelectedRow();
        		idDetailOrderTxt.setText(detailTableModel.getValueAt(row, 0).toString());        		
        		nameDetailOrderTxt.setText(detailTableModel.getValueAt(row, 1).toString());
        		soLuongMuaTxt.setText(detailTableModel.getValueAt(row, 2).toString());
        		priceDetailOrderTxt.setText(detailTableModel.getValueAt(row, 3).toString());
        	}
        });
        detailOrderScrollPane = new JScrollPane(detailOrdersTable);
        detailOrderScrollPane.setBounds(0, 0, 800, 360);
        deltailOrderPanel.add(detailOrderScrollPane);
        
        turnToSelectedItemTableBtn = new JButton(">>");
        turnToSelectedItemTableBtn.setFont(new Font("Tahoma", Font.BOLD, 11));
        turnToSelectedItemTableBtn.setForeground(new Color(0, 0, 0));
        turnToSelectedItemTableBtn.setBorder(BorderFactory.createLineBorder(Color.black));
        turnToSelectedItemTableBtn.setFocusPainted(false);
        turnToSelectedItemTableBtn.setBackground(Color.LIGHT_GRAY);
        turnToSelectedItemTableBtn.addMouseListener(this);
        detailOrderScrollPane.setRowHeaderView(turnToSelectedItemTableBtn);
        turnToSelectedItemTableBtn.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		switchTable.show(switchPanel, "hello1");
        	}
        });
        
        JPanel infoDetailOrderPanel = new JPanel(null);
        infoDetailOrderPanel.setBackground(new Color(255, 255, 255));
        infoDetailOrderPanel.setBounds(800, 0, 280, 360);
        deltailOrderPanel.add(infoDetailOrderPanel);
        
        JLabel idDetailOrderLabel = new JLabel("Mã món");
        idDetailOrderLabel.setFont(new Font("Arial", Font.BOLD, 13));
        idDetailOrderLabel.setBounds(10, 80, 73, 30);
        infoDetailOrderPanel.add(idDetailOrderLabel);
        
        idDetailOrderTxt = new JTextField();
        idDetailOrderTxt.setFont(new Font("Arial", Font.PLAIN, 13));
        idDetailOrderTxt.setColumns(10);
        idDetailOrderTxt.setBounds(93, 80, 167, 30);
        infoDetailOrderPanel.add(idDetailOrderTxt);
        
        JLabel nameDetailOrderLabel = new JLabel("Tên món");
        nameDetailOrderLabel.setFont(new Font("Arial", Font.BOLD, 13));
        nameDetailOrderLabel.setBounds(10, 132, 73, 30);
        infoDetailOrderPanel.add(nameDetailOrderLabel);
        
        nameDetailOrderTxt = new JTextField();
        nameDetailOrderTxt.setFont(new Font("Arial", Font.PLAIN, 13));
        nameDetailOrderTxt.setColumns(10);
        nameDetailOrderTxt.setBounds(93, 132, 167, 30);
        infoDetailOrderPanel.add(nameDetailOrderTxt);
        
        JLabel soLuongMuaLabel = new JLabel("Số lượng mua");
        soLuongMuaLabel.setFont(new Font("Arial", Font.BOLD, 13));
        soLuongMuaLabel.setBounds(10, 188, 140, 30);
        infoDetailOrderPanel.add(soLuongMuaLabel);
        
        soLuongMuaTxt = new JTextField();
        soLuongMuaTxt.setFont(new Font("Arial", Font.PLAIN, 13));
        soLuongMuaTxt.setColumns(10);
        soLuongMuaTxt.setBounds(210, 188, 50, 30);
        infoDetailOrderPanel.add(soLuongMuaTxt);
        
        JLabel priceDetailOrderLabel = new JLabel("Giá");
        priceDetailOrderLabel.setFont(new Font("Arial", Font.BOLD, 13));
        priceDetailOrderLabel.setBounds(10, 240, 73, 30);
        infoDetailOrderPanel.add(priceDetailOrderLabel);
        
        priceDetailOrderTxt = new JTextField();
        priceDetailOrderTxt.setFont(new Font("Arial", Font.PLAIN, 13));
        priceDetailOrderTxt.setColumns(10);
        priceDetailOrderTxt.setBounds(93, 240, 167, 30);
        infoDetailOrderPanel.add(priceDetailOrderTxt);
        
        JLabel thongtinHDLabel_1 = new JLabel("THÔNG TIN MÓN");
        thongtinHDLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        thongtinHDLabel_1.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 14));
        thongtinHDLabel_1.setBounds(80, 21, 126, 30);
        infoDetailOrderPanel.add(thongtinHDLabel_1);
        
        separator_3 = new JSeparator();
        separator_3.setBounds(0, 359, 280, 1);
        infoDetailOrderPanel.add(separator_3);
        //End
	    
        //Panel Chọn món
        selectItemPanel = new JPanel(new BorderLayout());
        switchPanel.add(selectItemPanel, "hello1");
              
        model = new DefaultTableModel(new Object[]{"Mã món", "Tên món", "Số lượng còn lại", "Giá", "Chọn"}, 0);		
        ordersSelectedTable = new JTable(model);   
       
      /*  ordersSelectedTable.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		int row = ordersSelectedTable.getSelectedRow();
        		idItemSelectedTxt.setText(model.getValueAt(row, 0).toString());
        		nameItemSelectedTxt.setText(model.getValueAt(row, 1).toString());
        		remainItemSelectedTxt.setText(model.getValueAt(row, 2).toString());
        		priceItemSelectedTxt.setText(model.getValueAt(row, 3).toString());
        		
        	}
        });*/
        ListSelectionModel listSelectionModel = ordersSelectedTable.getSelectionModel();
        listSelectionModel.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        listSelectionModel.addListSelectionListener(new ListSelectionListener(){
            @Override
            public void valueChanged(ListSelectionEvent e) {
            	int row = ordersSelectedTable.getSelectedRow();
        		idItemSelectedTxt.setText(model.getValueAt(row, 0).toString());
        		nameItemSelectedTxt.setText(model.getValueAt(row, 1).toString());
        		remainItemSelectedTxt.setText(model.getValueAt(row, 2).toString());
        		priceItemSelectedTxt.setText(model.getValueAt(row, 3).toString());
        		
            }          
        });
        
	    ordersSelectedTable.setDefaultRenderer(String.class, centerRenderer);
        ordersSelectedTable.setRowHeight(30);
        
        model.addRow(new Object[]{"C1", "Cơm sườn", 10, 30000, false});
	    model.addRow(new Object[]{"C2", "Cơm gà", 1, 30000, false});
	    model.addRow(new Object[]{"C3", "Cơm chiên", 1, 30000, false});
	    model.addRow(new Object[]{"C4", "Cơm trộn", 1, 30000, false});
	    for(int i = 0; i < 5; i++) {
	    	if(i == 1) {
	    		ordersSelectedTable.getColumnModel().getColumn(i).setPreferredWidth(300);
	    		ordersSelectedTable.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
	    	}
	    	else {
	    		ordersSelectedTable.getColumnModel().getColumn(i).setPreferredWidth(125);
	    		ordersSelectedTable.getColumnModel().getColumn(i).setCellRenderer(centerRenderer);
	    	}
	    }
    
	    
        TableColumn selectColumn = ordersSelectedTable.getColumnModel().getColumn(4);
        selection = new JCheckBox();
    	selection.addItemListener(this);
    	selectColumn.setCellEditor(new DefaultCellEditor(selection));
        selectColumn.setCellRenderer(new CheckboxRenderer());
        
        
        
        itemSelectedScrollPane = new JScrollPane(ordersSelectedTable);
        
        itemSelectedScrollPane.setPreferredSize(new Dimension(800, 360));
        selectItemPanel.add(itemSelectedScrollPane, BorderLayout.WEST);
        
        backToDetailOrderTableBtn = new JButton("<<");
        itemSelectedScrollPane.setRowHeaderView(backToDetailOrderTableBtn);
        backToDetailOrderTableBtn.setFont(new Font("Tahoma", Font.BOLD, 11));
        backToDetailOrderTableBtn.setForeground(new Color(0, 0, 0));
        backToDetailOrderTableBtn.setBorder(BorderFactory.createLineBorder(Color.black));       
        backToDetailOrderTableBtn.setBackground(Color.LIGHT_GRAY);
        backToDetailOrderTableBtn.addMouseListener(this);
        backToDetailOrderTableBtn.setFocusPainted(false);
        backToDetailOrderTableBtn.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		switchTable.show(switchPanel, "hello2");
        	}
        });
        
        JPanel infoItemSeclected = new JPanel(null);
        infoItemSeclected.setBackground(new Color(255, 255, 255));
        infoItemSeclected.setPreferredSize(new Dimension(280, 360));
        selectItemPanel.add(infoItemSeclected, BorderLayout.EAST);
        
        JLabel idItemSelectedLabel = new JLabel("Mã món");
        idItemSelectedLabel.setFont(new Font("Arial", Font.BOLD, 13));
        idItemSelectedLabel.setBounds(10, 80, 73, 30);
        infoItemSeclected.add(idItemSelectedLabel);
        
        idItemSelectedTxt = new JTextField();
        idItemSelectedTxt.setFont(new Font("Arial", Font.PLAIN, 13));
        idItemSelectedTxt.setColumns(10);
        idItemSelectedTxt.setBounds(93, 80, 167, 30);
        infoItemSeclected.add(idItemSelectedTxt);
        
        JLabel nameItemSelectedLabel = new JLabel("Tên món");
        nameItemSelectedLabel.setFont(new Font("Arial", Font.BOLD, 13));
        nameItemSelectedLabel.setBounds(10, 132, 73, 30);
        infoItemSeclected.add(nameItemSelectedLabel);
        
        nameItemSelectedTxt = new JTextField();
        nameItemSelectedTxt.setFont(new Font("Arial", Font.PLAIN, 13));
        nameItemSelectedTxt.setColumns(10);
        nameItemSelectedTxt.setBounds(93, 132, 167, 30);
        infoItemSeclected.add(nameItemSelectedTxt);
        
        JLabel remainItemSelectedLabel = new JLabel("Số lượng còn lại");
        remainItemSelectedLabel.setFont(new Font("Arial", Font.BOLD, 13));
        remainItemSelectedLabel.setBounds(10, 184, 140, 30);
        infoItemSeclected.add(remainItemSelectedLabel);
        
        remainItemSelectedTxt = new JTextField();
        remainItemSelectedTxt.setFont(new Font("Arial", Font.PLAIN, 13));
        remainItemSelectedTxt.setColumns(10);
        remainItemSelectedTxt.setBounds(210, 184, 50, 30);
        infoItemSeclected.add(remainItemSelectedTxt);
        
        JLabel amountInputItemSelectedLabel = new JLabel("Số lượng mua");
        amountInputItemSelectedLabel.setFont(new Font("Arial", Font.BOLD, 13));
        amountInputItemSelectedLabel.setBounds(10, 239, 140, 30);
        infoItemSeclected.add(amountInputItemSelectedLabel);
        
        amountInputItemSelectedTxt = new JTextField();
        amountInputItemSelectedTxt.setFont(new Font("Arial", Font.PLAIN, 13));
        amountInputItemSelectedTxt.setColumns(10);
        amountInputItemSelectedTxt.setBounds(210, 239, 50, 30);
        amountInputItemSelectedTxt.setEnabled(false);
        infoItemSeclected.add(amountInputItemSelectedTxt);
        
        JLabel priceItemSelectedLabel = new JLabel("Giá");
        priceItemSelectedLabel.setBounds(10, 292, 73, 30);
        infoItemSeclected.add(priceItemSelectedLabel);
        priceItemSelectedLabel.setFont(new Font("Arial", Font.BOLD, 13));
        
        priceItemSelectedTxt = new JTextField();
        priceItemSelectedTxt.setBounds(93, 292, 167, 30);
        infoItemSeclected.add(priceItemSelectedTxt);
        priceItemSelectedTxt.setFont(new Font("Arial", Font.PLAIN, 13));
        priceItemSelectedTxt.setColumns(10);
        
        thongtinHDLabel = new JLabel("THÔNG TIN MÓN");
        thongtinHDLabel.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 14));
        thongtinHDLabel.setHorizontalAlignment(SwingConstants.CENTER);
        thongtinHDLabel.setBounds(80, 21, 126, 30);
        infoItemSeclected.add(thongtinHDLabel);
        
        separator_1 = new JSeparator();
        separator_1.setBounds(0, 359, 280, 1);
        infoItemSeclected.add(separator_1);
        //End
        
       
        
        
        
        
        
        
        
        
        //Tạo hóa đơn
		JLabel orderInfoLabel = new JLabel("THÔNG TIN HÓA ĐƠN");
		orderInfoLabel.setFont(new Font("Arial", Font.BOLD, 15));
		orderInfoLabel.setBounds(10, 370, 200, 20);
		contentField.add(orderInfoLabel);
		
		JLabel idOrderLabel = new JLabel("Mã hóa đơn");
		idOrderLabel.setFont(new Font("Arial", Font.BOLD, 13));
		idOrderLabel.setBounds(30, 421, 120, 30);
		contentField.add(idOrderLabel);
		
		idOrderTxt = new JTextField();
		idOrderTxt.setFont(new Font("Arial", Font.PLAIN, 13));
		idOrderTxt.setBounds(160, 421, 178, 30);
		contentField.add(idOrderTxt);
		idOrderTxt.setColumns(10);
		
		JLabel orderDateLabel = new JLabel("Ngày tạo đơn");
		orderDateLabel.setFont(new Font("Arial", Font.BOLD, 13));
		orderDateLabel.setBounds(30, 473, 120, 30);
		contentField.add(orderDateLabel);
		
		orderDateChooser = new JDateChooser();
		orderDateChooser.setBounds(160, 473, 178, 30);
		contentField.add(orderDateChooser);
		
		JLabel unkownLabel = new JLabel("Mã hóa đơn");
		unkownLabel.setFont(new Font("Arial", Font.BOLD, 13));
		unkownLabel.setBounds(370, 421, 120, 30);
		contentField.add(unkownLabel);
		
		unknownTxt = new JTextField();
		unknownTxt.setFont(new Font("Arial", Font.PLAIN, 13));
		unknownTxt.setColumns(10);
		unknownTxt.setBounds(532, 421, 178, 30);
		contentField.add(unknownTxt);
		
		JLabel idStaffCreateOrderLabel = new JLabel("Mã nhân viên tạo đơn");
		idStaffCreateOrderLabel.setFont(new Font("Arial", Font.BOLD, 13));
		idStaffCreateOrderLabel.setBounds(370, 473, 150, 30);
		contentField.add(idStaffCreateOrderLabel);
		
		idStaffCreateOrderTxt = new JTextField();
		idStaffCreateOrderTxt.setFont(new Font("Arial", Font.PLAIN, 13));
		idStaffCreateOrderTxt.setColumns(10);
		idStaffCreateOrderTxt.setBounds(530, 473, 180, 30);
		contentField.add(idStaffCreateOrderTxt);
		
		JLabel totalPriceLabel = new JLabel("Tổng tiền");
		totalPriceLabel.setFont(new Font("Arial", Font.BOLD, 13));
		totalPriceLabel.setBounds(758, 421, 102, 30);
		contentField.add(totalPriceLabel);
		
		totalPriceOrderTxt = new JTextField();
		totalPriceOrderTxt.setFont(new Font("Arial", Font.PLAIN, 13));
		totalPriceOrderTxt.setColumns(10);
		totalPriceOrderTxt.setBounds(870, 421, 178, 30);
		contentField.add(totalPriceOrderTxt);
        
        
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
		preBtn.addActionListener(this);
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
		else if(e.getSource() == turnToSelectedItemTableBtn) {
			turnToSelectedItemTableBtn.setBackground(Color.white);			
		}
		else if(e.getSource() == backToDetailOrderTableBtn) {
			backToDetailOrderTableBtn.setBackground(Color.white);			
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
		else if(e.getSource() == turnToSelectedItemTableBtn) {
			turnToSelectedItemTableBtn.setBackground(Color.LIGHT_GRAY);			
		}
		else if(e.getSource() == backToDetailOrderTableBtn) {
			backToDetailOrderTableBtn.setBackground(Color.LIGHT_GRAY);			
		}
	}
	public static void setColumnWidths(JTable table, int... widths) {
	    TableColumnModel columnModel = table.getColumnModel();
	    for (int i = 0; i < widths.length; i++) {
	        if (i < columnModel.getColumnCount()) {
	            columnModel.getColumn(i).setMaxWidth(widths[i]);
	        }
	        else break;
	    }
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == nextBtn) {
			if(idOrderTxt.getText().equals("") || unknownTxt.getText().equals("") || totalPriceOrderTxt.getText().equals("") 
					|| idStaffCreateOrderTxt.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Thong tin chua day du!!!", "Quan com java", JOptionPane.WARNING_MESSAGE);
			}
			else {
				JOptionPane.showMessageDialog(null, "Tao don thanh cong!!!", "Quan com java", JOptionPane.INFORMATION_MESSAGE);
			}
		}
		if(e.getSource() == preBtn) {
			if(!idOrderTxt.getText().equals("") || !unknownTxt.getText().equals("") || !totalPriceOrderTxt.getText().equals("")
					|| !idStaffCreateOrderTxt.getText().equals("")) {
				JOptionPane.showConfirmDialog(null, "Mot so du lieu van chua duoc luu, ban co muon quay lai?", "Quan com java", JOptionPane.YES_NO_OPTION);
			}
		}
		
	}
	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource() == selection && selection.isSelected()) {
			String input;
			do {
				input = JOptionPane.showInputDialog("Nhap so luong mon");							
				if(input == null) {
					selection.setSelected(false);	
					break;
				}
			}while(input.equals(""));	
			amountInputItemSelectedTxt.setText(input);
		}
		else {				
			amountInputItemSelectedTxt.setText("");
		}		
	}
}
