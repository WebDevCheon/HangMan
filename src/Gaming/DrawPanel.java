package Gaming;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;
//////////////////////////////////////////사람 모형 그리는 창
import javax.swing.JPanel;

public class DrawPanel extends JPanel
{
	int count;
	
	public DrawPanel()
	{
        count=0; 
        this.setPreferredSize(new Dimension(940,1050));
    }
	
	int increment()
	{
		return count++;
	}
	void reset()
	{
		count=0;
	}
	 public void paintComponent(Graphics g)
     {
        super.paintComponent(g);	       
    	
        Graphics2D g2=(Graphics2D)g;
        g2.setStroke(new BasicStroke(10,BasicStroke.CAP_ROUND,0));
        
        ImageIcon icon=new ImageIcon("C:\\HangMan\\Game\\image\\hangman.jpg");
    	Image img=icon.getImage();
    		
    	g.drawImage(img,0,0, this.getWidth(), this.getHeight(),this);
   
        g.setColor(Color.RED);
        g.setFont(new Font("Arial",Font.BOLD,100));
       
        g.drawLine(800,200, 800, 880);
        g.drawLine(800, 880,700, 980);
        g.drawLine(800, 880, 900, 980);
        g.drawLine(400, 200, 800, 200);
        g.drawLine(400, 200, 400, 400);
        
        if(this.count==1)
        	g.drawOval(350,400,100,100);
        if(this.count==2) {
        	g.drawOval(350,400,100,100);
        	g.drawLine(400, 500, 400,700);
        }
        if(this.count==3) {
        	g.drawOval(350,400,100,100);
        	g.drawLine(400, 500, 400,700);
        	g.drawLine(300, 550, 400, 550);
        }
        if(this.count==4)
        {
        	g.drawOval(350,400,100,100);
        	g.drawLine(400, 500, 400,700);
        	g.drawLine(300, 550, 400, 550);
        	g.drawLine(500, 550, 400, 550);
        }
        if(this.count==5)
        {
        	g.drawOval(350,400,100,100);
        	g.drawLine(400, 500, 400,700);
        	g.drawLine(300, 550, 400, 550);
        	g.drawLine(500, 550, 400, 550);
        	g.drawLine(400, 700, 300, 800);
        }
        
        if(this.count==6)
        {
        	g.drawOval(350,400,100,100);
        	g.drawLine(400, 500, 400,700);
        	g.drawLine(300, 550, 400, 550);
        	g.drawLine(500, 550, 400, 550);
        	g.drawLine(400, 700, 300, 800);
        	g.drawLine(400, 700, 500, 800);
        }
     }
}