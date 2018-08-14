package quanlytruonghoc.control;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import quanlytruonghoc.entity.Lop;
import quanlytruonghoc.entity.SinhVien;
import quanlytruonghoc.model.LopDao;
import quanlytruonghoc.model.SinhVienDao;

public class QuanLyLopHoc extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	JPanel headerPanel, menuPanel, centerPanel, lopPanel, cardPanel, timKiemLopPanel;
	JButton lopButton;
	CardLayout card, card1, card2, card3, card4, card5, card6;
	ArrayList<String> listNamHoc, listNamHoc1, listTenLop, listMaLop, listTenMon, listTenMonHoc, listMaSv, listMaSv1;
	String theoNam, theoLop, maLop, theoMaLop;
	Font font;
	Border border;
	LopDao lopDao;
	ArrayList<Lop> listSvTheoLop, listLop, listDsLop;
	JTextField maLopField, tenLopField, namHocField;
	JButton themLopButton, suaLopButton, xoaLopButton, xemDsButton, xemDsButton1, lamMoiLopButton, timkiemLopButton,
			xacNhanButton, troVeButton, timKiemButton;
	JTable lopTable, lopTable1;
	JPanel lopBang, lopMenu, lopNhap, lopLop, timKiemBang;
	DefaultTableModel lopDtm, lopDtm1, timLopDtm;
	JComboBox<String> locTheoNam, locTheoLop, timTheoNam, timTheoLop;
	Container conn;
	SinhVienDao sinhVienDao;
	QuanLySinhVien quanLySinhVien;

	public QuanLyLopHoc() {
		lopDao = new LopDao();
		sinhVienDao = new SinhVienDao();
		quanLySinhVien = new QuanLySinhVien();

		// Tiêu đề trang quản lý lớp
		JLabel lopLabel = new JLabel("Quản lý lớp học");
		lopLabel.setIcon(new ImageIcon("icon\\Buddypress-icon.png"));
		Font font4 = new Font("Arial", Font.BOLD | Font.ITALIC, 40);
		lopLabel.setFont(font4);
		lopLabel.setAlignmentX(CENTER_ALIGNMENT);

		// Phần nhập bảng danh sách sinh viên
		JPanel lopKhu2 = new JPanel();
		JPanel lopXemDS = new JPanel();
		lopKhu2.add(lopXemDS);
		lopXemDS.setLayout(new BoxLayout(lopXemDS, BoxLayout.Y_AXIS));
		JLabel label = new JLabel("Danh sách sinh viên");
		label.setAlignmentX(CENTER_ALIGNMENT);
		lopXemDS.add(label);
		Font lbfont = new Font("Arial", Font.BOLD | Font.ITALIC, 18);
		label.setFont(lbfont);

		// Thực hiện nút chọn đến combox năm học
		JPanel panel = new JPanel();
		lopXemDS.add(panel);
		Font font5 = new Font("Arial", Font.BOLD | Font.ITALIC, 16);
		label.setFont(font5);
		JLabel label2 = new JLabel("Lọc theo năm học:");
		panel.add(label2);
		label2.setFont(font5);

		locTheoNam = new JComboBox<>();
		panel.add(locTheoNam);
		locTheoNam.setPreferredSize(new Dimension(150, 25));
		locTheoNam.addItem("Năm học");

		// Thực hiện nút chọn đến combox lớp học
		JPanel panel1 = new JPanel();
		lopXemDS.add(panel1);
		JLabel label3 = new JLabel("Lọc theo lớp học: ");
		panel1.add(label3);
		label3.setFont(font5);

		locTheoLop = new JComboBox<>();
		panel1.add(locTheoLop);
		locTheoLop.setPreferredSize(new Dimension(150, 25));
		locTheoLop.addItem("Lớp");

		// Thực hiện nút xem danh sách
		xemDsButton = new JButton("Xem danh sách");
		xemDsButton.setIcon(new ImageIcon("icon\\Apps-Aegisub-icon (6).png"));
		font = new Font("Arial", Font.BOLD | Font.ITALIC, 17);
		xemDsButton.setAlignmentX(CENTER_ALIGNMENT);
		xemDsButton.setFont(font);
		lopXemDS.add(xemDsButton);
		Border borderLop1 = BorderFactory.createLineBorder(Color.BLACK);
		lopXemDS.setPreferredSize(new Dimension(450, 200));
		lopXemDS.setBorder(borderLop1);

		// Lọc các năm học trùng nhau
		listNamHoc = new ArrayList<String>();
		listNamHoc = lopDao.getAllNamHoc();
		Set<String> set = new HashSet<String>(listNamHoc);
		listNamHoc = new ArrayList<String>(set);

		// Chạy sự kiện theo để lấy ra tất cả năm học và lấy lớp học từ năm học
		for (String listNam : listNamHoc) {
			locTheoNam.addItem(listNam);
		}
		locTheoNam.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					theoNam = locTheoNam.getSelectedItem().toString();
					locTheoLop.removeAllItems();
					listTenLop = lopDao.getAllTenLop(theoNam);
					for (int i = 0; i < listTenLop.size(); i++) {
						locTheoLop.addItem(listTenLop.get(i));
					}
				}
			}
		});
		locTheoLop.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					theoLop = locTheoLop.getSelectedItem().toString();
				}
			}
		});

		// Tạo phần nhập cho bảng quản lý lớp hoc(bảng 2)
		lopNhap = new JPanel();
		lopKhu2.add(lopNhap);
		lopNhap.setLayout(new BoxLayout(lopNhap, BoxLayout.Y_AXIS));
		JLabel tieuDeLop = new JLabel("Quản lý lớp học");
		tieuDeLop.setAlignmentX(CENTER_ALIGNMENT);
		tieuDeLop.setFont(lbfont);
		lopNhap.add(tieuDeLop);

		JPanel panel2 = new JPanel();
		lopNhap.add(panel2);

		JPanel lopPn1 = new JPanel();
		panel2.add(lopPn1);
		lopPn1.setLayout(new BoxLayout(lopPn1, BoxLayout.Y_AXIS));

		JLabel labelLop1 = new JLabel("Mã Lớp: ");
		JLabel labelLop2 = new JLabel("Tên lớp: ");
		JLabel labelLop3 = new JLabel("Năm học: ");
		labelLop1.setFont(font5);
		labelLop2.setFont(font5);
		labelLop3.setFont(font5);
		lopPn1.add(labelLop1);
		lopPn1.add(labelLop2);
		lopPn1.add(labelLop3);

		JPanel lopPn2 = new JPanel();
		panel2.add(lopPn2);
		lopPn2.setLayout(new BoxLayout(lopPn2, BoxLayout.Y_AXIS));
		maLopField = new JTextField(20);
		lopPn2.add(maLopField);
		tenLopField = new JTextField(20);
		lopPn2.add(tenLopField);
		namHocField = new JTextField(20);
		lopPn2.add(namHocField);

		// Tạo phần menu cho nút button thêm, sửa ,xóa, tìm kiếm cho bảng quản lý lớp
		// học
		lopMenu = new JPanel();
		lopNhap.add(lopMenu);
		JPanel lopPn3 = new JPanel();
		lopPn3.setLayout(new BoxLayout(lopPn3, BoxLayout.Y_AXIS));
		JPanel lopPn4 = new JPanel();
		lopPn3.add(lopPn4);
		JPanel lopPn5 = new JPanel();
		lopPn3.add(lopPn5);
		lopMenu.add(lopPn3);
		themLopButton = new JButton("Thêm");
		themLopButton.setIcon(new ImageIcon("icon\\add-icon.png"));
		themLopButton.setFont(font);
		lopPn4.add(themLopButton);
		suaLopButton = new JButton("Sửa");
		suaLopButton.setIcon(new ImageIcon("icon\\update-icon.png"));
		suaLopButton.setFont(font);
		lopPn4.add(suaLopButton);
		xoaLopButton = new JButton("Xóa");
		xoaLopButton.setIcon(new ImageIcon("icon\\delete-icon.png"));
		xoaLopButton.setFont(font);
		lopPn4.add(xoaLopButton);
		lamMoiLopButton = new JButton("Làm mới");
		lamMoiLopButton.setIcon(new ImageIcon("icon\\Actions-edit-redo-icon.png"));
		lamMoiLopButton.setFont(font);
		lopPn4.add(lamMoiLopButton);
		timkiemLopButton = new JButton("Tìm kiếm");
		timkiemLopButton.setIcon(new ImageIcon("icon\\Search-icon (2).png"));
		timkiemLopButton.setFont(font);
		lopPn5.add(timkiemLopButton);
		xemDsButton1 = new JButton("Xem danh sách");
		xemDsButton1.setIcon(new ImageIcon("icon\\Apps-Aegisub-icon (6).png"));
		xemDsButton1.setFont(font);
		lopPn5.add(xemDsButton1);
		lopNhap.setPreferredSize(new Dimension(450, 200));
		lopNhap.setBorder(borderLop1);

		// Tạo bảng table cho phần hiển thị cho phần xem danh sách sinh viên của trang
		// quản lý lớp học
		lopBang = new JPanel();
		JPanel lopSv = new JPanel();

		lopDtm = new DefaultTableModel();
		lopDtm.addColumn("Mã lớp");
		lopDtm.addColumn("Tên lớp");
		lopDtm.addColumn("Mã sinh viên");
		lopDtm.addColumn("Tên sinh viên");
		lopDtm.addColumn("Năm học");
		lopTable = new JTable(lopDtm);
		lopTable.getTableHeader().setReorderingAllowed(false);
		lopTable.setDefaultEditor(Object.class, null);
		lopTable.setFont(font);
		lopTable.getTableHeader().setFont(font);
		JScrollPane scLop = new JScrollPane(lopTable, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scLop.setPreferredSize(new Dimension(1400, 450));

		Border borderLop = BorderFactory.createLineBorder(Color.RED, 2);
		TitledBorder borderTitleLop = BorderFactory.createTitledBorder(borderLop, "Danh sách sinh viên");
		lopSv.setBorder(borderTitleLop);
		lopSv.add(scLop);

		// Tạo bảng table cho phần hiển thị lớp học của trang quản lý lớp học
		lopLop = new JPanel();
		lopDtm1 = new DefaultTableModel();
		lopDtm1.addColumn("Mã lớp");
		lopDtm1.addColumn("Tên lớp");
		lopDtm1.addColumn("Năm học");

		lopTable1 = new JTable(lopDtm1);
		lopTable1.getTableHeader().setReorderingAllowed(false);
		lopTable1.setDefaultEditor(Object.class, null);
		lopTable1.setFont(font);
		lopTable1.getTableHeader().setFont(font);
		JScrollPane scLop1 = new JScrollPane(lopTable1, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scLop1.setPreferredSize(new Dimension(1400, 450));

		// Thực hiện nút chọn trên phần hiển thị
		lopTable1.addMouseListener(new MouseListener() {
			public void mouseReleased(MouseEvent e) {
			}

			public void mousePressed(MouseEvent e) {
			}

			public void mouseExited(MouseEvent e) {
			}

			public void mouseEntered(MouseEvent e) {
			}

			public void mouseClicked(MouseEvent e) {
				int row = lopTable1.getSelectedRow();
				String s = (String) lopTable1.getValueAt(row, 0);
				maLopField.setText(s);
				String s1 = (String) lopTable1.getValueAt(row, 1);
				tenLopField.setText(s1);
				String s2 = (String) lopTable1.getValueAt(row, 2);
				namHocField.setText(s2);
			}
		});

		Border borderLopLop = BorderFactory.createLineBorder(Color.RED, 2);
		TitledBorder titledLopLop = BorderFactory.createTitledBorder(borderLopLop, "Danh sách lớp học");
		lopLop.setBorder(titledLopLop);
		lopLop.add(scLop1);

		card2 = new CardLayout();
		lopBang.setLayout(card2);
		lopBang.add(lopSv, "bang 1");
		lopBang.add(lopLop, "bang 2");

		conn = getContentPane();
		conn.add(lopLabel);
		conn.add(lopKhu2);
		conn.add(lopBang);
		
		conn.setLayout(new BoxLayout(conn, BoxLayout.Y_AXIS));
		displayAllLop(listLop);

		// Trang tìm kiếm lớp học.*********

		timKiemLopPanel = new JPanel();
		// Tiêu đề trang tìm kiếm lớp
		JLabel timKiemLabel = new JLabel("Tìm kiếm lớp học");
		timKiemLabel.setIcon(new ImageIcon("icon\\Buddypress-icon.png"));
		font = new Font("Arial", Font.BOLD | Font.ITALIC, 40);
		timKiemLabel.setFont(font);
		timKiemLabel.setAlignmentX(CENTER_ALIGNMENT);
			// Phần nhập các thông tin tìm kiếm
		JPanel timKiemPn = new JPanel();
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
		timKiemPn.setPreferredSize(new Dimension(450, 100));
		timKiemPn.setBorder(borderLop1);

		// Tạo bảng table cho phần hiển thị cho trang tìm kiếm lớp
		timKiemBang = new JPanel();
		JPanel timKiemBang1 = new JPanel();

		timLopDtm = new DefaultTableModel();
		timLopDtm.addColumn("Mã lớp");
		timLopDtm.addColumn("Tên lớp");
		timLopDtm.addColumn("Năm học");

		JTable lopTable2 = new JTable(timLopDtm);
		lopTable2.getTableHeader().setReorderingAllowed(false);
		lopTable2.setDefaultEditor(Object.class, null);
		lopTable2.setFont(font);
		lopTable2.getTableHeader().setFont(font);
		JScrollPane scTimKiem = new JScrollPane(lopTable2, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scTimKiem.setPreferredSize(new Dimension(1400, 570));

		Border bordertimKiem = BorderFactory.createLineBorder(Color.RED, 2);
		TitledBorder titledTimKiem = BorderFactory.createTitledBorder(bordertimKiem, "Danh sách lớp học");
		timKiemBang1.setBorder(titledTimKiem);
		timKiemBang1.add(scTimKiem);

		card4 = new CardLayout();
		timKiemBang.setLayout(card4);
		timKiemBang.add(timKiemBang1, "bang 1");
		conn = getContentPane();
		conn.add(timKiemLabel);
		conn.add(timKiemPn);
		conn.add(timKiemBang);
		
		conn.setLayout(new BoxLayout(conn, BoxLayout.Y_AXIS));

	}

//	public void setAction() {
//		lopButton.addActionListener(this);
//		themLopButton.addActionListener(this);
//		suaLopButton.addActionListener(this);
//		xoaLopButton.addActionListener(this);
//		lamMoiLopButton.addActionListener(this);
//		xemDsButton.addActionListener(this);
//		xemDsButton1.addActionListener(this);
//		timkiemLopButton.addActionListener(this);
//		troVeButton.addActionListener(this);
//		timKiemButton.addActionListener(this);
//	}

	@Override
	public void actionPerformed(ActionEvent e) {
//		if (e.getSource() == lopButton) {
//			card.show(cardPanel, "lopPanel");
//		} else if (e.getSource() == troVeButton) {
//			card.show(cardPanel, "lopPanel");
//		} else if (e.getSource() == timkiemLopButton) {
//			card.show(cardPanel, "timKiemLopPanel");
//		} else if (e.getSource() == xemDsButton) {
//			card2.show(lopBang, "bang 1");
//		} else if (e.getSource() == xemDsButton1) {
//			card2.show(lopBang, "bang 2");
//		} else if (e.getSource() == timKiemButton) {
//			card4.show(timKiemBang, "bang 1");
//		}

		// Ket noi database cua bang quan ly lop

		// Tao gia tri moi cho bang quan ly lop
		Lop lop = new Lop();
		SinhVien sinhvien = new SinhVien();
		String idLop1 = maLopField.getText();
		String tenLop1 = tenLopField.getText();
		String namHoc1 = namHocField.getText();
		String idSv = quanLySinhVien.maSvField.getText();
		String tenSv = quanLySinhVien.tenSvField.getText();
		// Hiển thi danh sách trong bảng lớp lien ket voi database

		// Gán giá trị cho bảng hiển thị danh sách trong bảng quản lý lớp học

		lop.setIdLop(idLop1);
		lop.setTenLop(theoLop);
		sinhvien.setIdSinhVien(idSv);
		sinhvien.setHoTen(tenSv);
		lop.setSinhVien(sinhvien);
		lop.setNamHoc(theoNam);

		// Bảng danh sách lớp trong bảng quản lý lơp
		if (e.getSource() == xemDsButton) {
			if (locTheoNam.getSelectedItem().toString().equals("Năm học")) {
				JOptionPane.showMessageDialog(null, "Mời bạn chọn năm học!!");
			} else {
			listSvTheoLop = new ArrayList<Lop>();
			listSvTheoLop = lopDao.getAllSinhVienTheoNam(lop);
			displayAllSvTheoNam(listSvTheoLop);}
		}

		if (e.getSource() == xemDsButton1) {
			lopDtm1.setRowCount(0);
			displayAllLop(listLop);
		}

		// Thực hiện lệnh gọi đến nút button

		if (e.getSource() == themLopButton) { // Nút thêm mới lớp học
			// Bắt lỗi các trường hợp trong nhập văn bản
			if (idLop1.length() == 0) {
				JOptionPane.showMessageDialog(null, "Mã lớp không đươc để trống !");
			} else if (!idLop1.matches("\\w{8}")) {
				JOptionPane.showMessageDialog(null, "Mã lớp không được nhập đúng.\n Vd: ftse1801 !");
			} else if (tenLop1.length() == 0) {
				JOptionPane.showMessageDialog(null, "Tên lớp không đươc để trống !");
			} else if (!tenLop1.matches("\\d{4}")) {
				JOptionPane.showMessageDialog(null, "Tên lớp chỉ được nhập số và phải đủ 4 chữ số. \n Vd: 1801 !");
			} else if (namHoc1.length() == 0) {
				JOptionPane.showMessageDialog(null, "Năm  học không được để trống !");
			} else if (!namHoc1.matches("\\d{4}")) {
				JOptionPane.showMessageDialog(null, "Năm học chỉ được nhập số và phải đủ 4 chữ số \n Vd: 2018 !");
			} else {
				int output = JOptionPane.showConfirmDialog(null, "Bạn có muốn thêm", "Thêm Lớp",
						JOptionPane.YES_NO_OPTION);

				if (output == JOptionPane.YES_OPTION) {
					if (lopDao.addLop̣̣̣(lop)) {
						JOptionPane.showMessageDialog(null, "Thêm thành công!!");
						lopDtm1.setRowCount(0);
						displayAllLop(listLop);
					}
				} else if (output == JOptionPane.NO_OPTION) {
					JOptionPane.showMessageDialog(null, " Thêm thất bại!!");
				}
			}
		} else if (e.getSource() == suaLopButton) { // Nút sửa lớp học
			// Bắt lỗi các trường hợp trong nhập văn bản
			if (tenLop1.length() == 0) {
				JOptionPane.showMessageDialog(null, "Tên lớp không đươc để trống !");
			} else if (!tenLop1.matches("\\d{4}")) {
				JOptionPane.showMessageDialog(null, "Tên lớp chỉ được nhập số và phải đủ 4 chữ số. \n Vd: 1801 !");
			} else if (namHoc1.length() == 0) {
				JOptionPane.showMessageDialog(null, "Năm  học không được để trống !");
			} else if (!namHoc1.matches("\\d{4}")) {
				JOptionPane.showMessageDialog(null, "Năm học chỉ được nhập số và phải đủ 4 chữ số \n Vd: 2018 !");
			} else {
				int output = JOptionPane.showConfirmDialog(null, "Bạn có muốn sửa", "Sửa Lớp",
						JOptionPane.YES_NO_OPTION);
				if (output == JOptionPane.YES_OPTION) {
					if (lopDao.updateLop(lop)) {
						JOptionPane.showMessageDialog(null, "Sửa thành công!!");
						lopDtm1.setRowCount(0);
						displayAllLop(listLop);
					}
				} else if (output == JOptionPane.NO_OPTION) {
					JOptionPane.showMessageDialog(null, "Sửa thất bại!!");
				}
			}
		} else if (e.getSource() == xoaLopButton) { // Nút xóa lớp học
			int output = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa", "Xóa Lớp", JOptionPane.YES_NO_OPTION);

			if (output == JOptionPane.YES_OPTION) {
				if (lopDao.deletelSinhVien(lop)) {
					JOptionPane.showMessageDialog(null, "Xoa thành công!!");
					lopDtm1.setRowCount(0);
					displayAllLop(listLop);
				}
			} else if (output == JOptionPane.NO_OPTION) {
				JOptionPane.showMessageDialog(null, "Xóa thất bại!!");
			}
		} else if (e.getSource() == timkiemLopButton) { // Nút tìm kiếm lớp học
			timLopDtm.setRowCount(0);
			listLop = new ArrayList<Lop>();
			listLop = lopDao.getAllLop();
			for (Lop lop1 : listLop) {
				timLopDtm.addRow(new String[] { lop1.getIdLop(), lop1.getTenLop(), lop1.getNamHoc() });
			}
		} else { // Nút làm mới
			maLopField.setText("");
			tenLopField.setText("");
			namHocField.setText("");
		}

		// Nút button đến trang tìm kiếm lớp học***********************
		if (e.getSource() == timKiemButton) {
			// Set gia tri combox theo lop va nam hoc
			lop.setIdLop(idLop1);
			lop.setTenLop(theoLop);
			lop.setNamHoc(theoNam);
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
	// Hiển thị danh sách tất cả các lớp

	public void displayAllLop(ArrayList<Lop> listLop) {
		listLop = new ArrayList<Lop>();
		listLop = lopDao.getAllLop();
		for (Lop lop : listLop) {
			lopDtm1.addRow(new String[] { lop.getIdLop(), lop.getTenLop(), lop.getNamHoc() });
		}
	}

	// Hiển thị danh sách sinh viên theo năm học và lớp học

	public void displayAllSvTheoNam(ArrayList<Lop> listSvTheoLop) {
		for (Lop lop1 : listSvTheoLop) {
			lopDtm.addRow(new String[] { lop1.getIdLop(), lop1.getTenLop(), lop1.getSinhVien().getIdSinhVien(),
					lop1.getSinhVien().getHoTen(), lop1.getNamHoc() });
		}
	}
}
