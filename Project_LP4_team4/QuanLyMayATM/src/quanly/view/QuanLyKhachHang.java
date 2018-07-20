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
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class QuanLyKhachHang extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	JPanel pnQuanLyKH, pnNhap, pnbutton;
	JPanel pnLabel1, pnTextField1, pnLabel2, pnTextField2, pnLabel3, pnTextField3;
	JLabel title, maKH, tenKH, diaChi, phuong, quan, dienThoai, email, soTheATM, soTK, soTien;
	JTextField txtMaKH, txtTenKH, txtDiaChi, txtDienThoai, txtEmail, txtSoTheATM, txtSoTK, txtSoTien;
	JComboBox<?> boxPhuong, boxQuan;
	JButton them, sua, xoa;
	DefaultTableModel tableModel;
	JTable table;
	Border border;
	TitledBorder titledBorder;

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
		quan = new JLabel("Quận");
		phuong = new JLabel("Phường");
		pnLabel1.add(maKH);
		pnLabel1.add(tenKH);
		pnLabel1.add(diaChi);
		pnLabel1.add(quan);
		pnLabel1.add(phuong);
		pnNhap.add(pnLabel1);

		pnTextField1 = new JPanel();
		pnTextField1.setLayout(new BoxLayout(pnTextField1, BoxLayout.Y_AXIS));
		txtMaKH = new JTextField(10);
		txtTenKH = new JTextField(10);
		txtDiaChi = new JTextField(10);
		String strQuan[] = { " " };
		boxQuan = new JComboBox<>(strQuan);
		String strPhuong[] = { " " };
		boxPhuong = new JComboBox<>(strPhuong);
		pnTextField1.add(txtMaKH);
		pnTextField1.add(txtTenKH);
		pnTextField1.add(txtDiaChi);
		pnTextField1.add(boxQuan);
		pnTextField1.add(boxPhuong);
		pnNhap.add(pnTextField1);

		pnLabel2 = new JPanel();
		pnLabel2.setLayout(new BoxLayout(pnLabel2, BoxLayout.Y_AXIS));
		dienThoai = new JLabel("Số điện thoại");
		email = new JLabel("Email");
		soTheATM = new JLabel("Số thẻ ATM");
		soTK = new JLabel("Số tài khoản ngân hàng");
		soTien = new JLabel("Số tiền hiện có");
		pnLabel2.add(dienThoai);
		pnLabel2.add(email);
		pnLabel2.add(soTheATM);
		pnLabel2.add(soTK);
		pnLabel2.add(soTien);
		pnNhap.add(pnLabel2);

		pnTextField2 = new JPanel();
		pnTextField2.setLayout(new BoxLayout(pnTextField2, BoxLayout.Y_AXIS));
		txtDienThoai = new JTextField(10);
		txtEmail = new JTextField(10);
		txtSoTheATM = new JTextField(10);
		txtSoTK = new JTextField(10);
		txtSoTien = new JTextField(10);
		pnTextField2.add(txtDienThoai);
		pnTextField2.add(txtEmail);
		pnTextField2.add(txtSoTheATM);
		pnTextField2.add(txtSoTK);
		pnTextField2.add(txtSoTien);
		pnNhap.add(pnTextField2);
		pnQuanLyKH.add(pnNhap);

		pnbutton = new JPanel();
		them = new JButton("Thêm thông tin khách hàng");
		sua = new JButton("Sửa thông tin khách hàng");
		xoa = new JButton("Xóa thông tin khách hàng");
		pnbutton.add(them);
		pnbutton.add(sua);
		pnbutton.add(xoa);
		pnQuanLyKH.add(pnbutton);

		border = BorderFactory.createLineBorder(Color.BLUE, 3, true);
		titledBorder = new TitledBorder(border, "Danh sách thông tin khách hàng");
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
