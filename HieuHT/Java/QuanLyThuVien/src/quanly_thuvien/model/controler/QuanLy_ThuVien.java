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

import quanly_thuvien.model.dao.thuvienDao;

import quanly_thuvien.model.entity.Phuong;
import quanly_thuvien.model.entity.Quan;

import quanly_thuvien.model.entity.QuanLy_BanDoc;
import quanly_thuvien.model.entity.ThanhPho;

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

	ArrayList<ThanhPho> list;
	ArrayList<Quan> list1;
	ArrayList<Phuong> list2;
	String tenThanhPho = null;
	String tenQuanHuyen = null;

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

	int j = 3;
	int x = 1;
	int a = 0;

	public QuanLy_ThuVien() {

		super("Phầm Mềm Quản Lý Thư Viện Điện Tử");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		thuVienDao = new thuvienDao();
		// sachDao = new SachDao();
		// banDoc = new banDocDao();
		// dao = new Tra_MuonDao();
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
		baocao = new JButton("Danh Sách Bạn Đọc");
		baocao.setPreferredSize(new Dimension(200, 40));
		baocao1 = new JButton("Thống Kê Đầu Sách");
		baocao1.setPreferredSize(new Dimension(200, 40));
		jpanel.add(menu);
		jpanel.add(mnuFileNew);
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
		ImageIcon img1 = new ImageIcon("D:\\Thuvienanh\\thuvien.png");
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
		addItem(panel11, new JLabel("Phường:"), 0, 2, 1, 1, GridBagConstraints.EAST);
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
		 * 
		 * Cardlayout
		 */
		card = new CardLayout();
		cardPanel.setLayout(card);
		cardPanel.add(panel3, "TrangChu");
		cardPanel.add(panel, "quanLyThongTin");
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
		baocao.addActionListener(this);
		baocao1.addActionListener(this);
		buton.addActionListener(this);
		buton1.addActionListener(this);
		buton2.addActionListener(this);
		seach.addActionListener(this);
		buton3.addActionListener(this);

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
					tenThanhVien.requestFocus();
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
