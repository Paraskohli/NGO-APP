
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Image;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.filechooser.FileNameExtensionFilter;

class win9 extends JFrame implements papaclass
{
	JPanel pnl,pnl2,pnl3,pnl4,pnl5;
	JLabel name,contect,address,city,email,state,pincode,occupation,pic;
	JButton submit,ne,cancel,update,browse;
	JTextField nam,em,cont,sta,cit,pin,occ;
	JComboBox d;
	JTextArea add;
	Connection con;
	File f;
	String picture;
	PreparedStatement pst;
	int savechecker=0;
	win9() 
	{
		con=Connectfi.getconnect();
		//------------------------------------panel             <-------------------panel
		pnl=new JPanel();
		pnl.setLayout(null);
		pnl.setBounds(23, 70, 350, 570);
		pnl.setBorder(BorderFactory.createLineBorder(Color.blue));
		pnl.setBackground(Color.lightGray);
		add(pnl);
		//------
		pnl4=new JPanel();
		pnl4.setLayout(null);
		pnl4.setBounds(375, 70, 180, 570);
		pnl4.setBorder(BorderFactory.createLineBorder(Color.blue));
		pnl4.setBackground(Color.lightGray);
		add(pnl4);
		pnl5=new JPanel();
		pnl5.setLayout(null);
		pnl5.setBounds(10, 50, 160, 280);
		pnl5.setBorder(BorderFactory.createLineBorder(Color.blue));
		pnl5.setBackground(Color.lightGray);
		pnl4.add(pnl5);
		//---------
	    pic=new JLabel();
        pic.setBounds(0,0, 160, 280);
        pnl5.add(pic);
		 browse=new JButton("Browser");
		 browse.setBounds(40, 380, 110, 40);
		 pnl4.add(browse);
			browse.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					JFileChooser fileopen=new JFileChooser();
					FileNameExtensionFilter filter=new FileNameExtensionFilter("JPEG file", "jpg","jpeg");
					fileopen.setFileFilter(filter);
					int x=fileopen.showOpenDialog(null);
					if(x==fileopen.CANCEL_OPTION)
					{
						JOptionPane.showConfirmDialog(null, "You apply cancel button");
					}
					else
					{
						f=fileopen.getSelectedFile();
						picture=String.valueOf(f.getAbsoluteFile());
						picturemaker();
					}
					
				}
			});
	       
		//-----------------pnl2
		pnl2=new JPanel();
		pnl2.setLayout(null);
		pnl2.setBounds(5, 5, 560, 60);
	//	pnl2.setBorder(BorderFactory.createLineBorder(Color.green));
		//pnl2.setBackground(Color.red);
		add(pnl2);
		//---------------=======================label--1                <---------labels
		JLabel ja=new JLabel();
		ja.setFont(new Font("serif",Font.BOLD,21));
		ja.setText("Donation Registration Form ");
		ja.setForeground(Color.blue);
		ja.setLocation(75, 2);
		ja.setSize(310, 40);
		pnl2.add(ja);
		//---------                   <---------------------upperlabel
		JLabel did =new JLabel();
		did.setText("DONOR ID");
		did.setBounds(430, 2, 70, 30);
		did.setFont(new Font("serif",Font.CENTER_BASELINE,12));
		pnl2.add(did);
		//======================-------labels--2                         <-------labels
		name=new JLabel("NAME*");
		name.setBounds(35, 30, 70, 25);
		name.setForeground(Color.BLUE);
		pnl.add(name);
		//------
		email=new JLabel("EMAIL ID*");
		email.setBounds(35, 75, 70, 25);
		email.setForeground(Color.BLUE);
		pnl.add(email);
		//------
		contect=new JLabel("MOBILE N0.*");
		contect.setBounds(35,120, 70, 25);
		contect.setForeground(Color.BLUE);
		pnl.add(contect);
		//--------
		state=new JLabel("STATE*");
		state.setBounds(35, 165, 90, 25);
		state.setForeground(Color.BLUE);
		pnl.add(state);
		//------
		city=new JLabel("CITY*");
		city.setBounds(35, 210, 110, 25);
		city.setForeground(Color.BLUE);
		pnl.add(city);
		//--------
		address=new JLabel("ADDRESS*");
		address.setBounds(35, 255, 130, 25);
		address.setForeground(Color.BLUE);
		pnl.add(address);
		//--------
		pincode=new JLabel("PIN CODE");
		pincode.setBounds(35, 340, 150, 25);
		pincode.setForeground(Color.BLUE);
		pnl.add(pincode);
		//------
		occupation=new JLabel("OCCUPATION*");
		occupation.setBounds(35, 385, 170, 25);
		occupation.setForeground(Color.BLUE);
		pnl.add(occupation);
		//-------------
        d=new JComboBox();
		d.setBounds(430, 30, 70, 20);
		setForeground(Color.BLUE);
		pnl2.add(d);
		//======-----------------textfeild                  <------------textfeild
		nam=new JTextField();
		nam.setBounds(120, 30, 220, 30);
		nam.setForeground(Color.BLUE);
		nam.setBorder(BorderFactory.createLineBorder(Color.green));
		pnl.add(nam);
		//----------
		em=new JTextField();
		em.setBounds(120, 75, 220, 30);
		em.setForeground(Color.BLUE);
		em.setBorder(BorderFactory.createLineBorder(Color.green));
		pnl.add(em);
		//----------	
		cont=new JTextField();
		cont.setBounds(120, 120, 220, 30);
		cont.setForeground(Color.BLUE);
		cont.setBorder(BorderFactory.createLineBorder(Color.green));
		pnl.add(cont);
		//----------	
		sta=new JTextField();
		sta.setBounds(120, 165, 220, 30);
		sta.setForeground(Color.BLUE);
		sta.setBorder(BorderFactory.createLineBorder(Color.green));
		pnl.add(sta);
		//----------
		cit=new JTextField();
		cit.setBounds(120, 210, 220, 30);
		cit.setForeground(Color.BLUE);
		cit.setBorder(BorderFactory.createLineBorder(Color.green));
		pnl.add(cit);
		//----------
		
		add=new JTextArea("Fill the address",5,50);
		JScrollPane scr=new JScrollPane(add);
		//add=new JTextField();
		scr.setBounds(120, 250, 220, 70);
		scr.setForeground(Color.BLUE);
		scr.setBorder(BorderFactory.createLineBorder(Color.green));
		pnl.add(scr);
		//----------	
		pin=new JTextField();
		pin.setBounds(120, 340, 220, 30);
		pin.setForeground(Color.BLUE);
		pin.setBorder(BorderFactory.createLineBorder(Color.green));
		pnl.add(pin);
		//----------	
		occ=new JTextField();
		occ.setBounds(120, 385, 220, 30);
		occ.setForeground(Color.BLUE);
		occ.setBorder(BorderFactory.createLineBorder(Color.green));
		pnl.add(occ);
		//--------------action listner with focuslistner
	    nam.addFocusListener(new FocusListener() {
	    	
	    	@Override
	    	public void focusLost(FocusEvent arg7) {
	    		// TODO Auto-generated method stub
	    	      nam.setBackground(Color.white);
	    	}
	    	
	    	@Override
	    	public void focusGained(FocusEvent arg7) {
	    		// TODO Auto-generated method stub
	    		nam.setBackground(Color.lightGray);
	    	}
	    });  
	    //------
    em.addFocusListener(new FocusListener() {
	    	
	    	@Override
	    	public void focusLost(FocusEvent arg7) {
	    	if(email()==false)
	    	{
	    		em.setText("");
	    		em.setBackground(Color.red);
	    		
	    	}
	    	else
	    	{
	    		 em.setBackground(Color.white);
	    	}      
	    		
	   	}
	    	
	    	@Override
	    	public void focusGained(FocusEvent arg7) {
	    		// TODO Auto-generated method stub
	    		em.setBackground(Color.LIGHT_GRAY);
	    	}
	    });  
    //------
