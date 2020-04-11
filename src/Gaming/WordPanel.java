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

      public WordPanel()  //일단 JFrame에서 패널을 만들면 1.단어 만들어짐  2.단어를 이루는 배열이 생성됨 3.패널에 라벨 두개 부착됨.
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
           
      boolean match(char c)                           //단어 알파벳 한 문자 맞는지 안맞는지 확인             
      { 	    
    	 if(w.contains(String.valueOf(c)) || w.contains(String.valueOf((char)(c-32))))
    		 return true;
    	 else
    		 return false;
      }
      
      boolean is_all_matched()                       //단어 전부 다 맞았는 지 확인
      {
         if(!new String(array).contains(String.valueOf('-')))
        	 return true;
         else 
        	 return false;
      }
      
      void quizSet()                                //선택된 단어를 라벨에 집어넣기
      {
            quiz.setText(String.valueOf(array));    	  
      }
      
      int getLen()                                  //단어의 길이
      {
    	  len=w.length();
    	  return len;
      }
      
      String getWord()                               //파일에서 단어 선택하고 반환하기
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
      
      void changeWord(char c)                //JTextField에서 입력한 문자가 단어의 한 문자랑 같다면 문자 c로 변화시키기->ActionListener로 구현
      {
    	  for(int i=0;i<w.length();i++)
    	  {
    		  if(w.charAt(i)==c)  //넣은 문자가 맞은 경우
    		  {
    			  for(int j=0;j<w.length();j++)    
    			  {
    				  if((w.charAt(j)+32)==c)      //대문자와 소문자가 같은 단어 안에서 공존하는 경우     
    					  array[j]=(char)(c-32);
    			  }
    			  array[i]=c;
    			  quizSet();
    		  }
    		  
    		  if(w.charAt(i)==c-32)   //대문자만 존재하는 경우
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

      //난이도에 따라서 맞추는 글자의 수를 달라지게 하는 메소드 구현하기
}