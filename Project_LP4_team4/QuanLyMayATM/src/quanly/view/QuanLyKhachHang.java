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
import javax.swing.table.DefaultTableModel;

import quanly.entity.KhachHang;
import quanly.model.KhachHangDAO;

public class QuanLyKhachHang extends JFrame {

	private static final long serialVersionUID = 1L;
	JPanel pnQuanLyKH, pnNhap, pnbutton;
	JPanel pnLabel1, pnLabel2;
	JLabel title, maKH, tenKH, diaChi, phuong, quan, dienThoai, email, soTheATM, soTK, soTien;
	JTextField txtMaKH, txtTenKH, txtDiaChi, txtDienThoai, txtEmail, txtSoTheATM, txtSoTK, txtSoTien;
	JComboBox<String> boxPhuong, boxQuan;
	JButton them, sua, xoa, tim;
	DefaultTableModel tableModel;
	JTable table;
	Border border;
	TitledBorder titledBorder;
	KhachHangDAO khachHangDAO;
	KhachHang khachHang;
	ArrayList<String> listQuan;
	ArrayList<String> listPhuong;
	String tenQuan;
	String tenPhuong;

//	ItemListener itemListener = new ItemListener() {
//		public void itemStateChanged(ItemEvent e) {
//			if (e.getStateChange() == ItemEvent.SELECTED) {
//				tenQuan = boxQuan.getSelectedItem().toString();
//				boxPhuong.removeAllItems();
//				listPhuong = khachHangDAO.showDanhSachPhuong(tenQuan);
//				for (int i = 0; i < listPhuong.size(); i++) {
//					boxPhuong.addItem(listPhuong.get(i));
//				}
//			}
//
//			if (e.getStateChange() == ItemEvent.SELECTED) {
//				tenPhuong = boxPhuong.getSelectedItem().toString();
//			}
//		}
//	};
//
//	ActionListener actionListener = new ActionListener() {
//		public void actionPerformed(ActionEvent e) {
//			JButton button = (JButton) e.getSource();
//			if (kiemTraNhapDuLieuAddKhachHang()) {
//				if (button == them) {
//					if (khachHangDAO.addKhachHang(layGiaTriKhachHang())) {
//						JOptionPane.showMessageDialog(null, "Thêm thành công");
//						tableModel.setRowCount(0);
//						showTable();
//					} else {
//						JOptionPane.showMessageDialog(null, "Mã khách hàng trùng hoặc số thẻ ATM không tồn tại");
//					}
//				}
//			}
//			if (kiemTraNhapDuLieuUpdateKhachHang()) {
//				if (button == sua) {
//					if (khachHangDAO.updateKhachHang(layGiaTriKhachHang())) {
//						JOptionPane.showMessageDialog(null, "Sửa thành công");
//						tableModel.setRowCount(0);
//						showTable();
//					} else {
//						JOptionPane.showMessageDialog(null, "Sai mã khách hàng hoặc số thẻ ATM không tồn tại");
//					}
//				}
//			}
//
//			if (button == xoa) {
//				if (khachHangDAO.deleteKhachHang(layGiaTriKhachHang().getMaKH())) {
//					JOptionPane.showMessageDialog(null, "Xóa thành công");
//					tableModel.setRowCount(0);
//					showTable();
//				} else {
//					JOptionPane.showMessageDialog(null, "Sai mã khách hàng");
//				}
//			}
//		}
//
//	};

