package quanlytruonghoc.control;


import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import quanlytruonghoc.entity.Lop;
import quanlytruonghoc.model.LopDao;
/**
 * TimKiemLopHoc Class
 * @author CongMT
 *
 */
public class TimKiemLopHoc extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	
	ArrayList<String> listNamHoc, listTenLop;
	String theoNam, theoLop;
	Font font;
	LopDao lopDao;
	JButton troVeButton, timKiemButton;
	JTable lopTable2;
	JPanel timKiemBang,	timKiemPn;
	DefaultTableModel timLopDtm;
	JComboBox<String> timTheoNam, timTheoLop;
	Container conn;
	ArrayList<Lop> listLop;
	public TimKiemLopHoc() {
		lopDao = new LopDao();
		// Tiêu đề trang tìm kiếm lớp
		JLabel timKiemLabel = new JLabel("Tìm kiếm lớp học");
		timKiemLabel.setIcon(new ImageIcon("icon\\Buddypress-icon.png"));
		font = new Font("Arial", Font.BOLD | Font.ITALIC, 40);
		timKiemLabel.setFont(font);
		timKiemLabel.setAlignmentX(CENTER_ALIGNMENT);
		// Phần nhập các thông tin tìm kiếm
		timKiemPn = new JPanel();
		timKiemPn.setLayout(new BoxLayout(timKiemPn, BoxLayout.Y_AXIS));
		JPanel nhappn = new JPanel();
		timKiemPn.add(nhappn);
		nhappn.setLayout(new BoxLayout(nhappn, BoxLayout.X_AXIS));

		// Thực hiện nút chọn đến combox năm học
		JPanel panelTimKiemNam = new JPanel();
		nhappn.add(panelTimKiemNam);
		font = new Font("Arial", Font.BOLD | Font.ITALIC, 20);

		JLabel labelNam = new JLabel("Tìm theo năm học:");
		labelNam.setFont(font);
		panelTimKiemNam.add(labelNam);

		timTheoNam = new JComboBox<>();
		panelTimKiemNam.add(timTheoNam);
		timTheoNam.setPreferredSize(new Dimension(150, 25));
		timTheoNam.addItem("Năm học");

		// Thực hiện nút chọn đến combox lớp học
		JPanel panelTimKiemLop = new JPanel();
		nhappn.add(panelTimKiemLop);
		JLabel labelLop = new JLabel("Tìm theo lớp học: ");
		labelLop.setFont(font);
		panelTimKiemLop.add(labelLop);

		timTheoLop = new JComboBox<>();
		panelTimKiemLop.add(timTheoLop);
		timTheoLop.setPreferredSize(new Dimension(150, 25));
		timTheoLop.addItem("Lớp");

		// Lọc các năm học trùng nhau
		listNamHoc = new ArrayList<String>();
		listNamHoc = lopDao.getAllNamHoc();
		Set<String> setNam = new HashSet<String>(listNamHoc);
		listNamHoc = new ArrayList<String>(setNam);

		// Chạy sự kiện theo để lấy ra tất cả năm học và lấy lớp học từ năm học
		for (String listNam : listNamHoc) {
			timTheoNam.addItem(listNam);
		}

		timTheoNam.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					theoNam = timTheoNam.getSelectedItem().toString();
					timTheoLop.removeAllItems();
					listTenLop = lopDao.getAllTenLop(theoNam);
					for (int i = 0; i < listTenLop.size(); i++) {
						timTheoLop.addItem(listTenLop.get(i));
					}
				}
			}
		});

		timTheoLop.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					theoLop = timTheoLop.getSelectedItem().toString();
				}
			}
		});
		// Tạo button
		JPanel timKiemBt = new JPanel();
		timKiemPn.add(timKiemBt);
		JPanel timKiem = new JPanel();
		timKiemBt.add(timKiem);

		timKiemButton = new JButton("Tìm kiếm");
		timKiemButton.setIcon(new ImageIcon("icon\\Search-icon (2).png"));
		timKiemButton.setFont(font);
		timKiem.add(timKiemButton);
		troVeButton = new JButton("Quay lại");
		troVeButton.setIcon(new ImageIcon("icon\\User-Interface-Login-icon.png"));
		troVeButton.setFont(font);
		timKiem.add(troVeButton);
		Border borderLop1 = BorderFactory.createLineBorder(Color.BLACK);
		timKiemPn.setPreferredSize(new Dimension(450, 100));
		timKiemPn.setBorder(borderLop1);

		// Tạo bảng table cho phần hiển thị cho trang tìm kiếm lớp
		timKiemBang = new JPanel();
		
		timLopDtm = new DefaultTableModel();
		timLopDtm.addColumn("Mã lớp");
		timLopDtm.addColumn("Tên lớp");
		timLopDtm.addColumn("Năm học");

		lopTable2 = new JTable(timLopDtm);
		lopTable2.getTableHeader().setReorderingAllowed(false);
		lopTable2.setDefaultEditor(Object.class, null);
		lopTable2.setFont(font);
		lopTable2.getTableHeader().setFont(font);
		JScrollPane scTimKiem = new JScrollPane(lopTable2, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scTimKiem.setPreferredSize(new Dimension(1400, 570));
		timLopDtm.setRowCount(0);
		listLop = new ArrayList<Lop>();
		listLop = lopDao.getAllLop();
		for (Lop lop1 : listLop) {
			timLopDtm.addRow(new String[] { lop1.getIdLop(), lop1.getTenLop(), lop1.getNamHoc() });
		}

		Border bordertimKiem = BorderFactory.createLineBorder(Color.RED, 2);
		TitledBorder titledTimKiem = BorderFactory.createTitledBorder(bordertimKiem, "Danh sách lớp học");
		timKiemBang.setBorder(titledTimKiem);
		timKiemBang.add(scTimKiem);

		conn = getContentPane();
		conn.add(timKiemLabel);
		conn.add(timKiemPn);
		conn.add(timKiemBang);

		conn.setLayout(new BoxLayout(conn, BoxLayout.Y_AXIS));

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Lop lop = new Lop();
		lop.setTenLop(theoLop);
		lop.setNamHoc(theoNam);
		// Nút button đến trang tìm kiếm lớp học***********************
		if (e.getSource() == timKiemButton) {
			// Set gia tri combox theo lop va nam hoc
			
			if (timTheoNam.getSelectedItem().toString().equals("Năm học")) {
				JOptionPane.showMessageDialog(null, "Mời bạn chọn năm học!!");
			} else {
				try {
					timLopDtm.setRowCount(0);
					listLop = new ArrayList<Lop>();
					listLop = lopDao.showTableLopTimKiem(lop);
					for (Lop lop1 : listLop) {
						timLopDtm.addRow(new String[] { lop1.getIdLop(), lop1.getTenLop(), lop1.getNamHoc() });
					}
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Tìm thất bại!!");
				}

			}
		}

	}

}