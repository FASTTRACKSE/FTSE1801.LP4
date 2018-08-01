import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class Demo1 extends JFrame {

	public Demo1() {
		super("Mai Thanh Cong");
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		getContentPane().setLayout(new FlowLayout());
		JButton btn1 = new JButton("Say Hello!");
		ActionListener btnClick = new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "Hello cong!");
			}
		};
		JButton btn2 = new JButton("Say Hello!");
		ActionListener btnClick1 = new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JOptionPane.showMessageDialog(null, "Click!");
			}
		};

		btn1.addActionListener(btnClick);
		btn2.addActionListener(btnClick1);

		JPanel pnTable = new JPanel();
		Border border = BorderFactory.createLineBorder(Color.RED);
		TitledBorder borderTitle = BorderFactory.createTitledBorder(border, "Danh sách");
		pnTable.add(btn1);
		pnTable.add(btn2);
		pnTable.setBorder(borderTitle);

		JLabel lblDes = new JLabel("Mô tả:");
		JTextArea are = new JTextArea(5, 15);
		JScrollPane sc = new JScrollPane(are, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		add(lblDes);
		add(sc);

		ImageIcon img = new ImageIcon("C:\\Users\\Administrator\\Desktop\\Capture.png");
		JLabel lblImg = new JLabel(img);
		JScrollPane scimg = new JScrollPane(lblImg, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scimg.setPreferredSize(new Dimension(600, 500));

		JPanel pnCheck = new JPanel();
		pnCheck.setLayout(new GridLayout(2, 2));
		Border bor2 = BorderFactory.createEtchedBorder(Color.BLUE, Color.RED);
		TitledBorder titlebor2 = new TitledBorder(bor2, "Môn học yêu thích:");
		pnCheck.setBorder(titlebor2);
		JCheckBox chk1 = new JCheckBox("Java");
		JCheckBox chk2 = new JCheckBox("F Sharp");
		JCheckBox chk3 = new JCheckBox("C Sharp");
		JCheckBox chk4 = new JCheckBox("Ruby");
		pnCheck.add(chk1);
		pnCheck.add(chk2);
		pnCheck.add(chk3);
		pnCheck.add(chk4);
		add(pnCheck);

		JPanel pnGroup = new JPanel();
		 pnGroup.setLayout(new BoxLayout(pnGroup, BoxLayout.Y_AXIS));
		Border bor = BorderFactory.createLineBorder(Color.RED);
		TitledBorder titlebor = new TitledBorder(bor, "Chọn nè:");
		pnGroup.setBorder(titlebor);
		JRadioButton rad1 = new JRadioButton("Rất hài lòng");
		JRadioButton rad2 = new JRadioButton("Hài lòng");
		JRadioButton rad3 = new JRadioButton("Tạm chấp nhận");
		JRadioButton rad4 = new JRadioButton("Không chấp nhận");
		ButtonGroup group = new ButtonGroup();
		group.add(rad1);
		group.add(rad2);
		group.add(rad3);
		group.add(rad4);
		pnGroup.add(rad1);
		pnGroup.add(rad2);
		pnGroup.add(rad3);
		pnGroup.add(rad4);

//		JPanel jpan = new JPanel();
//		String arr[] = { "Thành phố", "", ""};
//		JComboBox cbo = new JComboBox(arr);
//		jpan.add(cbo);
//		JPanel jpan1 = new JPanel();
//		String arr1[] = { "Quận/Huyện", "", ""};
//		JComboBox cbo1 = new JComboBox(arr1);
//		jpan1.add(cbo1);
//		JPanel jpan2 = new JPanel();
//		String arr2[] = { "Xã/Phường", "", ""};
//		JComboBox cbo2 = new JComboBox(arr2);
//		jpan2.add(cbo2);

		// List person
		Person[] list = { new Person("1", "Đỗ Công Thành"), new Person("2", "Nguyễn Văn Hùng"),
				new Person("3", "Trần Duy Thanh"), new Person("4", "Đoàn Á	i Nương"),

				new Person("10", "Đào Cẩm Hằng") };
		JList jl = new JList(list);
		jl.setSelectionBackground(Color.RED);
		jl.setSelectionForeground(Color.WHITE);
		JScrollPane scjl = new JScrollPane(jl, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);

		Container con = getContentPane();
		con.setLayout(new GridLayout(2, 2));
		con.add(pnTable);
		con.add(lblDes);
		con.add(sc);
		con.add(pnCheck);
		con.add(pnGroup);
//		con.add(jpan);
//		con.add(jpan1);
//		con.add(jpan2);
		con.add(scjl);
		con.add(scimg);
	}

	public void display() {
		setSize(700, 500);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public static void main(String[] args) {
		Demo1 demo1 = new Demo1();
		demo1.display();
	}
}
