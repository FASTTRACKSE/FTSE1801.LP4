package quanlytruonghoc.control;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
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

import quanlytruonghoc.entity.Lop;
import quanlytruonghoc.entity.MonHoc;
import quanlytruonghoc.entity.Phuong;
import quanlytruonghoc.entity.SinhVien;
import quanlytruonghoc.model.LopDao;
import quanlytruonghoc.model.MonDao;
import quanlytruonghoc.model.SinhVienDao;
import quanlytruonghoc.model.ThongKeDao;

public class Menu extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	JPanel headerPanel, menuPanel, centerPanel, trangChuPanel, sinhVienPanel, lopPanel, monHocPanel, thongKePanel,
			cardPanel;
	JButton sinhVienButton, monHocButton, lopButton, thongKeButton, trangChuButton;
	CardLayout card, card1, card2;
	JLabel jLabel, jLabel1, jLabel2, jLabel3, jLabel4;
	SinhVienDao sinhVienDao;
	ArrayList<SinhVien> listSinhVien, listSinhVien1, listSinhVien2;
	ArrayList<Double> listDiem;
	ArrayList<String> listTp, listQuan, listXaPhuong, listNamHoc, listNamHoc1, listTenLop, listMaLop, listTenMonHoc;
	String tenTP, tenQuan, tenPhuong, theoNam, theoLop, maLop;
	Font font;
	Border border;
	JTextField maSvField, tenSvField, diaChiField, sdtField, emailField, timKiemField;
	JComboBox<String> tpComb, quanComb, phuongComb, lopComb;
	JButton themSvButton, suaSvButton, xoaSvButton, taoMoiSvButton, timkiemSvButton;
	JTable svTable;
	DefaultTableModel svDtm;
	LopDao lopDao;
	ArrayList<Lop> listSvTheoLop, listLop, listDsLop;
	JTextField maLopField, tenLopField, namHocField;
	JButton themLopButton, suaLopButton, xoaLopButton, xemDsButton, xemDsButton1, lamMoiLopButton, timkiemLopButton;
	JTable lopTable, lopTable1;
	JPanel lopBang;
	DefaultTableModel lopDtm, lopDtm1;
	JComboBox<String> locTheoNam, locTheoLop, namcomb2, namcomb1, lopcomb;
	MonDao monDao;
	ArrayList<MonHoc> listMonHoc;
	JLabel tieuDeMon, labelMon1,labelMon2,labelMon3,labelMon4;
	JPanel monNhap,monPn1,monPn2,monPn3,monMenu,monBang;
	JTextField maMonField, tenMonField, soTinChiField, thoiLuongField;
	JButton themMonButton, suaMonButton, xoaMonButton, lamMoiMonButton, timkiemMonButton;
	JTable monTable;
	DefaultTableModel monDtm;

	JTable dssvTable;
	DefaultTableModel dssvDtm;
	JPanel tieudePanel;
	JTable dsLopTable;
	DefaultTableModel dsLopDtm;

	JButton show1, show2;
	JPanel thongKeBang, dssvBang, dsLopBang;
	ThongKeDao thongKeDao;

	public Menu() {
		super("Quản lý trường học");

		sinhVienDao = new SinhVienDao();
		lopDao = new LopDao();
		monDao = new MonDao();
		thongKeDao = new ThongKeDao();
		JPanel jPanel = new JPanel();
		jPanel.setLayout(new BorderLayout());

		/**
		 * Tạo header
		 */

		headerPanel = new JPanel();
		headerPanel.setBackground(Color.GREEN);
		jPanel.add(headerPanel, BorderLayout.NORTH);
		headerPanel.setPreferredSize(new Dimension(1000, 150));
		ImageIcon img = new ImageIcon("C:\\Users\\Administrator\\Desktop\\ft.png");
		JLabel lblImg = new JLabel(img);

		lblImg.setPreferredSize(new Dimension(300, 140));
		JLabel tieuDe = new JLabel("Chương trình quản lý trường học");
		Font fontTieuDe = new Font("Arial", Font.BOLD | Font.ITALIC, 50);
		tieuDe.setFont(fontTieuDe);
		//
		headerPanel.add(lblImg);
		headerPanel.add(tieuDe);
		// headerPanel.add(lblImg11);
		/**
		 * Tạo phần menu
		 */

		menuPanel = new JPanel();
		JPanel jPanel2 = new JPanel();
		font = new Font("Arial", Font.BOLD | Font.ITALIC, 25);
		menuPanel.setBackground(Color.CYAN);
		menuPanel.setPreferredSize(new Dimension(300, 700));
		jPanel.add(menuPanel, BorderLayout.WEST);
		sinhVienButton = new JButton("Quản lý sinh viên");
		sinhVienButton.setFont(font);
		sinhVienButton.setPreferredSize(new Dimension(240, 50));
		monHocButton = new JButton("Quản lý môn học");
		monHocButton.setFont(font);
		monHocButton.setPreferredSize(new Dimension(240, 50));
		lopButton = new JButton("Quản lý lớp học");
		lopButton.setFont(font);
		lopButton.setPreferredSize(new Dimension(240, 50));
		thongKeButton = new JButton("Thống kê báo cáo");
		thongKeButton.setFont(font);
		thongKeButton.setPreferredSize(new Dimension(240, 50));
		trangChuButton = new JButton("Trang chủ");
		trangChuButton.setFont(font);
		trangChuButton.setPreferredSize(new Dimension(240, 50));
		ImageIcon img10 = new ImageIcon("img\\ab.jpg");
		menuPanel.setPreferredSize(new Dimension(240, 50));
		JLabel lblImg10 = new JLabel(img10);
		ImageIcon img11 = new ImageIcon("img\\ft1.jpg");
		menuPanel.setPreferredSize(new Dimension(240, 50));
		JLabel lblImg11 = new JLabel(img11);
		menuPanel.add(jPanel2);

		jPanel2.add(trangChuButton);
		jPanel2.add(sinhVienButton);
		jPanel2.add(monHocButton);
		jPanel2.add(lopButton);
		jPanel2.add(thongKeButton);
		jPanel2.add(lblImg10);
		jPanel2.add(lblImg11);
		menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.Y_AXIS));

		/**
		 * Tạo phần center
		 */

		centerPanel = new JPanel();
		centerPanel.setBackground(Color.PINK);
		jPanel.add(centerPanel, BorderLayout.CENTER);

		cardPanel = new JPanel();
		cardPanel.setLayout(new BoxLayout(cardPanel, BoxLayout.Y_AXIS));
		centerPanel.add(cardPanel);

		trangChuPanel = new JPanel();
		tieudePanel = new JPanel();
		trangChuPanel.setLayout(new BoxLayout(trangChuPanel, BoxLayout.Y_AXIS));
		tieudePanel.setLayout(new BoxLayout(tieudePanel, BoxLayout.Y_AXIS));
		jLabel = new JLabel("Trang chủ");
		// jLabel.setBounds(80, -100, 1191, 715);
		Font fontTieuDe1 = new Font("Arial", Font.BOLD | Font.ITALIC, 40);
		jLabel.setFont(fontTieuDe1);
		tieudePanel.add(jLabel);
		tieudePanel.setAlignmentX(CENTER_ALIGNMENT);

		JPanel pnImg = new JPanel();
		pnImg.setLayout(new BoxLayout(pnImg, BoxLayout.X_AXIS));
		ImageIcon img1 = new ImageIcon("img\\ab1.jpg");
		JLabel lblImg1 = new JLabel(img1);

		JPanel pnImg1 = new JPanel();
		pnImg1.setLayout(new BoxLayout(pnImg1, BoxLayout.Y_AXIS));
		ImageIcon img2 = new ImageIcon("img\\ab2.jpg");
		JLabel lblImg2 = new JLabel(img2);
		ImageIcon img3 = new ImageIcon("img\\ab.jpg");
		JLabel lblImg3 = new JLabel(img3);
		pnImg.add(lblImg1);
		pnImg1.add(lblImg2);
		pnImg1.add(lblImg3);
		pnImg.add(pnImg1);
		trangChuPanel.add(tieudePanel);
		trangChuPanel.add(pnImg);
		// cardPanel.add(tieudePanel);
		cardPanel.add(trangChuPanel);
		// Trang quản lý sinh
		// viên.*****************************************************************************
		sinhVienPanel = new JPanel();

		JLabel svLabel = new JLabel("Quản lý sinh viên");
		Font font1 = new Font("Arial", Font.BOLD | Font.ITALIC, 40);
		svLabel.setFont(font1);
		svLabel.setAlignmentX(CENTER_ALIGNMENT);
		JPanel svNhap = new JPanel();
		JPanel svPn1 = new JPanel();
		svNhap.add(svPn1);
		svPn1.setLayout(new BoxLayout(svPn1, BoxLayout.Y_AXIS));
		Font font = new Font("Arial", Font.BOLD | Font.ITALIC, 23);
		JLabel labelSV1 = new JLabel("Mã sinh viên: ");
		labelSV1.setFont(font);
		svPn1.add(labelSV1);
		JLabel labelSV2 = new JLabel("Họ tên: ");
		labelSV2.setFont(font);
		svPn1.add(labelSV2);
		JLabel labelSV3 = new JLabel("Email: ");
		labelSV3.setFont(font);
		svPn1.add(labelSV3);
		JLabel labelSV4 = new JLabel("Số điện thoại: ");
		labelSV4.setFont(font);
		svPn1.add(labelSV4);
		JLabel labelSV5 = new JLabel("Địa chỉ(số nhà): ");
		labelSV5.setFont(font);
		svPn1.add(labelSV5);

		JPanel svPn2 = new JPanel();
		border = BorderFactory.createLineBorder(Color.BLACK);
		svNhap.add(svPn2);
		svPn2.setLayout(new BoxLayout(svPn2, BoxLayout.Y_AXIS));
		maSvField = new JTextField(20);

		maSvField.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		svPn2.add(maSvField);
		tenSvField = new JTextField(20);
		tenSvField.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		svPn2.add(tenSvField);
		emailField = new JTextField(20);
		emailField.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		svPn2.add(emailField);
		sdtField = new JTextField(20);
		sdtField.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		svPn2.add(sdtField);
		diaChiField = new JTextField(20);
		diaChiField.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		svPn2.add(diaChiField);
		JPanel svPn3 = new JPanel();
		svNhap.add(svPn3);
		svPn3.setLayout(new BoxLayout(svPn3, BoxLayout.Y_AXIS));
		JLabel labelSV6 = new JLabel("Tỉnh/Thành phố: ");
		labelSV6.setFont(font);
		svPn3.add(labelSV6);
		JLabel labelSV7 = new JLabel("Quận: ");
		labelSV7.setFont(font);
		svPn3.add(labelSV7);
		JLabel labelSV8 = new JLabel("Phường: ");
		labelSV8.setFont(font);
		svPn3.add(labelSV8);
		JLabel labelSV9 = new JLabel("Mã lớp: ");
		labelSV9.setFont(font);
		svPn3.add(labelSV9);

		JPanel svPn4 = new JPanel();
		svNhap.add(svPn4);
		svPn4.setLayout(new BoxLayout(svPn4, BoxLayout.Y_AXIS));
		tpComb = new JComboBox<>();
		tpComb.addItem("Chọn thành phố");
		svPn4.add(tpComb);
		// Thành phố combox
		tpComb.setPreferredSize(new Dimension(150, 30));
		listTp = new ArrayList<String>();
		listTp = sinhVienDao.getAllThanhPho();
		for (int i = 0; i < listTp.size(); i++) {
			tpComb.addItem(listTp.get(i));
		}

		quanComb = new JComboBox<>();
		quanComb.addItem("Chọn quận/huyện");
		svPn4.add(quanComb);
		quanComb.setPreferredSize(new Dimension(150, 30));
		phuongComb = new JComboBox<>();
		phuongComb.addItem("Chọn phường/xã");
		svPn4.add(phuongComb);
		phuongComb.setPreferredSize(new Dimension(150, 30));
		lopComb = new JComboBox<>();
		lopComb.addItem("Mã lớp");
		svPn4.add(lopComb);
		// Mã Lớp combox
		lopComb.setPreferredSize(new Dimension(150, 30));
		listMaLop = new ArrayList<String>();
		listMaLop = lopDao.getAllMaLop();
		for (int i = 0; i < listMaLop.size(); i++) {
			lopComb.addItem(listMaLop.get(i));
		}

		// Quận combox
		tpComb.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					tenTP = tpComb.getSelectedItem().toString();
					quanComb.removeAllItems();
					listQuan = sinhVienDao.getAllQuanHuyen(tenTP);
					for (int i = 0; i < listQuan.size(); i++) {
						quanComb.addItem(listQuan.get(i));
					}
				}
			}
		});
		// Phư�?ng combox
		quanComb.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					tenQuan = quanComb.getSelectedItem().toString();
					phuongComb.removeAllItems();
					listXaPhuong = sinhVienDao.getAllXaPhuong(tenQuan);
					for (int j = 0; j < listXaPhuong.size(); j++) {
						phuongComb.addItem(listXaPhuong.get(j));

					}

				}
			}
		});

		phuongComb.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					tenPhuong = phuongComb.getSelectedItem().toString();
				}
			}
		});

		font = new Font("Arial", Font.BOLD | Font.ITALIC, 18);
		JPanel svbtn = new JPanel();
		themSvButton = new JButton("Thêm");
		themSvButton.setFont(font);
		svbtn.add(themSvButton);
		suaSvButton = new JButton("Sửa");
		suaSvButton.setFont(font);
		svbtn.add(suaSvButton);
		xoaSvButton = new JButton("Xóa");
		xoaSvButton.setFont(font);
		svbtn.add(xoaSvButton);
		taoMoiSvButton = new JButton("Làm mới");
		taoMoiSvButton.setFont(font);
		svbtn.add(taoMoiSvButton);
		timkiemSvButton = new JButton("Tìm Kiếm");
		timkiemSvButton.setFont(font);
		svbtn.add(timkiemSvButton);
		JPanel svBang = new JPanel();
		font = new Font("Arial", Font.BOLD | Font.ITALIC, 16);
		svDtm = new DefaultTableModel();
		svDtm.addColumn("Mã SV");
		svDtm.addColumn("Tên SV");
		svDtm.addColumn("Mã lớp");
		svDtm.addColumn("Email");
		svDtm.addColumn("Số điện thoại");
		svDtm.addColumn("Địa chỉ");
		svDtm.addColumn("Phường");
		svDtm.addColumn("Quận");
		svDtm.addColumn("Thành phố");

		svTable = new JTable(svDtm);
		svTable.getTableHeader().setReorderingAllowed(false);
		svTable.setDefaultEditor(Object.class, null);
		svTable.setFont(font);
		svTable.getTableHeader().setFont(font);
		JScrollPane scMon = new JScrollPane(svTable, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scMon.setPreferredSize(new Dimension(1400, 500));
		svTable.addMouseListener(new MouseListener() {
			public void mouseReleased(MouseEvent e) {
			}

			public void mousePressed(MouseEvent e) {
			}

			public void mouseExited(MouseEvent e) {
			}

			public void mouseEntered(MouseEvent e) {
			}

			public void mouseClicked(MouseEvent e) {
				int row = svTable.getSelectedRow();
		
				String s = (String) svTable.getValueAt(row, 0);
				maSvField.setText(s);

				String s0 = (String) svTable.getValueAt(row, 1);
				tenSvField.setText(s0);

				String s1 = (String) svTable.getValueAt(row, 3);
				emailField.setText(s1);

				String s2 = (String) svTable.getValueAt(row, 4);
				sdtField.setText(s2);

				String s6 = (String) svTable.getValueAt(row, 5);
				diaChiField.setText(s6);
			}
		});

		Border border = BorderFactory.createLineBorder(Color.RED, 2);
		TitledBorder borderTitle = BorderFactory.createTitledBorder(border, "Danh sách sinh viên");
		svBang.setBorder(borderTitle);
		svBang.add(scMon);
		displayAllSv(listSinhVien);

		sinhVienPanel.add(svLabel);
		sinhVienPanel.add(svNhap);
		sinhVienPanel.add(svbtn);
		sinhVienPanel.add(svBang);
		sinhVienPanel.setLayout(new BoxLayout(sinhVienPanel, BoxLayout.Y_AXIS));

		// Kết thúc trang quản lý sinh
		// viên.********************************************************************************

		// Trang quản lý lớp học.*******************************************************************************************

		lopPanel = new JPanel();
		JLabel lopLabel = new JLabel("Quản lý lớp học");
		Font font4 = new Font("Arial", Font.BOLD | Font.ITALIC, 40);
		lopLabel.setFont(font4);
		lopLabel.setAlignmentX(CENTER_ALIGNMENT);
		JPanel lopKhu2 = new JPanel();

		JPanel lopXemDS = new JPanel();
		lopKhu2.add(lopXemDS);
		lopXemDS.setLayout(new BoxLayout(lopXemDS, BoxLayout.Y_AXIS));
		JLabel label = new JLabel("Danh sách sinh viên");
		lopXemDS.add(label);
		Font lbfont = new Font("Arial", Font.BOLD | Font.ITALIC, 16);
		label.setFont(lbfont);
		JPanel panel = new JPanel();
		lopXemDS.add(panel);
		Font lbfont1 = new Font("Arial", Font.BOLD | Font.ITALIC, 14);
		label.setFont(lbfont1);
		JLabel label2 = new JLabel("Lọc theo năm học");
		panel.add(label2);
		label2.setFont(lbfont1);
		locTheoNam = new JComboBox<>();
		panel.add(locTheoNam);
		locTheoNam.setPreferredSize(new Dimension(150, 25));
		locTheoNam.addItem("Năm học");
		JPanel panel1 = new JPanel();
		lopXemDS.add(panel1);
		JLabel label3 = new JLabel("Lọc theo lớp học  ");
		panel1.add(label3);
		label3.setFont(lbfont1);
		locTheoLop = new JComboBox<>();
		panel1.add(locTheoLop);
		locTheoLop.setPreferredSize(new Dimension(150, 25));
		locTheoLop.addItem("Lớp");
		xemDsButton = new JButton("Xem danh sách");
		font = new Font("Arial", Font.BOLD | Font.ITALIC, 18);
		xemDsButton.setFont(font);
		lopXemDS.add(xemDsButton);
		Border borderLop1 = BorderFactory.createLineBorder(Color.BLACK);
		lopXemDS.setPreferredSize(new Dimension(400, 160));
		lopXemDS.setBorder(borderLop1);

		listNamHoc = new ArrayList<String>();
		listNamHoc = lopDao.getAllNamHoc();

		Set<String> set = new HashSet<String>(listNamHoc);
		listNamHoc = new ArrayList<String>(set);

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

		JPanel lopNhap = new JPanel();
		lopKhu2.add(lopNhap);
		lopNhap.setLayout(new BoxLayout(lopNhap, BoxLayout.Y_AXIS));
		JPanel panel2 = new JPanel();
		lopNhap.add(panel2);

		JPanel lopPn1 = new JPanel();
		panel2.add(lopPn1);
		lopPn1.setLayout(new BoxLayout(lopPn1, BoxLayout.Y_AXIS));
		Font font5 = new Font("Arial", Font.BOLD | Font.ITALIC, 16);
		JLabel labelLop1 = new JLabel("Mã Lớp: ");
		labelLop1.setFont(font5);
		lopPn1.add(labelLop1);
		JLabel labelLop2 = new JLabel("Tên lớp: ");
		labelLop2.setFont(font5);
		lopPn1.add(labelLop2);
		JLabel labelLop3 = new JLabel("Năm học: ");
		labelLop3.setFont(font5);
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

		JPanel lopMenu = new JPanel();
		lopNhap.add(lopMenu);
		JPanel lopPn3 = new JPanel();
		lopPn3.setLayout(new BoxLayout(lopPn3, BoxLayout.Y_AXIS));
		JPanel lopPn4 = new JPanel();
		lopPn3.add(lopPn4);
		JPanel lopPn5 = new JPanel();
		lopPn3.add(lopPn5);
		lopMenu.add(lopPn3);
		themLopButton = new JButton("Thêm");
		lopPn4.add(themLopButton);
		suaLopButton = new JButton("Sửa");
		lopPn4.add(suaLopButton);
		xoaLopButton = new JButton("Xóa");
		lopPn4.add(xoaLopButton);
		lamMoiLopButton = new JButton("Làm mới");
		lopPn4.add(lamMoiLopButton);
		timkiemLopButton = new JButton("Tìm kiếm");
		lopPn5.add(timkiemLopButton);
		xemDsButton1 = new JButton("Xem danh sách");
		lopPn5.add(xemDsButton1);
		lopNhap.setPreferredSize(new Dimension(400, 160));
		lopNhap.setBorder(borderLop1);

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
		scLop.setPreferredSize(new Dimension(1400, 500));

		Border borderLop = BorderFactory.createLineBorder(Color.RED, 2);
		TitledBorder borderTitleLop = BorderFactory.createTitledBorder(borderLop, "Danh sách sinh viên");
		lopSv.setBorder(borderTitleLop);
		lopSv.add(scLop);

		JPanel lopLop = new JPanel();
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
		scLop1.setPreferredSize(new Dimension(1400, 500));
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

		lopPanel.add(lopLabel);
		lopPanel.add(lopKhu2);
		lopPanel.add(lopBang);
		lopPanel.setLayout(new BoxLayout(lopPanel, BoxLayout.Y_AXIS));
		displayAllLop(listLop);

		// Kết thúc quản lý lớp học.***************************************************************************************

		// Trang quản lý môn học.*******************************************************************************************

		monHocPanel = new JPanel();
		monHocPanel.setLayout(new BoxLayout(monHocPanel, BoxLayout.Y_AXIS));
		// Tiêu đề môn
		tieuDeMon = new JLabel("Quản lý môn học");
		tieuDeMon.setLayout(new BoxLayout(tieuDeMon, BoxLayout.Y_AXIS));
		Font font2 = new Font("Arial", Font.BOLD | Font.ITALIC, 40);
		tieuDeMon.setFont(font2);
		tieuDeMon.setAlignmentX(CENTER_ALIGNMENT);
		
		// Tạo phần nhập cho bảng trang quản lý môn
		
		monNhap = new JPanel();
		monPn1 = new JPanel();
		monNhap.add(monPn1);
		
		monPn1.setLayout(new BoxLayout(monPn1, BoxLayout.Y_AXIS));
		Font font3 = new Font("Arial", Font.BOLD | Font.ITALIC, 23);
		
		labelMon1 = new JLabel("Mã môn học: ");
		labelMon1.setFont(font3);
		monPn1.add(labelMon1);
		labelMon2 = new JLabel("Tên môn học: ");
		labelMon2.setFont(font3);
		monPn1.add(labelMon2);
		labelMon3 = new JLabel("Số tín chỉ: ");
		labelMon3.setFont(font3);
		monPn1.add(labelMon3);
		labelMon4 = new JLabel("Thời lượng: ");
		labelMon4.setFont(font3);
		monPn1.add(labelMon4);

		monPn2 = new JPanel();
		border = BorderFactory.createLineBorder(Color.BLACK);
		monNhap.add(monPn2);
		
		monPn2.setLayout(new BoxLayout(monPn2, BoxLayout.Y_AXIS));
		maMonField = new JTextField(20);
		maMonField.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		monPn2.add(maMonField);
		tenMonField = new JTextField(20);
		tenMonField.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		monPn2.add(tenMonField);
		soTinChiField = new JTextField(20);
		soTinChiField.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		monPn2.add(soTinChiField);
		thoiLuongField = new JTextField(20);
		thoiLuongField.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		monPn2.add(thoiLuongField);
		
		// Tạo phần menu thêm sửa xóa cho bảng quản lý môn
		
		monMenu = new JPanel();
		monPn3 = new JPanel();
		font = new Font("Arial", Font.BOLD | Font.ITALIC, 18);
		monMenu.add(monPn3);
		themMonButton = new JButton("Thêm");
		themMonButton.setFont(font);
		monPn3.add(themMonButton);
		suaMonButton = new JButton("Sửa");
		suaMonButton.setFont(font);
		monPn3.add(suaMonButton);
		xoaMonButton = new JButton("Xóa");
		xoaMonButton.setFont(font);
		monPn3.add(xoaMonButton);
		lamMoiMonButton = new JButton("Làm mới");
		lamMoiMonButton.setFont(font);
		monPn3.add(lamMoiMonButton);
		timkiemMonButton = new JButton("Tìm kiếm");
		timkiemMonButton.setFont(font);
		monPn3.add(timkiemMonButton);
		
		// Tạo table cho trang quản lý môn học
		
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
		scMonhoc.setPreferredSize(new Dimension(1400, 500));
		
		// Tạo nút clip chuột trong bảng quản lý môn học
		
		monTable.addMouseListener(new MouseListener() {
			public void mouseReleased(MouseEvent e) {
			}

			public void mousePressed(MouseEvent e) {
			}

			public void mouseExited(MouseEvent e) {
			}

			public void mouseEntered(MouseEvent e) {
			}

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
		
		// Add các JPanel nhỏ vào JPanel tổng
		
		monHocPanel.add(tieuDeMon);
		monHocPanel.add(monNhap);
		monHocPanel.add(monMenu);
		monHocPanel.add(monBang);
		monHocPanel.setLayout(new BoxLayout(monHocPanel, BoxLayout.Y_AXIS));
		
		displayAllMonHoc(listMonHoc);
		// Kết thuc quản lý môn
		// học.***************************************************************************************

		// Trang thống
		// kê.***************************************************************************************

		thongKePanel = new JPanel();
		JLabel thongKeLabel = new JLabel("Báo cáo thống kê");
		Font font6 = new Font("Arial", Font.BOLD | Font.ITALIC, 40);
		thongKeLabel.setFont(font6);
		thongKeLabel.setAlignmentX(CENTER_ALIGNMENT);
		JPanel thongKeNhap = new JPanel();
		JPanel thongKeNhap1 = new JPanel();
		JPanel thongKeNhap2 = new JPanel();
		Font fontTit = new Font("Arial", Font.BOLD | Font.ITALIC, 20);

		namcomb1 = new JComboBox<>();
		namcomb1.setPreferredSize(new Dimension(150, 30));
		namcomb1.addItem("Năm học");
		lopcomb = new JComboBox<>();
		lopcomb.addItem("Lớp");
		lopcomb.setPreferredSize(new Dimension(150, 30));
		show1 = new JButton("Xem danh sách");
		show1.setFont(font);
		JLabel dsLopLabel = new JLabel("Báo cáo danh sách lớp học");
		dsLopLabel.setFont(fontTit);
		namcomb2 = new JComboBox<>();
		namcomb2.addItem("Năm học");
		namcomb2.setPreferredSize(new Dimension(150, 30));
		JLabel dssvLabel = new JLabel("Báo cáo danh sách sinh viên");
		dssvLabel.setFont(fontTit);
		show2 = new JButton("Xem danh sách");
		show2.setFont(font);
		listNamHoc = new ArrayList<String>();
		listNamHoc = lopDao.getAllNamHoc();

		Set<String> set1 = new HashSet<String>(listNamHoc);
		listNamHoc = new ArrayList<String>(set1);

		for (String listNam : listNamHoc) {
			namcomb1.addItem(listNam);
			namcomb2.addItem(listNam);
		}

		namcomb1.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					theoNam = namcomb1.getSelectedItem().toString();
					lopcomb.removeAllItems();
					listTenLop = lopDao.getAllTenLop(theoNam);
					for (String list : listTenLop) {
						lopcomb.addItem(list);
					}
				}
			}
		});
		thongKeNhap1.setPreferredSize(new Dimension(300, 160));
		thongKeNhap1.setBorder(borderLop1);
		thongKeNhap1.setLayout(new BoxLayout(thongKeNhap, BoxLayout.X_AXIS));
		thongKeNhap1.setLayout(new GridBagLayout());

		addItem(thongKeNhap1, dssvLabel, 0, 0, 1, 1, GridBagConstraints.EAST);
		addItem(thongKeNhap1, namcomb1, 0, 1, 1, 1, GridBagConstraints.EAST);
		addItem(thongKeNhap1, lopcomb, 0, 2, 1, 1, GridBagConstraints.EAST);
		addItem(thongKeNhap1, show1, 0, 3, 1, 1, GridBagConstraints.EAST);
		thongKeNhap2.setPreferredSize(new Dimension(300, 160));
		thongKeNhap2.setBorder(borderLop1);
		thongKeNhap2.setLayout(new BoxLayout(thongKeNhap1, BoxLayout.X_AXIS));
		thongKeNhap2.setLayout(new GridBagLayout());

		addItem(thongKeNhap2, dsLopLabel, 1, 0, 1, 1, GridBagConstraints.WEST);
		addItem(thongKeNhap2, namcomb2, 1, 1, 1, 1, GridBagConstraints.WEST);
		addItem(thongKeNhap2, new JLabel(""), 1, 2, 1, 1, GridBagConstraints.WEST);
		addItem(thongKeNhap2, show2, 1, 3, 1, 1, GridBagConstraints.WEST);
		thongKeNhap.add(thongKeNhap1);
		thongKeNhap.add(thongKeNhap2);
		thongKeBang = new JPanel();
		dssvBang = new JPanel();
		dssvDtm = new DefaultTableModel();
		font = new Font("Arial", Font.BOLD | Font.ITALIC, 18);
		dssvDtm.addColumn("Mã sinh viên");
		dssvDtm.addColumn("Tên sinh viên");

		listTenMonHoc = new ArrayList<String>();
		listTenMonHoc = monDao.getAllTenMonHoc();
		for (String tenMonHoc : listTenMonHoc) {
			dssvDtm.addColumn(tenMonHoc);
		}
		dssvDtm.addColumn("ĐTB");
		dssvDtm.addColumn("Xếp loại");
		dssvTable = new JTable(dssvDtm);
		dssvTable.getTableHeader().setReorderingAllowed(false);
		dssvTable.setDefaultEditor(Object.class, null);
		dssvTable.setFont(font);
		dssvTable.getTableHeader().setFont(font);
		JScrollPane scDssv = new JScrollPane(dssvTable, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scDssv.setPreferredSize(new Dimension(1400, 500));

		Border borderDssv = BorderFactory.createLineBorder(Color.RED, 2);
		TitledBorder borderTitleDssv = BorderFactory.createTitledBorder(borderDssv, "Danh sách sinh viên");
		Font fontTit1 = new Font("Arial", Font.BOLD | Font.ITALIC, 15);
		borderTitleDssv.setTitleFont(fontTit1);
		dssvBang.setBorder(borderTitleDssv);
		dssvBang.add(scDssv);
		font = new Font("Arial", Font.BOLD | Font.ITALIC, 18);
		dsLopBang = new JPanel();
		dsLopDtm = new DefaultTableModel();
		dsLopDtm.addColumn("Mã lớp");
		dsLopDtm.addColumn("Tên lớp");
		dsLopDtm.addColumn("Năm học");
		dsLopDtm.addColumn("Số sinh viên");
		dsLopTable = new JTable(dsLopDtm);
		dsLopTable.getTableHeader().setReorderingAllowed(false);
		dsLopTable.setDefaultEditor(Object.class, null);
		dsLopTable.setFont(font);
		dsLopTable.getTableHeader().setFont(font);
		JScrollPane scDsLop = new JScrollPane(dsLopTable, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scDsLop.setPreferredSize(new Dimension(1400, 500));

		Border borderDsLop = BorderFactory.createLineBorder(Color.RED, 2);
		TitledBorder borderTitleDsLop = BorderFactory.createTitledBorder(borderDsLop, "Danh sách lớp học");
		Font fontTit2 = new Font("Arial", Font.BOLD | Font.ITALIC, 15);
		borderTitleDsLop.setTitleFont(fontTit2);
		dsLopBang.setBorder(borderTitleDsLop);
		dsLopBang.add(scDsLop);

		card1 = new CardLayout();
		thongKeBang.setLayout(card1);
		thongKeBang.add(dssvBang, "dssvBang");
		thongKeBang.add(dsLopBang, "dsLopBang");

		thongKePanel.add(thongKeLabel);
		thongKePanel.add(thongKeNhap);
		thongKePanel.add(thongKeBang);
		thongKePanel.setLayout(new BoxLayout(thongKePanel, BoxLayout.Y_AXIS));

		// Kết thuc thống
		// kê.***************************************************************************************

		card = new CardLayout();
		cardPanel.setLayout(card);
		cardPanel.add(sinhVienPanel, "sinhVienPanel");
		cardPanel.add(monHocPanel, "monHocPanel");
		cardPanel.add(lopPanel, "lopPanel");
		cardPanel.add(thongKePanel, "thongKePanel");
		cardPanel.add(trangChuPanel, "trangChuPanel");
		card1.show(thongKeBang, "dssvBang");

		card.show(cardPanel, "trangChuPanel");

		Container con = getContentPane();
		con.add(jPanel);
		display();
		setAction();
	}

	public void setAction() {
		sinhVienButton.addActionListener(this);
		monHocButton.addActionListener(this);
		lopButton.addActionListener(this);
		thongKeButton.addActionListener(this);
		trangChuButton.addActionListener(this);
		show1.addActionListener(this);
		show2.addActionListener(this);
		themSvButton.addActionListener(this);
		suaSvButton.addActionListener(this);
		xoaSvButton.addActionListener(this);
		taoMoiSvButton.addActionListener(this);
		themLopButton.addActionListener(this);
		suaLopButton.addActionListener(this);
		xoaLopButton.addActionListener(this);
		lamMoiLopButton.addActionListener(this);
		themMonButton.addActionListener(this);
		suaMonButton.addActionListener(this);
		xoaMonButton.addActionListener(this);
		lamMoiMonButton.addActionListener(this);
		xemDsButton.addActionListener(this);
		xemDsButton1.addActionListener(this);
		timkiemLopButton.addActionListener(this);
		timkiemMonButton.addActionListener(this);
		timkiemSvButton.addActionListener(this);
	}

	public void display() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(1700, 950);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	private void addItem(JPanel jpanel, JComponent cpn, int i, int j, int k, int l, int east) {
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.gridx = i;
		gbc.gridy = j;
		gbc.gridwidth = k;
		gbc.gridheight = l;
		gbc.weightx = 100.0;
		gbc.weighty = 100.0;
		gbc.insets = new Insets(5, 5, 5, 5);
		gbc.anchor = east;
		gbc.fill = GridBagConstraints.NONE;

		jpanel.add(cpn, gbc);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// Thực hiện lệnh gọi button đến các trang của menu
		if (e.getSource() == sinhVienButton) {
			card.show(cardPanel, "sinhVienPanel");

		} else if (e.getSource() == monHocButton) {
			card.show(cardPanel, "monHocPanel");
		} else if (e.getSource() == lopButton) {
			card.show(cardPanel, "lopPanel");
		} else if (e.getSource() == thongKeButton) {
			card.show(cardPanel, "thongKePanel");
		} else if (e.getSource() == trangChuButton) {
			card.show(cardPanel, "trangChuPanel");
		} else if (e.getSource() == show1) {
			card1.show(thongKeBang, "dssvBang");
		} else if (e.getSource() == show2) {
			card1.show(thongKeBang, "dsLopBang");
			baoCaoDsLop(listDsLop);
		} else if (e.getSource() == xemDsButton) {
			card2.show(lopBang, "bang 1");
		} else if (e.getSource() == xemDsButton1) {
			card2.show(lopBang, "bang 2");
		}

		

		// Ket noi database cua quan li sinh vien.
		SinhVien sinhvien = new SinhVien();
		Phuong phuong = new Phuong();

		String idSv = maSvField.getText();
		String tenSv = tenSvField.getText();
		String sdt = sdtField.getText();
		String email = emailField.getText();
		String diaChi = diaChiField.getText();

		// Gan gia tri cho bang sinh vien

		sinhvien.setIdSinhVien(idSv);
		sinhvien.setHoTen(tenSv);
		sinhvien.setSdt(sdt);
		sinhvien.setEmail(email);
		sinhvien.setThanhpho(tenTP);
		sinhvien.setQuan(tenQuan);
		phuong.setNamePhuong(tenPhuong);
		phuong.setIdPhuong(sinhVienDao.getXaId(tenPhuong));
		sinhvien.setPhuong(phuong);
		sinhvien.setDiaChi(diaChi);
		sinhvien.setIdLop(lopComb.getSelectedItem().toString());

		// Thực hiện lệnh gọi đến nút button

		if (e.getSource() == themSvButton) {
			// Bắt lỗi các trường hợp trong nhập văn bản
			// Tao gia tri moi cho bang sinhvien

			if (idSv.length() == 0) {
				JOptionPane.showMessageDialog(null, "Mã sinh viên không đươc để trống !");
			} else if (tenSv.length() == 0) {
				JOptionPane.showMessageDialog(null, "Tên sinh viên không đươc để trống !");
			} else if (!email.matches("\\w+@+\\w+\\.\\w+{1,2}")) {
				JOptionPane.showMessageDialog(null, "Nhập sai định dạng Email \\n vd: demo123.@gmail.com");
			} else if (!sdt.matches("0[0-9]{9,10}")) {
				JOptionPane.showMessageDialog(null, "Số điện thoại phải là 9 hoặc 11 số !");
			} else if (diaChi.length() == 0) {
				JOptionPane.showMessageDialog(null, "Địa chỉ không được để trống !");
			} else if (tenTP == null || tenQuan == null || tenPhuong == null
					|| lopComb.getSelectedItem().toString() == null) {
				JOptionPane.showMessageDialog(null, "Hộp chọn không đươc để trống !");
			} else {

				int output = JOptionPane.showConfirmDialog(null, "Bạn có muốn thêm", "Thêm sinh viên",
						JOptionPane.YES_NO_OPTION);

				if (output == JOptionPane.YES_OPTION) {
					if (sinhVienDao.addNewSinhVien(sinhvien)) {
						JOptionPane.showMessageDialog(null, "Thêm thành công!!");
						svDtm.setRowCount(0);
						displayAllSv(listSinhVien);
					}
				} else if (output == JOptionPane.NO_OPTION) {
					JOptionPane.showMessageDialog(null, " Thêm thất bại!!");
				}

			}

		} else if (e.getSource() == suaSvButton) {
			// Bắt lỗi các trường hợp trong nhập văn bản

			if (idSv.length() == 0) {
				JOptionPane.showMessageDialog(null, "Mã sinh viên không đươc để trống !");
			} else if (tenSv.length() == 0) {
				JOptionPane.showMessageDialog(null, "Tên sinh viên không đươc để trống !");
			} else if (!email.matches("\\w+@+\\w+\\.\\w+{1,2}")) {
				JOptionPane.showMessageDialog(null, "Nhập sai định dạng Email \\n vd: demo123.@gmail.com");
			} else if (!sdt.matches("0[0-9]{9,10}")) {
				JOptionPane.showMessageDialog(null, "Số điện thoại phải là 9 hoặc 11 số !");
			} else if (tenTP == null || tenQuan == null || tenPhuong == null) {
				JOptionPane.showMessageDialog(null, "Hộp chọn không đươc để trống !");
			} else if (diaChi.length() == 0) {
				JOptionPane.showMessageDialog(null, "Địa chỉ không được để trống !");
			} else {

				int output1 = JOptionPane.showConfirmDialog(null, "Bạn có muốn sửa", "Sửa sinh viên",
						JOptionPane.YES_NO_OPTION);

				if (output1 == JOptionPane.YES_OPTION) {
					if (sinhVienDao.updateSinhVien(sinhvien)) {
						JOptionPane.showMessageDialog(null, "Sửa thành công!!");
						svDtm.setRowCount(0);
						displayAllSv(listSinhVien);
					}
				} else if (output1 == JOptionPane.NO_OPTION) {
					JOptionPane.showMessageDialog(null, " Sửa thất bại!!");
				}
			}
		} else if (e.getSource() == xoaSvButton) {
			int output1 = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa", "Xóa sinh viên",
					JOptionPane.YES_NO_OPTION);

			if (output1 == JOptionPane.YES_OPTION) {
				if (sinhVienDao.deletelSinhVien(sinhvien)) {
					JOptionPane.showMessageDialog(null, "Xóa thành công!!");
					svDtm.setRowCount(0);
					displayAllSv(listSinhVien);
				}
			} else if (output1 == JOptionPane.NO_OPTION) {
				JOptionPane.showMessageDialog(null, " Xóa thất bại!!");
			}

		} else if (e.getSource() == timkiemSvButton) {
			int output1 = JOptionPane.showConfirmDialog(null, "Bạn có muốn tìm", "Tìm sinh viên",
					JOptionPane.YES_NO_OPTION);
			if (output1 == JOptionPane.YES_OPTION) {
				svDtm.setRowCount(0);
				listSinhVien1 = new ArrayList<SinhVien>();
				listSinhVien1 = sinhVienDao.showTableSinhVienTimKiem(sinhvien);
				JOptionPane.showMessageDialog(null, " Tìm thành công!!");
				for (SinhVien sinhVien : listSinhVien1) {
					svDtm.addRow(new String[] { sinhVien.getIdSinhVien(), sinhVien.getHoTen(), sinhVien.getIdLop(),
							sinhVien.getEmail(), sinhVien.getSdt(), sinhVien.getDiaChi(),
							sinhVien.getPhuong().getNamePhuong(), sinhVien.getQuan(), sinhVien.getThanhpho() });
				}
			} else if (output1 == JOptionPane.NO_OPTION) {
				JOptionPane.showMessageDialog(null, " Tìm thất bại!!");
			}

		} else {
			maSvField.setText("");
			tenSvField.setText("");
			sdtField.setText("");
			emailField.setText("");
			diaChiField.setText("");
			svDtm.setRowCount(0);
			displayAllSv(listSinhVien);
		}

		// Ket noi database cua bang quan ly lop
		Lop lop = new Lop();
		// Tao gia tri moi cho bang quan ly lop

		String idLop1 = maLopField.getText();
		String tenLop1 = tenLopField.getText();
		String namHoc1 = namHocField.getText();

		// Gan gia tri cho bang quan ly lop

		lop.setIdLop(idLop1);
		lop.setTenLop(tenLop1);
		lop.setNamHoc(namHoc1);

		// Thực hiện lệnh g�?i đến nút button

		if (e.getSource() == themLopButton) {
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
			} else if (!namHoc1.matches("\\d{2,3}")) {
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
		} else if (e.getSource() == suaLopButton) {
			// Bắt lỗi các trường hợp trong nhập văn bản
			if (tenLop1.length() == 0) {
				JOptionPane.showMessageDialog(null, "Tên lớp không đươc để trống !");
			} else if (!tenLop1.matches("\\d{4}")) {
				JOptionPane.showMessageDialog(null, "Tên lớp chỉ được nhập số và phải đủ 4 chữ số. \n Vd: 1801 !");
			} else if (namHoc1.length() == 0) {
				JOptionPane.showMessageDialog(null, "Năm  học không được để trống !");
			} else if (!namHoc1.matches("\\d{2,3}")) {
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
		} else if (e.getSource() == xoaLopButton) {
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
		} else if (e.getSource() == timkiemLopButton) {
			int output = JOptionPane.showConfirmDialog(null, "Bạn có muốn tìm", "Tìm Lớp", JOptionPane.YES_NO_OPTION);

			if (output == JOptionPane.YES_OPTION) {
				lopDtm1.setRowCount(0);
				listLop = new ArrayList<Lop>();
				listLop = lopDao.showTableLopTimKiem(lop);
				JOptionPane.showMessageDialog(null, "Tìm thành công!!");
				for (Lop lop1 : listLop) {
					lopDtm1.addRow(new String[] { lop1.getIdLop(), lop1.getTenLop(), lop1.getNamHoc() });
				}
			} else if (output == JOptionPane.NO_OPTION) {
				JOptionPane.showMessageDialog(null, "Tìm thất bại!!");
			}

		} else {
			maLopField.setText("");
			tenLopField.setText("");
			namHocField.setText("");

		}

		// Ket noi database của bảng môn học

		MonHoc monHoc = new MonHoc();
		// Tao gia tri moi cho bảng môn học

		String idMonHoc1 = maMonField.getText();
		String tenMonHoc1 = tenMonField.getText();
		String tinChi1 = soTinChiField.getText();
		String thoiLuong1 = thoiLuongField.getText();

		// Gan gia tri cho bang mon hoc

		monHoc.setIdMonHoc(idMonHoc1);
		monHoc.setTenMonHoc(tenMonHoc1);
		monHoc.setTinChi(tinChi1);
		monHoc.setThoiLuongHoc(thoiLuong1);

		// Thực hiện lệnh gọi đến nút button thêm , sửa , xóa, tìm kiếm đến trang quản lý môn học

		if (e.getSource() == themMonButton) {// Nút thêm môn học
			// Bắt lỗi các trường hợp trong nhập văn bản
			if (idMonHoc1.length() == 0) {
				JOptionPane.showMessageDialog(null, "Mã môn học không đươc để trống !");
			} else if (!idMonHoc1.matches("\\w{5}")) {
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
				JOptionPane.showMessageDialog(null, "Tên môn h�?c không đươc để trống !");
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
				JOptionPane.showMessageDialog(null, " M�?i bạn ch�?n lại!!");
			}
		} else if (e.getSource() == timkiemMonButton) { // Nút tìm kiếm môn học
			int output = JOptionPane.showConfirmDialog(null, "Bạn có muốn tìm", "Tìm Môn", JOptionPane.YES_NO_OPTION);

			if (output == JOptionPane.YES_OPTION) {
				monDtm.setRowCount(0);
				listMonHoc = new ArrayList<MonHoc>();
				listMonHoc = monDao.showTableMonTimKiem(monHoc);
				JOptionPane.showMessageDialog(null, "Tìm thành công!!");
				for (MonHoc monHoc1 : listMonHoc) {
					monDtm.addRow(new String[] { monHoc1.getIdMonHoc(), monHoc1.getTenMonHoc(), monHoc1.getTinChi(),
							monHoc1.getThoiLuongHoc() });
				}
			} else if (output == JOptionPane.NO_OPTION) {
				JOptionPane.showMessageDialog(null, " Mời bạn chọn lại!!");
			}

		} else { // Nút làm mới
			maMonField.setText("");
			tenMonField.setText("");
			soTinChiField.setText("");
			thoiLuongField.setText("");
			monDtm.setRowCount(0);
			displayAllMonHoc(listMonHoc);
		}
		// Hiển thi danh sách trong bảng lớp lien ket voi database

		// Gán giá trị cho bảng hiển thị danh sách trong bảng quản lý lớp học

		lop.setIdLop(idLop1);
		lop.setTenLop(theoLop);
		sinhvien.setIdSinhVien(idSv);
		sinhvien.setHoTen(tenSv);
		lop.setSinhVien(sinhvien);
		lop.setNamHoc(theoNam);

		// Thực hiện lệnh gọi đến nút button
		// Bảng danh sách lớp trong bảng quản lý lơp
		if (e.getSource() == xemDsButton) {
			listSvTheoLop = new ArrayList<Lop>();
			listSvTheoLop = lopDao.getAllSinhVienTheoNam(lop);
			displayAllSvTheoNam(listSvTheoLop);
		}

		if (e.getSource() == xemDsButton1) {
			lopDtm1.setRowCount(0);
			displayAllLop(listLop);
		}

		// Bảng danh sách thống kê lớp
		if (e.getSource() == show1) {
			listSinhVien2 = new ArrayList<SinhVien>();
			dssvDtm.setRowCount(0);
			listSinhVien2 = thongKeDao.getAllTenSinhVien(thongKeDao.getLopId(lopcomb.getSelectedItem().toString()));
			double dtb = 0;
			String xepLoai = null;
			
			for (SinhVien sinhVien : listSinhVien2) {
				
				double diemJava = thongKeDao.getDiemThiJava(sinhVien.getIdSinhVien());
				double diemHTML = thongKeDao.getDiemThiHTML(sinhVien.getIdSinhVien());
				double diemCSS = thongKeDao.getDiemThiCSS(sinhVien.getIdSinhVien());
				double diemEnglish = thongKeDao.getDiemThiEnligh(sinhVien.getIdSinhVien());
				
				dtb = (diemJava + diemHTML + diemCSS + diemEnglish)/4;
				if(dtb>=8) {
					xepLoai = "Gi�?i";
				}else if(dtb>=6.5) {
					xepLoai = "Khá";
				}else if(dtb>=5) {
					xepLoai = "TB";
				}else {
					xepLoai = "Yếu";
				}
				
				dssvDtm.addRow(new String[] { sinhVien.getIdSinhVien(), sinhVien.getHoTen(), String.valueOf(diemJava), String.valueOf(diemEnglish),
						String.valueOf(diemCSS), String.valueOf(diemHTML),  String.valueOf(dtb), xepLoai});
				
				
			}
		}
	}

	// Hiển thị danh sách tất cả sinh viên

	public void displayAllSv(ArrayList<SinhVien> listSinhVien) {
		listSinhVien = new ArrayList<SinhVien>();
		listSinhVien = sinhVienDao.getAllSinhVien();
		for (SinhVien sinhVien : listSinhVien) {
			svDtm.addRow(new String[] { sinhVien.getIdSinhVien(), sinhVien.getHoTen(), sinhVien.getIdLop(),
					sinhVien.getEmail(), sinhVien.getSdt(), sinhVien.getDiaChi(), sinhVien.getPhuong().getNamePhuong(),
					sinhVien.getQuan(), sinhVien.getThanhpho() });
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

	// Hiển thị danh sách tất cả môn học

	public void displayAllMonHoc(ArrayList<MonHoc> listMonHoc) {
		listMonHoc = new ArrayList<MonHoc>();
		listMonHoc = monDao.getAllMonHoc();
		for (MonHoc monHoc : listMonHoc) {
			monDtm.addRow(new String[] { monHoc.getIdMonHoc(), monHoc.getTenMonHoc(), monHoc.getTinChi(),
					monHoc.getThoiLuongHoc() });
		}
	}

	// Hiển thị danh sách sinh viên theo năm học và lớp học

	public void displayAllSvTheoNam(ArrayList<Lop> listSvTheoLop) {
		for (Lop lop1 : listSvTheoLop) {
			lopDtm.addRow(new String[] { lop1.getIdLop(), lop1.getTenLop(), lop1.getSinhVien().getIdSinhVien(),
					lop1.getSinhVien().getHoTen(), lop1.getNamHoc() });
		}
	}

	// Bảng thống kê báo cáo danh sách

	public void baoCaoDsLop(ArrayList<Lop> listDsLop) {
		listDsLop = new ArrayList<Lop>();
		dsLopDtm.setRowCount(0);
		listDsLop = thongKeDao.getAllLopTheoNam(namcomb2.getSelectedItem().toString());
		for (Lop lop11 : listDsLop) {
			dsLopDtm.addRow(new String[] { lop11.getIdLop(), lop11.getTenLop(), lop11.getNamHoc(),
					String.valueOf(thongKeDao.getAllSinhVienTheoLop(lop11.getIdLop())) });
		}
	}

	public void baoCaoDsSv(ArrayList<SinhVien> listSinhVien2) {

	}

	public static void main(String[] args) {
		Menu menu = new Menu();
		menu.display();
	}

}
