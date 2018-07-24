import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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

import quanlysv.entity.Diem;
import quanlysv.entity.SinhVien;
import quanlysv.model.SinhVienDao;

public class ChuongTrinhQuanLySv extends JFrame implements ActionListener {
	JLabel maSv, lbTenSv, lbPass, lbMonHoc, lbDiem;
	JTextField maSinhVien, tenSinhVien, passSinhVien, monHoc, diem;
	JPanel pnMaSinhVien, pnTenSinhVien, pnPassSinhVien, pnMonHoc, pnDiem, pnBox, pnBox1, pnBox2;
	JButton themSv, updateSv, deletelSv, themDiemSv, updataDiemSv, deletelDiemSv, displayTheoTen, displayAll, thoat,
			taoMoi;
	Font font;
	JScrollPane sc;
	DefaultTableModel defaultTableModel;
	SinhVienDao sinhviendao;

	public ChuongTrinhQuanLySv() {
		super("Chuong trinh quan ly sinh vien");
		sinhviendao = new SinhVienDao();
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		getContentPane().setLayout(new FlowLayout());
		pnBox = new JPanel();
		pnBox.setLayout(new BoxLayout(pnBox, BoxLayout.Y_AXIS));
		JPanel pnTenChuongTrinh = new JPanel();
		JLabel hienThi = new JLabel("Chuong trinh quan ly sinh vien");
		font = new Font("Arial", Font.BOLD | Font.ITALIC, 25);
		hienThi.setFont(font);
		pnTenChuongTrinh.add(hienThi);
		// Mã sinh viên
		font = new Font("Arial", Font.BOLD | Font.ITALIC, 15);
		pnMaSinhVien = new JPanel();
		maSv = new JLabel("Mã sinh viên:");
		maSinhVien = new JTextField(20);
		Border border3 = BorderFactory.createLineBorder(Color.BLACK);
		maSinhVien.setBorder(
				BorderFactory.createCompoundBorder(border3, BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		maSv.setFont(font);
		pnMaSinhVien.add(maSv);
		pnMaSinhVien.add(maSinhVien);
		// Ten sinh vien
		pnTenSinhVien = new JPanel();
		lbTenSv = new JLabel("Tên sinh viên:");
		tenSinhVien = new JTextField(20);
		Border border2 = BorderFactory.createLineBorder(Color.BLACK);
		tenSinhVien.setBorder(
				BorderFactory.createCompoundBorder(border2, BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		lbTenSv.setFont(font);
		pnTenSinhVien.add(lbTenSv);
		pnTenSinhVien.add(tenSinhVien);
		// Pass sinh viên
		pnPassSinhVien = new JPanel();
		lbPass = new JLabel("Pass :");
		passSinhVien = new JTextField(20);
		Border border1 = BorderFactory.createLineBorder(Color.BLACK);
		passSinhVien.setBorder(
				BorderFactory.createCompoundBorder(border1, BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		lbPass.setFont(font);
		pnPassSinhVien.add(lbPass);
		pnPassSinhVien.add(passSinhVien);
		// Mon hoc
		pnMonHoc = new JPanel();
		lbMonHoc = new JLabel("Môn học :");
		monHoc = new JTextField(20);
		Border border4 = BorderFactory.createLineBorder(Color.BLACK);
		monHoc.setBorder(BorderFactory.createCompoundBorder(border4, BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		lbMonHoc.setFont(font);
		pnMonHoc.add(lbMonHoc);
		pnMonHoc.add(monHoc);
		// Diem sinh viên
		pnDiem = new JPanel();
		lbDiem = new JLabel("Điểm :");
		diem = new JTextField(20);
		Border border5 = BorderFactory.createLineBorder(Color.BLACK);
		diem.setBorder(BorderFactory.createCompoundBorder(border5, BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		lbDiem.setFont(font);
		pnDiem.add(lbDiem);
		pnDiem.add(diem);
		// Can chinh cac cot trong pnbox
		JPanel panel1 = new JPanel();
		panel1.setLayout(new GridBagLayout());
		addItem(panel1, maSv, 0, 0, 1, 1, GridBagConstraints.EAST);
		addItem(panel1, lbTenSv, 0, 1, 1, 1, GridBagConstraints.EAST);
		addItem(panel1, lbPass, 0, 2, 1, 1, GridBagConstraints.EAST);
		addItem(panel1, lbMonHoc, 0, 3, 1, 1, GridBagConstraints.EAST);
		addItem(panel1, lbDiem, 0, 4, 1, 1, GridBagConstraints.EAST);

		addItem(panel1, maSinhVien, 1, 0, 2, 1, GridBagConstraints.WEST);
		addItem(panel1, tenSinhVien, 1, 1, 1, 1, GridBagConstraints.WEST);
		addItem(panel1, passSinhVien, 1, 2, 2, 1, GridBagConstraints.WEST);
		addItem(panel1, monHoc, 1, 3, 2, 1, GridBagConstraints.WEST);
		addItem(panel1, diem, 1, 4, 2, 1, GridBagConstraints.WEST);
		// Gắn giá trị cho pnbox
		pnBox.add(panel1);
		// Tao button
		pnBox1 = new JPanel();
		font = new Font("Arial", Font.BOLD | Font.ITALIC, 15);
		themSv = new JButton("ThêmSV:");
		themSv.setFont(font);
		updateSv = new JButton("UpdateSV:");
		updateSv.setFont(font);
		themDiemSv = new JButton("Thêm Điểm:");
		themDiemSv.setFont(font);
		updataDiemSv = new JButton("UpdataDiemSv:");
		updataDiemSv.setFont(font);
		taoMoi = new JButton("TaoMoi:");
		taoMoi.setFont(font);
		// Gắn giá trị cho pnbox1
		pnBox1.setFont(font);
		pnBox1.add(themSv);
		pnBox1.add(updateSv);
		pnBox1.add(themDiemSv);
		pnBox1.add(updataDiemSv);
		pnBox1.add(taoMoi);
		// Tao pnBox2
		pnBox2 = new JPanel();
		font = new Font("Arial", Font.BOLD | Font.ITALIC, 15);
		deletelSv = new JButton("XóaSV:");
		deletelSv.setFont(font);
		deletelDiemSv = new JButton("deletelDiemSvSV:");
		deletelDiemSv.setFont(font);
		displayTheoTen = new JButton("displayTheoTen:");
		displayTheoTen.setFont(font);
		displayAll = new JButton("displayAll:");
		displayAll.setFont(font);
		thoat = new JButton("Thoát:");
		thoat.setFont(font);
		// Gắn giá trị cho pnbox2
		pnBox2.setFont(font);
		pnBox2.add(deletelSv);
		pnBox2.add(deletelDiemSv);
		pnBox2.add(displayTheoTen);
		pnBox2.add(displayAll);
		pnBox2.add(thoat);
		setAction();
		// Tao boder cho bang
		JPanel pnTable = new JPanel();
		Border border = BorderFactory.createLineBorder(Color.RED, 2, true);
		TitledBorder borderTitle = BorderFactory.createTitledBorder(border, "Danh sách");
		// Tao table
		defaultTableModel = new DefaultTableModel();
		font = new Font("Arial", Font.BOLD | Font.ITALIC, 15);
		defaultTableModel.addColumn("Mã Sinh Viên");
		defaultTableModel.addColumn("Tên Sinh Viên");
		defaultTableModel.addColumn("Pass");
		defaultTableModel.addColumn("Môn Học");
		defaultTableModel.addColumn("Điểm");
		ArrayList<SinhVien> listSinhVien = new ArrayList<SinhVien>();
		listSinhVien = sinhviendao.getAllSinhVien();
		displayAllSv(listSinhVien);
		// gan table vao khung
		JTable tbl = new JTable(defaultTableModel);
		sc = new JScrollPane(tbl, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		sc.setPreferredSize(new Dimension(750, 300));
		tbl.addMouseListener(new MouseListener() {
			public void mouseReleased(MouseEvent e) {
			}

			public void mousePressed(MouseEvent e) {
			}

			public void mouseExited(MouseEvent e) {
			}

			public void mouseEntered(MouseEvent e) {
			}

			public void mouseClicked(MouseEvent e) {
				int row = tbl.getSelectedRow();
				int col = tbl.getSelectedColumn();
				String s = (String) tbl.getValueAt(row, col);
				maSinhVien.setText(s);
				diem.setText(s);
			}
		});

		tbl.setFont(font);
		tbl.getTableHeader().setFont(font);

		pnTable.setBorder(borderTitle);
		pnTable.add(sc, BorderLayout.CENTER);
		// Gan gia tri chay chuong trinh
		Container con = getContentPane();
		con.setLayout(new BoxLayout(con, BoxLayout.Y_AXIS));
		con.add(pnTenChuongTrinh);
		con.add(pnBox);
		con.add(pnBox1);
		con.add(pnBox2);
		con.add(pnTable);

	}

	/**
	 * Hien thi danh sach tat ca sinh vien
	 */
	public void displayAllSv(ArrayList<SinhVien> listSinhVien) {
		for (SinhVien sinhvien : listSinhVien) {
			defaultTableModel.addRow(
					new String[] { sinhvien.getMaSinhVien(), sinhvien.getTenSinhVien(), sinhvien.getPassSinhVien(),
							sinhvien.getDiem().getMonHoc(), String.valueOf(sinhvien.getDiem().getDiem()) });
		}
	}

	private void addItem(JPanel p, JComponent c, int x, int y, int width, int height, int align) {
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
		setSize(800, 800);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public void setAction() {
		themSv.addActionListener(this);
		updateSv.addActionListener(this);
		themDiemSv.addActionListener(this);
		updataDiemSv.addActionListener(this);
		deletelSv.addActionListener(this);
		deletelDiemSv.addActionListener(this);
		displayTheoTen.addActionListener(this);
		displayAll.addActionListener(this);
		thoat.addActionListener(this);
		taoMoi.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton) e.getSource();
		SinhVien sinhvien = new SinhVien();
		Diem diem1;

		String maSv = maSinhVien.getText();
		String tenSv = tenSinhVien.getText();
		String pass = passSinhVien.getText();
		String monHoc1 = monHoc.getText();
		double diemSv;
		diemSv = Double.parseDouble(diem.getText());

		sinhvien.setMaSinhVien(maSv);
		sinhvien.setTenSinhVien(tenSv);
		sinhvien.setPassSinhVien(pass);
		diem1 = new Diem();
		diem1.setMonHoc(monHoc1);
		diem1.setDiem(diemSv);
		sinhvien.setDiem(diem1);

		if (button == themSv) {
			if (sinhviendao.addNewSinhVien(sinhvien)) {
				JOptionPane.showMessageDialog(null, "Thêm thành công!!");
				defaultTableModel.setRowCount(0);
			} else {
				JOptionPane.showMessageDialog(null, "Nhập sai định dạng. Thêm thất bại!!");
			}
		} else if (button == updateSv) {
			if (sinhviendao.updateSinhVien(sinhvien)) {
				JOptionPane.showMessageDialog(null, "Cập nhập thành công!!");
				defaultTableModel.setRowCount(0);
			} else {
				JOptionPane.showMessageDialog(null, "Nhập sai định dạng. Cập nhập thất bại!!");
			}
		} else if (button == themDiemSv) {
			if (sinhviendao.addDiemSinhVien(sinhvien)) {
				JOptionPane.showMessageDialog(null, "Thêm điểm thành công!!");
				defaultTableModel.setRowCount(0);
			} else {
				JOptionPane.showMessageDialog(null, "Nhập sai định dạng. Thêm điểm thất bại!!");
			}
		} else if (button == updataDiemSv) {
			if (sinhviendao.updateDiemSinhVien(sinhvien)) {
				JOptionPane.showMessageDialog(null, "Thêm điểm thành công!!");
				defaultTableModel.setRowCount(0);
			} else {
				JOptionPane.showMessageDialog(null, "Nhập sai định dạng. Thêm điểm thất bại!!");
			}
		} else if (button == deletelSv) {
			if (sinhviendao.deletelSinhVien(sinhvien)) {
				JOptionPane.showMessageDialog(null, "Xóa thành công!!");
				defaultTableModel.setRowCount(0);
			} else {
				JOptionPane.showMessageDialog(null, "Nhập sai định dạng. Xóa thất bại!!");
			}
		} else if (button == deletelDiemSv) {
			if (sinhviendao.deletelDiemSinhVien(sinhvien)) {
				JOptionPane.showMessageDialog(null, "Xóa điểm thành công!!");
				defaultTableModel.setRowCount(0);
			} else {
				JOptionPane.showMessageDialog(null, "Nhập sai định dạng. Xóa điểm thất bại!!");
			}
		} else if (button == displayTheoTen) {
			JOptionPane.showMessageDialog(null, "Hiển thị thành công!!");
			defaultTableModel.setRowCount(0);
			displayAllSv(sinhviendao.getAllSinhVienTheoTen(sinhvien));

		} else if (button == displayAll) {
			JOptionPane.showMessageDialog(null, "Hiển thị thành công!!");
			defaultTableModel.setRowCount(0);
			displayAllSv(sinhviendao.getAllSinhVien());

		} else if (button == taoMoi) {
			maSinhVien.setText("");
			tenSinhVien.setText("");
			passSinhVien.setText("");
			monHoc.setText("");
			diem.setText("");
		} else {
			setVisible(false);
			dispose();
		}
	}

	public static void main(String[] args) {
		ChuongTrinhQuanLySv quanlysinhvien = new ChuongTrinhQuanLySv();
		quanlysinhvien.display();
	}
}
