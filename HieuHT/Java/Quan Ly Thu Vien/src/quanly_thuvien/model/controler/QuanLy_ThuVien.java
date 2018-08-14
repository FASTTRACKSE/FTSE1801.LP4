package quanly_thuvien.model.controler;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
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

import quanly_thuvien.model.SachDao;
import quanly_thuvien.model.Tra_MuonDao;
import quanly_thuvien.model.banDocDao;
import quanly_thuvien.model.thuvienDao;
import quanly_thuvien.model.entity.Quan;
import quanly_thuvien.model.entity.QuanLySach;
import quanly_thuvien.model.entity.QuanLy_BanDoc;
import quanly_thuvien.model.entity.ThanhPho;
import quanly_thuvien.model.entity.TheLoaiSach;
import quanly_thuvien.model.entity.muon_TraSach;
import quanly_thuvien.model.entity.NhaXuatBan;
import quanly_thuvien.model.entity.Phuong;

/**
 * 
 * @author
 *
 */
public class QuanLy_ThuVien extends JFrame implements ActionListener {
	Container con = getContentPane();

	/**
	 * Khai báo biến
	 */
	CardLayout card;
	JPanel pnBorder, cardPanel, panel1, panel11, panel2, panel, panel3, sachPanel, sachPanel1, sachPanel2, QuanLyTTin,
			MuonTraSach, MuonTraSach1, MuonTraSach2, panelBaoCao, panelBaoCao1, panelBaoCao2, panelBaoCao3,
			panelBaoCao4, panelBaoCao5;
	JLabel labe1, label2;

	JButton buton, buton1, buton2, buton3, seach, themSach, suaSach, xoaSach, seachSach, thoat, mnuFileNew, mnuFileOpen,
			mnFile, menu, baocao, baocao1, themMuon, suaMuon, xoaMuon, Muon, listBaoCao, listBaoCao1;

	JTextField maThanhVien, maThanhVien1, maThanhVien2, tenThanhVien, DiaChi, DienThoai, Email, maSach, maSach1,
			tenSach, tacGia, namXuatBan, soLuong, maGiaoDich, ngayMuon, tacGia1;

	JComboBox ThanhPho, ThanhPho1, Quan, Phuong, theLoaiSach, nhaXuatBan, theLoaiSach1, nhaXuatBan1;
	DefaultTableModel model, model1, model2, model3, model4;

	thuvienDao thuVienDao;
	SachDao sachDao;
	banDocDao banDoc;
	Tra_MuonDao dao;
	ArrayList<ThanhPho> list;
	ArrayList<Quan> list1;
	ArrayList<Phuong> list2;
	String tenThanhPho = null;
	String tenQuanHuyen = null;
	ArrayList<NhaXuatBan> list3;
	ArrayList<TheLoaiSach> list4;
	String NhaXuatBan = null;
	String NhaXuatBan1 = null;

	/**
	 * Lấy dữ liệu combobox từ quận huyện.
	 */
	ItemListener itemListener = new ItemListener() {
		public void itemStateChanged(ItemEvent e) {
			if (e.getStateChange() == ItemEvent.SELECTED) {
				tenThanhPho = e.getItem().toString();
				Quan.removeAllItems();
				list1 = thuVienDao.getQuan(tenThanhPho);
				for (int i = 0; i < list1.size(); i++) {
					Quan.addItem(list1.get(i).getTenQuanHuyen());
				}
				// JOptionPane.showMessageDialog(null, tenThanhPho + " aaa");
			}
		}
	};

	/**
	 * Lấy dữ liệu combobox từ phường xã.
	 */
	ItemListener itemListener1 = new ItemListener() {
		public void itemStateChanged(ItemEvent e) {
			if (e.getStateChange() == ItemEvent.SELECTED) {
				tenQuanHuyen = e.getItem().toString();
				Phuong.removeAllItems();
				list2 = thuVienDao.getPhuong(tenQuanHuyen);
				for (int i = 0; i < list2.size(); i++) {
					Phuong.addItem(list2.get(i).getTenPhuongXa());
				}
				// JOptionPane.showMessageDialog(null, tenThanhPho + " aaa");
			}

		}
	};

	/**
	 * Lấy dữ liệu từ thể loại sách
	 */
	ItemListener itemListener2 = new ItemListener() {
		public void itemStateChanged(ItemEvent e) {
			if (e.getStateChange() == ItemEvent.SELECTED) {
				theLoaiSach.removeAllItems();
				NhaXuatBan = e.getItem().toString();

				list4 = sachDao.getTheLoaiSach(NhaXuatBan);
				for (int i = 0; i < list4.size(); i++) {
					theLoaiSach.addItem(list4.get(i).getTheLoaiSach());

				}
			}
		}
	};

	ItemListener itemListener3 = new ItemListener() {
		public void itemStateChanged(ItemEvent e) {
			if (e.getStateChange() == ItemEvent.SELECTED) {
				theLoaiSach1.removeAllItems();
				NhaXuatBan1 = e.getItem().toString();

				list4 = sachDao.getTheLoaiSach(NhaXuatBan1);
				for (int i = 0; i < list4.size(); i++) {
					theLoaiSach1.addItem(list4.get(i).getTheLoaiSach());

				}
			}
		}
	};

