package quanlytruonghoc.control;


import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import quanlytruonghoc.entity.MonHoc;
import quanlytruonghoc.model.MonDao;
/**
 * TimKiemMonHoc Class
 * @author CongMT
 *
 */
public class TimKiemMonHoc extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	ArrayList<String> listMaMon, listTenMon;
	String theoMaMon, theoTenMon;
	Font font;
	JComboBox<String> timTheoMaMon, timTheoTenMon;
	MonDao monDao;
	ArrayList<MonHoc> listMonHoc;
	JButton timKiemMonBt, quayLaiMonBt;
	JPanel timKiemMonBang,timKiemMonPn;
	JTable monTable1;
	DefaultTableModel timMonDtm;
	Container conn;

	public TimKiemMonHoc() {
		// Trang tìm kiếm môn học.*********************
		monDao = new MonDao();
		// Tiêu đề trang tìm kiếm lớp
		JLabel timKiemMonLabel = new JLabel("Tìm kiếm môn học");
		timKiemMonLabel.setIcon(new ImageIcon("icon\\bookshelf-icon.png"));
		font = new Font("Arial", Font.BOLD | Font.ITALIC, 40);
		timKiemMonLabel.setFont(font);
		timKiemMonLabel.setAlignmentX(CENTER_ALIGNMENT);

		// Phần nhập các thông tin tìm kiếm
		timKiemMonPn = new JPanel();
		timKiemMonPn.setLayout(new BoxLayout(timKiemMonPn, BoxLayout.Y_AXIS));
		JPanel nhapMonpn = new JPanel();
		timKiemMonPn.add(nhapMonpn);
		nhapMonpn.setLayout(new BoxLayout(nhapMonpn, BoxLayout.X_AXIS));

		// Thực hiện nút chọn đến combox mã môn học
		JPanel panelTimKiemMaMon = new JPanel();
		nhapMonpn.add(panelTimKiemMaMon);
		font = new Font("Arial", Font.BOLD | Font.ITALIC, 20);

		JLabel labelMaMon = new JLabel("Tìm theo mã môn học:");
		labelMaMon.setFont(font);
		panelTimKiemMaMon.add(labelMaMon);

		timTheoMaMon = new JComboBox<>();
		panelTimKiemMaMon.add(timTheoMaMon);
		timTheoMaMon.setPreferredSize(new Dimension(150, 25));
		timTheoMaMon.addItem("Mã môn");

		// Thực hiện nút chọn đến combox tên môn học
		JPanel panelTimKiemTenMon = new JPanel();
		nhapMonpn.add(panelTimKiemTenMon);
		JLabel labelTenMon = new JLabel("Tìm theo tên môn: ");
		labelTenMon.setFont(font);
		panelTimKiemTenMon.add(labelTenMon);

		timTheoTenMon = new JComboBox<>();
		panelTimKiemTenMon.add(timTheoTenMon);
		timTheoTenMon.setPreferredSize(new Dimension(150, 25));
		timTheoTenMon.addItem("Tên môn học");

		// Chạy sự kiện theo để lấy ra tất cả mã môn học và lấy tên lớp học từ mã môn

		listMaMon = new ArrayList<String>();
		listMaMon = monDao.getAllMaMonHoc();
		for (int i = 0; i < listMaMon.size(); i++) {
			timTheoMaMon.addItem(listMaMon.get(i));
		}
		timTheoMaMon.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					theoMaMon = timTheoMaMon.getSelectedItem().toString();
					timTheoTenMon.removeAllItems();
					listTenMon = monDao.getAllTenMonHoc(theoMaMon);
					for (int i = 0; i < listTenMon.size(); i++) {
						timTheoTenMon.addItem(listTenMon.get(i));
					}
				}
			}
		});
		timTheoTenMon.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					theoTenMon = timTheoTenMon.getSelectedItem().toString();
				}
			}
		});

		// Tạo button
		
		JPanel timKiemMonBton = new JPanel();
		timKiemMonPn.add(timKiemMonBton);
		JPanel timKiemMon = new JPanel();
		timKiemMonBton.add(timKiemMon);
		
		Border borderLop1 = BorderFactory.createLineBorder(Color.BLACK);
		timKiemMonBt = new JButton("Tìm kiếm");
		timKiemMonBt.setIcon(new ImageIcon("icon\\Search-icon (2).png"));
		timKiemMonBt.setFont(font);
		timKiemMon.add(timKiemMonBt);
		quayLaiMonBt = new JButton("Quay lại");
		quayLaiMonBt.setIcon(new ImageIcon("icon\\User-Interface-Login-icon.png"));
		quayLaiMonBt.setFont(font);
		timKiemMon.add(quayLaiMonBt);
		timKiemMonPn.setPreferredSize(new Dimension(450, 100));
		timKiemMonPn.setBorder(borderLop1);

		// Tạo bảng table cho phần hiển thị cho trang tìm kiếm lớp
		timKiemMonBang = new JPanel();
		timMonDtm = new DefaultTableModel();
		timMonDtm.addColumn("Mã môn học");
		timMonDtm.addColumn("Tên môn học");
		timMonDtm.addColumn("Tín chỉ");
		timMonDtm.addColumn("Thường lượng");

		monTable1 = new JTable(timMonDtm);
		monTable1.getTableHeader().setReorderingAllowed(false);
		monTable1.setDefaultEditor(Object.class, null);
		monTable1.setFont(font);
		monTable1.getTableHeader().setFont(font);
		JScrollPane scTimKiemMon = new JScrollPane(monTable1, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scTimKiemMon.setPreferredSize(new Dimension(1400, 570));
		listMonHoc = new ArrayList<MonHoc>();
		listMonHoc = monDao.getAllMonHoc();
		for (MonHoc monHoc : listMonHoc) {
			timMonDtm.addRow(new String[] { monHoc.getIdMonHoc(), monHoc.getTenMonHoc(), monHoc.getTinChi(),
					monHoc.getThoiLuongHoc() });
		}

		Border bordertimKiemMon = BorderFactory.createLineBorder(Color.RED, 2);
		TitledBorder titledTimKiemMon = BorderFactory.createTitledBorder(bordertimKiemMon, "Danh sách môn học");
		timKiemMonBang.setBorder(titledTimKiemMon);
		timKiemMonBang.add(scTimKiemMon);

		conn = getContentPane();
		conn.add(timKiemMonLabel);
		conn.add(timKiemMonPn);
		conn.add(timKiemMonBang);

		conn.setLayout(new BoxLayout(conn, BoxLayout.Y_AXIS));

		// Kết thúc tìm kiếm lớp học.*********************
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		MonHoc monHoc = new MonHoc();
		// Nút tìm kiếm môn học trong tìm kiếm môn
				if (e.getSource() == timKiemMonBt) {
					monHoc.setIdMonHoc(theoMaMon);
					monHoc.setTenMonHoc(theoTenMon);
					if (timTheoMaMon.getSelectedItem().toString().equals("Mã môn")) {
						JOptionPane.showMessageDialog(null, " Mời bạn chọn mã sinh viên!!");
					} else {
						try {
							timMonDtm.setRowCount(0);
							listMonHoc = new ArrayList<MonHoc>();
							listMonHoc = monDao.showTableMonTimKiem(monHoc);

							for (MonHoc monHoc1 : listMonHoc) {
								timMonDtm.addRow(new String[] { monHoc1.getIdMonHoc(), monHoc1.getTenMonHoc(),
										monHoc1.getTinChi(), monHoc1.getThoiLuongHoc() });
							}
						} catch (Exception e2) {
							JOptionPane.showMessageDialog(null, "Tìm thất bại!!");
						}
					}
				}
	}

}
