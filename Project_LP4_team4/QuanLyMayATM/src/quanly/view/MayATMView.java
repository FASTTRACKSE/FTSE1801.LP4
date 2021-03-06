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
import quanly.entity.MayATM;
import quanly.model.DangNhapDAO;
import quanly.model.GiaoDichDAO;
import quanly.model.KhachHangDAO;
import quanly.model.MayAtmDAO;
import quanly.model.TheAtmDAO;

public class MayATMView extends JFrame {

	private static final long serialVersionUID = 1L;

	JPanel pnCenter, pnTitle, pnNhap, pnDangNhap, pnMayATM, pnThongTin, pnRutTien, pnDoiMaPin, pnThoat, pnThongTinATM;
	JPanel jPanel, pnAllCenter, pnMenu, pnSouth, pnButton, cardLayout;
	JPanel pnLabel1, pnLabel2, pnThongTinKH, pnLabel3, pnButton2, pnLabel4, pnButton3, pnButton4;
	JLabel title, title2, logoname, lbAccount, lbPin, lpPinCu, lpPinMoi, lpPinMoi2;
	JLabel lbSoCMND, lbTen, lbDiaChi, lbQuan, lbPhuong, lbSoDT, lbEmail, lbSoThe, lbSoTK, lbSoTien, lbRutTien,
			lbDiaChi2, lbQuan2, lbPhuong2;
	JTextField txtSoTheATM, txtPin, txtRutTien, txtPinCu, txtPinMoi, txtPinMoi2;
	JTextField soCMND, ten, diaChi, quan, phuong, soDT, email, soThe, soTK, soTien, txtDiaChi, txtQuan, txtPhuong;
	Border border;
	TitledBorder titledBorder;
	JButton btDangNhap, btThongTin, btRutTien, btThoatGD, btRut, btDoiPin, btXacNhan, btHuy;
	DefaultTableModel tableModel;
	JTable table;
	CardLayout card;
	Container conn;
	String maMayATM;
	static String sotheATM = null;
	static String maPinCu = null;
	DangNhapDAO dangNhapDAO;
	KhachHangDAO khachHangDAO;
	MayAtmDAO mayAtmDAO;
	GiaoDichDAO giaoDichDAO;
	TheAtmDAO theAtmDAO;
	KhachHang khachHang;
	GiaoDich giaoDich;
	MayATM mayATM;

