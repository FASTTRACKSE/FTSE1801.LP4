package quanly.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
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
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import quanly.entity.MayATM;
import quanly.model.MayAtmDAO;
import quanly.model.PhuongQuanDAO;

public class BaoCaoTinhTrangATM extends JFrame {

	private static final long serialVersionUID = 1L;
	JPanel pnBaoCaoTinhHinh, chon, pnButton;
	JPanel pnLabel, pnBox, pnChon;
	JLabel title, phuong, quan, may;
	JComboBox<String> boxPhuong, boxQuan, boxMay;
	JButton tim, hienThi;
	DefaultTableModel tableModel;
	JTable table;
	Border border;
	TitledBorder titledBorder;
	ArrayList<String> listQuan;
	ArrayList<String> listPhuong;
	PhuongQuanDAO phuongQuanDAO;
	MayAtmDAO mayAtmDAO;

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
	 * Chọn máy ATM
	 */
	ItemListener itemListenerMay = new ItemListener() {
		public void itemStateChanged(ItemEvent e) {
			if (e.getStateChange() == ItemEvent.SELECTED) {
				boxMay.removeAllItems();
				String tenPhuong = boxPhuong.getSelectedItem().toString();
				ArrayList<MayATM> listMayATM = mayAtmDAO.showMayATMTheoDiaChi(tenPhuong);
				if (listMayATM.isEmpty()) {
					boxMay.addItem("Không có máy ATM");
				} else {
					boxMay.addItem("Tất cả");
					for (int i = 0; i < listMayATM.size(); i++) {
						boxMay.addItem(listMayATM.get(i).getMaMay());
					}
				}

			}
		}
	};

	/**
	 * Sự kiên cho hiển thị máy ATM
	 */
	ActionListener actionListener = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			JButton button = (JButton) e.getSource();

			if (button == hienThi) {
				tableModel.setRowCount(0);
				ArrayList<MayATM> listMayATM = new ArrayList<>();
				listMayATM = mayAtmDAO.showAllMayATM();
				for (int i = 0; i < listMayATM.size(); i++) {
					tableModel.addRow(new String[] { listMayATM.get(i).getMaMay(), listMayATM.get(i).getViTri(),
							listMayATM.get(i).getPhuong(), listMayATM.get(i).getQuan(),
							listMayATM.get(i).getTongTien() });
				}
			}

			if (button == tim) {
				tableModel.setRowCount(0);
				if (boxMay.getSelectedItem().toString().equals("Không có máy ATM")) {
					JOptionPane.showMessageDialog(null, "Không có máy ATM nào");
				} else if (boxMay.getSelectedItem().toString().equals("Tất cả")) {
					ArrayList<MayATM> listMayATM = new ArrayList<>();
					listMayATM = mayAtmDAO.showMayATMTheoDiaChi(boxPhuong.getSelectedItem().toString());
					for (int i = 0; i < listMayATM.size(); i++) {
						tableModel.addRow(new String[] { listMayATM.get(i).getMaMay(), listMayATM.get(i).getViTri(),
								listMayATM.get(i).getPhuong(), listMayATM.get(i).getQuan(),
								listMayATM.get(i).getTongTien() });
					}
				} else {
					MayATM mayATM = new MayATM();
					mayATM = mayAtmDAO.showMayATMMaMay(boxMay.getSelectedItem().toString());
					tableModel.addRow(new String[] { mayATM.getMaMay(), mayATM.getViTri(), mayATM.getPhuong(),
							mayATM.getQuan(), mayATM.getTongTien() });
				}

			}
		}
	};

	public JPanel tinhTrangMayATM() {
		phuongQuanDAO = new PhuongQuanDAO();
		mayAtmDAO = new MayAtmDAO();
		pnBaoCaoTinhHinh = new JPanel();
		pnBaoCaoTinhHinh.setLayout(new BoxLayout(pnBaoCaoTinhHinh, BoxLayout.Y_AXIS));
		// Phần tiêu đề
		title = new JLabel("Báo cáo tình trạng máy ATM");
		title.setFont(new Font("Times New Roman", Font.BOLD, 30));
		title.setForeground(Color.RED);
		pnBaoCaoTinhHinh.add(title);

		//Phần chọn tiêu chí
		chon = new JPanel();
		chon.setLayout(new GridBagLayout());
		pnLabel = new JPanel();

		quan = new JLabel("Chọn quận:");
		boxQuan = new JComboBox<>();
		listQuan = phuongQuanDAO.showAllDanhSachQuan();
		for (int i = 0; i < listQuan.size(); i++) {
			boxQuan.addItem(listQuan.get(i).toString());
		}
		boxQuan.addItemListener(itemListener);

		phuong = new JLabel("Chọn phường:");
		boxPhuong = new JComboBox<>();
		listPhuong = phuongQuanDAO.showDanhSachPhuong(listQuan.get(0).toString());
		for (int i = 0; i < listPhuong.size(); i++) {
			boxPhuong.addItem(listPhuong.get(i).toString());
		}
		boxPhuong.addItemListener(itemListenerMay);
		may = new JLabel("Chọn máy:");
		boxMay = new JComboBox<>();
		String tenPhuong = boxPhuong.getSelectedItem().toString();
		ArrayList<MayATM> listMayATM = mayAtmDAO.showMayATMTheoDiaChi(tenPhuong);
		boxMay.addItem("Tất cả");
		for (int i = 0; i < listMayATM.size(); i++) {
			boxMay.addItem(listMayATM.get(i).getMaMay());
		}

		addItem(pnLabel, quan, 0, 0, 1, 1, GridBagConstraints.EAST);
		addItem(pnLabel, boxQuan, 1, 0, 2, 1, GridBagConstraints.WEST);
		addItem(pnLabel, phuong, 0, 1, 1, 1, GridBagConstraints.EAST);
		addItem(pnLabel, boxPhuong, 1, 1, 2, 1, GridBagConstraints.WEST);
		addItem(pnLabel, may, 0, 2, 1, 1, GridBagConstraints.EAST);
		addItem(pnLabel, boxMay, 1, 2, 2, 1, GridBagConstraints.WEST);
		chon.add(pnLabel);
		pnBaoCaoTinhHinh.add(chon);

		// Các nút chức năng
		pnChon = new JPanel();
		tim = new JButton("Tìm kiếm");
		hienThi = new JButton("Hiển thị tất cả");
		hienThi.addActionListener(actionListener);
		tim.addActionListener(actionListener);
		pnChon.add(tim);
		pnChon.add(hienThi);
		pnBaoCaoTinhHinh.add(pnChon);

		// Bảng báo cáo
		border = BorderFactory.createLineBorder(Color.BLUE, 3, true);
		titledBorder = new TitledBorder(border, "Danh sách thông tin máy ATM");
		tableModel = new DefaultTableModel();
		tableModel.addColumn("Tên máy");
		tableModel.addColumn("Địa chỉ");
		tableModel.addColumn("Phường");
		tableModel.addColumn("Quận");
		tableModel.addColumn("Số tiền còn lại trong máy");

		table = new JTable(tableModel);
//		table.getTableHeader().setReorderingAllowed(false);
		table.setDefaultEditor(Object.class, null);

		JScrollPane jScrollPane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		jScrollPane.setBorder(titledBorder);
		pnBaoCaoTinhHinh.add(jScrollPane);
		return pnBaoCaoTinhHinh;

	}

	/**
	 * Sắp xếp Label
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

}
