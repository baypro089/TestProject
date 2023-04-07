package view;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.magaki.mainFrame.Orders_OrderDetail;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
//import java.net.URL;



public class GiaoDien extends JFrame {
    
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private TitlePanel title;
    private JPanel leftMenu;
    private JPanel mainContent;
    private CardLayout cardLayout;
    
    
    public CardLayout getCardLayout() {
		return cardLayout;
	}
	public void setCardLayout(CardLayout cardLayout) {
		this.cardLayout = cardLayout;
	}
	public JPanel getFunctionPanel1() {
		return functionPanel1;
	}
	public void setFunctionPanel1(JPanel functionPanel1) {
		this.functionPanel1 = functionPanel1;
	}
	public JPanel getFunctionPanel2() {
		return functionPanel2;
	}
	public void setFunctionPanel2(JPanel functionPanel2) {
		this.functionPanel2 = functionPanel2;
	}
	public JPanel getFunctionPanel3() {
		return functionPanel3;
	}
	public void setFunctionPanel3(JPanel functionPanel3) {
		this.functionPanel3 = functionPanel3;
	}
	public JPanel getFunc1() {
		return func1;
	}
	public void setFunc1(JPanel func1) {
		this.func1 = func1;
	}
	public JPanel getFunc2() {
		return func2;
	}
	public void setFunc2(JPanel func2) {
		this.func2 = func2;
	}
	public JPanel getFunc3() {
		return func3;
	}
	public void setFunc3(JPanel func3) {
		this.func3 = func3;
	}

	private JPanel functionPanel1;
    private JPanel functionPanel2;
    private JPanel functionPanel3;
    private JPanel functionPanel4;
    private JPanel functionPanel5;
    private JPanel functionPanel6;
    private JPanel functionPanel7;
    private JPanel functionPanel8;
    private JPanel func1;
    private JPanel func2;
    private JPanel func3;
    
    public GiaoDien() {
        init();
        this.setVisible(true);
    }
    public GiaoDien(JPanel func1, JPanel func2, JPanel func3) {
    	this.func1 = func1;
    	this.func2 = func2;
    	this.func3 = func3;
    }
    public void init() {
        this.setSize(1280, 732);
        this.setLocationRelativeTo(null);
		this.setUndecorated(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Giao diện bán hàng");

        //Tieu de
		title = new TitlePanel(this);
        title.setBackground(Color.darkGray);
        title.setPreferredSize(new Dimension(1280,32));
        title.setOpaque(true);
        //---------------------------------------------------------------


        //Menu ben trai + logo
        
    
        //Menu ben trai
        leftMenu = new LeftMenu();
        leftMenu.setPreferredSize(new Dimension(200, 700));
		//---------------------------------------------------------------
        mainContent = new JPanel(new BorderLayout());
        mainContent.setPreferredSize(new Dimension(1080, 700));
        
        
        cardLayout = new CardLayout();
        JPanel switchPanel = new JPanel(cardLayout);
        switchPanel.setPreferredSize(new Dimension(1080, 700));
        mainContent.add(switchPanel);
        //chức năng 1
        functionPanel1 = new JPanel(null);
        functionPanel1.setPreferredSize(new Dimension(1080, 700));
        switchPanel.add(functionPanel1, "func1");
        //this.func1.setBounds(0, 0, 1080, 700);
        functionPanel1.add(func1);
        //Orders_OrderDetail taoDon = new Orders_OrderDetail();
        //taoDon.setBounds(0, 0, 1080, 700);
        //functionPanel1.add(taoDon);
        //Chức năng 2
        functionPanel2 = new JPanel(null);
        functionPanel2.setPreferredSize(new Dimension(1080, 700));
        switchPanel.add(functionPanel2, "func2");
        switchPanel.add(functionPanel1, "func1");
       // this.func1.setBounds(0, 0, 1080, 700);
        functionPanel1.add(func1);
        //chức năng 3
        functionPanel3 = new JPanel(null);
        functionPanel3.setPreferredSize(new Dimension(1080, 700));
        switchPanel.add(functionPanel3, "func3");
        //chức năng 4
        functionPanel4 = new JPanel(null);
        switchPanel.add(functionPanel4, "fun4");
        //chức năng 5
        functionPanel5 = new JPanel(null);
        switchPanel.add(functionPanel5, "func5");
        //chức năng 6
        functionPanel6 = new JPanel();
        switchPanel.add(functionPanel6, "func6");
        //chức năng 7
        functionPanel7 = new JPanel();
        switchPanel.add(functionPanel7, "func7");
        //chức năng 8
        functionPanel8 = new JPanel();
        switchPanel.add(functionPanel8, "func8");


        //---------------------------------------------------------------








        this.setLayout(new BorderLayout());
        this.add(title,BorderLayout.NORTH);
        this.add(leftMenu, BorderLayout.WEST);
        this.add(mainContent, BorderLayout.CENTER);
        
        
    }

    
    public static void main(String[] args) {
		JFrame a = new GiaoDien();
		
	}
}
