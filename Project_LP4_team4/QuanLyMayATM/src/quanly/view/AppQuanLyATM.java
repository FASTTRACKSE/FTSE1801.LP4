package quanly.view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.TextArea;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.border.Border;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;

public class AppQuanLyATM extends JFrame {

	private static final long serialVersionUID = 1L;

	Border border;
	Container con;
	JPanel pnTitle, pnMenu, pnAllCenter, pnSouth, pnCenter;
	JPanel pnQuanLyKH, pnQuanLyATM, pnQuanLyGD;

	JPanel pnBaoCaoKH, pnBaoCaoTinhTrangATM, pnBaoCaoRuTienKH, pnBaoCaoRutTienATM;
	JLabel logoname;
	CardLayout card;
	JButton btn_infor;
	JTextField txtTree;
	TextArea ta_east;
	JTree tree;
	DefaultMutableTreeNode root;
	DefaultMutableTreeNode file, file2, view, search, help, exit;
	DefaultMutableTreeNode quanLyKH, quanLyATM, quanLyGD;
	DefaultMutableTreeNode baoCaoKH, baoCaoTinhTrangATM, baoCaoRutTienKH, BaoCaoRutTienATM;
	
	TreeSelectionListener treeSelectionListener = new TreeSelectionListener() {
		
		@Override
		public void valueChanged(TreeSelectionEvent e) {
			JTree tree = (JTree) e.getSource();
			DefaultMutableTreeNode treeNode = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
			if (treeNode.toString().equals("Báo cáo máy ATM")) {
				card.show(pnAllCenter, "quanLyKH");
			}else if (treeNode.toString().equals("Báo cáo khách hàng")) {
				card.show(pnAllCenter, "luan");
			}
			
		}
	};

	public AppQuanLyATM() {
		super("Quản Lý máy ATM");
		con = getContentPane();
		con.setLayout(new BorderLayout());
		pnTitle = new JPanel();
		pnMenu = new JPanel();
		pnAllCenter = new JPanel();
		pnSouth = new JPanel();
		pnCenter = new JPanel();

		pnTitle.setBackground(Color.LIGHT_GRAY);
		pnMenu.setBackground(Color.LIGHT_GRAY);
		pnAllCenter.setBackground(Color.LIGHT_GRAY);
		pnSouth.setBackground(Color.LIGHT_GRAY);
		pnCenter.setBackground(Color.LIGHT_GRAY);

		logoname = new JLabel("Chương trình quản lý máy ATM");
		logoname.setFont(new Font("Times New Roman", Font.BOLD, 45));
		logoname.setForeground(Color.BLUE);
		pnTitle.add(logoname);
		con.add(pnTitle, "North");

		/**
		 * Phan Menu
		 */
		root = new DefaultMutableTreeNode("Quản lý máy ATM");
		file = new DefaultMutableTreeNode(" Quản Lý ");
		quanLyKH = new DefaultMutableTreeNode("Quản lý khách hàng");
		quanLyATM = new DefaultMutableTreeNode("Quản lý máy ATM");
		quanLyGD = new DefaultMutableTreeNode("Quản lý giao dịch");
		file.add(quanLyKH);
		file.add(quanLyATM);
		file.add(quanLyGD);
		root.add(file);

		file2 = new DefaultMutableTreeNode(" Báo cáo ");
		baoCaoKH = new DefaultMutableTreeNode("Báo cáo khách hàng");
		baoCaoRutTienKH = new DefaultMutableTreeNode("Báo cáo tình hình rút tiền của khách hàng");
		baoCaoTinhTrangATM = new DefaultMutableTreeNode("Báo cáo máy ATM");
		BaoCaoRutTienATM = new DefaultMutableTreeNode("Báo cáo tình hình rút tiền theo máy ATM");
		file2.add(baoCaoKH);
		file2.add(baoCaoRutTienKH);
		file2.add(baoCaoTinhTrangATM);
		file2.add(BaoCaoRutTienATM);
		root.add(file2);

		tree = new JTree(root);
		pnMenu.add(new JScrollPane(tree), BorderLayout.CENTER);
		pnMenu.setBorder(BorderFactory.createTitledBorder("Menu"));
		con.add(pnMenu, "West");
		//
		pnAllCenter = new JPanel();
		pnAllCenter.setBorder(BorderFactory.createTitledBorder("ProGram"));
		JScrollPane pane = new JScrollPane(pnAllCenter);
		card = new CardLayout();
		pnAllCenter.setLayout(card);
		JPanel jPanel = new JPanel();
		JLabel jLabel = new JLabel("sfasfaf");
		jPanel.add(jLabel);
		pnAllCenter.add(jPanel, "luan");
		QuanLyKhachHang quanLyKhachHang = new QuanLyKhachHang();
		pnAllCenter.add(quanLyKhachHang.quanLyKH(), "quanLyKH");
		
		
		
		

		
		
		
		
		
		tree.addTreeSelectionListener(treeSelectionListener);
		con.add(pnSouth, "South");
//		con.add(pnCenter, "Center");
		con.add(pane, "Center");
	}
	
	
	
	public void display() {
		setSize(1200, 750);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	// ________________________________________________________________________________________
	/* MAIN CLASS */
	// ----------------------------------------------------------------------------------------
	public static void main(String args[]) {
		AppQuanLyATM quanLyATM = new AppQuanLyATM();
		quanLyATM.display();
	}


}