	public JPanel quanLyKH() {
		pnQuanLyKH = new JPanel();
//		khachHangDAO = new KhachHangDAO();
		
		title = new JLabel("Quản lý khách hàng");
		title.setFont(new Font("Times New Roman", Font.BOLD, 30));
		title.setForeground(Color.RED);
		pnQuanLyKH.add(title);

		pnNhap = new JPanel();
		pnNhap.setLayout(new GridLayout(1,2));
		pnLabel1 = new JPanel();
		pnLabel1.setLayout(new GridBagLayout());
		maKH = new JLabel("Mã khách hàng :");
		tenKH = new JLabel("Họ tên khách hàng :");
		diaChi = new JLabel("Địa chỉ nhà :");
		quan = new JLabel("Quận :");
		phuong = new JLabel("Phường :");

		txtMaKH = new JTextField(10);
		txtTenKH = new JTextField(10);
		txtDiaChi = new JTextField(10);

		boxQuan = new JComboBox<String>();
//		listQuan = khachHangDAO.showAllDanhSachQuan();
//		for (int i = 0; i < listQuan.size(); i++) {
//			boxQuan.addItem(listQuan.get(i).toString());
//		}
//		boxQuan.addItemListener(itemListener);
		boxPhuong = new JComboBox<String>();
//		listPhuong = khachHangDAO.showDanhSachPhuong(listQuan.get(0).toString());
//		for (int i = 0; i < listPhuong.size(); i++) {
//			boxPhuong.addItem(listPhuong.get(i).toString());
//		}
		
		addItem(pnLabel1, maKH, 0, 0, 1, 1, GridBagConstraints.EAST);
		addItem(pnLabel1, tenKH, 0, 1, 1, 1, GridBagConstraints.EAST);
		addItem(pnLabel1, diaChi, 0, 2, 1, 1, GridBagConstraints.EAST);
		addItem(pnLabel1, quan, 0, 3, 1, 1, GridBagConstraints.EAST);
		addItem(pnLabel1, phuong, 0, 4, 1, 1, GridBagConstraints.EAST);

		addItem(pnLabel1, txtMaKH, 1, 0, 2, 1, GridBagConstraints.WEST);
		addItem(pnLabel1, txtTenKH, 1, 1, 2, 1, GridBagConstraints.WEST);
		addItem(pnLabel1, txtDiaChi, 1, 2, 2, 1, GridBagConstraints.WEST);
		addItem(pnLabel1, boxQuan, 1, 3, 2, 1, GridBagConstraints.WEST);
		addItem(pnLabel1, boxPhuong, 1, 4, 2, 1, GridBagConstraints.WEST);
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
		txtSoTheATM = new JTextField(10);
		txtSoTK = new JTextField(10);
		txtSoTien = new JTextField(10);
		
		addItem(pnLabel2, dienThoai, 0, 0, 1, 1, GridBagConstraints.EAST);
		addItem(pnLabel2, email, 0, 1, 1, 1, GridBagConstraints.EAST);
		addItem(pnLabel2, soTheATM, 0, 2, 1, 1, GridBagConstraints.EAST);
		addItem(pnLabel2, soTK, 0, 3, 1, 1, GridBagConstraints.EAST);
		addItem(pnLabel2, soTien, 0, 4, 1, 1, GridBagConstraints.EAST);

		addItem(pnLabel2, txtDienThoai, 1, 0, 2, 1, GridBagConstraints.WEST);
		addItem(pnLabel2, txtEmail, 1, 1, 2, 1, GridBagConstraints.WEST);
		addItem(pnLabel2, txtSoTheATM, 1, 2, 2, 1, GridBagConstraints.WEST);
		addItem(pnLabel2, txtSoTK, 1, 3, 2, 1, GridBagConstraints.WEST);
		addItem(pnLabel2, txtSoTien, 1, 4, 2, 1, GridBagConstraints.WEST);
		pnNhap.add(pnLabel2);
		pnQuanLyKH.add(pnNhap);
		
		pnbutton = new JPanel();
		them = new JButton("Thêm thông tin khách hàng");
		sua = new JButton("Sửa thông tin khách hàng");
		tim = new JButton("Tìm kiếm");
		xoa = new JButton("Xóa thông tin khách hàng");
//		them.addActionListener(actionListener);
//		sua.addActionListener(actionListener);
//		xoa.addActionListener(actionListener);
		pnbutton.add(them);
		pnbutton.add(sua);
		pnbutton.add(tim);
		pnbutton.add(xoa);
		pnQuanLyKH.add(pnbutton);

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
		tableModel.addColumn("Số thẻ ATM");
		tableModel.addColumn("Số tài khoản");
		tableModel.addColumn("Số tiền trong tài khoản");

//		showTable();

		table = new JTable(tableModel);
		JScrollPane jScrollPane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		jScrollPane.setBorder(titledBorder);

		pnQuanLyKH.add(jScrollPane);

		pnQuanLyKH.setLayout(new BoxLayout(pnQuanLyKH, BoxLayout.Y_AXIS));

		return pnQuanLyKH;
	}
	/**
	 * Sắp xếp các lable nhập
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
//	public void showTable() {
//		ArrayList<KhachHang> myList = new ArrayList<>();
//		myList = khachHangDAO.showAllKhachHang();
//		for (int i = 0; i < myList.size(); i++) {
//			tableModel.addRow(new String[] { myList.get(i).getMaKH(), myList.get(i).getTenKH(),
//					myList.get(i).getDiaChi(), myList.get(i).getPhuong(), myList.get(i).getQuan(),
//					myList.get(i).getSoDT(), myList.get(i).getEmail(), myList.get(i).getSoTheATM(),
//					myList.get(i).getSoTK(), myList.get(i).getSoTienTrongTK() });
//		}
//	}

	/**
	 * Kiem tra dữ liệu thêm thông tin khách hàng
	 * 
	 * @return
	 */
//	public boolean kiemTraNhapDuLieuAddKhachHang() {
//		boolean kiemTra = true;
//		String pantterMaKh = "\\w{6}";
//		String pantterTen = "[A-Z][a-z]*( [A-Z][a-z]+)+";
//		String pantterSDT = "0[0-9]{9,10}";
//		String pantterEmail = "\\w+@\\w+(\\.\\w+){1,2}";
//		String pantterSoTheATM = "\\w{16}";
//		String pantterSoTK = "\\w{13}";
//		String pantterSoTien = "[1-9][0-9]+0000";
//		if (!txtMaKH.getText().matches(pantterMaKh)) {
//			kiemTra = false;
//			JOptionPane.showMessageDialog(null, "Nhập sai định dạng mã khách khàng (Mã khách hàng gồm 6 ký tự)");
//			txtMaKH.setText("");
//		}
//		if (!txtTenKH.getText().matches(pantterTen)) {
//			kiemTra = false;
//			JOptionPane.showMessageDialog(null,
//					"Nhập sai định dạng tên khách hàng (Họ và tên phải viết hoa chữ đầu và cách nhau 1 dấu space)");
//			txtTenKH.setText("");
//		}
//		if (!txtDienThoai.getText().matches(pantterSDT)) {
//			kiemTra = false;
//			JOptionPane.showMessageDialog(null,
//					"Nhập sai định dạng số điện thoại khách hàng (Số điện thoại phải số 0 đầu tiên và gồm 10-11 chữ số)");
//			txtDienThoai.setText("");
//		}
//		if (!txtEmail.getText().matches(pantterEmail)) {
//			kiemTra = false;
//			JOptionPane.showMessageDialog(null, "Nhập sai định dạng Email");
//			txtEmail.setText("");
//		}
//		if (!txtSoTheATM.getText().matches(pantterSoTheATM)) {
//			kiemTra = false;
//			JOptionPane.showMessageDialog(null, "Nhập sai định dạng số thẻ ATM (Số thẻ ATM gồm 16 ký tự)");
//			txtSoTheATM.setText("");
//		}
//		if (!txtSoTK.getText().matches(pantterSoTK)) {
//			kiemTra = false;
//			JOptionPane.showMessageDialog(null, "Nhập sai định dạng số tài khoản (Số tài khoản gồm 13 ký tự)");
//			txtSoTK.setText("");
//		}
//		if (!txtSoTien.getText().matches(pantterSoTien)) {
//			kiemTra = false;
//			JOptionPane.showMessageDialog(null,
//					"Nhập sai định dạng số tiền (Số tiền phải bắt đầu từ 1-10 và phải là bội số của 10000)");
//			txtSoTien.setText("");
//		}
//
//		return kiemTra;
//	}

