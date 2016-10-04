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
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JTextField;

class win4 extends JFrame implements papaclass
{
	JPanel pnl,pnl1,pnl2;
	JButton nwa,save,cancel;
	JLabel defination,l_school,l_date,amount,mode,photo;
	JCheckBox copies,geo,book,uni,shoes,tiffin,cycle,spokit,toy;
	JComboBox c_school,c_date,c_month,c_year,c_mode;	
	JTextField am,co,eo,bo,un,sh,ti,cy,sp,to;
	Connection con;
	PreparedStatement pst;
	int i=0,j=0,k=0,l=0,m=0,n=0,o=0,p=0,q=0;
	win4()
	{
		con=Connectfi.getconnect();
		setLayout(null);
		//-------------------------------------panel
		
	    pnl=new JPanel();
	    pnl.setLayout(null);
		pnl.setBounds(12, 80, 375, 550);
		pnl.setBorder(BorderFactory .createLineBorder(Color.BLACK));
		pnl.setBackground(Color.lightGray);
		add(pnl);
		//------------------label of pnl
		l_school=new JLabel("School");
		l_school.setForeground(Color.white);
		l_school.setFont(new Font("serif",Font.HANGING_BASELINE,17));
		l_school.setBounds(40, 20, 70, 50);
		pnl.add(l_school);
		//------------
		l_date=new JLabel("Date of Donation");
		l_date.setForeground(Color.white);
		l_date.setFont(new Font("serif",Font.HANGING_BASELINE,17));
		l_date.setBounds(10, 85, 130, 40);
		pnl.add(l_date);
		//------------------pnl combobox
		c_school=new JComboBox();
		c_school.setBounds(140,25,190,30);
		pnl.add(c_school);
		//-------------
		c_date=new JComboBox();
		c_date.setBounds(140,90,50,30);
		c_date.addItem("D");
		pnl.add(c_date);
		for(int i=1;i<=31;i++)
		{
			c_date.addItem(i+"");
		}
		//-------------
		c_month=new JComboBox();
		c_month.setBounds(200,90,50,30);
		c_month.addItem("M");
		pnl.add(c_month);
		for(int i=1;i<=12;i++)
		{
		c_month.addItem(i);
		}
		//------------
		c_year=new JComboBox();
		c_year.setBounds(260,90,70,30);
		c_year.addItem("Y");
		pnl.add(c_year);
		for(int i=2000;i<=2100;i++)
		{
		c_year.addItem(i);
		}
		//--------------------------------------panel1
		
	    pnl1=new JPanel();
	    pnl1.setLayout(null);
		pnl1.setBounds(25,130,330,300);
		pnl1.setBorder(BorderFactory .createLineBorder(Color.cyan));
		pnl1.setBackground(Color.blue);
		pnl.add(pnl1);
		//--------------combobox
		String t[]={"cash","check","draft"};
		c_mode=new JComboBox(t);
		c_mode.setBounds(240,30,60,30);
		pnl1.add(c_mode);
		//------------------pnl amount 
		amount=new JLabel("Amount");
		amount.setBounds(20, 30, 60, 30);
		amount.setForeground(Color.blue);
		amount.setFont(new Font("serif",Font.HANGING_BASELINE,17));
		pnl1.add(amount);
		//------
		mode=new JLabel("Mode");
		mode.setBounds(195, 30, 60, 30);
		mode.setForeground(Color.blue);
		mode.setFont(new Font("serif",Font.HANGING_BASELINE,17));
		pnl1.add(mode);
		//-------------------------------------checkbox of pnl1
		copies=new JCheckBox("copies");
		copies.setBounds(20, 80, 80, 30);
		copies.setBackground(Color.lightGray);
		pnl1.add(copies);
		copies.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(i==0)
				{
					co.setVisible(true);
					i++;
				}
				else
				{
					co.setVisible(false);
					i=0;
				}
				
			}
		});
		//-------
		geo=new JCheckBox("geometries");
		geo.setBounds(115, 80, 100, 30);
		geo.setBackground(Color.LIGHT_GRAY);
		pnl1.add(geo);
geo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(j==0)
				{
					eo.setVisible(true);
					j++;
				}
				else
				{
					eo.setVisible(false);
					j=0;
				}
				
			}
		});
		//-------
		book=new JCheckBox("Books");
		book.setBounds(225, 80, 80, 30);
		book.setBackground(Color.LIGHT_GRAY);
		pnl1.add(book);
