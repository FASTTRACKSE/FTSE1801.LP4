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

import quanly.entity.MayATM;
import quanly.model.GiaoDichDAO;
import quanly.model.KhachHangDAO;
import quanly.model.MayAtmDAO;
import quanly.model.PhuongQuanDAO;;

public class QuanLyMayATM extends JFrame {

	private static final long serialVersionUID = 1L;

	JPanel pnQuanLyATM, pnNhap, pnbutton;
	JPanel pnLabel1, pnTextField1, pnLabel2, pnTextField2, pnLabel3, pnTextField3;
	JLabel title, maMayATM, viTri, tongTien, quan, phuong;
	JTextField txtMaMayATM, txtViTri, txtTongTien;
	JButton them, sua, xoa, tim, hienThi, huy;
	DefaultTableModel tableModel;
	JTable table;
	Border border;
	TitledBorder titledBorder;
	JComboBox<String> boxPhuong, boxQuan;
	KhachHangDAO khachHangDAO;
	MayAtmDAO mayAtmDAO;
	PhuongQuanDAO phuongQuanDAO;
	GiaoDichDAO giaoDichDAO;
	ArrayList<String> listQuan;
	ArrayList<String> listPhuong;
	MayATM mayATM;
	String tenQuan;
	String tenPhuong;
	boolean kiemTra = false;

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
				tenQuan = boxQuan.getSelectedItem().toString();
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
	 * Sự kiện cho các Jbutton
	 */
	ActionListener actionListener = new ActionListener() {

		public void actionPerformed(ActionEvent e) {
			JButton button = (JButton) e.getSource();
			int output = JOptionPane.showConfirmDialog(null, "" + button.getActionCommand(), "TPBank Đà Nẵng",
					JOptionPane.YES_NO_OPTION);
			if (button == them) {
				if (output == JOptionPane.YES_OPTION) {
					if (kiemTraAddMayATM()) {
						MayATM mayATM = layThongTinMay();
						if (mayAtmDAO.addMayATM(mayATM)) {
							JOptionPane.showMessageDialog(null, "Thêm máy atm thành công");
							tableModel.setRowCount(0);
							showTable();
							txtMaMayATM.setText("");
							txtTongTien.setText("");
							txtViTri.setText("");
						} else {
							JOptionPane.showMessageDialog(null, "Máy đã tồn tại vui lòng kiểm tra lại.");
						}
					}
				} else if (output == JOptionPane.NO_OPTION) {
				}
			}

			if (button == sua) {
				if (output == JOptionPane.YES_OPTION) {
					if (kiemTraAddMayATM()) {
						mayATM = layThongTinMay();
						if (mayAtmDAO.updateMayATM(mayATM,
								phuongQuanDAO.layThongTinMaPhuong(boxPhuong.getSelectedItem().toString()))) {
							JOptionPane.showMessageDialog(null, "Sửa thành công");
							tableModel.setRowCount(0);
							showTable();
							txtMaMayATM.setText("");
							txtTongTien.setText("");
							txtViTri.setText("");
							kiemTra = false;
							sua.setEnabled(false);
							xoa.setEnabled(false);
							them.setEnabled(true);
							txtMaMayATM.setEnabled(true);
						}
					}
				} else if (output == JOptionPane.NO_OPTION) {
				}
			}

			if (button == xoa) {
				if (output == JOptionPane.YES_OPTION) {
					if (mayAtmDAO.deleteMayATM(txtMaMayATM.getText())) {
						giaoDichDAO.xoaThongTinGDTheoMaMay(txtMaMayATM.getText());
						JOptionPane.showMessageDialog(null, "Xóa thành công");
						tableModel.setRowCount(0);
						showTable();
						txtMaMayATM.setText("");
						txtTongTien.setText("");
						txtViTri.setText("");
						kiemTra = false;
						sua.setEnabled(false);
						xoa.setEnabled(false);
						them.setEnabled(true);
						txtMaMayATM.setEnabled(true);
					}
				} else if (output == JOptionPane.NO_OPTION) {
				}
			}

			if (button == hienThi) {
				if (output == JOptionPane.YES_OPTION) {
					tableModel.setRowCount(0);
					showTable();
				} else if (output == JOptionPane.NO_OPTION) {
				}
			}

			if (button == tim) {
				if (output == JOptionPane.YES_OPTION) {
					TimKiemMayATM timKiemMayATM = new TimKiemMayATM();
					timKiemMayATM.timKiemMayATM(tableModel);
					timKiemMayATM.display();
				} else if (output == JOptionPane.NO_OPTION) {
				}

			}

			if (button == huy) {
				if (output == JOptionPane.YES_OPTION) {
					
					txtMaMayATM.setText("");
					txtTongTien.setText("");
					txtViTri.setText("");
					kiemTra = false;
					sua.setEnabled(false);
					xoa.setEnabled(false);
					them.setEnabled(true);
					txtMaMayATM.setEnabled(true);
				} else if (output == JOptionPane.NO_OPTION) {
				}
			}
		}
	};

