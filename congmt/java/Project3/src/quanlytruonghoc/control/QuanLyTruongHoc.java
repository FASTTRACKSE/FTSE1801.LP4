package quanlytruonghoc.control;

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

public class QuanLyTruongHoc extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	JPanel headerPanel, menuPanel, centerPanel, trangChuPanel, sinhVienPanel, timKiemSvPanel, lopPanel, monHocPanel, thongKePanel, cardPanel;
	JButton sinhVienButton, monHocButton, lopButton, thongKeButton, trangChuButton;
	CardLayout card, card2, card4;
	QuanLySinhVien quanLySinhVien;
	QuanLyLopHoc quanLyLopHoc;
	QuanLyMonHoc quanLyMonHoc;
	ThongKeBaoCao thongKeBaoCao;
	TimKiemSinhVien timKiemSinhVien;
	public QuanLyTruongHoc() {
		super("Quản lý trường học");
		quanLyLopHoc = new QuanLyLopHoc();
		quanLySinhVien = new QuanLySinhVien();
		quanLyMonHoc = new QuanLyMonHoc();
		thongKeBaoCao = new ThongKeBaoCao();
		JPanel jPanel = new JPanel();
		timKiemSinhVien = new TimKiemSinhVien();
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
		JLabel tieuDe = new JLabel("Chương trình quản lý trường học");
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
		sinhVienButton = new JButton("Quản lý sinh viên", icon2);
		sinhVienButton.setFont(font);
		sinhVienButton.setPreferredSize(new Dimension(240, 50));
		monHocButton = new JButton("Quản lý môn học", icon4);
		monHocButton.setFont(font);
		monHocButton.setPreferredSize(new Dimension(240, 50));
		lopButton = new JButton("Quản lý lớp học", icon3);
		lopButton.setFont(font);
		lopButton.setPreferredSize(new Dimension(240, 50));
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
		jPanel2.add(sinhVienButton);
		jPanel2.add(monHocButton);
		jPanel2.add(lopButton);
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
		
		sinhVienPanel = new JPanel();
		sinhVienPanel.add(quanLySinhVien.con);
		
		timKiemSvPanel = new JPanel();
		timKiemSvPanel.add(timKiemSinhVien.con);
		
		lopPanel = new JPanel();
		JLabel lopLabel = new JLabel("Quản lý lớp học");lopPanel.add(lopLabel);
		lopPanel.add(quanLyLopHoc.conn);
		
		monHocPanel = new JPanel();
		JLabel monLabel = new JLabel("Quản lý môn học");monHocPanel.add(monLabel);
		
		thongKePanel = new JPanel();
		thongKePanel.add(thongKeBaoCao.con);
		
		

		card = new CardLayout();
		cardPanel.setLayout(card);
		cardPanel.add(sinhVienPanel, "sinhVienPanel");
		cardPanel.add(monHocPanel, "monHocPanel");
		cardPanel.add(lopPanel, "lopPanel");
		cardPanel.add(thongKePanel, "thongKePanel");
		cardPanel.add(trangChuPanel, "trangChuPanel");
		cardPanel.add(timKiemSvPanel, "timKiemSvPanel");

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
		sinhVienButton.addActionListener(this);
		monHocButton.addActionListener(this);
		
		thongKeButton.addActionListener(this);
		trangChuButton.addActionListener(this);
		quanLySinhVien.themSvButton.addActionListener(quanLySinhVien);
		quanLySinhVien.suaSvButton.addActionListener(quanLySinhVien);
		quanLySinhVien.xoaSvButton.addActionListener(quanLySinhVien);
		quanLySinhVien.taoMoiSvButton.addActionListener(quanLySinhVien);
		quanLySinhVien.timkiemSvButton.addActionListener(this);
		lopButton.addActionListener(this);
		quanLyLopHoc.themLopButton.addActionListener(quanLyLopHoc);
		quanLyLopHoc.suaLopButton.addActionListener(quanLyLopHoc);
		quanLyLopHoc.xoaLopButton.addActionListener(quanLyLopHoc);
		quanLyLopHoc.lamMoiLopButton.addActionListener(quanLyLopHoc);
		quanLyLopHoc.xemDsButton.addActionListener(quanLyLopHoc);
		quanLyLopHoc.xemDsButton1.addActionListener(quanLyLopHoc);
		quanLyLopHoc.timkiemLopButton.addActionListener(quanLyLopHoc);
		quanLyLopHoc.troVeButton.addActionListener(quanLyLopHoc);
		quanLyLopHoc.timKiemButton.addActionListener(quanLyLopHoc);
	
		timKiemSinhVien.back.addActionListener(this);
		timKiemSinhVien.xacNhan.addActionListener(timKiemSinhVien);
		timKiemSinhVien.seach.addActionListener(timKiemSinhVien);
		thongKeBaoCao.show1.addActionListener(thongKeBaoCao);
		thongKeBaoCao.show2.addActionListener(thongKeBaoCao);
		
	}
	
	public static void main(String[] args) {
		QuanLyTruongHoc qlth = new QuanLyTruongHoc();
		qlth.display();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == sinhVienButton) {
			card.show(cardPanel, "sinhVienPanel");
		} else if (e.getSource() == monHocButton) {
			card.show(cardPanel, "monHocPanel");
		} else if (e.getSource() == lopButton) {
			card.show(cardPanel, "lopPanel");
		}else if (e.getSource() == quanLyLopHoc.troVeButton) {
			card.show(cardPanel, "lopPanel");
		} else if (e.getSource() == quanLyLopHoc.timkiemLopButton) {
			card.show(cardPanel, "timKiemLopPanel");
		} else if (e.getSource() == quanLyLopHoc.xemDsButton) {
			card2.show(quanLyLopHoc.lopBang, "bang 1");
		} else if (e.getSource() == quanLyLopHoc.xemDsButton1) {
			card2.show(quanLyLopHoc.lopBang, "bang 2");
		} else if (e.getSource() == quanLyLopHoc.timKiemButton) {
			card4.show(quanLyLopHoc.timKiemBang, "bang 1");
		} else if (e.getSource() == thongKeButton) {
			card.show(cardPanel, "thongKePanel");
		} else if (e.getSource() == trangChuButton) {
			card.show(cardPanel, "trangChuPanel");
		} else if (e.getSource() == quanLySinhVien.timkiemSvButton) {
			card.show(cardPanel, "timKiemSvPanel");
		} else if (e.getSource() == timKiemSinhVien.back) {
			card.show(cardPanel, "sinhVienPanel");
		}
	}

}
