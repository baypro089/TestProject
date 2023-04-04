package com.magaki.roundComponent;

import javax.swing.*;
import javax.swing.table.*;

public class avcc extends JFrame {
    private JTable table;
    private DefaultTableModel tableModel;

    public avcc() {
        // Tạo một mảng checkbox để chứa các giá trị đánh dấu
        JCheckBox[] checkBoxes = new JCheckBox[5];
        for (int i = 0; i < 5; i++) {
            checkBoxes[i] = new JCheckBox();
        }

        // Khởi tạo bảng với các cột và dòng ban đầu
        String[] columnNames = {"ID", "Tên", "Đánh dấu"};
        Object[][] data = {
            {"1", "A", checkBoxes[0]},
            {"2", "B", checkBoxes[1]},
            {"3", "C", checkBoxes[2]},
            {"4", "D", checkBoxes[3]},
            {"5", "E", checkBoxes[4]},
        };
        tableModel = new DefaultTableModel(data, columnNames);

        // Thêm bảng vào giao diện
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        getContentPane().add(scrollPane);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setVisible(true);
    }

    public static void main(String[] args) {
        new avcc();
    }
}

