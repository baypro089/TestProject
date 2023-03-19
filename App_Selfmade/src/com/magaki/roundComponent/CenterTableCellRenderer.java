package com.magaki.roundComponent;

import java.awt.Component;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class CenterTableCellRenderer extends DefaultTableCellRenderer {

  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

public CenterTableCellRenderer() {
    super();
  }

  @Override
  public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
      boolean hasFocus, int row, int column) {

    // Gọi phương thức getTableCellRendererComponent() của lớp cha
    Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);

    // Thiết lập văn bản can giữa cho ô
    this.setHorizontalAlignment(CENTER);

    return c;
  }
}
