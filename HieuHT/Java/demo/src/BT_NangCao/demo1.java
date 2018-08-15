//package BT_NangCao;
//
//import java.awt.BorderLayout;
//import java.awt.Color;
//import java.awt.Container;
//import java.awt.Dimension;
//
//import javax.swing.DefaultBoundedRangeModel;
//import javax.swing.JButton;
//import javax.swing.JFrame;
//import javax.swing.JMenu;
//import javax.swing.JMenuBar;
//import javax.swing.JMenuItem;
//import javax.swing.JPanel;
//import javax.swing.JScrollBar;
//import javax.swing.JScrollPane;
//import javax.swing.JSplitPane;
//import javax.swing.JTabbedPane;
//import javax.swing.JTable;
//import javax.swing.JTree;
//import javax.swing.table.DefaultTableModel;
//import javax.swing.tree.DefaultMutableTreeNode;
//
//import daodien_swing.MyWindow;
//
//public class demo1 extends JFrame {
//	public demo1() {
//		super("Demo1 Windows");
//		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,
		// listScrollPane, pictureScrollPane);
		// splitPane.setOneTouchExpandable(true);
		// splitPane.setDividerLocation(150);
		// // Provide minimum sizes for the two components in the split pane Dimension
		// Dimension minimumSize = new Dimension(100, 50);
		// listScrollPane.setMinimumSize(minimumSize);
		// pictureScrollPane.setMinimumSize(minimumSize);

		/*
		 * Nhập sinh viên
		 */
//		 DefaultTableModel dm = new DefaultTableModel();
//		 dm.addColumn("Mã SV");
//		 dm.addColumn("Tên SV");
//		 dm.addColumn("Tuổi SV");
//		 dm.addColumn("Địa chỉ SV");
//		
//		 dm.addRow(new String[]{"001","Hồ Tấn Hiệu","21","Quãng Nam"});
//		 dm.addRow(new String[]{"002","Nguyễn Tuấn Phương","22","Đà Nẵng"});
//		 dm.addRow(new String[]{"003","Nguyễn Đình Khải","20","Hà Nội"});
//		 dm.addRow(new String[]{"004","Huỳnh Khánh Hưng","28","Đà Nẵng"});
//		
//		 JTable tbl = new JTable(dm);
//		
//		 JScrollPane sc = new JScrollPane(tbl);

		/*
		 * JTree
		 */

		// DefaultMutableTreeNode root = new DefaultMutableTreeNode("Thư mục 1");
		// final JTree tree = new JTree(root);
		// DefaultMutableTreeNode root1 = new DefaultMutableTreeNode("Thư mục 2");
		// final JTree tree1 = new JTree(root1);
		// DefaultMutableTreeNode cnttNode = new DefaultMutableTreeNode("Mục 1");
		// root.add(cnttNode);

		/*
		 * JMenuBar
		 */

//		JMenuBar menubar = new JMenuBar();
//		setJMenuBar(menubar);
//		JMenu mnuFile = new JMenu("Mua sắm");
//		JMenu mnuEdit = new JMenu("Đơn hàng của tôi");
//		JMenu mnuExit = new JMenu("Thoát");
//		menubar.add(mnuFile);
//		menubar.add(mnuEdit);
//		menubar.add(mnuExit);
//		JMenuItem mnuFileXe = new JMenuItem("Xe");
//		JMenuItem mnuFileDT = new JMenuItem("Điện thoại");
//		JMenuItem mnuFileLT = new JMenuItem("Laptop");
//		
//		JMenuItem mnuEditHDM = new JMenuItem("Hàng đã mua");
//		JMenuItem mnuEditHDH = new JMenuItem("Hàng đã hủy");
//		JMenuItem mnuEditThoat = new JMenuItem("Thoát");
//		
//		
//		mnuFile.add(mnuFileXe);
//		mnuFile.add(mnuFileDT);
//		mnuFile.add(mnuFileLT);
//		mnuEdit.add(mnuEditHDM);
//		mnuEdit.add(mnuEditHDH);
//		mnuEdit.addSeparator(); 
//		mnuEdit.add(mnuEditThoat);
		
		
		/*
		 * JTabbedPane
		 */	
//		JTabbedPane myJTabled = new JTabbedPane();
//		JPanel QuangNam = new JPanel();
//		QuangNam.setBackground(Color.BLUE);
//		QuangNam.add(new JButton("Hội AN"));
//		QuangNam.add(new JButton("Cù Lao Chàm"));
//		QuangNam.add(new JButton("Bãi Rạng"));
//		
//		JPanel DaNang = new JPanel();
//		DaNang.setBackground(Color.GREEN);
//		DaNang.add(new JButton("Bà Nà"));
//		DaNang.add(new JButton("Biển"));
//		DaNang.add(new JButton("Ngũ Hành Sơn"));
//		myJTabled.add(QuangNam,"Quảng Nam");
//		myJTabled.add(DaNang,"Đà Nẵng"); 
//		
//		Container con = getContentPane();
//		con.add(myJTabled);

//		con.setLayout(null);
//		con.setLayout(new BorderLayout());
//		con.add(tree);
//		con.add(tree1);
//		con.add(sc, BorderLayout.CENTER);

//	}
//
//	public static void main(String[] args) {
//		demo1 dm = new demo1();
//		dm.setSize(400, 300);
//		dm.setLocationRelativeTo(null);
//		dm.setVisible(true);
//	}
//}