cont.addFocusListener(new FocusListener() {
    	
    	@Override
    	public void focusLost(FocusEvent arg7) {
    		// TODO Auto-generated method stub
    	      //cont.setBackground(Color.white);
    		if(check2()==false)
    		{
    			
    			
    			cont.setBackground(Color.red);
    			cont.requestFocusInWindow();
    		}
    		else
    		{
    			cont.setBackground(Color.white);
    		}
    	}
    	
    	@Override
    	public void focusGained(FocusEvent arg7) {
    		// TODO Auto-generated method stub
    		cont.setBackground(Color.LIGHT_GRAY);
    	}
    });  	 
//------
sta.addFocusListener(new FocusListener() {
	
	@Override
	public void focusLost(FocusEvent arg7) {
		// TODO Auto-generated method stub
	      sta.setBackground(Color.white);
	}
	
	@Override
	public void focusGained(FocusEvent arg7) {
		// TODO Auto-generated method stub
		sta.setBackground(Color.LIGHT_GRAY);
	}
});  	   
//------
cit.addFocusListener(new FocusListener() {
	
	@Override
	public void focusLost(FocusEvent arg7) {
		// TODO Auto-generated method stub
	      cit.setBackground(Color.white);
	}
	
	@Override
	public void focusGained(FocusEvent arg7) {
		// TODO Auto-generated method stub
		cit.setBackground(Color.LIGHT_GRAY);
	}
});  

