package com.magaki.SliderBanner;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;

public class ImageSliderPanel extends JPanel {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JSlider slider;
    private JLabel imageLabel;
    private ImageIcon[] images;

    public ImageSliderPanel() {
        setLayout(new BorderLayout());
        setSize(880, 700);
        // Khởi tạo các ảnh
        images = new ImageIcon[3];
        images[0] = new ImageIcon("Image/ảnh1.jpg");
        images[1] = new ImageIcon("Image/ảnh2.jpg");
        images[2] = new ImageIcon("Image/ảnh3.jpg");

        // Khởi tạo label chứa ảnh
        imageLabel = new JLabel(images[0]);
        imageLabel.setHorizontalAlignment(JLabel.CENTER);
        add(imageLabel, BorderLayout.CENTER);

        // Khởi tạo slider
        slider = new JSlider(JSlider.HORIZONTAL, 0, images.length - 1, 0);
        slider.setMajorTickSpacing(1);
        slider.setPaintTicks(true);
        slider.addChangeListener(new SliderListener());
        add(slider, BorderLayout.SOUTH);
    }

    private class SliderListener implements ChangeListener {
        public void stateChanged(ChangeEvent e) {
            int index = slider.getValue();
            imageLabel.setIcon(images[index]);
        }
    }

   /* public static void main(String[] args) {
        JFrame frame = new JFrame("Image Slider Panel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new ImageSliderPanel();
        frame.add(panel);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }*/
}
