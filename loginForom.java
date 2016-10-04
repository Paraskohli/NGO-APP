import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

class log extends JFrame
{
	JPanel pnl1,pnl2,pnl3;
	JLabel lbl,lbll,lbl1,lbl2,lbl3;
	JTextField uid;
	JPasswordField psw;
    Connection con;
	PreparedStatement pst;
	log()
	{
		con=Connectfi.getconnect();
		setLayout(null);
		//--------pnl
		//-----penal
		pnl1=new JPanel();
		pnl1.setBounds(0, 0, 1350, 730);
		//pnl1.setBorder(BorderFactory.createTitledBorder(null,"Change Password",TitledBorder.CENTER,0,getFont(),Color.BLUE));
		pnl1.setLayout(null);
		add(pnl1);
		
		//---------label
		  lbl=new JLabel();
	      lbl.setBounds(0, 0, 1350, 720);
	      pnl1.add(lbl);
	      picturemaker();
	    //---------label
	      pnl2=new JPanel();
		  pnl2.setBounds(302,230, 720, 320);
		  pnl2.setLayout(null);
		  lbl.add(pnl2);
		  pnl3=new JPanel();
		  pnl3.setBounds(10,10, 300, 300);
		  pnl3.setLayout(null);
		  pnl2.add(pnl3);
		
		  //------
		 ImageIcon img =new ImageIcon("adm.jpg");
		  lbll=new JLabel(img);
	      lbll.setBounds(0, 0, 300, 300);
	      pnl3.add(lbll);
	      //label
	      lbl3=new JLabel("ADMINISTRATION LOGIN");
	      lbl3.setFont(new Font("Serif", Font.PLAIN, 25));
	      lbl3.setBounds(320, 30, 300, 50);
	      pnl2.add(lbl3);
	      
	      lbl1=new JLabel("User ID");
	      lbl1.setBounds(320, 110, 50, 30);
	      pnl2.add(lbl1);
	      
	      lbl2=new JLabel("Password");
	      lbl2.setBounds(320, 165, 60, 30);
	      pnl2.add(lbl2);
	      //------textfeild
		  uid=new JTextField();
		  uid.setBounds(420, 110, 230,30);
		  pnl2.add(uid);
		  psw=new JPasswordField();
		  psw.setBounds(420, 165, 230,30);
		  pnl2.add(psw);
		  //--------button
		  JButton login=new JButton("Login");
		  login.setBounds(545, 240, 100, 25);
		  pnl2.add(login);
		  JButton forget=new JButton("Forget");
		  forget.setBounds(425, 240, 100, 25);
		  pnl2.add(forget);
		  login.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			   Login();	
			}
		});
		  forget.addActionListener(new ActionListener() {
				
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				process7 p=new process7();
			}
		});
		  
	    //---------
		setSize(1370, 730);
		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);
		uid.addFocusListener(new FocusListener() {
	    	
	    	@Override
	    	public void focusLost(FocusEvent arg7) {
	    		// TODO Auto-generated method stub
	    	      //cont.setBackground(Color.white);
	    		
	    		if(uid.getText().equals(""))
	    		{
	    			uid.requestFocusInWindow();
	    		}
	    		else
	    		{
	    			uid.setBackground(Color.white);
	    		}
	    	}
	    	
	    	@Override
	    	public void focusGained(FocusEvent arg7) {
	    		// TODO Auto-generated method stub
	    		uid.setBackground(Color.LIGHT_GRAY);
	    	}
	    });  	 
psw.addFocusListener(new FocusListener() {
	    	
	    	@Override
	    	public void focusLost(FocusEvent arg7) {
	    		// TODO Auto-generated method stub
	    	      //cont.setBackground(Color.white);
	    		
	    		if(psw.getText().equals(""))
	    		{
	    			psw.requestFocusInWindow();
	    		}
	    		else
	    		{
	    			psw.setBackground(Color.white);
	    		}
	    	}
	    	
	    	@Override
	    	public void focusGained(FocusEvent arg7) {
	    		// TODO Auto-generated method stub
	    		psw.setBackground(Color.LIGHT_GRAY);
	    	}
	    });  	
		
	}
	void Login()
	{
	  try
	  {
		  pst=con.prepareStatement("select Password from login where UserID=?");
		  pst.setString(1, uid.getText());
		  ResultSet rs=pst.executeQuery();
		  if(rs.next())
		  {
			 String pass=rs.getString("Password");
			 if(pass.equals(psw.getText()))
			 {
				 MainCalling m=new MainCalling();
				 dispose();

			 }
			 else
			 {
				 JOptionPane.showMessageDialog(null, "Not Correct Password"); 
			 }
		  }
		  else
		  {
			  JOptionPane.showMessageDialog(null, "Not Correct ID");
		  }
	  }
	  catch (Exception e) {
		// TODO: handle exception
		  e.printStackTrace();
	    }
	  
	}
	void picturemaker()
	{
		Image im=(new ImageIcon("jk.jpg")).getImage();
		ImageIcon imm=new ImageIcon(im.getScaledInstance(1350,720,Image.SCALE_DEFAULT));
		lbl.setIcon(imm);
	}
	
}
public class loginForom {

	
	public static void main(String[] args) {
		log l=new log();
		

	}

}
