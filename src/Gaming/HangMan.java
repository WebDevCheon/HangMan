package Gaming;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
///////////////////////////////////////////��ü â-->�������� ��� �г��� �� ���� ���� ����
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
				
		if(!wp.match(c)) //���� ���ĺ��� Ʋ�� ���
		{
			cp.decrement();
			dp.increment();
			dp.repaint();
			tp.reset();
		}
		
		if(cp.getCount()==0) //��� ��ȸ�� �� ���ư� ���
		{
			JOptionPane.showMessageDialog(null,"You Lose!!!");
			cp.reset(); //ī��Ʈ �г� 6���� �����
		 	dp.increment(); //��ο� �г� ī��Ʈ�� ������Ű��
		    dp.repaint(); //�ٽ� �׸���
		    dp.reset(); //ī��Ʈ �� 0���� �����
		    tp.reset(); //�ؽ�Ʈ �ʵ带 �ٽ� �ƹ��͵� ���� ������ �ǵ�����
		    wp.reset();
		    System.out.println(wp.word());
		}
		else //���� ���ĺ��� ���� ���
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
	
	class MyPanel_Right extends JPanel      //������ �г� (ī��Ʈ �г�,�ؽ�Ʈ �г�,���� �г�,����)
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