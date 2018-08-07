import java.awt.Color;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
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

import quanlysv.moi.model.SinhVienDAO;
import quanlysv.moi.model.entity.SinhVien;

public class QuanLySinhVien extends JFrame implements ActionListener {
	JTextField id;
	JTextField name;
	JTextField age;
	JButton luu;
	JButton moi;
	JButton xoa;
	JButton thoat;
	JTable table;
	JPanel pnTable;
	DefaultTableModel dtm;
	SinhVienDAO sinhVienDao;
	ArrayList<SinhVien> list;
	ArrayList<String> listMSV;
	String chon;
	JTable tbl;
	int row, col;
	String maSV, tenSV, tuoiSV;
	String msv = null;

	public QuanLySinhVien() {
		super("Quản lí sinh viên");
		sinhVienDao = new SinhVienDAO();
		JPanel header = new JPanel();
		JLabel tieuDe = new JLabel("Chương trình quản lí sinh viên");
		header.add(tieuDe);

		JPanel nhapThongTin = new JPanel();

		id = new JTextField(20);
		name = new JTextField(20);
		age = new JTextField(20);

		nhapThongTin.setLayout(new GridBagLayout());
		addItem(nhapThongTin, new JLabel("Mã sinh viên: "), 0, 0, 1, 1, GridBagConstraints.EAST);
		addItem(nhapThongTin, new JLabel("Tên sinh viên: "), 0, 1, 1, 1, GridBagConstraints.EAST);
		addItem(nhapThongTin, new JLabel("Tuổi: "), 0, 2, 1, 1, GridBagConstraints.EAST);

		addItem(nhapThongTin, id, 1, 0, 2, 1, GridBagConstraints.WEST);
		addItem(nhapThongTin, name, 1, 1, 1, 1, GridBagConstraints.WEST);
		addItem(nhapThongTin, age, 1, 2, 2, 1, GridBagConstraints.WEST);
		
		JPanel jPanel = new JPanel();
		listMSV = sinhVienDao.getAllMaSinhVien();
		System.out.println(listMSV);
		JComboBox comboBox = new JComboBox();
		for(int i = 0; i< listMSV.size(); i++) {
			comboBox.addItem(listMSV.get(i));
			
		}
		JComboBox comboBox1 = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				msv = comboBox.getSelectedItem().toString();
//				JOptionPane.showMessageDialog(null,"ma la" + msv);
				comboBox1.removeAllItems();
				comboBox1.addItem(msv);
				
			}
		});
		
		
		
	
		jPanel.add(comboBox);
		jPanel.add(comboBox1);

		JPanel chucNang = new JPanel();
		luu = new JButton("Lưu");
		moi = new JButton("Mới");
		xoa = new JButton("Xóa");
		thoat = new JButton("Thoát");
		chucNang.add(luu);
		chucNang.add(moi);
		chucNang.add(xoa);
		chucNang.add(thoat);

		pnTable = new JPanel();

		dtm = new DefaultTableModel();
		dtm.addColumn("Mã SV");
		dtm.addColumn("Tên SV");
		dtm.addColumn("Tuổi");
		tbl = new JTable(dtm);
		tbl.getTableHeader().setReorderingAllowed(false);
		tbl.setDefaultEditor(Object.class, null);
		tbl.setEnabled(true);

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
				row = tbl.getSelectedRow();
				col = tbl.getSelectedColumn();
				String s = String.valueOf(tbl.getValueAt(row, 0));
				id.setText(s);
				String s1 = String.valueOf(tbl.getValueAt(row, 1));
				name.setText(s1);
				String s2 = String.valueOf(tbl.getValueAt(row, 2));
				age.setText(s2);
			}
		});

		JScrollPane sc = new JScrollPane(tbl);

		Border border = BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitle = BorderFactory.createTitledBorder(border, "Danh sách");
		pnTable.setBorder(borderTitle);
		pnTable.add(sc);

		Container con = getContentPane();
		con.setLayout(new BoxLayout(con, BoxLayout.Y_AXIS));
		con.add(header);
		con.add(nhapThongTin);
		con.add(chucNang);
		con.add(jPanel);
		con.add(pnTable);

		list = sinhVienDao.getAllSinhVien();
		for (SinhVien sinhVien : list) {
			dtm.addRow(new String[] { sinhVien.getMaSinhVien(), sinhVien.getTenSinhVien(),
					String.valueOf(sinhVien.getTuoi()) });
		}
		exportExcel(tbl);
		display();
		setAction();
	}

	private void addItem(JPanel nhapThongTin, JComponent cpn, int i, int j, int k, int l, int east) {
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

		nhapThongTin.add(cpn, gbc);

	}

	private void setAction() {
		luu.addActionListener(this);
		moi.addActionListener(this);
		xoa.addActionListener(this);
		thoat.addActionListener(this);
	}

	private void display() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(500, 800);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public boolean check(String maSV, String tenSV, String tuoi) {
		boolean kiemTra = true;
		String kt1 = "[A-Z]{3}\\d{3}";
		if (maSV.matches(kt1)) {

		} else {
			JOptionPane.showMessageDialog(null, "Ma sinh vien sai");
			id.selectAll();
			id.requestFocus();
			kiemTra = false;
		}

		String kt2 = "[A-Z][a-z]*( [A-Z][a-z])*";
		if (tenSV.matches(kt2)) {

		} else {
			JOptionPane.showMessageDialog(null, "ten sinh vien sai");
			name.selectAll();
			name.requestFocus();
			kiemTra = false;
		}

		String kt3 = "[0-9]{1,2}";
		if (tuoiSV.matches(kt3)) {

		} else {
			JOptionPane.showMessageDialog(null, "tuoi sinh vien sai");
			age.selectAll();
			age.requestFocus();
			kiemTra = false;
		}
		return kiemTra;
	}

	public static void main(String[] args) {
		QuanLySinhVien qlsv = new QuanLySinhVien();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == luu) {
			SinhVien sinhVien = new SinhVien();
			maSV = id.getText();
			tenSV = name.getText();
			tuoiSV = age.getText();
			if (check(maSV, tenSV, tuoiSV)) {
				sinhVien.setMaSinhVien(maSV);
				sinhVien.setTenSinhVien(tenSV);
				sinhVien.setTuoi(Integer.parseInt(tuoiSV));

				sinhVienDao.addSinhVien(sinhVien);
				JOptionPane.showMessageDialog(null, "them thanh cong");
			}
		}

		if (e.getSource() == moi) {
			id.setText("");
			id.requestFocus();
			name.setText("");
			age.setText("");
			dtm.setRowCount(0);
			list = sinhVienDao.getAllSinhVien();
			for (SinhVien sinhVien1 : list) {
				dtm.addRow(new String[] { sinhVien1.getMaSinhVien(), sinhVien1.getTenSinhVien(),
						String.valueOf(sinhVien1.getTuoi()) });
			}
		}

		if (e.getSource() == xoa) {
			if (id.getText().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Xoa khong thanh cong");
			} else {
				SinhVien sinhVien = new SinhVien();
				sinhVien.setMaSinhVien(id.getText());

				sinhVienDao.deleteSinhVien(sinhVien);
				JOptionPane.showMessageDialog(null, "Xoa thanh cong");
			}

		}

		if (e.getSource() == thoat) {
			System.exit(0);
		}
	}
	
	public void exportExcel(JTable table) {
		 JFileChooser chooser = new JFileChooser();
		 int i = chooser.showSaveDialog(chooser);
		 if (i == JFileChooser.APPROVE_OPTION) {
		  File file = chooser.getSelectedFile();
		  try {
		   FileWriter out = new FileWriter(file + ".xls");
		   
		   BufferedWriter bwrite = new BufferedWriter(out);
//		   BufferedWriter bwrite = new BufferedWriter
//				    (new OutputStreamWriter(new FileOutputStream(file + ".xls"), StandardCharsets.UTF_8));
		   DefaultTableModel model = (DefaultTableModel) table.getModel();
		   // lay ten Cot
		   for (int j = 0; j < table.getColumnCount(); j++) {
		    bwrite.write(model.getColumnName(j).toString() + "\t");
		   }
		   bwrite.write("\n");
		   
		   // Lay du lieu dong
		   
		   for (int j = 0; j < table.getRowCount(); j++) {
		    for (int k = 0; k < table.getColumnCount(); k++) {
		     bwrite.write(model.getValueAt(j, k).toString() + "\t");
		    }
		    bwrite.write("\n");
		   }
		   bwrite.close();
		   JOptionPane.showMessageDialog(null, "Lưu file thành công!");
		  } catch (Exception e2) {
		   JOptionPane.showMessageDialog(null, "Lỗi khi lưu file!");
		  }
		 }
		}
}
