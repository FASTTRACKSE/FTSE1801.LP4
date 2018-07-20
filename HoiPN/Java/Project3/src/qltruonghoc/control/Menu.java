package qltruonghoc.control;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class Menu extends JFrame implements ActionListener {
	JPanel headerPanel, menuPanel, centerPanel, trangChuPanel, sinhVienPanel,lopPanel,monHocPanel,thongKePanel,cardPanel;
	JButton sinhVienButton, monHocButton, lopButton, thongKeButton, trangChuButton;
	CardLayout card,card1;
	JLabel jLabel,jLabel1,jLabel2,jLabel3,jLabel4;
	
	JTextField maSvField,tenSvField,diaChiField,sdtField,emailField;
	JComboBox tpComb,quanComb,phuongComb;
	JButton themSvButton,suaSvButton,xoaSvButton; 
	JTable svTable;
	DefaultTableModel svDtm;
	
	JTextField maLopField,tenLopField,namHocField;
	JButton themLopButton,suaLopButton,xoaLopButton,xemDsButton;
	JTable lopTable;
	DefaultTableModel lopDtm;
	JComboBox locTheoNam,locTheoLop;
	
	JTextField maMonField,tenMonField,soTinChiField,thoiLuongField;
	JButton themMonButton,suaMonButton,xoaMonButton; 
	JTable monTable;
	DefaultTableModel monDtm;
	
	JTable dssvTable;
	DefaultTableModel dssvDtm;
	
	JTable dsLopTable;
	DefaultTableModel dsLopDtm;
	
	JButton show1,show2;
	JPanel thongKeBang,dssvBang,dsLopBang;
	
	public Menu() {
		super("Quản lý trường học");
		
		JPanel jPanel = new JPanel();
		jPanel.setLayout(new BorderLayout());
		
		/**
		 * Tạo header
		 */
		
		headerPanel = new JPanel();
		headerPanel.setBackground(Color.RED);
		jPanel.add(headerPanel, BorderLayout.NORTH);
		headerPanel.setPreferredSize(new Dimension(1000, 100));
		JLabel tieuDe = new JLabel("Chương trình quản lý trường học");
		Font fontTieuDe = new Font("Arial", Font.BOLD| Font.ITALIC,35);
		tieuDe.setFont(fontTieuDe);
		headerPanel.add(tieuDe);
		
		/**
		 * Tạo phần menu
		 */
		
		menuPanel = new JPanel();
		JPanel jPanel2 = new JPanel();
		menuPanel.setBackground(Color.CYAN);
		menuPanel.setPreferredSize(new Dimension(200, 700));
		jPanel.add(menuPanel, BorderLayout.WEST);
		sinhVienButton = new JButton("Quản lý sinh viên");
		sinhVienButton.setPreferredSize(new Dimension(150, 40));
		monHocButton = new JButton("Quản lý môn học");
		monHocButton.setPreferredSize(new Dimension(150, 40));
		lopButton = new JButton("Quản lý lớp học");
		lopButton.setPreferredSize(new Dimension(150, 40));
		thongKeButton = new JButton("Thống kê báo cáo");
		thongKeButton.setPreferredSize(new Dimension(150, 40));
		trangChuButton = new JButton("Trang chủ");
		trangChuButton.setPreferredSize(new Dimension(150, 40));
		menuPanel.add(jPanel2);
		jPanel2.add(trangChuButton);
		jPanel2.add(sinhVienButton);
		jPanel2.add(monHocButton);
		jPanel2.add(lopButton);
		jPanel2.add(thongKeButton);
		menuPanel.setLayout(new BoxLayout(menuPanel, BoxLayout.Y_AXIS));
		
		/**
		 * Tạo phần center
		 */
		
		centerPanel = new JPanel();
		centerPanel.setBackground(Color.PINK);
		jPanel.add(centerPanel, BorderLayout.CENTER);
		
		cardPanel = new JPanel();
		centerPanel.add(cardPanel);
		
		trangChuPanel = new JPanel();
		jLabel = new JLabel("day la trnag chu1");
		trangChuPanel.add(jLabel);
		cardPanel.add(trangChuPanel);
		
		//Trang quản lý sinh viên.*****************************************************************************
		sinhVienPanel = new JPanel();
		JLabel svLabel = new JLabel("Quản lý sinh viên");
		Font font1 = new Font("Arial", Font.BOLD| Font.ITALIC,30);
		svLabel.setFont(font1);
		
		JPanel  svNhap = new JPanel();
		JPanel svPn1 = new JPanel();svNhap.add(svPn1);
		svPn1.setLayout(new BoxLayout(svPn1, BoxLayout.Y_AXIS));
		Font font = new Font("Arial", Font.BOLD| Font.ITALIC,16);
		JLabel labelSV1 = new JLabel("Mã sinh viên: ");labelSV1.setFont(font);svPn1.add(labelSV1);
		JLabel labelSV2 = new JLabel("Họ tên: ");labelSV2.setFont(font);svPn1.add(labelSV2);
		JLabel labelSV3 = new JLabel("Điện thoại: ");labelSV3.setFont(font);svPn1.add(labelSV3);
		JLabel labelSV4 = new JLabel("Email: ");labelSV4.setFont(font);svPn1.add(labelSV4);
		
		JPanel svPn2 = new JPanel();svNhap.add(svPn2);
		svPn2.setLayout(new BoxLayout(svPn2, BoxLayout.Y_AXIS));
		maSvField = new JTextField(20);svPn2.add(maSvField);
		tenSvField = new JTextField(20);svPn2.add(tenSvField);	
		sdtField = new JTextField(20);svPn2.add(sdtField);
		emailField = new JTextField(20);svPn2.add(emailField);
		
		JPanel svPn3 = new JPanel();svNhap.add(svPn3);
		svPn3.setLayout(new BoxLayout(svPn3, BoxLayout.Y_AXIS));
		JLabel labelSV5 = new JLabel("Tỉnh/Thành phố: ");labelSV5.setFont(font);svPn3.add(labelSV5);
		JLabel labelSV6 = new JLabel("Quận: ");labelSV6.setFont(font);svPn3.add(labelSV6);
		JLabel labelSV7 = new JLabel("Phường: ");labelSV7.setFont(font);svPn3.add(labelSV7);
		JLabel labelSV8 = new JLabel("Địa chỉ(số nhà): ");labelSV8.setFont(font);svPn3.add(labelSV8);
		
		JPanel svPn4 = new JPanel();svNhap.add(svPn4);
		svPn4.setLayout(new BoxLayout(svPn4, BoxLayout.Y_AXIS));
		tpComb = new JComboBox();svPn4.add(tpComb);tpComb.setPreferredSize(new Dimension(150, 20	));
		quanComb = new JComboBox();svPn4.add(quanComb);quanComb.setPreferredSize(new Dimension(150, 20));
		phuongComb = new JComboBox();svPn4.add(phuongComb);phuongComb.setPreferredSize(new Dimension(150, 20));
		diaChiField = new JTextField(20);svPn4.add(diaChiField);
		
		JPanel  svbtn = new JPanel();
		themSvButton = new JButton("Thêm sinh viên");svbtn.add(themSvButton);
		suaSvButton = new JButton("Sửa sinh viên");svbtn.add(suaSvButton);
		xoaSvButton = new JButton("Xóa sinh viên");svbtn.add(xoaSvButton);
		
		
		JPanel  svBang = new JPanel();

		svDtm = new DefaultTableModel();
		svDtm.addColumn("Mã SV");
		svDtm.addColumn("Tên SV");
		svDtm.addColumn("Địa chỉ");
		svDtm.addColumn("Phường");
		svDtm.addColumn("Quận");
		svDtm.addColumn("Thành phố");
		svDtm.addColumn("Số điện thoại");
		svDtm.addColumn("Email");
		svTable = new JTable(svDtm);
		svTable.getTableHeader().setReorderingAllowed(false);
		svTable.setDefaultEditor(Object.class, null);
		
		JScrollPane scMon = new JScrollPane(svTable);
		scMon.setPreferredSize(new Dimension(700, 500));

		Border border = BorderFactory.createLineBorder(Color.RED,2);
		TitledBorder borderTitle = BorderFactory.createTitledBorder(border, "Danh sách sinh viên");
		svBang.setBorder(borderTitle);
		svBang.add(scMon);
		
		
		sinhVienPanel.add(svLabel);
		sinhVienPanel.add(svNhap);
		sinhVienPanel.add(svbtn);
		sinhVienPanel.add(svBang);
		sinhVienPanel.setLayout(new BoxLayout(sinhVienPanel, BoxLayout.Y_AXIS));
		
		//Kết thúc trang quản lý sinh viên.********************************************************************************
		
		//Trang quản lý lớp học.*******************************************************************************************
		
		lopPanel = new JPanel();
		JLabel lopLabel = new JLabel("Quản lý lớp học");
		Font font4 = new Font("Arial", Font.BOLD| Font.ITALIC,30);
		lopLabel.setFont(font4);
		
		JPanel lopKhu2 = new JPanel();
		
		JPanel lopXemDS = new JPanel();lopKhu2.add(lopXemDS);
		lopXemDS.setLayout(new BoxLayout(lopXemDS, BoxLayout.Y_AXIS));
		JLabel label = new JLabel("Danh sách sinh viên");lopXemDS.add(label);
		Font lbfont = new Font("Arial", Font.BOLD| Font.ITALIC,16);label.setFont(lbfont);
		JPanel panel = new JPanel();lopXemDS.add(panel);
		Font lbfont1 = new Font("Arial", Font.BOLD| Font.ITALIC,14);label.setFont(lbfont1);
		JLabel label2 = new JLabel("Lọc theo năm học");panel.add(label2);label2.setFont(lbfont1);
		locTheoNam = new JComboBox();panel.add(locTheoNam);locTheoNam.setPreferredSize(new Dimension(150, 25));
		JPanel panel1 = new JPanel();lopXemDS.add(panel1);
		JLabel label3 = new JLabel("Lọc theo lớp học  ");panel1.add(label3);label3.setFont(lbfont1);
		locTheoLop = new JComboBox();panel1.add(locTheoLop);locTheoLop.setPreferredSize(new Dimension(150, 25));
		xemDsButton =new JButton("Xem danh sách");lopXemDS.add(xemDsButton);
		Border borderLop1 = BorderFactory.createLineBorder(Color.BLACK);lopXemDS.setBorder(borderLop1);
		
		JPanel  lopNhap = new JPanel();lopKhu2.add(lopNhap);
		lopNhap.setLayout(new  BoxLayout(lopNhap, BoxLayout.Y_AXIS));
		JPanel panel2 = new JPanel();lopNhap.add(panel2);
		
		JPanel lopPn1 = new JPanel();panel2.add(lopPn1);
		lopPn1.setLayout(new BoxLayout(lopPn1, BoxLayout.Y_AXIS));
		Font font5 = new Font("Arial", Font.BOLD| Font.ITALIC,16);
		JLabel labelLop1 = new JLabel("Mã Lớp: ");labelLop1.setFont(font5);lopPn1.add(labelLop1);
		JLabel labelLop2 = new JLabel("Tên lớp: ");labelLop2.setFont(font5);lopPn1.add(labelLop2);
		JLabel labelLop3 = new JLabel("Năm học: ");labelLop3.setFont(font5);lopPn1.add(labelLop3);
		
		JPanel lopPn2 = new JPanel();panel2.add(lopPn2);
		lopPn2.setLayout(new BoxLayout(lopPn2, BoxLayout.Y_AXIS));
		maLopField = new JTextField(20);lopPn2.add(maLopField);
		tenLopField = new JTextField(20);lopPn2.add(tenLopField);	
		namHocField = new JTextField(20);lopPn2.add(namHocField);

		JPanel lopMenu = new JPanel();lopNhap.add(lopMenu);
		JPanel lopPn3 = new JPanel();lopMenu.add(lopPn3);
		themLopButton = new JButton("Thêm lớp");lopPn3.add(themLopButton);
		suaLopButton = new JButton("Sửa lớp");lopPn3.add(suaLopButton);
		xoaLopButton = new JButton("Xóa lớp");lopPn3.add(xoaLopButton);
		lopNhap.setBorder(borderLop1);
		
		
		JPanel  lopBang = new JPanel();

		lopDtm = new DefaultTableModel();
		lopDtm.addColumn("Mã lớp");
		lopDtm.addColumn("Tên lớp");
		lopDtm.addColumn("Năm học");
		lopTable = new JTable(lopDtm);
		lopTable.getTableHeader().setReorderingAllowed(false);
		lopTable.setDefaultEditor(Object.class, null);
		
		JScrollPane scLop = new JScrollPane(lopTable);
		scLop.setPreferredSize(new Dimension(700, 500));

		Border borderLop = BorderFactory.createLineBorder(Color.RED,2);
		TitledBorder borderTitleLop = BorderFactory.createTitledBorder(borderLop, "Danh sách Lớp");
		lopBang.setBorder(borderTitleLop);
		lopBang.add(scLop);
		
		
		lopPanel.add(lopLabel);
		lopPanel.add(lopKhu2);
		lopPanel.add(lopBang);
		lopPanel.setLayout(new BoxLayout(lopPanel, BoxLayout.Y_AXIS));
		
		//Kết thuc quản lý lớp học.***************************************************************************************
		
		//Trang quản lý môn học.*******************************************************************************************
		
		monHocPanel = new JPanel();
		JLabel monLabel = new JLabel("Quản lý môn học");
		Font font2 = new Font("Arial", Font.BOLD| Font.ITALIC,30);
		monLabel.setFont(font2);
		
		JPanel  monNhap = new JPanel();
		JPanel monPn1 = new JPanel();monNhap.add(monPn1);
		monPn1.setLayout(new BoxLayout(monPn1, BoxLayout.Y_AXIS));
		Font font3 = new Font("Arial", Font.BOLD| Font.ITALIC,16);
		JLabel labelMon1 = new JLabel("Mã môn học: ");labelMon1.setFont(font3);monPn1.add(labelMon1);
		JLabel labelMon2 = new JLabel("Tên môn học: ");labelMon2.setFont(font3);monPn1.add(labelMon2);
		JLabel labelMon3 = new JLabel("Số tín chỉ: ");labelMon3.setFont(font3);monPn1.add(labelMon3);
		JLabel labelMon4 = new JLabel("Thời lượng: ");labelMon4.setFont(font3);monPn1.add(labelMon4);
		
		JPanel monPn2 = new JPanel();monNhap.add(monPn2);
		monPn2.setLayout(new BoxLayout(monPn2, BoxLayout.Y_AXIS));
		maMonField = new JTextField(20);monPn2.add(maMonField);
		tenMonField = new JTextField(20);monPn2.add(tenMonField);	
		soTinChiField = new JTextField(20);monPn2.add(soTinChiField);
		thoiLuongField = new JTextField(20);monPn2.add(thoiLuongField);

		
		JPanel monMenu = new JPanel();
		JPanel monPn3 = new JPanel();monMenu.add(monPn3);
		themMonButton = new JButton("Thêm môn học");monPn3.add(themMonButton);
		suaMonButton = new JButton("Sửa môn học");monPn3.add(suaMonButton);
		xoaMonButton = new JButton("Xóa môn học");monPn3.add(xoaMonButton);
		
		
		JPanel  monBang = new JPanel();

		monDtm = new DefaultTableModel();
		monDtm.addColumn("Mã môn học");
		monDtm.addColumn("Tên môn học");
		monDtm.addColumn("Số tín chỉ");
		monDtm.addColumn("Thời lượng");
		monTable = new JTable(monDtm);
		monTable.getTableHeader().setReorderingAllowed(false);
		monTable.setDefaultEditor(Object.class, null);
		
		JScrollPane scMonhoc = new JScrollPane(monTable);
		scMonhoc.setPreferredSize(new Dimension(700, 500));

		Border borderMon = BorderFactory.createLineBorder(Color.RED,2);
		TitledBorder borderTitleMon = BorderFactory.createTitledBorder(borderMon, "Danh sách môn học");
		monBang.setBorder(borderTitleMon);
		monBang.add(scMonhoc);
		
		
		monHocPanel.add(monLabel);
		monHocPanel.add(monNhap);
		monHocPanel.add(monMenu);
		monHocPanel.add(monBang);
		monHocPanel.setLayout(new BoxLayout(monHocPanel, BoxLayout.Y_AXIS));
		
		//Kết thuc quản lý môn học.***************************************************************************************
		
		
		//Trang thống kê.***************************************************************************************
		
		thongKePanel = new JPanel();
		JLabel thongKeLabel = new JLabel("Báo cáo thống kê");
		Font font6 = new Font("Arial", Font.BOLD | Font.ITALIC, 30);
		thongKeLabel.setFont(font6);

		JPanel thongKeNhap = new JPanel();
		
		Font fontTit = new Font("Arial", Font.BOLD| Font.ITALIC,16);
		
		JComboBox comb1 = new JComboBox();
		comb1.setPreferredSize(new Dimension(125, 30));
		comb1.addItem("Năm học");
		JComboBox comb2 = new JComboBox();
		comb2.addItem("Lớp");comb2.setPreferredSize(new Dimension(125, 30));
		show1= new JButton("Xem danh sách");
		JLabel dsLopLabel = new JLabel("Báo cáo danh sách lớp học");dsLopLabel.setFont(fontTit);
		JComboBox comb3 = new JComboBox();
		comb3.addItem("Năm học");comb3.setPreferredSize(new Dimension(125, 30));
		JLabel dssvLabel = new JLabel("Báo cáo danh sách sinh viên");dssvLabel.setFont(fontTit);
		show2= new JButton("Xem danh sách");
		
		thongKeNhap.setLayout(new GridBagLayout());
		addItem(thongKeNhap, dssvLabel, 0, 0, 1, 1, GridBagConstraints.WEST);
		addItem(thongKeNhap, comb1, 0, 1, 1, 1, GridBagConstraints.WEST);
		addItem(thongKeNhap, comb2, 0, 2, 1, 1, GridBagConstraints.WEST);
		addItem(thongKeNhap, show1, 0, 3, 1, 1, GridBagConstraints.WEST);
		
		addItem(thongKeNhap, dsLopLabel, 1, 0, 1, 1, GridBagConstraints.WEST);
		addItem(thongKeNhap, comb3, 1, 1, 1, 1, GridBagConstraints.WEST);
		addItem(thongKeNhap, new JLabel(""), 1, 2, 1, 1, GridBagConstraints.WEST);
		addItem(thongKeNhap, show2, 1, 3, 1, 1, GridBagConstraints.WEST);

		thongKeBang = new JPanel();	
		dssvBang = new JPanel();
		dssvDtm = new DefaultTableModel();
		dssvDtm.addColumn("Mã sinh viên");
		dssvDtm.addColumn("Tên sinh viên");
		dssvDtm.addColumn("Java");
		dssvDtm.addColumn("HTML");
		dssvDtm.addColumn("English");
		dssvDtm.addColumn("CSS");
		dssvDtm.addColumn("ĐTB");
		dssvDtm.addColumn("Xếp loại");
		dssvTable = new JTable(dssvDtm);
		dssvTable.getTableHeader().setReorderingAllowed(false);
		dssvTable.setDefaultEditor(Object.class, null);
		
		JScrollPane scDssv = new JScrollPane(dssvTable);
		scDssv.setPreferredSize(new Dimension(700, 500));

		Border borderDssv = BorderFactory.createLineBorder(Color.RED,2);
		TitledBorder borderTitleDssv = BorderFactory.createTitledBorder(borderDssv, "Danh sách sinh viên");
		Font fontTit1 = new Font("Arial", Font.BOLD| Font.ITALIC,15);
		borderTitleDssv.setTitleFont(fontTit1);
		dssvBang.setBorder(borderTitleDssv);
		dssvBang.add(scDssv);
		
		dsLopBang = new JPanel();
		dsLopDtm = new DefaultTableModel();
		dsLopDtm.addColumn("Mã lớp");
		dsLopDtm.addColumn("Tên lớp");
		dsLopDtm.addColumn("Năm học");
		dsLopDtm.addColumn("Số sinh viên");
		dsLopTable = new JTable(dsLopDtm);
		dsLopTable.getTableHeader().setReorderingAllowed(false);
		dsLopTable.setDefaultEditor(Object.class, null);
		
		JScrollPane scDsLop = new JScrollPane(dsLopTable);
		scDsLop.setPreferredSize(new Dimension(700, 500));

		Border borderDsLop = BorderFactory.createLineBorder(Color.RED,2);
		TitledBorder borderTitleDsLop = BorderFactory.createTitledBorder(borderDsLop, "Danh sách lớp học");
		Font fontTit2 = new Font("Arial", Font.BOLD| Font.ITALIC,15);
		borderTitleDsLop.setTitleFont(fontTit2);
		dsLopBang.setBorder(borderTitleDsLop);
		dsLopBang.add(scDsLop);
		
		card1 = new CardLayout();
		thongKeBang.setLayout(card1);
		thongKeBang.add(dssvBang,"dssvBang");
		thongKeBang.add(dsLopBang,"dsLopBang");
		
		thongKePanel.add(thongKeLabel);
		thongKePanel.add(thongKeNhap);
		thongKePanel.add(thongKeBang);
		thongKePanel.setLayout(new BoxLayout(thongKePanel, BoxLayout.Y_AXIS));
		
		//Kết thuc thống kê.***************************************************************************************
		
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
	}

	public void display() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(1000, 900);
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
	
	public static void main(String[] args) {
		Menu menu = new Menu();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
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
		} else if(e.getSource() == show1){
			card1.show(thongKeBang, "dssvBang");
		} else if(e.getSource()==show2) {
			card1.show(thongKeBang, "dsLopBang");
		}
	}

}
