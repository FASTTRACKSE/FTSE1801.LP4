package QLSinhVien.swing;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import quanlysv.moi.model.SinhVienDAO;
import quanlysv.moi.model.entity.SinhVien;

public class QLSinhVien extends JFrame implements ActionListener {
	SinhVienDAO sinhVienDAO;
	JButton moi,them, sua, xoa, thoat;
	JTextField txtMa, txtTen, txtTuoi;
	DefaultTableModel dm;
	JTable tb;

	public QLSinhVien() {
		super("Quản lý sinh viên");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		sinhVienDAO = new SinhVienDAO();
		JPanel pnFlow1 = new JPanel();
		pnFlow1.setLayout(new BoxLayout(pnFlow1, BoxLayout.Y_AXIS));
		JPanel pnFlow10 = new JPanel();
		JPanel pnFlow11 = new JPanel();
		JPanel pnFlow12 = new JPanel();
		JPanel pnFlow13 = new JPanel();

		pnFlow1.add(pnFlow10);
		pnFlow1.add(pnFlow11);
		pnFlow1.add(pnFlow12);
		pnFlow1.add(pnFlow13);

		getContentPane().setLayout(new FlowLayout());
		JLabel lblbang = new JLabel("Chương trình quảng lý sinh viên");
		add(lblbang);

		getContentPane().setLayout(new FlowLayout());
		JLabel lblMa = new JLabel("Nhập mã SV:");
		txtMa = new JTextField(20);
		add(lblMa);
		add(txtMa);

		getContentPane().setLayout(new FlowLayout());
		JLabel lblTen = new JLabel("Nhập tên SV:");
		txtTen = new JTextField(20);
		add(lblTen);
		add(txtTen);

		getContentPane().setLayout(new FlowLayout());
		JLabel lblTuoi = new JLabel("Nhập tuổi SV:");
		txtTuoi = new JTextField(20);
		add(lblTuoi);
		add(txtTuoi);

		pnFlow10.add(lblbang);
		pnFlow11.add(lblMa);
		pnFlow11.add(txtMa);
		pnFlow12.add(lblTen);
		pnFlow12.add(txtTen);
		pnFlow13.add(lblTuoi);
		pnFlow13.add(txtTuoi);

		JPanel pntable = new JPanel();
		JPanel pnbutton = new JPanel();
		
		moi = new JButton();
		them = new JButton();
		sua = new JButton();
		xoa = new JButton();
		thoat = new JButton();

		moi.setText("Mới");
		them.setText("Thêm");
		sua.setText("Sửa");
		xoa.setText("Xóa");
		thoat.setText("Thoát");

		tb = new JTable();
		JScrollPane spane = new JScrollPane(tb);
		pntable.add(spane);
		pnbutton.add(moi);
		pnbutton.add(them);
		pnbutton.add(sua);
		pnbutton.add(xoa);
		pnbutton.add(thoat);

		JPanel pnSouth = new JPanel();

		Border border = BorderFactory.createLineBorder(Color.RED);
		TitledBorder titledBorder = new TitledBorder(border, "Danh sách");

		dm = new DefaultTableModel();
		dm.addColumn("Mã SV");
		dm.addColumn("Tên SV");
		dm.addColumn("Tuổi SV");

		JTable tbl = new JTable(dm);
		JScrollPane sc = new JScrollPane(tbl, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
		sc.setBorder(titledBorder);
		pnSouth.add(sc);

		Container con = getContentPane();
		getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		con.add(pnFlow1);
		con.add(pnbutton);
		con.add(sc, pnSouth);

		ArrayList<SinhVien> listSV = sinhVienDAO.getAllSinhVien();
		for (SinhVien sinhVien : listSV) {
			dm.addRow(new String[] { sinhVien.getMaSinhVien(), sinhVien.getTenSinhVien(),
					String.valueOf(sinhVien.getTuoi()) });
		}
		setAction();

		setSize(400, 300);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public void setAction() {
		moi.addActionListener(this);
		them.addActionListener(this);
		sua.addActionListener(this);
		xoa.addActionListener(this);
		thoat.addActionListener(this);
	}

	public static void main(String[] args) {
		QLSinhVien qlsv = new QLSinhVien();
		qlsv.setSize(400, 300);
		qlsv.setLocationRelativeTo(null);
		qlsv.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == moi) {
			txtMa.setText("");
			txtTen.setText("");
			txtTuoi.setText("");
		}
		if (e.getSource() == them) {
			SinhVien sv = new SinhVien();
			sv.setMaSinhVien(txtMa.getText());
			sv.setTenSinhVien(txtTen.getText());
			sv.setTuoi(Integer.parseInt(txtTuoi.getText()));
			sinhVienDAO.addSinhVien(sv);
			ArrayList<SinhVien> listSV = sinhVienDAO.getAllSinhVien();
			for (SinhVien sinhVien : listSV) {
				dm.addRow(new String[] { sinhVien.getMaSinhVien(), sinhVien.getTenSinhVien(),
						String.valueOf(sinhVien.getTuoi()) });
			}
		}

		if (e.getSource() == sua) {
			SinhVien sv = new SinhVien();
			sv.setMaSinhVien(txtMa.getText());
			sv.setTenSinhVien(txtTen.getText());
			sv.setTuoi(Integer.parseInt(txtTuoi.getText()));
			sinhVienDAO.updateSV(sv);
			dm.setRowCount(0);
			ArrayList<SinhVien> listSV = sinhVienDAO.getAllSinhVien();
			for (SinhVien sinhVien : listSV) {
				dm.addRow(new String[] { sinhVien.getMaSinhVien(), sinhVien.getTenSinhVien(),
						String.valueOf(sinhVien.getTuoi()) });
			}

		}
		if (e.getSource() == xoa) {
			SinhVien sv = new SinhVien();
			sv.setMaSinhVien(txtMa.getText());
			
			sinhVienDAO.deleteSV(sv);
			dm.setRowCount(0);
			ArrayList<SinhVien> listSV = sinhVienDAO.getAllSinhVien();
			for (SinhVien sinhVien : listSV) {
				dm.addRow(new String[] { sinhVien.getMaSinhVien(), sinhVien.getTenSinhVien(),
						String.valueOf(sinhVien.getTuoi()) });
			}
		}

		if (e.getSource() == thoat) {
			System.exit(0);
			
		}
	}
}
