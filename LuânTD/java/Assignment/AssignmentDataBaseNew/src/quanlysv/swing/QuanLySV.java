package quanlysv.swing;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
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

import quanlysv.moi.entity.Diem;
import quanlysv.moi.entity.SinhVien;
import quanlysv.moi.modal.SinhVienDAO;

/**
 * Chuong trinh quan ly sinh vien bang Swing
 * 
 * @author Luan
 *
 */
public class QuanLySV extends JFrame {

	private static final long serialVersionUID = 1L;
	JPanel jpTitle, jpNhap, jpButton;
	JLabel jlTitle;
	JTextField jtMaSV, jtTenSV, jtPass, jtMonHoc, jtDiem;
	JButton themSV, themDiem, moi, xoa, thoat, clear;
	JPanel jpDanhSach;
	Border border;
	TitledBorder titledBorder;
	JTable table;
	Container cont;
	DefaultTableModel defaultTableModel;
	SinhVienDAO sinhVienDAO;
	SinhVien sinhVien;

//	public boolean check() {
//		boolean kiemtra = true;
//		String kt1 = "[A-Z]{2}\\d{2}";
//		if (jtMaSV.getText().matches(kt1)) {
//
//		} else {
//			JOptionPane.showMessageDialog(null, "Nhap sai dinh dang");
//			jtMaSV.selectAll();
//			jtMaSV.requestFocus();
//		}
//		String kt2 = "([A-Z][a-z]* )*[A-Z][a-z]*";
//		if (jtTenSV.getText().matches(kt2)) {
//
//		} else {
//			JOptionPane.showMessageDialog(null, "Nhap sai dinh dang");
//			jtMaSV.selectAll();
//			jtMaSV.requestFocus();
//		}
//		String kt3 = "\\w{6}";
//		if (jtPass.getText().matches(kt3)) {
//			
//		} else {
//			JOptionPane.showMessageDialog(null, "Nhap sai dinh dang");
//			jtMaSV.selectAll();
//			jtMaSV.requestFocus();
//		}
//
//		return kiemtra;
//
//	}

	/**
	 * Su kien cac button
	 */
	ActionListener actionListener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton button = (JButton) e.getSource();
			String maSV, tenSV, pass, monHoc;
			double diem = 0.0;
			maSV = jtMaSV.getText();
			tenSV = jtTenSV.getText();
			pass = jtPass.getText();
			monHoc = jtMonHoc.getText();
			try {
				diem = Double.parseDouble(jtDiem.getText());
			} catch (Exception e2) {
				System.out.println("Nhap sai");
			}

