package quanly.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
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
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

import quanly.entity.KhachHang;
import quanly.model.GiaoDichDAO;
import quanly.model.KhachHangDAO;
import quanly.model.PhuongQuanDAO;
import quanly.model.TheAtmDAO;

public class QuanLyKhachHang extends JFrame {

	private static final long serialVersionUID = 1L;
	JPanel pnQuanLyKH, pnNhap, pnbutton;
	JPanel pnLabel1, pnLabel2;
	JLabel title, soCMND, tenKH, diaChi, phuong, quan, dienThoai, email, soTheATM, soTK, soTien;
	JTextField txtSoCMND, txtTenKH, txtDiaChi, txtDienThoai, txtEmail, txtSoTK, txtSoTien;
	JComboBox<String> boxPhuong, boxQuan, boxtheATM;
	JButton them, sua, xoa, hienthi, tim, huy;
	DefaultTableModel tableModel;
	JTable table;
	Border border;
	TitledBorder titledBorder;
	KhachHangDAO khachHangDAO;
	PhuongQuanDAO phuongQuanDAO;
	TheAtmDAO theAtmDAO;
	GiaoDichDAO giaoDichDAO;

	KhachHang khachHang;
	ArrayList<String> listQuan;
	ArrayList<String> listPhuong;
	static String maKH = null;
	boolean kiemTra = false;

	private static final String UNICODE_HOA = "ÀÁẠÃẢĂẮẰẶẴẲÂẤẦẨẪẬĐÈÉẺẼẸÊẾỀỂỄỆỊÍÌỈĨỌÓÒỎÕỘỐỒỔỖÔƠỚỜỞỠỢÚÙỦŨỤƯỨỪỬỮỰ";
	private static final String UNICODE_THUONG = "àáạãảăắằặẵẳâẩấầẫậđèéẻẽẹêếềểễệịíìỉĩọóòỏõộốồổỗôơớờởỡợúùủũụưứừửữự";

	DocumentListener documentListener = new DocumentListener() {

		@Override
		public void removeUpdate(DocumentEvent e) {
			if (kiemTra) {
				xoa.setEnabled(false);
				sua.setEnabled(true);
			}
		}

		@Override
		public void insertUpdate(DocumentEvent e) {
			if (kiemTra) {
				xoa.setEnabled(false);
				sua.setEnabled(true);
			}
		}

		@Override
		public void changedUpdate(DocumentEvent e) {

		}
	};

	/**
	 * Sự kiện cho chọn phường và quận
	 */
	ItemListener itemListener = new ItemListener() {
		public void itemStateChanged(ItemEvent e) {
			if (e.getStateChange() == ItemEvent.SELECTED) {
				String tenQuan = boxQuan.getSelectedItem().toString();
				boxPhuong.removeAllItems();
				listPhuong = phuongQuanDAO.showDanhSachPhuong(tenQuan);
				for (int i = 0; i < listPhuong.size(); i++) {
					boxPhuong.addItem(listPhuong.get(i));
				}
				if (kiemTra) {
					xoa.setEnabled(false);
					sua.setEnabled(true);
				}
			}
		}
	};

	/**
	 * Sự kiện cho chọn phường và quận
	 */
	ItemListener itemListener1 = new ItemListener() {
		public void itemStateChanged(ItemEvent e) {
			if (e.getStateChange() == ItemEvent.SELECTED) {
				String soTheATM = boxtheATM.getSelectedItem().toString();
				txtSoTK.setText(theAtmDAO.layThongTinMaThe(soTheATM));
			}
			if (kiemTra) {
				xoa.setEnabled(false);
				sua.setEnabled(true);
			}
		}
	};