	/**
	 * Kiểm tra dữ liệu sửa thông tin khách hàng
	 * 
	 * @return
	 */
//	public boolean kiemTraNhapDuLieuUpdateKhachHang() {
//		boolean kiemTra = true;
//		String pantterMaKh = "\\w{6}";
//		String pantterTen = "[A-Z][a-z]*( [A-Z][a-z]+)+";
//		String pantterSDT = "0[0-9]{9,10}";
//		String pantterEmail = "\\w+@\\w+(\\.\\w+){1,2}";
//		String pantterSoTien = "[1-9][0-9]+0000";
//		if (!txtMaKH.getText().matches(pantterMaKh)) {
//			kiemTra = false;
//			JOptionPane.showMessageDialog(null, "Nhập sai định dạng mã khách khàng (Mã khách hàng gồm 6 ký tự)");
//			txtMaKH.setText("");
//		}
//		if (!txtTenKH.getText().matches(pantterTen)) {
//			kiemTra = false;
//			JOptionPane.showMessageDialog(null,
//					"Nhập sai định dạng tên khách hàng (Họ và tên phải viết hoa chữ đầu và cách nhau 1 dấu space)");
//			txtTenKH.setText("");
//		}
//		if (!txtDienThoai.getText().matches(pantterSDT)) {
//			kiemTra = false;
//			JOptionPane.showMessageDialog(null,
//					"Nhập sai định dạng số điện thoại khách hàng (Số điện thoại phải số 0 đầu tiên và gồm 10-11 chữ số)");
//			txtDienThoai.setText("");
//		}
//		if (!txtEmail.getText().matches(pantterEmail)) {
//			kiemTra = false;
//			JOptionPane.showMessageDialog(null, "Nhập sai định dạng Email");
//			txtEmail.setText("");
//		}
//		if (!txtSoTien.getText().matches(pantterSoTien)) {
//			kiemTra = false;
//			JOptionPane.showMessageDialog(null,
//					"Nhập sai định dạng số tiền (Số tiền phải bắt đầu từ 1-10 và phải là bội số của 10000)");
//			txtSoTien.setText("");
//		}
//
//		return kiemTra;
//	}
//
//	public KhachHang layGiaTriKhachHang() {
//		khachHang = new KhachHang();
//		khachHang.setMaKH(txtMaKH.getText());
//		khachHang.setTenKH(txtTenKH.getText());
//		khachHang.setDiaChi(txtDiaChi.getText());
//		khachHang.setPhuong(tenPhuong);
//		khachHang.setQuan(tenQuan);
//		khachHang.setSoDT(txtDienThoai.getText());
//		khachHang.setSoTheATM(txtSoTheATM.getText());
//		khachHang.setSoTK(txtSoTK.getText());
//		khachHang.setSoTienTrongTK(txtSoTien.getText());
//		return khachHang;
//	}
}