	/**
	 * Sự kiện cho các button
	 */
	ActionListener actionListener = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {

			if (e.getSource() == btDangNhap) {
				sotheATM = txtSoTheATM.getText();
				dangNhapDAO = new DangNhapDAO();
				if (dangNhapDAO.dangNhap(sotheATM, txtPin.getText())) {
					KhachHang khachHang1 = khachHangDAO.showKhachHangTheoSoThe(sotheATM);
					
					MayATMView mayATM = new MayATMView(maMayATM);
					mayATM.display();
					mayATM.thongTinKH(khachHang1, mayAtmDAO.showMayATMMaMay(maMayATM));
					maPinCu = txtPin.getText();
					txtSoTheATM.setText("");
					txtPin.setText("");
				} else {
					JOptionPane.showMessageDialog(null, "Sai số tài khoản hoặc pass");
				}

			} else if (e.getSource() == btThongTin) {
				card.show(cardLayout, "thongTin");
			} else if (e.getSource() == btRutTien) {
				card.show(cardLayout, "rutTien");
			} else if (e.getSource() == btDoiPin) {
				card.show(cardLayout, "doiPin");
			} else if (e.getSource() == btThoatGD) {
				int output = JOptionPane.showConfirmDialog(null, "Bạn có muốn thoát giao dịch", "TPBank Đà Nẵng",
						JOptionPane.YES_NO_OPTION);
				if (output == JOptionPane.YES_OPTION) {
					dispose(); // Destroy the JFrame object
				} else if (output == JOptionPane.NO_OPTION) {
				}

			}

			if (e.getSource() == btRut) {
				int output = JOptionPane.showConfirmDialog(null, "Rút tiền", "TPBank Đà Nẵng",
						JOptionPane.YES_NO_OPTION);
				if (output == JOptionPane.YES_OPTION) {
					if (kiemTraSoTien()) {
						String soTienRut = txtRutTien.getText();
						if (dangNhapDAO.kiemTraTienMayATM(mayAtmDAO.showMayATMMaMay(maMayATM), soTienRut)) {
							if (khachHangDAO.rutTien(khachHangDAO.showKhachHangTheoSoThe(sotheATM), soTienRut)) {
								mayAtmDAO.updateMayAtmRutTien(mayAtmDAO.showMayATMMaMay(maMayATM), soTienRut);
								giaoDichDAO.addThongTinGiaoDich(soTienRut, theAtmDAO.layThongTinMaThe(sotheATM),
										maMayATM, khachHangDAO.layMaKH(sotheATM));
								giaoDich = giaoDichDAO.layMaGiaoDich();
								khachHang = khachHangDAO.showKhachHangTheoSoThe(sotheATM);
								soTien.setText(khachHang.getSoTienTrongTK());
								tableModel
										.addRow(new String[] { ("" + giaoDich.getMaGiaoDich()), giaoDich.getThoiGian(),
												giaoDich.getSoTienRut(), khachHang.getSoTienTrongTK() });
							} else {
								JOptionPane.showMessageDialog(null, "Số tiền trong thẻ không đủ để rút");
							}
						} else {
							JOptionPane.showMessageDialog(null, "Số tiền trong máy không đủ để rút");
						}
					} else {
						JOptionPane.showMessageDialog(null, "Số tiền phải là bội số của 10,000 và không quá 5,000,000");
					}
				} else if (output == JOptionPane.NO_OPTION) {
				}

			}

			if (e.getSource() == btHuy) {
				txtPinCu.setText("");
				txtPinMoi.setText("");
				txtPinMoi2.setText("");
			}

			if (e.getSource() == btXacNhan) {
				if (kiemTraDoiMatKhau()) {
					if (txtPinCu.getText().equals(maPinCu) && !txtPinMoi.getText().equals(maPinCu)) {
						if (txtPinMoi.getText().equals(txtPinMoi2.getText())) {
							if (theAtmDAO.doiMaPin(txtPinMoi.getText(), sotheATM)) {
								JOptionPane.showMessageDialog(null, "Đổi mã pin thành công");
								txtPinCu.setText("");
								txtPinMoi.setText("");
								txtPinMoi2.setText("");
							} else {
								JOptionPane.showMessageDialog(null, "Đổi mã pin thất bại");
							}
						} else {
							JOptionPane.showMessageDialog(null, "Mã pin mới phải nhập giống nhau");
						}
					} else {
						JOptionPane.showMessageDialog(null, "Nhập sai mã pin hoặc Pin mới trùng với Pin cũ");
					}
				}
			}

		}
	};

	public MayATMView(String maMay) {
		display();
		maMayATM = maMay;
		khachHangDAO = new KhachHangDAO();
		dangNhapDAO = new DangNhapDAO();
		giaoDichDAO = new GiaoDichDAO();
		theAtmDAO = new TheAtmDAO();
		mayAtmDAO = new MayAtmDAO();
		khachHang = new KhachHang();
		giaoDich = new GiaoDich();
		mayATM = new MayATM();
	}

	/**
	 * Phần đăng nhập máy ATM
	 */
	public void mayATM(MayATM mayATM) {
		conn = getContentPane();
		conn.setLayout(new BorderLayout());

		// Phần tiêu đề
		pnTitle = new JPanel();
		pnTitle.setLayout(new GridLayout(2, 1));
		title = new JLabel("TP-BANK MÁY ATM");
		title.setHorizontalAlignment(JLabel.CENTER);
		title.setFont(new Font("Times New Roman", Font.BOLD, 45));
		title.setForeground(Color.RED);
		pnTitle.add(title);
		
		pnThongTinATM = new JPanel();
		lbDiaChi2 = new JLabel("Địa chỉ");
		lbPhuong2 = new JLabel("Phường");
		lbQuan2 = new JLabel("Quận");
		txtDiaChi = new JTextField(15);
		txtDiaChi.setEditable(false);
		txtPhuong = new JTextField(15);
		txtPhuong.setEditable(false);
		txtQuan = new JTextField(15);
		txtQuan.setEditable(false);
		pnThongTinATM.add(lbDiaChi2);
		pnThongTinATM.add(txtDiaChi);
		pnThongTinATM.add(lbPhuong2);
		pnThongTinATM.add(txtPhuong);
		pnThongTinATM.add(lbQuan2);
		pnThongTinATM.add(txtQuan);
		pnTitle.add(pnThongTinATM);
		
		txtDiaChi.setText(mayATM.getViTri());
		txtPhuong.setText(mayATM.getPhuong());
		txtQuan.setText(mayATM.getQuan());

		// Phần thân chương trình
		pnCenter = new JPanel();
		border = BorderFactory.createLineBorder(Color.BLUE, 3, true);
		titledBorder = new TitledBorder(border, "Program");
		pnCenter.setBorder(titledBorder);

		// Phần đăng nhập
		pnMayATM = new JPanel();
		pnMayATM.setLayout(new BoxLayout(pnMayATM, BoxLayout.Y_AXIS));
		pnDangNhap = new JPanel();
		lbAccount = new JLabel("Nhập số thẻ ATM");
		txtSoTheATM = new JTextField(10);
		pnDangNhap.add(lbAccount);
		pnDangNhap.add(txtSoTheATM);
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

	/**
	 * Phần Thông tin khách hàng và rút tiền
	 * 
	 * @param khachHang
	 */
	public void thongTinKH(KhachHang khachHang, MayATM mayATM) {

		conn = getContentPane();
		conn.setLayout(new BorderLayout());
		pnTitle = new JPanel();
		pnTitle.setLayout(new GridLayout(2, 1));
		pnMenu = new JPanel();
		pnAllCenter = new JPanel();
		pnSouth = new JPanel();
		pnCenter = new JPanel();

		pnMenu.setBackground(Color.LIGHT_GRAY);

		// Phần tiêu đề
		logoname = new JLabel("TP-BANK MÁY ATM");
		logoname.setFont(new Font("Times New Roman", Font.BOLD, 45));
		logoname.setHorizontalAlignment(JLabel.CENTER);
		logoname.setForeground(Color.RED);
		pnTitle.add(logoname);
		
		pnThongTinATM = new JPanel();
		lbDiaChi2 = new JLabel("Địa chỉ");
		lbPhuong2 = new JLabel("Phường");
		lbQuan2 = new JLabel("Quận");
		txtDiaChi = new JTextField(15);
		txtDiaChi.setEditable(false);
		txtPhuong = new JTextField(15);
		txtPhuong.setEditable(false);
		txtQuan = new JTextField(15);
		txtQuan.setEditable(false);
		pnThongTinATM.add(lbDiaChi2);
		pnThongTinATM.add(txtDiaChi);
		pnThongTinATM.add(lbPhuong2);
		pnThongTinATM.add(txtPhuong);
		pnThongTinATM.add(lbQuan2);
		pnThongTinATM.add(txtQuan);
		pnTitle.add(pnThongTinATM);
		conn.add(pnTitle, "North");
		
		txtDiaChi.setText(mayATM.getViTri());
		txtPhuong.setText(mayATM.getPhuong());
		txtQuan.setText(mayATM.getQuan());

		// Phần Menu
		pnButton = new JPanel();
		btThongTin = new JButton("Thông tin tài khoản");
		btThongTin.addActionListener(actionListener);
		btRutTien = new JButton("Rút tiền");
		btRutTien.addActionListener(actionListener);
		btDoiPin = new JButton("Đổi mã Pin");
		btDoiPin.addActionListener(actionListener);
		btThoatGD = new JButton("Thoát");
		btThoatGD.addActionListener(actionListener);
		pnButton.add(btThongTin);
		pnButton.add(btRutTien);
		pnButton.add(btDoiPin);
		pnButton.add(btThoatGD);
		pnMenu.add(new JScrollPane(pnButton), BorderLayout.CENTER);
		pnMenu.setBorder(BorderFactory.createTitledBorder("Menu"));
		conn.add(pnMenu, "South");

		pnAllCenter = new JPanel();
		pnAllCenter.setBorder(BorderFactory.createTitledBorder("ProGram"));
		JScrollPane pane = new JScrollPane(pnAllCenter);

		// Phần thông tin khách hàng
		pnThongTin = new JPanel();
		pnThongTin.setLayout(new GridLayout(1, 2));
		pnLabel1 = new JPanel();
		pnLabel1.setLayout(new GridBagLayout());
		lbSoCMND = new JLabel("Số CMND");
		lbTen = new JLabel("Họ tên khách hàng");
		lbDiaChi = new JLabel("Địa chỉ nhà");
		lbQuan = new JLabel("Quận");
		lbPhuong = new JLabel("Phường");

		soCMND = new JTextField(15);
		soCMND.setEditable(false);
		ten = new JTextField(15);
		ten.setEditable(false);
		diaChi = new JTextField(15);
		diaChi.setEditable(false);
		quan = new JTextField(15);
		quan.setEditable(false);
		phuong = new JTextField(15);
		phuong.setEditable(false);

		soCMND.setText(khachHang.getSoCMND());
		ten.setText(khachHang.getTenKH());
		diaChi.setText(khachHang.getDiaChi());
		phuong.setText(khachHang.getPhuong());
		quan.setText(khachHang.getQuan());

		addItem(pnLabel1, lbTen, 0, 0, 1, 1, GridBagConstraints.EAST);
		addItem(pnLabel1, lbSoCMND, 0, 1, 1, 1, GridBagConstraints.EAST);
		addItem(pnLabel1, lbDiaChi, 0, 2, 1, 1, GridBagConstraints.EAST);
		addItem(pnLabel1, lbQuan, 0, 3, 1, 1, GridBagConstraints.EAST);
		addItem(pnLabel1, lbPhuong, 0, 4, 1, 1, GridBagConstraints.EAST);

		addItem(pnLabel1, ten, 1, 0, 2, 1, GridBagConstraints.WEST);
		addItem(pnLabel1, soCMND, 1, 1, 2, 1, GridBagConstraints.WEST);
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
		soDT.setEditable(false);
		email = new JTextField(15);
		email.setEditable(false);
		soThe = new JTextField(15);
		soThe.setEditable(false);
		soTK = new JTextField(15);
		soTK.setEditable(false);
		soTien = new JTextField(15);
		soTien.setEditable(false);

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
		// table.getTableHeader().setReorderingAllowed(false);
		table.setDefaultEditor(Object.class, null);

		JScrollPane jScrollPane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		jScrollPane.setBorder(titledBorder);
		pnRutTien.add(jScrollPane);
		pnRutTien.setLayout(new BoxLayout(pnRutTien, BoxLayout.Y_AXIS));

		// Phần đổi mã Pin
		pnDoiMaPin = new JPanel();
		pnDoiMaPin.setLayout(new GridLayout(2, 1));
		pnLabel4 = new JPanel();
		pnLabel4.setLayout(new GridBagLayout());
		lpPinCu = new JLabel("Mã Pin cũ");
		lpPinMoi = new JLabel("Mã Pin mới");
		lpPinMoi2 = new JLabel("Nhập lại mã Pin mới");

		txtPinCu = new JTextField(10);
		txtPinMoi = new JTextField(10);
		txtPinMoi2 = new JTextField(10);

		addItem(pnLabel4, lpPinCu, 0, 0, 1, 1, GridBagConstraints.EAST);
		addItem(pnLabel4, lpPinMoi, 0, 1, 1, 1, GridBagConstraints.EAST);
		addItem(pnLabel4, lpPinMoi2, 0, 2, 1, 1, GridBagConstraints.EAST);

		addItem(pnLabel4, txtPinCu, 1, 0, 2, 1, GridBagConstraints.WEST);
		addItem(pnLabel4, txtPinMoi, 1, 1, 2, 1, GridBagConstraints.WEST);
		addItem(pnLabel4, txtPinMoi2, 1, 2, 2, 1, GridBagConstraints.WEST);

		pnButton4 = new JPanel();
		btXacNhan = new JButton("Xác nhận");
		btHuy = new JButton("Hủy");
		btXacNhan.addActionListener(actionListener);
		btHuy.addActionListener(actionListener);
		pnButton4.add(btXacNhan);
		pnButton4.add(btHuy);

		pnDoiMaPin.add(pnLabel4);
		pnDoiMaPin.add(pnButton4);

		// Phần Cardlayout
		card = new CardLayout();
		cardLayout = new JPanel();
		pnAllCenter.add(cardLayout);
		cardLayout.setLayout(card);
		cardLayout.add(pnThongTin, "thongTin");
		cardLayout.add(pnRutTien, "rutTien");
		cardLayout.add(pnDoiMaPin, "doiPin");

		conn.add(pnSouth, "West");
		conn.add(pane, "Center");
	}

	/**
	 * Sắp xếp các lable
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

	public void display() {
		setSize(800, 750);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

	/**
	 * Kiểm tra nhập số tiền cần rút
	 * 
	 * @return
	 */
	public boolean kiemTraSoTien() {
		boolean kiemTra = false;
		String pantter = "[1-9][0-9]{0,2}0000";
		if (txtRutTien.getText().matches(pantter)&&(Integer.parseInt(txtRutTien.getText()) <= 5000000)) {
			kiemTra = true;
		}
		return kiemTra;
	}

	/**
	 * Kiểm tra nhập thông tin đổi mật khẩu
	 * 
	 * @return
	 */
	public boolean kiemTraDoiMatKhau() {
		boolean kiemTra = true;
		String pantterMaPin = "[0-9]{6}";
		if (!txtPinCu.getText().matches(pantterMaPin)) {
			kiemTra = false;
			txtPinCu.setText("");
		}
		if (!txtPinMoi.getText().matches(pantterMaPin)) {
			kiemTra = false;
			txtPinMoi.setText("");
		}
		if (!txtPinMoi2.getText().matches(pantterMaPin)) {
			kiemTra = false;
			txtPinMoi2.setText("");
		}
		if (kiemTra == false) {
			JOptionPane.showMessageDialog(null, "Mã pin nhập số và có 6 kí tự");
		}
		return kiemTra;
	}

}
