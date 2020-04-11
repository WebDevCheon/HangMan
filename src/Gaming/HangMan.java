package Gaming;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
///////////////////////////////////////////전체 창-->마지막에 모든 패널을 다 갖다 붙일 것임
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class HangMan extends JFrame implements ActionListener
{
	CountPanel cp=new CountPanel();
	TextPanel tp=new TextPanel(this);
	WordPanel wp=new WordPanel();
	DrawPanel dp=new DrawPanel();
	///////////////////////////////////////////////////////////////////////
	
	public void actionPerformed(ActionEvent e)
	{
		JTextField tf=(JTextField)e.getSource();
		char c=tf.getText().charAt(0);
				
		if(!wp.match(c)) //예상 알파벳이 틀린 경우
		{
			cp.decrement();
			dp.increment();
			dp.repaint();
			tp.reset();
		}
		
		if(cp.getCount()==0) //모든 기회가 다 날아간 경우
		{
			JOptionPane.showMessageDialog(null,"You Lose!!!");
			cp.reset(); //카운트 패널 6으로 만들기
		 	dp.increment(); //드로우 패널 카운트값 증가시키기
		    dp.repaint(); //다시 그리기
		    dp.reset(); //카운트 값 0으로 만들기
		    tp.reset(); //텍스트 필드를 다시 아무것도 없는 것으로 되돌리기
		    wp.reset();
		    System.out.println(wp.word());
		}
		else //예상 알파벳이 맞은 경우
			{
				wp.changeWord(c);
				if(wp.is_all_matched())
				{
					JOptionPane.showMessageDialog(null,"You Win!!!");
				    cp.reset();
				    dp.reset();
				    dp.repaint();
				    wp.reset();
				    System.out.println(wp.word());
				}
				tp.reset();	
			}
	}
	
	class MyPanel_Right extends JPanel      //오른쪽 패널 (카운트 패널,텍스트 패널,워드 패널,부착)
	{
		public MyPanel_Right()	
		{
			setLayout(new GridLayout(3,1));
			add(wp);
			add(tp);
			add(cp);
		   
			wp.setPreferredSize(new Dimension(600,200));
			tp.setPreferredSize(new Dimension(700,300));
			cp.setPreferredSize(new Dimension(600,200));
		    
			setPreferredSize(new Dimension(940,1050));	
		}

	}

    HangMan()
    {
    	super("HangManGame");
        setSize(1920,1080);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    	setLayout(new FlowLayout());
    	add(dp);
    	add(new MyPanel_Right());   	
        
    	
        System.out.println(wp.word());
        
    	setVisible(true);
    }
	
	public static void main(String[] args) 
	{
	    new HangMan();
	}
    
}