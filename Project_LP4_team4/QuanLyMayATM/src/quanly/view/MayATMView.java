package quanly.view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import quanly.entity.KhachHang;
import quanly.model.DangNhapDAO;

public class MayATMView extends JFrame {

	private static final long serialVersionUID = 1L;

	JPanel pnCenter, pnTitle, pnNhap, pnDangNhap, pnMayATM, pnThongTin, pnRutTien, pnThoat;
	JPanel jPanel, pnAllCenter, pnMenu, pnSouth, pnButton, pnThongtinGD, cardLayout;
	JPanel pnLabel1, pnLabel2, pnTextField1, pnTextField2, pnLabel3, pnButton2;
	JLabel title, title2, logoname, lbAccount, lbPin;
	JLabel lbMaKH, lbTen, lbDiaChi, lbQuan, lbPhuong, lbSoDT, lbEmail, lbSoThe, lbSoTK, lbSoTien, lbRutTien;
	JTextField txtTaiKhoan, txtPin, txtRutTien;
	JTextField maKH, ten, diaChi, quan, phuong, soDT, email, soThe, soTK, soTien;
	Border border;
	TitledBorder titledBorder;
	JButton btDangNhap, btThongTin, btRutTien, btThoatGD, btRut;
	DefaultTableModel tableModel;
	JTable table;
	CardLayout card;
	Container conn;
	String maMayATM;
	DangNhapDAO dangNhapDAO;
	KhachHang khachHang;
	
	public MayATMView(String maMay) {
		display();
		maMayATM = maMay;
	}

	public void mayATM() {
		conn = getContentPane();
		conn.setLayout(new BorderLayout());
		pnTitle = new JPanel();
		title = new JLabel("MÁY ATM");
		title.setFont(new Font("Times New Roman", Font.BOLD, 30));
		title.setForeground(Color.RED);
		pnTitle.add(title);

		pnCenter = new JPanel();
		border = BorderFactory.createLineBorder(Color.BLUE, 3, true);
		titledBorder = new TitledBorder(border, "Program");
		pnCenter.setBorder(titledBorder);

		pnMayATM = new JPanel();
		pnMayATM.setLayout(new BoxLayout(pnMayATM, BoxLayout.Y_AXIS));
		pnDangNhap = new JPanel();
		lbAccount = new JLabel("Nhập số tài khoản");
		txtTaiKhoan = new JTextField(10);
		pnDangNhap.add(lbAccount);
		pnDangNhap.add(txtTaiKhoan);
		lbPin = new JLabel("Nhập mã Pin");
		txtPin = new JTextField(10);
		pnDangNhap.add(lbPin);
		pnDangNhap.add(txtPin);
		pnMayATM.add(pnDangNhap);

		btDangNhap = new JButton("Đăng nhập");
		btDangNhap.addActionListener(actionListener);
		pnMayATM.add(btDangNhap);
		pnCenter.add(pnMayATM);

		conn.add(pnTitle, "North");
		conn.add(pnCenter, "Center");
	}

