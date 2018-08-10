package QuanLyTienDien;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import QuanLyTienDien.model.BaoCaoDAO;
import QuanLyTienDien.model.BienLaiDAO;
import QuanLyTienDien.model.CongToDienDAO;
import QuanLyTienDien.model.KhachHangDAO;
import QuanLyTienDien.model.entity.BienLai;
import QuanLyTienDien.model.entity.CongToDien;
import QuanLyTienDien.model.entity.DateLabelFormatter;
import QuanLyTienDien.model.entity.KhachHang;
import QuanLyTienDien.model.entity.Phuong;
import QuanLyTienDien.model.entity.Quan;
import QuanLyTienDien.model.entity.TienDien;

/**
 * Chương trình quản lý tiền điện
 * 
 * @author SonVD and HungHK
 *
 */
public class QuanLyTienDien extends JFrame implements ActionListener {
	CardLayout cardLayout;
	JPanel cardPane, infoPane, btPane, tablePane, infoPane1, btPane1, tablePane1, tablePane2, tablePane4, tablePane5,
			tablePane6, tablePane7, tablePane8, tablePane9, card0, Panectdien, btPane5;
	JTextField txtMaKhachHang, txtNameKhachHang, txtDiachi, txtDienthoai, txtEmail, txtChuKyNhap, txtChiSoCongTo,
			txtMaKhachHang1, txtChuKyNhap7, txtChuKyNhap8, txtChuKyNhaP8, txtChuKyNhap9, txtMaBienLai, txtTimKiem,
			txtTimKiem1, txtMaCongToDien, txtTimKiem5;
	JComboBox cbPhuong, cbQuan, cbPhuong2, cbQuan2, cbPhuong5, cbQuan5, cbCongToDien, cbCongToDien1;
	JButton btAdd, btRepair, btDelete, btExit, btAdd1, btRepair1, btDelete1, btExit1, btKhachHang, btBienLai,
			btDSKHTQuan, btdsttdAll, btdsttkhuvuc, btdsttoneKH, btdstttheonam, btdstttkhoangtg, btdstttheoky, btdisplay,
			btdisplay7, btdisplay8, btdisplay9, btfind, btLamMoi, btfind1, btLamMoi1, btdanhsach, btCongToDien, btAdd5,
			btRepair5, btDelete5, btfind5, btLamMoi5, btExit5;
	JTable jTable, jTable1, jTable2, jTable4, jTable5;
	JLabel lbTKiem, lbTKiem1, lbTKiem5;
	JRadioButton rad1, rad2, rad3, rad4, rad5, rad6, rad7;
	DefaultTableModel dtm, dtm1, dtm2, dtm4, dtm5;
	KhachHangDAO khachHangDAO;
	BienLaiDAO bienLaiDao;
	BaoCaoDAO baoCaoDAO;
	CongToDienDAO congToDienDAO;
	ArrayList<Quan> list;
	ArrayList<Phuong> list1;
	ArrayList<CongToDien> list2;
	TienDien tienDien;
	String tenQuan;
	UtilDateModel model;
	Properties p;
	JDatePanelImpl datePanel;
	JDatePickerImpl datePicker;
	ButtonGroup grouprdo, group1rdo;

	/**
	 * Thêm các mục
	 * 
	 * @param p
	 *            Jpanel
	 * @param c
	 *            Jcomponet
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 * @param align
	 */
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