//------
add.addFocusListener(new FocusListener() {
	
	@Override
	public void focusLost(FocusEvent arg7) {
		// TODO Auto-generated method stub
	      add.setBackground(Color.white);
	}
	
	@Override
	public void focusGained(FocusEvent arg7) {
		// TODO Auto-generated method stub
		add.setBackground(Color.LIGHT_GRAY);
	}
});  
//------
pin.addFocusListener(new FocusListener() {
	
	@Override
	public void focusLost(FocusEvent arg7) {
		// TODO Auto-generated method stub
	      pin.setBackground(Color.white);
	}
	
	@Override
	public void focusGained(FocusEvent arg7) {
		// TODO Auto-generated method stub
		pin.setBackground(Color.LIGHT_GRAY);
	}
});  
//------
pin.addFocusListener(new FocusListener() {
	
	@Override
	public void focusLost(FocusEvent arg7) {
		// TODO Auto-generated method stub
	      pin.setBackground(Color.white);
	}
	
	@Override
	public void focusGained(FocusEvent arg7) {
		// TODO Auto-generated method stub
		pin.setBackground(Color.LIGHT_GRAY);
	}
});
occ.addFocusListener(new FocusListener() {
	
	@Override
	public void focusLost(FocusEvent arg7) {
		// TODO Auto-generated method stub
	      occ.setBackground(Color.white);
	}
	
	@Override
	public void focusGained(FocusEvent arg7) {
		// TODO Auto-generated method stub
		occ.setBackground(Color.LIGHT_GRAY);
	}
});
	
	//=====================---------------button                  <-------buttons
		
		submit=new JButton("Submit");
		submit.setBorderPainted(false);
		submit.setLocation(70,450);
		submit.setSize(100, 40);
		submit.setCursor(new Cursor(Cursor.HAND_CURSOR));
	    pnl.add(submit);
	    //------------------
	    cancel=new JButton("Cancel");
	    cancel.setBorderPainted(false);
	    cancel.setLocation(230,450);
	    cancel.setSize(100, 40);
		cancel.setCursor(new Cursor(Cursor.HAND_CURSOR));
	    pnl.add( cancel);
	    //------------------
	    ne=new JButton("New");
	    ne.setBorderPainted(false);
	    ne.setLocation(70,500);
	    ne.setSize(100, 40);
		ne.setCursor(new Cursor(Cursor.HAND_CURSOR));
	    pnl.add(ne);
	    //------------------
	    update=new JButton("Update");
	    update.setBorderPainted(false);
	    update.setLocation(230,500);
	    update.setSize(100, 40);
		update.setCursor(new Cursor(Cursor.HAND_CURSOR));
	    pnl.add(update);
	
