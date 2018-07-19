package quanly.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import javax.swing.border.Border;

public class QuanLyKhachHang extends JFrame implements ActionListener {
	
	private static final long serialVersionUID = 1L;
	JPanel pnQuanLyKH, pnNhap, pnTitle, pnbutton;
	JPanel pnLabel1, pnTextField1, pnLabel2, pnTextField2, pnLabel3, pnTextField3;
	JLabel title, maKH, tenKH, diaChi, phuong, quan, dienThoai, email, soTheATM, soTK;
	JTextField txtMaKH, txtTenKH, txtDiaChi, txtDienThoai, txtEmail, txtSoTheATM, txtSoTK;
	JComboBox<?> boxPhuong, boxQuan;
	JButton them, sua, xoa;
	DefaultTableModel tableModel;
	JTable table;
	Border border;
	TitledBorder  titledBorder;
	public JPanel quanLyKH() {
		pnQuanLyKH = new JPanel();
		
		title = new JLabel("Quản lý khách hàng");
		title.setFont(new Font("Times New Roman", Font.BOLD, 30));
		title.setForeground(Color.RED);
		pnQuanLyKH.add(title);
		
		pnNhap = new JPanel();
		pnLabel1 = new JPanel();
		pnLabel1.setLayout(new BoxLayout(pnLabel1, BoxLayout.Y_AXIS));
		maKH = new JLabel("Mã khách hàng");
		tenKH = new JLabel("Họ tên khách hàng");
		diaChi = new JLabel("Địa chỉ nhà");
		pnLabel1.add(maKH);pnLabel1.add(tenKH);pnLabel1.add(diaChi);
		pnNhap.add(pnLabel1);
		
		pnTextField1 = new JPanel();
		pnTextField1.setLayout(new BoxLayout(pnTextField1, BoxLayout.Y_AXIS));
		txtMaKH = new JTextField(10);
		txtTenKH = new JTextField(10);
		txtDiaChi = new JTextField(10);
		pnTextField1.add(txtMaKH);pnTextField1.add(txtTenKH);pnTextField1.add(txtDiaChi);		
		pnNhap.add(pnTextField1);
		
		pnLabel2 = new JPanel();
		pnLabel2.setLayout(new BoxLayout(pnLabel2, BoxLayout.Y_AXIS));
		phuong = new JLabel("Phường");
		quan = new JLabel("Quận");
		dienThoai = new JLabel("Số điện thoại");
		pnLabel2.add(phuong);pnLabel2.add(quan);pnLabel2.add(dienThoai);
		pnNhap.add(pnLabel2);
		
		pnTextField2 = new JPanel();
		pnTextField2.setLayout(new BoxLayout(pnTextField2, BoxLayout.Y_AXIS));
		String strPhuong[] = {" "};
		boxPhuong = new JComboBox<>(strPhuong);
		String strQuan[] = {" "};
		boxQuan = new JComboBox<>(strQuan);
		txtDienThoai = new JTextField(10);
		pnTextField2.add(boxPhuong);pnTextField2.add(boxQuan);pnTextField2.add(txtDienThoai);
		pnNhap.add(pnTextField2);
		
		
		pnLabel3 = new JPanel();
		pnLabel3.setLayout(new BoxLayout(pnLabel3, BoxLayout.Y_AXIS));
		email = new JLabel("Email");
		soTheATM = new JLabel("Số thẻ ATM");
		soTK = new JLabel("Số tài khoản ngân hàng");
		pnLabel3.add(email);pnLabel3.add(soTheATM);pnLabel3.add(soTK);
		pnNhap.add(pnLabel3);
		
		
		pnTextField3 = new JPanel();
		pnTextField3.setLayout(new BoxLayout(pnTextField3, BoxLayout.Y_AXIS));
		txtEmail = new JTextField(10);
		txtSoTheATM = new JTextField(10);
		txtSoTK = new JTextField(10);
		pnTextField3.add(txtEmail);pnTextField3.add(txtSoTheATM);pnTextField3.add(txtSoTK);
		pnNhap.add(pnTextField3);
		pnQuanLyKH.add(pnNhap);
		
		pnbutton = new JPanel();
		them = new JButton("Thêm thông tin khách hàng");
		sua = new JButton("Sửa thông tin khách hàng");
		xoa = new JButton("Xóa thông tin khách hàng");
		pnbutton.add(them);pnbutton.add(sua);pnbutton.add(xoa);
		pnQuanLyKH.add(pnbutton);
		
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
		
		pnQuanLyKH.add(jScrollPane);
		
		pnQuanLyKH.setLayout(new BoxLayout(pnQuanLyKH, BoxLayout.Y_AXIS));

		return pnQuanLyKH;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
	

	
}
