

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JRootPane;
import javax.swing.JTextField;

class process1 extends JFrame implements papaclass
{
	JPanel pnl,pnl1,pnl2;
	JLabel did,name,mno,am;
	JTextField di,na,mn;
	JTextField ca,ga,ba,aa,bb,cc,dd,ee,ff,gg,hh,ii,jj;
	JLabel c,g,b,u,f,ti,cyc,sp,toy;
	JButton d,s,cl,sa;
	Connection con;
	PreparedStatement pst;
	JComboBox c_date,c_year,c_month;
	process1()
	{ 
		
		con=Connectfi.getconnect();
		setLayout(null);
		//======------pnl
		pnl=new JPanel();
		pnl.setLayout(null);
		pnl.setBounds(20, 90, 350, 560);
		pnl.setBorder(BorderFactory .createLineBorder(Color.BLUE));
		pnl.setBackground(Color.lightGray);
		
		//--------------panel1
		pnl1=new JPanel();
		pnl1.setLayout(null);
		pnl1.setBounds(30,210, 290, 250);
		pnl1.setBorder(BorderFactory .createLineBorder(Color.green));
		pnl1.setBackground(Color.blue);
		pnl.add(pnl1);
		//------------------------panel2
		pnl2=new JPanel();
		pnl2.setLayout(null);
		pnl2.setBounds(10,10, 368, 74);
		pnl2.setBorder(BorderFactory .createLineBorder(Color.green));
		pnl2.setBackground(Color.blue);
		add(pnl2);
		//================---upper decoration
		
		ImageIcon emo=new ImageIcon("image.jpg");
		JLabel im=new JLabel(emo);
		im.setBounds(15, 15, 50, 50);
		pnl2.add(im);
		//------
		ImageIcon eme=new ImageIcon("icon.jpg");
		JLabel ic=new JLabel(eme);
		ic.setBounds(310, 15, 40, 40);
		pnl2.add(ic);
		//------
		JLabel ja=new JLabel();
		ja.setFont(new Font("serif",Font.LAYOUT_LEFT_TO_RIGHT,30));
		ja.setText("Donation Form ");
		ja.setForeground(Color.white);
		ja.setLocation(95, 8);
		ja.setSize(310, 50);
		pnl2.add(ja);
		//---------------down part labels
		did=new JLabel("DONER ID");
		did.setBounds(30, 20, 70, 25);
		did.setForeground(Color.blue);
		pnl.add(did);
		//------------form labels                          <-------------labels
		name=new JLabel("Name");
		name.setBounds(30, 65, 70, 25);
		name.setForeground(Color.blue);
		pnl.add(name);
		//------------
		mno=new JLabel("Mobile no.");
		mno.setBounds(30, 115, 70, 25);
		mno.setForeground(Color.blue);
		pnl.add(mno);
		am=new JLabel("Amount");
		am.setForeground(Color.white);
		am.setBounds(35, 25, 50, 30);
		pnl1.add(am);
		//===-----------
		aa=new JTextField("0");
		aa.setLayout(null);
		aa.setForeground(Color.blue);
		aa.setBorder(BorderFactory.createLineBorder(Color.green));
		aa.setBounds(100, 27, 150, 30);
		pnl1.add(aa);
		//====--------
		c=new JLabel("Copies");
		c.setForeground(Color.cyan);
		c.setBounds(10, 75, 50, 30);
		pnl1.add(c);
		//===----------
		g=new JLabel("Geometry");
		g.setForeground(Color.cyan);
		g.setBounds(100, 75, 90, 30);
		pnl1.add(g);
		//===----------	
		b=new JLabel("Book");
		b.setForeground(Color.cyan);
		b.setBounds(200, 75, 50, 30);
		pnl1.add(b);
		//===----------
		u=new JLabel("Uniform");
		u.setForeground(Color.cyan);
		u.setBounds(10, 130, 50, 30);
		pnl1.add(u);
		//===----------
		f=new JLabel("shoes");
		f.setForeground(Color.cyan);
		f.setBounds(100, 130, 50, 30);
		pnl1.add(f);
		//===----------
		ti=new JLabel("Tiffin box ");
		ti.setForeground(Color.cyan);
		ti.setBounds(200, 130, 70, 30);
		pnl1.add(ti);
		//===----------
		cyc=new JLabel("Cycile");
		cyc.setForeground(Color.cyan);
		cyc.setBounds(10, 180, 50, 30);
		pnl1.add(cyc);
		//------
		sp=new JLabel("Sports kit");
		sp.setForeground(Color.cyan);
		sp.setBounds(100, 180, 80, 30);
		pnl1.add(sp);
		//===----------
		toy=new JLabel("Toy");
		toy.setForeground(Color.cyan);
		toy.setBounds(200, 180, 50, 30);
		pnl1.add(toy);
		//==-----------------textfeild of down part          <--------------------Textfield
		di=new JTextField();
		di.setLayout(null);
		di.setForeground(Color.blue);
		di.setBounds(130, 20, 130, 30);
		di.setBorder(BorderFactory.createLineBorder(Color.orange));
		pnl.add(di);
		//=======================-----------------
		na=new JTextField();
		na.setLayout(null);
		na.setForeground(Color.blue);
		na.setBounds(130, 65, 130, 30);
		na.setBorder(BorderFactory.createLineBorder(Color.orange));
		pnl.add(na);
		//=======================-----------------
		mn=new JTextField();
		mn.setLayout(null);
		mn.setForeground(Color.blue);
		mn.setBounds(130, 110, 130, 30);
		mn.setBorder(BorderFactory.createLineBorder(Color.orange));
		pnl.add(mn);
		//-------------
				c_date=new JComboBox();
				c_date.setBounds(60,160,60,30);
				c_date.addItem("D");
				pnl.add(c_date);
				for(int i=1;i<=31;i++)
				{
					c_date.addItem(i+"");
				}
				//-------------
				c_month=new JComboBox();
				c_month.setBounds(140,160,60,30);
				c_month.addItem("MM");
				pnl.add(c_month);
				for(int i=1;i<=12;i++)
				{
				c_month.addItem(i);
				}
				//------------
				c_year=new JComboBox();
				c_year.setBounds(220,160,80,30);
				c_year.addItem("YYYY");
				pnl.add(c_year);
				for(int i=2000;i<=2100;i++)
				{
				c_year.addItem(i);
				}
		//================---------------
	    bb=new JTextField("0");
		bb.setLayout(null);
		bb.setForeground(Color.blue);
		bb.setBorder(BorderFactory.createLineBorder(Color.green));
		bb.setBounds(64, 80, 20, 15);
		pnl1.add(bb);
		//------
		cc=new JTextField("0");
		cc.setLayout(null);
		cc.setForeground(Color.blue);
		cc.setBorder(BorderFactory.createLineBorder(Color.green));
		cc.setBounds(160, 80, 20, 15);
		pnl1.add(cc);
		//--------
		dd=new JTextField("0");
		dd.setLayout(null);
		dd.setForeground(Color.blue);
		dd.setBorder(BorderFactory.createLineBorder(Color.green));
		dd.setBounds(260, 80, 20, 15);
		pnl1.add(dd);
		//----2
		ee=new JTextField("0");
		ee.setLayout(null);
		ee.setForeground(Color.blue);
		ee.setBorder(BorderFactory.createLineBorder(Color.green));
		ee.setBounds(64, 135, 20, 15);
		pnl1.add(ee);
	    //----
		ff=new JTextField("0");
		ff.setLayout(null);
		ff.setForeground(Color.blue);
	     ff.setBorder(BorderFactory.createLineBorder(Color.green));
		ff.setBounds(160, 135, 20, 15);
		pnl1.add(ff);
	    //------
		gg=new JTextField("0");
		gg.setLayout(null);
		gg.setForeground(Color.blue);
		gg.setBorder(BorderFactory.createLineBorder(Color.green));
		gg.setBounds(260, 135, 20, 15);
		pnl1.add(gg);
		//-------3
		hh=new JTextField("0");
		hh.setLayout(null);
		hh.setForeground(Color.blue);
		hh.setBorder(BorderFactory.createLineBorder(Color.green));
		hh.setBounds(64, 185, 20, 15);
		pnl1.add(hh);
	    //----
		ii=new JTextField("0");
		ii.setLayout(null);
		ii.setForeground(Color.blue);
		ii.setBounds(160, 185, 20, 15);
		ii.setBorder(BorderFactory.createLineBorder(Color.green));
		pnl1.add(ii);
	    //------
		jj=new JTextField("0");
		jj.setLayout(null);
		jj.setForeground(Color.blue);
		jj.setBounds(260, 185, 20, 15);
		jj.setBorder(BorderFactory.createLineBorder(Color.green));
		pnl1.add(jj);
		//=================================                <-----------buttons
		ImageIcon g=new ImageIcon("news.jpg");
		d=new JButton(g);
		d.setLocation(20, 490);
		d.setSize(75, 25);
		pnl.add(d);
		//=================================
		ImageIcon e=new ImageIcon("save.jpg");
		s=new JButton(e);
		s.setLocation(145, 490);
		s.setSize(75, 25);
		pnl.add(s);
		//=================================
		ImageIcon toc=new ImageIcon("cancel.jpg");
		cl=new JButton(toc);
		cl.setLocation(260, 490);
		cl.setSize(74, 25);
		pnl.add(cl);
	   //=================================
				ImageIcon tol=new ImageIcon("fet.jpg");
				sa=new JButton(tol);
				sa.setBorderPainted(false);
				sa.setLocation(265, 20);
				sa.setSize(65, 30);
				pnl.add(sa);
		//======------window
		add(pnl);
		  setUndecorated(true);
			getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
		setSize(400,700);
		setResizable(false);
		//=================================================action
		s.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				save();
				System.out.println("hlo kohli");
				
			}
		});
		//---------
		d.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg1) {
			      nwa();	
			}
		});
		//----
		cl.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg5) {
				close();
			}
		});
	
           sa.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
		        
				fetch();
				
			}
		});
           //---addfocus
           aa.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				aa.setBackground(Color.white);
				
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				aa.setText("");
				aa.setBackground(Color.lightGray);
			}
		});
           bb.addFocusListener(new FocusListener() {
   			
   			@Override
   			public void focusLost(FocusEvent e) {
   				bb.setBackground(Color.white);
   				
   			}
   			
   			@Override
   			public void focusGained(FocusEvent e) {
   				// TODO Auto-generated method stub
   				bb.setText("");
   				bb.setBackground(Color.lightGray);
   			}
   		});
           cc.addFocusListener(new FocusListener() {
   			
   			@Override
   			public void focusLost(FocusEvent e) {
   				cc.setBackground(Color.white);
   				
   			}
   			
   			@Override
   			public void focusGained(FocusEvent e) {
   				// TODO Auto-generated method stub
   				cc.setText("");
   				cc.setBackground(Color.lightGray);
   			}
   		});
           dd.addFocusListener(new FocusListener() {
      			
      			@Override
      			public void focusLost(FocusEvent e) {
      				dd.setBackground(Color.white);
      				
      			}
      			
      			@Override
      			public void focusGained(FocusEvent e) {
      				// TODO Auto-generated method stub
      				dd.setText("");
      				dd.setBackground(Color.lightGray);
      			}
      		});
           ee.addFocusListener(new FocusListener() {
      			
      			@Override
      			public void focusLost(FocusEvent e) {
      				ee.setBackground(Color.white);
      				
      			}
      			
      			@Override
      			public void focusGained(FocusEvent e) {
      				// TODO Auto-generated method stub
      				ee.setText("");
      				ee.setBackground(Color.lightGray);
      			}
      		});
           ff.addFocusListener(new FocusListener() {
     			
     			@Override
     			public void focusLost(FocusEvent e) {
     				ff.setBackground(Color.white);
     				
     			}
     			
     			@Override
     			public void focusGained(FocusEvent e) {
     				// TODO Auto-generated method stub
     				ff.setText("");
     				ff.setBackground(Color.lightGray);
     			}
     		});
           gg.addFocusListener(new FocusListener() {
     			
     			@Override
     			public void focusLost(FocusEvent e) {
     				gg.setBackground(Color.white);
     				
     			}
     			
     			@Override
     			public void focusGained(FocusEvent e) {
     				// TODO Auto-generated method stub
     				gg.setText("");
     				gg.setBackground(Color.lightGray);
     			}
     		});
           hh.addFocusListener(new FocusListener() {
     			
     			@Override
     			public void focusLost(FocusEvent e) {
     				hh.setBackground(Color.white);
     				
     			}
     			
     			@Override
     			public void focusGained(FocusEvent e) {
     				// TODO Auto-generated method stub
     				hh.setText("");
     				hh.setBackground(Color.lightGray);
     			}
     		});
           ii.addFocusListener(new FocusListener() {
     			
     			@Override
     			public void focusLost(FocusEvent e) {
     				ii.setBackground(Color.white);
     				
     			}
     			
     			@Override
     			public void focusGained(FocusEvent e) {
     				// TODO Auto-generated method stub
     				ii.setText("");
     				ii.setBackground(Color.lightGray);
     			}
     		});
           jj.addFocusListener(new FocusListener() {
     			
     			@Override
     			public void focusLost(FocusEvent e) {
     				jj.setBackground(Color.white);
     				
     			}
     			
     			@Override
     			public void focusGained(FocusEvent e) {
     				// TODO Auto-generated method stub
     				jj.setText("");
     				jj.setBackground(Color.lightGray);
     			}
     		});
	}
	
	//------------------function
	
	 void save()
	  {
		 //JOptionPane.showMessageDialog(null, am.getText());
		  try
		  {
			  //JTextField di,na,mn;
			  //	JTextField ca,ga,ba,aa,bb,cc,dd,ee,ff,gg,hh,ii,jj;
			  //"insert into detail(usernsme,pwd,mobileno) values(?,?,?)")
			  pst=con.prepareStatement("insert into donardonation(Name,Mobile_No,Donar_ID,Amount,Copy,Geometry,Book,Uniform,Shoes,Tiffin_Box,Cycle,Sports_kit,Toy,Date) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			  pst.setString(1,na.getText());
			  pst.setString(2,mn.getText());
			  pst.setInt(3,Integer.parseInt(di.getText()));
			  pst.setInt(4, Integer.parseInt(aa.getText()));
			  pst.setInt(5,Integer.parseInt(bb.getText()));
			  pst.setInt(6,Integer.parseInt(cc.getText()));
			  pst.setInt(7,Integer.parseInt(dd.getText()));
			  pst.setInt(8,Integer.parseInt(ee.getText()));
			  pst.setInt(9,Integer.parseInt(ff.getText()));
			  pst.setInt(10,Integer.parseInt(gg.getText()));
			  pst.setInt(11,Integer.parseInt(hh.getText()));
			  pst.setInt(12,Integer.parseInt(ii.getText()));
			  pst.setInt(13,Integer.parseInt(jj.getText()));
			 
			
			  String s=c_year.getSelectedItem()+"-"+c_month.getSelectedItem()+"-"+c_date.getSelectedItem() ;
				
				 DateFormat format=new SimpleDateFormat("yyyy-MM-dd");
				 java.util.Date javawalli =format.parse(s);
				 java.sql.Date sqlwallidate=new Date(javawalli.getTime());
		      pst.setDate(14,sqlwallidate);
			
			 
			  int x=pst.executeUpdate();
			  JOptionPane.showMessageDialog(null, "save "+x+" data");
			  pst.close();
		  }
		  catch(Exception m)
		  {
			  JOptionPane.showMessageDialog(null, "Enter Data in Feild Properly" );
			 
			  
		  }
	  }
	  void nwa()
	  {
		  try
		  {
			  di.setText("");
			  na.setText("");
			  mn.setText("");
			  aa.setText("");
			  bb.setText("");
			  cc.setText("");
			  dd.setText("");
			  ee.setText("");
			  ff.setText("");
			  gg.setText("");
			  hh.setText("");
			  ii.setText("");
			  jj.setText("");
			 
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
	  void fetch()
	  {
		  try
		  {
			int jasus;
			  String donarid="",namm="",mobileno="";
		  pst=con.prepareStatement("select Name,Mobile_No from donarregistation where Donar_ID=?");
		  pst.setString(1,di.getText());
		  ResultSet rs=pst.executeQuery();
		  if(rs.next())
		  {
			  jasus=1;
			  namm=rs.getString("Name");
			  mobileno=rs.getString("Mobile_No");
		  }
		  else
		  {
			  jasus=0;
			  JOptionPane.showMessageDialog(null, "Not Correct ID");
		  }
		  if(jasus==1)
		  {
			  JOptionPane.showMessageDialog(null,"see fetch data" );
			  na.setText(namm);
			  mn.setText(mobileno);
		  }
		  }
		  catch(Exception yy)
		  {
			  JOptionPane.showMessageDialog(null, yy.getMessage());
		  }
	  }
}
 class DonarDonation 
{
public static void main(String arg[])
   {
	process1 p=new process1();
   }
}
