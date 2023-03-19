package com.magaki.mainFrame;

import javax.swing.*;
import javax.swing.table.AbstractTableModel;

public class CheckboxTableExample extends JFrame {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JTable table;

    public CheckboxTableExample() {
        setTitle("Checkbox Table Example");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Object[][] data = {
                {false, "Apple", "Red", "Fruit"},
                {false, "Banana", "Yellow", "Fruit"},
                {false, "Carrot", "Orange", "Vegetable"},
                {false, "Broccoli", "Green", "Vegetable"}
        };
        String[] columnNames = {"Select", "Name", "Color", "Type"};
        MyTableModel model = new MyTableModel(data, columnNames);

        table = new JTable(model);
        table.getColumnModel().getColumn(0).setPreferredWidth(50);
        table.getColumnModel().getColumn(0).setMaxWidth(50);
        table.setAutoResizeMode(JTable.AUTO_RESIZE_LAST_COLUMN);

        JScrollPane scrollPane = new JScrollPane(table);
        getContentPane().add(scrollPane);

        setSize(400, 300);
        setVisible(true);
    }

    public static void main(String[] args) {
        new CheckboxTableExample();
    }

    class MyTableModel extends AbstractTableModel {
        /**
		 * 
		 */
		private static final long serialVersionUID = 1L;
		private Object[][] data;
        private String[] columnNames;

        public MyTableModel(Object[][] data, String[] columnNames) {
            this.data = data;
            this.columnNames = columnNames;
        }

        public int getColumnCount() {
            return columnNames.length;
        }

        public int getRowCount() {
            return data.length;
        }

        public Object getValueAt(int row, int col) {
            return data[row][col];
        }

        public String getColumnName(int col) {
            return columnNames[col];
        }

		public Class getColumnClass(int c) {
            return getValueAt(0, c).getClass();
        }

        public boolean isCellEditable(int row, int col) {
            if (col == 0) {
                return true;
            } else {
                return false;
            }
        }

        public void setValueAt(Object value, int row, int col) {
            data[row][col] = value;
            fireTableCellUpdated(row, col);
        }
    }
}
