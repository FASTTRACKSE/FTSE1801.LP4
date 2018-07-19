
import java.awt.Container;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class GiaiPhuongTrinhBac2 extends JFrame {
	Container con;
	JPanel pnFlow1;
	JPanel pnFlow11;
	JPanel pnFlow12;
	JPanel pnFlow13;
	JPanel pnFlow2;
	JPanel pnFlow3;
	JTextField heSoA;
	JTextField heSoB;
	JTextField heSoC;
	JTextField ketQua;
	JButton giaiPt;

	public GiaiPhuongTrinhBac2() {
		super("Giai Phuong trinh bac hai");

		pnFlow1 = new JPanel();
		pnFlow1.setLayout(new BoxLayout(pnFlow1, BoxLayout.Y_AXIS));
		pnFlow11 = new JPanel();
		pnFlow12 = new JPanel();
		pnFlow13 = new JPanel();
		pnFlow1.add(pnFlow11);
		pnFlow1.add(pnFlow12);
		pnFlow1.add(pnFlow13);

		JLabel lbl1 = new JLabel("Hệ số a: ");
		heSoA = new JTextField(15);
		JLabel lbl2 = new JLabel("Hệ số b: ");
		heSoB = new JTextField(15);
		JLabel lbl3 = new JLabel("Hệ số c: ");
		heSoC = new JTextField(15);

		pnFlow11.add(lbl1);
		pnFlow11.add(heSoA);
		pnFlow12.add(lbl2);
		pnFlow12.add(heSoB);
		pnFlow13.add(lbl3);
		pnFlow13.add(heSoC);

		pnFlow2 = new JPanel();
		giaiPt = new JButton("Giải");
		giaiPt.setPreferredSize(new Dimension(100, 50));
		giaiPt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				float a = 0, b = 0, c = 0;
				try {
					a = Float.parseFloat(heSoA.getText());
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Nhập sai định dạng!");
					heSoA.selectAll();
					heSoA.requestFocus();
					return;
				}
				try {
					b = Float.parseFloat(heSoB.getText());
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Nhập sai định dạng!");
					heSoB.selectAll();
					heSoB.requestFocus();
					return;
				}
				try {
					c = Float.parseFloat(heSoC.getText());
				} catch (Exception ex) {
					JOptionPane.showMessageDialog(null, "Nhập sai định dạng!");
					heSoC.selectAll();
					heSoC.requestFocus();
					return;
				}

				giaiPt(a, b, c);

			}
		});
		pnFlow2.add(giaiPt);
		pnFlow2.add(giaiPt);

		pnFlow3 = new JPanel();
		JLabel lbl4 = new JLabel("Kết quả: ");
		ketQua = new JTextField(15);
		ketQua.setEnabled(false);
		pnFlow3.add(lbl4);
		pnFlow3.add(ketQua);

		con = getContentPane();
		getContentPane().setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		con.add(pnFlow1);
		con.add(pnFlow2);
		con.add(pnFlow3);

		display();
	}

	private void display() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(400, 300);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	public void giaiPt(double a, double b, double c) {

		if (a == 0) {
			if (b == 0) {
				if (c == 0) {
					ketQua.setText(String.valueOf("Phương trình có vô số nghiệm"));
				} else {
					ketQua.setText(String.valueOf("Phương trình vô nghiệm"));
				}
			} else {
				double x = -c / b;// if cai nua
				ketQua.setText(String.valueOf("Phương trình có nghiệm là: " + x));
			}
		} else {
			double dt = b * b - 4 * a * c;

			if (dt < 0) {
				ketQua.setText(String.valueOf("Phương trình vô nghiệm"));
			} else if (dt == 0) {
				ketQua.setText(String.valueOf("Phương trình có nghiệm kép: x = " + -b / (2 * a)));
			} else {
				double y1 = (-b + Math.sqrt(dt)) / (2 * a);
				double y2 = (-b - Math.sqrt(dt)) / (2 * a);
				ketQua.setText(String.valueOf("Phương trình có 2 nghiệm phân biệt là x1 = " + y1 + " và x2 = " + y2));

			}
		}
	}

	public static void main(String[] args) {
		GiaiPhuongTrinhBac2 pt = new GiaiPhuongTrinhBac2();

	}

}
