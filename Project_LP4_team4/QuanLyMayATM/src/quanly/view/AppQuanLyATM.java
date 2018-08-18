package quanly.view;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
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

import quanly.entity.MayATM;
import quanly.model.MayAtmDAO;

public class AppQuanLyATM extends JFrame {

	private static final long serialVersionUID = 1L;

	Container con;
	JPanel pnTitle, pnMenu, pnAllCenter, pnSouth, pnCenter;
	JPanel pnQuanLyKH, pnQuanLyATM, pnMayATMDemo, pnMayATM, pnQuanLyTheATM;
	JLabel logoname, title;
	CardLayout card;
	JButton jbmayATM;
	JTextField txtTree;
	JTree tree;
	DefaultMutableTreeNode root;
	DefaultMutableTreeNode file, file2;
	DefaultMutableTreeNode quanLyKH, quanLyATM, quanLyGD, quanLyTheATM, mayATM;
	DefaultMutableTreeNode baoCaoKH, baoCaoTinhTrangATM, baoCaoRutTienKH, BaoCaoRutTienATM;
	MayATMView mayATMView;

	/**
	 * Sự kiện cho cây
	 */
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
			} else if (treeNode.toString().equals("Máy ATM")) {
				pnAllCenter.add(pnQuanLyMayAtmDemo(),"quanLyMayAtmDemo");
				card.show(pnAllCenter, "quanLyMayAtmDemo");
			} else if (treeNode.toString().equals("Báo cáo khách hàng")) {
				card.show(pnAllCenter, "baoCaoKH");
			} else if (treeNode.toString().equals("Báo cáo tình hình rút tiền của khách hàng")) {
				card.show(pnAllCenter, "baoCaoRutTien");
			} else if (treeNode.toString().equals("Báo cáo tình trạng máy ATM")) {
				card.show(pnAllCenter, "tinhTrangATM");
			} else if (treeNode.toString().equals("Báo cáo tình hình rút tiền theo máy ATM")) {
				card.show(pnAllCenter, "baoCaoRutTienATM");
			} else if (treeNode.toString().equals("Chương trình quản lý máy ATM của ngân hàng")) {
				card.show(pnAllCenter, "trangChu");
			}
		}
	};

	/**
	 * Sự kiện cho Demo máy ATM
	 */
	ActionListener actionListener = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
				mayATMView = new MayATMView(e.getActionCommand());
				MayAtmDAO mayAtmDAO = new MayAtmDAO();
				mayATMView.mayATM(mayAtmDAO.showMayATMMaMay(e.getActionCommand()));
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

		logoname = new JLabel("Chương trình quản lý máy ATM ngân hàng TP-Bank");
		logoname.setFont(new Font("Times New Roman", Font.BOLD, 45));
		logoname.setForeground(Color.BLUE);
		pnTitle.add(logoname);
		con.add(pnTitle, "North");

		// Phần Menu
		root = new DefaultMutableTreeNode("Chương trình quản lý máy ATM của ngân hàng");
		file = new DefaultMutableTreeNode(" Quản Lý ");
		quanLyKH = new DefaultMutableTreeNode("Quản lý khách hàng");
		quanLyATM = new DefaultMutableTreeNode("Quản lý máy ATM");
		quanLyGD = new DefaultMutableTreeNode("Quản lý giao dịch");
		mayATM = new DefaultMutableTreeNode("Máy ATM");
		file.add(quanLyKH);
		file.add(quanLyATM);
		file.add(quanLyGD);
		file.add(mayATM);
		root.add(file);

		file2 = new DefaultMutableTreeNode(" Báo cáo ");
		baoCaoKH = new DefaultMutableTreeNode("Báo cáo khách hàng");
		baoCaoRutTienKH = new DefaultMutableTreeNode("Báo cáo tình hình rút tiền của khách hàng");
		baoCaoTinhTrangATM = new DefaultMutableTreeNode("Báo cáo tình trạng máy ATM");
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
		
		// Phần giao diện chương trình
		pnAllCenter = new JPanel();
		pnAllCenter.setBorder(BorderFactory.createTitledBorder("ProGram"));
		JScrollPane pane = new JScrollPane(pnAllCenter);
		card = new CardLayout();
		pnAllCenter.setLayout(card);
		
		// Trang chủ
		JPanel jPanel = new JPanel();
		JLabel jLabel = new JLabel();
		jLabel.setIcon(new ImageIcon("img\\bank.jpg"));
		jPanel.add(jLabel);
		pnAllCenter.add(jPanel, "trangChu");

		// Quản lý khách hàng
		QuanLyKhachHang quanLyKhachHang = new QuanLyKhachHang();
		pnAllCenter.add(quanLyKhachHang.quanLyKH(), "quanLyKH");
		
		// Quản lý Giao dịch
		QuanLyGiaoDich quanLyGiaoDich = new QuanLyGiaoDich();
		pnAllCenter.add(quanLyGiaoDich.giaoDich(), "quanLyGD");

		// Quản lý máy ATM
		QuanLyMayATM atm = new QuanLyMayATM();
		pnAllCenter.add(atm.qLyMayATM(), "quanLyATM");

		// Máy ATM demo
		pnAllCenter.add(pnQuanLyMayAtmDemo(), "quanLyMayAtmDemo");
		
		// Báo cáo khách hàng
		BaoCaoKhachHang khachHang = new BaoCaoKhachHang();
		pnAllCenter.add(khachHang.BaoCaoKH(), "baoCaoKH");
		
		// Báo cáo tình hình rút tiền của khách hàng
		BaoCaoTinhHinhRutTien rutTien = new BaoCaoTinhHinhRutTien();
		pnAllCenter.add(rutTien.tinhHinhRutTien(), "baoCaoRutTien");
		
		// Báo cáo tình trạng máy ATM
		BaoCaoTinhTrangATM tinhTrangATM = new BaoCaoTinhTrangATM();
		pnAllCenter.add(tinhTrangATM.tinhTrangMayATM(), "tinhTrangATM");
		
		// Báo cáo tình hình rút tiền theo máy ATM
		BaoCaoRutTienATM atm2 = new  BaoCaoRutTienATM();
		pnAllCenter.add(atm2.baoCaoTinhHinhRutTienATM(), "baoCaoRutTienATM");
		
		tree.addTreeSelectionListener(treeSelectionListener);
		con.add(pnSouth, "South");
		con.add(pane, "Center");
	}

	/**
	 * JPanel quản lý giao dịch
	 * @return
	 */
	public JPanel pnQuanLyMayAtmDemo() {
		pnMayATMDemo = new JPanel();
		pnMayATMDemo.setLayout(new BoxLayout(pnMayATMDemo, BoxLayout.Y_AXIS));
		title = new JLabel("Máy ATM");
		title.setFont(new Font("Times New Roman", Font.BOLD, 30));
		title.setForeground(Color.RED);
		pnMayATMDemo.add(title);
		pnMayATM = new JPanel();
		pnMayATM.setLayout(new GridLayout(5,10));
		
		MayAtmDAO mayAtmDAO = new MayAtmDAO();
		ArrayList<MayATM> mayATMs = mayAtmDAO.showAllMayATM();
		for (int i = 0; i < mayATMs.size(); i++) {
			String nameButton = mayATMs.get(i).getMaMay();
			jbmayATM = new JButton(nameButton);
			jbmayATM.addActionListener(actionListener);
			pnMayATM.add(jbmayATM);
		}
		pnMayATMDemo.add(pnMayATM);
		return pnMayATMDemo;
	}
	
	/**
	 * Tạo 1 cửa sổ
	 */
	public void display() {
		setSize(1200, 750);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		AppQuanLyATM appQuanLyATM = new AppQuanLyATM();
		appQuanLyATM.display();
	}
	
}
