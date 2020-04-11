package Gaming;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
////////////////////////////////////////////////////입력 횟수 받는창
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CountPanel extends JPanel 
{
	JLabel countdown=new JLabel("CountDown: ");
	JLabel count=new JLabel();
	int counting=6;
	
    public CountPanel()
    {
    	countdown.setForeground(Color.GREEN);
    	count.setForeground(Color.GREEN);
        add(countdown);
        add(count);
        set();
        countdown.setFont(new Font("Arial",Font.BOLD,50));
        count.setFont(new Font("Arial",Font.BOLD,50));
    }
	void set()
	{
		count.setText(String.valueOf(this.counting));
	}
	
    void decrement()   //countdown 횟수 감소 ->0이 되면,게임 오버
    {
    	this.counting--;
    	set();
    }
    
    int getCount()
    {
    	return counting;
    }
    
    void reset()
    {
    	counting=6;
    	set();
    }
    
    public void paintComponent(Graphics g)
    {
       super.paintComponent(g);	       
   	
       	ImageIcon icon=new ImageIcon("C:\\HangMan\\Game\\image\\watch.jpg");
   		Image img=icon.getImage();
   		
   		g.drawImage(img,0,0, this.getWidth(), this.getHeight(),this);
    }
}
