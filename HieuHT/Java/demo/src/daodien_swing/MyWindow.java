package daodien_swing;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class MyWindow extends JFrame {
	public MyWindow() {
		super("Demo Windows");
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		JPanel pnFlow1 = new JPanel();
		pnFlow1.setLayout(new BoxLayout(pnFlow1, BoxLayout.Y_AXIS));
		JPanel pnFlow11 = new JPanel();
		JPanel pnFlow12 = new JPanel();
		JPanel pnFlow13 = new JPanel();
		pnFlow1.add(pnFlow11);
		pnFlow1.add(pnFlow12);
		pnFlow1.add(pnFlow13);

		JLabel lbl1 = new JLabel("Hệ số a: ");
		JTextField txtTen1 = new JTextField(15);
		JLabel lbl2 = new JLabel("Hệ số b: ");
		JTextField txtTen2 = new JTextField(15);
		JLabel lbl3 = new JLabel("Hệ số c: ");
		JTextField txtTen3 = new JTextField(15);

		pnFlow11.add(lbl1);
		pnFlow11.add(txtTen1);
		pnFlow12.add(lbl2);
		pnFlow12.add(txtTen2);
		pnFlow13.add(lbl3);
		pnFlow13.add(txtTen3);

		JPanel pnFlow2 = new JPanel();
		JButton button = new JButton("Giải");
		pnFlow2.add(button);

		JPanel pnFlow3 = new JPanel();
		JLabel lbl4 = new JLabel("Kết quả: ");
		JTextField txtTen4 = new JTextField(15);
		pnFlow3.add(lbl4);
		pnFlow3.add(txtTen4);

		Container con = getContentPane();
		getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		con.add(pnFlow1);
		con.add(pnFlow2);
		con.add(pnFlow3);

		setSize(400, 300);
		setLocationRelativeTo(null);
		setVisible(true);
	
	
//		
//		JPanel pnFlow1 = new JPanel();
//		pnFlow1.setLayout(new BoxLayout(pnFlow1, BoxLayout.Y_AXIS));
//		JPanel pnFlow11 = new JPanel();
//		JPanel pnFlow12 = new JPanel();
//		JPanel pnFlow13 = new JPanel();
//		
//		pnFlow1.add(pnFlow11);
//		pnFlow1.add(pnFlow12);
//		pnFlow1.add(pnFlow13);
//		
//		JLabel lbl1 = new JLabel("Nhập hệ số a: ");
//		JTextField txt1 = new JTextField(20);
//		JLabel lbl2 = new JLabel("Nhập hệ số b: ");
//		JTextField txt2 = new JTextField(20);
//		JLabel lbl3 = new JLabel("Nhập hệ số c: ");
//		JTextField txt3 = new JTextField(20);
//		
//		pnFlow11.add(lbl1);
//		pnFlow11.add(txt1);
//		pnFlow12.add(lbl2);
//		pnFlow12.add(txt2);
//		pnFlow13.add(lbl3);
//		pnFlow13.add(txt3);
//		
//		JPanel pnFlow2 = new JPanel();
//		JButton button = new JButton("Giải");
//		pnFlow2.add(button);
//		
//		JPanel pnFlow3 = new JPanel();
//		JLabel jbl4 = new JLabel("Kết quả");
//		JTextField txt4 = new JTextField(20);
//		pnFlow3.add(jbl4);
//		pnFlow3.add(txt4);
//		
//		Container con = getContentPane();
//		getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
//		con.add(pnFlow1);
//		con.add(pnFlow2);
//		con.add(pnFlow3);
//		
//		setSize(400, 300);
//		setLocationRelativeTo(null);
//		setVisible(true);
		
		
		/*
		 * FlowLayout && BoxLayout
		 */
//		JPanel pnFlow = new JPanel();
//		pnFlow.setLayout(new FlowLayout());
//		pnFlow.setLayout(new BoxLayout(pnFlow, BoxLayout.X_AXIS));
//		pnFlow.setBackground(Color.ORANGE);
//		
//		Font font = new Font("Times new roman", Font.CENTER_BASELINE, 18);
//		JButton btn1 = new JButton("Trang chủ");
//		btn1.setForeground(Color.blue);
//	
//		JButton btn2 = new JButton("Hệ thống");
//		btn2.setForeground(Color.yellow);
//		
//		JButton btn3 = new JButton("Cửa hàng");
//		btn3.setForeground(Color.green);
//		
//		JButton btn4 = new JButton("Tiện ích");
//		btn4.setForeground(Color.RED);
//		
//		JButton btn5 = new JButton("Tư vấn");
//		btn5.setForeground(Color.pink);
//		
//		btn1.setFont(font);
//		btn2.setFont(font);
//		btn3.setFont(font);
//		btn4.setFont(font);
//		btn5.setFont(font);
//		
//		pnFlow.add(btn1);
//		pnFlow.add(btn2);
//		pnFlow.add(btn3);
//		pnFlow.add(btn4);
//		pnFlow.add(btn5);
//		
		/*
		 * BorderLayout
		 */
		
//		JPanel pnBorder = new JPanel();
//		pnBorder.setLayout(new BorderLayout());
//		JPanel north = new JPanel();
//		north.setBackground(Color.BLUE);
//		pnBorder.add(north, BorderLayout.NORTH);
//		
//		JPanel south = new JPanel();
//		south.setBackground(Color.CYAN);
//		pnBorder.add(south, BorderLayout.SOUTH);
//		
//		JPanel west = new JPanel();
//		west.setBackground(Color.green);
//		pnBorder.add(west, BorderLayout.WEST);
//		
//		JPanel east = new JPanel();
//		east.setBackground(Color.PINK);
//		pnBorder.add(east, BorderLayout.EAST);
//		
//		JPanel center = new JPanel();
//		center.setBackground(Color.ORANGE);
//		pnBorder.add(center, BorderLayout.CENTER);
//		
//	/*
//	 * JLabel && JTextField
//	 */
//		JLabel jbl = new JLabel("Nhập tên: ");
//		getContentPane().setLayout(new FlowLayout());
//		JTextField txt1 = new JTextField(15);
//		jbl.setForeground(Color.blue);
//		
//		Container con = getContentPane();
//		con.add(pnFlow);
//		con.add(pnBorder);
//		con.add(jbl);
//		con.add(txt1);

	}
	public static void main(String[] args) {
		MyWindow ui = new MyWindow();
		ui.setSize(400, 300);
		ui.setLocationRelativeTo(null);
		ui.setVisible(true);

	
	}

}