package quanlytruonghoc.control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class QuanLyLopHoc extends JFrame implements ActionListener{
	JPanel jPanel;
	JButton jButton;
	public QuanLyLopHoc() {
		jPanel = new JPanel();
		JLabel jLabel = new JLabel("Quản lý lớp học");jPanel.add(jLabel);
		
		jButton = new JButton("Xác nhận");jPanel.add(jButton);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == jButton) {
			JOptionPane.showMessageDialog(null, "Bạn đã nhấn nút button");
		}
	}
	
	
}
