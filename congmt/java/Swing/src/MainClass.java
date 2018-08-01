import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractButton;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainClass extends JFrame {
	public MainClass() {
		super("Demo Windows");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JPanel pnFlow=new JPanel();
		pnFlow.setLayout(new FlowLayout());
		pnFlow.setBackground(Color.BLUE);
		JButton btn1=new JButton("FlowLayout");
		JButton btn2=new JButton("Add các control");
		JButton btn3=new JButton("Trên 1 dòng");
		JButton btn4=new JButton("Hết chỗ chứa");
		JButton btn5=new JButton("Thì xuống dòng");
		pnFlow.add(btn1);pnFlow.add(btn2);
		pnFlow.add(btn3);pnFlow.add(btn4);
		pnFlow.add(btn5);
		Container con=getContentPane();
		con.add(pnFlow);
		
		JPanel pnBox=new JPanel();
		pnBox.setLayout(new BoxLayout(pnBox, BoxLayout.Y_AXIS));
		JButton btn11=new JButton("BoxLayout");
		btn11.setForeground(Color.RED);
		Font font=new Font("Arial",Font.BOLD | Font.ITALIC,25);
		btn11.setFont(font);pnBox.add(btn11);
		JButton btn22=new JButton("X_AXIS");
		btn2.setForeground(Color.BLUE);
		btn2.setFont(font);pnBox.add(btn22);
		JButton btn32=new JButton("Y_AXIS");
		btn3.setForeground(Color.ORANGE);
		btn3.setFont(font);pnBox.add(btn32);
		Container con1=getContentPane();
		con1.add(pnBox);
		
		JPanel pnBorder=new JPanel();
		pnBorder.setLayout(new BorderLayout());
		JPanel pnNorth=new JPanel();
		pnNorth.setBackground(Color.RED);
		pnBorder.add(pnNorth,BorderLayout.NORTH);
		JPanel pnSouth=new JPanel();
		pnSouth.setBackground(Color.RED);
		pnBorder.add(pnSouth,BorderLayout.SOUTH);
		JPanel pnWest=new JPanel();
		pnWest.setBackground(Color.BLUE);
		pnBorder.add(pnWest,BorderLayout.WEST);
		JPanel pnEast=new JPanel();
		pnEast.setBackground(Color.BLACK);
		pnBorder.add(pnEast,BorderLayout.EAST);
		JPanel pnCenter=new JPanel();
		pnCenter.setBackground(Color.YELLOW);
		pnBorder.add(pnCenter,BorderLayout.CENTER);
		getContentPane().add(pnBorder);
		
		final JPanel pnCenter1=new JPanel();
		pnCenter1.setLayout(new CardLayout());
		final JPanel pnCard1=new JPanel();
		pnCard1.setBackground(Color.LIGHT_GRAY);
		final JPanel pnCard2=new JPanel();
		pnCard2.setBackground(Color.PINK);
		pnCenter1.add(pnCard1,"mycard1");
		pnCenter1.add(pnCard2,"mycard2");
		
		
		btnShowCard1.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
		CardLayout cl=(CardLayout)pnCenter1.getLayout();
		cl.show(pnCenter1, "mycard1");
		}});
		pnCenter.setLayout(new CardLayout());
		
		pnCenter.add(pnCard1,"mycard1");
		
		CardLayout cl=(CardLayout)pnCenter.getLayout();
		
		cl.show(pnCenter, "mycard1");
	}
	public void display() {
		setSize(500, 300);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	public static void main(String[] args) {
		MainClass ui = new MainClass();
		ui.display();
	}

}
