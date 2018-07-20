package quanly.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
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
	JButton them, sua, xoa;
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
		
		pnLabel1 = new JPanel();
		pnLabel1.setLayout(new BoxLayout(pnLabel1, BoxLayout.Y_AXIS));
		maMayATM = new JLabel("Mã máy ATM");
		viTri = new JLabel("Vị trí đặt máy");
		pnLabel1.add(maMayATM);pnLabel1.add(viTri);
		pnNhap.add(pnLabel1);
		
		pnTextField1 = new JPanel();
		pnTextField1.setLayout(new BoxLayout(pnTextField1, BoxLayout.Y_AXIS));
		txtMaMayATM = new JTextField(10);
		txtViTri = new JTextField(10);
		pnTextField1.add(txtMaMayATM);pnTextField1.add(txtViTri);
		pnNhap.add(pnTextField1);
		
		pnLabel2 = new JPanel();
		pnLabel2.setLayout(new BoxLayout(pnLabel2, BoxLayout.Y_AXIS));
		quan = new JLabel("Quận");
		phuong = new JLabel("Phường");
		pnLabel2.add(quan);pnLabel2.add(phuong);
		pnNhap.add(pnLabel2);
		
		pnTextField2 = new JPanel();
		pnTextField2.setLayout(new BoxLayout(pnTextField2, BoxLayout.Y_AXIS));
		String strQuan[] = {" "};
		boxQuan = new JComboBox<>(strQuan);
		String strPhuong[] = {" "};
		boxPhuong = new JComboBox<>(strPhuong);
		pnTextField2.add(boxQuan);pnTextField2.add(boxPhuong);
		pnNhap.add(pnTextField2);
		
		pnLabel3 = new JPanel();
		pnLabel3.setLayout(new BoxLayout(pnLabel3, BoxLayout.X_AXIS));
		tongTien = new JLabel("Tổng tiền trong máy");
		txtTongTien = new JTextField(10);
		pnLabel3.add(tongTien);pnLabel3.add(txtTongTien);
		pnNhap.add(pnLabel3);
		
		pnbutton = new JPanel();
		pnbutton.setLayout(new BoxLayout(pnbutton, BoxLayout.X_AXIS));
		them = new JButton("Thêm máy ATM");
		sua = new JButton("Sửa thông tin máy ATM");
		xoa = new JButton("Xóa thông tin máy ATM");
		pnbutton.add(them);pnbutton.add(sua);pnbutton.add(xoa);
		
		
		
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
	
	
	
}
