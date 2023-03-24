package com.magaki.mainFrame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import com.magaki.roundComponent.CenterTableCellRenderer;
import com.magaki.sql.SQLServerConnUtils_JTDS;

public class SuplierPanel extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField idTxt;
	private JTextField nameTxt;
	private JTextField addressTxt;
	DefaultTableModel model;
	private JTable table;
	/**
	 * Create the panel.
	 */
	public SuplierPanel() {
		init();
	}
	private void init() {
		this.setPreferredSize(new Dimension(1030, 700));
		setLayout(null);
		ArrayList<Suplier> list = addListFormSQL();
		JLabel titleLabel = new JLabel("NHÀ CUNG CẤP");
		titleLabel.setFont(new Font("Arial", Font.PLAIN, 15));
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setBounds(397, 11, 220, 36);
		add(titleLabel);
		
		JLabel idLabel = new JLabel("Mã");
		idLabel.setBounds(28, 76, 46, 14);
		add(idLabel);
		
		idTxt = new JTextField();
		idTxt.setBounds(105, 73, 168, 20);
		add(idTxt);
		
		JLabel nameLabel = new JLabel("Tên");
		nameLabel.setBounds(28, 127, 46, 14);
		add(nameLabel);
		
		nameTxt = new JTextField();
		nameTxt.setBounds(105, 124, 168, 20);
		add(nameTxt);
		
		JLabel addressLabel = new JLabel("Địa chỉ");
		addressLabel.setBounds(28, 185, 46, 14);
		add(addressLabel);
		
		addressTxt = new JTextField();
		addressTxt.setBounds(105, 182, 168, 20);
		add(addressTxt);
		
		JButton submitBtn = new JButton("Submit");
		submitBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Suplier o = new Suplier();
				o.setId(idTxt.getText());
				o.setName(nameTxt.getText());
				o.setAddress(addressTxt.getText());
				list.add(o);
			}
		});	
		submitBtn.setBounds(28, 313, 89, 23);
		add(submitBtn);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(312, 70, 652, 261);
		add(scrollPane);
		
		model = new DefaultTableModel(new Object[]{"Mã", "Tên", "Địa chỉ"}, 0);
		table = new JTable(model);
		table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		table.setFont(new Font("Arial", Font.PLAIN, 13));
		table.setBackground(new Color(255, 255, 102));
		table.setRowHeight(25); //chỉnh độ cao một dòng
		TableColumnModel columnModel = table.getColumnModel();
		columnModel.getColumn(0).setPreferredWidth(10);// Chỉnh độ rộng cột đầu tiên thành 100 pixel
		table.setDefaultRenderer(Object.class, new CenterTableCellRenderer());
		scrollPane.setViewportView(table);
		
		showTable();
	}
	public void showTable() {
		/*Suplier a = list.get(list.size()-1);
		model.addRow(new Object[] {
			a.getId(), a.getName(), a.getAddress()
		});
		try (Connection con = SQLServerConnUtils_JTDS.getSQLServerConnection()) {
			// Tạo đối tượng Statement.
	          String sql = "Insert into supplier(sup_id, sup_name, sup_address) values (?, ?, ?)";
	          // Thực thi câu lệnh SQL trả về đối tượng ResultSet.
	          PreparedStatement ps = con.prepareStatement(sql);
	          ps.setString(1, a.getId());
	          ps.setString(2, a.getName());
	          ps.setString(3, a.getAddress());
	          int rowsInserted = ps.executeUpdate();
	          // Đóng kết nối
	          con.close();
	      } catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	*/
		ArrayList<Suplier> list = addListFormSQL();
		for(Suplier i : list) {
			model.addRow(new Object[] {
				i.getId(), i.getName(), i.getAddress()
			});
		}
	}
	public ArrayList<Suplier> addListFormSQL() {
		ArrayList<Suplier> list = new ArrayList<>();                     
		try (Connection connection = SQLServerConnUtils_JTDS.getSQLServerConnection()) {
		          // Tạo đối tượng Statement.
		          Statement statement = connection.createStatement();
		          String sql = "Select sup_id, sup_name, sup_address from supplier";
		          // Thực thi câu lệnh SQL trả về đối tượng ResultSet.
		          ResultSet rs = statement.executeQuery(sql);
		          // Duyệt trên kết quả trả về.
		          while (rs.next()) {
		              // Di chuyển con trỏ xuống bản ghi kế tiếp.
		              String supId = rs.getString(1);
		              String supName = rs.getString(2);
		              String supAddress = rs.getString(3);
		              Suplier suplier = new Suplier(supId, supName, supAddress);
		              list.add(suplier);
		          }
		          // Đóng kết nối
		          connection.close();
		      } catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		}
		return list;
	}
	public void executeSQL(String sql, String functionality) {
		Connection connection;
		try {
			connection = SQLServerConnUtils_JTDS.getSQLServerConnection();
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
		
}
