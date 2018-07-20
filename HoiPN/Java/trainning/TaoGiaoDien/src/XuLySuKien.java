import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

public class XuLySuKien extends JFrame implements ActionListener{
	JButton chon;
	JCheckBox chk1;
	JCheckBox chk2;
	JCheckBox chk3;
	JCheckBox chk4;
	JRadioButton rad1;
	JRadioButton rad2;
	JRadioButton rad3;
	JRadioButton rad4;
	
	
	XuLySuKien(){
		super("Xu li su kien");
		
		JPanel pn1 = new JPanel();
		JLabel mota = new JLabel("Mo ta");
		JTextArea text = new JTextArea(10,30);
		JScrollPane sc=new JScrollPane(text, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		pn1.add(mota);
		pn1.add(sc);
		
		JPanel pnCheck=new JPanel(); 
		pnCheck.setLayout(new GridLayout(2, 2)); 
		Border bor2=BorderFactory.createLineBorder(Color.BLUE,2) ;
		TitledBorder titlebor2= new TitledBorder(bor2, "Môn học yêu thích:"); 
		pnCheck.setBorder(titlebor2); 
		chk1=new JCheckBox("Java"); 
		chk2=new JCheckBox("F Sharp"); 
		chk3=new JCheckBox("C Sharp"); 
		chk4=new JCheckBox("Ruby"); 
		pnCheck.add(chk1);
		pnCheck.add(chk2); 
		pnCheck.add(chk3);
		pnCheck.add(chk4);
		
		JPanel pnGroup=new JPanel();
		pnGroup.setLayout(new BoxLayout(pnGroup, BoxLayout.Y_AXIS));
		Border bor=BorderFactory.createLineBorder(Color.RED);
		TitledBorder titlebor=new TitledBorder(bor, "Chọn nè:");
		pnGroup.setBorder(titlebor);
		rad1=new JRadioButton("Rất hài lòng");
		rad2=new JRadioButton("Hài lòng");
		rad3=new JRadioButton("Tạm chấp nhận"); 
		rad4=new JRadioButton("Không chấp nhận");
		ButtonGroup group=new ButtonGroup();
		group.add(rad1);group.add(rad2);
		group.add(rad3);group.add(rad4); 
		pnGroup.add(rad1);
		pnGroup.add(rad2); 
		pnGroup.add(rad3);
		pnGroup.add(rad4); 
		
		JPanel combo = new JPanel();
		String arr[]={"","Xuất sắc" ,"Giỏi" ,"Khá","Trung bình"}; 
		JComboBox cbo=new JComboBox(arr);
//		cbo.setSelectedIndex(-1);
		combo.add(cbo);
		
		Person []list={ new Person("1", "Trần Thành Công"), new Person("2", "Nguyễn Đại Thắng"), new Person("3", "Hoàng Thành Đạt")};
		JComboBox cbo2=new JComboBox(list); 
		
		
		
		chon = new JButton("Chon");
		
		Container con = getContentPane();
		con.setLayout(new BoxLayout(con, BoxLayout.Y_AXIS));
		con.add(pn1);
		con.add(pnCheck);
		con.add(pnGroup);
		con.add(combo);
		con.add(cbo2);
		con.add(chon);
		display();
		setAction();
	}
	
	private void display() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(400, 500);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public void setAction() {
		chon.addActionListener(this);
	}
	
	public static void main(String[] args) {
		XuLySuKien kien= new XuLySuKien();
		kien.display();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == chon) {
			
			if(chk1.isSelected()) {
				JOptionPane.showMessageDialog(null, "Ban da CheckBox vao Java");
			}
			
			if(chk2.isSelected()) {
				JOptionPane.showMessageDialog(null, "Ban da CheckBox vao F sharp");
			}
			
			if(chk3.isSelected()) {
				JOptionPane.showMessageDialog(null, "Ban da CheckBox vao C sharp");
			}
			
			if(chk4.isSelected()) {
				JOptionPane.showMessageDialog(null, "Ban da CheckBox vao Ruby");
			}
			
			
			if(rad1.isSelected()) {
				JOptionPane.showMessageDialog(null, "Ban da RadioButton Rat hai long");
			}
			
			if(rad2.isSelected()) {
				JOptionPane.showMessageDialog(null, "Ban da RadioButton hai long");
			}
			
			if(rad3.isSelected()) {
				JOptionPane.showMessageDialog(null, "Ban da RadioButton Tam chap nhan");
			}
			
			if(rad4.isSelected()) {
				JOptionPane.showMessageDialog(null, "Ban da RadioButton khong chap nhan");
			}
		}
	}
}
