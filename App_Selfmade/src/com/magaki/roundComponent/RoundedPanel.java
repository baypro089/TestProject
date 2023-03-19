package com.magaki.roundComponent;

import java.awt.*;
import java.awt.geom.*;
import javax.swing.*;

public class RoundedPanel extends JPanel {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    public RoundedPanel() {
    	super();
    }
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();

        // Set the panel background color
        g2.setColor(getBackground());
        g2.fill(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 14, 14));

        g2.dispose();
    }
}
