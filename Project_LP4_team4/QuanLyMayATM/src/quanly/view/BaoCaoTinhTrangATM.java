package quanly.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class BaoCaoTinhTrangATM extends JFrame {

	private static final long serialVersionUID = 1L;
	JPanel pnBaoCaoTinhHinh, chon, pnButton;
	JPanel pnLabel, pnBox, pnTim;
	JLabel title, phuong, quan, may;
	JComboBox<?> boxPhuong, boxQuan, boxMay;
	JButton tim, hienThi;
	DefaultTableModel tableModel;
	JTable table;
	Border border;
	TitledBorder titledBorder;

	public JPanel tinhTrangMayATM() {

		pnBaoCaoTinhHinh = new JPanel();
		pnBaoCaoTinhHinh.setLayout(new BoxLayout(pnBaoCaoTinhHinh, BoxLayout.Y_AXIS));
		// Tiêu đề
		title = new JLabel("Báo cáo tình trạng máy ATM");
		title.setFont(new Font("Times New Roman", Font.BOLD, 30));
		title.setForeground(Color.RED);
		pnBaoCaoTinhHinh.add(title);

		// Chọn tiêu chí
		chon = new JPanel();
		chon.setLayout(new GridBagLayout());
		pnLabel = new JPanel();
		phuong = new JLabel("Chọn phường:");
		String strPhuong[] = { " " };
		boxPhuong = new JComboBox<>(strPhuong);

		quan = new JLabel("Chọn quận:");
		String strQuan[] = { " " };
		boxQuan = new JComboBox<>(strQuan);

		may = new JLabel("Chọn máy:");
		String strMay[] = { "Tất cả" };
		boxMay = new JComboBox<>(strMay);

		addItem(pnLabel, quan, 0, 0, 1, 1, GridBagConstraints.EAST);
		addItem(pnLabel, boxQuan, 1, 0, 2, 1, GridBagConstraints.WEST);
		addItem(pnLabel, phuong, 0, 1, 1, 1, GridBagConstraints.EAST);
		addItem(pnLabel, boxPhuong, 1, 1, 2, 1, GridBagConstraints.WEST);
		addItem(pnLabel, may, 0, 2, 1, 1, GridBagConstraints.EAST);
		addItem(pnLabel, boxMay, 1, 2, 2, 1, GridBagConstraints.WEST);
		chon.add(pnLabel);
		pnBaoCaoTinhHinh.add(chon);

		pnTim = new JPanel();
		tim = new JButton("Tìm kiếm");
		hienThi = new JButton("Hiển thị tất cả");
		pnTim.add(tim);
		pnTim.add(hienThi);
		pnBaoCaoTinhHinh.add(pnTim);

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
		JScrollPane jScrollPane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		jScrollPane.setBorder(titledBorder);
		pnBaoCaoTinhHinh.add(jScrollPane);
		return pnBaoCaoTinhHinh;

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

}