book.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(k==0)
				{
					bo.setVisible(true);
					k++;
				}
				else
				{
					bo.setVisible(false);
					k=0;
				}
				
			}
		});
		//----------------------------
		uni=new JCheckBox("Uniform");
		uni.setBounds(20, 140, 80, 30);
		uni.setBackground(Color.LIGHT_GRAY);
		pnl1.add(uni);
uni.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(l==0)
				{
					un.setVisible(true);
					l++;
				}
				else
				{
					un.setVisible(false);
					l=0;
				}
				
			}
		});
		//-------
		shoes=new JCheckBox("Shoes");
		shoes.setBounds(115, 140, 100, 30);
		shoes.setBackground(Color.LIGHT_GRAY);
		pnl1.add(shoes);
shoes.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(m==0)
				{
					sh.setVisible(true);
					m++;
				}
				else
				{
					sh.setVisible(false);
					m=0;
				}
				
			}
		});
		//-------
		tiffin=new JCheckBox("Tiffin Box");
		tiffin.setBounds(225, 140, 80, 30);
		tiffin.setBackground(Color.LIGHT_GRAY);
		pnl1.add(tiffin);
tiffin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(n==0)
				{
					ti.setVisible(true);
					n++;
				}
				else
				{
					ti.setVisible(false);
					n=0;
				}
				
			}
		});
		//----------------------------
				cycle=new JCheckBox("cycle");
				cycle.setBounds(20, 220, 80, 30);
				cycle.setBackground(Color.LIGHT_GRAY);
				pnl1.add(cycle);
				cycle.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						if(o==0)
						{
							cy.setVisible(true);
							o++;
						}
						else
						{
							cy.setVisible(false);
							o=0;
						}
						
					}
				});
				//-------
				spokit=new JCheckBox("sports kits");
				spokit.setBounds(115, 220, 100, 30);
				spokit.setBackground(Color.LIGHT_GRAY);
				pnl1.add(spokit);
				spokit.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						if(p==0)
						{
							sp.setVisible(true);
							p++;
						}
						else
						{
							sp.setVisible(false);
							p=0;
						}
						
					}
				});
				//-------
				toy=new JCheckBox("Toys");
				toy.setBounds(225, 220, 80, 30);
				toy.setBackground(Color.LIGHT_GRAY);
				pnl1.add(toy);
				toy.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						if(q==0)
						{
							to.setVisible(true);
							q++;
						}
						else
						{
							to.setVisible(false);
							q=0;
						}
						
					}
				});
		//------------------------------------textfield of pnl1
		//JTextField co,eo,bo,un,sh,ti,cy,sp,to;
	    am=new JTextField("0");
		am.setBounds(85, 30,100,30);
		pnl1.add(am);
		//----
		co=new JTextField("0");
		co.setBounds(25, 110,60,20);
		pnl1.add(co);
		co.setVisible(false);
		//----
		eo=new JTextField("0");
		eo.setBounds(120, 110,70,20);
		pnl1.add(eo);
		eo.setVisible(false);
		//----
		bo=new JTextField("0");
		bo.setBounds(230, 110,60,20);
		pnl1.add(bo);
		bo.setVisible(false);
		//------
		un=new JTextField("0");
		un.setBounds(25, 170,60,20);
		pnl1.add(un);
		un.setVisible(false);
		//----
		sh=new JTextField("0");
		sh.setBounds(120, 170,70,20);
		pnl1.add(sh);
		sh.setVisible(false);
		//----
		ti=new JTextField("0");
		ti.setBounds(230, 170,60,20);
		pnl1.add(ti);
		ti.setVisible(false);
		//------
		cy=new JTextField("0");
		cy.setBounds(25, 250,60,20);
		pnl1.add(cy);
		cy.setVisible(false);
		//----
		sp=new JTextField("0");
		sp.setBounds(120, 250,70,20);
		pnl1.add(sp);
		sp.setVisible(false);
		//----
		to=new JTextField("0");
		to.setBounds(230, 250,60,20);
		pnl1.add(to);
		to.setVisible(false);
		//--------------------------------------pnl2
	    pnl2=new JPanel();
	    pnl2.setLayout(null);
		pnl2.setBounds(2,2,397,77);
		pnl2.setBorder(BorderFactory .createLineBorder(Color.cyan));
		pnl2.setBackground(Color.blue);
		add(pnl2);
		//----------pnl2 label
		defination=new JLabel("NGO 's Distribution");
		defination.setFont(new Font("serif",Font.HANGING_BASELINE,30));
		defination.setBounds(110, 5, 250, 60);
		pnl2.add(defination);
		//-----label
		ImageIcon n=new ImageIcon("lo.jpg");
		photo=new JLabel(n);
		photo.setBounds(20, 5, 70, 70);
		pnl2.add(photo);	
		//-------------------------------------button
		  ImageIcon p=new ImageIcon("news.jpg");
		  nwa=new JButton(p);
		  nwa.setBorderPainted(false);
		  nwa.setLocation(20, 450);
		  nwa.setSize(77, 31);
		  pnl.add(nwa);
		  //----
		  ImageIcon q=new ImageIcon("save.jpg");
		  save=new JButton(q);
		  save.setBorderPainted(false);
		  save.setLocation(140, 450);
		  save.setSize(80, 28);
		  pnl.add(save);
		  //----
		  ImageIcon o=new ImageIcon("cancel.jpg");
		  cancel=new JButton(o);
		  cancel.setBorderPainted(false);
		  cancel.setLocation(260, 450);
		  cancel.setSize(80, 27);
		  pnl.add(cancel);
		  //----------action
			save.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
				//	System.out.println("yo yo");
				save();
					System.out.println("hlo kohli");
					
				}
			});
			//---------
			nwa.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg1) {
			      nwa();	
				}
			});
			//----
			cancel.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg5) {
					close();
				}
			});
		//-------------------------------------window
		     setUndecorated(true);
		    getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
			setVisible(true);
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			setSize(410,680);
			 setResizable(false);
			fetchIds();
			//JTextField am,co,eo,bo,un,sh,ti,cy,sp,to;
			am.addFocusListener(new FocusListener()
			{	
				@Override
				public void focusLost(FocusEvent e) 
				{
			     am.setBackground(Color.white);		
				}
				
				@Override
				public void focusGained(FocusEvent e)
				{
				  am.setText("");
				  am.setBackground(Color.LIGHT_GRAY);
				}
			});
			co.addFocusListener(new FocusListener()
			{	
				@Override
				public void focusLost(FocusEvent e) 
				{
			     co.setBackground(Color.white);		
				}
				
				@Override
				public void focusGained(FocusEvent e)
				{
				  co.setText("");
				  co.setBackground(Color.LIGHT_GRAY);
				}
			});
			eo.addFocusListener(new FocusListener()
			{	
				@Override
				public void focusLost(FocusEvent e) 
				{
			     eo.setBackground(Color.white);		
				}
				
				@Override
				public void focusGained(FocusEvent e)
				{
				  eo.setText("");
				  eo.setBackground(Color.LIGHT_GRAY);
				}
			});
			bo.addFocusListener(new FocusListener()
			{	
				@Override
				public void focusLost(FocusEvent e) 
				{
			     bo.setBackground(Color.white);		
				}
				
				@Override
				public void focusGained(FocusEvent e)
				{
				  bo.setText("");
				  bo.setBackground(Color.LIGHT_GRAY);
				}
			});
			un.addFocusListener(new FocusListener()
			{	
				@Override
				public void focusLost(FocusEvent e) 
				{
			     un.setBackground(Color.white);		
				}
				
				@Override
				public void focusGained(FocusEvent e)
				{
				  un.setText("");
				  un.setBackground(Color.LIGHT_GRAY);
				}
			});
			sh.addFocusListener(new FocusListener()
			{	
				@Override
				public void focusLost(FocusEvent e) 
				{
			     sh.setBackground(Color.white);		
				}
				
				@Override
				public void focusGained(FocusEvent e)
				{
				  sh.setText("");
				  sh.setBackground(Color.LIGHT_GRAY);
				}
			});
			ti.addFocusListener(new FocusListener()
			{	
				@Override
				public void focusLost(FocusEvent e) 
				{
			     ti.setBackground(Color.white);		
				}
				
				@Override
				public void focusGained(FocusEvent e)
				{
				  ti.setText("");
				  ti.setBackground(Color.LIGHT_GRAY);
				}
			});
			cy.addFocusListener(new FocusListener()
			{	
				@Override
				public void focusLost(FocusEvent e) 
				{
			     cy.setBackground(Color.white);		
				}
				
				@Override
				public void focusGained(FocusEvent e)
				{
				  cy.setText("");
				  cy.setBackground(Color.LIGHT_GRAY);
				}
			});
			sp.addFocusListener(new FocusListener()
			{	
				@Override
				public void focusLost(FocusEvent e) 
				{
			     sp.setBackground(Color.white);		
				}
				
				@Override
				public void focusGained(FocusEvent e)
				{
				  sp.setText("");
				  sp.setBackground(Color.LIGHT_GRAY);
				}
			});
			to.addFocusListener(new FocusListener()
			{	
				@Override
				public void focusLost(FocusEvent e) 
				{
			     to.setBackground(Color.white);		
				}
				
				@Override
				public void focusGained(FocusEvent e)
				{
				  to.setText("");
				  to.setBackground(Color.LIGHT_GRAY);
				}
			});
	}
	//---
	 void save()
	  {
		 //JOptionPane.showMessageDialog(null, am.getText());
		  try
		  {
			  //JTextField di,na,mn;
			//	JTextField ca,ga,ba,aa,bb,cc,dd,ee,ff,gg,hh,ii,jj;
			  //"insert into detail(usernsme,pwd,mobileno) values(?,?,?)")
       
			  pst=con.prepareStatement("insert into NGO_Distributions(School_Name,Date,Amount,Mode,Copy,Geometry,Book,Uniform,Shoes,Tiffin_Box,Cycle,Sports_Kits,Toyes) values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
			  if(c_school.getSelectedItem().toString().equals("Select")!=true)
		         {
			  pst.setString(1,c_school.getSelectedItem().toString());
			  System.out.println("u enter");
		         }
			  /*pst.setString(2,c_date.getSelectedItem().toString());
			  pst.setString(3,c_month.getSelectedItem().toString());
			  pst.setString(4,c_year.getSelectedItem().toString());*/
			     String s=c_year.getSelectedItem()+"-"+c_month.getSelectedItem()+"-"+c_date.getSelectedItem() ;
				
				 DateFormat format=new SimpleDateFormat("yyyy-MM-dd");
				 java.util.Date javawalli =format.parse(s);
				 java.sql.Date sqlwallidate=new Date(javawalli.getTime());
		      pst.setDate(2,sqlwallidate);
			  pst.setInt(3, Integer.parseInt(am.getText()));
			  pst.setString(4,c_mode.getSelectedItem().toString());
			  pst.setInt(5,Integer.parseInt(co.getText()));
			  pst.setInt(6,Integer.parseInt(eo.getText()));
			  pst.setInt(7,Integer.parseInt(bo.getText()));
			  pst.setInt(8,Integer.parseInt(un.getText()));
			  pst.setInt(9,Integer.parseInt(sh.getText()));
			  pst.setInt(10,Integer.parseInt(ti.getText()));
			  pst.setInt(11,Integer.parseInt(cy.getText()));
			  pst.setInt(12, Integer.parseInt(sp.getText()));
			  pst.setInt(13, Integer.parseInt(to.getText()));
			 
			  int x=pst.executeUpdate();
			  JOptionPane.showMessageDialog(null, "save "+x+" data");
			  pst.close();
		  }
		  catch(Exception gg)
		  {
			 JOptionPane.showMessageDialog(null,"Enter correct Field");
		  }
	  }
	//-----
	  void nwa()
	  {
		  try
		  {
			  c_date.setSelectedItem("d");
			  am.setText("");
			  co.setText("");
			  eo.setText("");
			  bo.setText("");
			  un.setText("");
			  sh.setText("");
			  ti.setText("");
			  cy.setText("");
			  sp.setText("");
			  to.setText("");
			  JOptionPane.showMessageDialog(null, "new apply");
		  }
		  catch(Exception tt)
		  {
			  tt.printStackTrace();
		  }
	  }
	  //----
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
	  void fetchIds()
	  {
		  //d.removeAllItems();
		  c_school.addItem("Select");
		  try
		  {System.out.println("hello");
		  pst=con.prepareStatement("select namm from schoolregistration");

		  ResultSet rs=pst.executeQuery();
		  while(rs.next())
		     {
			  String mk=rs.getString("namm");
			  c_school.addItem(mk);
		     }
		  }
		  catch(Exception emn)
		  {
			  String a=emn.getMessage();
			  JOptionPane.showMessageDialog(null, a);
		  }
	  }
	  
}
public class NGO_Distributions 
{
	public static void main(String[] args)
	{
		win4 w=new win4();
	}

}
