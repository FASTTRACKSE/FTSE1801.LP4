package quanlytruonghoc.control;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
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

import quanlytruonghoc.entity.SinhVien;
import quanlytruonghoc.model.LopDao;
import quanlytruonghoc.model.SinhVienDao;

public class TimKiemSinhVien extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	JCheckBox chk1, chk2, chk3, chk4;
	JTextField text;
	JComboBox<String> lopSeach, tpSeach, quanSeach;
	JPanel pnCheck;
	JButton seach, xacNhan, back;
	DefaultTableModel tkSvDtm;
	JTable tkSvTable;
	String tenTP, tenQuan, tenPhuong;
	Container con;
	LopDao lopDao;
	SinhVienDao sinhVienDao;
	ArrayList<String> listTp, listQuan, listXaPhuong, listNamHoc, listNamHoc1, listTenLop, listMaLop, listTenMonHoc;
	ArrayList<SinhVien> listSinhVien;

	public TimKiemSinhVien() {
		sinhVienDao = new SinhVienDao();
		lopDao = new LopDao();
		con = getContentPane();
		Font font34 = new Font("Arial", Font.BOLD | Font.ITALIC, 40);
		JLabel jl = new JLabel("Tìm kiếm sinh viên");

		jl.setFont(font34);
		pnCheck = new JPanel();
		pnCheck.setLayout(new GridLayout(2, 4));
		Border bor2 = BorderFactory.createEtchedBorder(Color.BLUE, Color.RED);
		Font font32 = new Font("Arial", Font.BOLD | Font.ITALIC, 25);
		TitledBorder titlebor2 = new TitledBorder(bor2, "Lọc sinh viên theo:");
		titlebor2.setTitleFont(font32);
		pnCheck.setBorder(titlebor2);
		chk1 = new JCheckBox("Lớp học");
		pnCheck.add(chk1);
		chk1.setFont(font32);
		lopSeach = new JComboBox<>();
		pnCheck.add(lopSeach);
		lopSeach.setEnabled(false);
		chk2 = new JCheckBox("Tỉnh/Thành phố");
		pnCheck.add(chk2);
		chk2.setFont(font32);
		tpSeach = new JComboBox<>();
		pnCheck.add(tpSeach);
		tpSeach.setEnabled(false);
		chk3 = new JCheckBox("Tên sinh viên");
		pnCheck.add(chk3);
		chk3.setFont(font32);
		text = new JTextField(15);
		pnCheck.add(text);
		text.setEnabled(false);
		chk4 = new JCheckBox("Quận/Huyện");
		pnCheck.add(chk4);
		chk4.setFont(font32);
		quanSeach = new JComboBox<>();
		pnCheck.add(quanSeach);
		quanSeach.setEnabled(false);

		listMaLop = new ArrayList<String>();
		listMaLop = lopDao.getAllMaLop();
		lopSeach.addItem("");
		tpSeach.addItem("");

		for (int i = 0; i < listMaLop.size(); i++) {
			lopSeach.addItem(listMaLop.get(i));
		}

		listTp = new ArrayList<String>();
		listTp = sinhVienDao.getAllThanhPho();
		for (int i = 0; i < listTp.size(); i++) {
			tpSeach.addItem(listTp.get(i));
		}

		tpSeach.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					tenTP = tpSeach.getSelectedItem().toString();
					quanSeach.removeAllItems();
					listQuan = sinhVienDao.getAllQuanHuyen(tenTP);
					quanSeach.addItem("");
					for (int i = 0; i < listQuan.size(); i++) {
						quanSeach.addItem(listQuan.get(i));
					}
				}
			}
		});

		quanSeach.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					tenQuan = quanSeach.getSelectedItem().toString();
				}
			}
		});

		JPanel timKiemSvBang = new JPanel();
		Font font33 = new Font("Arial", Font.BOLD | Font.ITALIC, 14);
		tkSvDtm = new DefaultTableModel();
		tkSvDtm.addColumn("Mã SV");
		tkSvDtm.addColumn("Tên SV");
		tkSvDtm.addColumn("Mã lớp");
		tkSvDtm.addColumn("Email");
		tkSvDtm.addColumn("Số điện thoại");
		tkSvDtm.addColumn("Địa chỉ");
		tkSvDtm.addColumn("Phường");
		tkSvDtm.addColumn("Quận");
		tkSvDtm.addColumn("Thành phố");

		tkSvTable = new JTable(tkSvDtm);
		tkSvTable.getTableHeader().setReorderingAllowed(false);
		tkSvTable.setDefaultEditor(Object.class, null);
		tkSvTable.setFont(font33);
		tkSvTable.getTableHeader().setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 25));
		JScrollPane scMonTk = new JScrollPane(tkSvTable, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scMonTk.setPreferredSize(new Dimension(1400, 500));

		Border borderTk = BorderFactory.createLineBorder(Color.RED, 2);
		TitledBorder borderTitleTk = BorderFactory.createTitledBorder(borderTk, "Danh sách sinh viên");
		borderTitleTk.setTitleFont(font33);
		timKiemSvBang.setBorder(borderTitleTk);
		timKiemSvBang.add(scMonTk);

		listSinhVien = new ArrayList<SinhVien>();
		listSinhVien = sinhVienDao.getAllSinhVien();
		for (SinhVien sinhVien : listSinhVien) {
			tkSvDtm.addRow(new String[] { sinhVien.getIdSinhVien(), sinhVien.getHoTen(), sinhVien.getIdLop(),
					sinhVien.getEmail(), sinhVien.getSdt(), sinhVien.getDiaChi(), sinhVien.getPhuong().getNamePhuong(),
					sinhVien.getQuan(), sinhVien.getThanhpho() });
		}
		// displayAllSv(listSinhVien);
		JPanel jPanel3 = new JPanel();
		xacNhan = new JButton("Xác nhận", new ImageIcon("img\\confirm-notification-icon.png"));
		jPanel3.add(xacNhan);
		seach = new JButton("Tìm kiếm", new ImageIcon("img\\zoom-seach-icon.png"));
		jPanel3.add(seach);
		seach.setEnabled(false);
		back = new JButton("Quay lại", new ImageIcon("icon\\\\User-Interface-Login-icon.png"));
		jPanel3.add(back);
		jl.setAlignmentX(CENTER_ALIGNMENT);
		con.add(jl);
		con.add(pnCheck);
		con.add(jPanel3);
		con.add(timKiemSvBang);
		con.setLayout(new BoxLayout(con, BoxLayout.Y_AXIS));

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		SinhVien sinhvien = new SinhVien();

		if (e.getSource() == xacNhan) {
			if (chk1.isSelected()) {
				lopSeach.setEnabled(true);
			} else {
				lopSeach.setEnabled(false);
				lopSeach.setSelectedItem("");
			}

			if (chk2.isSelected()) {
				tpSeach.setEnabled(true);
			} else {
				tpSeach.setEnabled(false);
				tpSeach.setSelectedItem("");
			}

			if (chk3.isSelected()) {

				text.setEnabled(true);
			} else {
				text.setEnabled(false);
				text.setText("");
			}

			if (chk4.isSelected()) {
				quanSeach.setEnabled(true);
			} else {
				quanSeach.setEnabled(false);
				quanSeach.setSelectedItem("");
			}

			if (chk1.isSelected() || chk2.isSelected() || chk3.isSelected() || chk4.isSelected()) {
				seach.setEnabled(true);
			} else {
				seach.setEnabled(false);
			}

			if (!chk1.isSelected() && !chk2.isSelected() && !chk3.isSelected() && !chk4.isSelected()) {
				JOptionPane.showMessageDialog(null, "Bạn cần chọn mục tìm kiếm!!!");
			}

		} else if (e.getSource() == seach) {
			try {
				sinhvien.setHoTen(text.getText());
				sinhvien.setIdLop(lopSeach.getSelectedItem().toString());
				sinhvien.setThanhpho(tenTP);
				sinhvien.setQuan(tenQuan);
				tkSvDtm.setRowCount(0);
				listSinhVien = new ArrayList<SinhVien>();

				listSinhVien = sinhVienDao.timSvTheoTen(sinhvien);

				for (SinhVien sinhVien : listSinhVien) {
					tkSvDtm.addRow(new String[] { sinhVien.getIdSinhVien(), sinhVien.getHoTen(), sinhVien.getIdLop(),
							sinhVien.getEmail(), sinhVien.getSdt(), sinhVien.getDiaChi(),
							sinhVien.getPhuong().getNamePhuong(), sinhVien.getQuan(), sinhVien.getThanhpho() });
				}
			} catch (Exception er) {
				JOptionPane.showMessageDialog(null, "Bạn cần chọn mục tìm kiếm");
			}

		} 

	}

}
