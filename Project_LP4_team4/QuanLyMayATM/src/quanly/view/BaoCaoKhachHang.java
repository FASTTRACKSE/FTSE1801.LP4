package quanly.view;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class BaoCaoKhachHang extends JFrame {

	private static final long serialVersionUID = 1L;
	
	JPanel pnBaoCaoKH, chon;
	JPanel pnLabel, pnBox, pnTim;
	JLabel title, phuong, quan;
	JComboBox<?> boxPhuong, boxQuan;
	JButton tim;
	DefaultTableModel tableModel;
	JTable table;
	Border border;
	TitledBorder  titledBorder;
	
	
	public void BaoCaoKH() {
		pnBaoCaoKH = new JPanel();
		pnBaoCaoKH.setLayout(new BoxLayout(pnBaoCaoKH, BoxLayout.Y_AXIS));
		// Tiêu đề
		title = new JLabel("Báo cáo khách hàng");
		title.setFont(new Font("Times New Roman", Font.BOLD, 30));
		title.setForeground(Color.RED);
		pnBaoCaoKH.add(title);
		
		// Chọn tiêu chí
		chon = new JPanel();
		chon.setLayout(new GridLayout(1, 3));
		
		
		pnLabel = new JPanel();
		pnLabel.setLayout(new BoxLayout(pnLabel, BoxLayout.X_AXIS));
		phuong = new JLabel("Chọn phường");
		String strPhuong[] = {" "};
		boxPhuong = new JComboBox<>(strPhuong);
		pnLabel.add(phuong);pnLabel.add(boxPhuong);
		chon.add(pnLabel);
		
		pnBox = new JPanel();
		pnBox.setLayout(new BoxLayout(pnBox, BoxLayout.X_AXIS));
		quan = new JLabel("Chọn quận");
		
		String strQuan[] = {" "};
		boxQuan = new JComboBox<>(strQuan);
		pnBox.add(quan);pnBox.add(boxQuan);
		chon.add(pnBox);
		
		pnTim = new JPanel();
		tim = new JButton("Tìm danh sách");
		pnTim.add(tim);
		chon.add(pnTim);
		
		
		pnBaoCaoKH.add(chon);
		
		
		
		border = BorderFactory.createLineBorder(Color.BLUE, 3, true);
		titledBorder = new TitledBorder(border,"Danh sách thông tin khách hàng");
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
		
		table = new JTable(tableModel);
		JScrollPane jScrollPane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		jScrollPane.setBorder(titledBorder);
		
		pnBaoCaoKH.add(jScrollPane);
		
		
		
		
		
		
		Container container = getContentPane();
		container.add(pnBaoCaoKH);
		
		
	}
	
	public void display() {
		setSize(800, 600);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	
	public static void main(String[] args) {
		BaoCaoKhachHang baoCaoKhachHang = new BaoCaoKhachHang();
		baoCaoKhachHang.BaoCaoKH();
		baoCaoKhachHang.display();
	}
}
