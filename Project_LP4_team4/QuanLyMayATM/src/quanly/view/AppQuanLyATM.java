package quanly.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTextArea;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;

public class AppQuanLyATM extends JFrame {

	private static final long serialVersionUID = 1L;
	Container con;
	JPanel jPanel, jPanel2;
	JLabel title;
	JButton button;
	JTextArea area = new JTextArea();
	public AppQuanLyATM() {
		con = getContentPane();
		con.setLayout(new BorderLayout());
//		con.setBackground(Color.WHITE);
		jPanel = new JPanel();
		jPanel.setBackground(Color.YELLOW);
		title = new JLabel("Quản Lý máy ATM");
		title.setForeground(Color.BLUE);
		title.setFont(new Font("Arial", Font.BOLD, 25));
		jPanel.add(title);
		
		
		jPanel2 = new JPanel();
		jPanel2.setLayout(new GridLayout(2, 1));
		
		DefaultMutableTreeNode root = new DefaultMutableTreeNode("Quản lý");
		JTree tree = new JTree(root);
		DefaultMutableTreeNode cnttNode1 = new DefaultMutableTreeNode("Quản lý khách hàng");
		DefaultMutableTreeNode cnttNode11 = new DefaultMutableTreeNode("Quản lý máy ATM");
		DefaultMutableTreeNode cnttNode12 = new DefaultMutableTreeNode("Quản lý giao dịch");
		root.add(cnttNode1);root.add(cnttNode11);root.add(cnttNode12);
		jPanel2.add(tree);
		DefaultMutableTreeNode root2 = new DefaultMutableTreeNode("Báo cáo");
		JTree tree2 = new JTree(root2);
		DefaultMutableTreeNode cnttNode2 = new DefaultMutableTreeNode("Báo cáo khách hàng");
		DefaultMutableTreeNode cnttNode21 = new DefaultMutableTreeNode("Báo cáo khách hàng");
		DefaultMutableTreeNode cnttNode22 = new DefaultMutableTreeNode("Báo cáo khách hàng");
		root2.add(cnttNode2);root2.add(cnttNode21);root2.add(cnttNode22);
		jPanel2.add(tree2);
		
		JSplitPane jSplitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT);
		jSplitPane.setTopComponent(jPanel);
		jSplitPane.setBottomComponent(jPanel2);
		
		con.add(jPanel, BorderLayout.NORTH);
		con.add(jPanel2, BorderLayout.WEST);		
		


	}

	public void display() {
		setTitle("Quản lý máy ATM");
		setSize(700, 700);
		setLocationRelativeTo(null);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		AppQuanLyATM appQuanLyATM = new AppQuanLyATM();
		appQuanLyATM.display();
	}
}
