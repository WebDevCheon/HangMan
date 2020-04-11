package Gaming;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.Vector;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class WordPanel extends JPanel
{
	JLabel word=new JLabel("Word: ");
	JLabel quiz=new JLabel();
	private String w;
	private int len;
	char[] array;

      public WordPanel()  //�ϴ� JFrame���� �г��� ����� 1.�ܾ� �������  2.�ܾ �̷�� �迭�� ������ 3.�гο� �� �ΰ� ������.
      {
    	   word.setForeground(Color.GREEN);
    	   quiz.setForeground(Color.GREEN);
    	    w=getWord();
    	    array=new char[w.length()];
    	      
    	     for(int i=0;i<w.length();i++)
    	    	  array[i]='-';
            
    	      add(word);
    	      quizSet();
              add(quiz);
              word.setFont(new Font("Arial",Font.BOLD,50));
              quiz.setFont(new Font("Arial",Font.BOLD,50));
      }
           
      boolean match(char c)                           //�ܾ� ���ĺ� �� ���� �´��� �ȸ´��� Ȯ��             
      { 	    
    	 if(w.contains(String.valueOf(c)) || w.contains(String.valueOf((char)(c-32))))
    		 return true;
    	 else
    		 return false;
      }
      
      boolean is_all_matched()                       //�ܾ� ���� �� �¾Ҵ� �� Ȯ��
      {
         if(!new String(array).contains(String.valueOf('-')))
        	 return true;
         else 
        	 return false;
      }
      
      void quizSet()                                //���õ� �ܾ �󺧿� ����ֱ�
      {
            quiz.setText(String.valueOf(array));    	  
      }
      
      int getLen()                                  //�ܾ��� ����
      {
    	  len=w.length();
    	  return len;
      }
      
      String getWord()                               //���Ͽ��� �ܾ� �����ϰ� ��ȯ�ϱ�
      {
    	  int randomLine;
    	  Random rand=new Random();
    	  Vector<String> vector=new Vector<String>();
    	  File file=new File("C:\\HangMan\\Game\\WordsFile\\words.txt");
    	  BufferedReader bfd;
    	  String a;
    	  
    	  try 
    	  {
    		  FileReader fd=new FileReader(file);
    		  bfd=new BufferedReader(fd);
    		  for(int i=0;i<25143;i++)
    	  {
    		  a=bfd.readLine();
    		  vector.add(a);
    	  }
    	  }catch(IOException e) 
    	  	{
    		  e.printStackTrace();
    		}
    	  
    	  randomLine=rand.nextInt(25143);
    	 
    	  w=vector.elementAt(randomLine); 
    	  return w;
      }
      
      void changeWord(char c)                //JTextField���� �Է��� ���ڰ� �ܾ��� �� ���ڶ� ���ٸ� ���� c�� ��ȭ��Ű��->ActionListener�� ����
      {
    	  for(int i=0;i<w.length();i++)
    	  {
    		  if(w.charAt(i)==c)  //���� ���ڰ� ���� ���
    		  {
    			  for(int j=0;j<w.length();j++)    
    			  {
    				  if((w.charAt(j)+32)==c)      //�빮�ڿ� �ҹ��ڰ� ���� �ܾ� �ȿ��� �����ϴ� ���     
    					  array[j]=(char)(c-32);
    			  }
    			  array[i]=c;
    			  quizSet();
    		  }
    		  
    		  if(w.charAt(i)==c-32)   //�빮�ڸ� �����ϴ� ���
    		  {
    			  array[i]=(char)(c-32);
    			  quizSet();
    		  }
    		  
    	  }
      }
      
      String word()
      {
    	  return w;
      }
      
      void reset() //
      {
    	  w=getWord();
    	  array=new char[w.length()];
    	  for(int i=0;i<w.length();i++)
    		  array[i]='-';
    	  quizSet();
      }
      
      public void paintComponent(Graphics g)
      {
         super.paintComponent(g);	       
     	
         	ImageIcon icon=new ImageIcon("C:\\HangMan\\Game\\image\\password.jpg");
     		Image img=icon.getImage();
     		
     		g.drawImage(img,0,0, this.getWidth(), this.getHeight(),this);
      }

      //���̵��� ���� ���ߴ� ������ ���� �޶����� �ϴ� �޼ҵ� �����ϱ�
}