import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;

public class Demo extends JFrame {
	

	public Demo() {
		super("Demo Windows");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
//		BufferedImage myPic = null;
//		try {
//			myPic = ImageIO.read(new File("C:\\Users\\Administrator\\Desktop\\Capture.png"));
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		JLabel jLabel = new JLabel(new ImageIcon(myPic));
//		add(jLabel);
	
		getContentPane().setLayout(new FlowLayout());
		JPanel pnBox=new JPanel();
		pnBox.setLayout(new BoxLayout(pnBox, BoxLayout.Y_AXIS));
		pnBox.setBackground(Color.RED);
		JPanel pnBox1=new JPanel();
		
		JLabel lblSoa=new JLabel("Hệ số a:");
		pnBox1.setBackground(Color.RED);
		JTextField txtTen=new JTextField(20);
		Border border3 = BorderFactory.createLineBorder(Color.BLACK);
		txtTen.setBorder(BorderFactory.createCompoundBorder(border3, 
		            BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		pnBox1.add(lblSoa);pnBox1.add(txtTen);
		
		JPanel pnBox2=new JPanel();
		
		JLabel lblSob=new JLabel("Hệ số b:");
		pnBox2.setBackground(Color.RED);
		JTextField txtTen1=new JTextField(20);
		Border border2 = BorderFactory.createLineBorder(Color.BLACK);
		txtTen1.setBorder(BorderFactory.createCompoundBorder(border2, 
		            BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		pnBox2.add(lblSob);pnBox2.add(txtTen1);
	
		JPanel pnBox3=new JPanel();
		
		JLabel lblSoc=new JLabel("Hệ số c:");
		pnBox3.setBackground(Color.RED);
		JTextField txtTen2=new JTextField(20);
		Border border1 = BorderFactory.createLineBorder(Color.BLACK);
		txtTen2.setBorder(BorderFactory.createCompoundBorder(border1, 
		            BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		pnBox3.add(lblSoc);
		pnBox3.add(txtTen2);
		pnBox.add(pnBox1);pnBox.add(pnBox2);pnBox.add(pnBox3);
		JPanel pnFlow=new JPanel();
		pnFlow.setLayout(new FlowLayout());
		pnFlow.setBackground(Color.YELLOW);
		JButton btn1=new JButton("Giải:");
		pnFlow.add(btn1);
		
		
		JPanel pnBox4=new JPanel();
		
		JLabel lblKetqua=new JLabel("Kết quả:");
		JTextArea txtTen3=new JTextArea(5,30);
		Border border = BorderFactory.createLineBorder(Color.BLACK);
		txtTen3.setBorder(BorderFactory.createCompoundBorder(border, 
		            BorderFactory.createEmptyBorder(10, 10, 10, 10)));
		
		pnBox4.add(lblKetqua);pnBox4.add(txtTen3);
		
		Container con=getContentPane();
		con.setLayout(new BoxLayout(con, BoxLayout.Y_AXIS));
		con.add(pnBox);
		con.add(pnFlow);
		con.add(pnBox4);
		
		
	}
	public void display() {
		setSize(700, 500);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	public static void main(String[] args) {
		Demo demo = new Demo();
		demo.display();
	}
}