			SinhVien sinhVien = new SinhVien();
			sinhVien.setMaSV(maSV);
			sinhVien.setTenSv(tenSV);
			sinhVien.setPass(pass);
			Diem diem2 = new Diem();
			diem2.setMonHoc(monHoc);
			diem2.setDiem(diem);
			sinhVien.setDiem(diem2);
			if (button == themSV) {
				if (sinhVienDAO.addSinhVien(sinhVien)) {
					JOptionPane.showMessageDialog(null, "Them thanh cong");
					defaultTableModel.setRowCount(0);
					showTable();
				} else {
					JOptionPane.showMessageDialog(null, "Them that bai");
				}
			}
			if (button == themDiem) {
				if (sinhVienDAO.addDiemSV(sinhVien)) {
					JOptionPane.showMessageDialog(null, "Them thanh cong");
					defaultTableModel.setRowCount(0);
					showTable();
				} else {
					JOptionPane.showMessageDialog(null, "Them that bai");
				}
			}
			if (button == moi) {
				if (sinhVienDAO.updateSV(sinhVien)) {
					JOptionPane.showMessageDialog(null, "Sua thanh cong");
					defaultTableModel.setRowCount(0);
					showTable();
				} else {
					JOptionPane.showMessageDialog(null, "Sua that bai");
				}
			}
			if (button == xoa) {
				sinhVienDAO.deleteDiemSV(sinhVien);
				if (sinhVienDAO.deleteSV(sinhVien)) {
					JOptionPane.showMessageDialog(null, "Xoa thanh cong");
					defaultTableModel.setRowCount(0);
					showTable();
				} else {
					JOptionPane.showMessageDialog(null, "Xoa that bai");
				}
			}
			if (button == clear) {
				jtMaSV.setText("");
				jtTenSV.setText("");
				jtPass.setText("");
				jtMonHoc.setText("");
				jtDiem.setText("");
			}
			if (button == thoat) {
				System.exit(0);
			}

		}
	};

	/**
	 * Phan viet chuong trinh
	 */
	public QuanLySV() {

		super("Quản lý sinh viên - Oracle");

		sinhVienDAO = new SinhVienDAO();
		sinhVien = new SinhVien();

		jpTitle = new JPanel();
		jlTitle = new JLabel("Chương trình quản lý sinh viên");
		jpTitle.add(jlTitle);

		jpNhap = new JPanel();
		jpNhap.setLayout(new GridBagLayout());
		jpNhap.setSize(new Dimension(400, 400));

		jtMaSV = new JTextField(15);
		jtTenSV = new JTextField(15);
		jtPass = new JTextField(15);
		jtMonHoc = new JTextField(15);
		jtDiem = new JTextField(15);

		addItem(jpNhap, new JLabel("Mã sinh viên: "), 0, 0, 1, 1, GridBagConstraints.EAST);
		addItem(jpNhap, new JLabel("Tên sinh viên: "), 0, 1, 1, 1, GridBagConstraints.EAST);
		addItem(jpNhap, new JLabel("Pass: "), 0, 2, 1, 1, GridBagConstraints.EAST);
		addItem(jpNhap, new JLabel("Môn học: "), 0, 3, 1, 1, GridBagConstraints.EAST);
		addItem(jpNhap, new JLabel("Điểm: "), 0, 4, 1, 1, GridBagConstraints.EAST);

		addItem(jpNhap, jtMaSV, 1, 0, 2, 1, GridBagConstraints.WEST);
		addItem(jpNhap, jtTenSV, 1, 1, 2, 1, GridBagConstraints.WEST);
		addItem(jpNhap, jtPass, 1, 2, 2, 1, GridBagConstraints.WEST);
		addItem(jpNhap, jtMonHoc, 1, 3, 2, 1, GridBagConstraints.WEST);
		addItem(jpNhap, jtDiem, 1, 4, 2, 1, GridBagConstraints.WEST);

		jpButton = new JPanel();
		themSV = new JButton("Thêm SV");
		themDiem = new JButton("Thêm Diểm");
		moi = new JButton("Mới");
		xoa = new JButton("Xóa");
		thoat = new JButton("Thoát");
		clear = new JButton("làm mới");
		jpButton.add(themSV);
		themSV.addActionListener(actionListener);
		jpButton.add(themDiem);
		themDiem.addActionListener(actionListener);
		jpButton.add(moi);
		moi.addActionListener(actionListener);
		jpButton.add(xoa);
		xoa.addActionListener(actionListener);
		jpButton.add(clear);
		clear.addActionListener(actionListener);
		jpButton.add(thoat);
		thoat.addActionListener(actionListener);

		jpDanhSach = new JPanel();
		border = BorderFactory.createLineBorder(Color.BLACK, 2, true);
		titledBorder = new TitledBorder(border, "Danh sách");
		defaultTableModel = new DefaultTableModel();
		defaultTableModel.addColumn("Mã");
		defaultTableModel.addColumn("Tên");
		defaultTableModel.addColumn("Pass");
		defaultTableModel.addColumn("Môn học");
		defaultTableModel.addColumn("Điểm");

		showTable();

		table = new JTable(defaultTableModel);
		JScrollPane jScrollPane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		jScrollPane.setBorder(titledBorder);

		cont = getContentPane();
		cont.setLayout(new BoxLayout(cont, BoxLayout.Y_AXIS));
		cont.add(jpTitle);
		cont.add(jpNhap);
		cont.add(jpButton);
		cont.add(jpDanhSach);
		cont.add(jScrollPane);
	}

	/**
	 * hien thi thong tin cac dong tren table
	 */
	public void showTable() {
		ArrayList<SinhVien> myList = new ArrayList<>();
		myList = sinhVienDAO.getAllSinhVien();
		for (int i = 0; i < myList.size(); i++) {
			defaultTableModel
					.addRow(new String[] { myList.get(i).getMaSV(), myList.get(i).getTenSv(), myList.get(i).getPass(),
							myList.get(i).getDiem().getMonHoc(), String.valueOf(myList.get(i).getDiem().getDiem()) });
		}
	}

	/**
	 * Chia cac o thong tin
	 * 
	 * @param p
	 *            panel
	 * @param c
	 *            Jcomponent
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

	/**
	 * Hien thi chuong trinh
	 */
	public void display() {
		setSize(400, 400);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		QuanLySV quanlySV = new QuanLySV();
		quanlySV.display();
	}

}
