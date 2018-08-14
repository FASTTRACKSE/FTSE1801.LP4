package quanlynhatro.control;


import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class QuanLyNhaNghi extends JFrame implements ActionListener{
	JPanel headerPanel, menuPanel, centerPanel, trangChuPanel, khachHangPanel, phongPanel, dichVuPanel, thongKePanel, ghiChuPanel, dangNhapPanel, cardPanel;
	JButton khachHangButton, dichVuButton, phongButton, thongKeButton, trangChuButton, ghiChuButton;
	CardLayout card;
	public QuanLyNhaNghi() {
		super("Quản lý nhà nghỉ");
		JPanel jPanel = new JPanel();
		jPanel.setLayout(new BorderLayout());

		/**
		 * Tạo header
		 */

		headerPanel = new JPanel();
		headerPanel.setBackground(Color.GREEN);
		jPanel.add(headerPanel, BorderLayout.NORTH);
		headerPanel.setPreferredSize(new Dimension(1000, 150));
		ImageIcon img = new ImageIcon("img\\ft.png");
		JLabel lblImg = new JLabel(img);

		lblImg.setPreferredSize(new Dimension(300, 140));
		JLabel tieuDe = new JLabel("Chương trình quản lý nhà nghỉ");
		Font fontTieuDe = new Font("Arial", Font.BOLD | Font.ITALIC, 50);
		tieuDe.setFont(fontTieuDe);

		headerPanel.add(lblImg);
		headerPanel.add(tieuDe);

		/**
		 * Tạo phần menu
		 */

		menuPanel = new JPanel();
		JPanel jPanel2 = new JPanel();
		Font font = new Font("Arial", Font.BOLD | Font.ITALIC, 25);
		menuPanel.setBackground(Color.CYAN);
		menuPanel.setPreferredSize(new Dimension(300, 700));
		jPanel.add(menuPanel, BorderLayout.WEST);
		ImageIcon icon1 = new ImageIcon("img\\home-icon.png");
		ImageIcon icon2 = new ImageIcon("img\\Student-3-icon.png");
		ImageIcon icon3 = new ImageIcon("img\\Science-Classroom-icon.png");
		ImageIcon icon4 = new ImageIcon("img\\books-icon.png");
		ImageIcon icon5 = new ImageIcon("img\\Food-List-Ingredients-icon.png");
		khachHangButton = new JButton("Quản lý sinh viên", icon2);
		khachHangButton.setFont(font);
		khachHangButton.setPreferredSize(new Dimension(240, 50));
		dichVuButton = new JButton("Quản lý môn học", icon4);
		dichVuButton.setFont(font);
		dichVuButton.setPreferredSize(new Dimension(240, 50));
		phongButton = new JButton("Quản lý lớp học", icon3);
		phongButton.setFont(font);
		phongButton.setPreferredSize(new Dimension(240, 50));
		thongKeButton = new JButton("Bảng thống kê", icon5);
		thongKeButton.setFont(font);
		thongKeButton.setPreferredSize(new Dimension(240, 50));
		trangChuButton = new JButton("Trang chủ", icon1);
		trangChuButton.setFont(font);
		trangChuButton.setPreferredSize(new Dimension(240, 50));
		ImageIcon img10 = new ImageIcon("img\\ab.jpg");
		menuPanel.setPreferredSize(new Dimension(240, 50));
		JLabel lblImg10 = new JLabel(img10);
		ImageIcon img11 = new ImageIcon("img\\ft1.jpg");
		menuPanel.setPreferredSize(new Dimension(240, 50));
		JLabel lblImg11 = new JLabel(img11);
		menuPanel.add(jPanel2);

		jPanel2.add(trangChuButton);
		jPanel2.add(khachHangButton);
		jPanel2.add(dichVuButton);
		jPanel2.add(phongButton);
		jPanel2.add(thongKeButton);
		jPanel2.add(lblImg10);
		jPanel2.add(lblImg11);
		menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.Y_AXIS));

		/**
		 * Tạo phần center
		 */

		centerPanel = new JPanel();
		centerPanel.setBackground(Color.PINK);
		jPanel.add(centerPanel, BorderLayout.CENTER);

		cardPanel = new JPanel();
		cardPanel.setLayout(new BoxLayout(cardPanel, BoxLayout.Y_AXIS));
		centerPanel.add(cardPanel);

		trangChuPanel = new JPanel();
		JPanel tieudePanel = new JPanel();
		trangChuPanel.setLayout(new BoxLayout(trangChuPanel, BoxLayout.Y_AXIS));
		tieudePanel.setLayout(new BoxLayout(tieudePanel, BoxLayout.Y_AXIS));
		JLabel jLabel = new JLabel("Trang chủ");
		Font fontTieuDe1 = new Font("Arial", Font.BOLD | Font.ITALIC, 40);
		jLabel.setFont(fontTieuDe1);
		tieudePanel.add(jLabel);
		tieudePanel.setAlignmentX(CENTER_ALIGNMENT);

		JPanel pnImg = new JPanel();
		pnImg.setLayout(new BoxLayout(pnImg, BoxLayout.X_AXIS));
		ImageIcon img1 = new ImageIcon("img\\ab1.jpg");
		JLabel lblImg1 = new JLabel(img1);

		JPanel pnImg1 = new JPanel();
		pnImg1.setLayout(new BoxLayout(pnImg1, BoxLayout.Y_AXIS));
		ImageIcon img2 = new ImageIcon("img\\ab2.jpg");
		JLabel lblImg2 = new JLabel(img2);
		ImageIcon img3 = new ImageIcon("img\\ab.jpg");
		JLabel lblImg3 = new JLabel(img3);
		pnImg.add(lblImg1);
		pnImg1.add(lblImg2);
		pnImg1.add(lblImg3);
		pnImg.add(pnImg1);
		trangChuPanel.add(tieudePanel);
		trangChuPanel.add(pnImg);
		
		khachHangPanel = new JPanel();
		
		phongPanel = new JPanel();
		JLabel lopLabel = new JLabel("Quản lý lớp học");phongPanel.add(lopLabel);
		
		dichVuPanel = new JPanel();
		JLabel monLabel = new JLabel("Quản lý môn học");dichVuPanel.add(monLabel);
		
		thongKePanel = new JPanel();
		
		

		card = new CardLayout();
		cardPanel.setLayout(card);
		cardPanel.add(khachHangPanel, "khachHangPanel");
		cardPanel.add(dichVuPanel, "dichVuPanel");
		cardPanel.add(phongPanel, "phongPanel");
		cardPanel.add(thongKePanel, "thongKePanel");
		cardPanel.add(trangChuPanel, "trangChuPanel");

		card.show(cardPanel, "trangChuPanel");

		Container con = getContentPane();
		con.add(jPanel);
		display();
		setAction();
	}
	
	
	public void display() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(1700, 950);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public void setAction() {
		khachHangButton.addActionListener(this);
		dichVuButton.addActionListener(this);
		phongButton.addActionListener(this);
		thongKeButton.addActionListener(this);
		trangChuButton.addActionListener(this);

		
	}
	
	public static void main(String[] args) {
		QuanLyNhaNghi ql = new QuanLyNhaNghi();
		ql.display();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == khachHangButton) {
			card.show(cardPanel, "khachHangPanel");
		} else if (e.getSource() == dichVuButton) {
			card.show(cardPanel, "dichVuPanel");
		} else if (e.getSource() == phongButton) {
			card.show(cardPanel, "phongPanel");
		} else if (e.getSource() == thongKeButton) {
			card.show(cardPanel, "thongKePanel");
		} else if (e.getSource() == trangChuButton) {
			card.show(cardPanel, "trangChuPanel");
		} 
	}

}
