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
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import quanly.entity.GiaoDich;
import quanly.entity.KhachHang;
import quanly.model.GiaoDichDAO;
import quanly.model.KhachHangDAO;
import quanly.model.TheAtmDAO;

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
	KhachHangDAO khachHangDAO;
	TheAtmDAO theAtmDAO;
	GiaoDichDAO giaoDichDAO;
	GiaoDich giaoDich;
	KhachHang khachHang;

	/**
	 * Sự kiện cho các button
	 */
	ActionListener actionListener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == huy) {
				txtTaiKhoan.setText("");
				txtCMND.setText("");
				txtSoTien.setText("");
			}

			if (e.getSource() == themTien) {
				if (kiemTraNhapDuLieu()) {
					if (khachHangDAO.kiemTraSoTKvaSoCMND(txtTaiKhoan.getText(), txtCMND.getText())) {
						khachHangDAO.updateSoTien(txtCMND.getText(),
								theAtmDAO.layThongTinSoTheATM(txtTaiKhoan.getText()), txtSoTien.getText());
							
							giaoDichDAO.addThongTinGiaoDichKhiThemTienTaiNganHang(txtSoTien.getText(),
									txtTaiKhoan.getText(),
									khachHangDAO.layMaKH(theAtmDAO.layThongTinSoTheATM(txtTaiKhoan.getText())));
							khachHang = khachHangDAO.showKhachHangTheoSoThe(theAtmDAO.layThongTinSoTheATM(txtTaiKhoan.getText()));
							giaoDich = giaoDichDAO.layMaGiaoDich();
							tableModel.setRowCount(0);
							tableModel.addRow(new String[] {""+giaoDich.getMaGiaoDich(), giaoDich.getKhachHang().getSoTK(),giaoDich.getThoiGian(),giaoDich.getSoTienThem(),giaoDich.getSoTienRut(),khachHang.getSoTienTrongTK()});
							txtCMND.setText("");
							txtTaiKhoan.setText("");
							txtSoTien.setText("");
							JOptionPane.showMessageDialog(null, "Thêm tiền thành công");
					} else {
						JOptionPane.showMessageDialog(null, "Sai số tk hoặc số CMND");
					}
				}
			}
			
			if (e.getSource() == rutTien) {
				if (kiemTraNhapDuLieu()) {
					if (khachHangDAO.kiemTraSoTKvaSoCMND(txtTaiKhoan.getText(), txtCMND.getText())) {
						if (khachHangDAO.rutTien(khachHangDAO.showKhachHangTheoSoThe(theAtmDAO.layThongTinSoTheATM(txtTaiKhoan.getText())),txtSoTien.getText())) {
							giaoDichDAO.addThongTinGiaoDichKhiRutTienTaiNganHang(txtSoTien.getText(),
									txtTaiKhoan.getText(),
									khachHangDAO.layMaKH(theAtmDAO.layThongTinSoTheATM(txtTaiKhoan.getText())));
							khachHang = khachHangDAO.showKhachHangTheoSoThe(theAtmDAO.layThongTinSoTheATM(txtTaiKhoan.getText()));
							giaoDich = giaoDichDAO.layMaGiaoDich();
							tableModel.setRowCount(0);
							tableModel.addRow(new String[] {""+giaoDich.getMaGiaoDich(), giaoDich.getKhachHang().getSoTK(),giaoDich.getThoiGian(),giaoDich.getSoTienThem(),giaoDich.getSoTienRut(),khachHang.getSoTienTrongTK()});
							txtCMND.setText("");
							txtTaiKhoan.setText("");
							txtSoTien.setText("");
							JOptionPane.showMessageDialog(null, "Rút tiền thành công");
						} else {
							JOptionPane.showMessageDialog(null, "Số tiền trong tài khoản không đủ để rút");
						}
					}else {
						JOptionPane.showMessageDialog(null, "Sai số tk hoặc số CMND");
					}
				}
			}

		}
	};

	public JPanel giaoDich() {
		khachHangDAO = new KhachHangDAO();
		theAtmDAO = new TheAtmDAO();
		giaoDichDAO = new GiaoDichDAO();
		giaoDich = new GiaoDich();
		khachHang = new KhachHang();

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
		themTien.addActionListener(actionListener);
		rutTien.addActionListener(actionListener);
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
	 * Kiểm tra nhập dữ liệu
	 * 
	 * @return
	 */
	public boolean kiemTraNhapDuLieu() {
		boolean kiemTra = true;
		String pantterSoTK = "[0-9]{13}";
		String pantterSoCMND = "[0-9]{9}";
		String pantterSoTien = "[1-9][0-9]{0,3}0000";
		if (!txtTaiKhoan.getText().matches(pantterSoTK)) {
			kiemTra = false;
			JOptionPane.showMessageDialog(null, "Tài khoản phải nhập đủ 13 số");
			txtTaiKhoan.setText("");
		}
		if (!txtCMND.getText().matches(pantterSoCMND)) {
			kiemTra = false;
			JOptionPane.showMessageDialog(null, "Số CMND phải nhập đủ 9 số");
			txtCMND.setText("");
		}
		if (!txtSoTien.getText().matches(pantterSoTien)) {
			kiemTra = false;
			JOptionPane.showMessageDialog(null, "Số tiền không quá 100 triệu và phải là bội số của 10000");
			txtSoTien.setText("");
		}
		return kiemTra;
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