	/**
	 * Sự kiện cho các button
	 */
	ActionListener actionListener = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			JButton button = (JButton) e.getSource();
			int output = JOptionPane.showConfirmDialog(null, "" + button.getActionCommand(), "TPBank Đà Nẵng",
					JOptionPane.YES_NO_OPTION);
			if (button == them) {
				if (output == JOptionPane.YES_OPTION) {
					if (kiemTraNhapDuLieuAddKhachHang()) {
						KhachHang khachHang1 = layGiaTriKhachHang();
						if (khachHangDAO.addKhachHang(khachHang1,
								phuongQuanDAO.layThongTinMaPhuong(khachHang1.getPhuong()))) {
							theAtmDAO.addTheATM(theAtmDAO.layThongTinTheATM().getSoTheATM(),
									theAtmDAO.layThongTinTheATM().getSoTK());
							JOptionPane.showMessageDialog(null, "Thêm khách hàng thành công");
							txtDiaChi.setText("");
							txtDienThoai.setText("");
							txtEmail.setText("");
							txtSoCMND.setText("");
							txtSoTien.setText("");
							txtTenKH.setText("");
							boxtheATM.removeAllItems();
							ArrayList<String> listSoThe = theAtmDAO.laySoTheATM();
							for (int i = 0; i < listSoThe.size(); i++) {
								boxtheATM.addItem(listSoThe.get(i));
							}
							tableModel.setRowCount(0);
							showTable();
						} else {
							JOptionPane.showMessageDialog(null, "Trùng số CMND");
						}
					}
				}
			} else if (output == JOptionPane.NO_OPTION) {

			}

			if (button == sua) {
				if (output == JOptionPane.YES_OPTION) {

					if (kiemTraNhapDuLieuUpdateKhachHang()) {
						KhachHang khachHang = layGiaTriKhachHang();
						if (khachHangDAO.updateKhachHang(maKH, khachHang,
								phuongQuanDAO.layThongTinMaPhuong(boxPhuong.getSelectedItem().toString()))) {
							JOptionPane.showMessageDialog(null, "Sửa thành công");
							txtDiaChi.setText("");
							txtDienThoai.setText("");
							txtEmail.setText("");
							txtSoCMND.setText("");
							txtSoTien.setText("");
							txtTenKH.setText("");
							boxtheATM.removeAllItems();
							ArrayList<String> listSoThe = theAtmDAO.laySoTheATM();
							for (int i = 0; i < listSoThe.size(); i++) {
								boxtheATM.addItem(listSoThe.get(i));
							}
							tableModel.setRowCount(0);
							showTable();
							sua.setEnabled(false);
							xoa.setEnabled(false);
							them.setEnabled(true);
							txtSoTien.setEnabled(true);
							boxtheATM.setEnabled(true);
							kiemTra = false;
						}
					}
				}
			} else if (output == JOptionPane.NO_OPTION) {
			}

			if (button == xoa) {
				if (output == JOptionPane.YES_OPTION) {
					if (khachHangDAO.deleteKhachHangTheoMaKH(maKH)) {
						giaoDichDAO.xoaThongTinGDTheoMaKH(maKH);
						JOptionPane.showMessageDialog(null, "Xóa thành công");
						txtDiaChi.setText("");
						txtDienThoai.setText("");
						txtEmail.setText("");
						txtSoCMND.setText("");
						txtSoTien.setText("");
						txtTenKH.setText("");
						boxtheATM.removeAllItems();
						ArrayList<String> listSoThe = theAtmDAO.laySoTheATM();
						for (int i = 0; i < listSoThe.size(); i++) {
							boxtheATM.addItem(listSoThe.get(i));
						}
						tableModel.setRowCount(0);
						showTable();
						sua.setEnabled(false);
						xoa.setEnabled(false);
						them.setEnabled(true);
						txtSoTien.setEnabled(true);
						boxtheATM.setEnabled(true);
						kiemTra = false;
					}
				} else if (output == JOptionPane.NO_OPTION) {
				}
			}

			if (button == hienthi) {
				if (output == JOptionPane.YES_OPTION) {
					tableModel.setRowCount(0);
					showTable();
				} else if (output == JOptionPane.NO_OPTION) {
				}
			}

