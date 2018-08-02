package quanly.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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

import quanly.entity.TheATM;
import quanly.model.KhachHangDAO;
import quanly.model.TheAtmDAO;

public class QuanLyTheATM extends JFrame {

	private static final long serialVersionUID = 1L;
	JPanel pnQuanLyTheATM, pnNhap, pnButton;
	JLabel title, soTheATM, soTK;
	JTextField txtSoThe, txtSoTK;
	JButton them, xoa, hienThi, tim;
	Border border;
	TitledBorder titledBorder;
	DefaultTableModel tableModel;
	JTable table;
	TheAtmDAO theAtmDAO;
	KhachHangDAO khachHangDAO;
	
	/**
	 * Sự kiện cho các Jbutton
	 */
	ActionListener actionListener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton button = (JButton) e.getSource();
			int output = JOptionPane.showConfirmDialog(null, "" + button.getActionCommand(), "TPBank Đà Nẵng",
					JOptionPane.YES_NO_OPTION);
			if (e.getSource() == them) {
				if (output == JOptionPane.YES_OPTION) {
					if (kiemTra()) {
						if (theAtmDAO.addTheATM(txtSoThe.getText(), txtSoTK.getText())) {
							JOptionPane.showMessageDialog(null, "Thêm thành công");
							tableModel.setRowCount(0);
							showALL();
						} else {
							JOptionPane.showMessageDialog(null, "Trùng số thẻ hoặc số tài khoản");
						}

					} else {
						JOptionPane.showMessageDialog(null, "Nhập sai định dạng số thẻ hoặc số tài khoản.");
					}
				} else if (output == JOptionPane.NO_OPTION) {
				}
			}

			if (e.getSource() == hienThi) {
				if (output == JOptionPane.YES_OPTION) {
					tableModel.setRowCount(0);
					showALL();
				} else if (output == JOptionPane.NO_OPTION) {
				}
			}

			if (e.getSource() == tim) {
				if (output == JOptionPane.YES_OPTION) {
					tableModel.setRowCount(0);
					if (!txtSoThe.getText().equals("") && !txtSoTK.getText().equals("")) {
						ArrayList<TheATM> listThe = theAtmDAO.layThongTinTheoSoTKVaSoThe(txtSoTK.getText(),
								txtSoThe.getText());
						if (listThe.isEmpty()) {
							JOptionPane.showMessageDialog(null, "Nhập sai số thẻ hoặc số tài khoản");
						} else {
							for (int i = 0; i < listThe.size(); i++) {
								tableModel.addRow(new String[] { listThe.get(i).getSoTheATM(), listThe.get(i).getSoTK(),
										listThe.get(i).getPass() });
							}
						}
					} else if (!txtSoThe.getText().equals("") && txtSoTK.getText().equals("")) {
						ArrayList<TheATM> listThe = theAtmDAO.layThongTinTheoSoTheATM(txtSoThe.getText());
						if (listThe.isEmpty()) {
							JOptionPane.showMessageDialog(null, "Không tồn tại số thẻ ATM này");
						} else {
							for (int i = 0; i < listThe.size(); i++) {
								tableModel.addRow(new String[] { listThe.get(i).getSoTheATM(), listThe.get(i).getSoTK(),
										listThe.get(i).getPass() });
							}
						}
					} else if (txtSoThe.getText().equals("") && !txtSoTK.getText().equals("")) {
						ArrayList<TheATM> listThe = theAtmDAO.layThongTinTheoSoTK(txtSoTK.getText());
						if (listThe.isEmpty()) {
							JOptionPane.showMessageDialog(null, "Không tồn tại số tài khoản này");
						} else {
							for (int i = 0; i < listThe.size(); i++) {
								tableModel.addRow(new String[] { listThe.get(i).getSoTheATM(), listThe.get(i).getSoTK(),
										listThe.get(i).getPass() });
							}
						}
					} else {
						JOptionPane.showMessageDialog(null, "Vui lòng nhập số tài khoản hoặc số thẻ");
					}
				} else if (output == JOptionPane.NO_OPTION) {
				}

			}

