package quanlytruonghoc.control;

import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import quanlytruonghoc.entity.Phuong;
import quanlytruonghoc.entity.SinhVien;
import quanlytruonghoc.model.LopDao;
import quanlytruonghoc.model.SinhVienDao;

public class QuanLySinhVien extends JFrame implements ActionListener{
	private static final long serialVersionUID = 1L;
	ArrayList<SinhVien> listSinhVien, listSinhVien1, listSinhVien2;
	ArrayList<Double> listDiem;
	ArrayList<String> listTp, listQuan, listXaPhuong, listNamHoc, listNamHoc1, listTenLop, listMaLop, listTenMonHoc;
	Border border;
	JTextField maSvField, tenSvField, diaChiField, sdtField, emailField, timKiemField;
	JComboBox<String> tpComb, quanComb, phuongComb, lopComb;
	JButton themSvButton, suaSvButton, xoaSvButton, taoMoiSvButton, timkiemSvButton, seach, xacNhan;
	JTable svTable, tkSvTable;
	DefaultTableModel svDtm, tkSvDtm;
	String tenTP, tenTP1, tenQuan, tenQuan1, tenPhuong, theoNam, theoLop, maLop;
	SinhVienDao sinhVienDao;
	LopDao lopDao;
	Container con;
	public QuanLySinhVien() {
		sinhVienDao = new SinhVienDao();
		lopDao = new LopDao();
		JLabel svLabel = new JLabel("Quản lý sinh viên");
		Font font1 = new Font("Arial", Font.BOLD | Font.ITALIC, 40);
		svLabel.setFont(font1);
		svLabel.setAlignmentX(CENTER_ALIGNMENT);
		JPanel svNhap = new JPanel();
		JPanel svPn1 = new JPanel();
		svNhap.add(svPn1);
		svPn1.setLayout(new BoxLayout(svPn1, BoxLayout.Y_AXIS));
		Font font = new Font("Arial", Font.BOLD | Font.ITALIC, 23);
		JLabel labelSV1 = new JLabel("Mã sinh viên: ");
		labelSV1.setFont(font);
		svPn1.add(labelSV1);
		JLabel labelSV2 = new JLabel("Họ tên: ");
		labelSV2.setFont(font);
		svPn1.add(labelSV2);
		JLabel labelSV3 = new JLabel("Email: ");
		labelSV3.setFont(font);
		svPn1.add(labelSV3);
		JLabel labelSV4 = new JLabel("Số điện thoại: ");
		labelSV4.setFont(font);
		svPn1.add(labelSV4);
		JLabel labelSV5 = new JLabel("Địa chỉ(số nhà): ");
		labelSV5.setFont(font);
		svPn1.add(labelSV5);

		JPanel svPn2 = new JPanel();
		border = BorderFactory.createLineBorder(Color.BLACK);
		svNhap.add(svPn2);
		svPn2.setLayout(new BoxLayout(svPn2, BoxLayout.Y_AXIS));
		maSvField = new JTextField(20);

		maSvField.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		svPn2.add(maSvField);
		tenSvField = new JTextField(20);
		tenSvField.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		svPn2.add(tenSvField);
		emailField = new JTextField(20);
		emailField.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		svPn2.add(emailField);
		sdtField = new JTextField(20);
		sdtField.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		svPn2.add(sdtField);
		diaChiField = new JTextField(20);
		diaChiField.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(5, 5, 5, 5)));
		svPn2.add(diaChiField);
		JPanel svPn3 = new JPanel();
		svNhap.add(svPn3);
		svPn3.setLayout(new BoxLayout(svPn3, BoxLayout.Y_AXIS));
		JLabel labelSV6 = new JLabel("Tỉnh/Thành phố: ");
		labelSV6.setFont(font);
		svPn3.add(labelSV6);
		JLabel labelSV7 = new JLabel("Quận: ");
		labelSV7.setFont(font);
		svPn3.add(labelSV7);
		JLabel labelSV8 = new JLabel("Phường: ");
		labelSV8.setFont(font);
		svPn3.add(labelSV8);
		JLabel labelSV9 = new JLabel("Mã lớp: ");
		labelSV9.setFont(font);
		svPn3.add(labelSV9);

		JPanel svPn4 = new JPanel();
		svNhap.add(svPn4);
		svPn4.setLayout(new BoxLayout(svPn4, BoxLayout.Y_AXIS));
		tpComb = new JComboBox<>();svPn4.add(tpComb);
		tpComb.setPreferredSize(new Dimension(150, 30));
		tpComb.addItem("Chọn thành phố");

		quanComb = new JComboBox<>();svPn4.add(quanComb);
		quanComb.setPreferredSize(new Dimension(150, 30));
		quanComb.addItem("Chọn quận/huyện");
		
		phuongComb = new JComboBox<>();svPn4.add(phuongComb);
		phuongComb.setPreferredSize(new Dimension(150, 30));
		phuongComb.addItem("Chọn phường/xã");

		lopComb = new JComboBox<>();svPn4.add(lopComb);
		lopComb.setPreferredSize(new Dimension(150, 30));
		lopComb.addItem("Mã lớp");
		
		// Add danh sách mã lớp vào ComboBox
		listMaLop = new ArrayList<String>();
		listMaLop = lopDao.getAllMaLop();
		for (int i = 0; i < listMaLop.size(); i++) {
			lopComb.addItem(listMaLop.get(i));
		}
		
		// Add danh sách Tỉnh/Thành phố vào ComboBox
		listTp = new ArrayList<String>();
		listTp = sinhVienDao.getAllThanhPho();
		for (int i = 0; i < listTp.size(); i++) {
			tpComb.addItem(listTp.get(i));
		}
		
		// Add danh sách quận/huyện vào ComboBox
		tpComb.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					tenTP = tpComb.getSelectedItem().toString();
					quanComb.removeAllItems();
					listQuan = sinhVienDao.getAllQuanHuyen(tenTP);
					for (int i = 0; i < listQuan.size(); i++) {
						quanComb.addItem(listQuan.get(i));
					}
					quanComb.addItem("Chọn quận/huyện");
				}
			}
		});
		
		// Add danh sách Phường xã vào ComboBox
		quanComb.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					tenQuan = quanComb.getSelectedItem().toString();
					phuongComb.removeAllItems();
					listXaPhuong = sinhVienDao.getAllXaPhuong(tenQuan);
					for (int j = 0; j < listXaPhuong.size(); j++) {
						phuongComb.addItem(listXaPhuong.get(j));
					}
					phuongComb.addItem("Chọn phường/xã");
				}
			}
		});
		
		// Lấy tên phường xã từ ComboBox
		phuongComb.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					tenPhuong = phuongComb.getSelectedItem().toString();
				}
			}
		});
		
		//Tạo các button cho bảng quản lý sinh viên
		font = new Font("Arial", Font.BOLD | Font.ITALIC, 18);
		JPanel svbtn = new JPanel();
		themSvButton = new JButton("Thêm", new ImageIcon("img\\add-contact-icon.png"));
		themSvButton.setFont(font);
		svbtn.add(themSvButton);
		suaSvButton = new JButton("Sửa", new ImageIcon("img\\edit-validated-icon.png"));
		suaSvButton.setFont(font);
		svbtn.add(suaSvButton);
		xoaSvButton = new JButton("Xóa", new ImageIcon("img\\Actions-edit-delete-icon.png"));
		xoaSvButton.setFont(font);
		svbtn.add(xoaSvButton);
		taoMoiSvButton = new JButton("Làm mới", new ImageIcon("img\\Actions-view-refresh-icon.png"));
		taoMoiSvButton.setFont(font);
		svbtn.add(taoMoiSvButton);
		timkiemSvButton = new JButton("Tìm Kiếm", new ImageIcon("img\\zoom-seach-icon.png"));
		timkiemSvButton.setFont(font);
		svbtn.add(timkiemSvButton);
		
		//Tạo bảng hiển thị danh sách sinh viên
		JPanel svBang = new JPanel();
		font = new Font("Arial", Font.BOLD | Font.ITALIC, 16);
		svDtm = new DefaultTableModel();
		svDtm.addColumn("Mã SV");
		svDtm.addColumn("Tên SV");
		svDtm.addColumn("Mã lớp");
		svDtm.addColumn("Email");
		svDtm.addColumn("Số điện thoại");
		svDtm.addColumn("Địa chỉ");
		svDtm.addColumn("Phường");
		svDtm.addColumn("Quận");
		svDtm.addColumn("Thành phố");

		svTable = new JTable(svDtm);
		svTable.getTableHeader().setReorderingAllowed(false);
		svTable.setDefaultEditor(Object.class, null);
		svTable.setFont(font);
		svTable.getTableHeader().setFont(font);
		JScrollPane scMon = new JScrollPane(svTable, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scMon.setPreferredSize(new Dimension(1400, 500));
		
		//Tạo sự kiện kích chuột vào bảng danh sách sinh viên để lấy thông tin sinh viên
		svTable.addMouseListener(new MouseListener() {
			public void mouseReleased(MouseEvent e) {
			}

			public void mousePressed(MouseEvent e) {
			}

			public void mouseExited(MouseEvent e) {
			}

			public void mouseEntered(MouseEvent e) {
			}

			public void mouseClicked(MouseEvent e) {
				int row = svTable.getSelectedRow();
				maSvField.setText((String) svTable.getValueAt(row, 0));
				tenSvField.setText((String) svTable.getValueAt(row, 1));
				emailField.setText((String) svTable.getValueAt(row, 3));
				sdtField.setText((String) svTable.getValueAt(row, 4));
				lopComb.setSelectedItem((String) svTable.getValueAt(row, 2));
				diaChiField.setText((String) svTable.getValueAt(row, 5));
				tpComb.setSelectedItem((String) svTable.getValueAt(row, 8));
				quanComb.setSelectedItem((String) svTable.getValueAt(row, 7));
				phuongComb.setSelectedItem((String) svTable.getValueAt(row, 6));
			}
		});

		Border border = BorderFactory.createLineBorder(Color.RED, 2);
		TitledBorder borderTitle = BorderFactory.createTitledBorder(border, "Danh sách sinh viên");
		svBang.setBorder(borderTitle);
		svBang.add(scMon);
		displayAllSv(listSinhVien);
		con = getContentPane();
		con.add(svLabel);
		con.add(svNhap);
		con.add(svbtn);
		con.add(svBang);
		con.setLayout(new BoxLayout(con, BoxLayout.Y_AXIS));
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		SinhVien sinhvien = new SinhVien();
		Phuong phuong = new Phuong();
		
		String idSv = maSvField.getText();
		String tenSv = tenSvField.getText();
		String sdt = sdtField.getText();
		String email = emailField.getText();
		String diaChi = diaChiField.getText();

		// Gán giá trị cho sinh viên

		sinhvien.setIdSinhVien(idSv);
		sinhvien.setHoTen(tenSv);
		sinhvien.setSdt(sdt);
		sinhvien.setEmail(email);
		sinhvien.setThanhpho(tenTP);
		sinhvien.setQuan(tenQuan);
		phuong.setNamePhuong(tenPhuong);
		phuong.setIdPhuong(sinhVienDao.getXaId(tenPhuong));
		sinhvien.setPhuong(phuong);
		sinhvien.setDiaChi(diaChi);
		sinhvien.setIdLop(lopComb.getSelectedItem().toString());

		// Thực hiện lệnh gọi đến nút button

		if (e.getSource() == themSvButton) {
			// Bắt lỗi các trường hợp trong nhập văn bản
			// Tao gia tri moi cho bang sinhvien
			
			if (idSv.length() == 0) {
				JOptionPane.showMessageDialog(null, "Mã sinh viên không được để trống!!!");
			} else if (tenSv.length() == 0) {
				JOptionPane.showMessageDialog(null, "Tên sinh viên không đươc để trống !");
			} else if (!email.matches("\\w+@+\\w+\\.\\w+{1,2}")) {
				JOptionPane.showMessageDialog(null, "Nhập sai định dạng Email \\n vd: demo123.@gmail.com");
			} else if (!sdt.matches("0[0-9]{9,10}")) {
				JOptionPane.showMessageDialog(null, "Số điện thoại phải là 9 hoặc 11 số !");
			} else if (diaChi.length() == 0) {
				JOptionPane.showMessageDialog(null, "Địa chỉ không được để trống !");
			} else if (tenTP == null || tenQuan == null || tenPhuong == null
					|| lopComb.getSelectedItem().toString() == null) {
				JOptionPane.showMessageDialog(null, "Hộp chọn không đươc để trống !");
			} else {

				int output = JOptionPane.showConfirmDialog(null, "Bạn có muốn thêm", "Thêm sinh viên",
						JOptionPane.YES_NO_OPTION);

				if (output == JOptionPane.YES_OPTION) {
					if (sinhVienDao.addNewSinhVien(sinhvien)) {
						JOptionPane.showMessageDialog(null, "Thêm thành công!!");
						svDtm.setRowCount(0);
						displayAllSv(listSinhVien);
					}
				} else if (output == JOptionPane.NO_OPTION) {
					JOptionPane.showMessageDialog(null, " Thêm thất bại!!");
				}

			}

		} else if (e.getSource() == suaSvButton) {
			// Bắt lỗi các trường hợp trong nhập văn bản

			if (idSv.length() == 0) {
				JOptionPane.showMessageDialog(null, "Mã sinh viên không đươc để trống !");
			} else if (tenSv.length() == 0) {
				JOptionPane.showMessageDialog(null, "Tên sinh viên không đươc để trống !");
			} else if (!email.matches("\\w+@+\\w+\\.\\w+{1,2}")) {
				JOptionPane.showMessageDialog(null, "Nhập sai định dạng Email \\n vd: demo123.@gmail.com");
			} else if (!sdt.matches("0[0-9]{9,10}")) {
				JOptionPane.showMessageDialog(null, "Số điện thoại phải là 9 hoặc 11 số !");
			} else if (tenTP == null || tenQuan == null || tenPhuong == null) {
				JOptionPane.showMessageDialog(null, "Hộp chọn không đươc để trống !");
			} else if (diaChi.length() == 0) {
				JOptionPane.showMessageDialog(null, "Địa chỉ không được để trống !");
			} else {

				int output1 = JOptionPane.showConfirmDialog(null, "Bạn có muốn sửa", "Sửa sinh viên",
						JOptionPane.YES_NO_OPTION);

				if (output1 == JOptionPane.YES_OPTION) {
					if (sinhVienDao.updateSinhVien(sinhvien)) {
						JOptionPane.showMessageDialog(null, "Sửa thành công!!");
						svDtm.setRowCount(0);
						displayAllSv(listSinhVien);
					}
				} else if (output1 == JOptionPane.NO_OPTION) {
					JOptionPane.showMessageDialog(null, " Sửa thất bại!!");
				}
			}
		} else if (e.getSource() == xoaSvButton) {
			int output1 = JOptionPane.showConfirmDialog(null, "Bạn có muốn xóa", "Xóa sinh viên",
					JOptionPane.YES_NO_OPTION);

			if (output1 == JOptionPane.YES_OPTION) {
				if (sinhVienDao.deletelSinhVien(sinhvien)) {
					JOptionPane.showMessageDialog(null, "Xóa thành công!!");
					svDtm.setRowCount(0);
					displayAllSv(listSinhVien);
				}
			} 

			svDtm.setRowCount(0);
			displayAllSv(listSinhVien);
		}else if(e.getSource() == taoMoiSvButton) {
			maSvField.setText("");
			tenSvField.setText("");
			sdtField.setText("");
			emailField.setText("");
			diaChiField.setText("");
			tpComb.setSelectedItem("Chọn thành phố");
			quanComb.setSelectedItem("Chọn quận/huyện");
			phuongComb.setSelectedItem("Chọn phường/xã");
			lopComb.setSelectedItem("Mã lớp");
			svDtm.setRowCount(0);
			displayAllSv(listSinhVien);
		}
//		else if(e.getSource() == timkiemSvButton) {
//			quanLyTruongHoc.cardPanel.add(timKiemSinhVien.con,"timKiemSinhVien");
//			displayAllSv(listSinhVien);
//		}

	}

	public void displayAllSv(ArrayList<SinhVien> listSinhVien) {
		listSinhVien = new ArrayList<SinhVien>();
		listSinhVien = sinhVienDao.getAllSinhVien();
		for (SinhVien sinhVien : listSinhVien) {
			svDtm.addRow(new String[] { sinhVien.getIdSinhVien(), sinhVien.getHoTen(), sinhVien.getIdLop(),
					sinhVien.getEmail(), sinhVien.getSdt(), sinhVien.getDiaChi(), sinhVien.getPhuong().getNamePhuong(),
					sinhVien.getQuan(), sinhVien.getThanhpho() });
		}
	}
}
