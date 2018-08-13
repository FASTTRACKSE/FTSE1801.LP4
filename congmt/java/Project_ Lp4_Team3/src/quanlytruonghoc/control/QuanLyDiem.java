package quanlytruonghoc.control;


import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

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
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import quanlytruonghoc.entity.Diem;
import quanlytruonghoc.entity.DiemSinhVien;
import quanlytruonghoc.model.DiemDao;
/**
 * QuanLyDiem Class
 * @author CongMT
 *
 */
public class QuanLyDiem extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	DiemDao diemDao;
	ArrayList<Double> listDiem;
	ArrayList<String> listMaSv;
	Font font;
	Border border;
	JComboBox<String>  maSinhViencb;
	JTextField jaVaField, englishField, cssField, htmlField;
	JButton themDiemButton, suaDiemButton, xoaDiemButton, lamMoiDiemButton, timkiemDiemButton, xemDiemButton;
	JPanel  diemNhap, diemBang;
	JTable diemTable;
	DefaultTableModel diemDtm;
	Container conn;
	public QuanLyDiem() {
		diemDao = new DiemDao();

		// Tiêu đề trang quản lý lớp
		JLabel diemLabel = new JLabel("Quản lý điểm");
		diemLabel.setIcon(new ImageIcon("icon\\Delicious-icon.png"));
		font = new Font("Arial", Font.BOLD | Font.ITALIC, 40);
		diemLabel.setFont(font);
		diemLabel.setAlignmentX(CENTER_ALIGNMENT);
		
		// Tạo phần nhập cho bảng điểm
		diemNhap = new JPanel();
		font = new Font("Arial", Font.BOLD | Font.ITALIC, 23);
		diemNhap.setLayout(new BoxLayout(diemNhap, BoxLayout.Y_AXIS));

		JPanel diemPn1 = new JPanel();
		diemNhap.add(diemPn1);

		JPanel diemPn2 = new JPanel();
		diemPn1.add(diemPn2);
		diemPn2.setLayout(new BoxLayout(diemPn2, BoxLayout.Y_AXIS));

		JLabel labelDiem1 = new JLabel("Mã sinh viên: ");
		JLabel labelDiem2 = new JLabel("Môn Java: ");
		JLabel labelDiem3 = new JLabel("Môn English: ");
		JLabel labelDiem4 = new JLabel("Môn CSS: ");
		JLabel labelDiem5 = new JLabel("Môn HTML: ");
		labelDiem1.setFont(font);labelDiem2.setFont(font);labelDiem3.setFont(font);labelDiem4.setFont(font);labelDiem5.setFont(font);
		diemPn2.add(labelDiem1);diemPn2.add(labelDiem2);diemPn2.add(labelDiem3);diemPn2.add(labelDiem4);diemPn2.add(labelDiem5);
		
		JPanel diemPn3 = new JPanel();
		border = BorderFactory.createLineBorder(Color.BLACK);
		diemPn1.add(diemPn3);
		diemPn3.setLayout(new BoxLayout(diemPn3, BoxLayout.Y_AXIS));

		// Mã sinh viên combox
		maSinhViencb = new JComboBox<>();
		diemPn3.add(maSinhViencb);
		maSinhViencb.addItem("Nhấp chọn");
		maSinhViencb.setPreferredSize(new Dimension(150, 30));

		// Lọc các năm học trùng nhau
		listMaSv = new ArrayList<String>();
		listMaSv = diemDao.getAllMaSv();
		Set<String> locMaSv = new HashSet<String>(listMaSv);
		listMaSv = new ArrayList<String>(locMaSv);
		for (String listMasv : listMaSv) {
			maSinhViencb.addItem(listMasv);
		}

		jaVaField = new JTextField(20);
		jaVaField.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(4, 4, 4, 4)));
		diemPn3.add(jaVaField);
		englishField = new JTextField(20);
		englishField.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(4, 4, 4, 4)));
		diemPn3.add(englishField);
		cssField = new JTextField(20);
		cssField.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(4, 4, 4, 4)));
		diemPn3.add(cssField);
		htmlField = new JTextField(20);
		htmlField.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(4, 4, 4, 4)));
		diemPn3.add(htmlField);

		JPanel diemMenu = new JPanel();
		diemNhap.add(diemMenu);
		JPanel diemPn4 = new JPanel();
		diemMenu.add(diemPn4);
		font = new Font("Arial", Font.BOLD | Font.ITALIC, 20);
		themDiemButton = new JButton("Thêm");
		themDiemButton.setIcon(new ImageIcon("icon\\add-icon.png"));
		themDiemButton.setFont(font);
		diemPn4.add(themDiemButton);
		suaDiemButton = new JButton("Sửa");
		suaDiemButton.setIcon(new ImageIcon("icon\\update-icon.png"));
		suaDiemButton.setFont(font);
		diemPn4.add(suaDiemButton);
		xoaDiemButton = new JButton("Xóa");
		xoaDiemButton.setIcon(new ImageIcon("icon\\delete-icon.png"));
		xoaDiemButton.setFont(font);
		diemPn4.add(xoaDiemButton);
		lamMoiDiemButton = new JButton("Làm mới");
		lamMoiDiemButton.setIcon(new ImageIcon("icon\\Actions-edit-redo-icon.png"));
		lamMoiDiemButton.setFont(font);
		diemPn4.add(lamMoiDiemButton);
		timkiemDiemButton = new JButton("Tìm kiếm");
		timkiemDiemButton.setIcon(new ImageIcon("icon\\Search-icon (2).png"));
		timkiemDiemButton.setFont(font);
		diemPn4.add(timkiemDiemButton);
		Border borderLop1 = BorderFactory.createLineBorder(Color.BLACK);
		diemNhap.setPreferredSize(new Dimension(550, 200));
		diemNhap.setBorder(borderLop1);

		diemBang = new JPanel();
		font = new Font("Arial", Font.BOLD | Font.ITALIC, 16);
		diemDtm = new DefaultTableModel();
		diemDtm.addColumn("Mã sinh viên");
		diemDtm.addColumn("Môn JaVa");
		diemDtm.addColumn("Môn English");
		diemDtm.addColumn("Môn CSS");
		diemDtm.addColumn("Môn HTML");
		diemTable = new JTable(diemDtm);
		diemTable.getTableHeader().setReorderingAllowed(false);
		diemTable.setDefaultEditor(Object.class, null);
		diemTable.setFont(font);
		diemTable.getTableHeader().setFont(font);
		JScrollPane scDiem = new JScrollPane(diemTable, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scDiem.setPreferredSize(new Dimension(1400, 460));
		diemTable.addMouseListener(new MouseListener() {
			public void mouseReleased(MouseEvent e) {}
			public void mousePressed(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
			public void mouseEntered(MouseEvent e) {}
			public void mouseClicked(MouseEvent e) {
				int row = diemTable.getSelectedRow();
				String s0 = (String) diemTable.getValueAt(row, 0);
				maSinhViencb.setSelectedItem(s0);
				String s = (String) diemTable.getValueAt(row, 1);
				jaVaField.setText(s);
				String s1 = (String) diemTable.getValueAt(row, 2);
				englishField.setText(s1);
				String s2 = (String) diemTable.getValueAt(row, 3);
				cssField.setText(s2);
				String s3 = (String) diemTable.getValueAt(row, 4);
				htmlField.setText(s3);
			}
		});

		Border borderDiem = BorderFactory.createLineBorder(Color.RED, 2);
		TitledBorder borderTitleDiem = BorderFactory.createTitledBorder(borderDiem, "Danh sách điểm");
		diemBang.setBorder(borderTitleDiem);
		diemBang.add(scDiem);
		
		conn = getContentPane();
		conn.add(diemLabel);
		conn.add(diemNhap);
		conn.add(diemBang);
		
		conn.setLayout(new BoxLayout(conn, BoxLayout.Y_AXIS));
		

	}


	
	@Override
	public void actionPerformed(ActionEvent e) {

		// Thực hiện lệnh gọi đến nút button
		if (e.getSource() == xemDiemButton) {

			diemDtm.setRowCount(0);
			displayAllDiem();
		}
		if (e.getSource() == themDiemButton) {// Nút thêm môn học

			List<Diem> listDiem = new ArrayList<>();
			// Tao gia tri moi cho bảng môn học

			String javaText = jaVaField.getText();
			String englishText = englishField.getText();
			String cssText = cssField.getText();
			String htmlText = htmlField.getText();

			String IdMHJava = "MH001";
			String IdMHEnglish = "MH002";
			String IdMHCSS = "MH003";
			String IdMHHTML = "MH004";

			// get id sv in combobox
			String idSvText = maSinhViencb.getSelectedItem().toString();
			List<Diem> listDiemDB = diemDao.showTableDiemTimKiem(idSvText);
			
			// Bắt lỗi các trường hợp trong nhập văn bản
			if (idSvText.equals("Nhấp chọn")) {
				JOptionPane.showMessageDialog(null, "Mời bạn chọn mã sinh viên !");
			} else if (listDiemDB.size() > 0) {
				JOptionPane.showMessageDialog(null, "Sinh viên này đã có điểm !");
			} else if (javaText.length() == 0) {
				JOptionPane.showMessageDialog(null, "Điểm Java không đươc để trống !");
			} else if (!javaText.matches("\\d*")) {
				JOptionPane.showMessageDialog(null, "Điểm Java chỉ được nhập số !");
			} else if (Double.parseDouble(javaText) <= 0 || Double.parseDouble(javaText) > 10) {
				JOptionPane.showMessageDialog(null, "Điểm Java không nhập thấp hơn 0 và lớn hơn 10!");
			} else if (englishText.length() == 0) {
				JOptionPane.showMessageDialog(null, "Điểm english không đươc để trống !");
			} else if (!englishText.matches("\\d*")) {
				JOptionPane.showMessageDialog(null, "Điểm english chỉ được nhập số !");
			} else if (Double.parseDouble(englishText) <= 0 || Double.parseDouble(englishText) > 10) {
				JOptionPane.showMessageDialog(null, "Điểm english không nhập thấp hơn 0 và lớn hơn 10!");
			} else if (cssText.length() == 0) {
				JOptionPane.showMessageDialog(null, "Điểm css  không được để trống !");
			} else if (!cssText.matches("\\d*")) {
				JOptionPane.showMessageDialog(null, "Điểm css chỉ được nhập số !");
			} else if (Double.parseDouble(cssText) <= 0 || Double.parseDouble(cssText) > 10) {
				JOptionPane.showMessageDialog(null, "Điểm css không nhập thấp hơn 0 và lớn hơn 10!");
			} else if (htmlText.length() == 0) {
				JOptionPane.showMessageDialog(null, "Điểm html không được để trống !");
			} else if (!htmlText.matches("\\d*")) {
				JOptionPane.showMessageDialog(null, "Điểm html chỉ được nhập số !");
			} else if (Double.parseDouble(htmlText) <= 0 || Double.parseDouble(htmlText) > 10) {
				JOptionPane.showMessageDialog(null, "Điểm html không nhập thấp hơn 0 và lớn hơn 10!");
			} else {

				// set diem java
				Diem diemJavaObject = new Diem();
				diemJavaObject.setIdSinhVien(idSvText);
				diemJavaObject.setIdMonHoc(IdMHJava);
				diemJavaObject.setDiemThi(Double.parseDouble(javaText));

				listDiem.add(diemJavaObject);

				// set diem java
				Diem diemEnglishObject = new Diem();
				diemEnglishObject.setIdSinhVien(idSvText);
				diemEnglishObject.setIdMonHoc(IdMHEnglish);
				diemEnglishObject.setDiemThi(Double.parseDouble(englishText));

				listDiem.add(diemEnglishObject);

				// set diem java
				Diem diemCssObject = new Diem();
				diemCssObject.setIdSinhVien(idSvText);
				diemCssObject.setIdMonHoc(IdMHCSS);
				diemCssObject.setDiemThi(Double.parseDouble(cssText));

				listDiem.add(diemCssObject);

				// set diem java
				Diem diemHTMLObject = new Diem();
				diemHTMLObject.setIdSinhVien(idSvText);
				diemHTMLObject.setIdMonHoc(IdMHHTML);
				diemHTMLObject.setDiemThi(Double.parseDouble(htmlText));

				listDiem.add(diemHTMLObject);

				int output = JOptionPane.showConfirmDialog(null, "Bạn có muốn thêm", "Thêm Điểm",JOptionPane.YES_NO_OPTION);

				if (output == JOptionPane.YES_OPTION) {
					boolean result = true;
					for (Diem diem : listDiem) {
						result = diemDao.addDiem(diem);
						if (!result) {
							break;
						}
					}
					if (result) {
						diemDtm.setRowCount(0);
						displayAllDiem();
					} else {
						JOptionPane.showMessageDialog(null, "Thêm thất bại!!");
					}
				} else if (output == JOptionPane.NO_OPTION) {
					JOptionPane.showMessageDialog(null, "Mời bạn chọn lại!!");
				}
			}
		} else if (e.getSource() == suaDiemButton) { // Nút sửa môn học

			List<Diem> listDiem = new ArrayList<>();
			// Tao gia tri moi cho bảng môn học

			String javaText = jaVaField.getText();
			String englishText = englishField.getText();
			String cssText = cssField.getText();
			String htmlText = htmlField.getText();

			String IdMHJava = "MH001";
			String IdMHEnglish = "MH002";
			String IdMHCSS = "MH003";
			String IdMHHTML = "MH004";

			// get id sv in combobox
			String idSvText = maSinhViencb.getSelectedItem().toString();

			// Bắt lỗi các trường hợp trong nhập văn bản
			if (javaText.length() == 0) {
				JOptionPane.showMessageDialog(null, "Điểm Java không đươc để trống !");
			} else if (!javaText.matches("\\d*")) {
				JOptionPane.showMessageDialog(null, "Điểm Java chỉ được nhập số !");
			} else if (Double.parseDouble(javaText) <= 0 || Double.parseDouble(javaText) > 10) {
				JOptionPane.showMessageDialog(null, "Điểm Java không nhập thấp hơn 0 và lớn hơn 10!");
			} else if (englishText.length() == 0) {
				JOptionPane.showMessageDialog(null, "Điểm english không đươc để trống !");
			} else if (!englishText.matches("\\d*")) {
				JOptionPane.showMessageDialog(null, "Điểm english chỉ được nhập số !");
			} else if (Double.parseDouble(englishText) <= 0 || Double.parseDouble(englishText) > 10) {
				JOptionPane.showMessageDialog(null, "Điểm english không nhập thấp hơn 0 và lớn hơn 10!");
			} else if (cssText.length() == 0) {
				JOptionPane.showMessageDialog(null, "Điểm css  không được để trống !");
			} else if (!cssText.matches("\\d*")) {
				JOptionPane.showMessageDialog(null, "Điểm css chỉ được nhập số !");
			} else if (Double.parseDouble(cssText) <= 0 || Double.parseDouble(cssText) > 10) {
				JOptionPane.showMessageDialog(null, "Điểm css không nhập thấp hơn 0 và lớn hơn 10!");
			} else if (htmlText.length() == 0) {
				JOptionPane.showMessageDialog(null, "Điểm html không được để trống !");
			} else if (!htmlText.matches("\\d*")) {
				JOptionPane.showMessageDialog(null, "Điểm html chỉ được nhập số !");
			} else if (Double.parseDouble(htmlText) <= 0 || Double.parseDouble(htmlText) > 10) {
				JOptionPane.showMessageDialog(null, "Điểm html không nhập thấp hơn 0 và lớn hơn 10!");
			} else {
				// set diem java
				Diem diemJavaObject = new Diem();
				diemJavaObject.setIdSinhVien(idSvText);
				diemJavaObject.setIdMonHoc(IdMHJava);
				diemJavaObject.setDiemThi(Double.parseDouble(javaText));

				listDiem.add(diemJavaObject);

				// Set điểm english
				Diem diemEnglishObject = new Diem();
				diemEnglishObject.setIdSinhVien(idSvText);
				diemEnglishObject.setIdMonHoc(IdMHEnglish);
				diemEnglishObject.setDiemThi(Double.parseDouble(englishText));

				listDiem.add(diemEnglishObject);

				// Set điểm css
				Diem diemCssObject = new Diem();
				diemCssObject.setIdSinhVien(idSvText);
				diemCssObject.setIdMonHoc(IdMHCSS);
				diemCssObject.setDiemThi(Double.parseDouble(cssText));

				listDiem.add(diemCssObject);

				// Set điểm html
				Diem diemHTMLObject = new Diem();
				diemHTMLObject.setIdSinhVien(idSvText);
				diemHTMLObject.setIdMonHoc(IdMHHTML);
				diemHTMLObject.setDiemThi(Double.parseDouble(htmlText));

				listDiem.add(diemHTMLObject);
				int output = JOptionPane.showConfirmDialog(null, "Bạn có muốn sửa", "Sửa Điểm",
						JOptionPane.YES_NO_OPTION);

				if (output == JOptionPane.YES_OPTION) {
					boolean result = true;

					for (Diem diem : listDiem) {
						result = diemDao.updateDiemSinhVien(diem);
						if (!result) {
							break;
						}
					}
					if (result) {
						JOptionPane.showMessageDialog(null, "Sửa thành công!!");
						diemDtm.setRowCount(0);
						displayAllDiem();
					} else {
						JOptionPane.showMessageDialog(null, "Sửa thất bại!!");
					}
				} else if (output == JOptionPane.NO_OPTION) {
					JOptionPane.showMessageDialog(null, " Mời bạn chọn lại!!");
				}
			}
		} else if (e.getSource() == xoaDiemButton) { // Nút xóa điểm
			int output = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa", "Xóa Điểm", JOptionPane.YES_NO_OPTION);
			String idSvText = maSinhViencb.getSelectedItem().toString();
			if (output == JOptionPane.YES_OPTION) {
				if (diemDao.deletelDiemSinhVien(idSvText)) {
					JOptionPane.showMessageDialog(null, "Xóa thành công!!");
					diemDtm.setRowCount(0);
					displayAllDiem();
				} else {
					JOptionPane.showMessageDialog(null, "Xóa thất bại!!");
				}
			} else if (output == JOptionPane.NO_OPTION) {
				JOptionPane.showMessageDialog(null, " Mời bạn chọn lại!!");
			}
		}else { // Nút làm mới
			maSinhViencb.setSelectedItem("Nhấp chọn");
			jaVaField.setText("");
			englishField.setText("");
			cssField.setText("");
			htmlField.setText("");
			diemDtm.setRowCount(0);
			displayAllDiem();
		}

	}
	// Hiển thị danh sách tất cả điểm

	public void displayAllDiem() {
		ArrayList<Diem> listDiem = new ArrayList<Diem>();
		diemDtm.setRowCount(0);

		// Get diem by ID Sinh vien
		listDiem = diemDao.getDiem();

		// add listDiem to gird

		Map<String, List<Diem>> listDiemObject = listDiem.stream().collect(Collectors.groupingBy(Diem::getIdSinhVien));
		List<DiemSinhVien> listDiemSinhVien = new ArrayList<>();
		for (List<Diem> lstDiem : listDiemObject.values()) {
			double diemJava = 0;
			double diemHTML = 0;
			double diemCSS = 0;
			double diemEnglish = 0;
			String idSinhVien = lstDiem.get(0).getIdSinhVien();

			for (Diem diem : lstDiem) {
				switch (diem.getIdMonHoc()) {
				case "MH001":
					diemJava = diem.getDiemThi();
					break;
				case "MH002":
					diemEnglish = diem.getDiemThi();
					break;
				case "MH003":
					diemCSS = diem.getDiemThi();
					break;
				case "MH004":
					diemHTML = diem.getDiemThi();
					break;

				default:
					break;
				}
			}

			DiemSinhVien diemSinhVien = new DiemSinhVien();
			diemSinhVien.setIdSinhVien(idSinhVien);
			diemSinhVien.setDiemJava(diemJava);
			diemSinhVien.setDiemHTML(diemHTML);
			diemSinhVien.setDiemCSS(diemCSS);
			diemSinhVien.setDiemEnglish(diemEnglish);

			listDiemSinhVien.add(diemSinhVien);
		}

		for (DiemSinhVien diemSinhVien : listDiemSinhVien) {
			diemDtm.addRow(new String[] { diemSinhVien.getIdSinhVien(), String.valueOf(diemSinhVien.getDiemJava()),
					String.valueOf(diemSinhVien.getDiemEnglish()), String.valueOf(diemSinhVien.getDiemCSS()),
					String.valueOf(diemSinhVien.getDiemHTML()) });
		}

	}
}
