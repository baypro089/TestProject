package com.magaki.mainFrame;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Arrays;

import javax.swing.*;
import javax.swing.table.*;

public class CheckBoxTableAndGetDataFromIt extends JFrame implements ItemListener{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JCheckBox tick;
	JTable table;
	public CheckBoxTableAndGetDataFromIt() {
        super("Checkbox Table Example");

        // Tạo một bảng
        DefaultTableModel model = new DefaultTableModel(new Object[]{"Name", "Age", "Gender", "Select"}, 0);
        table = new JTable(model);
        
        // Thêm dữ liệu vào bảng
        model.addRow(new Object[]{"John", 20, "Male", false});
        model.addRow(new Object[]{"Mary", 25, "Female", false});
        model.addRow(new Object[]{"Tom", 30, "Male", false});
        model.addRow(new Object[]{"Jane", 35, "Female", false});
        
        // Thêm checkbox vào cột "Select"
        TableColumn selectColumn = table.getColumnModel().getColumn(3);
        tick = new JCheckBox();
        tick.addItemListener(this);
        selectColumn.setCellEditor(new DefaultCellEditor(tick));
        selectColumn.setCellRenderer(new CheckboxRenderer());
        
        // Hiển thị bảng trong một JScrollPane
        JScrollPane scrollPane = new JScrollPane(table);
        getContentPane().add(scrollPane);
        
        // Thiết lập kích thước của frame và hiển thị nó
        setSize(400, 300);
        setVisible(true);
        
        
    }
    
    // Lớp CheckboxRenderer để hiển thị checkbox
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
    
    public static void main(String[] args) {
        new CheckBoxTableAndGetDataFromIt();
    }

	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		if(e.getItemSelectable() == tick && tick.isSelected()) {
			int selectedRow = table.getSelectedRow(); // Lấy chỉ mục của hàng được chọn
			int modelRow = table.convertRowIndexToModel(selectedRow); // Chuyển đổi chỉ mục hàng sang chỉ mục hàng tương ứng trong mô hình dữ liệu

			Object[] rowData = new Object[table.getColumnCount()]; // Khởi tạo một mảng đối tượng để lưu trữ dữ liệu của hàng được chọn
			for (int i = 0; i < table.getColumnCount(); i++) {
			    rowData[i] = table.getValueAt(modelRow, i); // Lấy giá trị của ô tại hàng và cột được chỉ định và thêm vào mảng rowData
			}
			Person anhA = new Person(rowData[0].toString(), rowData[1].toString(), rowData[2].toString());
			System.out.println(anhA.toString());
			// Chuyển đổi mảng rowData sang chuỗi và trả về dòng chứa ô đó
			//String rowString = Arrays.toString(rowData);
			//System.out.println(rowString);
		}
	}
}

