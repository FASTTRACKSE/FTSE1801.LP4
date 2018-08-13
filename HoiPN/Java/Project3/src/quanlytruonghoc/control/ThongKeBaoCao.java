package quanlytruonghoc.control;

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
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import quanlytruonghoc.entity.Lop;
import quanlytruonghoc.entity.SinhVien;
import quanlytruonghoc.model.LopDao;
import quanlytruonghoc.model.MonDao;
import quanlytruonghoc.model.ThongKeDao;

public class ThongKeBaoCao extends JFrame implements ActionListener{
	JTable dssvTable;
	DefaultTableModel dssvDtm;
	JPanel tieudePanel;
	JTable dsLopTable;
	DefaultTableModel dsLopDtm;
	JComboBox comb1, comb2, comb3;
	ArrayList<String> listNamHoc,listTenLop,listTenMonHoc;
	String theoNam;
	LopDao lopDao;
	MonDao monDao;
	ThongKeDao thongKeDao;
	CardLayout card;
	ArrayList<SinhVien> listSinhVien;
	ArrayList<Lop> listDsLop;

	JButton show1, show2;
	JPanel thongKeBang, dssvBang, dsLopBang;
	
	Container con;
	public ThongKeBaoCao() {
		con = getContentPane();
		lopDao = new LopDao();
		monDao = new MonDao();
		thongKeDao = new ThongKeDao();
		Font font = new Font("Arial", Font.BOLD | Font.ITALIC, 25);
		JLabel thongKeLabel = new JLabel("Báo cáo thống kê");
		Font font6 = new Font("Arial", Font.BOLD | Font.ITALIC, 40);
		thongKeLabel.setFont(font6);
		thongKeLabel.setAlignmentX(CENTER_ALIGNMENT);
		JPanel thongKeNhap = new JPanel();
		JPanel thongKeNhap1 = new JPanel();
		JPanel thongKeNhap2 = new JPanel();
		Font fontTit = new Font("Arial", Font.BOLD | Font.ITALIC, 20);

		comb1 = new JComboBox<>();
		comb1.setPreferredSize(new Dimension(150, 30));
		comb1.addItem("Năm học");
		comb2 = new JComboBox<>();
		comb2.addItem("Lớp");
		comb2.setPreferredSize(new Dimension(150, 30));
		ImageIcon icon12 = new ImageIcon("img\\eye-icon.png");
		show1 = new JButton("Xem danh sách", icon12);
		show1.setFont(font);
		JLabel dsLopLabel = new JLabel("Báo cáo danh sách lớp học");
		dsLopLabel.setFont(fontTit);
		comb3 = new JComboBox<>();
		comb3.addItem("Năm học");
		comb3.setPreferredSize(new Dimension(150, 30));
		JLabel dssvLabel = new JLabel("Báo cáo danh sách sinh viên");
		dssvLabel.setFont(fontTit);
		show2 = new JButton("Xem danh sách", icon12);
		show2.setFont(font);
		listNamHoc = new ArrayList<String>();
		listNamHoc = lopDao.getAllNamHoc();

		Set<String> set1 = new HashSet<String>(listNamHoc);
		listNamHoc = new ArrayList<String>(set1);

		for (String listNam : listNamHoc) {
			comb1.addItem(listNam);
			comb3.addItem(listNam);
		}

		comb1.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					theoNam = comb1.getSelectedItem().toString();
					comb2.removeAllItems();
					listTenLop = lopDao.getAllTenLop(theoNam);
					for (String list : listTenLop) {
						comb2.addItem(list);
					}
				}
			}
		});
		Border borderLop1 = BorderFactory.createLineBorder(Color.BLACK);
		thongKeNhap1.setPreferredSize(new Dimension(300, 160));
		thongKeNhap1.setBorder(borderLop1);
		thongKeNhap1.setLayout(new BoxLayout(thongKeNhap, BoxLayout.X_AXIS));
		thongKeNhap1.setLayout(new GridBagLayout());

		addItem(thongKeNhap1, dssvLabel, 0, 0, 1, 1, GridBagConstraints.EAST);
		addItem(thongKeNhap1, comb1, 0, 1, 1, 1, GridBagConstraints.EAST);
		addItem(thongKeNhap1, comb2, 0, 2, 1, 1, GridBagConstraints.EAST);
		addItem(thongKeNhap1, show1, 0, 3, 1, 1, GridBagConstraints.EAST);
		thongKeNhap2.setPreferredSize(new Dimension(300, 160));
		thongKeNhap2.setBorder(borderLop1);
		thongKeNhap2.setLayout(new BoxLayout(thongKeNhap1, BoxLayout.X_AXIS));
		thongKeNhap2.setLayout(new GridBagLayout());

		addItem(thongKeNhap2, dsLopLabel, 1, 0, 1, 1, GridBagConstraints.WEST);
		addItem(thongKeNhap2, comb3, 1, 1, 1, 1, GridBagConstraints.WEST);
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

		card = new CardLayout();
		thongKeBang.setLayout(card);
		thongKeBang.add(dssvBang, "dssvBang");
		thongKeBang.add(dsLopBang, "dsLopBang");

		con.add(thongKeLabel);
		con.add(thongKeNhap);
		con.add(thongKeBang);
		con.setLayout(new BoxLayout(con, BoxLayout.Y_AXIS));

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
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == show1) {
			card.show(thongKeBang, "dssvBang");
			
			listSinhVien = new ArrayList<SinhVien>();
			dssvDtm.setRowCount(0);
			listSinhVien = thongKeDao.getAllTenSinhVien(thongKeDao.getLopId(comb2.getSelectedItem().toString()));
			double dtb = 0;
			String xepLoai = null;

			for (SinhVien sinhVien : listSinhVien) {

				double diemJava = thongKeDao.getDiemThiJava(sinhVien.getIdSinhVien());
				double diemHTML = thongKeDao.getDiemThiHTML(sinhVien.getIdSinhVien());
				double diemCSS = thongKeDao.getDiemThiCSS(sinhVien.getIdSinhVien());
				double diemEnglish = thongKeDao.getDiemThiEnligh(sinhVien.getIdSinhVien());

				dtb = (diemJava + diemHTML + diemCSS + diemEnglish) / 4;
				if (dtb >= 8) {
					xepLoai = "Giỏi";
				} else if (dtb >= 6.5) {
					xepLoai = "Khá";
				} else if (dtb >= 5) {
					xepLoai = "TB";
				} else {
					xepLoai = "Yếu";
				}

				dssvDtm.addRow(new String[] { sinhVien.getIdSinhVien(), sinhVien.getHoTen(), String.valueOf(diemJava),
						String.valueOf(diemEnglish), String.valueOf(diemCSS), String.valueOf(diemHTML),
						String.valueOf(dtb), xepLoai });

			} 
		} else if(e.getSource() == show2) {
			card.show(thongKeBang, "dsLopBang");
			
			listDsLop = new ArrayList<Lop>();
			dsLopDtm.setRowCount(0);
			listDsLop = thongKeDao.getAllLopTheoNam(comb3.getSelectedItem().toString());
			for (Lop lop11 : listDsLop) {
				dsLopDtm.addRow(new String[] { lop11.getIdLop(), lop11.getTenLop(), lop11.getNamHoc(),
						String.valueOf(thongKeDao.getAllSinhVienTheoLop(lop11.getIdLop())) });
			}
		}
		
	}

}
