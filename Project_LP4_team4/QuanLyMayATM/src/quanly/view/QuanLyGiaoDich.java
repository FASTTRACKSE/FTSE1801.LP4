package quanly.view;

import java.awt.Color;
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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class QuanLyGiaoDich extends JFrame {
	private static final long serialVersionUID = 1L;
	JPanel pnGiaoDich, pnNhap, pnbutton;
	JPanel pnLabel1;
	JLabel title, soTaiKhoan, CMND, soTien;
	JTextField txtTaiKhoan, txtCMND, txtSoTien;
	JButton themTien, rutTien, huy;
	Border border;
	TitledBorder titledBorder;
	DefaultTableModel tableModel;
	JTable table;

	ActionListener actionListener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == huy) {
				txtTaiKhoan.setText("");
				txtCMND.setText("");
				txtSoTien.setText("");
			}

		}
	};

	public JPanel giaoDich() {
		pnGiaoDich = new JPanel();
		pnGiaoDich.setLayout(new BoxLayout(pnGiaoDich, BoxLayout.Y_AXIS));
		// Phần tiêu đề
		title = new JLabel("Giao dịch");
		title.setFont(new Font("Times New Roman", Font.BOLD, 30));
		title.setForeground(Color.RED);
		pnGiaoDich.add(title);

		// Phần nhập thông tin
		pnNhap = new JPanel();
		pnNhap.setLayout(new GridLayout(1, 2));
		pnLabel1 = new JPanel();
		pnLabel1.setLayout(new GridBagLayout());

		soTaiKhoan = new JLabel("Số tài khoản");
		CMND = new JLabel("Số chứng minh nhân dân");
		soTien = new JLabel("Số tiền");
		txtSoTien = new JTextField(10);
		txtTaiKhoan = new JTextField(10);
		txtCMND = new JTextField(10);

		addItem(pnLabel1, soTaiKhoan, 0, 0, 1, 1, GridBagConstraints.EAST);
		addItem(pnLabel1, CMND, 0, 1, 1, 1, GridBagConstraints.EAST);
		addItem(pnLabel1, soTien, 0, 2, 1, 1, GridBagConstraints.EAST);

		addItem(pnLabel1, txtTaiKhoan, 1, 0, 2, 1, GridBagConstraints.WEST);
		addItem(pnLabel1, txtCMND, 1, 1, 2, 1, GridBagConstraints.WEST);
		addItem(pnLabel1, txtSoTien, 1, 2, 2, 1, GridBagConstraints.WEST);
		pnNhap.add(pnLabel1);

		// Các button chức năng
		pnbutton = new JPanel();
		themTien = new JButton("Thêm tiền");
		rutTien = new JButton("Rút tiền");
		huy = new JButton("Hủy");
		huy.addActionListener(actionListener);
		pnbutton.add(themTien);
		pnbutton.add(rutTien);
		pnbutton.add(huy);
		pnGiaoDich.add(pnNhap);
		pnGiaoDich.add(pnbutton);
		

		border = BorderFactory.createLineBorder(Color.BLUE, 3, true);
		titledBorder = new TitledBorder(border, "Danh sách thông tin khách hàng");
		tableModel = new DefaultTableModel();
		tableModel.addColumn("Mã giao dịch");
		tableModel.addColumn("Số tài khoản");
		tableModel.addColumn("Thời gian");
		tableModel.addColumn("Số tiền thêm");
		tableModel.addColumn("Số tiền rút");
		tableModel.addColumn("Số tiền trong tài khoản");

		table = new JTable(tableModel);
		// table.getTableHeader().setReorderingAllowed(false);
		table.setDefaultEditor(Object.class, null);

		JScrollPane jScrollPane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		jScrollPane.setBorder(titledBorder);
		pnGiaoDich.add(jScrollPane);
		pnGiaoDich.setLayout(new BoxLayout(pnGiaoDich, BoxLayout.Y_AXIS));
		return pnGiaoDich;


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

}
