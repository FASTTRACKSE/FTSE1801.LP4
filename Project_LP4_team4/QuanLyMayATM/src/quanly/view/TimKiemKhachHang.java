package quanly.view;

import java.awt.Color;
import java.awt.Container;
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

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import quanly.entity.KhachHang;
import quanly.model.KhachHangDAO;
import quanly.model.PhuongQuanDAO;

public class TimKiemKhachHang extends JFrame {
	private static final long serialVersionUID = 1L;
	JPanel pnTimKiem, pnNhap, pnbutton;
	JPanel pnLabel1, pnLabel2;
	JLabel title, tenKH, diaChi, phuong, quan, dienThoai, email, soCMND;
	JTextField txtTenKH, txtDiaChi, txtDienThoai, txtEmail, txtSoCMND;
	JComboBox<String> boxPhuong, boxQuan;
	JButton tim, huy;
	PhuongQuanDAO phuongQuanDAO;
	KhachHangDAO khachHangDAO;
	ArrayList<String> listPhuong;
	ArrayList<String> listQuan;
	DefaultTableModel tableModel;
	KhachHang khachHang;

	ActionListener actionListener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == huy) {
				dispose();
			}
			if (e.getSource() == tim) {
				if (txtTenKH.getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Bắt buộc nhập tên");
				} else {
					ArrayList<KhachHang> listKH = khachHangDAO.timKiem(layGiaTriKhachHang());
					if (listKH.isEmpty()) {
						JOptionPane.showMessageDialog(null, "Không có khách hàng nào theo tiêu chí đã nhập");
					} else {
						tableModel.setRowCount(0);
						for (int i = 0; i < listKH.size(); i++) {
							tableModel.addRow(new String[] { listKH.get(i).getMaKH(), listKH.get(i).getTenKH(),
									listKH.get(i).getDiaChi(), listKH.get(i).getPhuong(), listKH.get(i).getQuan(),
									listKH.get(i).getSoDT(), listKH.get(i).getEmail(), listKH.get(i).getSoCMND(),
									listKH.get(i).getSoTheATM(), listKH.get(i).getSoTK(),
									listKH.get(i).getSoTienTrongTK() });
						}
					}
				}
			}
		}
	};

	ItemListener itemListener = new ItemListener() {

		@Override
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

	public void TimKiem(DefaultTableModel tableModel) {
		this.tableModel = tableModel;
		phuongQuanDAO = new PhuongQuanDAO();
		khachHangDAO = new KhachHangDAO();
		pnTimKiem = new JPanel();
		pnTimKiem.setLayout(new BoxLayout(pnTimKiem, BoxLayout.Y_AXIS));
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
		tenKH = new JLabel("Họ tên khách hàng :");
		dienThoai = new JLabel("Số điện thoại :");
		email = new JLabel("Email :");
		soCMND = new JLabel("Số CMND");

		txtTenKH = new JTextField(10);
		txtDienThoai = new JTextField(10);
		txtEmail = new JTextField(10);
		txtSoCMND = new JTextField(10);

		addItem(pnLabel1, tenKH, 0, 0, 1, 1, GridBagConstraints.EAST);
		addItem(pnLabel1, dienThoai, 0, 1, 1, 1, GridBagConstraints.EAST);
		addItem(pnLabel1, email, 0, 2, 1, 1, GridBagConstraints.EAST);
		addItem(pnLabel1, soCMND, 0, 3, 1, 1, GridBagConstraints.EAST);

		addItem(pnLabel1, txtTenKH, 1, 0, 2, 1, GridBagConstraints.WEST);
		addItem(pnLabel1, txtDienThoai, 1, 1, 2, 1, GridBagConstraints.WEST);
		addItem(pnLabel1, txtEmail, 1, 2, 2, 1, GridBagConstraints.WEST);
		addItem(pnLabel1, txtSoCMND, 1, 3, 2, 1, GridBagConstraints.WEST);
		pnNhap.add(pnLabel1);

		pnLabel2 = new JPanel();
		pnLabel2.setLayout(new GridBagLayout());
		diaChi = new JLabel("Địa chỉ nhà :");
		quan = new JLabel("Quận :");
		phuong = new JLabel("Phường :");

		txtDiaChi = new JTextField(10);
		boxQuan = new JComboBox<String>();
		listQuan = phuongQuanDAO.showAllDanhSachQuan();
		boxQuan.addItem("");
		boxQuan.addItemListener(itemListener);
		for (int i = 0; i < listQuan.size(); i++) {
			boxQuan.addItem(listQuan.get(i).toString());
		}
		boxPhuong = new JComboBox<String>();
		boxPhuong.addItem("");
		listPhuong = phuongQuanDAO.showDanhSachPhuong(listQuan.get(0).toString());
		for (int i = 0; i < listPhuong.size(); i++) {
			boxPhuong.addItem(listPhuong.get(i).toString());
		}

		addItem(pnLabel2, diaChi, 0, 0, 1, 1, GridBagConstraints.EAST);
		addItem(pnLabel2, quan, 0, 1, 1, 1, GridBagConstraints.EAST);
		addItem(pnLabel2, phuong, 0, 2, 1, 1, GridBagConstraints.EAST);

		addItem(pnLabel2, txtDiaChi, 1, 0, 2, 1, GridBagConstraints.WEST);
		addItem(pnLabel2, boxQuan, 1, 1, 2, 1, GridBagConstraints.WEST);
		addItem(pnLabel2, boxPhuong, 1, 2, 2, 1, GridBagConstraints.WEST);

		pnNhap.add(pnLabel2);
		pnTimKiem.add(pnNhap);

		// Các button chức năng
		pnbutton = new JPanel();
		tim = new JButton("Tìm kiếm");
		huy = new JButton("Hủy");
		huy.addActionListener(actionListener);
		tim.addActionListener(actionListener);
		pnbutton.add(tim);
		pnbutton.add(huy);
		pnTimKiem.add(pnbutton);

		Container container = getContentPane();
		container.add(pnTimKiem);

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
	 * Lấy giá trị nhập thông tin khách hàng
	 * 
	 * @return
	 */
	public KhachHang layGiaTriKhachHang() {
		khachHang = new KhachHang();
		khachHang.setTenKH(txtTenKH.getText());
		khachHang.setDiaChi(txtDiaChi.getText());
		khachHang.setPhuong(boxPhuong.getSelectedItem().toString());
		khachHang.setSoDT(txtDienThoai.getText());
		khachHang.setEmail(txtEmail.getText());
		khachHang.setSoCMND(txtSoCMND.getText());
		return khachHang;
	}

	public void display() {
		setSize(700, 500);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

}
