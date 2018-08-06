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
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;

import quanly.entity.KhachHang;
import quanly.model.KhachHangDAO;
import quanly.model.PhuongQuanDAO;
import quanly.model.TheAtmDAO;

public class TimKiemKH extends JFrame {
	private static final long serialVersionUID = 1L;

	JPanel pnTimKiem, pnNhap, pnbutton;
	JPanel pnLabel1, pnLabel2;
	JLabel title, maKH, tenKH, diaChi, phuong, quan, dienThoai, email, soTheATM;
	JTextField txtMaKH, txtTenKH, txtDiaChi, txtDienThoai, txtEmail, txtSoTheATM;
	JComboBox<String> boxPhuong, boxQuan;
	JButton tim, hienthi;
	DefaultTableModel tableModel;
	JTable table;
	Border border;
	TitledBorder titledBorder;
	KhachHangDAO khachHangDAO;
	PhuongQuanDAO phuongQuanDAO;
	TheAtmDAO theAtmDAO;

	KhachHang khachHang;
	ArrayList<String> listQuan;
	ArrayList<String> listPhuong;

	/**
	 * Sự kiện cho chọn số TK và mã thẻ
	 */
	DocumentListener documentListener = new DocumentListener() {

		public void removeUpdate(DocumentEvent e) {
			if (txtTenKH.getText().equals("")) {
				tim.setEnabled(false);
			}
		}

		public void insertUpdate(DocumentEvent e) {
			tim.setEnabled(true);
		}

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

			if (button == tim) {
					KhachHang khachHang = layGiaTriKhachHang();
					ArrayList<KhachHang> myList = khachHangDAO.timKiem(khachHang);
					tableModel.setRowCount(0);
					if (myList.isEmpty()) {
						JOptionPane.showMessageDialog(null, "Không tìm thấy khách bạn cần tìm.");
					} else {
						for (int j = 0; j < myList.size(); j++) {
							tableModel.addRow(new String[] { myList.get(j).getMaKH(), myList.get(j).getTenKH(),
									myList.get(j).getDiaChi(), myList.get(j).getPhuong(), myList.get(j).getQuan(),
									myList.get(j).getSoDT(), myList.get(j).getEmail(), myList.get(j).getSoTheATM(),
									myList.get(j).getSoTK(), myList.get(j).getSoTienTrongTK() });
						}
					}

				} else {
					JOptionPane.showMessageDialog(null, "Vui lòng nhập dữ liệu tìm kiếm");
				}

			if (button == hienthi) {
				if (output == JOptionPane.YES_OPTION) {
					tableModel.setRowCount(0);
					showTable();
				} else if (output == JOptionPane.NO_OPTION) {
				}
			}
		}

	};

	public JPanel timKiemKH() {
		pnTimKiem = new JPanel();
		khachHangDAO = new KhachHangDAO();
		phuongQuanDAO = new PhuongQuanDAO();
		theAtmDAO = new TheAtmDAO();

		// Phần tiêu đề
		title = new JLabel("Tìm kiếm khách hàng");
		title.setFont(new Font("Times New Roman", Font.BOLD, 30));
		title.setForeground(Color.RED);
		pnTimKiem.add(title);

		// Phần nhập thông tin
		pnNhap = new JPanel();
		pnNhap.setLayout(new GridLayout(1, 2));
		pnLabel1 = new JPanel();
		pnLabel1.setLayout(new GridBagLayout());
		maKH = new JLabel("Mã khách hàng :");
		tenKH = new JLabel("Họ tên khách hàng (Bắt buộc) :");
		diaChi = new JLabel("Địa chỉ nhà :");
		quan = new JLabel("Quận :");
		phuong = new JLabel("Phường :");

		txtMaKH = new JTextField(10);
		txtTenKH = new JTextField(10);
		txtTenKH.getDocument().addDocumentListener(documentListener);
		txtDiaChi = new JTextField(10);

		boxQuan = new JComboBox<String>();
		listQuan = phuongQuanDAO.showAllDanhSachQuan();
		boxQuan.addItem("");
		for (int i = 0; i < listQuan.size(); i++) {
			boxQuan.addItem(listQuan.get(i).toString());
		}
		boxQuan.addItemListener(itemListener);
		boxPhuong = new JComboBox<String>();
		boxPhuong.addItem("");
		listPhuong = phuongQuanDAO.showDanhSachPhuong(listQuan.get(0).toString());
		for (int i = 0; i < listPhuong.size(); i++) {
			boxPhuong.addItem(listPhuong.get(i).toString());
		}

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

		txtDienThoai = new JTextField(10);
		txtEmail = new JTextField(10);
		txtSoTheATM = new JTextField(10);

		addItem(pnLabel2, dienThoai, 0, 0, 1, 1, GridBagConstraints.EAST);
		addItem(pnLabel2, email, 0, 1, 1, 1, GridBagConstraints.EAST);
		addItem(pnLabel2, soTheATM, 0, 2, 1, 1, GridBagConstraints.EAST);

		addItem(pnLabel2, txtDienThoai, 1, 0, 2, 1, GridBagConstraints.WEST);
		addItem(pnLabel2, txtEmail, 1, 1, 2, 1, GridBagConstraints.WEST);
		addItem(pnLabel2, txtSoTheATM, 1, 2, 2, 1, GridBagConstraints.WEST);
		pnNhap.add(pnLabel2);
		pnTimKiem.add(pnNhap);

		// Các button chức năng
		pnbutton = new JPanel();
		tim = new JButton("Tìm kiếm");
		tim.setEnabled(false);
		hienthi = new JButton("Hiển thị danh sách");
		hienthi.addActionListener(actionListener);
		tim.addActionListener(actionListener);
		pnbutton.add(tim);
		pnbutton.add(hienthi);
		pnTimKiem.add(pnbutton);

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
		tableModel.addColumn("Số thẻ ATM");
		tableModel.addColumn("Số tài khoản");
		tableModel.addColumn("Số tiền trong tài khoản");

		showTable();

		table = new JTable(tableModel);
		// table.getTableHeader().setReorderingAllowed(false);
		table.setDefaultEditor(Object.class, null);

		JScrollPane jScrollPane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		jScrollPane.setBorder(titledBorder);

		pnTimKiem.add(jScrollPane);
		pnTimKiem.setLayout(new BoxLayout(pnTimKiem, BoxLayout.Y_AXIS));

		return pnTimKiem;
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
					myList.get(i).getSoDT(), myList.get(i).getEmail(), myList.get(i).getSoTheATM(),
					myList.get(i).getSoTK(), myList.get(i).getSoTienTrongTK() });
		}
	}

	/**
	 * Lấy giá trị nhập thông tin khách hàng
	 * 
	 * @return
	 */
	public KhachHang layGiaTriKhachHang() {
		khachHang = new KhachHang();
		khachHang.setMaKH(txtMaKH.getText());
		khachHang.setTenKH(txtTenKH.getText());
		khachHang.setDiaChi(txtDiaChi.getText());
		khachHang.setPhuong(boxPhuong.getSelectedItem().toString());
		khachHang.setQuan(boxQuan.getSelectedItem().toString());
		khachHang.setSoDT(txtDienThoai.getText());
		khachHang.setEmail(txtEmail.getText());
		khachHang.setSoTheATM(txtSoTheATM.getText());
		return khachHang;
	}
}
