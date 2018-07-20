package quanly.view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;

public class AppQuanLyATM extends JFrame {

	private static final long serialVersionUID = 1L;

	Container con;
	JPanel pnTitle, pnMenu, pnAllCenter, pnSouth, pnCenter;
	JPanel pnQuanLyKH, pnQuanLyATM, pnQuanLyGD, pnMayATM;
	JLabel logoname, title;
	CardLayout card;
	JButton btMay1, btMay2, btMay3, btMay4, btMay5, btMay6, btMay7, btMay8, btMay9, btMay10;
	JTextField txtTree;
	JTree tree;
	DefaultMutableTreeNode root;
	DefaultMutableTreeNode file, file2;
	DefaultMutableTreeNode quanLyKH, quanLyATM, quanLyGD;
	DefaultMutableTreeNode baoCaoKH, baoCaoTinhTrangATM, baoCaoRutTienKH, BaoCaoRutTienATM;

	TreeSelectionListener treeSelectionListener = new TreeSelectionListener() {

		@Override
		public void valueChanged(TreeSelectionEvent e) {
			JTree tree = (JTree) e.getSource();
			DefaultMutableTreeNode treeNode = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
			if (treeNode.toString().equals("Quản lý khách hàng")) {
				card.show(pnAllCenter, "quanLyKH");
			} else if (treeNode.toString().equals("Quản lý máy ATM")) {
				card.show(pnAllCenter, "quanLyATM");
			} else if (treeNode.toString().equals("Quản lý giao dịch")) {
				card.show(pnAllCenter, "quanLyGD");
			} else if (treeNode.toString().equals("Chương trình quản lý máy ATM của ngân hàng")) {
				card.show(pnAllCenter, "Đây là trang chủ");
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
		root = new DefaultMutableTreeNode("Chương trình quản lý máy ATM của ngân hàng");
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
		// Trang chủ
		JPanel jPanel = new JPanel();
		JLabel jLabel = new JLabel("Đây là trang chủ");
		jPanel.add(jLabel);
		pnAllCenter.add(jPanel, "Đây là trang chủ");

		// Quản lý khách hàng
		QuanLyKhachHang quanLyKhachHang = new QuanLyKhachHang();
		pnAllCenter.add(quanLyKhachHang.quanLyKH(), "quanLyKH");

		// Quản lý máy ATM
		QuanLyMayATM atm = new QuanLyMayATM();
		pnAllCenter.add(atm.qLyMayATM(), "quanLyATM");

		// Quản lý giao dịch
		pnQuanLyGD = new JPanel();
		pnQuanLyGD.setLayout(new BoxLayout(pnQuanLyGD, BoxLayout.Y_AXIS));
		 title = new JLabel("Máy ATM");
		 title.setFont(new Font("Times New Roman", Font.BOLD, 30));
		 title.setForeground(Color.RED);
		 pnQuanLyGD.add(title);
		pnMayATM = new JPanel();
		pnMayATM.setLayout(new GridLayout(2, 5));
		btMay1 = new JButton("May001");
		btMay2 = new JButton("May002");
		btMay3 = new JButton("May003");
		btMay4 = new JButton("May004");
		btMay5 = new JButton("May005");
		btMay6 = new JButton("May006");
		btMay7 = new JButton("May007");
		btMay8 = new JButton("May008");
		btMay9 = new JButton("May009");
		btMay10 = new JButton("May010");

		pnMayATM.add(btMay1);
		pnMayATM.add(btMay2);
		pnMayATM.add(btMay3);
		pnMayATM.add(btMay4);
		pnMayATM.add(btMay5);
		pnMayATM.add(btMay6);
		pnMayATM.add(btMay7);
		pnMayATM.add(btMay8);
		pnMayATM.add(btMay9);
		pnMayATM.add(btMay10);
		pnQuanLyGD.add(pnMayATM);
		pnAllCenter.add(pnQuanLyGD, "quanLyGD");

		tree.addTreeSelectionListener(treeSelectionListener);
		con.add(pnSouth, "South");
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
