package com.magaki.mainFrame;
import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;


import java.awt.GridLayout;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import com.magaki.roundComponent.CenterTableCellRenderer;
import com.magaki.sql.SQLServerConnUtils_JTDS;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;
import javax.swing.ListSelectionModel;

public class OrdersPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField nameTxt;
	private JTextField amountTxt;
	private JTextField unitTxt;
	private JTextField priceTxt;
	DefaultTableModel model;
	private List<Orders> list;
	private JTable table;
	/**
	 * Create the panel.
	 */
	public OrdersPanel() {
		init();
	}
	public void init() {
		this.setPreferredSize(new Dimension(1030, 700));
		setLayout(null);
		list = new ArrayList<Orders>();
		JLabel titleLabel = new JLabel("THÔNG TIN MÓN ĂN");
		titleLabel.setFont(new Font("Arial", Font.PLAIN, 15));
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setBounds(397, 11, 220, 36);
		add(titleLabel);
		
		JLabel nameLabel = new JLabel("Name");
		nameLabel.setBounds(28, 76, 46, 14);
		add(nameLabel);
		
		nameTxt = new JTextField();
		nameTxt.setBounds(105, 73, 168, 20);
		add(nameTxt);
		nameTxt.setColumns(10);
		
		JLabel amountLabel = new JLabel("Amount");
		amountLabel.setBounds(28, 127, 46, 14);
		add(amountLabel);
		
		amountTxt = new JTextField();
		amountTxt.setBounds(105, 124, 168, 20);
		add(amountTxt);
		amountTxt.setColumns(10);
		
		JLabel unitLabel = new JLabel("Unit");
		unitLabel.setBounds(28, 185, 46, 14);
		add(unitLabel);
		
		unitTxt = new JTextField();
		unitTxt.setBounds(105, 182, 168, 20);
		add(unitTxt);
		unitTxt.setColumns(10);
		
		JLabel priceLabel = new JLabel("Price");
		priceLabel.setBounds(28, 236, 46, 14);
		add(priceLabel);
		
		priceTxt = new JTextField();
		priceTxt.setBounds(105, 233, 168, 20);
		add(priceTxt);
		priceTxt.setColumns(10);
		
		JButton submitBtn = new JButton("Submit");
		submitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Orders o = new Orders();
				o.setName(nameTxt.getText());
				o.setAmount(Integer.parseInt(amountTxt.getText()));
				o.setUnit(unitTxt.getText());
				o.setPrice(Long.parseLong(priceTxt.getText()));
				list.add(o);
				showResult();
			}
		});	
		submitBtn.setBounds(28, 313, 89, 23);
		add(submitBtn);
		
		JButton resetBtn = new JButton("Reset");
		resetBtn.setBounds(184, 313, 89, 23);
		add(resetBtn);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(344, 75, 652, 261);
		add(scrollPane);
		
		model = new DefaultTableModel(new Object[]{"DEPT_ID", "DEPT_NAME", "DEPT_NO", "LOCATION"}, 0);
		table = new JTable(model);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setFont(new Font("Arial", Font.PLAIN, 13));
		table.setBackground(new Color(255, 255, 102));
		table.setRowHeight(25); //chỉnh độ cao một dòng
		table.getColumnModel().getColumn(0).setPreferredWidth(15);// chỉnh độ rộng một cột
		table.setDefaultRenderer(Object.class, new CenterTableCellRenderer());
		scrollPane.setViewportView(table);
		
		SLQquery();
	}
	private void showResult() {
		
		Orders o = list.get(list.size()-1);
		model.addRow(new Object[] {
			o.getName(), o.getAmount(), o.getUnit(), o.getPrice()
		});
		
		
	}
	private void SLQquery() {
		try ( // Lấy ra đối tượng Connection kết nối vào DB.
	          Connection connection = SQLServerConnUtils_JTDS.getSQLServerConnection()) {
	          // Tạo đối tượng Statement.
	          Statement statement = connection.createStatement();
	          String sql = "Select DEPT_ID, DEPT_NAME, DEPT_NO, LOCATION from DEPARTMENT";
	          // Thực thi câu lệnh SQL trả về đối tượng ResultSet.
	          ResultSet rs = statement.executeQuery(sql);
	          // Duyệt trên kết quả trả về.
	          while (rs.next()) {
	              // Di chuyển con trỏ xuống bản ghi kế tiếp.
	              String deptId = rs.getString(1);
	              String deptName = rs.getString(2);
	              String deptNo = rs.getString(3);
	              String depLocation = rs.getString(4);
	              model.addRow(new Object[] {
	            		  deptId, deptName, deptNo, depLocation
	          	  });
	          }
	          // Đóng kết nối
	          connection.close();
	      } catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