//---------                                              <----------------action listner on button
ne.addActionListener(new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent arg1) {
	      nwa();	
	}
});
//----
cancel.addActionListener(new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent arg7) {
		close();
	}
});
update.addActionListener(new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent arg4) {
	    	update();
	    	JOptionPane.showMessageDialog(null, "your Data is Updated ....");
	}
});
//====------------                            
d.addActionListener(new ActionListener() {

@Override
public void actionPerformed(ActionEvent arg0) {
    
	//JOptionPane.showInputDialog(null,"Enter the Donar ID");
	fetch();
	//JOptionPane.showMessageDialog(null, "hiii this is fetch");
}
});	
//------------------------action
submit.addActionListener(new ActionListener() {

@Override
public void actionPerformed(ActionEvent arg0) {
save();
System.out.println("Your Data is Saved");
}
});		


		//======================-------------------window
	    setUndecorated(true);
		getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
		setLayout(null);
		setSize(585,710);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		//=========
		fetchIds();
	
			
}                          //<------------------------------constucter finish
	  void save()
	  {
		  if(savechecker==0)
		  {//JTextField nam,em,cont,sta,cit,pin,occ;
			  if(nam.getText().equals("")||em.getText().equals("")||cont.getText().equals("")||
					  sta.getText().equals("")||cit.getText().equals("")||occ.getText().equals(""))
			  {
				  JOptionPane.showMessageDialog(null, "You are not Filling the * Fields");
			  }
			  else
			  {
		      try
		      {
			  //"insert into detail(usernsme,pwd,mobileno) values(?,?,?)")
			 
			 /* pst=con.prepareStatement("select max(Donar_ID) as 'Max' from donarregistation");
			  ResultSet rs=pst.executeQuery();
			  if(rs.next())
			  {System.out.println("hlo");
				  int max=rs.getInt("Max");
				  JOptionPane.showMessageDialog(null, max);
			  }*/
			  
			
			  
			  pst=con.prepareStatement("insert into donarregistation(Name,Email_ID,Mobile_No,State,City,Address,PIN,Occupation,Donar_pic_Path) values(?,?,?,?,?,?,?,?,?)");
			  pst.setString(1,nam.getText());
			  pst.setString(2,em.getText());
			  pst.setString(3,cont.getText());
			  pst.setString(4,sta.getText());
			  pst.setString(5,cit.getText());
			  pst.setString(6,add.getText());
			  pst.setString(7,pin.getText());
			  pst.setString(8,occ.getText());
			  pst.setString(9, picture);
			  int x=pst.executeUpdate();
			  JOptionPane.showMessageDialog(null, "save "+x+" data");
			  pst.close();
		      }
		      catch(Exception m)
		      {
			  String a=m.getMessage();
			  JOptionPane.showMessageDialog(null, a);
		      }
			 }
		  }
		  else
		  {
			  JOptionPane.showMessageDialog(null, "You Need to Update the Present Data");
		  }
	  }
	  void nwa()
	  {
		  try
		  {    
//			------------------------------------------->any tarikaato go to select
			  nam.setText("");
			  em.setText("");
			  cont.setText("");
			  sta.setText("");
			  cit.setText("");
			  pin.setText("");
			  occ.setText("");
			  add.setText("");
			  
			  JOptionPane.showMessageDialog(null, "new apply");
		  }
		  catch(Exception tt)
		  {
			  tt.printStackTrace();
		  }
	  }
	  void close()
	  {
		  try
		  {
			  JOptionPane.showMessageDialog(null, "close is apply");
			  System.exit(0);
			  
		  }
		  catch(Exception mn)
		  {
			  mn.printStackTrace();
		  }
	  }
	  void update()
	  {
		  //JTextField nam,em,cont,sta,cit,pin,occ;
		//	JTextArea add;
		  try
		  {
			  pst=con.prepareStatement("update donarregistation set Name=?,Email_ID=?,Mobile_No=?,State=?,City=?,Address=?,PIN=?,Occupation=?,Donar_Pic_Path=? where Donar_ID=?");
			  pst.setString(10,d.getSelectedItem().toString());
			  pst.setString(1,nam.getText());
			  pst.setString(2,em.getText());
			  pst.setString(3,cont.getText());
			  pst.setString(4,sta.getText());
			  pst.setString(5,cit.getText());
			  pst.setString(6,add.getText());
			  pst.setString(7,pin.getText());
			  pst.setString(8,occ.getText());
			  pst.setString(9,picture);
			  int x=pst.executeUpdate();
			  JOptionPane.showMessageDialog(null, "update"+x);
			    
		  }
		  catch(Exception jj)
		  {
			  jj.printStackTrace();
		  }
	  }
	  void fetch()
	  {
		  try
		  {
			
			  //JOptionPane.showMessageDialog(null, "hiiii Mr kohli");
		  int jasus=1;
		  String name="",emid="",conts="",staa="",cita="",adda="",pina="",occa="";
		  pst=con.prepareStatement("select Name,Email_ID,Mobile_No,State,City,Address,PIN,Occupation,Donar_Pic_Path from donarregistation where Donar_ID=?");
		  pst.setString(1,d.getSelectedItem().toString());
		  ResultSet rs=pst.executeQuery();
		  if(rs.next())
		     {
			  savechecker=1;
			  jasus=1;
			  name=rs.getString("Name");
			  emid=rs.getString("Email_ID");
			  conts=rs.getString("Mobile_No");
			  staa=rs.getString("State");
			  cita=rs.getString("City");
			  adda=rs.getString("Address");
			  pina=rs.getString("PIN");
			  occa=rs.getString("Occupation");
			  picture=rs.getString("Donar_Pic_Path");
			  picturemaker();
			  System.out.print("hi paras");
		     }
		  else
		  {
			  jasus=0;
		  }
		  if(jasus==1)
		  {
			  JOptionPane.showMessageDialog(null,"see fetch data" );
			  nam.setText(name);
			  em.setText(emid);
			  cont.setText(conts);
			  sta.setText(staa);
			  cit.setText(cita);
			  pin.setText(pina);
			  occ.setText(occa);
			  add.setText(adda);
			  
		  }
		  
		  }
		  catch(Exception emn)
		  {
			  String a=emn.getMessage();
			  JOptionPane.showMessageDialog(null, a);
		  }
	  }

