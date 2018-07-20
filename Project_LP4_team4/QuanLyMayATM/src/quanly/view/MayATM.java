package quanly.view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.tree.DefaultMutableTreeNode;

public class MayATM extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;

	JPanel pnCenter, pnTitle, pnNhap, pnDangNhap, pnMayATM;
	JPanel jPanel;
	JLabel title, title2, lbAccount, lbPin;
	JTextField txtTaiKhoan, txtPin;
	Border border;
	TitledBorder titledBorder;
	JButton btDangNhap;

	// public void mayATM() {
	// Container con = getContentPane();
	// con.setLayout(new BorderLayout());
	// pnTitle = new JPanel();
	// title = new JLabel("MÁY ATM");
	// title.setFont(new Font("Times New Roman", Font.BOLD, 30));
	// title.setForeground(Color.RED);
	// pnTitle.add(title);
	//
	// pnCenter = new JPanel();
	// border = BorderFactory.createLineBorder(Color.BLUE, 3, true);
	// titledBorder = new TitledBorder(border,"Program");
	// pnCenter.setBorder(titledBorder);
	//
	// pnMayATM = new JPanel();
	// pnMayATM.setLayout(new BoxLayout(pnMayATM, BoxLayout.Y_AXIS));
	// pnDangNhap = new JPanel();
	// lbAccount = new JLabel("Nhập số tài khoản");
	// txtTaiKhoan = new JTextField(10);
	// pnDangNhap.add(lbAccount);pnDangNhap.add(txtTaiKhoan);
	// lbPin = new JLabel("Nhập mã Pin");
	// txtPin = new JTextField(10);
	// pnDangNhap.add(lbPin);pnDangNhap.add(txtPin);
	// pnMayATM.add(pnDangNhap);
	//
	// btDangNhap = new JButton("Đăng nhập");
	// pnMayATM.add(btDangNhap);
	// pnCenter.add(pnMayATM);
	//
	//
	//
	// con.add(pnTitle, "North");
	// con.add(pnCenter, "Center");
	//
	// }
	JPanel pnAllCenter, pnMenu, pnSouth, pnButton;
	JPanel pnThongTin, pnRutTien, pnThoat;
	JPanel pnLabel1, pnTextField1;
	JLabel logoname;
	JTable table;
	JButton btThongTin, btRutTien, btThoat;
	JLabel lbMaKH, lbTen, lbDiaChi, lbQuan, lbPhuong, lbSoDT, lbEmail, lbSoThe, lbSoTK, lbSoTien;
	JTextField maKH, ten, diaChi, quan, phuong, soDT, email, soThe, soTK, soTien;
	CardLayout card;
	Container con;

	public void thongTinKH() {

		con = getContentPane();
		con.setLayout(new BorderLayout());
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
		con.add(pnTitle, "North");

		/**
		 * Phan Menu
		 */
		pnButton = new JPanel();
		btThongTin = new JButton("Thông tin tài khoản");
		btRutTien = new JButton("Rút tiền");
		btThoat = new JButton("Thoát");
		pnButton.add(btThongTin);
		pnButton.add(btRutTien);
		pnButton.add(btThoat);
		pnMenu.add(new JScrollPane(pnButton), BorderLayout.CENTER);
		pnMenu.setBorder(BorderFactory.createTitledBorder("Menu"));
		con.add(pnMenu, "South");
		//
		pnAllCenter = new JPanel();
		pnAllCenter.setBorder(BorderFactory.createTitledBorder("ProGram"));
		JScrollPane pane = new JScrollPane(pnAllCenter);

		pnThongTin = new JPanel();
		pnLabel1 = new JPanel();
		pnLabel1.setLayout(new BoxLayout(pnLabel1, BoxLayout.Y_AXIS));
		lbMaKH = new JLabel("Mã khách hàng");
		lbTen = new JLabel("Họ tên khách hàng");
		lbDiaChi = new JLabel("Địa chỉ nhà");
		lbQuan = new JLabel("Quận");
		lbPhuong = new JLabel("Phường");
		lbSoDT = new JLabel("Số điện thoại");
		lbEmail = new JLabel("Email");
		lbSoThe = new JLabel("Số thẻ");
		lbSoTK = new JLabel("Số tài khoản ngân hàng");
		lbSoTien = new JLabel("Số tiền trong tài khoản");
		pnLabel1.add(lbMaKH);pnLabel1.add(lbTen);pnLabel1.add(lbDiaChi);pnLabel1.add(lbQuan);
		pnLabel1.add(lbPhuong);pnLabel1.add(lbSoDT);pnLabel1.add(lbEmail);pnLabel1.add(lbSoThe);
		pnLabel1.add(lbSoTK);pnLabel1.add(lbSoTien);
		pnThongTin.add(pnLabel1);
		
		pnTextField1 = new JPanel();
		pnTextField1.setLayout(new BoxLayout(pnTextField1, BoxLayout.Y_AXIS));
		maKH = new JTextField(10);
		ten = new JTextField(10);
		diaChi = new JTextField(10);
		quan = new JTextField(10);
		phuong = new JTextField(10);
		soDT = new JTextField(10);
		email = new JTextField(10);
		soThe = new JTextField(10);
		soTK = new JTextField(10);
		soTien = new JTextField(10);
		pnTextField1.add(maKH);pnTextField1.add(ten);pnTextField1.add(diaChi);pnTextField1.add(quan);
		pnTextField1.add(phuong);pnTextField1.add(soDT);pnTextField1.add(email);pnTextField1.add(soThe);
		pnTextField1.add(soTK);pnTextField1.add(soTien);
		pnThongTin.add(pnTextField1);
		
		
		
		
		
		
		
		
		pnAllCenter.add(pnThongTin);
		
//		card = new CardLayout();
//		pnAllCenter.setLayout(card);

		con.add(pnSouth, "West");
		con.add(pane, "Center");

	}

	public void display() {
		setSize(800, 600);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		MayATM atm = new MayATM();
		// atm.mayATM();
		atm.thongTinKH();
		atm.display();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btThongTin) {

		}

	}
}
