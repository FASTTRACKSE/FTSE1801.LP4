package quanly_thuvien.model.controler;

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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Properties;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFormattedTextField.AbstractFormatter;
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

import quanly_thuvien.model.dao.SachDao;
import quanly_thuvien.model.dao.Tra_MuonDao;
import quanly_thuvien.model.dao.banDocDao;
import quanly_thuvien.model.dao.thuvienDao;
import quanly_thuvien.model.entity.NhaXuatBan;
import quanly_thuvien.model.entity.Phuong;
import quanly_thuvien.model.entity.Quan;
import quanly_thuvien.model.entity.QuanLySach;
import quanly_thuvien.model.entity.QuanLy_BanDoc;
import quanly_thuvien.model.entity.ThanhPho;
import quanly_thuvien.model.entity.TheLoaiSach;
import quanly_thuvien.model.entity.muon_TraSach;

/**
 * phần mềm quản lý thư viện
 * 
 * @author Phạm Ngọc Thiên AND Hồ Tấn Hiệu
 *
 */
public class QuanLy_ThuVien extends JFrame implements ActionListener {
	Container con = getContentPane();

	/**
	 * Khai báo biến
	 */
	CardLayout card;
	JPanel pnBorder, pnCenter, cardPanel, panel1, panel11, panel2, panel, panel3, sachPanel, sachPanel1, sachPanel2,
			QuanLyTTin, MuonTraSach, MuonTraSach1, MuonTraSach2, panelBaoCao, panelBaoCao1, panelBaoCao2, panelBaoCao3,
			panelBaoCao4, panelBaoCao5, TimKiemBanDoc, TimKiemsach, timKiemMuonTra;
	JLabel labe1, label2, MuonTra;

	JButton buton, buton1, buton2, buton3, seach, themSach, suaSach, xoaSach, seachSach, thoat, mnuFileNew, mnuFileOpen,
			mnFile, menu, baocao, baocao1, themMuon, suaMuon, xoaMuon, Muon, MuontraButTon, listBaoCao, listBaoCao1;

	JTextField maThanhVien, maThanhVien1, maThanhVien2, tenThanhVien, DiaChi, DienThoai, Email, maSach, maSach1,
			tenSach, tacGia, namXuatBan, soLuong, maGiaoDich, ngayMuon, tacGia1, timkiembandoc, TimKiemSach,
			MuonTraTextField;

	JComboBox ThanhPho, ThanhPho1, Quan, Phuong, theLoaiSach, nhaXuatBan, theLoaiSach1, nhaXuatBan1;
	DefaultTableModel model, model1, model2, model3, model4;

	// làm addDinamic
	JButton btnAdd;
	ArrayList<JTextField> listTextField;
	JDatePanelImpl datePanel, datePanel1;
	JDatePickerImpl datePicker, datePicker1;
	UtilDateModel modelDate, modelDate1;
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

