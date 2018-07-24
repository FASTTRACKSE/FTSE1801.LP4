

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Demo4 {
   private JFrame mainFrame;
   private JLabel headerLabel;
   private JLabel statusLabel;
   private JPanel controlPanel;

   public Demo4(){
      prepareGUI();
   }

   public static void main(String[] args){
	   Demo4  swingListenerDemo = new Demo4();  
      swingListenerDemo.showKeyListenerDemo();
   }

//   private void prepareGUI(){
//      mainFrame = new JFrame("Vi du Java Swing");
//      mainFrame.setSize(400,400);
//      mainFrame.setLayout(new GridLayout(3, 1));
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
//   private void showMouseListenerDemo(){
//      headerLabel.setText("Listener in action: MouseListener");      
//
//      JPanel panel = new JPanel();      
//      panel.setBackground(Color.magenta);
//      panel.setLayout(new FlowLayout());        
//      panel.addMouseListener(new CustomMouseListener());
//
//      JLabel msglabel = 
//      new JLabel("Chao mung ban den voi bai huong dan Java Swing."
//      ,JLabel.CENTER);        
//      panel.add(msglabel);
//
//      msglabel.addMouseListener(new CustomMouseListener());
//      panel.add(msglabel);
//
//      controlPanel.add(panel);
//      mainFrame.setVisible(true);  
//   }
//
//   class CustomMouseListener implements MouseListener{
//      public void mouseClicked(MouseEvent e) {
//         statusLabel.setText("Mouse Clicked: ("+e.getX()+", "+e.getY() +")");
//      }
//
//      public void mousePressed(MouseEvent e) {
//      }
//
//      public void mouseReleased(MouseEvent e) {
//      }
//
//      public void mouseEntered(MouseEvent e) {
//      }
//
//      public void mouseExited(MouseEvent e) {
//      }
//   }
   private void prepareGUI(){
	      mainFrame = new JFrame("Vi du Java Swing");
	      mainFrame.setSize(400,400);
	      mainFrame.setLayout(new GridLayout(3, 1));

	      headerLabel = new JLabel("",JLabel.CENTER );
	      statusLabel = new JLabel("",JLabel.CENTER);        

	      statusLabel.setSize(350,100);
	      mainFrame.addWindowListener(new WindowAdapter() {
	         public void windowClosing(WindowEvent windowEvent){
		        System.exit(0);
	         }        
	      });    
	      controlPanel = new JPanel();
	      controlPanel.setLayout(new FlowLayout());

	      mainFrame.add(headerLabel);
	      mainFrame.add(controlPanel);
	      mainFrame.add(statusLabel);
	      mainFrame.setVisible(true);  
	   }

	   private JTextField textField;
	   private void showKeyListenerDemo(){
	      headerLabel.setText("Listener in action: KeyListener");      
	      textField  = new JTextField(10);

	      textField.addKeyListener(new CustomKeyListener());
	      JButton okButton = new JButton("OK");
	      okButton.addActionListener(new ActionListener() {
	         public void actionPerformed(ActionEvent e) {
	            statusLabel.setText("Entered text: " 
	               + textField.getText());                
	         }
	      });

	      controlPanel.add(textField);
	      controlPanel.add(okButton);    
	      mainFrame.setVisible(true);  
	   }

	   class CustomKeyListener implements KeyListener{
	      public void keyTyped(KeyEvent e) {
	      }

	      public void keyPressed(KeyEvent e) {
	         if(e.getKeyCode() == KeyEvent.VK_ENTER){
	            statusLabel.setText("Entered text: " 
	               + textField.getText());
	         }
	      }

	      public void keyReleased(KeyEvent e) {
	      }   
	   }
	
}