	/**
	 * Phần thiết kế giao diện
	 */
	public QuanLyTienDien() {
		super("Quán Lý Tiền Điện tại sở điện lực Đà Nẵng");
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		khachHangDAO = new KhachHangDAO();
		bienLaiDao = new BienLaiDAO();
		baoCaoDAO = new BaoCaoDAO();
		tienDien = new TienDien();
		congToDienDAO = new CongToDienDAO();

		//
		JPanel pnBorder = new JPanel();
		pnBorder.setLayout(new BorderLayout());

		// Layout phía Bắc
		JPanel pnNorth = new JPanel();
		JLabel title = new JLabel("CHƯƠNG TRÌNH QUẢN LÝ TIỀN ĐIỆN TẠI ĐÀ NẴNG");
		title.setFont(new Font("Serif", Font.BOLD, 25));
		pnNorth.setBackground(new Color(153, 204, 255));
		pnNorth.add(title);
		pnBorder.add(pnNorth, BorderLayout.NORTH);

		// Layout phía Tây
		JPanel pnWest = new JPanel();

		// Các button Menu
		JLabel lbQuanLy = new JLabel("Quản lý");
		btKhachHang = new JButton("Khách Hàng");
		btBienLai = new JButton("Biên Lai");
		JLabel lbBaoCao = new JLabel("Thống kê báo cáo");
		btDSKHTQuan = new JButton("Khách hàng theo quận , phường");
		btdsttdAll = new JButton("Tình hình tiêu thụ của khách hàng");
		btCongToDien = new JButton("Công tơ điện");

		JPanel layout = new JPanel();
		pnWest.setLayout(new BoxLayout(pnWest, BoxLayout.Y_AXIS));
		layout.add(lbQuanLy);
		layout.add(btCongToDien);
		layout.add(btKhachHang);
		layout.add(btBienLai);
		layout.add(lbBaoCao);
		layout.add(btDSKHTQuan);
		layout.add(btdsttdAll);

		btCongToDien.setPreferredSize(new Dimension(250, 30));
		btKhachHang.setPreferredSize(new Dimension(250, 30));
		btBienLai.setPreferredSize(new Dimension(250, 30));
		btDSKHTQuan.setPreferredSize(new Dimension(250, 30));
		btdsttdAll.setPreferredSize(new Dimension(250, 30));

		pnWest.setPreferredSize(new Dimension(250, 700));
		pnWest.add(layout);
		Border border2 = BorderFactory.createLineBorder(Color.RED);
		TitledBorder titledBorder2 = BorderFactory.createTitledBorder(border2, "Menu");
		pnWest.setBorder(titledBorder2);
		layout.setBackground(new Color(153, 204, 255));

		pnBorder.add(pnWest, BorderLayout.WEST);

		// Layout trung tâm
		JPanel pnCenter = new JPanel();
		JScrollPane pane = new JScrollPane(pnCenter);
		pnBorder.add(pane, BorderLayout.CENTER);

		cardPane = new JPanel();

		// *********** PHẦN TRANG CHỦ*******************
		card0 = new JPanel();
		JPanel imgPane = new JPanel();
		ImageIcon img = new ImageIcon("F:\\bài tập ftse1801\\acx.jpg");
		JLabel lblImg = new JLabel(img);
		imgPane.add(lblImg);
		card0.add(imgPane);
		card0.setPreferredSize(new Dimension(1000, 650));

		// ****************PHẦN QUẢN LÝ KHÁCH HÀNG***********************
		JPanel card1 = new JPanel();

		// PHẦN TIÊU ĐỀ
		JPanel TitlePane = new JPanel();
		JLabel txtTitle = new JLabel("QUẢN LÝ KHÁCH HÀNG");
		txtTitle.setFont(new Font("Serif", Font.BOLD, 20));
		TitlePane.add(txtTitle);
		TitlePane.setBackground(Color.WHITE);
		card1.add(TitlePane);

		// CÁC TRƯỜNG NHẬP DỮ LIỆU
		txtMaKhachHang = new JTextField(15);
		txtNameKhachHang = new JTextField(15);
		txtDiachi = new JTextField(15);
		cbPhuong = new JComboBox();
		cbPhuong.addItem("Chọn Phường");
		cbQuan = new JComboBox();
		cbQuan.addItem("Chọn Quận");
		txtDienthoai = new JTextField(15);
		txtEmail = new JTextField(15);
		cbCongToDien = new JComboBox<>();
		cbCongToDien.setPreferredSize(new Dimension(170, 25));
		cbQuan.setPreferredSize(new Dimension(170, 25));
		cbPhuong.setPreferredSize(new Dimension(170, 25));

		infoPane = new JPanel();
		JPanel info1 = new JPanel();
		infoPane.setLayout(new GridBagLayout());
		info1.setLayout(new GridBagLayout());
		addItem(infoPane, new JLabel("Mã Khách Hàng (*):"), 0, 0, 1, 1, GridBagConstraints.EAST);
		addItem(infoPane, new JLabel("Họ Tên Khách Hàng (*):"), 0, 1, 1, 1, GridBagConstraints.EAST);
		addItem(info1, new JLabel("Địa Chỉ:"), 0, 0, 1, 1, GridBagConstraints.EAST);
		addItem(info1, new JLabel("Phường (*):"), 0, 2, 1, 1, GridBagConstraints.EAST);
		addItem(info1, new JLabel("Quận (*):"), 0, 1, 1, 1, GridBagConstraints.EAST);
		addItem(info1, new JLabel("Điện thoại (*):"), 0, 3, 1, 1, GridBagConstraints.EAST);
		addItem(infoPane, new JLabel("Email:"), 0, 2, 1, 1, GridBagConstraints.EAST);
		addItem(infoPane, new JLabel("Mã công tơ điện (*):"), 0, 3, 1, 1, GridBagConstraints.EAST);

		addItem(infoPane, txtMaKhachHang, 1, 0, 1, 1, GridBagConstraints.WEST);
		addItem(infoPane, txtNameKhachHang, 1, 1, 2, 1, GridBagConstraints.WEST);
		addItem(info1, txtDiachi, 1, 0, 2, 1, GridBagConstraints.WEST);
		addItem(info1, cbPhuong, 1, 2, 2, 1, GridBagConstraints.WEST);
		addItem(info1, cbQuan, 1, 1, 2, 1, GridBagConstraints.WEST);
		addItem(info1, txtDienthoai, 1, 3, 2, 1, GridBagConstraints.WEST);
		addItem(infoPane, txtEmail, 1, 2, 2, 1, GridBagConstraints.WEST);
		addItem(infoPane, cbCongToDien, 1, 3, 2, 1, GridBagConstraints.WEST);

		list = khachHangDAO.getAllQuan();
		for (int i = 0; i < list.size(); i++) {
			cbQuan.addItem(list.get(i));
		}

		cbQuan.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				tenQuan = cbQuan.getSelectedItem().toString();
				cbPhuong.removeAllItems();
				list1 = khachHangDAO.getAllPhuong(tenQuan);
				for (int i = 0; i < list1.size(); i++) {
					cbPhuong.addItem(list1.get(i));
				}
				cbPhuong.addItem("Chọn Phường");
			}
		});
		list1 = khachHangDAO.getAllPhuong(cbQuan.getSelectedItem().toString());
		for (int i = 0; i < list1.size(); i++) {
			cbPhuong.addItem(list1.get(i));
		}

		list2 = congToDienDAO.getAllCongToDien();
		for (int i = 0; i < list2.size(); i++) {
			cbCongToDien.addItem(list2.get(i));
		}

		JPanel infoChung = new JPanel();
		infoChung.setLayout(new BoxLayout(infoChung, BoxLayout.X_AXIS));
		infoChung.add(infoPane);
		infoChung.add(info1);
		info1.setBackground(Color.WHITE);
		infoPane.setBackground(Color.WHITE);
		card1.add(infoChung);

		JPanel PaneInfor = new JPanel();
		JLabel lbinfor = new JLabel("(*) Thông tin cần phải nhập");
		PaneInfor.add(lbinfor);
		PaneInfor.setBackground(Color.WHITE);
		card1.add(PaneInfor);

		// CÁC NÚT THÊM SỬA XÓA
		btPane = new JPanel();
		btAdd = new JButton("Thêm");
		btRepair = new JButton("Sửa");
		btDelete = new JButton("Xóa");
		btLamMoi = new JButton("Làm mới");
		btExit = new JButton("Thoát");

		btPane.add(btAdd);
		btPane.add(btRepair);
		btPane.add(btDelete);
		btPane.add(btLamMoi);
		btPane.add(btExit);
		pnCenter.add(btPane);
		btPane.setBackground(Color.WHITE);

		btRepair.setEnabled(false);
		btDelete.setEnabled(false);

		btLamMoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				btAdd.setEnabled(true);
				btRepair.setEnabled(false);
				btDelete.setEnabled(false);
			}
		});

		card1.add(btPane);

		JPanel PaneBT = new JPanel();
		lbTKiem = new JLabel("Tìm kiếm:");
		btfind = new JButton("Tìm kiếm thông tin");
		txtTimKiem = new JTextField(15);
		PaneBT.add(lbTKiem);
		PaneBT.add(txtTimKiem);
		PaneBT.add(btfind);
		PaneBT.setBackground(Color.WHITE);
		card1.add(PaneBT);

		// BẢNG HIỂN THỊ BẢNG DANH SÁCH KHÁCH HÀNG
		tablePane = new JPanel();
		Border border = BorderFactory.createLineBorder(Color.RED);
		TitledBorder titledBorder = BorderFactory.createTitledBorder(border, "Danh sách khách hàng");

		dtm = new DefaultTableModel();
		dtm.addColumn("Mã khách hàng");
		dtm.addColumn("Họ tên khách hàng");
		dtm.addColumn("Địa chỉ");
		dtm.addColumn("Phường");
		dtm.addColumn("Quận");
		dtm.addColumn("Điện thoại");
		dtm.addColumn("Email");
		dtm.addColumn("Mã công tơ");

		tablePane.setBorder(titledBorder);
		jTable = new JTable(dtm);
		jTable.setDefaultEditor(Object.class, null);
		jTable.getTableHeader().setReorderingAllowed(false);
		JScrollPane jScrollPane = new JScrollPane(jTable);
		jScrollPane.setPreferredSize(new Dimension(1000, 400));
		tablePane.add(jScrollPane);

		jTable.addMouseListener(new MouseListener() {
			public void mouseReleased(MouseEvent e) {
			}

			public void mousePressed(MouseEvent e) {
			}

			public void mouseExited(MouseEvent e) {
			}

			public void mouseEntered(MouseEvent e) {
			}

			public void mouseClicked(MouseEvent e) {
				int row = jTable.getSelectedRow();
				String s = (String) jTable.getValueAt(row, 0);
				txtMaKhachHang.setText(s);
				String s1 = (String) jTable.getValueAt(row, 1);
				txtNameKhachHang.setText(s1);
				String s2 = (String) jTable.getValueAt(row, 2);
				txtDiachi.setText(s2);
				String s3 = (String) jTable.getValueAt(row, 3);
				cbPhuong.getModel().setSelectedItem(s3);
				String s4 = (String) jTable.getValueAt(row, 4);
				cbQuan.getModel().setSelectedItem(s4);
				String s5 = (String) jTable.getValueAt(row, 5);
				txtDienthoai.setText(s5);
				String s6 = (String) jTable.getValueAt(row, 6);
				txtEmail.setText(s6);
				String s7 = (String) jTable.getValueAt(row, 7);
				cbCongToDien.getModel().setSelectedItem(s7);

				btAdd.setEnabled(false);
				btRepair.setEnabled(true);
				btDelete.setEnabled(true);
			}
		});

		ArrayList<KhachHang> listds = khachHangDAO.getAllKhachHang();
		dtm.setRowCount(0);
		for (KhachHang khachHang1 : listds) {
			dtm.addRow(new String[] { khachHang1.getMaKhachHang(), khachHang1.getNameKhachHang(),
					khachHang1.getAddress(), khachHang1.getTenPhuong(), khachHang1.getTenQuan(), khachHang1.getPhone(),
					khachHang1.getEmail(), khachHang1.getMaCongTo().getMaCongTo() });
		}

		card1.setLayout(new BoxLayout(card1, BoxLayout.Y_AXIS));
		card1.add(tablePane);

		// ********************QUẢN LÝ BIÊN LAI*************************
		JPanel card2 = new JPanel();

		// TIÊU ĐỀ
		JPanel titlePane1 = new JPanel();
		JLabel txtTitle1 = new JLabel("QUẢN LÝ BIÊN LAI");
		txtTitle1.setFont(new Font("Serif", Font.BOLD, 20));
		titlePane1.add(txtTitle1);
		titlePane1.setBackground(Color.WHITE);
		card2.add(titlePane1);

		// CÁC TRƯỜNG NHẬP DỮ LIỆU

		model = new UtilDateModel();
		model.setSelected(true);
		p = new Properties();
		p.put("text.today", "today");
		p.put("text.month", "month");
		p.put("text.year", "year");
		datePanel = new JDatePanelImpl(model, p);
		// datePicker.setValue(LocalDate.now());
		datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
		datePicker.setBounds(230, 30, 110, 30);

		txtMaBienLai = new JTextField(15);
		txtChuKyNhap = new JTextField(15);
		txtChiSoCongTo = new JTextField(15);
		cbCongToDien1 = new JComboBox<>();
		cbCongToDien1.setPreferredSize(new Dimension(170, 25));

		infoPane1 = new JPanel();
		infoPane1.setLayout(new GridBagLayout());
		addItem(infoPane1, new JLabel("Mã biên lai (*)"), 0, 0, 1, 1, GridBagConstraints.EAST);
		addItem(infoPane1, new JLabel("Mã Công Tơ (*):"), 0, 1, 1, 1, GridBagConstraints.EAST);
		addItem(infoPane1, new JLabel("Ngày nhập (*):"), 0, 2, 1, 1, GridBagConstraints.EAST);
		addItem(infoPane1, new JLabel("Chu kỳ nhập (*):"), 0, 3, 1, 1, GridBagConstraints.EAST);
		addItem(infoPane1, new JLabel("Chỉ số công tơ (*):"), 0, 4, 1, 1, GridBagConstraints.EAST);

		addItem(infoPane1, txtMaBienLai, 1, 0, 2, 1, GridBagConstraints.WEST);
		addItem(infoPane1, cbCongToDien1, 1, 1, 2, 1, GridBagConstraints.WEST);
		addItem(infoPane1, datePicker, 1, 2, 1, 1, GridBagConstraints.WEST);
		addItem(infoPane1, txtChuKyNhap, 1, 3, 2, 1, GridBagConstraints.WEST);
		addItem(infoPane1, txtChiSoCongTo, 1, 4, 2, 1, GridBagConstraints.WEST);

		list2 = congToDienDAO.getAllCongToDien();
		for (int i = 0; i < list2.size(); i++) {
			cbCongToDien1.addItem(list2.get(i));
		}

		infoPane1.setBackground(Color.WHITE);
		card2.add(infoPane1);

		JPanel PaneInfor1 = new JPanel();
		JLabel lbinfor1 = new JLabel("(*) Thông tin cần phải nhập");
		PaneInfor1.add(lbinfor1);
		PaneInfor1.setBackground(Color.WHITE);
		card2.add(PaneInfor1);

		// CÁC NÚT THÊM SỬA XÓA
		btPane1 = new JPanel();
		btAdd1 = new JButton("Thêm");
		btRepair1 = new JButton("Sửa");
		btDelete1 = new JButton("Xóa");
		btfind1 = new JButton("Tìm kiếm");
		btLamMoi1 = new JButton("Làm mới");
		btExit1 = new JButton("Thoát");
		btPane1.add(btAdd1);
		btPane1.add(btRepair1);
		btPane1.add(btDelete1);

		btPane1.add(btLamMoi1);
		btPane1.add(btExit1);
		pnCenter.add(btPane1);
		btPane1.setBackground(Color.WHITE);

		btRepair1.setEnabled(false);
		btDelete1.setEnabled(false);

		btLamMoi1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				btAdd1.setEnabled(true);
				btRepair1.setEnabled(false);
				btDelete1.setEnabled(false);
			}
		});

		card2.add(btPane1);

		JPanel PaneBT1 = new JPanel();
		lbTKiem1 = new JLabel("Tìm kiếm:");
		btfind1 = new JButton("Tìm kiếm thông tin");
		txtTimKiem1 = new JTextField(15);
		PaneBT1.add(lbTKiem1);
		PaneBT1.add(txtTimKiem1);
		PaneBT1.add(btfind1);
		PaneBT1.setBackground(Color.WHITE);
		card2.add(PaneBT1);

		// BẢNG HIỂN THỊ DANH SÁCH BIÊN LAI
		tablePane1 = new JPanel();
		Border border1 = BorderFactory.createLineBorder(Color.RED);
		TitledBorder titledBorder1 = BorderFactory.createTitledBorder(border1, "Danh sách biên lai");
		dtm1 = new DefaultTableModel();
		dtm1.addColumn("Mã biên lai");
		dtm1.addColumn("Mã công tơ");
		dtm1.addColumn("Ngày nhập");
		dtm1.addColumn("Chu kỳ nhập");
		dtm1.addColumn("Chỉ số công tơ");

		tablePane1.setBorder(titledBorder1);
		jTable1 = new JTable(dtm1);
		jTable1.setDefaultEditor(Object.class, null);
		jTable1.getTableHeader().setReorderingAllowed(false);
		JScrollPane jScrollPane1 = new JScrollPane(jTable1);
		jScrollPane1.setPreferredSize(new Dimension(1000, 400));
		tablePane1.add(jScrollPane1);

		jTable1.addMouseListener(new MouseListener() {
			public void mouseReleased(MouseEvent e) {
			}

			public void mousePressed(MouseEvent e) {
			}

			public void mouseExited(MouseEvent e) {
			}

			public void mouseEntered(MouseEvent e) {
			}

			public void mouseClicked(MouseEvent e) {
				int row = jTable1.getSelectedRow();
				String s = (String) jTable1.getValueAt(row, 0);
				txtMaBienLai.setText(s);
				String s1 = (String) jTable1.getValueAt(row, 1);
				cbCongToDien1.getModel().setSelectedItem(s1);
				String s2 = (String) jTable1.getValueAt(row, 2);
				datePicker.getJFormattedTextField().setText(s2);
				String s3 = (String) jTable1.getValueAt(row, 3);
				txtChuKyNhap.setText(s3);
				String s4 = (String) jTable1.getValueAt(row, 4);
				txtChiSoCongTo.setText(s4);

				btAdd1.setEnabled(false);
				btRepair1.setEnabled(true);
				btDelete1.setEnabled(true);
			}
		});

		ArrayList<BienLai> listds1 = bienLaiDao.getAllBienLai();
		dtm1.setRowCount(0);
		String datePattern = "dd-MM-yyyy";
		SimpleDateFormat dateFormatter = new SimpleDateFormat(datePattern);
		for (BienLai bienLai : listds1) {
			dtm1.addRow(new String[] { "" + bienLai.getMaBienLai(), bienLai.getMaCongTo().getMaCongTo(),
					dateFormatter.format(bienLai.getNgayNhap()), "" + bienLai.getChuKyNhap(),
					bienLai.getChiSoCongTo() });
		}

		card2.setLayout(new BoxLayout(card2, BoxLayout.Y_AXIS));
		card2.add(tablePane1);
		card2.setPreferredSize(new Dimension(1000, 650));

		// ****************BÁO CÁO KHÁCH HÀNG THEO QUẬN, PHƯỜNG****************
		JPanel card3 = new JPanel();

		// PHẦN TIÊU ĐỀ
		JPanel titlePan3 = new JPanel();
		JLabel txtTitle3 = new JLabel("DANH SÁCH KHÁCH HÀNG THEO QUẬN, PHƯỜNG");
		txtTitle3.setFont(new Font("Serif", Font.BOLD, 20));
		titlePan3.add(txtTitle3);
		titlePan3.setBackground(Color.WHITE);
		card3.add(titlePan3);

		// PHẦN HIỂN THỊ COMBOBOX PHƯỜNG VÀ QUẬN
		JPanel quanPaneChung = new JPanel();
		JPanel quanPane = new JPanel();
		JPanel quanPane1 = new JPanel();
		cbPhuong2 = new JComboBox();
		cbQuan2 = new JComboBox();
		quanPane.setLayout(new GridBagLayout());
		quanPane1.setLayout(new GridBagLayout());
		addItem(quanPane1, new JLabel("Phường:"), 0, 0, 1, 1, GridBagConstraints.EAST);
		addItem(quanPane, new JLabel("Quận:"), 0, 1, 1, 1, GridBagConstraints.EAST);
		addItem(quanPane1, cbPhuong2, 1, 0, 2, 1, GridBagConstraints.WEST);
		addItem(quanPane, cbQuan2, 1, 1, 2, 1, GridBagConstraints.WEST);

		list = khachHangDAO.getAllQuan();
		for (int i = 0; i < list.size(); i++) {
			cbQuan2.addItem(list.get(i));
		}
		cbQuan2.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					dtm2.setRowCount(0);
					ArrayList<KhachHang> listKH = baoCaoDAO.reportDSKHQuan(cbQuan2.getSelectedItem().toString());
					for (KhachHang khachHang1 : listKH) {
						dtm2.addRow(new String[] { khachHang1.getMaKhachHang(), khachHang1.getNameKhachHang(),
								khachHang1.getTenPhuong(), khachHang1.getTenQuan() });
					}
				}

			}
		});
		list1 = baoCaoDAO.getAllPhuong();
		for (int i = 0; i < list1.size(); i++) {
			cbPhuong2.addItem(list1.get(i));
		}
		cbPhuong2.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					dtm2.setRowCount(0);
					ArrayList<KhachHang> listKH = baoCaoDAO.reportDSKHPhuong(cbPhuong2.getSelectedItem().toString());
					for (KhachHang khachHang1 : listKH) {
						dtm2.addRow(new String[] { khachHang1.getMaKhachHang(), khachHang1.getNameKhachHang(),
								khachHang1.getTenPhuong(), khachHang1.getTenQuan() });
					}
				}
			}
		});

		quanPaneChung.add(quanPane1);
		quanPaneChung.add(quanPane);
		card3.add(quanPaneChung);
		card3.setPreferredSize(new Dimension(1000, 650));
		quanPane1.setBackground(Color.WHITE);
		quanPane.setBackground(Color.WHITE);
		quanPaneChung.setBackground(Color.WHITE);
		card3.setLayout(new BoxLayout(card3, BoxLayout.Y_AXIS));

		// PHẦN HIỂN THỊ DANH SÁCH KHÁCH HÀNG
		tablePane2 = new JPanel();
		Border border3 = BorderFactory.createLineBorder(Color.RED);
		TitledBorder titledBorder3 = BorderFactory.createTitledBorder(border3, "Dánh sách khách hàng");
		dtm2 = new DefaultTableModel();
		dtm2.addColumn("Mã khách hàng");
		dtm2.addColumn("Tên khách hàng");
		dtm2.addColumn("Phường");
		dtm2.addColumn("Quận");

		tablePane2.setBorder(titledBorder3);
		jTable2 = new JTable(dtm2);
		jTable2.setDefaultEditor(Object.class, null);
		jTable2.getTableHeader().setReorderingAllowed(false);
		JScrollPane jScrollPane2 = new JScrollPane(jTable2);
		jScrollPane2.setPreferredSize(new Dimension(1000, 400));
		tablePane2.add(jScrollPane2);
		card3.setLayout(new BoxLayout(card3, BoxLayout.Y_AXIS));
		card3.add(tablePane2);

		// *************BÁO CÁO TÌNH HÌNH KHÁCH HÀNG TIÊU THỤ********************
		JPanel card4 = new JPanel();

		// PHẦN TIÊU ĐỀ
		JPanel titlePan4 = new JPanel();
		JLabel txtTitle4 = new JLabel("DANH SÁCH TIÊU THỤ CỦA KHÁCH HÀNG");
		txtTitle4.setFont(new Font("Serif", Font.BOLD, 20));
		titlePan4.add(txtTitle4);
		titlePan4.setBackground(Color.WHITE);
		card4.add(titlePan4);

		// PHẦN RADIO
		cbQuan5 = new JComboBox<>();
		cbPhuong5 = new JComboBox<>();
		txtMaKhachHang1 = new JTextField(15);
		txtChuKyNhap7 = new JTextField(15);
		txtChuKyNhap9 = new JTextField(15);
		txtChuKyNhap8 = new JTextField(15);
		txtChuKyNhaP8 = new JTextField(15);

		JPanel rdoPane = new JPanel();
		JPanel rdoPane1 = new JPanel();
		Border bor = BorderFactory.createLineBorder(Color.RED);
		TitledBorder titlebor = new TitledBorder(bor, "Khách Hàng:");
		rdoPane.setBorder(titlebor);
		Border bor1 = BorderFactory.createLineBorder(Color.RED);
		TitledBorder titlebor1 = new TitledBorder(bor1, "Thời gian:");
		rdoPane1.setBorder(titlebor1);
		rdoPane.setLayout(new GridBagLayout());
		rdoPane1.setLayout(new GridBagLayout());
		addItem(rdoPane, rad1 = new JRadioButton("Tất cả khách hàng"), 0, 0, 1, 1, GridBagConstraints.WEST);
		addItem(rdoPane, rad2 = new JRadioButton("Khách hàng theo khu vực Quận"), 0, 1, 1, 1, GridBagConstraints.WEST);
		addItem(rdoPane, rad3 = new JRadioButton("Khách hàng theo khu vực Phường"), 0, 2, 1, 1,
				GridBagConstraints.WEST);
		addItem(rdoPane, rad4 = new JRadioButton("Khách hàng cụ thể"), 0, 3, 1, 1, GridBagConstraints.WEST);
		addItem(rdoPane1, rad5 = new JRadioButton("Theo năm"), 0, 0, 1, 1, GridBagConstraints.WEST);
		addItem(rdoPane1, rad6 = new JRadioButton("Theo khoảng thời gian: Từ tháng/năm:"), 0, 1, 1, 1,
				GridBagConstraints.WEST);
		addItem(rdoPane1, new JLabel("Đến tháng/năm:"), 0, 2, 1, 1, GridBagConstraints.EAST);
		addItem(rdoPane1, rad7 = new JRadioButton("Theo chu kỳ (Chọn tháng - năm)"), 0, 3, 1, 1,
				GridBagConstraints.WEST);

		addItem(rdoPane, cbQuan5, 1, 1, 1, 1, GridBagConstraints.WEST);
		addItem(rdoPane, cbPhuong5, 1, 2, 2, 1, GridBagConstraints.WEST);
		addItem(rdoPane, txtMaKhachHang1, 1, 3, 2, 1, GridBagConstraints.WEST);
		addItem(rdoPane1, txtChuKyNhap7, 1, 0, 2, 1, GridBagConstraints.WEST);
		addItem(rdoPane1, txtChuKyNhap8, 1, 1, 2, 1, GridBagConstraints.WEST);
		addItem(rdoPane1, txtChuKyNhaP8, 1, 2, 2, 1, GridBagConstraints.WEST);
		addItem(rdoPane1, txtChuKyNhap9, 1, 3, 2, 1, GridBagConstraints.WEST);

		list = khachHangDAO.getAllQuan();
		for (int i = 0; i < list.size(); i++) {
			cbQuan5.addItem(list.get(i));
		}

		list1 = baoCaoDAO.getAllPhuong();
		for (int i = 0; i < list1.size(); i++) {
			cbPhuong5.addItem(list1.get(i));
		}

		grouprdo = new ButtonGroup();
		grouprdo.add(rad1);
		grouprdo.add(rad2);
		grouprdo.add(rad3);
		grouprdo.add(rad4);
		group1rdo = new ButtonGroup();
		group1rdo.add(rad5);
		group1rdo.add(rad6);
		group1rdo.add(rad7);
		JPanel PaneChungrdo = new JPanel();
		PaneChungrdo.add(rdoPane);
		PaneChungrdo.add(rdoPane1);
		rad1.setBackground(Color.WHITE);
		rad2.setBackground(Color.WHITE);
		rad3.setBackground(Color.WHITE);
		rad4.setBackground(Color.WHITE);
		rad5.setBackground(Color.WHITE);
		rad6.setBackground(Color.WHITE);
		rad7.setBackground(Color.WHITE);
		rdoPane.setBackground(Color.WHITE);
		rdoPane1.setBackground(Color.WHITE);
		PaneChungrdo.setBackground(Color.WHITE);

		rad1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cbQuan5.setEnabled(false);
				cbPhuong5.setEnabled(false);
				txtMaKhachHang1.setEditable(false);
			}
		});

		rad2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cbQuan5.setEnabled(true);
				cbPhuong5.setEnabled(false);
				txtMaKhachHang1.setEditable(false);
			}
		});

		rad4.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cbQuan5.setEnabled(false);
				cbPhuong5.setEnabled(false);
				txtMaKhachHang1.setEditable(true);
			}
		});

		rad5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				txtChuKyNhap7.setEditable(true);
				txtChuKyNhap8.setEditable(false);
				txtChuKyNhaP8.setEditable(false);
				txtChuKyNhap9.setEditable(false);
			}
		});

		rad6.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				txtChuKyNhap7.setEditable(false);
				txtChuKyNhap8.setEditable(true);
				txtChuKyNhaP8.setEditable(true);
				txtChuKyNhap9.setEditable(false);
			}
		});

		rad7.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				txtChuKyNhap7.setEditable(false);
				txtChuKyNhap8.setEditable(false);
				txtChuKyNhaP8.setEditable(false);
				txtChuKyNhap9.setEditable(true);
			}
		});

		rad3.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				cbQuan5.setEnabled(false);
				cbPhuong5.setEnabled(true);
				txtMaKhachHang1.setEditable(false);
			}
		});
		card4.add(PaneChungrdo);

		// PHẦN NÚT HIỂN THỊ DANH SÁCH
		JPanel paneBT = new JPanel();
		btdanhsach = new JButton("Xem danh sách");
		paneBT.add(btdanhsach);
		paneBT.setBackground(Color.WHITE);
		card4.add(paneBT);

		// PHẦN HIỂN THỊ DANH SÁCH KHÁCH HÀNG
		tablePane4 = new JPanel();
		Border border4 = BorderFactory.createLineBorder(Color.RED);
		TitledBorder titledBorder4 = BorderFactory.createTitledBorder(border4, "Danh sách khách hàng");
		dtm4 = new DefaultTableModel();
		dtm4.addColumn("Mã khách hàng");
		dtm4.addColumn("Họ tên khách hàng");
		dtm4.addColumn("Phường");
		dtm4.addColumn("Quận");
		dtm4.addColumn("Mã Công tơ");
		dtm4.addColumn("Chu kỳ nhập");
		dtm4.addColumn("Chỉ số công tơ");
		dtm4.addColumn("Thành tiền");

		tablePane4.setBorder(titledBorder4);
		jTable4 = new JTable(dtm4);
		jTable4.setDefaultEditor(Object.class, null);
		jTable4.getTableHeader().setReorderingAllowed(false);
		JScrollPane jScrollPane4 = new JScrollPane(jTable4);
		jScrollPane4.setPreferredSize(new Dimension(1000, 400));
		tablePane4.add(jScrollPane4);
		card4.setLayout(new BoxLayout(card4, BoxLayout.Y_AXIS));
		card4.add(tablePane4);

		// **************************QUẢN LÝ CÔNG TƠ ĐIỆN******************************
		JPanel card5 = new JPanel();

		JPanel titlePan5 = new JPanel();
		JLabel txtTitle5 = new JLabel("QUẢN LÝ CÔNG TƠ ĐIỆN");
		txtTitle5.setFont(new Font("Serif", Font.BOLD, 20));
		titlePan5.add(txtTitle5);
		titlePan5.setBackground(Color.WHITE);
		card5.add(titlePan5);

		// PHẦN NHẬP DỮ LIỆU
		txtMaCongToDien = new JTextField(15);

		Panectdien = new JPanel();
		Panectdien.setLayout(new GridBagLayout());
		addItem(Panectdien, new JLabel("Mã công tơ (*):"), 0, 0, 1, 1, GridBagConstraints.EAST);

		addItem(Panectdien, txtMaCongToDien, 1, 0, 2, 1, GridBagConstraints.WEST);

		Panectdien.setBackground(Color.WHITE);
		card5.add(Panectdien);

		JPanel PaneInfor5 = new JPanel();
		JLabel lbinfor5 = new JLabel("(*) Thông tin cần phải nhập");
		PaneInfor5.add(lbinfor5);
		PaneInfor5.setBackground(Color.WHITE);
		card5.add(PaneInfor5);

		// PHẦN NÚT THÊM SỬA XÓA
		btPane5 = new JPanel();
		btAdd5 = new JButton("Thêm");
		btRepair5 = new JButton("Sửa");
		btDelete5 = new JButton("Xóa");
		btfind5 = new JButton("Tìm kiếm");
		btLamMoi5 = new JButton("Làm mới");
		btExit5 = new JButton("Thoát");
		btPane5.add(btAdd5);
		btPane5.add(btRepair5);
		btPane5.add(btDelete5);

		btPane5.add(btLamMoi5);
		btPane5.add(btExit5);
		pnCenter.add(btPane5);
		btPane5.setBackground(Color.WHITE);

		btRepair5.setEnabled(false);
		btDelete5.setEnabled(false);

		btLamMoi5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				btAdd5.setEnabled(true);
				btRepair5.setEnabled(false);
				btDelete5.setEnabled(false);
			}
		});

		card5.add(btPane5);

		JPanel PaneBT5 = new JPanel();
		lbTKiem5 = new JLabel("Tìm kiếm:");
		btfind5 = new JButton("Tìm kiếm thông tin");
		txtTimKiem5 = new JTextField(15);
		PaneBT5.add(lbTKiem5);
		PaneBT5.add(txtTimKiem5);
		PaneBT5.add(btfind5);
		PaneBT5.setBackground(Color.WHITE);
		card5.add(PaneBT5);

		// PHẦN HIỂN THỊ DANH SÁCH
		tablePane5 = new JPanel();
		Border border5 = BorderFactory.createLineBorder(Color.RED);
		TitledBorder titledBorder5 = BorderFactory.createTitledBorder(border, "Danh sách công tơ");

		dtm5 = new DefaultTableModel();
		dtm5.addColumn("Mã Công tơ");

		tablePane5.setBorder(titledBorder5);
		jTable5 = new JTable(dtm5);
		jTable5.setDefaultEditor(Object.class, null);
		jTable5.getTableHeader().setReorderingAllowed(false);
		JScrollPane jScrollPane5 = new JScrollPane(jTable5);
		jScrollPane5.setPreferredSize(new Dimension(200, 400));
		tablePane5.add(jScrollPane5);

		jTable5.addMouseListener(new MouseListener() {
			public void mouseReleased(MouseEvent e) {
			}

			public void mousePressed(MouseEvent e) {
			}

			public void mouseExited(MouseEvent e) {
			}

			public void mouseEntered(MouseEvent e) {
			}

			public void mouseClicked(MouseEvent e) {
				int row = jTable5.getSelectedRow();
				String s = (String) jTable5.getValueAt(row, 0);
				txtMaCongToDien.setText(s);

				btAdd5.setEnabled(false);
				btRepair5.setEnabled(true);
				btDelete5.setEnabled(true);
			}
		});

		ArrayList<CongToDien> list = congToDienDAO.getAllCongToDien();
		dtm5.setRowCount(0);
		for (CongToDien congToDien2 : list) {
			dtm5.addRow(new String[] { congToDien2.getMaCongTo() });
		}
		card5.add(tablePane5);

		card5.setLayout(new BoxLayout(card5, BoxLayout.Y_AXIS));
		card5.setPreferredSize(new Dimension(1000, 650));

		// *******THÊM CÁC LAYOUT CON VÀ LAYOUT CHÍNH*********
		cardLayout = new CardLayout();
		cardPane.setLayout(cardLayout);
		cardPane.add(card0, "home");
		cardPane.add(card1, "khachHang");
		cardPane.add(card2, "bienLai");
		cardPane.add(card3, "baocaokh");
		cardPane.add(card4, "baocaokh1");
		cardPane.add(card5, "congtodien");

		pnCenter.add(cardPane);
		getContentPane().add(pnBorder);

		setAction();
	}

	/**
	 * THÊM CÁC SỰ KIỆN CHO CÁC NÚT
	 */
	public void setAction() {
		btKhachHang.addActionListener(this);
		btBienLai.addActionListener(this);
		btDSKHTQuan.addActionListener(this);
		btdsttdAll.addActionListener(this);
		btAdd.addActionListener(this);
		btAdd1.addActionListener(this);
		btfind.addActionListener(this);
		btLamMoi.addActionListener(this);
		btRepair.addActionListener(this);
		btDelete.addActionListener(this);
		btRepair1.addActionListener(this);
		btDelete1.addActionListener(this);
		btfind1.addActionListener(this);
		btExit.addActionListener(this);
		btdanhsach.addActionListener(this);
		btExit1.addActionListener(this);
		btCongToDien.addActionListener(this);
		btAdd5.addActionListener(this);
		btRepair5.addActionListener(this);
		btDelete5.addActionListener(this);
		btLamMoi5.addActionListener(this);
		btExit5.addActionListener(this);
		btfind5.addActionListener(this);
		btLamMoi1.addActionListener(this);
	}

	/**
	 * HIỂN THỊ CHƯƠNG TRÌNH
	 */
	public void display() {
		setSize(1600, 700);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public static void main(String[] args) {
		QuanLyTienDien qlDien = new QuanLyTienDien();
		qlDien.display();
	}

	/**
	 * TẠO CÁC SỰ KIỆN CHO CÁC NÚT
	 */
	@Override
	public void actionPerformed(ActionEvent e) {

		// SỰ KIỆN CÁC NÚT CHUYỂN QUA LẠI VỚI NHAU
		if (e.getSource() == btKhachHang) {
			list2 = congToDienDAO.getAllCongToDien();
			cbCongToDien.removeAllItems();
			cbCongToDien.addItem("Chọn mã công tơ");
			for (int i = 0; i < list2.size(); i++) {
				cbCongToDien.addItem(list2.get(i));
			}
			cardLayout.show(cardPane, "khachHang");
		}
		if (e.getSource() == btBienLai) {
			list2 = congToDienDAO.getAllCongToDien();
			cbCongToDien1.removeAllItems();
			cbCongToDien1.addItem("Chọn mã công tơ");
			for (int i = 0; i < list2.size(); i++) {
				cbCongToDien1.addItem(list2.get(i));
			}
			cardLayout.show(cardPane, "bienLai");
		}
		if (e.getSource() == btDSKHTQuan) {
			cardLayout.show(cardPane, "baocaokh");
		}
		if (e.getSource() == btdsttdAll) {
			cardLayout.show(cardPane, "baocaokh1");
		}
		if (e.getSource() == btdsttkhuvuc) {
			cardLayout.show(cardPane, "baocaokh2");
		}
		if (e.getSource() == btCongToDien) {
			cardLayout.show(cardPane, "congtodien");
		}

		// SỰ KIỆN NÚT THÊM KHÁCH HÀNG
		if (e.getSource() == btAdd) {
			KhachHang khachHang = new KhachHang();
			CongToDien congToDien = new CongToDien();
			khachHang.setMaKhachHang(txtMaKhachHang.getText());
			khachHang.setNameKhachHang(txtNameKhachHang.getText());
			khachHang.setAddress(txtDiachi.getText());
			khachHang.setTenPhuong(cbPhuong.getSelectedItem().toString());
			khachHang.setTenQuan(cbQuan.getSelectedItem().toString());
			khachHang.setPhone(txtDienthoai.getText());
			khachHang.setEmail(txtEmail.getText());
			congToDien.setMaCongTo(cbCongToDien.getSelectedItem().toString());
			khachHang.setMaCongTo(congToDien);
			if (txtMaKhachHang.getText().equals("") || txtNameKhachHang.getText().equals("")
					|| cbPhuong.getSelectedItem().toString().equals("")
					|| cbQuan.getSelectedItem().toString().equals("") || txtDienthoai.getText().equals("")
					|| cbCongToDien.getSelectedItem().toString().equals("")) {
				JOptionPane.showMessageDialog(null, "Bạn cần phải nhập vào trường còn trống");
			} else {
				if (khachHangDAO.addKhachHang(khachHang)) {
					JOptionPane.showMessageDialog(null, "Thêm thành công");
					txtMaKhachHang.setText("");
					txtNameKhachHang.setText("");
					txtDiachi.setText("");
					txtDienthoai.setText("");
					txtEmail.setText("");
					cbCongToDien.setSelectedItem("Chọn mã công tơ");

				} else {
					JOptionPane.showMessageDialog(null, "Mã công tơ hoặc mã khách hàng đã tồn tại");
				}
			}

			ArrayList<KhachHang> list = khachHangDAO.getAllKhachHang();
			dtm.setRowCount(0);
			for (KhachHang khachHang1 : list) {
				dtm.addRow(new String[] { khachHang1.getMaKhachHang(), khachHang1.getNameKhachHang(),
						khachHang1.getAddress(), khachHang1.getTenPhuong(), khachHang1.getTenQuan(),
						khachHang1.getPhone(), khachHang1.getEmail(), khachHang1.getMaCongTo().getMaCongTo() });
			}

		}

		// SỰ KIỆN NÚT TÌM KIẾM KHÁCH HÀNG
		if (e.getSource() == btfind) {
			KhachHang khachHang = new KhachHang();
			khachHang.setNameKhachHang(txtTimKiem.getText());
			khachHang.setTenPhuong(txtTimKiem.getText());
			khachHang.setTenQuan(txtTimKiem.getText());
			khachHang.setMaKhachHang(txtTimKiem.getText());

			if (txtTimKiem.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Bạn cần phải nhập vào tìm kiếm");
			} else {
				ArrayList<KhachHang> list = khachHangDAO.searchMaKH(khachHang);
				ArrayList<KhachHang> myList = new ArrayList<>();

				for (int j = 0; j < list.size(); j++) {
					if (!list.get(j).equals(txtTimKiem.getText())) {
						myList.add(list.get(j));
					}
				}
				if (myList.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Không có dữ liệu");
				} else {
					JOptionPane.showMessageDialog(null, "Tìm kiếm thành công");
					dtm.setRowCount(0);
					for (int j = 0; j < myList.size(); j++) {
						dtm.addRow(new String[] { myList.get(j).getMaKhachHang(), myList.get(j).getNameKhachHang(),
								myList.get(j).getAddress(), myList.get(j).getTenPhuong(), myList.get(j).getTenQuan(),
								myList.get(j).getPhone(), myList.get(j).getEmail(),
								myList.get(j).getMaCongTo().getMaCongTo() });
					}
				}
			}
		}

		// SỰ KIỆN NÚT LÀM MỚI
		if (e.getSource() == btLamMoi) {
			txtMaKhachHang.setText("");
			txtNameKhachHang.setText("");
			txtDiachi.setText("");
			txtDienthoai.setText("");
			txtEmail.setText("");
			cbQuan.setSelectedItem("Chọn Quận");
			cbPhuong.setSelectedItem("Chọn Phường");
			cbCongToDien.setSelectedItem("Chọn mã công tơ");
			ArrayList<KhachHang> list = khachHangDAO.getAllKhachHang();
			dtm.setRowCount(0);
			for (KhachHang khachHang1 : list) {
				dtm.addRow(new String[] { khachHang1.getMaKhachHang(), khachHang1.getNameKhachHang(),
						khachHang1.getAddress(), khachHang1.getTenPhuong(), khachHang1.getTenQuan(),
						khachHang1.getPhone(), khachHang1.getEmail(), khachHang1.getMaCongTo().getMaCongTo() });
			}
		}

		// SỰ KIỆN NÚT SỬA KHÁCH HÀNG
		if (e.getSource() == btRepair) {
			KhachHang khachHang = new KhachHang();
			CongToDien congToDien = new CongToDien();

			khachHang.setMaKhachHang(txtMaKhachHang.getText());
			khachHang.setNameKhachHang(txtNameKhachHang.getText());
			khachHang.setAddress(txtDiachi.getText());
			khachHang.setTenPhuong(cbPhuong.getSelectedItem().toString());
			khachHang.setTenQuan(cbQuan.getSelectedItem().toString());
			khachHang.setPhone(txtDienthoai.getText());
			khachHang.setEmail(txtEmail.getText());
			congToDien.setMaCongTo(cbCongToDien.getSelectedItem().toString());
			khachHang.setMaCongTo(congToDien);

			if (txtMaKhachHang.getText().equals("") || txtNameKhachHang.getText().equals("")
					|| cbPhuong.getSelectedItem().toString().equals("")
					|| cbQuan.getSelectedItem().toString().equals("") || txtDienthoai.getText().equals("")
					|| cbCongToDien.getSelectedItem().toString().equals("")) {
				JOptionPane.showMessageDialog(null, "Bạn cần phải nhập vào trường còn trống");
			} else {
				if (khachHangDAO.updateKhachHang(khachHang)) {
					int ret = JOptionPane.showConfirmDialog(null, "Bạn có muốn chắc sửa không?", "Sửa",
							JOptionPane.YES_NO_OPTION);
					if (ret == JOptionPane.YES_OPTION) {
						khachHangDAO.updateKhachHang(khachHang);
						JOptionPane.showMessageDialog(null, "Sửa thành công");
					} else if (ret == JOptionPane.NO_OPTION) {
						JOptionPane.showMessageDialog(null, "Sửa không thành công");
					}
				} else {
					JOptionPane.showMessageDialog(null, "Mã công tơ hoặc mã khách hàng đã tồn tại.");
				}
			}

			ArrayList<KhachHang> list = khachHangDAO.getAllKhachHang();
			dtm.setRowCount(0);
			for (KhachHang khachHang1 : list) {
				dtm.addRow(new String[] { khachHang1.getMaKhachHang(), khachHang1.getNameKhachHang(),
						khachHang1.getAddress(), khachHang1.getTenPhuong(), khachHang1.getTenQuan(),
						khachHang1.getPhone(), khachHang1.getEmail(), khachHang1.getMaCongTo().getMaCongTo() });
			}
		}

		// SỰ KIỆN NÚT XÓA KHÁCH HÀNG
		if (e.getSource() == btDelete) {

			int ret = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn xóa không?", "Xóa danh sách",
					JOptionPane.YES_NO_OPTION);
			if (ret == JOptionPane.YES_OPTION) {
				if (txtNameKhachHang.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Xóa thất bại. Bạn cần phải nhập tên khách hàng để xóa");
					txtNameKhachHang.requestFocus();
					return;
				}
				khachHangDAO.deleteKhachHang(txtNameKhachHang.getText());
				JOptionPane.showMessageDialog(null, "Xóa thành công");
			} else if (ret == JOptionPane.NO_OPTION) {
				JOptionPane.showMessageDialog(null, "Xóa thất bại");
			}

			ArrayList<KhachHang> list = khachHangDAO.getAllKhachHang();
			dtm.setRowCount(0);
			for (KhachHang khachHang1 : list) {
				dtm.addRow(new String[] { khachHang1.getMaKhachHang(), khachHang1.getNameKhachHang(),
						khachHang1.getAddress(), khachHang1.getTenPhuong(), khachHang1.getTenQuan(),
						khachHang1.getPhone(), khachHang1.getEmail(), khachHang1.getMaCongTo().getMaCongTo() });
			}
		}

		// SỰ KIỆN NÚT THOÁT
		if (e.getSource() == btExit) {
			int ret = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn quay lại trang chủ không?", "Thoát",
					JOptionPane.YES_NO_OPTION);
			if (ret == JOptionPane.YES_OPTION) {
				cardLayout.show(cardPane, "home");
			}
		}

		// SỰ KIỆN NÚT THÊM BIÊN LAI
		if (e.getSource() == btAdd1) {
			CongToDien congToDien = new CongToDien();
			BienLai bienlai = new BienLai();
			if (cbCongToDien1.getSelectedItem().equals("") || txtChuKyNhap.getText().equals("")
					|| datePicker.getJFormattedTextField().getText().equals("")
					|| txtChiSoCongTo.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Bạn cần phải nhập vào các trường còn trống.");
			}

			congToDien.setMaCongTo(cbCongToDien1.getSelectedItem().toString());
			SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
			Date parsed = null;

			try {
				parsed = format.parse(datePicker.getJFormattedTextField().getText());
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
			java.sql.Date sql = new java.sql.Date(parsed.getTime());
			bienlai.setChuKyNhap(txtChuKyNhap.getText());
			bienlai.setNgayNhap(sql);
			bienlai.setChiSoCongTo(txtChiSoCongTo.getText());

			if (bienLaiDao.addBienLai(bienlai, congToDien)) {
				JOptionPane.showMessageDialog(null, "Thêm thành công");
				txtMaBienLai.setText("");
				// datePicker.getJFormattedTextField().setText("");
				txtChuKyNhap.setText("");
				txtChiSoCongTo.setText("");
				cbCongToDien1.setSelectedItem("Chọn mã công tơ");
			} else {
				JOptionPane.showMessageDialog(null, "Thêm thất bại");
			}
			ArrayList<BienLai> list1 = bienLaiDao.getAllBienLai();
			dtm1.setRowCount(0);
			String datePattern = "dd-MM-yyyy";
			SimpleDateFormat dateFormatter = new SimpleDateFormat(datePattern);
			for (BienLai bienLai2 : list1) {
				dtm1.addRow(new String[] { "" + bienLai2.getMaBienLai(), bienLai2.getMaCongTo().getMaCongTo(),
						dateFormatter.format(bienLai2.getNgayNhap()), "" + bienLai2.getChuKyNhap(),
						bienLai2.getChiSoCongTo() });
			}
		}

		// SỰ KIỆN NÚT SỬA BIÊN LAI
		if (e.getSource() == btRepair1) {
			BienLai bienLai = new BienLai();

			if (cbCongToDien1.getSelectedItem().equals("") || txtChuKyNhap.getText().equals("")
					|| datePicker.getJFormattedTextField().getText().equals("")
					|| txtChiSoCongTo.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Bạn cần phải nhập vào các trường còn trống để sửa.");
			}

			bienLai.setMaBienLai((txtMaBienLai.getText()));
			SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
			Date parsed = null;

			try {
				parsed = format.parse(datePicker.getJFormattedTextField().getText());
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
			java.sql.Date sql = new java.sql.Date(parsed.getTime());
			bienLai.setChuKyNhap(txtChuKyNhap.getText());
			bienLai.setNgayNhap(sql);
			bienLai.setChiSoCongTo(txtChiSoCongTo.getText());

			if (bienLaiDao.updateBienLai(bienLai)) {
				int ret = JOptionPane.showConfirmDialog(null, "Bạn có muốn chắc sửa không?", "Sửa",
						JOptionPane.YES_NO_OPTION);
				if (ret == JOptionPane.YES_OPTION) {
					bienLaiDao.updateBienLai(bienLai);
					JOptionPane.showMessageDialog(null, "Sửa thành công");
				} else if (ret == JOptionPane.NO_OPTION) {
					JOptionPane.showMessageDialog(null, "Sửa không thành công");
				}
			}
			ArrayList<BienLai> list1 = bienLaiDao.getAllBienLai();
			dtm1.setRowCount(0);
			String datePattern = "dd-MM-yyyy";
			SimpleDateFormat dateFormatter = new SimpleDateFormat(datePattern);
			for (BienLai bienLai2 : list1) {
				dtm1.addRow(new String[] { "" + bienLai2.getMaBienLai(), bienLai2.getMaCongTo().getMaCongTo(),
						dateFormatter.format(bienLai2.getNgayNhap()), "" + bienLai2.getChuKyNhap(),
						bienLai2.getChiSoCongTo() });
			}
		}

		// SỰ KIẾN NÚT LÀM MỚI
		if (e.getSource() == btLamMoi1) {
			txtMaBienLai.setText("");
			txtChuKyNhap.setText("");
			txtChiSoCongTo.setText("");
			txtTimKiem1.setText("");
			cbCongToDien1.setSelectedItem("Chọn mã công tơ");

			ArrayList<BienLai> list = bienLaiDao.getAllBienLai();
			dtm1.setRowCount(0);
			for (BienLai bienLai : list) {
				dtm1.addRow(new String[] { "" + bienLai.getMaBienLai(), bienLai.getMaCongTo().getMaCongTo(),
						"" + bienLai.getNgayNhap(), "" + bienLai.getChuKyNhap(), bienLai.getChiSoCongTo() });
			}
		}

		// SỰ KIỆN NÚT XÓA BIÊN LAI
		if (e.getSource() == btDelete1) {
			BienLai bienLai = new BienLai();

			int ret = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn xóa không?", "Xóa danh sách",
					JOptionPane.YES_NO_OPTION);
			if (ret == JOptionPane.YES_OPTION) {
				if (txtMaBienLai.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Xóa thất bại. Bạn cần phải nhập mã biên lai để xóa");
					txtMaBienLai.requestFocus();
					return;
				}
				bienLai.setMaBienLai((txtMaBienLai.getText()));
				bienLaiDao.deleteBienLai(bienLai);
				JOptionPane.showMessageDialog(null, "Xóa thành công");
			} else if (ret == JOptionPane.NO_OPTION) {
				JOptionPane.showMessageDialog(null, "Xóa thất bại");
			}

			ArrayList<BienLai> list1 = bienLaiDao.getAllBienLai();
			dtm1.setRowCount(0);
			for (BienLai bienLai2 : list1) {
				dtm1.addRow(new String[] { "" + bienLai2.getMaBienLai(), bienLai2.getMaCongTo().getMaCongTo(),
						"" + bienLai2.getNgayNhap(), "" + bienLai2.getChuKyNhap(), bienLai2.getChiSoCongTo() });
			}

		}

		// SỰ KIỆN NÚT TÌM KIẾM BIÊN LAI
		if (e.getSource() == btfind1) {
			CongToDien congToDien = new CongToDien();
			BienLai bienLai = new BienLai();
			congToDien.setMaCongTo(txtTimKiem1.getText());
			bienLai.setMaBienLai(txtTimKiem1.getText());
			bienLai.setMaCongTo(congToDien);
			if (txtTimKiem1.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Bạn cần phải nhập vào tìm kiếm");
			} else {
				ArrayList<BienLai> list = bienLaiDao.searchBienLai(bienLai);
				ArrayList<BienLai> myList = new ArrayList<>();
				for (int i = 0; i < list.size(); i++) {
					if (!list.get(i).equals(txtTimKiem1.getText())) {
						myList.add(list.get(i));
					}
				}

				if (myList.isEmpty()) {
					JOptionPane.showMessageDialog(null, "không có dữ liệu.");
				} else {
					JOptionPane.showMessageDialog(null, "Tìm kiếm thành công");
					dtm1.setRowCount(0);
					for (int i = 0; i < myList.size(); i++) {
						dtm1.addRow(new String[] { "" + myList.get(i).getMaBienLai(),
								myList.get(i).getMaCongTo().getMaCongTo(), "" + myList.get(i).getNgayNhap(),
								"" + myList.get(i).getChuKyNhap(), myList.get(i).getChiSoCongTo() });
					}
				}
			}
		}

		// SỰ KIỆN NÚT THOÁT BIÊN LAI
		if (e.getSource() == btExit1) {
			int ret = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn quay lại trang chủ không?", "Thoát",
					JOptionPane.YES_NO_OPTION);
			if (ret == JOptionPane.YES_OPTION) {
				cardLayout.show(cardPane, "home");
			}
		}

		// SỰ KIỆN NÚT THÊM CÔNG TƠ ĐIỆN
		if (e.getSource() == btAdd5) {
			CongToDien congToDien = new CongToDien();
			congToDien.setMaCongTo(txtMaCongToDien.getText());
			if (txtMaCongToDien.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Bạn cần phải nhập vào trường còn trống");
			} else {
				if (congToDienDAO.addCongToDien(congToDien)) {
					JOptionPane.showMessageDialog(null, "Thêm thành công");

					txtMaCongToDien.setText("");
				} else {
					JOptionPane.showMessageDialog(null, "Mã công tơ hoặc mã khách hàng đã tồn tại");
				}
			}

			ArrayList<CongToDien> list = congToDienDAO.getAllCongToDien();
			dtm5.setRowCount(0);
			for (CongToDien congToDien2 : list) {
				dtm5.addRow(new String[] { congToDien2.getMaCongTo() });
			}
		}

		// SỰ KIỆN NÚT SỬA CÔNG TƠ ĐIỆN
		if (e.getSource() == btRepair5) {
			CongToDien congToDien = new CongToDien();
			congToDien.setMaCongTo(cbCongToDien.getSelectedItem().toString());

			if (cbCongToDien.getSelectedItem().toString().equals("")) {
				JOptionPane.showMessageDialog(null, "Bạn cần phải nhập vào trường còn trống");
			} else {
				if (congToDienDAO.updateCongToDien(congToDien)) {
					int ret = JOptionPane.showConfirmDialog(null, "Bạn có muốn chắc sửa không?", "Sửa",
							JOptionPane.YES_NO_OPTION);
					if (ret == JOptionPane.YES_OPTION) {
						congToDienDAO.updateCongToDien(congToDien);
						JOptionPane.showMessageDialog(null, "Sửa thành công");
					} else if (ret == JOptionPane.NO_OPTION) {
						JOptionPane.showMessageDialog(null, "Sửa không thành công");
					}
				}
			}
		}

		// SỰ KIỆN NÚT XÓA CÔNG TƠ ĐIỆN
		if (e.getSource() == btDelete5) {
			int ret = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn xóa không?", "Xóa danh sách",
					JOptionPane.YES_NO_OPTION);
			if (ret == JOptionPane.YES_OPTION) {
				if (txtMaCongToDien.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Xóa thất bại. Bạn cần phải nhập mã công tớ để xóa");
					txtMaCongToDien.requestFocus();
					return;
				} else if (congToDienDAO.deleteCongToDien(txtMaCongToDien.getText())) {
					JOptionPane.showMessageDialog(null, "Xóa thành công");
				} else {
					JOptionPane.showMessageDialog(null, "Không thể xóa được");
				}
			} else if (ret == JOptionPane.NO_OPTION) {
				JOptionPane.showMessageDialog(null, "Xóa thất bại");
			}

			ArrayList<CongToDien> list = congToDienDAO.getAllCongToDien();
			dtm5.setRowCount(0);
			for (CongToDien congToDien2 : list) {
				dtm5.addRow(new String[] { congToDien2.getMaCongTo() });
			}
		}

		// SỰ KIỆN LÀM MỚI
		if (e.getSource() == btLamMoi5) {
			txtMaCongToDien.setText("");
			txtTimKiem5.setText("");
			ArrayList<CongToDien> list = congToDienDAO.getAllCongToDien();
			dtm5.setRowCount(0);
			for (CongToDien congToDien2 : list) {
				dtm5.addRow(new String[] { congToDien2.getMaCongTo() });
			}
		}

		// SỰ KIỆN NÚT TÌM KIẾM CÔNG TƠ ĐIỆN
		if (e.getSource() == btfind5) {
			CongToDien congToDien = new CongToDien();
			congToDien.setMaCongTo(txtTimKiem5.getText());
			if (txtTimKiem5.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Bạn cần phải nhập vào tìm kiếm");
			} else {
				ArrayList<CongToDien> list = congToDienDAO.searchCongToDien(congToDien);
				ArrayList<CongToDien> myList = new ArrayList<>();
				for (int i = 0; i < list.size(); i++) {
					if (!list.get(i).equals(txtTimKiem1.getText())) {
						myList.add(list.get(i));
					}
				}

				if (myList.isEmpty()) {
					JOptionPane.showMessageDialog(null, "không có dữ liệu.");
				} else {
					JOptionPane.showMessageDialog(null, "Tìm kiếm thành công");
					dtm5.setRowCount(0);
					for (int i = 0; i < myList.size(); i++) {
						dtm5.addRow(new String[] { myList.get(i).getMaCongTo() });
					}
				}
			}
		}

		// SỰ KIỆN NÚT THOÁT
		if (e.getSource() == btExit5) {
			int ret = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn quay lại trang chủ không?", "Thoát",
					JOptionPane.YES_NO_OPTION);
			if (ret == JOptionPane.YES_OPTION) {
				cardLayout.show(cardPane, "home");
			}
		}

		// SỰ KIỆN NÚT DANH SÁCH KHÁCH HÀNG
		if (e.getSource() == btdanhsach) {
			if (grouprdo.getSelection() == null || group1rdo.getSelection() == null) {
				JOptionPane.showMessageDialog(null, "Bạn phải chọn.");
			} else {
				if (rad1.isSelected() && rad5.isSelected()) {
					dtm4.setRowCount(0);
					if (txtChuKyNhap7.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Bạn cần phải nhập năm");
					} else {
						ArrayList<KhachHang> listdsbc = tienDien.tienDien();
						ArrayList<KhachHang> myList = new ArrayList<>();

						for (int j = 0; j < listdsbc.size(); j++) {
							if (listdsbc.get(j).getBienLai().getChuKyNhap().split("-")[1]
									.equals(txtChuKyNhap7.getText())) {
								myList.add(listdsbc.get(j));
							}
						}

						if (myList.isEmpty()) {
							JOptionPane.showMessageDialog(null, "Không có dữ liệu.");
						} else {
							for (int j = 0; j < myList.size(); j++) {
								dtm4.addRow(new String[] { myList.get(j).getMaKhachHang(),
										myList.get(j).getNameKhachHang(), myList.get(j).getTenPhuong(),
										myList.get(j).getTenQuan(), myList.get(j).getMaCongTo().getMaCongTo(),
										"" + myList.get(j).getBienLai().getChuKyNhap(),
										myList.get(j).getBienLai().getChiSoCongTo(),
										"" + myList.get(j).getTienDien() });
							}
						}
					}
				}

				if (rad1.isSelected() && rad6.isSelected()) {
					dtm4.setRowCount(0);
					SimpleDateFormat formatter = new SimpleDateFormat("MM-yyyy");
					Date min = null, max = null, d = null;
					try {
						min = formatter.parse(txtChuKyNhap8.getText());
						max = formatter.parse(txtChuKyNhaP8.getText());
					} catch (ParseException e1) {
						e1.printStackTrace();
					}
					if (txtChuKyNhap8.getText().equals("") || txtChuKyNhaP8.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Bạn cần phải nhập vào các trường.");
					} else {
						ArrayList<KhachHang> listdsbc = tienDien.tienDien();
						ArrayList<KhachHang> myList = new ArrayList<>();

						for (int i = 0; i < listdsbc.size(); i++) {
							try {
								d = formatter.parse(listdsbc.get(i).getBienLai().getChuKyNhap());
							} catch (ParseException e1) {
								e1.printStackTrace();
							}
							if (d.after(min) && d.before(max)) {
								myList.add(listdsbc.get(i));
							}
						}
						if (myList.isEmpty()) {
							JOptionPane.showMessageDialog(null, "Không có dữ liệu.");
						} else {
							for (int i = 0; i < myList.size(); i++) {
								dtm4.addRow(new String[] { myList.get(i).getMaKhachHang(),
										myList.get(i).getNameKhachHang(), myList.get(i).getTenPhuong(),
										myList.get(i).getTenQuan(), myList.get(i).getMaCongTo().getMaCongTo(),
										"" + myList.get(i).getBienLai().getChuKyNhap(),
										myList.get(i).getBienLai().getChiSoCongTo(),
										"" + myList.get(i).getTienDien() });
							}
						}
					}
				}

				if (rad1.isSelected() && rad7.isSelected()) {
					dtm4.setRowCount(0);
					if (txtChuKyNhap9.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Bạn cần phải nhập chu kỳ.");
					} else {
						ArrayList<KhachHang> listdsbc = tienDien.tienDien();
						ArrayList<KhachHang> myList = new ArrayList<>();

						for (int j = 0; j < listdsbc.size(); j++) {
							if (listdsbc.get(j).getBienLai().getChuKyNhap().equals(txtChuKyNhap9.getText())) {
								myList.add(listdsbc.get(j));
							}
						}
						if (myList.isEmpty()) {
							JOptionPane.showMessageDialog(null, "Không có dữ liệu.");
						} else {
							for (int j = 0; j < myList.size(); j++) {
								dtm4.addRow(new String[] { myList.get(j).getMaKhachHang(),
										myList.get(j).getNameKhachHang(), myList.get(j).getTenPhuong(),
										myList.get(j).getTenQuan(), myList.get(j).getMaCongTo().getMaCongTo(),
										"" + myList.get(j).getBienLai().getChuKyNhap(),
										myList.get(j).getBienLai().getChiSoCongTo(),
										"" + myList.get(j).getTienDien() });
							}
						}
					}
				}

				if (rad2.isSelected() && rad5.isSelected()) {
					dtm4.setRowCount(0);
					if (txtChuKyNhap7.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Bạn cần phải nhập năm.");
					} else {
						ArrayList<KhachHang> listdsbc = tienDien.tienDien();
						ArrayList<KhachHang> myList = new ArrayList<>();

						for (int j = 0; j < listdsbc.size(); j++) {
							if (listdsbc.get(j).getTenQuan().equals(cbQuan5.getSelectedItem().toString())
									&& listdsbc.get(j).getBienLai().getChuKyNhap().split("-")[1]
											.equals(txtChuKyNhap7.getText())) {
								myList.add(listdsbc.get(j));
							}
						}

						if (myList.isEmpty()) {
							JOptionPane.showMessageDialog(null, "Không có dữ liệu.");
						} else {
							for (int j = 0; j < myList.size(); j++)
								dtm4.addRow(new String[] { myList.get(j).getMaKhachHang(),
										myList.get(j).getNameKhachHang(), myList.get(j).getTenPhuong(),
										myList.get(j).getTenQuan(), myList.get(j).getMaCongTo().getMaCongTo(),
										"" + myList.get(j).getBienLai().getChuKyNhap(),
										myList.get(j).getBienLai().getChiSoCongTo(),
										"" + myList.get(j).getTienDien() });
						}
					}
				}

				if (rad2.isSelected() && rad6.isSelected()) {
					dtm4.setRowCount(0);
					SimpleDateFormat formatter = new SimpleDateFormat("MM-yyyy");
					Date min = null, max = null, d = null;
					try {
						min = formatter.parse(txtChuKyNhap8.getText());
						max = formatter.parse(txtChuKyNhaP8.getText());
					} catch (ParseException e1) {
						e1.printStackTrace();
					}
					if (txtChuKyNhap8.getText().equals("") || txtChuKyNhaP8.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Bạn cần phải nhập vào các trường.");
					} else {
						ArrayList<KhachHang> listdsbc = tienDien.tienDien();
						ArrayList<KhachHang> myList = new ArrayList<>();

						for (int j = 0; j < listdsbc.size(); j++) {
							try {
								d = formatter.parse(listdsbc.get(j).getBienLai().getChuKyNhap());
							} catch (ParseException e1) {
								e1.printStackTrace();
							}
							if (listdsbc.get(j).getTenQuan().equals(cbQuan5.getSelectedItem().toString())
									&& d.after(min) && d.before(max)) {
								myList.add(listdsbc.get(j));
							}
						}

						if (myList.isEmpty()) {
							JOptionPane.showMessageDialog(null, "Không có dữ liệu.");
						} else {
							for (int j = 0; j < myList.size(); j++)
								dtm4.addRow(new String[] { myList.get(j).getMaKhachHang(),
										myList.get(j).getNameKhachHang(), myList.get(j).getTenPhuong(),
										myList.get(j).getTenQuan(), myList.get(j).getMaCongTo().getMaCongTo(),
										"" + myList.get(j).getBienLai().getChuKyNhap(),
										myList.get(j).getBienLai().getChiSoCongTo(),
										"" + myList.get(j).getTienDien() });
						}
					}
				}

				if (rad2.isSelected() && rad7.isSelected()) {
					dtm4.setRowCount(0);
					if (txtChuKyNhap9.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Bạn cần phải nhập chu kỳ.");
					} else {
						ArrayList<KhachHang> listdsbc = tienDien.tienDien();
						ArrayList<KhachHang> myList = new ArrayList<>();

						for (int j = 0; j < listdsbc.size(); j++) {
							if (listdsbc.get(j).getTenQuan().equals(cbQuan5.getSelectedItem().toString())
									&& listdsbc.get(j).getBienLai().getChuKyNhap().equals(txtChuKyNhap9.getText())) {
								myList.add(listdsbc.get(j));
							}
						}

						if (myList.isEmpty()) {
							JOptionPane.showMessageDialog(null, "Không có dữ liệu.");
						} else {
							for (int j = 0; j < myList.size(); j++)
								dtm4.addRow(new String[] { myList.get(j).getMaKhachHang(),
										myList.get(j).getNameKhachHang(), myList.get(j).getTenPhuong(),
										myList.get(j).getTenQuan(), myList.get(j).getMaCongTo().getMaCongTo(),
										"" + myList.get(j).getBienLai().getChuKyNhap(),
										myList.get(j).getBienLai().getChiSoCongTo(),
										"" + myList.get(j).getTienDien() });
						}
					}
				}

				if (rad3.isSelected() && rad5.isSelected()) {
					dtm4.setRowCount(0);
					if (txtChuKyNhap7.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Bạn cần phải nhập năm.");
					} else {
						ArrayList<KhachHang> listdsbc = tienDien.tienDien();
						ArrayList<KhachHang> myList = new ArrayList<>();

						for (int j = 0; j < listdsbc.size(); j++) {
							if (listdsbc.get(j).getTenPhuong().equals(cbPhuong5.getSelectedItem().toString())
									&& listdsbc.get(j).getBienLai().getChuKyNhap().split("-")[1]
											.equals(txtChuKyNhap7.getText())) {
								myList.add(listdsbc.get(j));
							}
						}

						if (myList.isEmpty()) {
							JOptionPane.showMessageDialog(null, "Không có dữ liệu.");
						} else {
							for (int j = 0; j < myList.size(); j++)
								dtm4.addRow(new String[] { myList.get(j).getMaKhachHang(),
										myList.get(j).getNameKhachHang(), myList.get(j).getTenPhuong(),
										myList.get(j).getTenQuan(), myList.get(j).getMaCongTo().getMaCongTo(),
										"" + myList.get(j).getBienLai().getChuKyNhap(),
										myList.get(j).getBienLai().getChiSoCongTo(),
										"" + myList.get(j).getTienDien() });
						}
					}
				}

				if (rad3.isSelected() && rad6.isSelected()) {
					dtm4.setRowCount(0);
					SimpleDateFormat formatter = new SimpleDateFormat("MM-yyyy");
					Date min = null, max = null, d = null;
					try {
						min = formatter.parse(txtChuKyNhap8.getText());
						max = formatter.parse(txtChuKyNhaP8.getText());
					} catch (ParseException e1) {
						e1.printStackTrace();
					}
					if (txtChuKyNhap8.getText().equals("") || txtChuKyNhaP8.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Bạn cần phải nhập vào các trường.");
					} else {
						ArrayList<KhachHang> listdsbc = tienDien.tienDien();
						ArrayList<KhachHang> myList = new ArrayList<>();

						for (int j = 0; j < listdsbc.size(); j++) {
							try {
								d = formatter.parse(listdsbc.get(j).getBienLai().getChuKyNhap());
							} catch (ParseException e1) {
								e1.printStackTrace();
							}
							if (listdsbc.get(j).getTenPhuong().equals(cbPhuong5.getSelectedItem().toString())
									&& d.after(min) && d.before(max)) {
								myList.add(listdsbc.get(j));
							}
						}

						if (myList.isEmpty()) {
							JOptionPane.showMessageDialog(null, "Không có dữ liệu.");
						} else {
							for (int j = 0; j < myList.size(); j++)
								dtm4.addRow(new String[] { myList.get(j).getMaKhachHang(),
										myList.get(j).getNameKhachHang(), myList.get(j).getTenPhuong(),
										myList.get(j).getTenQuan(), myList.get(j).getMaCongTo().getMaCongTo(),
										"" + myList.get(j).getBienLai().getChuKyNhap(),
										myList.get(j).getBienLai().getChiSoCongTo(),
										"" + myList.get(j).getTienDien() });
						}
					}
				}

				if (rad3.isSelected() && rad7.isSelected()) {
					dtm4.setRowCount(0);
					if (txtChuKyNhap9.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Bạn cần phải nhập chu kỳ.");
					} else {
						ArrayList<KhachHang> listdsbc = tienDien.tienDien();
						ArrayList<KhachHang> myList = new ArrayList<>();

						for (int j = 0; j < listdsbc.size(); j++) {
							if (listdsbc.get(j).getTenPhuong().equals(cbPhuong5.getSelectedItem().toString())
									&& listdsbc.get(j).getBienLai().getChuKyNhap().equals(txtChuKyNhap9.getText())) {
								myList.add(listdsbc.get(j));
							}
						}

						if (myList.isEmpty()) {
							JOptionPane.showMessageDialog(null, "Không có dữ liệu.");
						} else {
							for (int j = 0; j < myList.size(); j++)
								dtm4.addRow(new String[] { myList.get(j).getMaKhachHang(),
										myList.get(j).getNameKhachHang(), myList.get(j).getTenPhuong(),
										myList.get(j).getTenQuan(), myList.get(j).getMaCongTo().getMaCongTo(),
										"" + myList.get(j).getBienLai().getChuKyNhap(),
										myList.get(j).getBienLai().getChiSoCongTo(),
										"" + myList.get(j).getTienDien() });
						}
					}
				}

				if (rad4.isSelected() && rad5.isSelected()) {
					dtm4.setRowCount(0);
					if (txtMaKhachHang1.getText().equals("") || txtChuKyNhap7.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Bạn cần phải nhập vào các trường.");
					} else {
						ArrayList<KhachHang> listdsbc = tienDien.tienDien();
						ArrayList<KhachHang> myList = new ArrayList<>();

						for (int j = 0; j < listdsbc.size(); j++) {
							if (listdsbc.get(j).getMaKhachHang().equals(txtMaKhachHang1.getText())
									&& listdsbc.get(j).getBienLai().getChuKyNhap().split("-")[1]
											.equals(txtChuKyNhap7.getText())) {
								myList.add(listdsbc.get(j));
							}
						}

						if (myList.isEmpty()) {
							JOptionPane.showMessageDialog(null, "Không có dữ liệu.");
						} else {
							for (int j = 0; j < myList.size(); j++) {
								dtm4.addRow(
										new String[] { myList.get(j).getMaKhachHang(), myList.get(j).getNameKhachHang(),
												myList.get(j).getAddress(), myList.get(j).getTenPhuong(),
												myList.get(j).getTenQuan(), myList.get(j).getMaCongTo().getMaCongTo(),
												"" + myList.get(j).getBienLai().getChuKyNhap(),
												myList.get(j).getBienLai().getChiSoCongTo(),
												"" + myList.get(j).getTienDien() });
							}
						}
					}
				}

				if (rad4.isSelected() && rad6.isSelected()) {
					dtm4.setRowCount(0);
					SimpleDateFormat formatter = new SimpleDateFormat("MM-yyyy");
					Date min = null, max = null, d = null;
					try {
						min = formatter.parse(txtChuKyNhap8.getText());
						max = formatter.parse(txtChuKyNhaP8.getText());
					} catch (ParseException e1) {
						e1.printStackTrace();
					}
					if (txtMaKhachHang1.getText().equals("") || txtChuKyNhap8.getText().equals("")
							|| txtChuKyNhaP8.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Bạn cần phải nhập vào các trường.");
					} else {
						ArrayList<KhachHang> listdsbc = tienDien.tienDien();
						ArrayList<KhachHang> myList = new ArrayList<>();

						for (int j = 0; j < listdsbc.size(); j++) {
							try {
								d = formatter.parse(listdsbc.get(j).getBienLai().getChuKyNhap());
							} catch (ParseException e1) {
								e1.printStackTrace();
							}
							if (listdsbc.get(j).getMaKhachHang().equals(txtMaKhachHang1.getText()) && d.after(min)
									&& d.before(max)) {
								myList.add(listdsbc.get(j));
							}
						}

						if (myList.isEmpty()) {
							JOptionPane.showMessageDialog(null, "Không có dữ liệu.");
						} else {
							for (int j = 0; j < myList.size(); j++) {
								dtm4.addRow(
										new String[] { myList.get(j).getMaKhachHang(), myList.get(j).getNameKhachHang(),
												myList.get(j).getAddress(), myList.get(j).getTenPhuong(),
												myList.get(j).getTenQuan(), myList.get(j).getMaCongTo().getMaCongTo(),
												"" + myList.get(j).getBienLai().getChuKyNhap(),
												myList.get(j).getBienLai().getChiSoCongTo(),
												"" + myList.get(j).getTienDien() });
							}
						}
					}
				}

				if (rad4.isSelected() && rad7.isSelected()) {
					dtm4.setRowCount(0);
					if (txtMaKhachHang1.getText().equals("") || txtChuKyNhap9.getText().equals("")) {
						JOptionPane.showMessageDialog(null, "Bạn cần phải nhập vào các trường.");
					} else {
						ArrayList<KhachHang> listdsbc = tienDien.tienDien();
						ArrayList<KhachHang> myList = new ArrayList<>();

						for (int j = 0; j < listdsbc.size(); j++) {
							if (listdsbc.get(j).getMaKhachHang().equals(txtMaKhachHang1.getText())
									&& listdsbc.get(j).getBienLai().getChuKyNhap().equals(txtChuKyNhap9.getText())) {
								myList.add(listdsbc.get(j));
							}
						}

						if (myList.isEmpty()) {
							JOptionPane.showMessageDialog(null, "Không có dữ liệu.");
						} else {
							for (int j = 0; j < myList.size(); j++) {
								dtm4.addRow(
										new String[] { myList.get(j).getMaKhachHang(), myList.get(j).getNameKhachHang(),
												myList.get(j).getAddress(), myList.get(j).getTenPhuong(),
												myList.get(j).getTenQuan(), myList.get(j).getMaCongTo().getMaCongTo(),
												"" + myList.get(j).getBienLai().getChuKyNhap(),
												myList.get(j).getBienLai().getChiSoCongTo(),
												"" + myList.get(j).getTienDien() });
							}
						}
					}
				}
			}
		}
	}
}