//------------------
	  void fetchIds()
	  {
		  //d.removeAllItems();
		  d.addItem("Select");
		  try
		  {
		  pst=con.prepareStatement("select distinct Donar_ID from donarregistation");

		  ResultSet rs=pst.executeQuery();
		  while(rs.next())
		     {
			  int idd=rs.getInt("Donar_ID");
			  d.addItem(idd+"");
			  //JOptionPane.showMessageDialog(null,idd+"" );
		     }
		  }
		  catch(Exception emn)
		  {
			  String a=emn.getMessage();
			  JOptionPane.showMessageDialog(null, a);
		  }
	  }
	  
	  boolean check2()
	  {
		  String mobile="^[789]\\d{9}$";
		  //JOptionPane.showMessageDialog(null, cont.getText());
		  boolean b=cont.getText().matches(mobile);
		  //JOptionPane.showMessageDialog(null, b);
		  return b;
		  
	  }
	  void picturemaker()
		{
			Image im=(new ImageIcon(picture)).getImage();
			ImageIcon imm=new ImageIcon(im.getScaledInstance(160,280,Image.SCALE_DEFAULT));
			pic.setIcon(imm);
		}
	  Boolean email()
	  {
		  String Email_pattern="^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
				  + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
				Boolean retu=em.getText().matches(Email_pattern);
				return retu;
	  }
}
public class DonarRegistration {

	public static void main(String[] args) {
		win9 w=new win9();
	}
}