			if (e.getSource() == xoa) {
				if (output == JOptionPane.YES_OPTION) {
					if (khachHangDAO.kiemTraKhachHangCoSoHuuThe(txtSoThe.getText(), txtSoTK.getText())) {
						JOptionPane.showMessageDialog(null,
								"Thẻ ATM hiện đang có khách hàng sở hữu, vui lòng xóa thẻ trong khách hàng trước khi xóa thẻ");
					} else {
						if (!txtSoThe.getText().equals("") && txtSoTK.getText().equals("")) {
							if (theAtmDAO.deleteTheATMTheoSoThe(txtSoThe.getText())) {
								JOptionPane.showMessageDialog(null, "Xóa thành công");
								tableModel.setRowCount(0);
								showALL();
							} else {
								JOptionPane.showMessageDialog(null, "Nhập sai số thẻ ATM");
							}
						} else if (txtSoThe.getText().equals("") && !txtSoTK.getText().equals("")) {
							if (theAtmDAO.deleteTheATMTheoSoTK(txtSoTK.getText())) {
								JOptionPane.showMessageDialog(null, "Xóa thành công");
								tableModel.setRowCount(0);
								showALL();
							} else {
								JOptionPane.showMessageDialog(null, "Nhập sai số tài khoản");
							}
						} else {
							JOptionPane.showMessageDialog(null, "Không để trống 2 ô hoặc nhập cả 2 ô");
						}
					}
				} else if (output == JOptionPane.NO_OPTION) {
				}

			}
		}
	};

	public JPanel quanLyThe() {
		theAtmDAO = new TheAtmDAO();
		khachHangDAO = new KhachHangDAO();
		pnQuanLyTheATM = new JPanel();
		pnQuanLyTheATM.setLayout(new BoxLayout(pnQuanLyTheATM, BoxLayout.Y_AXIS));

		// Tiêu đề
		title = new JLabel("Quản lý thẻ ATM");
		title.setFont(new Font("Times New Roman", Font.BOLD, 30));
		title.setForeground(Color.RED);
		pnQuanLyTheATM.add(title);

		// Phần nhập thông tin thẻ
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

		// Các nút chức năng
		pnButton = new JPanel();
		them = new JButton("Thêm thẻ ATM");
		hienThi = new JButton("Hiển thị danh sách thẻ ATM");
		tim = new JButton("Tìm thẻ");
		xoa = new JButton("Xóa thẻ ATM");
		them.addActionListener(actionListener);
		hienThi.addActionListener(actionListener);
		tim.addActionListener(actionListener);
		xoa.addActionListener(actionListener);

		pnButton.add(them);
		pnButton.add(hienThi);
		pnButton.add(tim);
		pnButton.add(xoa);
		pnQuanLyTheATM.add(pnButton);

		// Bảng danh sách thẻ ATM
		border = BorderFactory.createLineBorder(Color.BLUE, 3, true);
		titledBorder = new TitledBorder(border, "Danh sách thông tin khách hàng");
		tableModel = new DefaultTableModel();
		tableModel.addColumn("Số thẻ ATM");
		tableModel.addColumn("Số tài khoản");
		tableModel.addColumn("Mật khẩu");

		table = new JTable(tableModel);
//		table.getTableHeader().setReorderingAllowed(false);
		table.setDefaultEditor(Object.class, null);
		showALL();

		JScrollPane jScrollPane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		jScrollPane.setBorder(titledBorder);
		pnQuanLyTheATM.add(jScrollPane);
		return pnQuanLyTheATM;

	}
	
	/**
	 * hiển thị table
	 */
	public void showALL() {
		ArrayList<TheATM> myList = new ArrayList<>();
		myList = theAtmDAO.showAllTheATM();
		for (int i = 0; i < myList.size(); i++) {
			tableModel.addRow(
					new String[] { myList.get(i).getSoTheATM(), myList.get(i).getSoTK(), myList.get(i).getPass() });
		}
	}

	/**
	 * kiểm tra nhập các JTextField
	 * @return
	 */
	public boolean kiemTra() {
		boolean kiemTra = true;
		String pantterSoThe = "[0-9]{16}";
		String pantterSoTK = "[0-9]{13}";
		if (!txtSoThe.getText().matches(pantterSoThe)) {
			kiemTra = false;
		}
		if (!txtSoTK.getText().matches(pantterSoTK)) {
			kiemTra = false;
		}
		return kiemTra;
	}

	/**
	 * Sắp xếp các lable
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