			if (button == tim) {
				if (output == JOptionPane.YES_OPTION) {
					TimKiemKhachHang hang = new TimKiemKhachHang();
					hang.TimKiem(tableModel);
					hang.display();
				} else if (output == JOptionPane.NO_OPTION) {
				}

			}

			if (button == huy) {
				if (output == JOptionPane.YES_OPTION) {
					boxtheATM.removeAllItems();
					ArrayList<String> listSoThe = theAtmDAO.laySoTheATM();
					for (int i = 0; i < listSoThe.size(); i++) {
						boxtheATM.addItem(listSoThe.get(i));
					}

					txtDiaChi.setText("");
					txtDienThoai.setText("");
					txtEmail.setText("");
					txtSoCMND.setText("");
					txtSoTien.setText("");
					txtTenKH.setText("");
					sua.setEnabled(false);
					xoa.setEnabled(false);
					them.setEnabled(true);
					txtSoTien.setEnabled(true);
					boxtheATM.setEnabled(true);
					kiemTra = false;
				}
			} else if (output == JOptionPane.NO_OPTION) {
			}
		}

	};

	public JPanel quanLyKH() {
		pnQuanLyKH = new JPanel();
		khachHangDAO = new KhachHangDAO();
		phuongQuanDAO = new PhuongQuanDAO();
		theAtmDAO = new TheAtmDAO();
		giaoDichDAO = new GiaoDichDAO();

		// Phần tiêu đề
		title = new JLabel("Quản lý khách hàng");
		title.setFont(new Font("Times New Roman", Font.BOLD, 30));
		title.setForeground(Color.RED);
		pnQuanLyKH.add(title);

		// Phần nhập thông tin
		pnNhap = new JPanel();
		pnNhap.setLayout(new GridLayout(1, 2));
		pnLabel1 = new JPanel();
		pnLabel1.setLayout(new GridBagLayout());
		soCMND = new JLabel("Số CMND :");
		tenKH = new JLabel("Họ tên khách hàng :");
		diaChi = new JLabel("Địa chỉ nhà :");
		quan = new JLabel("Quận :");
		phuong = new JLabel("Phường :");

		txtSoCMND = new JTextField(10);
		txtTenKH = new JTextField(10);
		txtDiaChi = new JTextField(10);
		txtSoCMND.getDocument().addDocumentListener(documentListener);
		txtTenKH.getDocument().addDocumentListener(documentListener);
		txtDiaChi.getDocument().addDocumentListener(documentListener);

		boxQuan = new JComboBox<String>();
		listQuan = phuongQuanDAO.showAllDanhSachQuan();
		for (int i = 0; i < listQuan.size(); i++) {
			boxQuan.addItem(listQuan.get(i).toString());
		}
		boxQuan.addItemListener(itemListener);
		boxPhuong = new JComboBox<String>();
		listPhuong = phuongQuanDAO.showDanhSachPhuong(listQuan.get(0).toString());
		for (int i = 0; i < listPhuong.size(); i++) {
			boxPhuong.addItem(listPhuong.get(i).toString());
		}

		addItem(pnLabel1, tenKH, 0, 0, 1, 1, GridBagConstraints.EAST);
		addItem(pnLabel1, diaChi, 0, 1, 1, 1, GridBagConstraints.EAST);
		addItem(pnLabel1, quan, 0, 2, 1, 1, GridBagConstraints.EAST);
		addItem(pnLabel1, phuong, 0, 3, 1, 1, GridBagConstraints.EAST);
		addItem(pnLabel1, soCMND, 0, 4, 1, 1, GridBagConstraints.EAST);

		addItem(pnLabel1, txtTenKH, 1, 0, 2, 1, GridBagConstraints.WEST);
		addItem(pnLabel1, txtDiaChi, 1, 1, 2, 1, GridBagConstraints.WEST);
		addItem(pnLabel1, boxQuan, 1, 2, 2, 1, GridBagConstraints.WEST);
		addItem(pnLabel1, boxPhuong, 1, 3, 2, 1, GridBagConstraints.WEST);
		addItem(pnLabel1, txtSoCMND, 1, 4, 2, 1, GridBagConstraints.WEST);
		pnNhap.add(pnLabel1);

		pnLabel2 = new JPanel();
		pnLabel2.setLayout(new GridBagLayout());
		dienThoai = new JLabel("Số điện thoại :");
		email = new JLabel("Email :");
		soTheATM = new JLabel("Số thẻ ATM :");
		soTK = new JLabel("Số tài khoản ngân hàng :");
		soTien = new JLabel("Số tiền hiện có :");

		txtDienThoai = new JTextField(10);
		txtEmail = new JTextField(10);
		txtSoTK = new JTextField(10);
		txtSoTien = new JTextField(10);
		txtDienThoai.getDocument().addDocumentListener(documentListener);
		txtEmail.getDocument().addDocumentListener(documentListener);
		txtSoTK.getDocument().addDocumentListener(documentListener);

		boxtheATM = new JComboBox<String>();
		ArrayList<String> listSoThe = theAtmDAO.laySoTheATM();
		for (int i = 0; i < listSoThe.size(); i++) {
			boxtheATM.addItem(listSoThe.get(i));
		}
		boxtheATM.addItemListener(itemListener1);
		txtSoTK.setText(theAtmDAO.layThongTinMaThe(boxtheATM.getSelectedItem().toString()));
		txtSoTK.setEditable(false);

		addItem(pnLabel2, dienThoai, 0, 0, 1, 1, GridBagConstraints.EAST);
		addItem(pnLabel2, email, 0, 1, 1, 1, GridBagConstraints.EAST);
		addItem(pnLabel2, soTheATM, 0, 2, 1, 1, GridBagConstraints.EAST);
		addItem(pnLabel2, soTK, 0, 3, 1, 1, GridBagConstraints.EAST);
		addItem(pnLabel2, soTien, 0, 4, 1, 1, GridBagConstraints.EAST);

		addItem(pnLabel2, txtDienThoai, 1, 0, 2, 1, GridBagConstraints.WEST);
		addItem(pnLabel2, txtEmail, 1, 1, 2, 1, GridBagConstraints.WEST);
		addItem(pnLabel2, boxtheATM, 1, 2, 2, 1, GridBagConstraints.WEST);
		addItem(pnLabel2, txtSoTK, 1, 3, 2, 1, GridBagConstraints.WEST);
		addItem(pnLabel2, txtSoTien, 1, 4, 2, 1, GridBagConstraints.WEST);
		pnNhap.add(pnLabel2);
		pnQuanLyKH.add(pnNhap);

		// Các button chức năng
		pnbutton = new JPanel();
		them = new JButton("Thêm khách hàng");
		sua = new JButton("Sửa thông tin");
		hienthi = new JButton("Hiển thị danh sách");
		xoa = new JButton("Xóa thông tin");
		tim = new JButton("Tìm kiếm");
		huy = new JButton("Hủy");
		them.addActionListener(actionListener);
		sua.addActionListener(actionListener);
		xoa.addActionListener(actionListener);
		tim.addActionListener(actionListener);
		hienthi.addActionListener(actionListener);
		huy.addActionListener(actionListener);
		sua.setEnabled(false);
		xoa.setEnabled(false);
		pnbutton.add(them);
		pnbutton.add(sua);
		pnbutton.add(hienthi);
		pnbutton.add(tim);
		pnbutton.add(xoa);
		pnbutton.add(huy);
		pnQuanLyKH.add(pnbutton);

		// Phần bảng danh sách khách hàng
		border = BorderFactory.createLineBorder(Color.BLUE, 3, true);
		titledBorder = new TitledBorder(border, "Danh sách thông tin khách hàng");
		tableModel = new DefaultTableModel();
		tableModel.addColumn("Mã Khách hàng");
		tableModel.addColumn("Họ tên khách hàng");
		tableModel.addColumn("Địa chỉ nhà");
		tableModel.addColumn("Phường");
		tableModel.addColumn("Quận");
		tableModel.addColumn("Số điện thoại");
		tableModel.addColumn("Email");
		tableModel.addColumn("Số CMND");
		tableModel.addColumn("Số thẻ ATM");
		tableModel.addColumn("Số tài khoản");
		tableModel.addColumn("Số tiền trong tài khoản");

		showTable();

		table = new JTable(tableModel);
		// table.getTableHeader().setReorderingAllowed(false);
		table.setDefaultEditor(Object.class, null);

		table.addMouseListener(new MouseListener() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				int row = table.getSelectedRow();
				maKH = String.valueOf(table.getValueAt(row, 0));
				String s = String.valueOf(table.getValueAt(row, 1));
				txtTenKH.setText(s);
				String s1 = String.valueOf(table.getValueAt(row, 2));
				txtDiaChi.setText(s1);
				String s2 = String.valueOf(table.getValueAt(row, 4));
				boxQuan.getModel().setSelectedItem(s2);
				String s3 = String.valueOf(table.getValueAt(row, 3));
				boxPhuong.getModel().setSelectedItem(s3);
				String s4 = String.valueOf(table.getValueAt(row, 5));
				txtDienThoai.setText(s4);
				String s5 = String.valueOf(table.getValueAt(row, 6));
				txtEmail.setText(s5);
				String s6 = String.valueOf(table.getValueAt(row, 7));
				txtSoCMND.setText(s6);
				String s7 = String.valueOf(table.getValueAt(row, 8));
				boxtheATM.getModel().setSelectedItem(s7);
				String s8 = String.valueOf(table.getValueAt(row, 10));
				txtSoTien.setText(s8);
				txtSoTien.setEnabled(false);
				boxtheATM.setEnabled(false);
				xoa.setEnabled(true);
				sua.setEnabled(false);
				them.setEnabled(false);
				kiemTra = true;

			}
		});

		JScrollPane jScrollPane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		jScrollPane.setBorder(titledBorder);

		pnQuanLyKH.add(jScrollPane);
		pnQuanLyKH.setLayout(new BoxLayout(pnQuanLyKH, BoxLayout.Y_AXIS));

		return pnQuanLyKH;
	}

	/**
	 * Sắp xếp các lable nhập
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

	/**
	 * Hien thi table
	 */
	public void showTable() {
		ArrayList<KhachHang> myList = new ArrayList<>();
		myList = khachHangDAO.showAllKhachHang();
		for (int i = 0; i < myList.size(); i++) {
			tableModel.addRow(new String[] { myList.get(i).getMaKH(), myList.get(i).getTenKH(),
					myList.get(i).getDiaChi(), myList.get(i).getPhuong(), myList.get(i).getQuan(),
					myList.get(i).getSoDT(), myList.get(i).getEmail(), myList.get(i).getSoCMND(),
					myList.get(i).getSoTheATM(), myList.get(i).getSoTK(), myList.get(i).getSoTienTrongTK() });
		}
	}

	/**
	 * Kiem tra dữ liệu nhập thêm thông tin khách hàng
	 * 
	 * @return
	 */
	public boolean kiemTraNhapDuLieuAddKhachHang() {
		boolean kiemTra = true;
		String pantterTen = "[A-Z" + UNICODE_HOA + "][a-z" + UNICODE_THUONG + "]*( [A-Z" + UNICODE_HOA + "][a-z"
				+ UNICODE_THUONG + "]*)+";
		String pantterSDT = "0[0-9]{9,10}";
		String pantterEmail = "\\w+@\\w+(\\.\\w+){1,2}";
		String pantterSoCMND = "[0-9]{9}";
		String pantterSoTien = "[1-9][0-9]{0,3}0000";
		if (!txtTenKH.getText().matches(pantterTen)) {
			kiemTra = false;
			JOptionPane.showMessageDialog(null,
					"Nhập sai định dạng tên khách hàng (Họ và tên phải viết hoa chữ đầu và cách nhau 1 dấu space)");
			txtTenKH.setText("");
		}
		if (!txtDienThoai.getText().matches(pantterSDT)) {
			kiemTra = false;
			JOptionPane.showMessageDialog(null,
					"Nhập sai định dạng số điện thoại khách hàng (Số điện thoại phải số 0 đầu tiên và gồm 10-11 chữ số)");
			txtDienThoai.setText("");
		}
		if (!txtEmail.getText().matches(pantterEmail)) {
			kiemTra = false;
			JOptionPane.showMessageDialog(null, "Nhập sai định dạng Email");
			txtEmail.setText("");
		}
		if (!txtSoCMND.getText().matches(pantterSoCMND)) {
			kiemTra = false;
			JOptionPane.showMessageDialog(null, "Nhập sai định dạng số CMND");
			txtSoCMND.setText("");
		}
		if (txtSoTK.getText().equals("")) {
			kiemTra = false;
			JOptionPane.showMessageDialog(null, "Nhập sai số thẻ ATM");
		}
		if (!txtSoTien.getText().matches(pantterSoTien)) {
			kiemTra = false;
			JOptionPane.showMessageDialog(null,
					"Nhập sai định dạng số tiền (Số tiền phải bắt đầu từ 1-10 và phải là bội số của 10000 và không quá 99990000)");
			txtSoTien.setText("");
		}

		return kiemTra;
	}

	/**
	 * Kiem tra dữ liệu nhập sữa thông tin khách hàng
	 * 
	 * @return
	 */
	public boolean kiemTraNhapDuLieuUpdateKhachHang() {
		boolean kiemTra = true;
		String pantterTen = "[A-Z" + UNICODE_HOA + "][a-z" + UNICODE_THUONG + "]*( [A-Z" + UNICODE_HOA + "][a-z"
				+ UNICODE_THUONG + "]*)+";
		String pantterSDT = "0[0-9]{9,10}";
		String pantterEmail = "\\w+@\\w+(\\.\\w+){1,2}";
		String pantterSoCMND = "[0-9]{9}";
		if (!txtTenKH.getText().matches(pantterTen)) {
			kiemTra = false;
			JOptionPane.showMessageDialog(null,
					"Nhập sai định dạng tên khách hàng (Họ và tên phải viết hoa chữ đầu và cách nhau 1 dấu space)");
			txtTenKH.setText("");
		}
		if (!txtDienThoai.getText().matches(pantterSDT)) {
			kiemTra = false;
			JOptionPane.showMessageDialog(null,
					"Nhập sai định dạng số điện thoại khách hàng (Số điện thoại phải số 0 đầu tiên và gồm 10-11 chữ số)");
			txtDienThoai.setText("");
		}
		if (!txtEmail.getText().matches(pantterEmail)) {
			kiemTra = false;
			JOptionPane.showMessageDialog(null, "Nhập sai định dạng Email");
			txtEmail.setText("");
		}
		if (!txtSoCMND.getText().matches(pantterSoCMND)) {
			kiemTra = false;
			JOptionPane.showMessageDialog(null, "Nhập sai định dạng số CMND");
			txtSoCMND.setText("");
		}

		return kiemTra;
	}

	/**
	 * Lấy giá trị nhập thông tin khách hàng
	 * 
	 * @return
	 */
	public KhachHang layGiaTriKhachHang() {
		khachHang = new KhachHang();
		khachHang.setTenKH(txtTenKH.getText());
		khachHang.setDiaChi(txtDiaChi.getText());
		khachHang.setPhuong(boxPhuong.getSelectedItem().toString());
		khachHang.setQuan(boxQuan.getSelectedItem().toString());
		khachHang.setSoDT(txtDienThoai.getText());
		khachHang.setEmail(txtEmail.getText());
		khachHang.setSoCMND(txtSoCMND.getText());
		khachHang.setSoTheATM(boxtheATM.getSelectedItem().toString());
		khachHang.setSoTK(txtSoTK.getText());
		khachHang.setSoTienTrongTK(txtSoTien.getText());
		return khachHang;
	}
}
