package quanly.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
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
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class QuanLyMayATM extends JFrame {
	
	private static final long serialVersionUID = 1L;
	
	JPanel pnQuanLyATM, pnNhap, pnbutton;
	JPanel pnLabel1, pnTextField1, pnLabel2, pnTextField2, pnLabel3, pnTextField3;
	JLabel title, maMayATM, viTri, tongTien, quan, phuong;
	JTextField txtMaMayATM, txtViTri, txtTongTien;
	JButton them, sua, xoa, tim;
	DefaultTableModel tableModel;
	JTable table;
	Border border;
	TitledBorder  titledBorder;
	JComboBox<?> boxPhuong, boxQuan;
	
	public JPanel qLyMayATM() {
		pnQuanLyATM = new JPanel();
		
		
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
		String strQuan[] = {" "};
		boxQuan = new JComboBox<>(strQuan);
		String strPhuong[] = {" "};
		boxPhuong = new JComboBox<>(strPhuong);
		
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
		pnbutton.add(them);pnbutton.add(sua);pnbutton.add(tim);pnbutton.add(xoa);
		
		
		
		border = BorderFactory.createLineBorder(Color.BLUE, 3, true);
		titledBorder = new TitledBorder(border,"Danh sách thông tin khách hàng");
		tableModel = new DefaultTableModel();
		tableModel.addColumn("Tên máy");
		tableModel.addColumn("Địa Chỉ");
		tableModel.addColumn("Phường");
		tableModel.addColumn("Quận");
		tableModel.addColumn("Tổng tiền trong máy");
		
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
