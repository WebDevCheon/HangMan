package Gaming;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
//////////////////////////////////////게이머가 알파벳 입력하는 창(JTextfield)
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TextPanel extends JPanel 
{
	JLabel input=new JLabel("input: ");
	JTextField textfield;
	String c;
	
     public TextPanel(ActionListener al)
     {
    	  input.setForeground(Color.GREEN);
          add(input);   	 
    	  add(textfield=new JTextField(10));
    	  textfield.addActionListener(al);
    	  textfield.setFont(new Font("Arial",Font.BOLD,50));
    	  input.setFont(new Font("Arial",Font.BOLD,50));
     }
     
     void reset()
     {
    	 textfield.setText("");
     }
     
     public void paintComponent(Graphics g)
     {
        super.paintComponent(g);	       
    	
        	ImageIcon icon=new ImageIcon("C:\\HangMan\\Game\\image\\break.jpg");
    		Image img=icon.getImage();
    		
    		g.drawImage(img,0,0, this.getWidth(), this.getHeight(),this);
     }
}