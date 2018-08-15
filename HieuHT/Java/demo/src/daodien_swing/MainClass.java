package daodien_swing;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class MainClass extends JFrame {
	public MainClass() {
		super("Windows");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
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

		JComboBox cbo = new JComboBox();
		cbo.addItem("Xuất sắc");
		cbo.addItem("Giỏi");
		cbo.addItem("Khá");
		cbo.addItem("Trung bình");

		JPanel jp1 = new JPanel();
		jp1.setLayout(new FlowLayout());
		jp1.add(cbo);
		getContentPane().add(jp1);

		Container con = getContentPane();
		// getContentPane().setLayout(new BoxLayout(getContentPane(),
		// BoxLayout.Y_AXIS));
		con.setLayout(new GridLayout(2, 2));
		con.add(pnGroup);
		setSize(400, 300);
		setLocationRelativeTo(null);
		setVisible(true);
		con.add(cbo);

	}

	public static void main(String[] args) {
		MainClass ui = new MainClass();
		ui.setSize(400, 300);
		ui.setLocationRelativeTo(null);
		ui.setVisible(true);
	}
}