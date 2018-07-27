package quanly.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

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


public class QuanLyTheATM extends JFrame{

	private static final long serialVersionUID = 1L;
	JPanel pnQuanLyTheATM, pnNhap, pnButton;
	JLabel title, soTheATM, soTK;
	JTextField txtSoThe, txtSoTK;
	JButton them, xoa, hienThi;
	Border border;
	TitledBorder titledBorder;
	DefaultTableModel tableModel;
	JTable table;
	
	
	public JPanel quanLyThe() {
		pnQuanLyTheATM = new JPanel();
		pnQuanLyTheATM.setLayout(new BoxLayout(pnQuanLyTheATM, BoxLayout.Y_AXIS));
		
		// Tiêu đề
		title = new JLabel("Quản lý thẻ ATM");
		title.setFont(new Font("Times New Roman", Font.BOLD, 30));
		title.setForeground(Color.RED);
		pnQuanLyTheATM.add(title);
		
		// Phần thân
		pnNhap = new JPanel();
		pnNhap.setLayout(new GridBagLayout());
		
		soTheATM = new JLabel("Số thẻ ATM");
		soTK = new JLabel("Số tài khoản");
		txtSoThe = new JTextField(15);
		txtSoTK = new JTextField(15);
		addItem(pnNhap, soTheATM, 0, 0, 1, 1, GridBagConstraints.EAST);
		addItem(pnNhap, txtSoThe, 1, 0, 2, 1, GridBagConstraints.WEST);
		addItem(pnNhap, soTK, 0, 1, 1, 1, GridBagConstraints.EAST);
		addItem(pnNhap, txtSoTK, 1, 1, 2, 1, GridBagConstraints.WEST);
		pnQuanLyTheATM.add(pnNhap);
		
		pnButton = new JPanel();
		them = new JButton("Thêm thẻ ATM");
		hienThi = new JButton("Hiển thị danh sách thẻ ATM");
		xoa = new JButton("Xóa thẻ ATM");
		pnButton.add(them);pnButton.add(hienThi);pnButton.add(xoa);
		pnQuanLyTheATM.add(pnButton);
		
		// Bảng danh sách thẻ ATM
		border = BorderFactory.createLineBorder(Color.BLUE, 3, true);
		titledBorder = new TitledBorder(border,"Danh sách thông tin khách hàng");
		tableModel = new DefaultTableModel();
		tableModel.addColumn("Số thẻ ATM");
		tableModel.addColumn("Số tài khoản");
		table = new JTable(tableModel);
		table.getTableHeader().setReorderingAllowed(false);
		table.setDefaultEditor(Object.class, null);
		
		JScrollPane jScrollPane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		jScrollPane.setBorder(titledBorder);
		pnQuanLyTheATM.add(jScrollPane);
		return pnQuanLyTheATM;
		
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
	
	
}
