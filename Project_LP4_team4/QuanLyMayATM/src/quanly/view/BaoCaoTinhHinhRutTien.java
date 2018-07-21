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
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class BaoCaoTinhHinhRutTien extends JFrame {

	private static final long serialVersionUID = 1L;

	JPanel pnBaoCaoTH, chon, pnTongTienRut;
	JPanel pnLabel, pnBox, pnTim;
	JLabel title, thoiGian, tongTienRut, maKH;
	JTextField txtMaKH, txtTongTienRut;
	JComboBox<?> boxThoiGian;
	JButton tim;
	DefaultTableModel tableModel;
	JTable table;
	Border border;
	TitledBorder  titledBorder;
	
	public JPanel tinhHinhRutTien() {
		pnBaoCaoTH = new JPanel();
		pnBaoCaoTH.setLayout(new BoxLayout(pnBaoCaoTH, BoxLayout.Y_AXIS));
		// Tiêu đề
		title = new JLabel("Báo cáo khách hàng");
		title.setFont(new Font("Times New Roman", Font.BOLD, 30));
		title.setForeground(Color.RED);
		pnBaoCaoTH.add(title);
		
		// Chọn tiêu chí
		chon = new JPanel();
		chon.setLayout(new GridBagLayout());
		pnLabel = new JPanel();
		
		maKH = new JLabel("Mã khách hàng:");
		txtMaKH = new JTextField(10);
		
		thoiGian = new JLabel("Chọn thời gian:");
		String strThoiGian[] = {" "};
		boxThoiGian = new JComboBox<>(strThoiGian);
		
		
		addItem(pnLabel, maKH, 0, 0, 1, 1, GridBagConstraints.EAST);
		addItem(pnLabel, txtMaKH, 1, 0, 2, 1, GridBagConstraints.WEST);
		addItem(pnLabel, thoiGian, 0, 1, 1, 1, GridBagConstraints.EAST);
		addItem(pnLabel, boxThoiGian, 1, 1, 2, 1, GridBagConstraints.WEST);
		chon.add(pnLabel);
		
		pnTim = new JPanel();
		tim = new JButton("Tìm danh sách");
		pnTim.add(tim);
		chon.add(pnTim);
		pnBaoCaoTH.add(chon);
		
		// Bảng báo cáo
		border = BorderFactory.createLineBorder(Color.BLUE, 3, true);
		titledBorder = new TitledBorder(border,"Danh sách tình hình rút tiền rút tiền của khách hàng");
		tableModel = new DefaultTableModel();
		tableModel.addColumn("Máy ATM");
		tableModel.addColumn("Thời gian giao dịch");
		tableModel.addColumn("Số tiền giao dịch");
		
		table = new JTable(tableModel);
		JScrollPane jScrollPane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		jScrollPane.setBorder(titledBorder);
		pnBaoCaoTH.add(jScrollPane);
		
		pnTongTienRut = new JPanel();
		tongTienRut = new JLabel("Tổng số tiền đã rút:");
		txtTongTienRut = new JTextField(10);
		pnTongTienRut.add(tongTienRut);pnTongTienRut.add(txtTongTienRut);
		pnBaoCaoTH.add(pnTongTienRut);
		
		return pnBaoCaoTH;
				
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
