package quanly.view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
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

import quanly.entity.GiaoDich;
import quanly.entity.KhachHang;
import quanly.model.DangNhapDAO;
import quanly.model.GiaoDichDAO;
import quanly.model.MayAtmDAO;

public class MayATMView extends JFrame {

	private static final long serialVersionUID = 1L;

	JPanel pnCenter, pnTitle, pnNhap, pnDangNhap, pnMayATM, pnThongTin, pnRutTien, pnThoat;
	JPanel jPanel, pnAllCenter, pnMenu, pnSouth, pnButton, cardLayout;
	JPanel pnLabel1, pnLabel2, pnThongTinKH, pnLabel3, pnButton2;
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
	String soTheAtm;
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

	public void thongTinKH(KhachHang khachHang) {
		
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
		pnThongTin.setLayout(new GridLayout(1,2));
		pnLabel1 = new JPanel();
		pnLabel1.setLayout(new GridBagLayout());
		lbMaKH = new JLabel("Mã khách hàng");
		lbTen = new JLabel("Họ tên khách hàng");
		lbDiaChi = new JLabel("Địa chỉ nhà");
		lbQuan = new JLabel("Quận");
		lbPhuong = new JLabel("Phường");
		
		maKH = new JTextField(15);
		ten = new JTextField(15);
		diaChi = new JTextField(15);
		quan = new JTextField(15);
		phuong = new JTextField(15);
		
		maKH.setText(khachHang.getMaKH());
		ten.setText(khachHang.getTenKH());
		diaChi.setText(khachHang.getDiaChi());
		phuong.setText(khachHang.getPhuong());
		quan.setText(khachHang.getQuan());
		
		addItem(pnLabel1, lbMaKH, 0, 0, 1, 1, GridBagConstraints.EAST);
		addItem(pnLabel1, lbTen, 0, 1, 1, 1, GridBagConstraints.EAST);
		addItem(pnLabel1, lbDiaChi, 0, 2, 1, 1, GridBagConstraints.EAST);
		addItem(pnLabel1, lbQuan, 0, 3, 1, 1, GridBagConstraints.EAST);
		addItem(pnLabel1, lbPhuong, 0, 4, 1, 1, GridBagConstraints.EAST);

		addItem(pnLabel1, maKH, 1, 0, 2, 1, GridBagConstraints.WEST);
		addItem(pnLabel1, ten, 1, 1, 2, 1, GridBagConstraints.WEST);
		addItem(pnLabel1, diaChi, 1, 2, 2, 1, GridBagConstraints.WEST);
		addItem(pnLabel1, quan, 1, 3, 2, 1, GridBagConstraints.WEST);
		addItem(pnLabel1, phuong, 1, 4, 2, 1, GridBagConstraints.WEST);
		pnThongTin.add(pnLabel1);

		pnLabel2 = new JPanel();
		pnLabel2.setLayout(new GridBagLayout());
		lbSoDT = new JLabel("Số điện thoại");
		lbEmail = new JLabel("Email");
		lbSoThe = new JLabel("Số thẻ");
		lbSoTK = new JLabel("Số tài khoản ngân hàng");
		lbSoTien = new JLabel("Số tiền trong tài khoản");
		
		soDT = new JTextField(15);
		email = new JTextField(15);
		soThe = new JTextField(15);
		soTK = new JTextField(15);
		soTien = new JTextField(15);
		
		soDT.setText(khachHang.getSoDT());
		email.setText(khachHang.getEmail());
		soThe.setText(khachHang.getSoTheATM());
		soTK.setText(khachHang.getSoTK());
		soTien.setText(khachHang.getSoTienTrongTK());

		addItem(pnLabel2, lbSoDT, 0, 0, 1, 1, GridBagConstraints.EAST);
		addItem(pnLabel2, lbEmail, 0, 1, 1, 1, GridBagConstraints.EAST);
		addItem(pnLabel2, lbSoThe, 0, 2, 1, 1, GridBagConstraints.EAST);
		addItem(pnLabel2, lbSoTK, 0, 3, 1, 1, GridBagConstraints.EAST);
		addItem(pnLabel2, lbSoTien, 0, 4, 1, 1, GridBagConstraints.EAST);

		addItem(pnLabel2, soDT, 1, 0, 2, 1, GridBagConstraints.WEST);
		addItem(pnLabel2, email, 1, 1, 2, 1, GridBagConstraints.WEST);
		addItem(pnLabel2, soThe, 1, 2, 2, 1, GridBagConstraints.WEST);
		addItem(pnLabel2, soTK, 1, 3, 2, 1, GridBagConstraints.WEST);
		addItem(pnLabel2, soTien, 1, 4, 2, 1, GridBagConstraints.WEST);
		pnThongTin.add(pnLabel2);
		

		// Phần rút tiền
		pnRutTien = new JPanel();
		pnLabel3 = new JPanel();
		lbRutTien = new JLabel("Nhập số tiền cần rút");
		txtRutTien = new JTextField(10);
		pnLabel3.add(lbRutTien);
		pnLabel3.add(txtRutTien);

		pnButton2 = new JPanel();
		btRut = new JButton("Rút tiền");
		btRut.addActionListener(actionListener);
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
	
	/**
	 * Sắp xếp button
	 * 
	 * @param p
	 * @param c
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 * @param align
	 */
	public void addItem(JPanel p, JComponent c, int x, int y, int width, int height, int align) {
		GridBagConstraints gc = new GridBagConstraints();
		gc.gridx = x;
		gc.gridy = y;
		gc.gridwidth = width;
		gc.gridheight = height;
		gc.weightx = 100.0;
		gc.weighty = 100.0;
		gc.insets = new Insets(5, 5, 5, 5);
		gc.anchor = align;
		gc.fill = GridBagConstraints.NONE;
		p.add(c, gc);
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

	public boolean kiemTraSoTien() {
		boolean kiemTra = true;
		String pantter = "[1-9][0-9]*0000";
		if (!txtRutTien.getText().matches(pantter)) {
			kiemTra = false;
		}
		return kiemTra;
	}
	
	ActionListener actionListener = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {

			if (e.getSource() == btDangNhap) {
				soTheAtm = txtTaiKhoan.getText(); //nhẩy jputon kolays được txt
				dangNhapDAO = new DangNhapDAO();
				if (dangNhapDAO.dangNhap(soTheAtm, txtPin.getText())) {
				khachHang = dangNhapDAO.showKhachHangTheoMaKH(txtTaiKhoan.getText());
				MayATMView mayATM = new MayATMView(maMayATM);
				mayATM.display();
				mayATM.thongTinKH(khachHang);
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
			
			if (e.getSource()==btRut) {
				MayAtmDAO atmDAO = new MayAtmDAO();
				KhachHang khachHang = new KhachHang();
				GiaoDich giaoDich = new GiaoDich();
				DangNhapDAO dangNhapDAO = new DangNhapDAO();
				GiaoDichDAO giaoDichDAO = new GiaoDichDAO();
				if (kiemTraSoTien()) {
					String soTienRut = txtRutTien.getText();
					JOptionPane.showMessageDialog(null, soTheAtm);
					if (dangNhapDAO.kiemTraTienMayATM(atmDAO.showMayATMMaMay(maMayATM), soTienRut)) {
						if (dangNhapDAO.rutTien(dangNhapDAO.showKhachHangTheoMaKH(txtTaiKhoan.getText()), soTienRut)) {
							giaoDichDAO.addThongTinGiaoDich(soTienRut, giaoDichDAO.layThongTinMaThe(txtTaiKhoan.getText()), maMayATM);
							giaoDichDAO.updateMayATM(atmDAO.showMayATMMaMay(maMayATM), txtRutTien.getText());
							giaoDich = giaoDichDAO.layMaGiaoDich();
							khachHang = dangNhapDAO.showKhachHangTheoMaKH(txtTaiKhoan.getText());
							tableModel.setRowCount(0);
							tableModel.addRow(new String[] {(""+giaoDich.getMaGiaoDich()), giaoDich.getThoiGian(), txtRutTien.getText(),khachHang.getSoTienTrongTK()});
						}else {
							JOptionPane.showMessageDialog(null, "Số tiền trong thẻ không đủ để rút");
						}
					}else {
						JOptionPane.showMessageDialog(null, "Số tiền trong máy không đủ để rút");
					}
				} else {
					JOptionPane.showMessageDialog(null, "Số tiền phải là bội số của 10000");
				}
			} else {

			}
		}
	};
}
