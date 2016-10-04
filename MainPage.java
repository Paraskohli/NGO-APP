import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.security.auth.Refreshable;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

class MainCalling extends JFrame
{
	papaclass ref;
	JPanel pnl1;
	JLabel lbl;
  public MainCalling()
  {
	    setLayout(null);
		//-----penal
		pnl1=new JPanel();
		pnl1.setBounds(0, 0, 1350, 730);
		//pnl1.setBorder(BorderFactory.createTitledBorder(null,"Change Password",TitledBorder.CENTER,0,getFont(),Color.BLUE));
		pnl1.setLayout(null);
		add(pnl1);
		
		//---------label
		  lbl=new JLabel();
	      lbl.setBounds(0, 0, 1370, 730);
	      pnl1.add(lbl);
	      picturemaker();
	      //---------
	      ImageIcon img1=new ImageIcon("donarRegForm.gif");
	      JButton b1=new JButton(img1);
	      b1.setBounds(720, 60,360, 30);
	      lbl.add(b1);
	      b1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ref=new win9();
				
			}
		});
	      //---------
	      ImageIcon img2=new ImageIcon("donationform.gif");
	      JButton b2=new JButton(img2);
	      b2.setBounds(920, 120,370, 30);
	      lbl.add(b2);
	      b2.addActionListener(new ActionListener() 
	      {	
				@Override
				public void actionPerformed(ActionEvent e)
				{  
					ref=new process1();
				}
			});
	      //---------
	      ImageIcon img3=new ImageIcon("schoolR.gif");
	      JButton b3=new JButton(img3);
	      b3.setBounds(720, 180,370, 30);
	      lbl.add(b3);
	      b3.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					ref=new pro();
				}
			});
	      //---------
	      ImageIcon img4=new ImageIcon("Lalldon.gif");
	      JButton b4=new JButton(img4);
	      b4.setBounds(920, 240,370, 30);
	      lbl.add(b4);
	      b4.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					ref=new Tabel();
				}
			});
	      //---------
	      ImageIcon img5=new ImageIcon("loadalldisti.gif");
	      JButton b5=new JButton(img5);
	      b5.setBounds(720, 300,370, 30);
	      lbl.add(b5);
	      b5.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					ref=new Tabel2();
				}
			});
	      //---------
	      ImageIcon img6=new ImageIcon("ngodistri.gif");
	      JButton b6=new JButton(img6);
	      b6.setBounds(920, 360,370, 30);
	      lbl.add(b6);
	      b6.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					ref=new win4();
				}
			});
	      //---------
	      ImageIcon img7=new ImageIcon("Cdetail.gif");
	      JButton b7=new JButton(img7);
	      b7.setBounds(720, 420,370, 30);
	      lbl.add(b7);
	      b7.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e)
				{
					  ref=new detail();
				}
			});
	      //---------
	      ImageIcon img8=new ImageIcon("donlog.gif");
	      JButton b8=new JButton(img8);
	      b8.setBounds(920, 480,370, 30);
	      lbl.add(b8);
	      b8.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e)
				{
					  ref=new dist();
				}
			});
	      //---------
	      ImageIcon img9=new ImageIcon("donarlog.gif");
	      JButton b9=new JButton(img9);
	      b9.setBounds(720, 540,370, 30);
	      lbl.add(b9);
	      b9.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e)
				{
					ref=new doa();
				}
			});
	      ImageIcon img10=new ImageIcon("crossBtn.png");
	      JButton b10=new JButton(img10);
	      b10.setBounds(1315, 3,30, 30);
	      lbl.add(b10);
	      b10.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e)
				{
					System.exit(0);
				}
			});
	      //------------
	    setUndecorated(true);
		setSize(1370, 730);
		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);
		
		
	}
	void picturemaker()
	{
		Image im=(new ImageIcon("note4.jpg")).getImage();
		ImageIcon imm=new ImageIcon(im.getScaledInstance(1370,730,Image.SCALE_DEFAULT));
		lbl.setIcon(imm);
	} 
}
public class MainPage {

	public static void main(String[] args) {
		MainCalling m=new MainCalling();

	}

}
