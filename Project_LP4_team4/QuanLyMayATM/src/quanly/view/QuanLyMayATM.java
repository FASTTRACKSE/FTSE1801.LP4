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

import quanly.entity.MayATM;
import quanly.model.KhachHangDAO;
import quanly.model.MayAtmDAO;;

public class QuanLyMayATM extends JFrame {

	private static final long serialVersionUID = 1L;

	JPanel pnQuanLyATM, pnNhap, pnbutton;
	JPanel pnLabel1, pnTextField1, pnLabel2, pnTextField2, pnLabel3, pnTextField3;
	JLabel title, maMayATM, viTri, tongTien, quan, phuong;
	JTextField txtMaMayATM, txtViTri, txtTongTien;
	JButton them, sua, xoa, tim, hienThi;
	DefaultTableModel tableModel;
	JTable table;
	Border border;
	TitledBorder titledBorder;
	JComboBox<String> boxPhuong, boxQuan;
	KhachHangDAO khachHangDAO;
	MayAtmDAO mayAtmDAO;
	ArrayList<String> listQuan;
	ArrayList<String> listPhuong;
	MayATM mayATM;
	String tenQuan;
	String tenPhuong;

	/**
	 * Sự kiện cho chọn phường và quận
	 */
	ItemListener itemListener = new ItemListener() {
		public void itemStateChanged(ItemEvent e) {
			if (e.getStateChange() == ItemEvent.SELECTED) {
				tenQuan = boxQuan.getSelectedItem().toString();
				boxPhuong.removeAllItems();
				listPhuong = khachHangDAO.showDanhSachPhuong(tenQuan);
				for (int i = 0; i < listPhuong.size(); i++) {
					boxPhuong.addItem(listPhuong.get(i));
				}
			}

			if (e.getStateChange() == ItemEvent.SELECTED) {
				tenPhuong = boxPhuong.getSelectedItem().toString();
			}
		}
	};

	ActionListener actionListener = new ActionListener() {

		public void actionPerformed(ActionEvent e) {
			JButton button = (JButton) e.getSource();
			if (button == them) {
				if (kiemTraAddMayATM()) {
					MayATM mayATM = layThongTinMay();
					if (mayAtmDAO.addMayATM(mayATM)) {
						JOptionPane.showMessageDialog(null, "Thêm máy atm thành công");
						tableModel.setRowCount(0);
						showTable();
					} else {
						JOptionPane.showMessageDialog(null, "Kiểm tra lại mã máy");
					}
				}
			}

			if (button == sua) {
				if (kiemTraAddMayATM()) {
					mayATM = layThongTinMay();
					ArrayList<MayATM> myList = mayAtmDAO.showMayATMMaMay(mayATM.getMaMay());
					if (mayAtmDAO.updateMayATM(myList, mayATM.getTongTien())) {
						JOptionPane.showMessageDialog(null, "Thêm tiền thành công");
						tableModel.setRowCount(0);
						showTable();
					} else {
						JOptionPane.showMessageDialog(null, "Kiểm tra lại mã máy");
					}
				}
			}

			if (button == xoa) {
				if (mayAtmDAO.deleteMayATM(txtMaMayATM.getText())) {
					JOptionPane.showMessageDialog(null, "Xóa thành công");
					tableModel.setRowCount(0);
					showTable();
				} else {
					JOptionPane.showMessageDialog(null, "Kiểm tra lại mã máy");
				}
			}

			if (button == hienThi) {
				tableModel.setRowCount(0);
				showTable();
			}

			if (button == tim) {
				if (txtMaMayATM.getText().equals("")) {
					ArrayList<MayATM> myList = mayAtmDAO.showMayATMTheoDiaChi(boxPhuong.getSelectedItem().toString());
					tableModel.setRowCount(0);
					for (int i = 0; i < myList.size(); i++) {
						tableModel.addRow(new String[] { myList.get(i).getMaMay(), myList.get(i).getViTri(),
								myList.get(i).getPhuong(), myList.get(i).getQuan(), myList.get(i).getTongTien() });
					}
				} else {
					ArrayList<MayATM> myList = mayAtmDAO.showMayATMMaMay(txtMaMayATM.getText());
					tableModel.setRowCount(0);
					for (int i = 0; i < myList.size(); i++) {
						tableModel.addRow(new String[] { myList.get(i).getMaMay(), myList.get(i).getViTri(),
								myList.get(i).getPhuong(), myList.get(i).getQuan(), myList.get(i).getTongTien() });
					}
				}
			}
		}
	};

