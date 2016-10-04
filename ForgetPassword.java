import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JTextField;
import javax.swing.border.Border;

class process7 extends JFrame
{
	JPanel pnl1,pnl,pnl2;
	JButton b;
	JTextField t;
	JLabel l,pic;
	JLabel ll;
	public static String bb,cc;
	java.sql.Connection con;
	PreparedStatement pst;
	process7()
	{
		con=Connectfi.getconnect();
	
		//==============pnl
		setLayout(null);
		pnl=new JPanel();
		pnl.setLayout(null);
		pnl.setBounds(0, 0, 400, 80);
		pnl.setBackground(Color.white);
		add(pnl);
		
		ll=new JLabel("FORGET PASSWORD");
		ll.setFont(new Font("Serif",Font.BOLD, 22));
		ll.setBounds(90, 5, 230, 70);
		ll.setForeground(Color.lightGray);
		pnl.add(ll);
		
		pnl1=new JPanel();
		pnl1.setBounds(55, 100, 280, 510);
		//pnl1.setBorder(BorderFactory.createLineBorder(Color.RED));
		pnl1.setLayout(null);
		//pnl1.setBackground(Color.);
		add(pnl1);
		ImageIcon ico=new ImageIcon("forget.gif");
		pic=new JLabel(ico);
		pic.setBounds(-10, -80, 300, 500);
		pic.setForeground(Color.white);
		pnl1.add(pic);
		l=new JLabel("User ID");
		l.setBounds(15, 360, 50, 30);
		pnl1.add(l);
		//==================
		t=new JTextField();
		t.setBounds(65, 360, 200, 30);
		pnl1.add(t);
		
        //==============
        
        b=new JButton("Send SMS");
      //  b.setBorder(null);
        b.setSize(175,45);
     //   b.setBorder(BorderFactory.createLineBorder(Color.blue));
        b.setLocation(80, 430);
        pnl1.add(b);
        pnl2=new JPanel();
		pnl2.setLayout(null);
		pnl2.setBounds(0, 40, 400, 650);
		pnl2.setBackground(Color.LIGHT_GRAY);
		add(pnl2);
        b.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
                 try
                 {
                	 pst=con.prepareStatement("select Mobile_No,Password from login where UserID=?");
                	 pst.setString(1, t.getText());
                	 ResultSet rs=pst.executeQuery();
                	 if(rs.next())
                	 {System.out.println("hlo");
                		 String Mobile=rs.getString("Mobile_No");
                		 String Password=rs.getString("Password");
                		 String msg=SMS.bceSunSoftSend(Mobile,"Your Secret Password Of NGO Desktop App Is : "+ Password);
                		 if(msg.equals("sent"))
                    	 {
                    		 JOptionPane.showMessageDialog(null, msg);
                    	 }
                    	 else
                    	 {
                    		 JOptionPane.showMessageDialog(null, "Not in Connection");
                    	 }
                	 }
                	 else
                	 {
                		 JOptionPane.showMessageDialog(null, "Wrong UserId ");
                	 }
                	
                 }
                 catch(Exception e)
                 {
                	 JOptionPane.showMessageDialog(null,e.getMessage());
                 }
                 
			}
		});
        
		//----------------------------window
		
	//	setUndecorated(true);
	//	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
		setSize(400,700);
		setResizable(false);
t.addFocusListener(new FocusListener() {
	    	
	    	@Override
	    	public void focusLost(FocusEvent arg7) {
	    		// TODO Auto-generated method stub
	    	      //cont.setBackground(Color.white);
	    		
	    		if(t.getText().equals(""))
	    		{
	    			t.requestFocusInWindow();
	    		}
	    		else
	    		{
	    			t.setBackground(Color.white);
	    		}
	    	}
	    	
	    	@Override
	    	public void focusGained(FocusEvent arg7) {
	    		// TODO Auto-generated method stub
	    		t.setBackground(Color.LIGHT_GRAY);
	    	}
	    });  	
		  
	//  getRootPane().setWindowDecorationStyle(JRootPane.PROPERTIES);
	}
}
public class ForgetPassword 
{
	public static void main(String[] args) 
	{
		 process7 h=new process7();
	}
}
