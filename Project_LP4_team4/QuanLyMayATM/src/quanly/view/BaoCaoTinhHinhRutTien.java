package quanly.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Properties;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
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

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

import quanly.entity.GiaoDich;
import quanly.model.GiaoDichDAO;

public class BaoCaoTinhHinhRutTien extends JFrame {

	private static final long serialVersionUID = 1L;

	JPanel pnBaoCaoTH, chon, pnTongTien;
	JPanel pnLabel, pnBox, pnTim;
	JLabel title, ngay, ngay1, tongTienRut, tongtienThem, maKH;
	JTextField txtMaKH, txtTongTienRut, txtTongTienThem;
	JComboBox<?> boxThoiGian;
	JButton tim;
	DefaultTableModel tableModel;
	JTable table;
	Border border;
	TitledBorder titledBorder;
	UtilDateModel model, model1;
	JDatePanelImpl datePanel, datePanel1;
	JDatePickerImpl datePicker, datePicker1;
	Properties p;
	Date date, date1;

	/**
	 * Sự kiện cho các JButton
	 */
	ActionListener actionListener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == tim) {
				String strDate = datePicker.getJFormattedTextField().getText();
				String strDate1 = datePicker1.getJFormattedTextField().getText();
				if (strDate.equals("") || strDate1.equals("")) {
					JOptionPane.showMessageDialog(null, "Yêu cầu chọn ngày");
				} else {
					SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
					java.util.Date date = null;
					java.util.Date date1 = null;
					try {
						date = format.parse(strDate);
						date1 = format.parse(strDate1);
					} catch (java.text.ParseException e1) {
						e1.printStackTrace();
					}
					long soSanh = (date1.getTime() - date.getTime()) / (24 * 3600 * 1000);
					if (soSanh > 90 || soSanh < 0) {
						JOptionPane.showMessageDialog(null, "Sai tổng số ngày. Mời nhập lại");
					} else {
						if (txtMaKH.getText().equals("")) {
							JOptionPane.showMessageDialog(null, "Yêu cầu nhập mã khách hàng");
						} else {
							GiaoDichDAO giaoDichDAO = new GiaoDichDAO();
							txtTongTienRut.setText("");
							txtTongTienThem.setText("");
							tableModel.setRowCount(0);
							if (giaoDichDAO.kiemTraMaKHDaGiaoDichChua(txtMaKH.getText())) {
								ArrayList<GiaoDich> listGD = new ArrayList<>();
								listGD = giaoDichDAO.showGiaoDichTheoMaKHAnDate(txtMaKH.getText(), strDate, strDate1);
								if (listGD.isEmpty()) {
									JOptionPane.showMessageDialog(null,
											"Khách hàng không thực hiện giao dịch trong khoảng thời gian này");
								} else {
									Integer allTienRut = 0;
									Integer allTienThem = 0;
									for (int i = 0; i < listGD.size(); i++) {
										if (listGD.get(i).getMayATM().getMaMay().equals("Tại ngân hàng")) {
											tableModel.addRow(new String[] { listGD.get(i).getMayATM().getMaMay(),
													listGD.get(i).getKhachHang().getSoTK(), listGD.get(i).getThoiGian(),
													listGD.get(i).getSoTienThem(), listGD.get(i).getSoTienRut() });
											allTienRut = allTienRut + Integer.parseInt(listGD.get(i).getSoTienRut());
											allTienThem = allTienThem + Integer.parseInt(listGD.get(i).getSoTienThem());
										} else {
											tableModel.addRow(new String[] {
													"Máy ATM: " + listGD.get(i).getMayATM().getMaMay(),
													listGD.get(i).getKhachHang().getSoTK(), listGD.get(i).getThoiGian(),
													listGD.get(i).getSoTienThem(), listGD.get(i).getSoTienRut() });
											allTienRut = allTienRut + Integer.parseInt(listGD.get(i).getSoTienRut());
											allTienThem = allTienThem + Integer.parseInt(listGD.get(i).getSoTienThem());
										}

									}
									txtTongTienRut.setText("" + allTienRut);
									txtTongTienThem.setText("" + allTienThem);

								}

							} else {
								JOptionPane.showMessageDialog(null,
										"Mã khách hàng không tồn tại hoặc chưa thực hiện giao dịch.");
							}
						}
					}

				}
			}
		}
	};

	public JPanel tinhHinhRutTien() {
		pnBaoCaoTH = new JPanel();
		pnBaoCaoTH.setLayout(new BoxLayout(pnBaoCaoTH, BoxLayout.Y_AXIS));
		// Tiêu đề
		title = new JLabel("Báo cáo tình hình rút tiền của khách hàng");
		title.setFont(new Font("Times New Roman", Font.BOLD, 30));
		title.setForeground(Color.RED);
		pnBaoCaoTH.add(title);

		// Chọn tiêu chí
		chon = new JPanel();
		chon.setLayout(new GridBagLayout());
		pnLabel = new JPanel();

		maKH = new JLabel("Mã khách hàng:");
		txtMaKH = new JTextField(10);

		ngay = new JLabel("Từ ngày:");
		model = new UtilDateModel();
		p = new Properties();
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");
		datePanel = new JDatePanelImpl(model, p);
		datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());

		ngay1 = new JLabel("Đến ngày");
		model1 = new UtilDateModel();
		datePanel1 = new JDatePanelImpl(model1, p);
		datePicker1 = new JDatePickerImpl(datePanel1, new DateLabelFormatter());

		addItem(pnLabel, maKH, 0, 0, 1, 1, GridBagConstraints.EAST);
		addItem(pnLabel, txtMaKH, 1, 0, 2, 1, GridBagConstraints.WEST);
		addItem(pnLabel, ngay, 0, 1, 1, 1, GridBagConstraints.EAST);
		addItem(pnLabel, datePicker, 1, 1, 2, 1, GridBagConstraints.WEST);
		addItem(pnLabel, ngay1, 0, 2, 1, 1, GridBagConstraints.EAST);
		addItem(pnLabel, datePicker1, 1, 2, 2, 1, GridBagConstraints.WEST);
		chon.add(pnLabel);

		pnTim = new JPanel();
		tim = new JButton("Tìm danh sách");
		tim.addActionListener(actionListener);
		pnTim.add(tim);
		pnBaoCaoTH.add(chon);
		pnBaoCaoTH.add(pnTim);

		// Bảng báo cáo
		border = BorderFactory.createLineBorder(Color.BLUE, 3, true);
		titledBorder = new TitledBorder(border, "Danh sách tình hình rút tiền rút tiền của khách hàng");
		tableModel = new DefaultTableModel();
		tableModel.addColumn("Nơi thực hiện giao dịch");
		tableModel.addColumn("Số tài khoản");
		tableModel.addColumn("Thời gian giao dịch");
		tableModel.addColumn("Số tiền Thêm");
		tableModel.addColumn("Số tiền rút");

		table = new JTable(tableModel);
		// table.getTableHeader().setReorderingAllowed(false);
		table.setDefaultEditor(Object.class, null);

		JScrollPane jScrollPane = new JScrollPane(table, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		jScrollPane.setBorder(titledBorder);
		pnBaoCaoTH.add(jScrollPane);

		pnTongTien = new JPanel();
		tongTienRut = new JLabel("Tổng số tiền rút:");
		tongtienThem = new JLabel("Tổng tiền thêm:");
		txtTongTienRut = new JTextField(10);
		txtTongTienThem = new JTextField(10);
		pnTongTien.add(tongTienRut);
		pnTongTien.add(txtTongTienRut);
		addItem(pnTongTien, tongTienRut, 0, 0, 1, 1, GridBagConstraints.EAST);
		addItem(pnTongTien, txtTongTienRut, 1, 0, 2, 1, GridBagConstraints.WEST);
		addItem(pnTongTien, tongtienThem, 0, 1, 1, 1, GridBagConstraints.EAST);
		addItem(pnTongTien, txtTongTienThem, 1, 1, 2, 1, GridBagConstraints.WEST);
		pnBaoCaoTH.add(pnTongTien);

		return pnBaoCaoTH;

	}

	/**
	 * Chuyển kiểu String thành kiểu Date
	 * 
	 * @author ADMIN
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
	 * Sắp xếp các lable nhập
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

}
