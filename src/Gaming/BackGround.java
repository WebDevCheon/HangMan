package Gaming;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class BackGround extends JPanel 
{
	ImageIcon icon=new ImageIcon("C:\\HangMan\\Game\\image\\hangman-wallpaper-1920x1080.jpg");
	Image img=icon.getImage();
	
    public void paintComponent(Graphics g)
    {
    	super.paintComponent(g);
    	g.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
    }
}