	public void thongTinKH(String tenKH) {
		
		conn = getContentPane();
		conn.setLayout(new BorderLayout());
		pnTitle = new JPanel();
		pnMenu = new JPanel();
		pnAllCenter = new JPanel();
		pnSouth = new JPanel();
		pnCenter = new JPanel();

		pnTitle.setBackground(Color.LIGHT_GRAY);
		pnMenu.setBackground(Color.LIGHT_GRAY);
		pnAllCenter.setBackground(Color.LIGHT_GRAY);
		pnSouth.setBackground(Color.LIGHT_GRAY);
		pnCenter.setBackground(Color.LIGHT_GRAY);

		logoname = new JLabel("Máy ATM");
		logoname.setFont(new Font("Times New Roman", Font.BOLD, 45));
		logoname.setForeground(Color.BLUE);
		pnTitle.add(logoname);
		conn.add(pnTitle, "North");

		// Phần Menu
		pnButton = new JPanel();
		btThongTin = new JButton("Thông tin tài khoản");
		btRutTien = new JButton("Rút tiền");
		btThoatGD = new JButton("Thoát");
		pnButton.add(btThongTin);
		pnButton.add(btRutTien);
		pnButton.add(btThoatGD);
		pnMenu.add(new JScrollPane(pnButton), BorderLayout.CENTER);
		pnMenu.setBorder(BorderFactory.createTitledBorder("Menu"));
		conn.add(pnMenu, "South");

		pnAllCenter = new JPanel();
		pnAllCenter.setBorder(BorderFactory.createTitledBorder("ProGram"));
		JScrollPane pane = new JScrollPane(pnAllCenter);

		// Phần thông tin khách hàng
		pnThongTin = new JPanel();
		pnLabel1 = new JPanel();
		pnLabel1.setLayout(new BoxLayout(pnLabel1, BoxLayout.Y_AXIS));
		lbMaKH = new JLabel("Mã khách hàng");
		lbTen = new JLabel("Họ tên khách hàng");
		lbDiaChi = new JLabel("Địa chỉ nhà");
		lbQuan = new JLabel("Quận");
		lbPhuong = new JLabel("Phường");

		pnLabel1.add(lbMaKH);
		pnLabel1.add(lbTen);
		pnLabel1.add(lbDiaChi);
		pnLabel1.add(lbQuan);
		pnLabel1.add(lbPhuong);
		pnThongTin.add(pnLabel1);

		pnTextField1 = new JPanel();
		pnTextField1.setLayout(new BoxLayout(pnTextField1, BoxLayout.Y_AXIS));
		maKH = new JTextField(10);
		ten = new JTextField(10);
		diaChi = new JTextField(10);
		quan = new JTextField(10);
		phuong = new JTextField(10);
		ten.setText(tenKH);
		pnTextField1.add(maKH);
		pnTextField1.add(ten);
		pnTextField1.add(diaChi);
		pnTextField1.add(quan);
		pnTextField1.add(phuong);
		pnThongTin.add(pnTextField1);

		pnLabel2 = new JPanel();
		pnLabel2.setLayout(new BoxLayout(pnLabel2, BoxLayout.Y_AXIS));
		lbSoDT = new JLabel("Số điện thoại");
		lbEmail = new JLabel("Email");
		lbSoThe = new JLabel("Số thẻ");
		lbSoTK = new JLabel("Số tài khoản ngân hàng");
		lbSoTien = new JLabel("Số tiền trong tài khoản");
		pnLabel2.add(lbSoDT);
		pnLabel2.add(lbEmail);
		pnLabel2.add(lbSoThe);
		pnLabel2.add(lbSoTK);
		pnLabel2.add(lbSoTien);
		pnThongTin.add(pnLabel2);

		pnTextField2 = new JPanel();
		pnTextField2.setLayout(new BoxLayout(pnTextField2, BoxLayout.Y_AXIS));
		soDT = new JTextField(10);
		email = new JTextField(10);
		soThe = new JTextField(10);
		soTK = new JTextField(10);
		soTien = new JTextField(10);
		pnTextField2.add(soDT);
		pnTextField2.add(email);
		pnTextField2.add(soThe);
		pnTextField2.add(soTK);
		pnTextField2.add(soTien);
		pnThongTin.add(pnTextField2);

		// Phần rút tiền
		pnRutTien = new JPanel();
		pnLabel3 = new JPanel();
		lbRutTien = new JLabel("Nhập số tiền cần rút");
		txtRutTien = new JTextField(10);
		pnLabel3.add(lbRutTien);
		pnLabel3.add(txtRutTien);

		pnButton2 = new JPanel();
		btRut = new JButton("Rút tiền");
		pnButton2.add(btRut);
		pnRutTien.add(pnLabel3);
		pnRutTien.add(pnButton2);

		border = BorderFactory.createLineBorder(Color.BLUE, 3, true);
		titledBorder = new TitledBorder(border, "Danh sách thông tin khách hàng");
		tableModel = new DefaultTableModel();
		tableModel.addColumn("Mã giao dịch");
		tableModel.addColumn("Thời gian");
		tableModel.addColumn("Số tiền rút");
		tableModel.addColumn("Số tiền còn lại");

		table = new JTable(tableModel);
		JScrollPane jScrollPane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		jScrollPane.setBorder(titledBorder);
		pnRutTien.add(jScrollPane);
		pnRutTien.setLayout(new BoxLayout(pnRutTien, BoxLayout.Y_AXIS));

		card = new CardLayout();
		cardLayout = new JPanel();
		pnAllCenter.add(cardLayout);
		cardLayout.setLayout(card);
		cardLayout.add(pnThongTin, "thongTin");
		cardLayout.add(pnRutTien, "rutTien");

		conn.add(pnSouth, "West");
		conn.add(pane, "Center");
		getAction();
	}

	public void getAction() {
		btThongTin.addActionListener(actionListener);
		btRutTien.addActionListener(actionListener);
		btThoatGD.addActionListener(actionListener);
	}

	public void display() {
		setSize(800, 750);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	ActionListener actionListener = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {

			if (e.getSource() == btDangNhap) {
				dangNhapDAO = new DangNhapDAO();
				if (dangNhapDAO.dangNhap(txtTaiKhoan.getText(), txtPin.getText())) {
				khachHang = dangNhapDAO.showKhachHangTheoMaKH(txtTaiKhoan.getText());
				MayATMView mayATM = new MayATMView(maMayATM);
				mayATM.display();
				mayATM.thongTinKH(khachHang.getTenKH());
				}else {
					JOptionPane.showMessageDialog(null, "Sai số tài khoản hoặc pass");
				}
				
			} else if (e.getSource() == btThongTin) {
				card.show(cardLayout, "thongTin");
			} else if (e.getSource() == btRutTien) {
				card.show(cardLayout, "rutTien");
			} else if (e.getSource() == btThoatGD) {
				dispose(); // Destroy the JFrame object
			}
		}
	};
}
