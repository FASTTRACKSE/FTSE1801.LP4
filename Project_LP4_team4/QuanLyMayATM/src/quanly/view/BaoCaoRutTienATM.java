package quanly.view;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.time.LocalDate;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
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

import javafx.scene.control.DatePicker;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class BaoCaoRutTienATM extends JFrame {

	private static final long serialVersionUID = 1L;
	JPanel pnBaoCaoTinhHinh, chon, chon2, pnButton;
	JPanel pnLabel, pnLabel2, pnBox, pnTim;
	JLabel title, phuong, quan, may, ngay1, ngay2;
	JComboBox<?> boxPhuong, boxQuan, boxNgay1, boxNgay2, boxMay;
	JButton tim, hienThi;
	DefaultTableModel tableModel;
	JTable table;
	Border border;
	TitledBorder titledBorder;
	DatePicker datePicker;
	public void baoCaoTinhHinhRutTienATM() {
		pnBaoCaoTinhHinh = new JPanel();
		pnBaoCaoTinhHinh.setLayout(new BoxLayout(pnBaoCaoTinhHinh, BoxLayout.Y_AXIS));
		// Tiêu đề
		title = new JLabel("Báo cáo tình hình rút tiền của máy ATM");
		title.setFont(new Font("Times New Roman", Font.BOLD, 30));
		title.setForeground(Color.RED);
		pnBaoCaoTinhHinh.add(title);

		// Chọn tiêu chí
		chon = new JPanel();
		chon.setLayout(new GridBagLayout());
		pnLabel = new JPanel();
		phuong = new JLabel("Chọn phường:");
		String strPhuong[] = { " " };
		boxPhuong = new JComboBox<>(strPhuong);

		quan = new JLabel("Chọn quận:");
		String strQuan[] = { " " };
		boxQuan = new JComboBox<>(strQuan);

		may = new JLabel("Chọn máy:");
		String strMay[] = { "Tất cả" };
		boxMay = new JComboBox<>(strMay);

		addItem(pnLabel, quan, 0, 0, 1, 1, GridBagConstraints.EAST);
		addItem(pnLabel, boxQuan, 1, 0, 2, 1, GridBagConstraints.WEST);
		addItem(pnLabel, phuong, 0, 1, 1, 1, GridBagConstraints.EAST);
		addItem(pnLabel, boxPhuong, 1, 1, 2, 1, GridBagConstraints.WEST);
		addItem(pnLabel, may, 0, 2, 1, 1, GridBagConstraints.EAST);
		addItem(pnLabel, boxMay, 1, 2, 2, 1, GridBagConstraints.WEST);
		chon.add(pnLabel);
		pnBaoCaoTinhHinh.add(chon);
		
		chon2 = new JPanel();
		chon2.setLayout(new GridBagLayout());
		pnLabel2 = new JPanel();
		ngay1 = new JLabel("Từ ngày:");
		String strNgay1[] = { " " };
		boxNgay1 = new JComboBox<>(strNgay1);

		ngay2 = new JLabel("Đến ngày:");
		String strNgay2[] = { " " };
		boxNgay2 = new JComboBox<>(strNgay2);

		addItem(pnLabel2, ngay1, 0, 0, 1, 1, GridBagConstraints.EAST);
		addItem(pnLabel2, boxNgay1, 1, 0, 2, 1, GridBagConstraints.WEST);
		addItem(pnLabel2, ngay2, 0, 1, 1, 1, GridBagConstraints.EAST);
		addItem(pnLabel2, boxNgay2, 1, 1, 2, 1, GridBagConstraints.WEST);
		chon2.add(pnLabel2);
		pnBaoCaoTinhHinh.add(chon2);

		pnTim = new JPanel();
		tim = new JButton("Tìm kiếm");
		pnTim.add(tim);
		pnBaoCaoTinhHinh.add(pnTim);

		// Bảng báo cáo
		border = BorderFactory.createLineBorder(Color.BLUE, 3, true);
		titledBorder = new TitledBorder(border, "Danh sách thông tin máy ATM");
		tableModel = new DefaultTableModel();
		tableModel.addColumn("Tên máy");
		tableModel.addColumn("Địa chỉ");
		tableModel.addColumn("Phường");
		tableModel.addColumn("Quận");
		tableModel.addColumn("Số tiền còn lại trong máy");

		table = new JTable(tableModel);
		JScrollPane jScrollPane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		jScrollPane.setBorder(titledBorder);
		pnBaoCaoTinhHinh.add(jScrollPane);
		
		DatePicker datePicker = new DatePicker(LocalDate.now());
		GridPane gridPane = new GridPane();
		gridPane.add(datePicker, 0,0);
		
		VBox box = new VBox();
		box.getChildren().add(gridPane);
		Container container = getContentPane();
		container.add(pnBaoCaoTinhHinh);
	}
	
	/**
	 * Sắp xếp button
	 * 
	 * @param p
	 * @param c
	 * @param x
	 * @param y
	 * @param width
	 * @param height
	 * @param align
	 */
	public void addItem(JPanel p, JComponent c, int x, int y, int width, int height, int align) {
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
	
	public void display() {
		setSize(1200, 750);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public static void main(String[] args) {
		BaoCaoRutTienATM atm = new BaoCaoRutTienATM();
		atm.baoCaoTinhHinhRutTienATM();
		atm.display();
		
	}
}