				list4 = banDoc.getBaoCaoTheLoaiSach(NhaXuatBan1);
				for (int i = 0; i < list4.size(); i++) {
					theLoaiSach1.addItem(list4.get(i).getTheLoaiSach());

				}
			}
		}
	};
	/**
	 * 
	 * Thống Kê Sách Theo Nhà Xuất Bản Và Thể Lọai Sách.
	 */
	ItemListener itemListener4 = new ItemListener() {
		public void itemStateChanged(ItemEvent e) {
			if (e.getStateChange() == ItemEvent.SELECTED) {
				model4.setRowCount(0);
				ArrayList<QuanLySach> listBaoCao = sachDao.getAllSach();
				for (int i = 0; i < listBaoCao.size(); i++) {
					if (listBaoCao.get(i).getNhaXuatBan().equals(nhaXuatBan1.getSelectedItem().toString())
							&& listBaoCao.get(i).getTheLoaiSach().equals(theLoaiSach1.getSelectedItem().toString())) {
						model4.addRow(
								new String[] { ("" + listBaoCao.get(i).getMaSach()), listBaoCao.get(i).getTenSach(),
										listBaoCao.get(i).getTacGia(), listBaoCao.get(i).getNhaXuatBan(),
										listBaoCao.get(i).getTheLoaiSach(), listBaoCao.get(i).getNamXuatBan(),
										listBaoCao.get(i).getSoLuong(), listBaoCao.get(i).getSoLuongTonKho() });
					}
				}

			}
		}
	};

	/**
	 * Date Mượn
	 * 
	 * @author
	 *
	 */
	public class DateLabelFormatter extends AbstractFormatter {

		private static final long serialVersionUID = 1L;
		String datePattern = "yyyy-MM-dd";
		SimpleDateFormat dateFormatter = new SimpleDateFormat(datePattern);

		@Override
		public Object stringToValue(String text) throws ParseException, java.text.ParseException {
			return dateFormatter.parseObject(text);
		}

		@Override
		public String valueToString(Object value) throws ParseException {
			if (value != null) {
				Calendar cal = (Calendar) value;
				return dateFormatter.format(cal.getTime());
			}

			return "";
		}

	}

	/**
	 * date Trả.
	 */
	public class DateLabelFormatter1 extends AbstractFormatter {

		private static final long serialVersionUID = 1L;
		String datePattern1 = "yyyy-MM-dd";
		SimpleDateFormat dateFormatter1 = new SimpleDateFormat(datePattern1);

		@Override
		public Object stringToValue(String text) throws ParseException, java.text.ParseException {
			return dateFormatter1.parseObject(text);
		}

		@Override
		public String valueToString(Object value) throws ParseException {
			if (value != null) {
				Calendar cal = (Calendar) value;
				return dateFormatter1.format(cal.getTime());
			}

			return "";
		}

	}

	int j = 3;
	int x = 1;
	int a = 0;

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
		label.setFont(new Font("Arial", Font.BOLD, 40));
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
		// pnBorder.add(pnWest);
		pnWest.setBackground(Color.DARK_GRAY);
		pnBorder.add(pnWest, BorderLayout.WEST);

		/**
		 * Giao diện
		 */
		pnCenter = new JPanel();
		cardPanel = new JPanel();
		pnCenter.add(cardPanel);
		JScrollPane pane = new JScrollPane(pnCenter);
		pnBorder.add(pane, BorderLayout.CENTER);

		// pnBorder.add(pnCenter);

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
		list1 = thuVienDao.getQuan(ThanhPho.getSelectedItem().toString());
		for (int i = 0; i < list1.size(); i++) {
			Quan.addItem(list1.get(i).getTenQuanHuyen());
		}

		Phuong = new JComboBox<>();
		Phuong.setPreferredSize(new Dimension(170, 20));
		list2 = thuVienDao.getPhuong(Quan.getSelectedItem().toString());
		for (int i = 0; i < list2.size(); i++) {
			Phuong.addItem(list2.get(i).getTenPhuongXa());
		}
		/**
		 * Lấy dữ liệu quân_huyện,phường_xã từ Database.
		 */
		ThanhPho.addItemListener(itemListener);
		Quan.addItemListener(itemListener1);
		/**********************************/
		DienThoai = new JTextField(15);
		Email = new JTextField(15);
		panel = new JPanel();
		JPanel panelNguoiDung = new JPanel();
		JLabel label2 = new JLabel("Quản Lý Người Dùng");
		label2.setFont(new Font("Arial", Font.BOLD, 20));
		panelNguoiDung.add(label2);
		panel.add(panelNguoiDung);
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
		buton3 = new JButton("Làm Mới");

		buton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				buton.setEnabled(true);
				buton1.setEnabled(false);
				buton2.setEnabled(false);
				seach.setEnabled(false);

			}
		});
		buton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				buton1.setEnabled(true);
				buton.setEnabled(false);
				buton2.setEnabled(false);
				seach.setEnabled(false);
			}
		});
		buton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				buton2.setEnabled(true);
				buton.setEnabled(false);
				buton.setEnabled(false);
				seach.setEnabled(false);
			}
		});

		panel2.add(buton);
		panel2.add(buton1);
		panel2.add(buton2);
		panel2.add(buton3);
		JLabel TimKiem = new JLabel("Tên Thành Viên* :");
		timkiembandoc = new JTextField(15);
		TimKiemBanDoc = new JPanel();
		TimKiemBanDoc.add(TimKiem);
		TimKiemBanDoc.add(timkiembandoc);
		seach = new JButton("Tìm Kiếm");
		TimKiemBanDoc.add(seach);
		QuanLyTTin.add(panel1);
		QuanLyTTin.add(panel11);
		panel.add(QuanLyTTin);
		panel.add(panel2);
		panel.add(TimKiemBanDoc);
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
		sc.setPreferredSize(new Dimension(970, 300));
		pnTable.setBackground(Color.white);
		pnTable.setBorder(borderTitle);
		pnTable.add(sc);
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
				String s = (String) tbl.getValueAt(row, 0);
				maThanhVien.setText(s);
				String y = (String) tbl.getValueAt(row, 1);
				tenThanhVien.setText(y);
				String z = (String) tbl.getValueAt(row, 6);
				DienThoai.setText(z);
				String a = (String) tbl.getValueAt(row, 7);
				Email.setText(a);
				String b = (String) tbl.getValueAt(row, 5);
				ThanhPho.getModel().setSelectedItem(b);
				String c = (String) tbl.getValueAt(row, 4);
				Quan.getModel().setSelectedItem(c);
				String d = (String) tbl.getValueAt(row, 3);
				Phuong.getModel().setSelectedItem(d);
				String o = (String) tbl.getValueAt(row, 2);
				DiaChi.setText(o);
				buton1.setEnabled(true);
				buton.setEnabled(false);
				buton2.setEnabled(true);

			}
		});

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
		TimKiemSach = new JTextField(15);
		list4 = sachDao.getTheLoaiSach(nhaXuatBan.getSelectedItem().toString());
		for (int i = 0; i < list4.size(); i++) {
			theLoaiSach.addItem(list4.get(i).getTheLoaiSach());
		}
		nhaXuatBan.addItemListener(itemListener2);
		/**********************************/
		namXuatBan = new JTextField(15);
		soLuong = new JTextField(15);
		sachPanel = new JPanel();
		JPanel panelQuanLySach = new JPanel();
		JLabel label3 = new JLabel("Quản Lý Sách");
		label3.setFont(new Font("Arial", Font.BOLD, 20));
		panelQuanLySach.add(label3);
		sachPanel.add(panelQuanLySach);
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
		TimKiemsach = new JPanel();
		seachSach = new JButton("Tìm Kiếm");
		addItem(TimKiemsach, new JLabel("Tên Sách* :"), 0, 0, 1, 1, GridBagConstraints.EAST);
		addItem(TimKiemsach, TimKiemSach, 1, 0, 2, 1, GridBagConstraints.WEST);
		TimKiemsach.add(seachSach);
		/**********************************/
		sachPanel2 = new JPanel();
		themSach = new JButton("Thêm Sách");
		suaSach = new JButton("Sửa Sách");
		xoaSach = new JButton("Xóa Sách");
		thoat = new JButton("Làm Mới");
		themSach.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				themSach.setEnabled(true);
				suaSach.setEnabled(false);
				xoaSach.setEnabled(false);
				seachSach.setEnabled(false);
			}
		});

		suaSach.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				themSach.setEnabled(false);
				suaSach.setEnabled(true);
				xoaSach.setEnabled(false);
				seachSach.setEnabled(false);
			}
		});
		xoaSach.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				themSach.setEnabled(false);
				suaSach.setEnabled(false);
				xoaSach.setEnabled(true);
				seachSach.setEnabled(false);
			}
		});

		sachPanel2.add(themSach);
		sachPanel2.add(suaSach);
		sachPanel2.add(xoaSach);
		sachPanel2.add(thoat);
		sachPanel.add(sachPanel1);
		sachPanel.add(sachPanel2);
		sachPanel.add(TimKiemsach);
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
		tbl1.addMouseListener(new MouseListener() {
			public void mouseReleased(MouseEvent e) {
			}

			public void mousePressed(MouseEvent e) {
			}

			public void mouseExited(MouseEvent e) {
			}

			public void mouseEntered(MouseEvent e) {
			}

			public void mouseClicked(MouseEvent e) {
				int row = tbl1.getSelectedRow();
				String a = (String) tbl1.getValueAt(row, 0);
				maSach.setText(a);
				String b = (String) tbl1.getValueAt(row, 1);
				tenSach.setText(b);
				String c = (String) tbl1.getValueAt(row, 2);
				tacGia.setText(c);
				String d = (String) tbl1.getValueAt(row, 3);
				nhaXuatBan.getModel().setSelectedItem(d);
				String g = (String) tbl1.getValueAt(row, 4);
				theLoaiSach.getModel().setSelectedItem(g);
				String h = (String) tbl1.getValueAt(row, 5);
				namXuatBan.setText(h);
				String f = (String) tbl1.getValueAt(row, 6);
				soLuong.setText(f);
				themSach.setEnabled(false);
				suaSach.setEnabled(true);
				xoaSach.setEnabled(true);
				seachSach.setEnabled(true);

			}
		});
		JScrollPane sc1 = new JScrollPane(tbl1);
		sc1.setPreferredSize(new Dimension(970, 300));
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
		/*
		 * ngày mượn!
		 */
		modelDate = new UtilDateModel();
		Properties p = new Properties();
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");
		datePanel = new JDatePanelImpl(modelDate, p);
		datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
		/*
		 * ngày trả!
		 */
		modelDate1 = new UtilDateModel();
		Properties p1 = new Properties();
		p1.put("text.today", "Today");
		p1.put("text.month", "Month");
		p1.put("text.year", "Year");
		datePanel1 = new JDatePanelImpl(modelDate1, p1);
		datePicker1 = new JDatePickerImpl(datePanel1, new DateLabelFormatter1());
		// ngayMuon = new JTextField(15);
		maThanhVien1 = new JTextField(15);

		MuonTraSach = new JPanel();
		JPanel panelMuonTra = new JPanel();
		JLabel label4 = new JLabel("Quản Lý Mượn Trả");
		label4.setFont(new Font("Arial", Font.BOLD, 20));
		panelMuonTra.add(label4);
		MuonTraSach.add(panelMuonTra);
		MuonTraSach.setLayout(new BorderLayout());
		MuonTraSach.setLayout(new BoxLayout(MuonTraSach, BoxLayout.Y_AXIS));

		/**********************************/
		MuonTraSach1 = new JPanel();
		MuonTraSach1.setLayout(new GridBagLayout());

		addItem(MuonTraSach1, new JLabel("Ngày Mượn:"), 0, 0, 1, 1, GridBagConstraints.EAST);
		addItem(MuonTraSach1, new JLabel("Ngày Trả:"), 0, 1, 1, 1, GridBagConstraints.EAST);
		addItem(MuonTraSach1, new JLabel("Mã Thành Viên:"), 0, 2, 1, 1, GridBagConstraints.EAST);

		addItem(MuonTraSach1, datePicker, 1, 0, 2, 1, GridBagConstraints.WEST);
		addItem(MuonTraSach1, datePicker1, 1, 1, 1, 1, GridBagConstraints.WEST);
		addItem(MuonTraSach1, maThanhVien1, 1, 2, 1, 1, GridBagConstraints.WEST);
		listTextField = new ArrayList<JTextField>();
		btnAdd = new JButton("Thêm Sách");
		listTextField.add(new JTextField(15));
		addItem(MuonTraSach1, new JLabel("Mã Sách" + x + ":"), 0, j, 1, 1, GridBagConstraints.EAST);
		addItem(MuonTraSach1, listTextField.get(a), 1, j, 2, 1, GridBagConstraints.WEST);

		j++;
		x++;
		a++;
		Display();
		if (j > 5) {
			btnAdd.setEnabled(false);
		}
		btnAdd.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				listTextField.add(new JTextField(15));
				addItem(MuonTraSach1, new JLabel("Mã Sách" + x + ":"), 0, j, 1, 1, GridBagConstraints.EAST);
				addItem(MuonTraSach1, listTextField.get(a), 1, j, 2, 1, GridBagConstraints.WEST);
				j++;
				x++;
				a++;
				Display();
				if (j > 5) {
					btnAdd.setEnabled(false);
				}
			}
		});

		/**********************************/
		MuonTraSach2 = new JPanel();
		themMuon = new JButton("Mượn Sách");
		suaMuon = new JButton("Trả Sách");

		Muon = new JButton("Danh Sách");

		MuonTraSach2.add(themMuon);
		MuonTraSach2.add(suaMuon);
		MuonTraSach2.add(Muon);
		MuonTraSach2.add(btnAdd);
		MuonTraSach.add(MuonTraSach1);
		MuonTraSach.add(MuonTraSach2);
		timKiemMuonTra = new JPanel();
		MuonTra = new JLabel("Mã Thành Viên*:");
		MuonTraTextField = new JTextField(15);
		MuontraButTon = new JButton("Tìm Kiếm");
		timKiemMuonTra.add(MuonTra);
		timKiemMuonTra.add(MuonTraTextField);
		timKiemMuonTra.add(MuontraButTon);
		MuonTraSach.add(timKiemMuonTra);
		/**********************************/
		JPanel pnTable2 = new JPanel();
		Border border2 = BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitle2 = BorderFactory.createTitledBorder(border2, "Danh sách Trả-Mượn");
		model2 = new DefaultTableModel();
		model2.addColumn("Mã Giao Dich");
		model2.addColumn("Ngày Mượn");
		model2.addColumn("Ngày Trả");
		model2.addColumn("Mã Thành Viên");
		model2.addColumn("Tên Thành Viên");
		model2.addColumn("Mã Sách");
		model2.addColumn("Tên Sách");
		model2.addColumn("Tình Trạng");
		JTable tbl2 = new JTable(model2);
		tbl2.getTableHeader().setReorderingAllowed(false);
		tbl2.setDefaultEditor(Object.class, null);
		JScrollPane sc2 = new JScrollPane(tbl2);
		sc2.setPreferredSize(new Dimension(970, 300));
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
		JPanel panelChuDe = new JPanel();
		JLabel label5 = new JLabel("Danh Sách Bạn Đọc");
		label5.setFont(new Font("Arial", Font.BOLD, 20));
		panelChuDe.add(label5);
		panelBaoCao.add(panelChuDe);
		panelBaoCao.setLayout(new BorderLayout());
		panelBaoCao.setLayout(new BoxLayout(panelBaoCao, BoxLayout.Y_AXIS));

		/**********************************/
		panelBaoCao1 = new JPanel();
		panelBaoCao1.setLayout(new GridBagLayout());
		listBaoCao = new JButton("Danh Sách");
		addItem(panelBaoCao1, new JLabel("Mã Thành Viên:"), 0, 0, 1, 1, GridBagConstraints.EAST);
		addItem(panelBaoCao1, maThanhVien2, 1, 0, 1, 1, GridBagConstraints.WEST);
		addItem(panelBaoCao1, listBaoCao, 2, 0, 1, 1, GridBagConstraints.WEST);
		addItem(panelBaoCao1, new JLabel("Thành Phố:"), 0, 1, 1, 1, GridBagConstraints.EAST);
		addItem(panelBaoCao1, ThanhPho1, 1, 1, 1, 1, GridBagConstraints.WEST);
		// panelBaoCao1.add(listBaoCao);
		panelBaoCao2 = new JPanel();
		Border borderBaoCao = BorderFactory.createLineBorder(Color.RED);
		panelBaoCao1.setPreferredSize(new Dimension(500, 200));
		panelBaoCao1.setBorder(borderBaoCao);
		panelBaoCao2.add(panelBaoCao1);
		panelBaoCao.add(panelBaoCao2);
		/**********************************/
		JPanel pnTable3 = new JPanel();
		Border border3 = BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitle3 = BorderFactory.createTitledBorder(border3, "Danh sách Bạn Đọc");
		model3 = new DefaultTableModel();
		model3.addColumn("Mã thành viên");
		model3.addColumn("Tên thành viên");
		model3.addColumn("Phường");
		model3.addColumn("Quận");
		model3.addColumn("Thành Phố");
		model3.addColumn("Tên Sách");
		model3.addColumn("Tình Trạng Mượn Sách");
		JTable tbl3 = new JTable(model3);
		tbl3.getTableHeader().setReorderingAllowed(false);
		tbl3.setDefaultEditor(Object.class, null);
		JScrollPane sc3 = new JScrollPane(tbl3);
		sc3.setPreferredSize(new Dimension(970, 300));
		pnTable3.setBackground(Color.white);
		pnTable3.setBorder(borderTitle3);
		pnTable3.add(sc3);
		panelBaoCao.add(pnTable3);

		/**
		 * Lấy dữ liệu Thành Phố từ Database in danh sách bạn đọc theo thành phố.
		 */
		list = banDoc.getCiTy1();
		for (int i = 0; i < list.size(); i++) {
			ThanhPho1.addItem(list.get(i).getTenThanhPho());
		}

		ThanhPho1.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {

					ArrayList<muon_TraSach> list = banDoc.getBaoCaoBanDoc(ThanhPho1.getSelectedItem().toString());
					model3.setRowCount(0);
					for (muon_TraSach ql : list) {
						model3.addRow(new String[] { ("" + ql.getMaThanhVien().getMaThanhVien()),
								ql.getMaThanhVien().getTenThanhVien(), ql.getMaThanhVien().getMaPhuongXa(),
								ql.getMaThanhVien().getMaQuanHuyen(), ql.getMaThanhVien().getMaThanhPho(),
								ql.getMaSach().getTenSach(), ql.getTinhTrang() });
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
		list3 = banDoc.getBaoCaoNhaXuatBan();
		for (int i = 0; i < list3.size(); i++) {
			nhaXuatBan1.addItem(list3.get(i).getNhaXuatBan());
		}

		theLoaiSach1 = new JComboBox<>();
		theLoaiSach1.setPreferredSize(new Dimension(170, 20));
		list4 = banDoc.getBaoCaoTheLoaiSach(nhaXuatBan1.getSelectedItem().toString());
		for (int i = 0; i < list4.size(); i++) {
			theLoaiSach1.addItem(list4.get(i).getTheLoaiSach());

		}
		nhaXuatBan1.addItemListener(itemListener3);
		theLoaiSach1.addItemListener(itemListener4);

		panelBaoCao3 = new JPanel();
		JPanel panelThongKe = new JPanel();
		JLabel label6 = new JLabel("Thống Kê Đầu Sách");
		label6.setFont(new Font("Arial", Font.BOLD, 20));
		panelThongKe.add(label6);
		panelBaoCao3.add(panelThongKe);
		panelBaoCao3.setLayout(new BorderLayout());
		panelBaoCao3.setLayout(new BoxLayout(panelBaoCao3, BoxLayout.Y_AXIS));
		/**********************************/
		panelBaoCao4 = new JPanel();
		listBaoCao1 = new JButton("Danh Sách");
		panelBaoCao4.setLayout(new GridBagLayout());
		addItem(panelBaoCao4, new JLabel("Tác Giả:"), 0, 0, 1, 1, GridBagConstraints.EAST);
		addItem(panelBaoCao4, new JLabel("Nhà Xuất Bản:"), 0, 1, 1, 1, GridBagConstraints.EAST);
		addItem(panelBaoCao4, new JLabel("Thể Loại Sách:"), 1, 1, 1, 1, GridBagConstraints.EAST);
		addItem(panelBaoCao4, tacGia1, 1, 0, 2, 1, GridBagConstraints.WEST);
		addItem(panelBaoCao4, listBaoCao1, 2, 0, 2, 1, GridBagConstraints.WEST);
		addItem(panelBaoCao4, nhaXuatBan1, 1, 1, 1, 1, GridBagConstraints.WEST);
		addItem(panelBaoCao4, theLoaiSach1, 2, 1, 1, 1, GridBagConstraints.WEST);
		panelBaoCao5 = new JPanel();
		Border border6 = BorderFactory.createLineBorder(Color.RED);
		panelBaoCao4.setPreferredSize(new Dimension(750, 200));
		panelBaoCao4.setBorder(border6);
		panelBaoCao5.add(panelBaoCao4);

		// panelBaoCao5.add(listBaoCao1);
		panelBaoCao3.add(panelBaoCao5);
		// panelBaoCao3.add(panelBaoCao5);
		/**********************************/
		JPanel pnTable4 = new JPanel();
		Border border4 = BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitle4 = BorderFactory.createTitledBorder(border4, "Thống Kê Sách");
		model4 = new DefaultTableModel();
		model4.addColumn("Mã Sách");
		model4.addColumn("Tên Sách");
		model4.addColumn("Tác Giả");
		model4.addColumn("Nhà Xuất Bản");
		model4.addColumn("Thể Loại Sách");
		model4.addColumn("Năm Xuất Bản");
		model4.addColumn("Số Lượng");
		model4.addColumn("Số Lượng Còn Lại");
		JTable tbl4 = new JTable(model4);
		tbl4.getTableHeader().setReorderingAllowed(false);
		tbl4.setDefaultEditor(Object.class, null);
		JScrollPane sc4 = new JScrollPane(tbl4);
		sc4.setPreferredSize(new Dimension(970, 300));
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
		setSize(1500, 800);
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
		MuontraButTon.addActionListener(this);
		listBaoCao.addActionListener(this);
		listBaoCao1.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == menu) {

			card.show(cardPanel, "TrangChu");
		}

		if (e.getSource() == mnuFileNew) {

			card.show(cardPanel, "quanLyThongTin");
			ArrayList<QuanLy_BanDoc> list = thuVienDao.getAllBanDoc();
			model.setRowCount(0);
			for (QuanLy_BanDoc ql : list) {
				model.addRow(new String[] { ("" + ql.getMaThanhVien()), ql.getTenThanhVien(), ql.getSoNha(),
						ql.getMaPhuongXa(), ql.getMaQuanHuyen(), ql.getMaThanhPho(), ql.getSDT(), ql.getEmail() });
			}

		}

		if (e.getSource() == mnuFileOpen) {

			card.show(cardPanel, "quanLySach");
			ArrayList<QuanLySach> listSach = sachDao.getAllSach();
			model1.setRowCount(0);
			for (QuanLySach sach : listSach) {
				model1.addRow(new String[] { ("" + sach.getMaSach()), sach.getTenSach(), sach.getTacGia(),
						sach.getNhaXuatBan(), sach.getTheLoaiSach(), sach.getNamXuatBan(), sach.getSoLuong() });
			}
		}
		if (e.getSource() == mnFile) {
			card.show(cardPanel, "MuonTra");
		}
		if (e.getSource() == baocao) {
			card.show(cardPanel, "baocao1");
			ArrayList<muon_TraSach> list = banDoc.getAllBaoCaoBanDoc();
			model3.setRowCount(0);
			for (muon_TraSach ql : list) {
				model3.addRow(new String[] { ("" + ql.getMaThanhVien().getMaThanhVien()),
						ql.getMaThanhVien().getTenThanhVien(), ql.getMaThanhVien().getMaPhuongXa(),
						ql.getMaThanhVien().getMaQuanHuyen(), ql.getMaThanhVien().getMaThanhPho(),
						ql.getMaSach().getTenSach(), ql.getTinhTrang() });
			}
		}
		if (e.getSource() == baocao1) {
			card.show(cardPanel, "baocao2");
			ArrayList<QuanLySach> listBaoCao = sachDao.getAllSach();
			model4.setRowCount(0);
			for (int i = 0; i < listBaoCao.size(); i++) {
				model4.addRow(new String[] { ("" + listBaoCao.get(i).getMaSach()), listBaoCao.get(i).getTenSach(),
						listBaoCao.get(i).getTacGia(), listBaoCao.get(i).getNhaXuatBan(),
						listBaoCao.get(i).getTheLoaiSach(), listBaoCao.get(i).getNamXuatBan(),
						listBaoCao.get(i).getSoLuong(), listBaoCao.get(i).getSoLuongTonKho() });
			}
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
			if (quanLyBanDoc.getTenThanhVien().equals("") || quanLyBanDoc.getSoNha().equals("")
					|| quanLyBanDoc.getSDT().equals("") || quanLyBanDoc.getEmail().equals("")) {
				JOptionPane.showMessageDialog(null, "Vui lòng nhập dữ liệu.");
			} else {
				int ret = JOptionPane.showConfirmDialog(null, "Bạn có muốn thêm thành viên này?", "Quản Lý Bạn Đọc",
						JOptionPane.YES_NO_OPTION);
				if (ret == JOptionPane.YES_OPTION) {
					thuVienDao.addBanDoc(quanLyBanDoc);
					ArrayList<QuanLy_BanDoc> list = thuVienDao.getAllBanDoc();
					model.setRowCount(0);
					for (QuanLy_BanDoc ql : list) {
						model.addRow(new String[] { "" + ql.getMaThanhVien(), ql.getTenThanhVien(), ql.getSoNha(),
								ql.getMaPhuongXa(), ql.getMaQuanHuyen(), ql.getMaThanhPho(), ql.getSDT(),
								ql.getEmail() });
					}
					JOptionPane.showMessageDialog(null, "Thêm thành công");
					tenThanhVien.setText("");
					DiaChi.setText("");
					DienThoai.setText("");
					Email.setText("");
					tenThanhVien.requestFocus();
				} else if (ret == JOptionPane.NO_OPTION) {

				}
			}

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
			if (quanLyBanDoc.getTenThanhVien().equals("") || quanLyBanDoc.getSoNha().equals("")
					|| quanLyBanDoc.getSDT().equals("") || quanLyBanDoc.getEmail().equals("")) {
				JOptionPane.showMessageDialog(null, "Vui lòng nhập dữ liệu.");
			} else {
				int ret = JOptionPane.showConfirmDialog(null, "Bạn có muốn sửa thành viên này?", "Quản Lý Bạn Đọc",
						JOptionPane.YES_NO_OPTION);
				if (ret == JOptionPane.YES_OPTION) {
					thuVienDao.UpdateBanDoc(quanLyBanDoc);
					ArrayList<QuanLy_BanDoc> list = thuVienDao.getAllBanDoc();
					model.setRowCount(0);
					for (QuanLy_BanDoc ql : list) {
						model.addRow(new String[] { "" + ql.getMaThanhVien(), ql.getTenThanhVien(), ql.getSoNha(),
								ql.getMaPhuongXa(), ql.getMaQuanHuyen(), ql.getMaThanhPho(), ql.getSDT(),
								ql.getEmail() });
					}
					maThanhVien.setText("");
					tenThanhVien.setText("");
					DiaChi.setText("");
					DienThoai.setText("");
					Email.setText("");
					maThanhVien.requestFocus();
				} else if (ret == JOptionPane.NO_OPTION) {

				}

			}

		}

		/**
		 * Xóa sanh sách bạn đọc.
		 */
		if (e.getSource() == buton2) {
			QuanLy_BanDoc quanLyBanDoc = new QuanLy_BanDoc();
			quanLyBanDoc.setMaThanhVien(maThanhVien.getText());
			if (quanLyBanDoc.getMaThanhVien().equals("")) {
				JOptionPane.showMessageDialog(null, "Vui lòng nhập mã thành viên cần xóa.");
			} else {
				int ret = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa thành viên này?", "Quản Lý Bạn Đọc",
						JOptionPane.YES_NO_OPTION);
				if (ret == JOptionPane.YES_OPTION) {
					thuVienDao.DeleteBanDoc(quanLyBanDoc);
					ArrayList<QuanLy_BanDoc> list = thuVienDao.getAllBanDoc();
					model.setRowCount(0);
					for (QuanLy_BanDoc ql : list) {
						model.addRow(new String[] { "" + ql.getMaThanhVien(), ql.getTenThanhVien(), ql.getSoNha(),
								ql.getMaPhuongXa(), ql.getMaQuanHuyen(), ql.getMaThanhPho(), ql.getSDT(),
								ql.getEmail() });
					}
					maThanhVien.setText("");
					tenThanhVien.setText("");
					DiaChi.setText("");
					DienThoai.setText("");
					Email.setText("");
				} else if (ret == JOptionPane.NO_OPTION) {

				}

			}

		}

		/**
		 * Tìm kiếm danh sách bạn đọc.
		 */
		if (e.getSource() == seach) {
			QuanLy_BanDoc quanLyBanDoc = new QuanLy_BanDoc();
			quanLyBanDoc.setTenThanhVien(timkiembandoc.getText());
			if (quanLyBanDoc.getTenThanhVien().equals("")) {
				JOptionPane.showMessageDialog(null, "Vui lòng nhập tên thành viên cần tìm.");
			} else {
				if (thuVienDao.kiemTra(tenThanhVien.getText())) {
					ArrayList<QuanLy_BanDoc> listSeach = thuVienDao.SeachBanDoc(quanLyBanDoc);
					model.setRowCount(0);
					for (QuanLy_BanDoc ql : listSeach) {
						model.addRow(new String[] { "" + ql.getMaThanhVien(), ql.getTenThanhVien(), ql.getSoNha(),
								ql.getMaPhuongXa(), ql.getMaQuanHuyen(), ql.getMaThanhPho(), ql.getSDT(),
								ql.getEmail() });
					}
				} else {
					JOptionPane.showMessageDialog(null, "Tên thành viên không tồn tại.");
				}

				timkiembandoc.setText("");
			}

		}

		/**
		 * In ra danh sách bạn đọc.
		 */
		if (e.getSource() == buton3) {
			maThanhVien.setText("");
			tenThanhVien.setText("");
			DiaChi.setText("");
			DienThoai.setText("");
			Email.setText("");
			buton1.setEnabled(true);
			buton.setEnabled(true);
			buton2.setEnabled(true);
			seach.setEnabled(true);
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
			maSach.setText("");
			tenSach.setText("");
			tacGia.setText("");
			namXuatBan.setText("");
			soLuong.setText("");
			themSach.setEnabled(true);
			suaSach.setEnabled(true);
			xoaSach.setEnabled(true);
			seachSach.setEnabled(true);
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
			if (quanly.getTenSach().equals("") || quanly.getTacGia().equals("") || quanly.getNamXuatBan().equals("")
					|| quanly.getSoLuong().equals("")) {
				JOptionPane.showMessageDialog(null, "Vui lòng nhập dữ liệu");

			} else {
				int ret = JOptionPane.showConfirmDialog(null, "Bạn có muốn thêm sách này?", "Quản Lý Sách",
						JOptionPane.YES_NO_OPTION);
				if (ret == JOptionPane.YES_OPTION) {
					sachDao.addSach(quanly);
					ArrayList<QuanLySach> listSach = sachDao.getAllSach();
					model1.setRowCount(0);
					for (QuanLySach sach : listSach) {
						model1.addRow(new String[] { ("" + sach.getMaSach()), sach.getTenSach(), sach.getTacGia(),
								sach.getNhaXuatBan(), sach.getTheLoaiSach(), sach.getNamXuatBan(), sach.getSoLuong() });
					}
					tenSach.setText("");
					tacGia.setText("");
					namXuatBan.setText("");
					soLuong.setText("");
				} else if (ret == JOptionPane.NO_OPTION) {

				}

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
			if (quanly.getTenSach().equals("") || quanly.getTacGia().equals("") || quanly.getNamXuatBan().equals("")
					|| quanly.getSoLuong().equals("")) {
				JOptionPane.showMessageDialog(null, "Vui lòng nhập dữ liệu");
			} else {
				int ret = JOptionPane.showConfirmDialog(null, "Bạn có muốn sửa sách này?", "Quản Lý Sách",
						JOptionPane.YES_NO_OPTION);
				if (ret == JOptionPane.YES_OPTION) {
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
				} else if (ret == JOptionPane.NO_OPTION) {

				}

			}

		}

		/**
		 * Xóa Sách trong hệ thống sách.
		 */
		if (e.getSource() == xoaSach) {
			QuanLySach quanly = new QuanLySach();
			quanly.setMaSach(maSach.getText());
			if (quanly.getMaSach().equals("")) {
				JOptionPane.showMessageDialog(null, "Vui lòng nhập mã sách cần xóa");
			} else {
				int ret = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa sách này?", "Quản Lý Sách",
						JOptionPane.YES_NO_OPTION);
				if (ret == JOptionPane.YES_OPTION) {
					sachDao.DeleteSach(quanly);
					ArrayList<QuanLySach> listSach = sachDao.getAllSach();
					model1.setRowCount(0);
					for (QuanLySach sach : listSach) {
						model1.addRow(new String[] { ("" + sach.getMaSach()), sach.getTenSach(), sach.getTacGia(),
								sach.getNhaXuatBan(), sach.getTheLoaiSach(), sach.getNamXuatBan(), sach.getSoLuong() });
					}
					maSach.setText("");
					JOptionPane.showMessageDialog(null, "Xóa Thành Công.");
				} else if (ret == JOptionPane.NO_OPTION) {

				}

			}

		}

		/**
		 * Tìm kiếm sách Trong hệ thống theo tên Sách.
		 */
		if (e.getSource() == seachSach) {
			QuanLySach quanly = new QuanLySach();
			quanly.setTenSach(TimKiemSach.getText());
			if (quanly.getTenSach().equals("")) {
				JOptionPane.showMessageDialog(null, "Vui lòng nhập tên sách cần tìm");
			} else {
				if (sachDao.kiemTraSach(TimKiemSach.getText())) {
					ArrayList<QuanLySach> listTimKiem = sachDao.SeachSach(quanly);
					model1.setRowCount(0);
					for (QuanLySach sach : listTimKiem) {
						model1.addRow(new String[] { ("" + sach.getMaSach()), sach.getTenSach(), sach.getTacGia(),
								sach.getNhaXuatBan(), sach.getTheLoaiSach(), sach.getNamXuatBan(), sach.getSoLuong() });
					}
				} else {
					JOptionPane.showMessageDialog(null, "Tên sách không tồn tại");
				}

				TimKiemSach.setText("");
			}

		}
		/**
		 * 
		 * Quản lý mượn Sách.
		 */
		if (e.getSource() == themMuon) {
			int i = dao.layMaGiaoDich() + 1;
			for (int a = 0; a < listTextField.size(); a++) {
				boolean kiemTra = false;
				if (listTextField.get(a).getText().equals("") || maThanhVien1.getText().equals("")
						|| datePicker.getJFormattedTextField().getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Vui lòng không để trống");
				} else {
					ArrayList<Integer> mylist = dao.KiemTraTinhHinhMuon(Integer.parseInt(maThanhVien1.getText()));
					if (mylist.isEmpty()) {
						quanLyMuonSach(a, i);
					} else {
						for (int j = 0; j < mylist.size(); j++) {
							if (listTextField.get(a).getText().equals("" + mylist.get(j))) {
								kiemTra = false;
								break;
							} else {
								kiemTra = true;
							}
						}

						if (kiemTra) {
							quanLyMuonSach(a, i);
						} else {
							JOptionPane.showMessageDialog(null,
									"Bạn đã mượn sách có mã sách số : " + listTextField.get(a).getText());
						}

					}
				}

			}

		}
		/**
		 * 
		 * Quản lý trả Sach
		 */
		if (e.getSource() == suaMuon) {
			for (int a = 0; a < listTextField.size(); a++) {
				if (listTextField.get(a).getText().equals("") || maThanhVien1.getText().equals("")
						|| datePicker1.getJFormattedTextField().getText().equals("")) {
					JOptionPane.showMessageDialog(null, "Vui lòng không để trống");
				} else {

					muon_TraSach muonTra = new muon_TraSach();
					muonTra.setNgayTra(datePicker1.getJFormattedTextField().getText());
					QuanLy_BanDoc quanly = new QuanLy_BanDoc();
					quanly.setMaThanhVien(maThanhVien1.getText());
					muonTra.setMaThanhVien(quanly);
					QuanLySach sach = new QuanLySach();
					sach.setMaSach(listTextField.get(a).getText());
					muonTra.setMaSach(sach);
					if (muonTra.getMaSach().getMaSach().matches("[0-9]+")
							&& muonTra.getMaThanhVien().getMaThanhVien().matches("[0-9]+")) {
						if (dao.TraSach(muonTra)) {
							dao.UpDateSoLuongSachTra(Integer.parseInt(listTextField.get(a).getText()));
							ArrayList<muon_TraSach> listMuonTra = dao.getAllMuon_Tra();
							model2.setRowCount(0);
							for (muon_TraSach muonTra1 : listMuonTra) {
								model2.addRow(new String[] { ("" + muonTra1.getMaGiaoDich()), muonTra1.getNgayMuon(),
										muonTra1.getNgayTra(), muonTra.getMaThanhVien().getMaThanhVien(),
										muonTra1.getMaThanhVien().getTenThanhVien(), muonTra1.getMaSach().getMaSach(),
										muonTra1.getMaSach().getTenSach(), muonTra1.getTinhTrang() });
							}
						} else {
							JOptionPane.showMessageDialog(null, "Sai mã thành viên hoặc mã sách");
						}
					} else {
						JOptionPane.showMessageDialog(null, "Mã sách hoặc mã thành viên không hợp lệ");
					}

				}

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
						muonTra.getNgayTra(), muonTra.getMaThanhVien().getMaThanhVien(),
						muonTra.getMaThanhVien().getTenThanhVien(), muonTra.getMaSach().getMaSach(),
						muonTra.getMaSach().getTenSach(), muonTra.getTinhTrang() });
			}
			/**
			 * Tìm kiếm danh sách mượn-trả theo mã thành viên
			 */
		}
		if (e.getSource() == MuontraButTon) {
			QuanLy_BanDoc quanLyBanDoc = new QuanLy_BanDoc();
			quanLyBanDoc.setMaThanhVien(MuonTraTextField.getText());
			muon_TraSach Muon_Tra = new muon_TraSach();
			Muon_Tra.setMaThanhVien(quanLyBanDoc);
			if (quanLyBanDoc.getMaThanhVien().equals("")) {
				JOptionPane.showMessageDialog(null, "Vui lòng nhập mã thành viên cần tìm");
			} else {
				ArrayList<muon_TraSach> listMuonTra = dao.getSeachByMaThanhVien(quanLyBanDoc);
				model2.setRowCount(0);
				for (muon_TraSach muonTra : listMuonTra) {
					model2.addRow(new String[] { ("" + muonTra.getMaGiaoDich()), muonTra.getNgayMuon(),
							muonTra.getNgayTra(), muonTra.getMaThanhVien().getTenThanhVien(),
							muonTra.getMaSach().getTenSach(), muonTra.getTinhTrang() });
				}
			}
			MuonTraTextField.setText("");
		}
		/**
		 * 
		 * báo cáo danh sách theo mã thành viên.
		 */
		if (e.getSource() == listBaoCao) {
			muon_TraSach muon = new muon_TraSach();
			QuanLy_BanDoc quanly1 = new QuanLy_BanDoc();
			quanly1.setMaThanhVien(maThanhVien2.getText());
			muon.setMaThanhVien(quanly1);
			if (quanly1.getMaThanhVien().equals("")) {
				JOptionPane.showMessageDialog(null, "Vui lòng nhập mã thành viên cần tìm");
			} else {
				ArrayList<muon_TraSach> list1 = banDoc.getBaoCaoBanDocByMa(muon);
				model3.setRowCount(0);
				for (muon_TraSach ql : list1) {
					model3.addRow(new String[] { ("" + ql.getMaThanhVien().getMaThanhVien()),
							ql.getMaThanhVien().getTenThanhVien(), ql.getMaThanhVien().getMaPhuongXa(),
							ql.getMaThanhVien().getMaQuanHuyen(), ql.getMaThanhVien().getMaThanhPho(),
							ql.getMaSach().getTenSach(), ql.getTinhTrang() });
				}
			}

		}
		/**
		 * Thống kê sách theo tác giả
		 */
		if (e.getSource() == listBaoCao1) {
			ArrayList<QuanLySach> listBaoCao = sachDao.getAllSach();
			model4.setRowCount(0);
			for (int i = 0; i < listBaoCao.size(); i++) {
				if (listBaoCao.get(i).getTacGia().equals(tacGia1.getText())) {
					model4.addRow(new String[] { ("" + listBaoCao.get(i).getMaSach()), listBaoCao.get(i).getTenSach(),
							listBaoCao.get(i).getTacGia(), listBaoCao.get(i).getNhaXuatBan(),
							listBaoCao.get(i).getTheLoaiSach(), listBaoCao.get(i).getNamXuatBan(),
							listBaoCao.get(i).getSoLuong(), listBaoCao.get(i).getSoLuongTonKho() });
				} else {
					JOptionPane.showMessageDialog(null, "Vui lòng nhập tác giả muốn hiển thị");
					break;
				}
			}
			tacGia1.setText("");
		}

	}

	public void quanLyMuonSach(int a, int i) {
		if (dao.kiemTra(maThanhVien1.getText()) && dao.kiemTraSach(listTextField.get(a).getText())) {
			if (dao.kiemTraSoLuong(Integer.parseInt(listTextField.get(a).getText()))) {
				dao.MuonSach(datePicker.getJFormattedTextField().getText(), Integer.parseInt(maThanhVien1.getText()),
						Integer.parseInt(listTextField.get(a).getText()), i);
				dao.UpDateSoLuongSach(Integer.parseInt(listTextField.get(a).getText()));
				ArrayList<muon_TraSach> listMuonTra = dao.getAllMuon_Tra();
				model2.setRowCount(0);
				for (muon_TraSach muonTra : listMuonTra) {
					model2.addRow(new String[] { ("" + muonTra.getMaGiaoDich()), muonTra.getNgayMuon(),
							muonTra.getNgayTra(), muonTra.getMaThanhVien().getMaThanhVien(),
							muonTra.getMaThanhVien().getTenThanhVien(), muonTra.getMaSach().getMaSach(),
							muonTra.getMaSach().getTenSach(), muonTra.getTinhTrang() });
				}
			} else {
				JOptionPane.showMessageDialog(null, "Số lượng sách không đủ");
			}

		} else {
			JOptionPane.showMessageDialog(null, "Sai thành viên hoặc mã sách.");
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