	public QuanLy_ThuVien() {

		super("Phầm Mềm Quản Lý Thư Viện Điện Tử");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		thuVienDao = new thuvienDao();
		sachDao = new SachDao();
		banDoc = new banDocDao();
		dao = new Tra_MuonDao();
		/**
		 * Phần tiêu đề
		 */
		JPanel pnNorth = new JPanel();
		JLabel label = new JLabel("Quản Lý Thư Viện");
		pnNorth.add(label);
		pnBorder = new JPanel();
		pnBorder.setLayout(new BorderLayout());
		pnNorth.setBackground(Color.pink);
		pnBorder.add(pnNorth, BorderLayout.NORTH);

		/**
		 * Thanh Công cụ bên trái.
		 */
		JPanel pnWest = new JPanel();
		JPanel jpanel = new JPanel();
		pnWest.setLayout(new BorderLayout());
		pnWest.setLayout(new BoxLayout(pnWest, BoxLayout.Y_AXIS));
		pnWest.setPreferredSize(new Dimension(200, 50));
		menu = new JButton("Trang Chủ");
		menu.setPreferredSize(new Dimension(200, 40));
		mnuFileNew = new JButton("Quản Lý Thông Tin Bạn Đọc");
		mnuFileNew.setPreferredSize(new Dimension(200, 40));
		mnuFileOpen = new JButton("Quản Lý Sách");
		mnuFileOpen.setPreferredSize(new Dimension(200, 40));
		mnFile = new JButton("Quản Lý Mượn, Trả Sách");
		mnFile.setPreferredSize(new Dimension(200, 40));
		baocao = new JButton("Danh Sách Bạn Đọc");
		baocao.setPreferredSize(new Dimension(200, 40));
		baocao1 = new JButton("Thống Kê Đầu Sách");
		baocao1.setPreferredSize(new Dimension(200, 40));
		jpanel.add(menu);
		jpanel.add(mnuFileNew);
		jpanel.add(mnuFileOpen);
		jpanel.add(mnFile);
		jpanel.add(baocao);
		jpanel.add(baocao1);
		jpanel.setBackground(new Color(174, 234, 245));
		pnWest.add(jpanel);
		pnBorder.add(pnWest);
		pnWest.setBackground(Color.DARK_GRAY);
		pnBorder.add(pnWest, BorderLayout.WEST);

		/**
		 * Giao diện
		 */
		JPanel pnCenter = new JPanel();
		pnBorder.add(pnCenter, BorderLayout.CENTER);
		cardPanel = new JPanel();
		pnCenter.add(cardPanel);
		pnBorder.add(pnCenter);

		/**
		 * Buton Trang Chủ.
		 */
		panel3 = new JPanel();
		ImageIcon img1 = new ImageIcon("F:\\thuvien.jpg");
		JLabel lblImg1 = new JLabel(img1);
		panel3.add(lblImg1);

		/**
		 * Buton Quản Lý Thông Tin Bạn Đọc.
		 */
		maThanhVien = new JTextField(15);
		tenThanhVien = new JTextField(15);
		DiaChi = new JTextField(15);
		ThanhPho = new JComboBox();
		ThanhPho.setPreferredSize(new Dimension(170, 20));
		/**
		 * Lấy dữ liệu thành phố từ Database.
		 */
		list = thuVienDao.getCiTy();
		for (int i = 0; i < list.size(); i++) {
			ThanhPho.addItem(list.get(i).getTenThanhPho());
		}
		/***********************************/
		Quan = new JComboBox<>();
		Quan.setPreferredSize(new Dimension(170, 20));
		Phuong = new JComboBox<>();
		Phuong.setPreferredSize(new Dimension(170, 20));
		/**
		 * Lấy dữ liệu quân_huyện,phường_xã từ Database.
		 */
		ThanhPho.addItemListener(itemListener);
		Quan.addItemListener(itemListener1);
		/**********************************/
		DienThoai = new JTextField(15);
		Email = new JTextField(15);
		panel = new JPanel();
		JLabel label2 = new JLabel("Quản Lý Người Dùng");
		panel.add(label2);
		panel.setLayout(new BorderLayout());
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		QuanLyTTin = new JPanel();
		QuanLyTTin.setLayout(new BorderLayout());
		QuanLyTTin.setLayout(new BoxLayout(QuanLyTTin, BoxLayout.X_AXIS));

		/**********************************/
		panel1 = new JPanel();
		panel1.setLayout(new BorderLayout());
		panel1.setLayout(new BoxLayout(panel1, BoxLayout.Y_AXIS));
		panel1.setLayout(new GridBagLayout());
		addItem(panel1, new JLabel("Mã Thành Viên:"), 0, 0, 1, 1, GridBagConstraints.EAST);
		addItem(panel1, new JLabel("Tên Thành viên:"), 0, 1, 1, 1, GridBagConstraints.EAST);
		addItem(panel1, new JLabel("Điện Thoại:"), 0, 2, 1, 1, GridBagConstraints.EAST);
		addItem(panel1, new JLabel("Email:"), 0, 3, 1, 1, GridBagConstraints.EAST);

		addItem(panel1, maThanhVien, 1, 0, 2, 1, GridBagConstraints.WEST);
		addItem(panel1, tenThanhVien, 1, 1, 1, 1, GridBagConstraints.WEST);
		addItem(panel1, DienThoai, 1, 2, 1, 1, GridBagConstraints.WEST);
		addItem(panel1, Email, 1, 3, 2, 1, GridBagConstraints.WEST);
		/**********************************/
		panel11 = new JPanel();
		panel11.setLayout(new BorderLayout());
		panel11.setLayout(new BoxLayout(panel11, BoxLayout.Y_AXIS));
		panel11.setLayout(new GridBagLayout());
		addItem(panel11, new JLabel("Thành Phố:"), 0, 0, 1, 1, GridBagConstraints.EAST);
		addItem(panel11, new JLabel("Quận:"), 0, 1, 1, 1, GridBagConstraints.EAST);
		addItem(panel11, new JLabel("Phườ" + "ng:"), 0, 2, 1, 1, GridBagConstraints.EAST);
		addItem(panel11, new JLabel("Địa Chỉ:"), 0, 3, 1, 1, GridBagConstraints.EAST);

		addItem(panel11, ThanhPho, 1, 0, 2, 1, GridBagConstraints.WEST);
		addItem(panel11, Quan, 1, 1, 1, 1, GridBagConstraints.WEST);
		addItem(panel11, Phuong, 1, 2, 2, 1, GridBagConstraints.WEST);
		addItem(panel11, DiaChi, 1, 3, 2, 1, GridBagConstraints.WEST);
		/**********************************/
		panel2 = new JPanel();
		buton = new JButton("Thêm Thành Viên");
		buton1 = new JButton("Sửa Thành Viên");
		buton2 = new JButton("Xóa Thành Viên");
		seach = new JButton("Tìm Kiếm");
		buton3 = new JButton("Hiển Thị Danh Sách");

		panel2.add(buton);
		panel2.add(buton1);
		panel2.add(buton2);
		panel2.add(seach);
		panel2.add(buton3);
		QuanLyTTin.add(panel1);
		QuanLyTTin.add(panel11);
		panel.add(QuanLyTTin);
		panel.add(panel2);
		/**********************************/
		JPanel pnTable = new JPanel();
		Border border = BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitle = BorderFactory.createTitledBorder(border, "Danh sách");
		model = new DefaultTableModel();
		model.addColumn("Mã thành viên");
		model.addColumn("Tên thành viên");
		model.addColumn("Địa chỉ");
		model.addColumn("Phường");
		model.addColumn("Quận");
		model.addColumn("Thành Phố");
		model.addColumn("Điện Thoai");
		model.addColumn("Email");

		JTable tbl = new JTable(model);
		tbl.getTableHeader().setReorderingAllowed(false);
		tbl.setDefaultEditor(Object.class, null);
		JScrollPane sc = new JScrollPane(tbl);
		sc.setPreferredSize(new Dimension(750, 300));
		pnTable.setBackground(Color.white);
		pnTable.setBorder(borderTitle);
		pnTable.add(sc);
		panel.add(pnTable);
		/**********************************
		 * Kết Thúc Quản Lý Bạn Đọc
		 ***************************************/

		/**
		 * Quản Lý Sách
		 * 
		 */
		maSach = new JTextField(15);
		tenSach = new JTextField(15);
		tacGia = new JTextField(15);
		nhaXuatBan = new JComboBox();
		nhaXuatBan.setPreferredSize(new Dimension(170, 20));

		/**
		 * Lấy dữ liệu Nhà Xuất Bản từ Database.
		 */
		list3 = sachDao.getNhaXuatBan();
		for (int i = 0; i < list3.size(); i++) {
			nhaXuatBan.addItem(list3.get(i).getNhaXuatBan());
		}
		/**********************************/
		theLoaiSach = new JComboBox<>();
		theLoaiSach.setPreferredSize(new Dimension(170, 20));
		nhaXuatBan.addItemListener(itemListener2);
		/**********************************/
		namXuatBan = new JTextField(15);
		soLuong = new JTextField(15);
		sachPanel = new JPanel();
		JLabel label3 = new JLabel("Quản Lý Sách");
		sachPanel.add(label3);
		sachPanel.setLayout(new BorderLayout());
		sachPanel.setLayout(new BoxLayout(sachPanel, BoxLayout.Y_AXIS));
		/**********************************/
		sachPanel1 = new JPanel();
		sachPanel1.setLayout(new GridBagLayout());
		addItem(sachPanel1, new JLabel("Mã Sách:"), 0, 0, 1, 1, GridBagConstraints.EAST);
		addItem(sachPanel1, new JLabel("Tên Sách:"), 0, 1, 1, 1, GridBagConstraints.EAST);
		addItem(sachPanel1, new JLabel("Tác Giả:"), 0, 2, 1, 1, GridBagConstraints.EAST);
		addItem(sachPanel1, new JLabel("Nhà Xuất Bản:"), 0, 3, 1, 1, GridBagConstraints.EAST);
		addItem(sachPanel1, new JLabel("Thể Loại Sách:"), 0, 4, 1, 1, GridBagConstraints.EAST);
		addItem(sachPanel1, new JLabel("Năm Xuất Bản:"), 0, 5, 1, 1, GridBagConstraints.EAST);
		addItem(sachPanel1, new JLabel("Số Lượng:"), 0, 6, 1, 1, GridBagConstraints.EAST);
		addItem(sachPanel1, maSach, 1, 0, 2, 1, GridBagConstraints.WEST);
		addItem(sachPanel1, tenSach, 1, 1, 1, 1, GridBagConstraints.WEST);
		addItem(sachPanel1, tacGia, 1, 2, 2, 1, GridBagConstraints.WEST);
		addItem(sachPanel1, nhaXuatBan, 1, 3, 2, 1, GridBagConstraints.WEST);
		addItem(sachPanel1, theLoaiSach, 1, 4, 1, 1, GridBagConstraints.WEST);
		addItem(sachPanel1, namXuatBan, 1, 5, 2, 1, GridBagConstraints.WEST);
		addItem(sachPanel1, soLuong, 1, 6, 1, 1, GridBagConstraints.WEST);
		/**********************************/
		sachPanel2 = new JPanel();
		themSach = new JButton("Thêm Sách");
		suaSach = new JButton("Sửa Sách");
		xoaSach = new JButton("Xóa Sách");
		seachSach = new JButton("Tìm Kiếm");
		thoat = new JButton("Danh Sách");

		sachPanel2.add(themSach);
		sachPanel2.add(suaSach);
		sachPanel2.add(xoaSach);
		sachPanel2.add(seachSach);
		sachPanel2.add(thoat);
		sachPanel.add(sachPanel1);
		sachPanel.add(sachPanel2);
		/**********************************/
		JPanel pnTable1 = new JPanel();
		Border border1 = BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitle1 = BorderFactory.createTitledBorder(border1, "Danh sách");
		model1 = new DefaultTableModel();
		model1.addColumn("Mã Sách");
		model1.addColumn("Tên Sách");
		model1.addColumn("Tác Giả");
		model1.addColumn("Nhà Xuất Bản");
		model1.addColumn("Thể Loại Sách");
		model1.addColumn("Năm Xuất Bản");
		model1.addColumn("Số Lượng Hiện Có ");
		JTable tbl1 = new JTable(model1);
		tbl1.getTableHeader().setReorderingAllowed(false);
		tbl1.setDefaultEditor(Object.class, null);
		JScrollPane sc1 = new JScrollPane(tbl1);
		sc1.setPreferredSize(new Dimension(750, 300));
		pnTable1.setBackground(Color.white);
		pnTable1.setBorder(borderTitle1);
		pnTable1.add(sc1);
		sachPanel.add(pnTable1);
		/**********************************
		 * Kết Thúc Quản Lý Sách
		 ***************************************/
		/**
		 * 
		 * Quản Lý Trả Mượn
		 */
		maGiaoDich = new JTextField(15);
		ngayMuon = new JTextField(15);
		maThanhVien1 = new JTextField(15);
		maSach1 = new JTextField(15);
		MuonTraSach = new JPanel();
		JLabel label4 = new JLabel("Quản Lý Mượn Trả");
		MuonTraSach.add(label4);
		MuonTraSach.setLayout(new BorderLayout());
		MuonTraSach.setLayout(new BoxLayout(MuonTraSach, BoxLayout.Y_AXIS));
		/**********************************/
		MuonTraSach1 = new JPanel();
		MuonTraSach1.setLayout(new GridBagLayout());
		addItem(MuonTraSach1, new JLabel("Mã Giao Dịch:"), 0, 0, 1, 1, GridBagConstraints.EAST);
		addItem(MuonTraSach1, new JLabel("Ngày Mượn/Trả:"), 0, 1, 1, 1, GridBagConstraints.EAST);
		addItem(MuonTraSach1, new JLabel("Tên Thành Viên:"), 0, 2, 1, 1, GridBagConstraints.EAST);
		addItem(MuonTraSach1, new JLabel("Tên Sách:"), 0, 3, 1, 1, GridBagConstraints.EAST);

		addItem(MuonTraSach1, maGiaoDich, 1, 0, 2, 1, GridBagConstraints.WEST);
		addItem(MuonTraSach1, ngayMuon, 1, 1, 1, 1, GridBagConstraints.WEST);
		addItem(MuonTraSach1, maThanhVien1, 1, 2, 2, 1, GridBagConstraints.WEST);
		addItem(MuonTraSach1, maSach1, 1, 3, 2, 1, GridBagConstraints.WEST);
		/**********************************/
		MuonTraSach2 = new JPanel();
		themMuon = new JButton("Mượn Sách");
		suaMuon = new JButton("Trả Sách");

		Muon = new JButton("Danh Sách");

		MuonTraSach2.add(themMuon);
		MuonTraSach2.add(suaMuon);

		MuonTraSach2.add(Muon);
		MuonTraSach.add(MuonTraSach1);
		MuonTraSach.add(MuonTraSach2);
		/**********************************/
		JPanel pnTable2 = new JPanel();
		Border border2 = BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitle2 = BorderFactory.createTitledBorder(border2, "Danh sách Trả-Mượn");
		model2 = new DefaultTableModel();
		model2.addColumn("Mã Giao Dich");
		model2.addColumn("Ngày Mượn");
		model2.addColumn("Tên Thành Viên");
		model2.addColumn("Tên Sách");
		model2.addColumn("Tình Trạng");
		JTable tbl2 = new JTable(model2);
		tbl2.getTableHeader().setReorderingAllowed(false);
		tbl2.setDefaultEditor(Object.class, null);
		JScrollPane sc2 = new JScrollPane(tbl2);
		sc2.setPreferredSize(new Dimension(750, 300));
		pnTable2.setBackground(Color.white);
		pnTable2.setBorder(borderTitle2);
		pnTable2.add(sc2);
		MuonTraSach.add(pnTable2);

		/**********************************
		 * Kết Thúc Quản Lý Trả Mượn
		 ***************************************/
		/**
		 * 
		 * Báo cáo Danh Sách Bạn Đọc.
		 */
		ThanhPho1 = new JComboBox<>();
		ThanhPho1.setPreferredSize(new Dimension(170, 20));
		maThanhVien2 = new JTextField(15);
		panelBaoCao = new JPanel();
		JLabel label5 = new JLabel("Danh Sách Bạn Đọc");
		panelBaoCao.add(label5);
		panelBaoCao.setLayout(new BorderLayout());
		panelBaoCao.setLayout(new BoxLayout(panelBaoCao, BoxLayout.Y_AXIS));
		/**********************************/
		panelBaoCao1 = new JPanel();
		panelBaoCao1.setLayout(new GridBagLayout());
		addItem(panelBaoCao1, new JLabel("Thành Phố:"), 0, 0, 1, 1, GridBagConstraints.EAST);
		addItem(panelBaoCao1, new JLabel("Mã Thành Viên:"), 0, 1, 1, 1, GridBagConstraints.EAST);
		addItem(panelBaoCao1, ThanhPho1, 1, 0, 2, 1, GridBagConstraints.WEST);
		addItem(panelBaoCao1, maThanhVien2, 1, 1, 1, 1, GridBagConstraints.WEST);
		panelBaoCao2 = new JPanel();
		listBaoCao = new JButton("Danh Sách");
		panelBaoCao2.add(listBaoCao);
		panelBaoCao.add(panelBaoCao1);
		panelBaoCao.add(panelBaoCao2);
		/**********************************/
		JPanel pnTable3 = new JPanel();
		Border border3 = BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitle3 = BorderFactory.createTitledBorder(border3, "Danh sách Bạn Đọc");
		model3 = new DefaultTableModel();
		model3.addColumn("Mã thành viên");
		model3.addColumn("Tên thành viên");
		model3.addColumn("Địa chỉ");
		model3.addColumn("Phường");
		model3.addColumn("Quận");
		model3.addColumn("Thành Phố");
		model3.addColumn("Điện Thoai");
		model3.addColumn("Email");
		JTable tbl3 = new JTable(model3);
		tbl3.getTableHeader().setReorderingAllowed(false);
		tbl3.setDefaultEditor(Object.class, null);
		JScrollPane sc3 = new JScrollPane(tbl3);
		sc3.setPreferredSize(new Dimension(750, 300));
		pnTable3.setBackground(Color.white);
		pnTable3.setBorder(borderTitle3);
		pnTable3.add(sc3);
		panelBaoCao.add(pnTable3);

		/**
		 * Lấy dữ liệu Thành Phố từ Database.
		 */
		list = banDoc.getCiTy1();
		for (int i = 0; i < list.size(); i++) {
			ThanhPho1.addItem(list.get(i).getTenThanhPho());
		}

		ThanhPho1.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {

					ArrayList<QuanLy_BanDoc> list = banDoc.getBaoCaoBanDoc(ThanhPho1.getSelectedItem().toString());
					model3.setRowCount(0);
					for (QuanLy_BanDoc ql : list) {
						model3.addRow(new String[] { ("" + ql.getMaThanhVien()), ql.getTenThanhVien(), ql.getSoNha(),
								ql.getMaPhuongXa(), ql.getMaQuanHuyen(), ql.getMaThanhPho(), ql.getSDT(),
								ql.getEmail() });
					}
				}

			}
		});

		/**********************************
		 * Kết Thúc Báo Cáo Danh Sách Bạn Đọc
		 ***************************************/
		/**
		 * 
		 * Thống Kê Đầu Sách
		 */
		tacGia1 = new JTextField(15);
		nhaXuatBan1 = new JComboBox<>();
		nhaXuatBan1.setPreferredSize(new Dimension(170, 20));
		/**
		 * Lấy dữ liệu Thành Phố từ Database.
		 */
		list3 = sachDao.getNhaXuatBan();
		for (int i = 0; i < list3.size(); i++) {
			nhaXuatBan1.addItem(list3.get(i).getNhaXuatBan());
		}

		theLoaiSach1 = new JComboBox<>();
		theLoaiSach1.setPreferredSize(new Dimension(170, 20));
		nhaXuatBan1.addItemListener(itemListener3);

		panelBaoCao3 = new JPanel();
		JLabel label6 = new JLabel("Danh Sách Bạn Đọc");
		panelBaoCao3.add(label6);
		panelBaoCao3.setLayout(new BorderLayout());
		panelBaoCao3.setLayout(new BoxLayout(panelBaoCao3, BoxLayout.Y_AXIS));

		/**********************************/
		panelBaoCao4 = new JPanel();
		panelBaoCao4.setLayout(new GridBagLayout());
		addItem(panelBaoCao4, new JLabel("Tác Giả:"), 0, 0, 1, 1, GridBagConstraints.EAST);
		addItem(panelBaoCao4, new JLabel("Nhà Xuất Bản:"), 0, 1, 1, 1, GridBagConstraints.EAST);
		addItem(panelBaoCao4, new JLabel("Thể Loại Sách:"), 0, 2, 1, 1, GridBagConstraints.EAST);
		addItem(panelBaoCao4, tacGia1, 1, 0, 2, 1, GridBagConstraints.WEST);
		addItem(panelBaoCao4, nhaXuatBan1, 1, 1, 1, 1, GridBagConstraints.WEST);
		addItem(panelBaoCao4, theLoaiSach1, 1, 2, 2, 1, GridBagConstraints.WEST);
		panelBaoCao5 = new JPanel();
		listBaoCao1 = new JButton("Danh Sách");
		panelBaoCao5.add(listBaoCao1);
		panelBaoCao3.add(panelBaoCao4);
		panelBaoCao3.add(panelBaoCao5);
		/**********************************/
		JPanel pnTable4 = new JPanel();
		Border border4 = BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitle4 = BorderFactory.createTitledBorder(border4, "Danh sách Bạn Đọc");
		model4 = new DefaultTableModel();
		model4.addColumn("Mã Sách");
		model4.addColumn("Tên Sách");
		model4.addColumn("Tác Giả");
		model4.addColumn("Nhà Xuất Bản");
		model4.addColumn("Thể Loại Sách");
		model4.addColumn("Năm Xuất Bản");
		model4.addColumn("Số Lượng");
		JTable tbl4 = new JTable(model4);
		tbl4.getTableHeader().setReorderingAllowed(false);
		tbl4.setDefaultEditor(Object.class, null);
		JScrollPane sc4 = new JScrollPane(tbl4);
		sc4.setPreferredSize(new Dimension(750, 300));
		pnTable4.setBackground(Color.white);
		pnTable4.setBorder(borderTitle4);
		pnTable4.add(sc4);
		panelBaoCao3.add(pnTable4);
		/**********************************
		 * Kết Thúc Thống Kê Đầu Sách
		 ***************************************/

		/**
		 * 
		 * Cardlayout
		 */
		card = new CardLayout();
		cardPanel.setLayout(card);
		cardPanel.add(panel3, "TrangChu");
		cardPanel.add(panel, "quanLyThongTin");
		cardPanel.add(sachPanel, "quanLySach");
		cardPanel.add(MuonTraSach, "MuonTra");
		cardPanel.add(panelBaoCao, "baocao1");
		cardPanel.add(panelBaoCao3, "baocao2");
		card.show(cardPanel, "TrangChu");

		con.add(pnBorder);
		setAction();
	}

	public void Display() {
		setSize(1000, 800);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public static void main(String[] args) {
		QuanLy_ThuVien quanLy_ThuVien = new QuanLy_ThuVien();
		quanLy_ThuVien.Display();

	}

	private void setAction() {
		menu.addActionListener(this);
		mnuFileNew.addActionListener(this);
		mnuFileOpen.addActionListener(this);
		mnFile.addActionListener(this);
		baocao.addActionListener(this);
		baocao1.addActionListener(this);
		buton.addActionListener(this);
		buton1.addActionListener(this);
		buton2.addActionListener(this);
		seach.addActionListener(this);
		buton3.addActionListener(this);
		thoat.addActionListener(this);
		themSach.addActionListener(this);
		suaSach.addActionListener(this);
		xoaSach.addActionListener(this);
		seachSach.addActionListener(this);
		themMuon.addActionListener(this);
		suaMuon.addActionListener(this);
		Muon.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == menu) {

			card.show(cardPanel, "TrangChu");
		}

		if (e.getSource() == mnuFileNew) {

			card.show(cardPanel, "quanLyThongTin");

		}

		if (e.getSource() == mnuFileOpen) {

			card.show(cardPanel, "quanLySach");
		}
		if (e.getSource() == mnFile) {
			card.show(cardPanel, "MuonTra");
		}
		if (e.getSource() == baocao) {
			card.show(cardPanel, "baocao1");
		}
		if (e.getSource() == baocao1) {
			card.show(cardPanel, "baocao2");
		}
		/**
		 * Thêm danh sách bạn đọc.
		 */
		if (e.getSource() == buton) {
			QuanLy_BanDoc quanLyBanDoc = new QuanLy_BanDoc();
			quanLyBanDoc.setTenThanhVien(tenThanhVien.getText());
			quanLyBanDoc.setSoNha(DiaChi.getText());
			quanLyBanDoc.setMaPhuongXa(Phuong.getSelectedItem().toString());
			quanLyBanDoc.setMaQuanHuyen(Quan.getSelectedItem().toString());
			quanLyBanDoc.setMaThanhPho(tenThanhPho);
			quanLyBanDoc.setSDT(DienThoai.getText());
			quanLyBanDoc.setEmail(Email.getText());
			thuVienDao.addBanDoc(quanLyBanDoc);
			ArrayList<QuanLy_BanDoc> list = thuVienDao.getAllBanDoc();
			model.setRowCount(0);
			for (QuanLy_BanDoc ql : list) {
				model.addRow(new String[] { "" + ql.getMaThanhVien(), ql.getTenThanhVien(), ql.getSoNha(),
						ql.getMaPhuongXa(), ql.getMaQuanHuyen(), ql.getMaThanhPho(), ql.getSDT(), ql.getEmail() });
			}
			tenThanhVien.setText("");
			DiaChi.setText("");
			DienThoai.setText("");
			Email.setText("");

		}

		/**
		 * Sửa danh sách bạn đọc.
		 */
		if (e.getSource() == buton1) {
			QuanLy_BanDoc quanLyBanDoc = new QuanLy_BanDoc();
			quanLyBanDoc.setMaThanhVien(maThanhVien.getText());
			quanLyBanDoc.setTenThanhVien(tenThanhVien.getText());
			quanLyBanDoc.setSoNha(DiaChi.getText());
			quanLyBanDoc.setMaPhuongXa(Phuong.getSelectedItem().toString());
			quanLyBanDoc.setMaQuanHuyen(Quan.getSelectedItem().toString());
			quanLyBanDoc.setMaThanhPho(tenThanhPho);
			quanLyBanDoc.setSDT(DienThoai.getText());
			quanLyBanDoc.setEmail(Email.getText());
			thuVienDao.UpdateBanDoc(quanLyBanDoc);
			ArrayList<QuanLy_BanDoc> list = thuVienDao.getAllBanDoc();
			JOptionPane.showMessageDialog(null, "Update thành công");
			model.setRowCount(0);
			for (QuanLy_BanDoc ql : list) {
				model.addRow(new String[] { "" + ql.getMaThanhVien(), ql.getTenThanhVien(), ql.getSoNha(),
						ql.getMaPhuongXa(), ql.getMaQuanHuyen(), ql.getMaThanhPho(), ql.getSDT(), ql.getEmail() });
			}
			maThanhVien.setText("");
			tenThanhVien.setText("");
			DiaChi.setText("");
			DienThoai.setText("");
			Email.setText("");

		}

		/**
		 * Xóa sanh sách bạn đọc.
		 */
		if (e.getSource() == buton2) {
			QuanLy_BanDoc quanLyBanDoc = new QuanLy_BanDoc();
			quanLyBanDoc.setMaThanhVien(maThanhVien.getText());
			thuVienDao.DeleteBanDoc(quanLyBanDoc);
			ArrayList<QuanLy_BanDoc> list = thuVienDao.getAllBanDoc();
			model.setRowCount(0);
			for (QuanLy_BanDoc ql : list) {
				model.addRow(new String[] { "" + ql.getMaThanhVien(), ql.getTenThanhVien(), ql.getSoNha(),
						ql.getMaPhuongXa(), ql.getMaQuanHuyen(), ql.getMaThanhPho(), ql.getSDT(), ql.getEmail() });
			}
			maThanhVien.setText("");
		}

		/**
		 * Tìm kiếm danh sách bạn đọc.
		 */
		if (e.getSource() == seach) {
			QuanLy_BanDoc quanLyBanDoc = new QuanLy_BanDoc();
			quanLyBanDoc.setTenThanhVien(tenThanhVien.getText());

			ArrayList<QuanLy_BanDoc> listSeach = thuVienDao.SeachBanDoc(quanLyBanDoc);
			model.setRowCount(0);
			for (QuanLy_BanDoc ql : listSeach) {
				model.addRow(new String[] { "" + ql.getMaThanhVien(), ql.getTenThanhVien(), ql.getSoNha(),
						ql.getMaPhuongXa(), ql.getMaQuanHuyen(), ql.getMaThanhPho(), ql.getSDT(), ql.getEmail() });
			}

			maThanhVien.setText("");
		}

		/**
		 * In ra danh sách bạn đọc.
		 */
		if (e.getSource() == buton3) {
			ArrayList<QuanLy_BanDoc> list = thuVienDao.getAllBanDoc();
			model.setRowCount(0);
			for (QuanLy_BanDoc ql : list) {
				model.addRow(new String[] { ("" + ql.getMaThanhVien()), ql.getTenThanhVien(), ql.getSoNha(),
						ql.getMaPhuongXa(), ql.getMaQuanHuyen(), ql.getMaThanhPho(), ql.getSDT(), ql.getEmail() });
			}
		}

		/**
		 * In ra danh sách hệ thống sách.
		 */
		if (e.getSource() == thoat) {
			ArrayList<QuanLySach> listSach = sachDao.getAllSach();
			model1.setRowCount(0);
			for (QuanLySach sach : listSach) {
				model1.addRow(new String[] { ("" + sach.getMaSach()), sach.getTenSach(), sach.getTacGia(),
						sach.getNhaXuatBan(), sach.getTheLoaiSach(), sach.getNamXuatBan(), sach.getSoLuong() });
			}
		}

		/**
		 * Thêm Sách vào hệ thống sách.
		 */
		if (e.getSource() == themSach) {
			QuanLySach quanly = new QuanLySach();
			quanly.setTenSach(tenSach.getText());
			quanly.setTacGia(tacGia.getText());
			quanly.setNhaXuatBan(nhaXuatBan.getSelectedItem().toString());
			quanly.setTheLoaiSach(theLoaiSach.getSelectedItem().toString());
			quanly.setNamXuatBan(namXuatBan.getText());
			quanly.setSoLuong(soLuong.getText());
			sachDao.addSach(quanly);
			ArrayList<QuanLySach> listSach = sachDao.getAllSach();
			model1.setRowCount(0);
			for (QuanLySach sach : listSach) {
				model1.addRow(new String[] { ("" + sach.getMaSach()), sach.getTenSach(), sach.getTacGia(),
						sach.getNhaXuatBan(), sach.getTheLoaiSach(), sach.getNamXuatBan(), sach.getSoLuong() });
			}

		}

		/**
		 * Sửa Sách trong hệ thống sách
		 */
		if (e.getSource() == suaSach) {
			QuanLySach quanly = new QuanLySach();
			quanly.setMaSach(maSach.getText());
			quanly.setTenSach(tenSach.getText());
			quanly.setTacGia(tacGia.getText());
			quanly.setNhaXuatBan(nhaXuatBan.getSelectedItem().toString());
			quanly.setTheLoaiSach(theLoaiSach.getSelectedItem().toString());
			quanly.setNamXuatBan(namXuatBan.getText());
			quanly.setSoLuong(soLuong.getText());
			sachDao.UpdateSach(quanly);
			ArrayList<QuanLySach> listSach = sachDao.getAllSach();
			model1.setRowCount(0);
			for (QuanLySach sach : listSach) {
				model1.addRow(new String[] { ("" + sach.getMaSach()), sach.getTenSach(), sach.getTacGia(),
						sach.getNhaXuatBan(), sach.getTheLoaiSach(), sach.getNamXuatBan(), sach.getSoLuong() });
			}
			maSach.setText("");
			tenSach.setText("");
			tacGia.setText("");
			namXuatBan.setText("");
			soLuong.setText("");
		}

		/**
		 * Xóa Sách trong hệ thống sách.
		 */
		if (e.getSource() == xoaSach) {
			QuanLySach quanly = new QuanLySach();
			quanly.setMaSach(maSach.getText());
			sachDao.DeleteSach(quanly);
			ArrayList<QuanLySach> listSach = sachDao.getAllSach();
			model1.setRowCount(0);
			for (QuanLySach sach : listSach) {
				model1.addRow(new String[] { ("" + sach.getMaSach()), sach.getTenSach(), sach.getTacGia(),
						sach.getNhaXuatBan(), sach.getTheLoaiSach(), sach.getNamXuatBan(), sach.getSoLuong() });
			}
			maSach.setText("");
		}

		/**
		 * Tìm kiếm sách Trong hệ thống theo tên Sách.
		 */
		if (e.getSource() == seachSach) {
			QuanLySach quanly = new QuanLySach();
			quanly.setTenSach(tenSach.getText());

			ArrayList<QuanLySach> listTimKiem = sachDao.SeachSach(quanly);
			model1.setRowCount(0);
			for (QuanLySach sach : listTimKiem) {
				model1.addRow(new String[] { ("" + sach.getMaSach()), sach.getTenSach(), sach.getTacGia(),
						sach.getNhaXuatBan(), sach.getTheLoaiSach(), sach.getNamXuatBan(), sach.getSoLuong() });
			}
			tenSach.setText("");

		}
		/**
		 * 
		 * Quản lý mượn Sách.
		 */
		if (e.getSource() == themMuon) {
			if (dao.kiemTra(maThanhVien1.getText()) && dao.kiemTraSach(maSach1.getText())) {
				dao.MuonSach(ngayMuon.getText(), Integer.parseInt(maThanhVien1.getText()),
						Integer.parseInt(maSach1.getText()));
			} else {
				JOptionPane.showMessageDialog(null, "Vui lòng nhập đúng mã");
			}
			ArrayList<muon_TraSach> listMuonTra = dao.getAllMuon_Tra();
			model2.setRowCount(0);
			for (muon_TraSach muonTra : listMuonTra) {
				model2.addRow(new String[] { ("" + muonTra.getMaGiaoDich()), muonTra.getNgayMuon(),
						muonTra.getMaThanhVien().getTenThanhVien(), muonTra.getMaSach().getTenSach(),
						muonTra.getTinhTrang() });
			}
		}
		/**
		 * 
		 * Quản lý trả Sach
		 */
		if (e.getSource() == suaMuon) {
			muon_TraSach muonTra = new muon_TraSach();
			muonTra.setNgayMuon(ngayMuon.getText());
			QuanLy_BanDoc quanly = new QuanLy_BanDoc();
			quanly.setMaThanhVien(maThanhVien1.getText());
			muonTra.setMaThanhVien(quanly);
			QuanLySach sach = new QuanLySach();
			sach.setMaSach(maSach1.getText());
			muonTra.setMaSach(sach);

			dao.TraSach(muonTra);
			ArrayList<muon_TraSach> listMuonTra = dao.getAllMuon_Tra();
			model2.setRowCount(0);
			for (muon_TraSach muonTra1 : listMuonTra) {
				model2.addRow(new String[] { ("" + muonTra1.getMaGiaoDich()), muonTra1.getNgayMuon(),
						muonTra1.getMaThanhVien().getTenThanhVien(), muonTra1.getMaSach().getTenSach(),
						muonTra1.getTinhTrang() });
			}
		}
		/**
		 * 
		 * Danh Sách Mượn, Trả
		 */
		if (e.getSource() == Muon) {
			ArrayList<muon_TraSach> listMuonTra = dao.getAllMuon_Tra();
			model2.setRowCount(0);
			for (muon_TraSach muonTra : listMuonTra) {
				model2.addRow(new String[] { ("" + muonTra.getMaGiaoDich()), muonTra.getNgayMuon(),
						muonTra.getMaThanhVien().getTenThanhVien(), muonTra.getMaSach().getTenSach(),
						muonTra.getTinhTrang() });
			}
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
}
