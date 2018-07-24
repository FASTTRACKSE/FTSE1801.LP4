//
//import java.awt.*;
//import java.awt.event.*;
//import javax.swing.*;
//
//public class Demo5 {
//   private JFrame mainFrame;
//   private JLabel headerLabel;
//   private JLabel statusLabel;
//   private JPanel controlPanel;
//   private JLabel msglabel;
//
//   public Demo5(){
//      prepareGUI();
//   }
//
//   public static void main(String[] args){
//	   Demo5 swingLayoutDemo = new Demo5();  
//      swingLayoutDemo.showCardLayoutDemo();       
//   }
//      
//   private void prepareGUI(){
//      mainFrame = new JFrame("Vi du Java Swing");
//      mainFrame.setSize(400,400);
//      mainFrame.setLayout(new GridLayout(5, 2));
//
//      headerLabel = new JLabel("",JLabel.CENTER );
//      statusLabel = new JLabel("",JLabel.CENTER);        
//
//      statusLabel.setSize(350,100);
//      mainFrame.addWindowListener(new WindowAdapter() {
//         public void windowClosing(WindowEvent windowEvent){
//	        System.exit(0);
//         }        
//      });    
//      controlPanel = new JPanel();
//      controlPanel.setLayout(new FlowLayout());
//
//      mainFrame.add(headerLabel);
//      mainFrame.add(controlPanel);
//      mainFrame.add(statusLabel);
//      mainFrame.setVisible(true);  
//   }
//   
//   private void showCardLayoutDemo(){
//      headerLabel.setText("Layout in action: CardLayout");      
//
//      final JPanel panel = new JPanel();
//      panel.setBackground(Color.CYAN);
//      panel.setSize(300,300);
//
//      CardLayout layout = new CardLayout();
//      layout.setHgap(10);
//      layout.setVgap(10);
//      panel.setLayout(layout);        
//
//      JPanel buttonPanel = new JPanel(new FlowLayout());
//
//      buttonPanel.add(new JButton("OK"));
//      buttonPanel.add(new JButton("Cancel"));    
//
//      JPanel textBoxPanel = new JPanel(new FlowLayout());
//
//      textBoxPanel.add(new JLabel("Name:"));
//      textBoxPanel.add(new JTextField(20));
//
//      panel.add("Button", buttonPanel);
//      panel.add("Text", textBoxPanel);
//      
//      final DefaultComboBoxModel panelName = new DefaultComboBoxModel();
//
//      panelName.addElement("Button");
//      panelName.addElement("Text");
//      
//      final JComboBox listCombo = new JComboBox(panelName);    
//      listCombo.setSelectedIndex(0);
//
//      JScrollPane listComboScrollPane = new JScrollPane(listCombo);    
//
//      JButton showButton = new JButton("Show");
//
//      showButton.addActionListener(new ActionListener() {
//         public void actionPerformed(ActionEvent e) { 
//            String data = "";
//            if (listCombo.getSelectedIndex() != -1) {  
//               CardLayout cardLayout = (CardLayout)(panel.getLayout());
//               cardLayout.show(panel, 
//               (String)listCombo.getItemAt(listCombo.getSelectedIndex()));	               
//            }              
//            statusLabel.setText(data);
//         }
//      }); 
//	  
//      controlPanel.add(listComboScrollPane);
//      controlPanel.add(showButton);
//	  controlPanel.add(panel);
//
//      mainFrame.setVisible(true);  
//   }
//}
import javax.swing.JButton;
import javax.swing.JFrame;
import layout.TableLayout;

public class Demo5 {

    public static void main(String args[]) {

        JFrame frame = new JFrame("Example of TableLayout");
        frame.setSize(450, 450);

        double size[][] = {{10, 75, 75, 75, 75, 75, 10}, // Columns
            {10, 75, 75, 75, 75, 75, 10}}; // Rows

        frame.setLayout(new TableLayout(size));


        String label[] = {"(1,1)", "(1,5)", "(1,3)", "(5,3)", "(3,3)"};
        JButton button[] = new JButton[label.length];

        for (int i = 0; i < label.length; i++) {
            button[i] = new JButton(label[i]);
        }


        frame.add(button[0], "1, 1");
        frame.add(button[1], "1, 5");
        frame.add(button[2], "1, 3");
        frame.add(button[3], "5, 3");
        frame.add(button[4], "3, 3");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
