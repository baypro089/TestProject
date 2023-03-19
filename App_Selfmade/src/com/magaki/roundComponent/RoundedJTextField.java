package com.magaki.roundComponent;

import javax.swing.JTextField;
import java.awt.*;
import java.awt.geom.RoundRectangle2D;

public class RoundedJTextField extends JTextField {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public RoundedJTextField(int columns) {
        super(columns);
        setOpaque(false);
    }

    protected void paintComponent(Graphics g) {
        g.setColor(getBackground());
        g.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, 14, 14);
        super.paintComponent(g);
    }

    protected void paintBorder(Graphics g) {
    }

    public boolean contains(int x, int y) {
        Shape shape = new RoundRectangle2D.Float(0, 0, getWidth()-1, getHeight()-1, 14, 14);
        return shape.contains(x, y);
    }
}