import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

import org.omg.CosNaming.NamingContextExtPackage.AddressHelper;

class Progress extends JFrame
{
	JProgressBar prog;
	JLabel icon;
	Progress()
	{
      icon=new JLabel();
      add(icon);
      Image im=(new ImageIcon("progress.jpg")).getImage();
	  ImageIcon imm=new ImageIcon(im.getScaledInstance(410,260,Image.SCALE_DEFAULT));
	  icon.setIcon(imm);
      //-----
      prog=new JProgressBar(0,100);
      prog.setStringPainted(true);
      add(prog, BorderLayout.AFTER_LAST_LINE);
      prog.setBackground(Color.LIGHT_GRAY);

      prog.setForeground(Color.BLACK);

      setUndecorated(true);
      setSize(410, 260);
      setVisible(true); 
      setLocation(500,250);
      run();
	}
	void run()
	{
		for(int i=0;i<=100;i++)
		{
			prog.setValue(i);
			  try
			  {
				Thread.sleep(30);
			  }
			  catch(Exception e){}
			 
		 }
		 new log();
		 dispose();
		
	}
	
}
public class ProgressBar 
{ 
	public static void main(String[] args) 
	{
		Progress p=new Progress();
		
	    
	}

}
