package quanly.view;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import quanly.entity.MayATM;
import quanly.model.MayAtmDAO;
import quanly.model.PhuongQuanDAO;

public class TimKiemMayATM extends JFrame {
	private static final long serialVersionUID = 1L;

	JPanel pnTimKiem, pnNhap, pnbutton;
	JPanel pnLabel1, pnLabel2;
	JLabel title, tenMay, quan, phuong;
	JTextField txtMay;
	JComboBox<String> boxPhuong, boxQuan;
	JButton tim, huy;
	PhuongQuanDAO phuongQuanDAO;
	ArrayList<String> listPhuong;
	ArrayList<String> listQuan;
	MayAtmDAO mayAtmDAO;
	DefaultTableModel tableModel;

	ActionListener actionListener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == huy) {
				dispose();
			}
			if (e.getSource() == tim) {
				if (txtMay.getText().equals("")) {
					ArrayList<MayATM> listMayATM = mayAtmDAO
							.showMayATMTheoDiaChi(boxPhuong.getSelectedItem().toString());
					tableModel.setRowCount(0);
					if (listMayATM.isEmpty()) {
						JOptionPane.showMessageDialog(null, "Không có máy ATM tại địa chỉ này. Mời chọn lại");
					} else {
						for (int i = 0; i < listMayATM.size(); i++) {
							tableModel.addRow(new String[] { listMayATM.get(i).getMaMay(), listMayATM.get(i).getViTri(),
									listMayATM.get(i).getPhuong(), listMayATM.get(i).getQuan(),
									listMayATM.get(i).getTongTien() });
							dispose();
						}
						
					}
				} else {
					MayATM mayATM = mayAtmDAO.showMayATMMaMay(txtMay.getText());
					tableModel.setRowCount(0);
					if (mayATM.getMaMay() == null) {
						JOptionPane.showMessageDialog(null, "Máy không tồn tại. Vui lòng nhập lại.");
					} else {
						tableModel.addRow(new String[] { mayATM.getMaMay(), mayATM.getViTri(), mayATM.getPhuong(),
								mayATM.getQuan(), mayATM.getTongTien() });
						dispose();
					}
					
				}

			}
		}
	};

	ItemListener itemListener = new ItemListener() {

		@Override
		public void itemStateChanged(ItemEvent e) {
			if (e.getStateChange() == ItemEvent.SELECTED) {
				String tenQuan = boxQuan.getSelectedItem().toString();
				boxPhuong.removeAllItems();
				listPhuong = phuongQuanDAO.showDanhSachPhuong(tenQuan);
				for (int i = 0; i < listPhuong.size(); i++) {
					boxPhuong.addItem(listPhuong.get(i));
				}
			}
		}
	};

	public void timKiemMayATM(DefaultTableModel tableModel) {
		this.tableModel = tableModel;
		phuongQuanDAO = new PhuongQuanDAO();
		mayAtmDAO = new MayAtmDAO();
		pnTimKiem = new JPanel();
		pnTimKiem.setLayout(new BoxLayout(pnTimKiem, BoxLayout.Y_AXIS));
		// Phần tiêu đề
		title = new JLabel("Tìm kiếm máy ATM");
		title.setFont(new Font("Times New Roman", Font.BOLD, 30));
		title.setForeground(Color.RED);
		pnTimKiem.add(title);

		// Phần nhập thông tin
		pnNhap = new JPanel();
		pnNhap.setLayout(new GridLayout(1, 2));
		pnLabel1 = new JPanel();
		pnLabel1.setLayout(new GridBagLayout());
		tenMay = new JLabel("Mã máy");
		txtMay = new JTextField(10);
		quan = new JLabel("Quận :");
		phuong = new JLabel("Phường :");

		boxQuan = new JComboBox<String>();
		listQuan = phuongQuanDAO.showAllDanhSachQuan();
		boxQuan.addItem("");
		boxQuan.addItemListener(itemListener);
		for (int i = 0; i < listQuan.size(); i++) {
			boxQuan.addItem(listQuan.get(i).toString());
		}
		boxPhuong = new JComboBox<String>();
		boxPhuong.addItem("");
		listPhuong = phuongQuanDAO.showDanhSachPhuong(listQuan.get(0).toString());
		for (int i = 0; i < listPhuong.size(); i++) {
			boxPhuong.addItem(listPhuong.get(i).toString());
		}

		addItem(pnLabel1, tenMay, 0, 0, 1, 1, GridBagConstraints.EAST);
		addItem(pnLabel1, quan, 0, 1, 1, 1, GridBagConstraints.EAST);
		addItem(pnLabel1, phuong, 0, 2, 1, 1, GridBagConstraints.EAST);

		addItem(pnLabel1, txtMay, 1, 0, 2, 1, GridBagConstraints.WEST);
		addItem(pnLabel1, boxQuan, 1, 1, 2, 1, GridBagConstraints.WEST);
		addItem(pnLabel1, boxPhuong, 1, 2, 2, 1, GridBagConstraints.WEST);

		pnNhap.add(pnLabel1);
		pnTimKiem.add(pnNhap);

		// Các button chức năng
		pnbutton = new JPanel();
		tim = new JButton("Tìm kiếm");
		tim.addActionListener(actionListener);
		huy = new JButton("Hủy");
		huy.addActionListener(actionListener);
		pnbutton.add(tim);
		pnbutton.add(huy);
		pnTimKiem.add(pnbutton);

		Container container = getContentPane();
		container.add(pnTimKiem);

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

	public void display() {
		setSize(700, 500);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
	}

}
