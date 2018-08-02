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
import java.util.Date;
import java.util.Properties;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

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

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import QuanLyTienDien.model.BaoCaoDAO;
import QuanLyTienDien.model.BienLaiDAO;
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
			tablePane6, tablePane7, tablePane8, tablePane9, card0;
	JTextField txtMaCongTo, txtMaKhachHang, txtNameKhachHang, txtDiachi, txtDienthoai, txtEmail, txtMaCongTo1,
			txtChuKyNhap, txtChiSoCongTo, txtMaKhachHang1, txtChuKyNhap7, txtChuKyNhap8, txtChuKyNhaP8, txtChuKyNhap9,
			txtMaBienLai;
	JComboBox cbPhuong, cbQuan, cbPhuong2, cbQuan2, cbPhuong5, cbQuan5;
	JButton btAdd, btRepair, btDelete, btExit, btAdd1, btRepair1, btDelete1, btExit1, btKhachHang, btBienLai,
			btDSKHTQuan, btdsttdAll, btdsttkhuvuc, btdsttoneKH, btdstttheonam, btdstttkhoangtg, btdstttheoky, btdisplay,
			btdisplay7, btdisplay8, btdisplay9, btfind, btLamMoi, btfind1, btLamMoi1, btdanhsach;
	JTable jTable, jTable1, jTable2, jTable4, jTable5, jTable6, jTable7, jTable8, jTable9;
	DefaultTableModel dtm, dtm1, dtm2, dtm4, dtm5, dtm6, dtm7, dtm8, dtm9;
	KhachHangDAO khachHangDAO;
	BienLaiDAO bienLaiDao;
	BaoCaoDAO baoCaoDAO;
	ArrayList<Quan> list;
	ArrayList<Phuong> list1;
	TienDien tienDien;
	String tenQuan;
	UtilDateModel model;
	Properties p;
	JDatePanelImpl datePanel;
	JDatePickerImpl datePicker;

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
		btdsttdAll = new JButton("Tình hình tất cả khách hàng tiêu thụ");
		btdsttkhuvuc = new JButton("Khách hàng tiêu thụ theo khu vực");
		btdsttoneKH = new JButton("Tình hình tiêu thụ của 1 khách hàng");
		btdstttheonam = new JButton("Tình hình tiêu thụ theo năm");
		btdstttkhoangtg = new JButton("Tình hình tiêu thụ khoảng thời gian");
		btdstttheoky = new JButton("Tình hình tiêu thụ theo chu kỳ");
		JPanel layout = new JPanel();
		pnWest.setLayout(new BoxLayout(pnWest, BoxLayout.Y_AXIS));
		layout.add(lbQuanLy);
		layout.add(btKhachHang);
		layout.add(btBienLai);
		layout.add(lbBaoCao);
		layout.add(btDSKHTQuan);
		layout.add(btdsttdAll);
		layout.add(btdsttkhuvuc);
		layout.add(btdsttoneKH);
		layout.add(btdstttheonam);
		layout.add(btdstttkhoangtg);
		layout.add(btdstttheoky);
		btKhachHang.setPreferredSize(new Dimension(250, 30));
		btBienLai.setPreferredSize(new Dimension(250, 30));
		btDSKHTQuan.setPreferredSize(new Dimension(250, 30));
		btdsttdAll.setPreferredSize(new Dimension(250, 30));
		btdsttkhuvuc.setPreferredSize(new Dimension(250, 30));
		btdsttoneKH.setPreferredSize(new Dimension(250, 30));
		btdstttheonam.setPreferredSize(new Dimension(250, 30));
		btdstttkhoangtg.setPreferredSize(new Dimension(250, 30));
		btdstttheoky.setPreferredSize(new Dimension(250, 30));
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
		JLabel txtTitle = new JLabel("Quản lý khách hàng");
		txtTitle.setFont(new Font("Serif", Font.BOLD, 20));
		TitlePane.add(txtTitle);
		TitlePane.setBackground(Color.WHITE);
		card1.add(TitlePane);

		// CÁC TRƯỜNG NHẬP DỮ LIỆU
		txtMaCongTo = new JTextField(15);
		txtMaKhachHang = new JTextField(15);
		txtNameKhachHang = new JTextField(15);
		txtDiachi = new JTextField(15);
		cbPhuong = new JComboBox();
		cbQuan = new JComboBox();
		txtDienthoai = new JTextField(15);
		txtEmail = new JTextField(15);

		infoPane = new JPanel();
		JPanel info1 = new JPanel();
		infoPane.setLayout(new GridBagLayout());
		info1.setLayout(new GridBagLayout());
		addItem(infoPane, new JLabel("Mã Khách Hàng:"), 0, 0, 1, 1, GridBagConstraints.EAST);
		addItem(infoPane, new JLabel("Họ Tên Khách Hàng:"), 0, 1, 1, 1, GridBagConstraints.EAST);
		addItem(info1, new JLabel("Địa Chỉ:"), 0, 0, 1, 1, GridBagConstraints.EAST);
		addItem(info1, new JLabel("Phường:"), 0, 2, 1, 1, GridBagConstraints.EAST);
		addItem(info1, new JLabel("Quận:"), 0, 1, 1, 1, GridBagConstraints.EAST);
		addItem(info1, new JLabel("Điện thoại:"), 0, 3, 1, 1, GridBagConstraints.EAST);
		addItem(infoPane, new JLabel("Email:"), 0, 2, 1, 1, GridBagConstraints.EAST);
		addItem(infoPane, new JLabel("Mã công tơ điện:"), 0, 3, 1, 1, GridBagConstraints.EAST);

		addItem(infoPane, txtMaKhachHang, 1, 0, 1, 1, GridBagConstraints.WEST);
		addItem(infoPane, txtNameKhachHang, 1, 1, 2, 1, GridBagConstraints.WEST);
		addItem(info1, txtDiachi, 1, 0, 2, 1, GridBagConstraints.WEST);
		addItem(info1, cbPhuong, 1, 2, 2, 1, GridBagConstraints.WEST);
		addItem(info1, cbQuan, 1, 1, 2, 1, GridBagConstraints.WEST);
		addItem(info1, txtDienthoai, 1, 3, 2, 1, GridBagConstraints.WEST);
		addItem(infoPane, txtEmail, 1, 2, 2, 1, GridBagConstraints.WEST);
		addItem(infoPane, txtMaCongTo, 1, 3, 2, 1, GridBagConstraints.WEST);

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
			}
		});
		list1 = khachHangDAO.getAllPhuong(cbQuan.getSelectedItem().toString());
		for (int i = 0; i < list1.size(); i++) {

			cbPhuong.addItem(list1.get(i));
		}
		JPanel infoChung = new JPanel();
		infoChung.setLayout(new BoxLayout(infoChung, BoxLayout.X_AXIS));
		infoChung.add(infoPane);
		infoChung.add(info1);
		info1.setBackground(Color.WHITE);
		infoPane.setBackground(Color.WHITE);
		card1.add(infoChung);

		// CÁC NÚT THÊM SỬA XÓA
		btPane = new JPanel();
		btAdd = new JButton("Thêm");
		btRepair = new JButton("Sửa");
		btDelete = new JButton("Xóa");
		btfind = new JButton("Tìm kiếm");
		btLamMoi = new JButton("Làm mới");
		btExit = new JButton("Thoát");
		btPane.add(btAdd);
		btPane.add(btRepair);
		btPane.add(btDelete);
		btPane.add(btfind);
		btPane.add(btLamMoi);
		btPane.add(btExit);
		pnCenter.add(btPane);
		btPane.setBackground(Color.WHITE);
		card1.add(btPane);

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
				txtMaCongTo.setText(s7);
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
		JLabel txtTitle1 = new JLabel("Quản lý biên lai");
		txtTitle1.setFont(new Font("Serif", Font.BOLD, 20));
		titlePane1.add(txtTitle1);
		titlePane1.setBackground(Color.WHITE);
		card2.add(titlePane1);

		// CÁC TRƯỜNG NHẬP DỮ LIỆU

		model = new UtilDateModel();
		p = new Properties();
		p.put("text.today", "today");
		p.put("text.month", "month");
		p.put("text.year", "year");
		datePanel = new JDatePanelImpl(model, p);
		datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
		datePicker.setBounds(230, 30, 110, 30);

		txtMaBienLai = new JTextField(15);
		txtMaCongTo1 = new JTextField(15);
		txtChuKyNhap = new JTextField(15);
		txtChiSoCongTo = new JTextField(15);

		infoPane1 = new JPanel();
		infoPane1.setLayout(new GridBagLayout());
		addItem(infoPane1, new JLabel("Mã biên lai"), 0, 0, 1, 1, GridBagConstraints.EAST);
		addItem(infoPane1, new JLabel("Mã Công Tơ:"), 0, 1, 1, 1, GridBagConstraints.EAST);
		addItem(infoPane1, new JLabel("Ngày nhập:"), 0, 2, 1, 1, GridBagConstraints.EAST);
		addItem(infoPane1, new JLabel("Chu kỳ nhập:"), 0, 3, 1, 1, GridBagConstraints.EAST);
		addItem(infoPane1, new JLabel("Chỉ số công tơ:"), 0, 4, 1, 1, GridBagConstraints.EAST);

		addItem(infoPane1, txtMaBienLai, 1, 0, 2, 1, GridBagConstraints.WEST);
		addItem(infoPane1, txtMaCongTo1, 1, 1, 2, 1, GridBagConstraints.WEST);
		addItem(infoPane1, datePicker, 1, 2, 1, 1, GridBagConstraints.WEST);
		addItem(infoPane1, txtChuKyNhap, 1, 3, 2, 1, GridBagConstraints.WEST);
		addItem(infoPane1, txtChiSoCongTo, 1, 4, 2, 1, GridBagConstraints.WEST);

		infoPane1.setBackground(Color.WHITE);
		card2.add(infoPane1);

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
		btPane1.add(btfind1);
		btPane1.add(btLamMoi1);
		btPane1.add(btExit1);
		pnCenter.add(btPane1);
		btPane1.setBackground(Color.WHITE);
		card2.add(btPane1);

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
				txtMaCongTo1.setText(s1);
				String s2 = (String) jTable1.getValueAt(row, 2);
				datePicker.getJFormattedTextField().setText(s2);
				String s3 = (String) jTable1.getValueAt(row, 3);
				txtChuKyNhap.setText(s3);
				String s4 = (String) jTable1.getValueAt(row, 4);
				txtChiSoCongTo.setText(s4);
			}
		});

		ArrayList<BienLai> listds1 = bienLaiDao.getAllBienLai();
		dtm1.setRowCount(0);
		for (BienLai bienLai : listds1) {
			dtm1.addRow(new String[] { "" + bienLai.getMaBienLai(), bienLai.getMaCongTo().getMaCongTo(),
					"" + bienLai.getNgayNhap(), "" + bienLai.getChuKyNhap(), bienLai.getChiSoCongTo() });
		}

		card2.setLayout(new BoxLayout(card2, BoxLayout.Y_AXIS));
		card2.add(tablePane1);
		card2.setPreferredSize(new Dimension(1000, 650));

		// ****************BÁO CÁO KHÁCH HÀNG THEO QUẬN, PHƯỜNG****************
		JPanel card3 = new JPanel();

		// PHẦN TIÊU ĐỀ
		JPanel titlePan3 = new JPanel();
		JLabel txtTitle3 = new JLabel("Danh sách khách hàng theo quận, phường");
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
		jScrollPane2.setPreferredSize(new Dimension(800, 400));
		tablePane2.add(jScrollPane2);
		card3.setLayout(new BoxLayout(card3, BoxLayout.Y_AXIS));
		card3.add(tablePane2);

		// *************BÁO CÁO TÌNH HÌNH KHÁCH HÀNG TIÊU THỤ********************
		JPanel card4 = new JPanel();

		// PHẦN TIÊU ĐỀ
		JPanel titlePan4 = new JPanel();
		JLabel txtTitle4 = new JLabel("Danh sách tiêu thụ của tất cả khách hàng");
		txtTitle4.setFont(new Font("Serif", Font.BOLD, 20));
		titlePan4.add(txtTitle4);
		card4.add(titlePan4);

		// PHẦN HIỂN THỊ DANH SÁCH KHÁCH HÀNG
		tablePane4 = new JPanel();
		Border border4 = BorderFactory.createLineBorder(Color.RED);
		TitledBorder titledBorder4 = BorderFactory.createTitledBorder(border4, "Danh sách khách hàng");
		dtm4 = new DefaultTableModel();
		dtm4.addColumn("Mã khách hàng");
		dtm4.addColumn("Họ tên khách hàng");
		dtm4.addColumn("Địa chỉ");
		dtm4.addColumn("Mã Công tơ");
		dtm4.addColumn("Chu kỳ nhập");
		dtm4.addColumn("Chỉ số công tơ");
		dtm4.addColumn("Thành tiền");

		tablePane4.setBorder(titledBorder4);
		jTable4 = new JTable(dtm4);
		jTable4.setDefaultEditor(Object.class, null);
		jTable4.getTableHeader().setReorderingAllowed(false);
		JScrollPane jScrollPane4 = new JScrollPane(jTable4);
		jScrollPane4.setPreferredSize(new Dimension(1000, 600));
		tablePane4.add(jScrollPane4);
		card4.setLayout(new BoxLayout(card4, BoxLayout.Y_AXIS));
		card4.add(tablePane4);

		ArrayList<KhachHang> listdsbc = tienDien.tienDien();
		for (int j = 0; j < listdsbc.size(); j++) {
			dtm4.addRow(new String[] { listdsbc.get(j).getMaKhachHang(), listdsbc.get(j).getNameKhachHang(),
					listdsbc.get(j).getAddress(), listdsbc.get(j).getMaCongTo().getMaCongTo(),
					"" + listdsbc.get(j).getBienLai().getChuKyNhap(), listdsbc.get(j).getBienLai().getChiSoCongTo(),
					"" + listdsbc.get(j).getTienDien() });
		}

		// ************BÁO CÁO KHÁCH HÀNG TIÊU THỤ THEO KHU VỰC*************
		JPanel card5 = new JPanel();

		// PHẦN TIÊU ĐỀ
		JPanel titlePan5 = new JPanel();
		JLabel txtTitle5 = new JLabel("Danh sách khách hàng tiêu thụ theo khu vực");
		txtTitle5.setFont(new Font("Serif", Font.BOLD, 20));
		titlePan5.add(txtTitle5);
		titlePan5.setBackground(Color.WHITE);
		card5.add(titlePan5);

		// PHẦN HIỂN THỊ COMBOBOX
		JPanel quanPaneChung5 = new JPanel();
		JPanel quanPane5 = new JPanel();
		JPanel quanPanE = new JPanel();
		cbPhuong5 = new JComboBox();
		cbQuan5 = new JComboBox();
		quanPane.setLayout(new GridBagLayout());
		quanPane1.setLayout(new GridBagLayout());

		addItem(quanPanE, new JLabel("Phường:"), 0, 0, 1, 1, GridBagConstraints.EAST);
		addItem(quanPane5, new JLabel("Quận:"), 0, 1, 1, 1, GridBagConstraints.EAST);
		addItem(quanPanE, cbPhuong5, 1, 0, 2, 1, GridBagConstraints.WEST);
		addItem(quanPane5, cbQuan5, 1, 1, 2, 1, GridBagConstraints.WEST);

		list = khachHangDAO.getAllQuan();
		for (int i = 0; i < list.size(); i++) {
			cbQuan5.addItem(list.get(i));
		}

		cbQuan5.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				tenQuan = cbQuan5.getSelectedItem().toString();
				cbPhuong5.removeAllItems();
				list1 = khachHangDAO.getAllPhuong(tenQuan);
				for (int i = 0; i < list1.size(); i++) {

					cbPhuong5.addItem(list1.get(i));
				}
			}
		});

		list1 = khachHangDAO.getAllPhuong(cbQuan5.getSelectedItem().toString());
		for (int i = 0; i < list1.size(); i++) {

			cbPhuong5.addItem(list1.get(i));
		}

		quanPaneChung5.add(quanPanE);
		quanPaneChung5.add(quanPane5);
		card5.add(quanPaneChung5);
		card5.setPreferredSize(new Dimension(1000, 650));
		quanPanE.setBackground(Color.WHITE);
		quanPane5.setBackground(Color.WHITE);
		quanPaneChung5.setBackground(Color.WHITE);
		card5.setLayout(new BoxLayout(card5, BoxLayout.Y_AXIS));

		// NÚT XEM DANH SÁCH
		JPanel paneBT = new JPanel();
		btdanhsach = new JButton("Xem danh sách");
		paneBT.add(btdanhsach);
		paneBT.setBackground(Color.WHITE);
		card5.add(paneBT);

		// PHẦN BẢNG HIỂN THỊ DANH SÁCH KHÁCH HÀNG
		tablePane5 = new JPanel();
		Border border5 = BorderFactory.createLineBorder(Color.RED);
		TitledBorder titledBorder5 = BorderFactory.createTitledBorder(border5, "Danh sách khách hàng");
		dtm5 = new DefaultTableModel();
		dtm5.addColumn("Mã khách hàng");
		dtm5.addColumn("Họ tên khách hàng");
		dtm5.addColumn("Địa chỉ");
		dtm5.addColumn("Phường");
		dtm5.addColumn("Quận");
		dtm5.addColumn("Mã công tơ");
		dtm5.addColumn("Chu kỳ nhập");
		dtm5.addColumn("Chỉ số công tơ");
		dtm5.addColumn("Thành tiền");

		tablePane5.setBorder(titledBorder5);
		jTable5 = new JTable(dtm5);
		jTable5.setDefaultEditor(Object.class, null);
		jTable5.getTableHeader().setReorderingAllowed(false);
		JScrollPane jScrollPane5 = new JScrollPane(jTable5);
		jScrollPane5.setPreferredSize(new Dimension(1000, 500));
		tablePane5.add(jScrollPane5);
		card5.setLayout(new BoxLayout(card5, BoxLayout.Y_AXIS));
		card5.add(tablePane5);

		// *****************BÁO CÁO TÌNH HÌNH CỦA 1 KHÁCH HÀNG******************
		JPanel card6 = new JPanel();

		// PHẦN TIÊU ĐỀ
		JPanel titlePan6 = new JPanel();
		JLabel txtTitle6 = new JLabel("Danh sách tiêu thụ của một khách hàng cụ thể");
		txtTitle6.setFont(new Font("Serif", Font.BOLD, 20));
		titlePan6.add(txtTitle6);
		titlePan6.setBackground(Color.WHITE);
		card6.add(titlePan6);

		// PHẦN NHẬP DỮ LIỆU
		txtMaKhachHang1 = new JTextField();
		JPanel txtPane6 = new JPanel();
		txtPane6.setLayout(new GridBagLayout());
		addItem(txtPane6, new JLabel("Mã khách hàng:"), 0, 0, 1, 1, GridBagConstraints.EAST);
		addItem(txtPane6, txtMaKhachHang1, 1, 0, 2, 1, GridBagConstraints.WEST);
		txtMaKhachHang1.setPreferredSize(new Dimension(200, 20));
		txtPane6.setBackground(Color.WHITE);
		card6.add(txtPane6);

		// NÚT XEM DANH SÁCH
		JPanel btPane6 = new JPanel();
		btdisplay = new JButton("Xem danh sách");
		btPane6.add(btdisplay);
		btPane6.setBackground(Color.WHITE);
		card6.add(btPane6);

		// PHẦN BẢNG HIỂN THỊ DANH SÁCH KHÁCH HÀNG
		tablePane6 = new JPanel();
		Border border6 = BorderFactory.createLineBorder(Color.RED);
		TitledBorder titledBorder6 = BorderFactory.createTitledBorder(border6, "Danh sách khách hàng");
		dtm6 = new DefaultTableModel();
		dtm6.addColumn("Mã khách hàng");
		dtm6.addColumn("Họ tên khách hàng");
		dtm6.addColumn("Địa chỉ");
		dtm6.addColumn("Phường");
		dtm6.addColumn("Quận");
		dtm6.addColumn("Mã công tơ");
		dtm6.addColumn("Chu kỳ nhập");
		dtm6.addColumn("Chỉ số công tơ");
		dtm6.addColumn("Thành tiền");

		tablePane6.setBorder(titledBorder6);
		jTable6 = new JTable(dtm6);
		jTable6.setDefaultEditor(Object.class, null);
		jTable6.getTableHeader().setReorderingAllowed(false);
		JScrollPane jScrollPane6 = new JScrollPane(jTable6);
		jScrollPane6.setPreferredSize(new Dimension(1000, 500));
		tablePane6.add(jScrollPane6);
		card6.setLayout(new BoxLayout(card6, BoxLayout.Y_AXIS));
		card6.add(tablePane6);

		// *********BÁO CÁO TÌNH HÌNH TIÊU THỊ ĐIỆN CỦA KHÁCH HÀNG THEO NĂM**********
		JPanel card7 = new JPanel();

		// PHẦN TIÊU ĐỀ
		JPanel titlePan7 = new JPanel();
		JLabel txtTitle7 = new JLabel("Danh sách tiêu thụ điện của khách hàng theo năm");
		txtTitle7.setFont(new Font("Serif", Font.BOLD, 20));
		titlePan7.add(txtTitle7);
		titlePan7.setBackground(Color.WHITE);
		card7.add(titlePan7);

		// PHẦN NHẬP DỮ LIỆU
		txtChuKyNhap7 = new JTextField();
		JPanel txtPane7 = new JPanel();
		txtPane7.setLayout(new GridBagLayout());
		addItem(txtPane7, new JLabel("Nhập Năm:"), 0, 0, 1, 1, GridBagConstraints.EAST);
		addItem(txtPane7, txtChuKyNhap7, 1, 0, 2, 1, GridBagConstraints.WEST);
		txtChuKyNhap7.setPreferredSize(new Dimension(200, 20));
		txtPane7.setBackground(Color.WHITE);
		card7.add(txtPane7);

		// PHẦN NÚT XEM DANH SÁCH
		JPanel btPane7 = new JPanel();
		btdisplay7 = new JButton("Xem danh sách");
		btPane7.add(btdisplay7);
		btPane7.setBackground(Color.WHITE);
		card7.add(btPane7);

		// PHẦN BẢNG HIỂN THỊ DANH SÁCH KHÁCH HÀNG
		tablePane7 = new JPanel();
		Border border7 = BorderFactory.createLineBorder(Color.RED);
		TitledBorder titledBorder7 = BorderFactory.createTitledBorder(border7, "Danh sách khách hàng");
		dtm7 = new DefaultTableModel();
		dtm7.addColumn("Mã khách hàng");
		dtm7.addColumn("Họ tên khách hàng");
		dtm7.addColumn("Địa chỉ");
		dtm7.addColumn("Mã công tơ");
		dtm7.addColumn("Chu kỳ");
		dtm7.addColumn("Chỉ số công tơ");
		dtm7.addColumn("Thành tiền");

		tablePane7.setBorder(titledBorder7);
		jTable7 = new JTable(dtm7);
		jTable7.setDefaultEditor(Object.class, null);
		jTable7.getTableHeader().setReorderingAllowed(false);
		JScrollPane jScrollPane7 = new JScrollPane(jTable7);
		jScrollPane7.setPreferredSize(new Dimension(1000, 500));
		tablePane7.add(jScrollPane7);
		card7.setLayout(new BoxLayout(card7, BoxLayout.Y_AXIS));
		card7.add(tablePane7);

		// ***********BÁO CÁO TÌNH HÌNH KHÁCH HÀNG TIÊU THỤ TRONG KHOẢNG THỜI GIAN*****
		JPanel card8 = new JPanel();

		// PHẦN TIÊU ĐỀ
		JPanel titlePan8 = new JPanel();
		JLabel txtTitle8 = new JLabel("Danh sách khách hàng tiêu thụ theo khoảng thời gian");
		txtTitle8.setFont(new Font("Serif", Font.BOLD, 20));
		titlePan8.add(txtTitle8);
		titlePan8.setBackground(Color.WHITE);
		card8.add(titlePan8);

		// PHẦN NHẬP DỮ LIỆU
		txtChuKyNhap8 = new JTextField();
		txtChuKyNhaP8 = new JTextField();
		JPanel txtPane8 = new JPanel();
		txtPane8.setLayout(new GridBagLayout());
		addItem(txtPane8, new JLabel("Từ tháng/năm:"), 0, 0, 1, 1, GridBagConstraints.EAST);
		addItem(txtPane8, txtChuKyNhap8, 1, 0, 2, 1, GridBagConstraints.WEST);
		addItem(txtPane8, new JLabel("Đến tháng/năm:"), 0, 1, 1, 1, GridBagConstraints.EAST);
		addItem(txtPane8, txtChuKyNhaP8, 1, 1, 2, 1, GridBagConstraints.WEST);
		txtChuKyNhap8.setPreferredSize(new Dimension(200, 20));
		txtChuKyNhaP8.setPreferredSize(new Dimension(200, 20));
		txtPane8.setBackground(Color.WHITE);
		card8.add(txtPane8);

		// PHẦN NÚT XEM DANH SÁCH
		JPanel btPane8 = new JPanel();
		btdisplay8 = new JButton("Xem danh sách");
		btPane8.add(btdisplay8);
		btPane8.setBackground(Color.WHITE);
		card8.add(btPane8);

		// PHẦN BẢNG HIỂN THỊ DANH SÁCH
		tablePane8 = new JPanel();
		Border border8 = BorderFactory.createLineBorder(Color.RED);
		TitledBorder titledBorder8 = BorderFactory.createTitledBorder(border8, "Danh sách khách hàng");
		dtm8 = new DefaultTableModel();
		dtm8.addColumn("Mã khách hàng");
		dtm8.addColumn("Họ tên khách hàng");
		dtm8.addColumn("Địa chỉ");
		dtm8.addColumn("Mã công tơ");
		dtm8.addColumn("Chu kỳ");
		dtm8.addColumn("Chỉ số công tơ");
		dtm8.addColumn("Thành tiền");

		tablePane8.setBorder(titledBorder8);
		jTable8 = new JTable(dtm8);
		jTable8.setDefaultEditor(Object.class, null);
		jTable8.getTableHeader().setReorderingAllowed(false);
		JScrollPane jScrollPane8 = new JScrollPane(jTable8);
		jScrollPane8.setPreferredSize(new Dimension(1000, 500));
		tablePane8.add(jScrollPane8);
		card8.setLayout(new BoxLayout(card8, BoxLayout.Y_AXIS));
		card8.add(tablePane8);

		// ********BÁO CÁO TÌNH HÌNH KHÁCH HÀNG TIÊU THỤ THEO CHU KỲ*************
		JPanel card9 = new JPanel();

		// PHẨN TIÊU ĐỀ
		JPanel titlePan9 = new JPanel();
		JLabel txtTitle9 = new JLabel("Danh sách khách hàng tiêu thụ theo chu kỳ");
		txtTitle9.setFont(new Font("Serif", Font.BOLD, 20));
		titlePan9.add(txtTitle9);
		titlePan9.setBackground(Color.WHITE);
		card9.add(titlePan9);

		// PHẦN NHẬP DỮ LIỆU
		txtChuKyNhap9 = new JTextField();
		JPanel txtPane9 = new JPanel();
		txtPane9.setLayout(new GridBagLayout());
		addItem(txtPane9, new JLabel("Chu kỳ nhập:"), 0, 0, 1, 1, GridBagConstraints.EAST);
		addItem(txtPane9, txtChuKyNhap9, 1, 0, 2, 1, GridBagConstraints.WEST);
		txtChuKyNhap9.setPreferredSize(new Dimension(200, 20));
		txtPane9.setBackground(Color.WHITE);
		card9.add(txtPane9);

		// PHẦN NÚT XEM DANH SÁCH
		JPanel btPane9 = new JPanel();
		btdisplay9 = new JButton("Xem danh sách");
		btPane9.add(btdisplay9);
		btPane9.setBackground(Color.WHITE);
		card9.add(btPane9);

		// PHẦN BẢNG HIỂN THỊ XEM DANH SÁCH KHÁCH HÀNG
		tablePane9 = new JPanel();
		Border border9 = BorderFactory.createLineBorder(Color.RED);
		TitledBorder titledBorder9 = BorderFactory.createTitledBorder(border9, "Danh sách khách hàng");
		dtm9 = new DefaultTableModel();
		dtm9.addColumn("Mã khách hàng");
		dtm9.addColumn("Họ tên khách hàng");
		dtm9.addColumn("Địa chỉ");
		dtm9.addColumn("Mã công tơ");
		dtm9.addColumn("Chu kỳ");
		dtm9.addColumn("Chỉ số công tơ");
		dtm9.addColumn("Thành tiền");

		tablePane9.setBorder(titledBorder9);
		jTable9 = new JTable(dtm9);
		jTable9.setDefaultEditor(Object.class, null);
		jTable9.getTableHeader().setReorderingAllowed(false);
		JScrollPane jScrollPane9 = new JScrollPane(jTable9);
		jScrollPane9.setPreferredSize(new Dimension(1000, 500));
		tablePane9.add(jScrollPane9);
		card9.setLayout(new BoxLayout(card9, BoxLayout.Y_AXIS));
		card9.add(tablePane9);

		// *******THÊM CÁC LAYOUT CON VÀ LAYOUT CHÍNH*********
		cardLayout = new CardLayout();
		cardPane.setLayout(cardLayout);
		cardPane.add(card0, "home");
		cardPane.add(card1, "khachHang");
		cardPane.add(card2, "bienLai");
		cardPane.add(card3, "baocaokh");
		cardPane.add(card4, "baocaokh1");
		cardPane.add(card5, "baocaokh2");
		cardPane.add(card6, "baocaokh3");
		cardPane.add(card7, "baocaokh4");
		cardPane.add(card8, "baocaokh5");
		cardPane.add(card9, "baocaokh6");

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
		btdsttkhuvuc.addActionListener(this);
		btdsttoneKH.addActionListener(this);
		btdstttheonam.addActionListener(this);
		btdstttkhoangtg.addActionListener(this);
		btdstttheoky.addActionListener(this);
		btAdd.addActionListener(this);
		btAdd1.addActionListener(this);
		btfind.addActionListener(this);
		btLamMoi.addActionListener(this);
		btRepair.addActionListener(this);
		btDelete.addActionListener(this);
		btRepair1.addActionListener(this);
		btLamMoi1.addActionListener(this);
		btDelete1.addActionListener(this);
		btfind1.addActionListener(this);
		btdisplay.addActionListener(this);
		btExit.addActionListener(this);
		btdanhsach.addActionListener(this);
		btdisplay7.addActionListener(this);
		btdisplay9.addActionListener(this);
		btdisplay8.addActionListener(this);
		btExit1.addActionListener(this);
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
			cardLayout.show(cardPane, "khachHang");
		}
		if (e.getSource() == btBienLai) {
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
		if (e.getSource() == btdsttoneKH) {
			cardLayout.show(cardPane, "baocaokh3");
		}
		if (e.getSource() == btdstttheonam) {
			cardLayout.show(cardPane, "baocaokh4");
		}
		if (e.getSource() == btdstttkhoangtg) {
			cardLayout.show(cardPane, "baocaokh5");
		}
		if (e.getSource() == btdstttheoky) {
			cardLayout.show(cardPane, "baocaokh6");
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
			congToDien.setMaCongTo(txtMaCongTo.getText());
			khachHang.setMaCongTo(congToDien);
			if (txtMaKhachHang.getText().equals("") || txtNameKhachHang.getText().equals("")
					|| cbPhuong.getSelectedItem().toString().equals("")
					|| cbQuan.getSelectedItem().toString().equals("") || txtDienthoai.getText().equals("")
					|| txtMaCongTo.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Bạn cần phải nhập vào trường còn trống");
			} else {
				if (khachHangDAO.addKhachHang(khachHang)) {
					JOptionPane.showMessageDialog(null, "Thêm thành công");
				} else {
					JOptionPane.showMessageDialog(null, "Mã công tơ hoặc mã thành viên đã tồn tại");
				}
			}
			ArrayList<KhachHang> list = khachHangDAO.getAllKhachHang();
			dtm.setRowCount(0);
			for (KhachHang khachHang1 : list) {
				dtm.addRow(new String[] { khachHang1.getMaKhachHang(), khachHang1.getNameKhachHang(),
						khachHang1.getAddress(), khachHang1.getTenPhuong(), khachHang1.getTenQuan(),
						khachHang1.getPhone(), khachHang1.getEmail(), khachHang1.getMaCongTo().getMaCongTo() });
			}
			txtMaKhachHang.setText("");
			txtNameKhachHang.setText("");
			txtDiachi.setText("");
			txtDienthoai.setText("");
			txtEmail.setText("");
			txtMaCongTo.setText("");
		}

		// SỰ KIỆN NÚT TÌM KIẾM KHÁCH HÀNG
		if (e.getSource() == btfind) {
			KhachHang khachHang = new KhachHang();
			khachHang.setNameKhachHang(txtNameKhachHang.getText());
			if (txtNameKhachHang.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Bạn cần nhập tên khách hàng để tìm kiếm");
			} else {
				JOptionPane.showMessageDialog(null, "Tìm kiếm thành công");
				ArrayList<KhachHang> list = khachHangDAO.searchMaKH(khachHang);
				dtm.setRowCount(0);
				for (KhachHang khachHang1 : list) {
					dtm.addRow(new String[] { khachHang1.getMaKhachHang(), khachHang1.getNameKhachHang(),
							khachHang1.getAddress(), khachHang1.getTenPhuong(), khachHang1.getTenQuan(),
							khachHang1.getPhone(), khachHang1.getEmail(), khachHang1.getMaCongTo().getMaCongTo() });
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
			txtMaCongTo.setText("");

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
			congToDien.setMaCongTo(txtMaCongTo.getText());
			khachHang.setMaCongTo(congToDien);

			if (txtMaKhachHang.getText().equals("") || txtNameKhachHang.getText().equals("")
					|| cbPhuong.getSelectedItem().toString().equals("")
					|| cbQuan.getSelectedItem().toString().equals("") || txtDienthoai.getText().equals("")
					|| txtMaCongTo.getText().equals("")) {
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
			int ret = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn thoát không?", "Thoát",
					JOptionPane.YES_NO_OPTION);
			if (ret == JOptionPane.YES_OPTION) {
				System.exit(0);
			}
		}

		// SỰ KIỆN NÚT THÊM BIÊN LAI
		if (e.getSource() == btAdd1) {
			CongToDien congToDien = new CongToDien();
			BienLai bienlai = new BienLai();
			if (txtMaCongTo1.getText().equals("") || txtChuKyNhap.getText().equals("")
					|| datePicker.getJFormattedTextField().getText().equals("")
					|| txtChiSoCongTo.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Bạn cần phải nhập vào các trường còn trống.");
			}

			congToDien.setMaCongTo(txtMaCongTo1.getText());
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
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
			} else {
				JOptionPane.showMessageDialog(null, "Thêm thất bại");
			}
			ArrayList<BienLai> list1 = bienLaiDao.getAllBienLai();
			dtm1.setRowCount(0);
			for (BienLai bienLai2 : list1) {
				dtm1.addRow(new String[] { "" + bienLai2.getMaBienLai(), bienLai2.getMaCongTo().getMaCongTo(),
						"" + bienLai2.getNgayNhap(), "" + bienLai2.getChuKyNhap(), bienLai2.getChiSoCongTo() });
			}
			txtMaBienLai.setText("");
			txtMaCongTo1.setText("");
			datePicker.getJFormattedTextField().setText("");
			txtChuKyNhap.setText("");
			txtChiSoCongTo.setText("");

		}

		// SỰ KIỆN NÚT SỬA BIÊN LAI
		if (e.getSource() == btRepair1) {
			BienLai bienLai = new BienLai();

			if (txtMaCongTo1.getText().equals("") || txtChuKyNhap.getText().equals("")
					|| datePicker.getJFormattedTextField().getText().equals("")
					|| txtChiSoCongTo.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Bạn cần phải nhập vào các trường còn trống để sửa.");
			}

			bienLai.setMaBienLai(Integer.parseInt(txtMaBienLai.getText()));
			SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
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
			for (BienLai bienLai2 : list1) {
				dtm1.addRow(new String[] { "" + bienLai2.getMaBienLai(), bienLai2.getMaCongTo().getMaCongTo(),
						"" + bienLai2.getNgayNhap(), "" + bienLai2.getChuKyNhap(), bienLai2.getChiSoCongTo() });
			}

		}

		// SỰ KIẾN NÚT LÀM MỚI
		if (e.getSource() == btLamMoi1) {
			txtMaBienLai.setText("");
			txtMaCongTo1.setText("");
			datePicker.getJFormattedTextField().setText("");
			txtChuKyNhap.setText("");
			txtChiSoCongTo.setText("");

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
				if (txtNameKhachHang.getText().isEmpty()) {
					JOptionPane.showMessageDialog(null, "Xóa thất bại. Bạn cần phải nhập mã biên lai để xóa");
					txtMaBienLai.requestFocus();
					return;
				}
				bienLai.setMaBienLai(Integer.parseInt(txtMaBienLai.getText()));
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
			congToDien.setMaCongTo(txtMaCongTo1.getText());
			bienLai.setMaCongTo(congToDien);
			if (txtMaCongTo1.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Bạn cần phải nhập mã công tơ để tìm kiếm");
			} else {
				JOptionPane.showMessageDialog(null, "Tìm kiếm thành công");
				ArrayList<BienLai> list = bienLaiDao.searchBienLai(bienLai);
				dtm1.setRowCount(0);
				for (BienLai bienLai2 : list) {
					dtm1.addRow(new String[] { "" + bienLai2.getMaBienLai(), bienLai2.getMaCongTo().getMaCongTo(),
							"" + bienLai2.getNgayNhap(), "" + bienLai2.getChuKyNhap(), bienLai2.getChiSoCongTo() });
				}
			}
		}

		// SỰ KIỆN NÚT THOÁT BIÊN LAI
		if (e.getSource() == btExit1) {
			int ret = JOptionPane.showConfirmDialog(null, "Bạn có chắc muốn thoát không?", "Thoát",
					JOptionPane.YES_NO_OPTION);
			if (ret == JOptionPane.YES_OPTION) {
				System.exit(0);
			}
		}

		// SỰ KIỆN NÚT DANH SÁCH KHÁCH HÀNG THEO KHU VỰC
		if (e.getSource() == btdanhsach) {
			dtm5.setRowCount(0);
			if (cbPhuong5.getSelectedItem().toString().equals("")) {
				JOptionPane.showMessageDialog(null, "Bạn cần phải chọn phường.");
			} else {
				ArrayList<KhachHang> listdsbc = tienDien.tienDien();
				ArrayList<KhachHang> myList = new ArrayList<>();

				for (int j = 0; j < listdsbc.size(); j++) {
					if (listdsbc.get(j).getTenPhuong().equals(cbPhuong5.getSelectedItem().toString())) {
						myList.add(listdsbc.get(j));
					}
				}

				if (myList.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Không có dữ liệu.");
				} else {
					for (int j = 0; j < myList.size(); j++) {
						dtm5.addRow(new String[] { myList.get(j).getMaKhachHang(), myList.get(j).getNameKhachHang(),
								myList.get(j).getAddress(), myList.get(j).getTenPhuong(), myList.get(j).getTenQuan(),
								myList.get(j).getMaCongTo().getMaCongTo(),
								"" + myList.get(j).getBienLai().getChuKyNhap(),
								myList.get(j).getBienLai().getChiSoCongTo(), "" + myList.get(j).getTienDien() });
					}
				}
			}
		}

		// SỰ KIỆN NÚT XEM DANH SÁCH CỦA 1 KHÁCH HÀNG TIÊU THỤ

		if (e.getSource() == btdisplay) {

			dtm6.setRowCount(0);
			if (txtMaKhachHang1.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Bạn cần phải nhập mã khách hàng.");
			} else {
				ArrayList<KhachHang> listdsbc = tienDien.tienDien();
				ArrayList<KhachHang> myList = new ArrayList<>();

				for (int j = 0; j < listdsbc.size(); j++) {
					if (listdsbc.get(j).getMaKhachHang().equals(txtMaKhachHang1.getText())) {
						myList.add(listdsbc.get(j));
					}
				}

				if (myList.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Không có dữ liệu.");
				} else {
					for (int j = 0; j < myList.size(); j++) {
						dtm6.addRow(new String[] { myList.get(j).getMaKhachHang(), myList.get(j).getNameKhachHang(),
								myList.get(j).getAddress(), myList.get(j).getTenPhuong(), myList.get(j).getTenQuan(),
								myList.get(j).getMaCongTo().getMaCongTo(),
								"" + myList.get(j).getBienLai().getChuKyNhap(),
								myList.get(j).getBienLai().getChiSoCongTo(), "" + myList.get(j).getTienDien() });
					}
				}
			}

		}

		// SỰ KIỆN NÚT XEM DANH SÁCH KHÁCH HÀNG TIÊU THỤ THEO NĂM
		if (e.getSource() == btdisplay7) {
			dtm7.setRowCount(0);
			if (txtChuKyNhap7.getText().equals("")) {
				JOptionPane.showMessageDialog(null, "Bạn cần phải nhập năm");
			} else {
				ArrayList<KhachHang> listdsbc = tienDien.tienDien();
				ArrayList<KhachHang> myList = new ArrayList<>();

				for (int j = 0; j < listdsbc.size(); j++) {
					if (listdsbc.get(j).getBienLai().getChuKyNhap().split("-")[1].equals(txtChuKyNhap7.getText())) {
						myList.add(listdsbc.get(j));
					}
				}

				if (myList.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Không có dữ liệu.");
				} else {
					for (int j = 0; j < myList.size(); j++) {
						dtm7.addRow(new String[] { myList.get(j).getMaKhachHang(), myList.get(j).getNameKhachHang(),
								myList.get(j).getAddress(), myList.get(j).getMaCongTo().getMaCongTo(),
								"" + myList.get(j).getBienLai().getChuKyNhap(),
								myList.get(j).getBienLai().getChiSoCongTo(), "" + myList.get(j).getTienDien() });
					}
				}
			}
		}

		// SỰ KIỆN NÚT XEM DANH SÁCH KHÁCH HÀNG TIÊU THỤ KHOẢNG THỜI GIAN
		if (e.getSource() == btdisplay8) {
			dtm8.setRowCount(0);
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
						dtm8.addRow(new String[] { myList.get(i).getMaKhachHang(), myList.get(i).getNameKhachHang(),
								myList.get(i).getAddress(), myList.get(i).getMaCongTo().getMaCongTo(),
								"" + myList.get(i).getBienLai().getChuKyNhap(),
								myList.get(i).getBienLai().getChiSoCongTo(), "" + myList.get(i).getTienDien() });
					}
				}
			}
		}

		// SỰ KIỆN NÚT XEM DANH SÁCH KHÁCH HÀNG TIÊU THỤ THEO CHU KỲ
		if (e.getSource() == btdisplay9) {
			dtm9.setRowCount(0);
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
						dtm9.addRow(new String[] { myList.get(j).getMaKhachHang(), myList.get(j).getNameKhachHang(),
								myList.get(j).getAddress(), myList.get(j).getMaCongTo().getMaCongTo(),
								"" + myList.get(j).getBienLai().getChuKyNhap(),
								myList.get(j).getBienLai().getChiSoCongTo(), "" + myList.get(j).getTienDien() });
					}
				}
			}
		}
	}
}
