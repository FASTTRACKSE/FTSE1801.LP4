package quanly.view;

 
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import quanly.model.PhuongQuanDAO;

public class TimKiemKhachHang extends JFrame {
	private static final long serialVersionUID = 1L;
	JPanel pnTimKiem, pnNhap, pnbutton;
	JPanel pnLabel1, pnLabel2;
	JLabel title, maKH, tenKH, diaChi, phuong, quan, dienThoai, email;
	JTextField txtMaKH, txtTenKH, txtDiaChi, txtDienThoai, txtEmail;
	JComboBox<String> boxPhuong, boxQuan;
	JButton tim, huy;
	PhuongQuanDAO phuongQuanDAO;
	ArrayList<String> listPhuong;
	ArrayList<String> listQuan;
	
	ActionListener actionListener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource()==huy) {
				dispose();
			}
			if (e.getSource()==tim) {
				
			}
		}
	};
	
	ItemListener itemListener = new ItemListener() {
		
		@Override
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
	
	
	
	
	public void TimKiem() {
		phuongQuanDAO = new PhuongQuanDAO();
		pnTimKiem = new JPanel();
		pnTimKiem.setLayout(new BoxLayout(pnTimKiem, BoxLayout.Y_AXIS));
		// Phần tiêu đề
		title = new JLabel("Tìm kiếm khách hàng");
		title.setFont(new Font("Times New Roman", Font.BOLD, 30));
		title.setForeground(Color.RED);
		pnTimKiem.add(title);

		// Phần nhập thông tin
		pnNhap = new JPanel();
		pnNhap.setLayout(new GridLayout(1, 2));
		pnLabel1 = new JPanel();
		pnLabel1.setLayout(new GridBagLayout());
		maKH = new JLabel("Mã khách hàng :");
		tenKH = new JLabel("Họ tên khách hàng :");
		dienThoai = new JLabel("Số điện thoại :");
		email = new JLabel("Email :");

		txtMaKH = new JTextField(10);
		txtTenKH = new JTextField(10);
		txtDienThoai = new JTextField(10);
		txtEmail = new JTextField(10);

		addItem(pnLabel1, maKH, 0, 0, 1, 1, GridBagConstraints.EAST);
		addItem(pnLabel1, tenKH, 0, 1, 1, 1, GridBagConstraints.EAST);
		addItem(pnLabel1, dienThoai, 0, 2, 1, 1, GridBagConstraints.EAST);
		addItem(pnLabel1, email, 0, 3, 1, 1, GridBagConstraints.EAST);

		addItem(pnLabel1, txtMaKH, 1, 0, 2, 1, GridBagConstraints.WEST);
		addItem(pnLabel1, txtTenKH, 1, 1, 2, 1, GridBagConstraints.WEST);
		addItem(pnLabel1, txtDienThoai, 1, 2, 2, 1, GridBagConstraints.WEST);
		addItem(pnLabel1, txtEmail, 1, 3, 2, 1, GridBagConstraints.WEST);
		pnNhap.add(pnLabel1);

		pnLabel2 = new JPanel();
		pnLabel2.setLayout(new GridBagLayout());
		diaChi = new JLabel("Địa chỉ nhà :");
		quan = new JLabel("Quận :");
		phuong = new JLabel("Phường :");
		
		txtDiaChi = new JTextField(10);
		boxQuan = new JComboBox<String>();
		listQuan = phuongQuanDAO.showAllDanhSachQuan();
		boxQuan.addItem("");
		boxQuan.addItemListener(itemListener);
		for (int i = 0; i < listQuan.size(); i++) {
			boxQuan.addItem(listQuan.get(i).toString());
		}
		boxPhuong = new JComboBox<String>();
		boxPhuong.addItem("");
		listPhuong = phuongQuanDAO.showDanhSachPhuong(listQuan.get(0).toString());
		for (int i = 0; i < listPhuong.size(); i++) {
			boxPhuong.addItem(listPhuong.get(i).toString());
		}

		addItem(pnLabel2, diaChi, 0, 0, 1, 1, GridBagConstraints.EAST);
		addItem(pnLabel2, quan, 0, 1, 1, 1, GridBagConstraints.EAST);
		addItem(pnLabel2, phuong, 0, 2, 1, 1, GridBagConstraints.EAST);

		addItem(pnLabel2, txtDiaChi, 1, 0, 2, 1, GridBagConstraints.WEST);
		addItem(pnLabel2, boxQuan, 1, 1, 2, 1, GridBagConstraints.WEST);
		addItem(pnLabel2, boxPhuong, 1, 2, 2, 1, GridBagConstraints.WEST);
		
		pnNhap.add(pnLabel2);
		pnTimKiem.add(pnNhap);

		// Các button chức năng
		pnbutton = new JPanel();
		tim = new JButton("Tìm kiếm");
		huy = new JButton("Hủy");
		huy.addActionListener(actionListener);
		pnbutton.add(tim);pnbutton.add(huy);
		pnTimKiem.add(pnbutton);
		
		Container container = getContentPane();
		container.add(pnTimKiem);

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




	public void display() {
		setSize(700,500);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		TimKiemKhachHang khacHang = new TimKiemKhachHang();
		khacHang.TimKiem();
		khacHang.display();
	}
}

