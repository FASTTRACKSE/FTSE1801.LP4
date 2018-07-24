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
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import org.jdatepicker.impl.JDatePanelImpl;
import org.jdatepicker.impl.JDatePickerImpl;
import org.jdatepicker.impl.UtilDateModel;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

  
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
	UtilDateModel model, model2;
	JDatePanelImpl datePanel, datePanel2;
	JDatePickerImpl datePicker, datePicker2;
	Properties p;
	Date date,date2;
	
	public JPanel baoCaoTinhHinhRutTienATM() {
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
		model = new UtilDateModel();
		p = new Properties();
		p.put("text.today", "Today");
		p.put("text.month", "Month");
		p.put("text.year", "Year");
		datePanel = new JDatePanelImpl(model, p);
		datePicker = new JDatePickerImpl(datePanel, new DateLabelFormatter());
		

		model2 = new UtilDateModel();
		ngay2 = new JLabel("Đến ngày:");
		datePanel2 = new JDatePanelImpl(model2, p);
		datePicker2 = new JDatePickerImpl(datePanel2, new DateLabelFormatter());

		addItem(pnLabel2, ngay1, 0, 0, 1, 1, GridBagConstraints.EAST);
		addItem(pnLabel2, datePicker, 1, 0, 2, 1, GridBagConstraints.WEST);
		addItem(pnLabel2, ngay2, 0, 1, 1, 1, GridBagConstraints.EAST);
		addItem(pnLabel2, datePicker2, 1, 1, 2, 1, GridBagConstraints.WEST);
		chon2.add(pnLabel2);
		pnBaoCaoTinhHinh.add(chon2);

		pnTim = new JPanel();
		tim = new JButton("Tìm kiếm");
		tim.addActionListener(actionListener);

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
		
		return pnBaoCaoTinhHinh;
		
	}
	
	ActionListener actionListener = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == tim) {
				String strdate = datePicker.getJFormattedTextField().getText();
				String strdate2 = datePicker2.getJFormattedTextField().getText();
				
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				java.util.Date date = null;
				java.util.Date date1 = null;
				try {
					date = sdf.parse(strdate);
					date1 = sdf.parse(strdate2);
				} catch (java.text.ParseException e1) {
					e1.printStackTrace();
				}
				long soSanh = (date1.getTime()-date.getTime()) / (24 * 3600 * 1000);;
				if ((soSanh>30) || (soSanh<0)) {
					JOptionPane.showMessageDialog(null, "Sai tổng số ngày. Nhập lại");
				}else {
					JOptionPane.showMessageDialog(null, soSanh);
				}
			}
		}
	};
	
	public class DateLabelFormatter extends AbstractFormatter {

		private static final long serialVersionUID = 1L;
		private String datePattern = "yyyy-MM-dd";
	    private SimpleDateFormat dateFormatter = new SimpleDateFormat(datePattern);

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
	
}
