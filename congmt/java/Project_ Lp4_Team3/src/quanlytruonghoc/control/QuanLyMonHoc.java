package quanlytruonghoc.control;


import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
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

import quanlytruonghoc.entity.MonHoc;
import quanlytruonghoc.model.MonDao;
/**
 * QuanLyMonHoc Class
 * @author CongMT
 *
 */
public class QuanLyMonHoc extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	JPanel monNhap, monMenu, monBang;
	JButton monHocButton,themMonButton, suaMonButton, xoaMonButton, lamMoiMonButton, timkiemMonButton;
	Font font;
	Border border;
	MonDao monDao;
	ArrayList<MonHoc> listMonHoc;
	JTextField maMonField, tenMonField, soTinChiField, thoiLuongField;
	JTable monTable;
	DefaultTableModel monDtm;
	Container conn;
	
	public QuanLyMonHoc() {
		monDao = new MonDao();
		// Tieu de trang quan ly mon
		JLabel monLabel = new JLabel("Quản lý môn học");
		monLabel.setIcon(new ImageIcon("icon\\bookshelf-icon.png"));
		monLabel.setLayout(new BoxLayout(monLabel, BoxLayout.Y_AXIS));
		Font font2 = new Font("Arial", Font.BOLD | Font.ITALIC, 40);
		monLabel.setFont(font2);
		monLabel.setAlignmentX(CENTER_ALIGNMENT);

		
		monNhap = new JPanel();
		monNhap.setLayout(new BoxLayout(monNhap, BoxLayout.Y_AXIS));
		JPanel monPn1 = new JPanel();
		monNhap.add(monPn1);

		JPanel monPn2 = new JPanel();
		monPn1.add(monPn2);
		monPn2.setLayout(new BoxLayout(monPn2, BoxLayout.Y_AXIS));
		font = new Font("Arial", Font.BOLD | Font.ITALIC, 20);
		JLabel labelMon1 = new JLabel("Mã môn học: ");
		labelMon1.setFont(font);
		monPn2.add(labelMon1);
		JLabel labelMon2 = new JLabel("Tên môn học: ");
		labelMon2.setFont(font);
		monPn2.add(labelMon2);
		JLabel labelMon3 = new JLabel("Số tín chỉ: ");
		labelMon3.setFont(font);
		monPn2.add(labelMon3);
		JLabel labelMon4 = new JLabel("Thời lượng: ");
		labelMon4.setFont(font);
		monPn2.add(labelMon4);

		JPanel monPn3 = new JPanel();
		monPn1.add(monPn3);
		border = BorderFactory.createLineBorder(Color.BLACK);
		monPn3.setLayout(new BoxLayout(monPn3, BoxLayout.Y_AXIS));
		maMonField = new JTextField(20);
		maMonField.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(2, 2, 2, 2)));
		monPn3.add(maMonField);
		tenMonField = new JTextField(20);
		tenMonField.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(2, 2, 2, 2)));
		monPn3.add(tenMonField);
		soTinChiField = new JTextField(20);
		soTinChiField.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(2, 2, 2, 2)));
		monPn3.add(soTinChiField);
		thoiLuongField = new JTextField(20);
		thoiLuongField.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(2, 2, 2, 2)));
		monPn3.add(thoiLuongField);

		monMenu = new JPanel();
		monNhap.add(monMenu);
		JPanel monPn4 = new JPanel();
		monMenu.add(monPn4);

		themMonButton = new JButton("Thêm");
		themMonButton.setIcon(new ImageIcon("icon\\add-icon.png"));
		themMonButton.setFont(font);
		monPn4.add(themMonButton);
		suaMonButton = new JButton("Sửa");
		suaMonButton.setIcon(new ImageIcon("icon\\update-icon.png"));
		suaMonButton.setFont(font);
		monPn4.add(suaMonButton);
		xoaMonButton = new JButton("Xóa");
		xoaMonButton.setIcon(new ImageIcon("icon\\delete-icon.png"));
		xoaMonButton.setFont(font);
		monPn4.add(xoaMonButton);
		lamMoiMonButton = new JButton("Làm mới");
		lamMoiMonButton.setIcon(new ImageIcon("icon\\Actions-edit-redo-icon.png"));
		lamMoiMonButton.setFont(font);
		monPn4.add(lamMoiMonButton);
		timkiemMonButton = new JButton("Tìm kiếm");
		timkiemMonButton.setIcon(new ImageIcon("icon\\Search-icon (2).png"));
		timkiemMonButton.setFont(font);
		monPn4.add(timkiemMonButton);
		Border borderLop1 = BorderFactory.createLineBorder(Color.BLUE);
		monNhap.setPreferredSize(new Dimension(400, 210));
		monNhap.setBorder(borderLop1);
		
		// Tao table cho trang quan ly mon hoc
		monBang = new JPanel();
		font = new Font("Arial", Font.BOLD | Font.ITALIC, 16);
		monDtm = new DefaultTableModel();
		monDtm.addColumn("Mã môn học");
		monDtm.addColumn("Tên môn học");
		monDtm.addColumn("Số tín chỉ");
		monDtm.addColumn("Thời lượng");
		monTable = new JTable(monDtm);
		monTable.getTableHeader().setReorderingAllowed(false);
		monTable.setDefaultEditor(Object.class, null);
		monTable.setFont(font);
		monTable.getTableHeader().setFont(font);
		JScrollPane scMonhoc = new JScrollPane(monTable, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scMonhoc.setPreferredSize(new Dimension(1400, 450));
		monTable.addMouseListener(new MouseListener() {
			public void mouseReleased(MouseEvent e) {}
			public void mousePressed(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
			public void mouseEntered(MouseEvent e) {}
			public void mouseClicked(MouseEvent e) {
				int row = monTable.getSelectedRow();
				String s = (String) monTable.getValueAt(row, 0);
				maMonField.setText(s);
				String s1 = (String) monTable.getValueAt(row, 1);
				tenMonField.setText(s1);
				String s2 = (String) monTable.getValueAt(row, 2);
				soTinChiField.setText(s2);
				String s3 = (String) monTable.getValueAt(row, 3);
				thoiLuongField.setText(s3);
			}
		});

		Border borderMon = BorderFactory.createLineBorder(Color.RED, 2);
		TitledBorder borderTitleMon = BorderFactory.createTitledBorder(borderMon, "Danh sách môn học");
		monBang.setBorder(borderTitleMon);
		monBang.add(scMonhoc);
		
		conn = getContentPane();
		conn.add(monLabel);
		conn.add(monNhap);
		conn.add(monBang);
		conn.setLayout(new BoxLayout(conn, BoxLayout.Y_AXIS));
		displayAllMonHoc(listMonHoc);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		// Tao gia tri moi cho bảng môn học
		MonHoc monHoc = new MonHoc();
		String idMonHoc1 = maMonField.getText();
		String tenMonHoc1 = tenMonField.getText();
		String tinChi1 = soTinChiField.getText();
		String thoiLuong1 = thoiLuongField.getText();

		// Gan gia tri cho bang mon hoc
		monHoc.setIdMonHoc(idMonHoc1);
		monHoc.setTenMonHoc(tenMonHoc1);
		monHoc.setTinChi(tinChi1);
		monHoc.setThoiLuongHoc(thoiLuong1);
		List<MonHoc> listMonHocDB = monDao.showTableMonTimKiem(monHoc);
		// Thực hiện lệnh gọi đến nút button thêm , sửa , xóa, tìm kiếm đến trang quản lý môn học

		if (e.getSource() == themMonButton) {// Nút thêm môn học
			// Bắt lỗi các trường hợp trong nhập văn bản
			if (idMonHoc1.length() == 0) {
				JOptionPane.showMessageDialog(null, "Mã môn học không đươc để trống !");
			} else if (listMonHocDB.size()>0) {
				JOptionPane.showMessageDialog(null, "Mã môn học này đã có !");
			}else if (!idMonHoc1.matches("\\w{5}")) {
				JOptionPane.showMessageDialog(null, "Mã môn học không được nhập đúng.\n Vd: MH001 !");
			} else if (tenMonHoc1.length() == 0) {
				JOptionPane.showMessageDialog(null, "Tên môn học không đươc để trống !");
			} else if (tinChi1.length() == 0) {
				JOptionPane.showMessageDialog(null, "Tín chỉ không được để trống !");
			} else if (!tinChi1.matches("\\d{1}")) {
				JOptionPane.showMessageDialog(null, "Tín chỉ chỉ được nhập số và không quá 2 chữ số !");
			} else if (thoiLuong1.length() == 0) {
				JOptionPane.showMessageDialog(null, "Thời lượng học không được để trống !");
			} else if (!thoiLuong1.matches("\\d{2,3}")) {
				JOptionPane.showMessageDialog(null, "Thời lượng học chỉ được nhập số và không quá 3 chữ số !");
			} else {
				int output = JOptionPane.showConfirmDialog(null, "Bạn có muốn thêm", "Thêm Môn",
						JOptionPane.YES_NO_OPTION);

				if (output == JOptionPane.YES_OPTION) {
					if (monDao.addMoṇ(monHoc)) {
						JOptionPane.showMessageDialog(null, "Thêm thành công!!");
						monDtm.setRowCount(0);
						displayAllMonHoc(listMonHoc);
					} else {
						JOptionPane.showMessageDialog(null, "Thêm thất bại!!");
					}
				} else if (output == JOptionPane.NO_OPTION) {
					JOptionPane.showMessageDialog(null, "Mời bạn chọn lại!!");
				}
			}
		} else if (e.getSource() == suaMonButton) { // Nút sửa môn học
			// Bắt lỗi các trường hợp trong nhập văn bản
			if (tenMonHoc1.length() == 0) {
				JOptionPane.showMessageDialog(null, "Tên môn học không đươc để trống !");
			} else if (tinChi1.length() == 0) {
				JOptionPane.showMessageDialog(null, "Tín chỉ không được để trống !");
			} else if (!tinChi1.matches("\\d{1}")) {
				JOptionPane.showMessageDialog(null, "Tín chỉ chỉ được nhập số và không quá 2 chữ số !");
			} else if (thoiLuong1.length() == 0) {
				JOptionPane.showMessageDialog(null, "Thời lượng học không được để trống !");
			} else if (!thoiLuong1.matches("\\d{2,3}")) {
				JOptionPane.showMessageDialog(null, "Thời lượng học chỉ được nhập số và khống quá 3 chữ số !");
			} else {
				int output = JOptionPane.showConfirmDialog(null, "Bạn có muốn sửa", "Sửa Môn",
						JOptionPane.YES_NO_OPTION);

				if (output == JOptionPane.YES_OPTION) {
					if (monDao.updateMonHoc(monHoc)) {
						JOptionPane.showMessageDialog(null, "Sửa thành công!!");
						monDtm.setRowCount(0);
						displayAllMonHoc(listMonHoc);
					} else {
						JOptionPane.showMessageDialog(null, "Sửa thất bại!!");
					}
				} else if (output == JOptionPane.NO_OPTION) {
					JOptionPane.showMessageDialog(null, " Mời bạn chọn lại!!");
				}
			}
		} else if (e.getSource() == xoaMonButton) { // Nút xóa môn học
			int output = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa", "Xóa Môn", JOptionPane.YES_NO_OPTION);

			if (output == JOptionPane.YES_OPTION) {
				if (monDao.deletelMonHoc(monHoc)) {
					JOptionPane.showMessageDialog(null, "Xóa thành công!!");
					monDtm.setRowCount(0);
					displayAllMonHoc(listMonHoc);
				} else {
					JOptionPane.showMessageDialog(null, "Xóa thất bại!!");
				}
			} else if (output == JOptionPane.NO_OPTION) {
				JOptionPane.showMessageDialog(null, " Mời bạn chọn lại!!");
			}
		} else if (e.getSource() == timkiemMonButton) { // Nút tìm kiếm môn học
			monDtm.setRowCount(0);
			listMonHoc = new ArrayList<MonHoc>();
			listMonHoc = monDao.getAllMonHoc();
			for (MonHoc monHoc1 : listMonHoc) {
				monDtm.addRow(new String[] { monHoc1.getIdMonHoc(), monHoc1.getTenMonHoc(), monHoc1.getTinChi(),
						monHoc1.getThoiLuongHoc() });
			}

		}  else { // Nút làm mới
			maMonField.setText("");
			tenMonField.setText("");
			soTinChiField.setText("");
			thoiLuongField.setText("");
			monDtm.setRowCount(0);
			displayAllMonHoc(listMonHoc);
		}
	}

	// Hiển thị danh sách tất cả môn học
		public void displayAllMonHoc(ArrayList<MonHoc> listMonHoc) {
			listMonHoc = new ArrayList<MonHoc>();
			listMonHoc = monDao.getAllMonHoc();
			for (MonHoc monHoc : listMonHoc) {
				monDtm.addRow(new String[] { monHoc.getIdMonHoc(), monHoc.getTenMonHoc(), monHoc.getTinChi(),
						monHoc.getThoiLuongHoc() });
			}
		}
}