	public JPanel qLyMayATM() {
		pnQuanLyATM = new JPanel();
		khachHangDAO = new KhachHangDAO();
		mayAtmDAO = new MayAtmDAO();

		title = new JLabel("Quản lý máy ATM");
		title.setFont(new Font("Times New Roman", Font.BOLD, 30));
		title.setForeground(Color.RED);
		pnQuanLyATM.add(title);

		pnNhap = new JPanel();
		pnNhap.setLayout(new GridLayout(1, 3));
		pnLabel1 = new JPanel();
		pnLabel1.setLayout(new GridBagLayout());
		maMayATM = new JLabel("Mã máy ATM:");
		viTri = new JLabel("Vị trí đặt máy:");

		txtMaMayATM = new JTextField(10);
		txtViTri = new JTextField(10);

		addItem(pnLabel1, maMayATM, 0, 0, 1, 1, GridBagConstraints.EAST);
		addItem(pnLabel1, viTri, 0, 1, 1, 1, GridBagConstraints.EAST);

		addItem(pnLabel1, txtMaMayATM, 1, 0, 2, 1, GridBagConstraints.WEST);
		addItem(pnLabel1, txtViTri, 1, 1, 2, 1, GridBagConstraints.WEST);
		pnNhap.add(pnLabel1);

		pnLabel2 = new JPanel();
		pnLabel2.setLayout(new GridBagLayout());
		quan = new JLabel("Quận:");
		phuong = new JLabel("Phường:");
		boxQuan = new JComboBox<String>();
		listQuan = khachHangDAO.showAllDanhSachQuan();
		for (int i = 0; i < listQuan.size(); i++) {
			boxQuan.addItem(listQuan.get(i).toString());
		}
		boxQuan.addItemListener(itemListener);
		boxPhuong = new JComboBox<String>();
		listPhuong = khachHangDAO.showDanhSachPhuong(listQuan.get(0).toString());
		for (int i = 0; i < listPhuong.size(); i++) {
			boxPhuong.addItem(listPhuong.get(i).toString());
		}

		addItem(pnLabel2, quan, 0, 0, 1, 1, GridBagConstraints.EAST);
		addItem(pnLabel2, phuong, 0, 1, 1, 1, GridBagConstraints.EAST);

		addItem(pnLabel2, boxQuan, 1, 0, 2, 1, GridBagConstraints.WEST);
		addItem(pnLabel2, boxPhuong, 1, 1, 2, 1, GridBagConstraints.WEST);
		pnNhap.add(pnLabel2);

		pnLabel3 = new JPanel();
		tongTien = new JLabel("Tổng tiền trong máy:");
		txtTongTien = new JTextField(10);
		addItem(pnLabel3, tongTien, 0, 0, 1, 1, GridBagConstraints.EAST);
		addItem(pnLabel3, txtTongTien, 1, 0, 2, 1, GridBagConstraints.WEST);
		pnNhap.add(pnLabel3);

		pnbutton = new JPanel();
		pnbutton.setLayout(new BoxLayout(pnbutton, BoxLayout.X_AXIS));
		them = new JButton("Thêm máy ATM");
		sua = new JButton("Sửa thông tin máy ATM");
		tim = new JButton("Tìm kiếm");
		xoa = new JButton("Xóa thông tin máy ATM");
		hienThi = new JButton("Hiển thị tất cả máy ATM");

		them.addActionListener(actionListener);
		sua.addActionListener(actionListener);
		tim.addActionListener(actionListener);
		xoa.addActionListener(actionListener);
		hienThi.addActionListener(actionListener);

		pnbutton.add(them);
		pnbutton.add(sua);
		pnbutton.add(tim);
		pnbutton.add(hienThi);
		pnbutton.add(xoa);

		border = BorderFactory.createLineBorder(Color.BLUE, 3, true);
		titledBorder = new TitledBorder(border, "Danh sách thông tin khách hàng");
		tableModel = new DefaultTableModel();
		tableModel.addColumn("Tên máy");
		tableModel.addColumn("Địa Chỉ");
		tableModel.addColumn("Phường");
		tableModel.addColumn("Quận");
		tableModel.addColumn("Tổng tiền trong máy");

		showTable();

		table = new JTable(tableModel);
		JScrollPane jScrollPane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		jScrollPane.setBorder(titledBorder);
		pnQuanLyATM.add(pnNhap);
		pnQuanLyATM.add(pnbutton);
		pnQuanLyATM.add(jScrollPane);
		pnQuanLyATM.setLayout(new BoxLayout(pnQuanLyATM, BoxLayout.Y_AXIS));

		return pnQuanLyATM;
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
		ArrayList<MayATM> myList = new ArrayList<>();
		myList = mayAtmDAO.showAllMayATM();
		for (int i = 0; i < myList.size(); i++) {
			tableModel.addRow(new String[] { myList.get(i).getMaMay(), myList.get(i).getViTri(),
					myList.get(i).getPhuong(), myList.get(i).getQuan(), myList.get(i).getTongTien() });
		}
	}

	public boolean kiemTraAddMayATM() {
		boolean kiemTra = true;
		String pantterMaMay = "\\w{6}";
		String pantterSoTien = "[1-9][0-9]*0000";
		if (!txtMaMayATM.getText().matches(pantterMaMay)) {
			kiemTra = false;
			JOptionPane.showMessageDialog(null, "Nhập sai định dạng mã máy (Mã máy gồm 6 ký tự)");
			txtMaMayATM.setText("");
		}

		if (!txtTongTien.getText().matches(pantterSoTien)) {
			kiemTra = false;
			JOptionPane.showMessageDialog(null, "Nhập sai định dạng số tiền (Số tiền phải bắt đầu từ 1-10 và phải là bội số của 10000)");
			txtTongTien.setText("");
		}

		return kiemTra;
	}

	public MayATM layThongTinMay() {
		mayATM = new MayATM();
		mayATM.setMaMay(txtMaMayATM.getText());
		mayATM.setViTri(txtViTri.getText());
		mayATM.setPhuong(boxPhuong.getSelectedItem().toString());
		mayATM.setQuan(boxQuan.getSelectedItem().toString());
		mayATM.setTongTien(txtTongTien.getText());
		return mayATM;
	}

}
