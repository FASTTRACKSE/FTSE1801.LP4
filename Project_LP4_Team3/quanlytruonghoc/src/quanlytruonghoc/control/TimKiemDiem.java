package quanlytruonghoc.control;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

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

import quanlytruonghoc.entity.Diem;
import quanlytruonghoc.entity.DiemSinhVien;
import quanlytruonghoc.entity.Lop;
import quanlytruonghoc.model.DiemDao;
/**
 * TimKiemDiem Class
 * @author CongMT
 *
 */
public class TimKiemDiem extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	ArrayList<String> listMaSv1;
	String theoNam, theoLop;
	Font font;
	DiemDao diemDao;
	JButton quayLaiDiemBt, timKiemDiemBt;
	JTable diemTable1;
	JPanel timKiemDiemBang, timKiemDiemPn;
	DefaultTableModel timDiemDtm;
	JComboBox<String> timTheoMaSv;
	Container conn;
	ArrayList<Lop> listLop;

	public TimKiemDiem() {
		diemDao = new DiemDao();
		// Tiêu đề trang tìm kiếm lớp
		JLabel timKiemDiemLabel = new JLabel("Tìm kiếm điểm");
		timKiemDiemLabel.setIcon(new ImageIcon("icon\\Delicious-icon.png"));
		font = new Font("Arial", Font.BOLD | Font.ITALIC, 40);
		timKiemDiemLabel.setFont(font);
		timKiemDiemLabel.setAlignmentX(CENTER_ALIGNMENT);

		// Phần nhập các thông tin tìm kiếm
		timKiemDiemPn = new JPanel();
		timKiemDiemPn.setLayout(new BoxLayout(timKiemDiemPn, BoxLayout.Y_AXIS));
		JPanel nhapDiempn = new JPanel();
		timKiemDiemPn.add(nhapDiempn);

		// Thực hiện nút chọn đến combox mã môn học
		font = new Font("Arial", Font.BOLD | Font.ITALIC, 20);

		JLabel labelMaSv = new JLabel("Tìm theo mã sinh viên:");
		labelMaSv.setFont(font);
		nhapDiempn.add(labelMaSv);

		timTheoMaSv = new JComboBox<>();
		nhapDiempn.add(timTheoMaSv);
		timTheoMaSv.setPreferredSize(new Dimension(150, 25));
		timTheoMaSv.addItem("Nhấn chọn");

		// Lọc các năm học trùng nhau
		listMaSv1 = new ArrayList<String>();
		listMaSv1 = diemDao.getAllMaSv();
		Set<String> timMaSv = new HashSet<String>(listMaSv1);
		listMaSv1 = new ArrayList<String>(timMaSv);
		for (String listMasv : listMaSv1) {
			timTheoMaSv.addItem(listMasv);
		}

		// Tạo button

		JPanel timKiemDiemBton = new JPanel();
		timKiemDiemPn.add(timKiemDiemBton);
		JPanel timKiemDiem = new JPanel();
		timKiemDiemBton.add(timKiemDiem);

		timKiemDiemBt = new JButton("Tìm kiếm");
		timKiemDiemBt.setIcon(new ImageIcon("icon\\Search-icon (2).png"));
		timKiemDiemBt.setFont(font);
		timKiemDiem.add(timKiemDiemBt);
		quayLaiDiemBt = new JButton("Quay lại");
		quayLaiDiemBt.setIcon(new ImageIcon("icon\\User-Interface-Login-icon.png"));
		quayLaiDiemBt.setFont(font);
		timKiemDiem.add(quayLaiDiemBt);
		Border borderLop1 = BorderFactory.createLineBorder(Color.BLACK);
		timKiemDiemPn.setPreferredSize(new Dimension(450, 100));
		timKiemDiemPn.setBorder(borderLop1);

		// Tạo bảng cho trang tìm kiếm điểm
		timKiemDiemBang = new JPanel();

		font = new Font("Arial", Font.BOLD | Font.ITALIC, 16);
		timDiemDtm = new DefaultTableModel();
		timDiemDtm.addColumn("Mã sinh viên");
		timDiemDtm.addColumn("Môn JaVa");
		timDiemDtm.addColumn("Môn English");
		timDiemDtm.addColumn("Môn CSS");
		timDiemDtm.addColumn("Môn HTML");
		diemTable1 = new JTable(timDiemDtm);
		diemTable1.getTableHeader().setReorderingAllowed(false);
		diemTable1.setDefaultEditor(Object.class, null);
		diemTable1.setFont(font);
		diemTable1.getTableHeader().setFont(font);
		JScrollPane scTimDiem = new JScrollPane(diemTable1, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scTimDiem.setPreferredSize(new Dimension(1400, 570));
		ArrayList<Diem> listDiem = new ArrayList<Diem>();
		timDiemDtm.setRowCount(0);

		// Get diem by ID Sinh vien
		listDiem = diemDao.getDiem();

		// add listDiem to gird

		Map<String, List<Diem>> listDiemObject = listDiem.stream().collect(Collectors.groupingBy(Diem::getIdSinhVien));
		List<DiemSinhVien> listDiemSinhVien = new ArrayList<>();
		for (List<Diem> lstDiem : listDiemObject.values()) {
			double diemJava = 0;
			double diemHTML = 0;
			double diemCSS = 0;
			double diemEnglish = 0;
			String idSinhVien = lstDiem.get(0).getIdSinhVien();

			for (Diem diem : lstDiem) {
				switch (diem.getIdMonHoc()) {
				case "MH001":
					diemJava = diem.getDiemThi();
					break;
				case "MH002":
					diemEnglish = diem.getDiemThi();
					break;
				case "MH003":
					diemCSS = diem.getDiemThi();
					break;
				case "MH004":
					diemHTML = diem.getDiemThi();
					break;

				default:
					break;
				}
			}
			DiemSinhVien diemSinhVien = new DiemSinhVien();
			diemSinhVien.setIdSinhVien(idSinhVien);
			diemSinhVien.setDiemJava(diemJava);
			diemSinhVien.setDiemHTML(diemHTML);
			diemSinhVien.setDiemCSS(diemCSS);
			diemSinhVien.setDiemEnglish(diemEnglish);

			listDiemSinhVien.add(diemSinhVien);
		}

		for (DiemSinhVien diemSinhVien : listDiemSinhVien) {
			timDiemDtm.addRow(new String[] { diemSinhVien.getIdSinhVien(), String.valueOf(diemSinhVien.getDiemJava()),
					String.valueOf(diemSinhVien.getDiemEnglish()), String.valueOf(diemSinhVien.getDiemCSS()),
					String.valueOf(diemSinhVien.getDiemHTML()) });
		}
		
		Border bordertimKiemDiem = BorderFactory.createLineBorder(Color.RED, 2);
		TitledBorder titledTimKiemDiem = BorderFactory.createTitledBorder(bordertimKiemDiem, "Danh sách điểm");
		timKiemDiemBang.setBorder(titledTimKiemDiem);
		timKiemDiemBang.add(scTimDiem);

		conn = getContentPane();
		conn.add(timKiemDiemLabel);
		conn.add(timKiemDiemPn);
		conn.add(timKiemDiemBang);

		conn.setLayout(new BoxLayout(conn, BoxLayout.Y_AXIS));
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {

		// Thực hiện lệnh gọi đến nút button tìm kiếm trong trang tìm kiếm điểm

		if (e.getSource() == timKiemDiemBt) {
			if (timTheoMaSv.getSelectedItem().toString().equals("Nhấn chọn")) {
				JOptionPane.showMessageDialog(null, " Mời bạn chọn mã sinh viên!!");
			} else {
				try {
					displayAllDiem1Sv();
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "Tìm thất bại!!");
				}
			}
		}
	}


	// Hiển thị điểm của 1 sinh viên
	public void displayAllDiem1Sv() {
		ArrayList<Diem> listDiem = new ArrayList<Diem>();
		timDiemDtm.setRowCount(0);

		// Get diem by ID Sinh vien
		listDiem = diemDao.showTableDiemTimKiem(timTheoMaSv.getSelectedItem().toString());

		// add listDiem to gird

		Map<String, List<Diem>> listDiemObject = listDiem.stream().collect(Collectors.groupingBy(Diem::getIdSinhVien));
		List<DiemSinhVien> listDiemSinhVien = new ArrayList<>();
		for (List<Diem> lstDiem : listDiemObject.values()) {
			double diemJava = 0;
			double diemHTML = 0;
			double diemCSS = 0;
			double diemEnglish = 0;
			String idSinhVien = lstDiem.get(0).getIdSinhVien();

			for (Diem diem : lstDiem) {
				switch (diem.getIdMonHoc()) {
				case "MH001":
					diemJava = diem.getDiemThi();
					break;
				case "MH002":
					diemEnglish = diem.getDiemThi();
					break;
				case "MH003":
					diemCSS = diem.getDiemThi();
					break;
				case "MH004":
					diemHTML = diem.getDiemThi();
					break;

				default:
					break;
				}
			}

			DiemSinhVien diemSinhVien = new DiemSinhVien();
			diemSinhVien.setIdSinhVien(idSinhVien);
			diemSinhVien.setDiemJava(diemJava);
			diemSinhVien.setDiemHTML(diemHTML);
			diemSinhVien.setDiemCSS(diemCSS);
			diemSinhVien.setDiemEnglish(diemEnglish);

			listDiemSinhVien.add(diemSinhVien);
		}

		for (DiemSinhVien diemSinhVien : listDiemSinhVien) {
			timDiemDtm.addRow(new String[] { diemSinhVien.getIdSinhVien(), String.valueOf(diemSinhVien.getDiemJava()),
					String.valueOf(diemSinhVien.getDiemEnglish()), String.valueOf(diemSinhVien.getDiemCSS()),
					String.valueOf(diemSinhVien.getDiemHTML()) });
		}

	}
}