	public JPanel qLyMayATM() {
		pnQuanLyATM = new JPanel();
		khachHangDAO = new KhachHangDAO();
		mayAtmDAO = new MayAtmDAO();
		phuongQuanDAO = new PhuongQuanDAO();
		giaoDichDAO = new GiaoDichDAO();

		// Phần tiêu đề
		title = new JLabel("Quản lý máy ATM");
		title.setFont(new Font("Times New Roman", Font.BOLD, 30));
		title.setForeground(Color.RED);
		pnQuanLyATM.add(title);

		// Phần nhập thông tin máy ATM
		pnNhap = new JPanel();
		pnNhap.setLayout(new GridLayout(1, 3));
		pnLabel1 = new JPanel();
		pnLabel1.setLayout(new GridBagLayout());
		maMayATM = new JLabel("Mã máy ATM:");
		viTri = new JLabel("Vị trí đặt máy:");

		txtMaMayATM = new JTextField(10);
		txtViTri = new JTextField(10);
		txtMaMayATM.getDocument().addDocumentListener(documentListener);
		txtViTri.getDocument().addDocumentListener(documentListener);

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

		addItem(pnLabel2, quan, 0, 0, 1, 1, GridBagConstraints.EAST);
		addItem(pnLabel2, phuong, 0, 1, 1, 1, GridBagConstraints.EAST);

		addItem(pnLabel2, boxQuan, 1, 0, 2, 1, GridBagConstraints.WEST);
		addItem(pnLabel2, boxPhuong, 1, 1, 2, 1, GridBagConstraints.WEST);
		pnNhap.add(pnLabel2);

		pnLabel3 = new JPanel();
		tongTien = new JLabel("Tổng tiền trong máy:");
		txtTongTien = new JTextField(10);
		txtTongTien.getDocument().addDocumentListener(documentListener);
		addItem(pnLabel3, tongTien, 0, 0, 1, 1, GridBagConstraints.EAST);
		addItem(pnLabel3, txtTongTien, 1, 0, 2, 1, GridBagConstraints.WEST);
		pnNhap.add(pnLabel3);

		// Các nút chức năng
		pnbutton = new JPanel();
		pnbutton.setLayout(new BoxLayout(pnbutton, BoxLayout.X_AXIS));
		them = new JButton("Thêm máy ATM");
		sua = new JButton("Sửa thông tin máy ATM");
		tim = new JButton("Tìm kiếm");
		xoa = new JButton("Xóa thông tin máy ATM");
		hienThi = new JButton("Hiển thị tất cả máy ATM");
		huy = new JButton("Hủy");

		them.addActionListener(actionListener);
		sua.addActionListener(actionListener);
		tim.addActionListener(actionListener);
		xoa.addActionListener(actionListener);
		hienThi.addActionListener(actionListener);
		huy.addActionListener(actionListener);
		sua.setEnabled(false);
		xoa.setEnabled(false);

		pnbutton.add(them);
		pnbutton.add(sua);
		pnbutton.add(tim);
		pnbutton.add(hienThi);
		pnbutton.add(xoa);
		pnbutton.add(huy);

		// Phần bảng danh sách máy ATM
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
				String s = String.valueOf(table.getValueAt(row, 0));
				txtMaMayATM.setText(s);
				String s1 = String.valueOf(table.getValueAt(row, 1));
				txtViTri.setText(s1);
				String s2 = String.valueOf(table.getValueAt(row, 3));
				boxQuan.getModel().setSelectedItem(s2);
				String s3 = String.valueOf(table.getValueAt(row, 2));
				boxPhuong.getModel().setSelectedItem(s3);
				String s4 = String.valueOf(table.getValueAt(row, 4));
				txtTongTien.setText(s4);
				xoa.setEnabled(true);
				sua.setEnabled(false);
				them.setEnabled(false);
				txtMaMayATM.setEnabled(false);
				kiemTra = true;
			}
		});

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

	/**
	 * Kiểm tra nhập vào các JTextField
	 * 
	 * @return
	 */
	public boolean kiemTraAddMayATM() {
		boolean kiemTra = true;
		String pantterMaMay = "\\w{6}";
		String pantterSoTien = "[1-9][0-9]{0,4}0000";
		if (!txtMaMayATM.getText().matches(pantterMaMay)) {
			kiemTra = false;
			JOptionPane.showMessageDialog(null, "Nhập sai định dạng mã máy (Mã máy gồm 6 ký tự)");
			txtMaMayATM.setText("");
		}

		if (!txtTongTien.getText().matches(pantterSoTien)) {
			kiemTra = false;
			JOptionPane.showMessageDialog(null,
					"Nhập sai định dạng số tiền (Số tiền phải bắt đầu từ 1-10 và phải là bội số của 10000 và không quá 999990000)");
			txtTongTien.setText("");
		}

		return kiemTra;
	}

	/**
	 * Lấy thông tin máy
	 * 
	 * @return
	 */
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
