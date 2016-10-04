import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JTextField;

class pro extends JFrame implements papaclass
{
	JPanel pnl,pnl2;
	JLabel sr,nos,add,c,noh,cd,s,req;
	JTextField adda,ca,noha,cda,sa,reqa;
	JComboBox nosa;
	JButton save,ne,close;
	Connection con;
	PreparedStatement pst;
	String gd;
     pro()
   {
    	 con=Connectfi.getconnect();
      //-----------------------------                     <------------panel
      pnl=new JPanel();
      pnl.setLayout(null);
      pnl.setBounds(10, 10, 330, 70);
      pnl.setBackground(Color.darkGray);
      pnl.setBorder(BorderFactory.createLineBorder(Color.CYAN));
      add(pnl);
      //-----------------------------                     <------------label
      sr=new JLabel("School Registration Form");
      sr.setBounds(30, 13, 300, 40);
      sr.setForeground(Color.white);
      sr.setFont(new Font("serif",Font.CENTER_BASELINE,24));
      pnl.add(sr);
      //-----------------------------                     <---------------penal2
      pnl2=new JPanel();
      pnl2.setLayout(null);
      pnl2.setBounds(15, 85, 320, 500);
      pnl2.setBackground(Color.LIGHT_GRAY);
      pnl2.setBorder(BorderFactory.createLineBorder(Color.CYAN));
      add(pnl2);
      //-----------------------------                     <------------Down label
      nos=new JLabel("Name of School*");
      nos.setBounds(10, 13, 150, 40);
      nos.setForeground(Color.white);
      nos.setFont(new Font("serif",Font.CENTER_BASELINE,18));
      pnl2.add(nos);
      //-----------------------------                     <------------Down label
      add=new JLabel("Address*");
      add.setBounds(10, 73, 70, 40);
      add.setForeground(Color.black);
      add.setFont(new Font("serif",Font.CENTER_BASELINE,14));
      pnl2.add(add);
      //-----------------------------                     <------------Down label
      c=new JLabel("City*");
      c.setBounds(10, 140, 70, 40);
      c.setForeground(Color.black);
      c.setFont(new Font("serif",Font.CENTER_BASELINE,14));
      pnl2.add(c);
      //-----------------------------                     <------------Down label
      noh=new JLabel("Name of Head*");
      noh.setBounds(10, 200, 120, 40);
      noh.setForeground(Color.black);
      noh.setFont(new Font("serif",Font.CENTER_BASELINE,14));
      pnl2.add(noh);
      //-----------------------------                     <------------Down label
      cd=new JLabel("Contect Detail*");
      cd.setBounds(10, 260, 120, 40);
      cd.setForeground(Color.black);
      cd.setFont(new Font("serif",Font.CENTER_BASELINE,14));
      pnl2.add(cd);
      //-----------------------------                     <------------Down label
      s=new JLabel("Strenght");
      s.setBounds(10, 315, 120, 40);
      s.setForeground(Color.black);
      s.setFont(new Font("serif",Font.CENTER_BASELINE,14));
      pnl2.add(s);
      //-----------------------------                     <------------Down label
      req=new JLabel("Requirment*");
      req.setBounds(10, 373, 120, 40);
      req.setForeground(Color.black);
      req.setFont(new Font("serif",Font.CENTER_BASELINE,14));
      pnl2.add(req);
      //-------------            <--------------combobox
      nosa=new JComboBox();
      nosa.setEditable(true);
      nosa.setBounds(150, 17, 150, 30);
      pnl2.add(nosa);
       //gd=nosa.getSelectedItem().toString();//--------------------------------------->error
      //nosa.addItem(gd);
      //-----------               <-------------textfeild
      adda=new JTextField();
      adda.setBounds(115, 85, 180, 30);
      adda.setForeground(Color.CYAN);
      pnl2.add(adda);
      //-----------
      ca=new JTextField();
      ca.setBounds(115, 150, 180, 30);
      ca.setForeground(Color.CYAN);
      pnl2.add(ca);
      //-----------
      noha=new JTextField();
      noha.setBounds(115, 210, 180, 30);
      noha.setForeground(Color.CYAN);
      pnl2.add(noha);
      //-----------
      cda=new JTextField();
      cda.setBounds(115, 270, 180, 30);
      cda.setForeground(Color.CYAN);
      pnl2.add(cda);
      //-----------
      sa=new JTextField();
      sa.setBounds(115, 322, 180, 30);
      sa.setForeground(Color.CYAN);
      pnl2.add(sa);
      //-----------
      reqa=new JTextField();
      reqa.setBounds(115, 382, 180, 30);
      reqa.setForeground(Color.CYAN);
      pnl2.add(reqa);
      //----------------------                 <-----------button
      save=new JButton("Save");
      save.setLocation(20,440);
      save.setSize(80,30);
      pnl2.add(save);
      //-------------
      ne=new JButton("New");
      ne.setLocation(120,440);
      ne.setSize(80,30);
      pnl2.add(ne);
      //-------------
      close=new JButton("Close");
      close.setLocation(220,440);
      close.setSize(80,30);
      pnl2.add(close);
      //------------------------------------           <--------action listner
     nosa.addActionListener(new ActionListener() {

    	  @Override
    	  public void actionPerformed(ActionEvent arg0) {
    	      
    	  	//JOptionPane.showInputDialog(null,"Enter the Donar ID");
    	  	fetch();
    	  	//JOptionPane.showMessageDialog(null, "hiii this is fetch");
    	  }
    	  });	
      //------
      save.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
		save();	   
			JOptionPane.showMessageDialog(null, "hi this is save");
			 dispose();
			 pro h=new pro();
			 }
	});
      //------------
      ne.addActionListener(new ActionListener() {
  		
  		@Override
  		public void actionPerformed(ActionEvent arg0) {
  		nwa();	   
  		}
  	});
      //------------
      close.addActionListener(new ActionListener() {
  		
  		@Override
  		public void actionPerformed(ActionEvent arg0) {
  		     close();	   
  			
  		}
  	});
      
      //--------                   <----------------------window
      setLayout(null);
      setUndecorated(true);
      getRootPane().setWindowDecorationStyle(JRootPane.FRAME); 
      setSize(360,650);
      setVisible(true);
      setResizable(false);
      fetchid();
      setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
   }
     void close()
     {
    	 try
    	 {
         JOptionPane.showMessageDialog(null, "hi this is close");
         System.exit(0);
    	 }
    	 catch(Exception e)
    	 {
    		 String a=e.getMessage();
    		 JOptionPane.showConfirmDialog(null, a);
    	 }
     }
     void nwa()
     {
    	 try
		  {
    		 nosa.setSelectedIndex(0);
			  adda.setText("");
			  ca.setText("");
			  noha.setText("");
			  cda.setText("");
			  sa.setText("");
			  reqa.setText("");
			  JOptionPane.showMessageDialog(null, "new apply");
		  }
		  catch(Exception tt)
		  {
			  tt.printStackTrace();
		  }	 
     }
     void save()
     {//adda,ca,noha,cda,sa,reqa;
    	 if(nosa.getSelectedItem().equals("")||adda.getText().equals("")||ca.getText().equals("")||
    			 noha.getText().equals("")|| cda.getText().equals("")||reqa.getText().equals(""))
    	 {
    		JOptionPane.showMessageDialog(null,"Fill All * Fields"); 
    	 }
    	 else{
    	 try
    	 {
    	pst= con.prepareStatement("insert into SchoolRegistration(namm,ad,ci,noh,con,st,re) values(?,?,?,?,?,?,?)");
    	pst.setString(1,nosa.getSelectedItem().toString());
    	pst.setString(2,adda.getText());
    	pst.setString(3,ca.getText());
    	pst.setString(4,noha.getText());
    	pst.setString(5, cda.getText());
    	pst.setString(6, sa.getText());
    	pst.setString(7,reqa.getText());
    	int x=pst.executeUpdate();
    	JOptionPane.showMessageDialog(null,"saved"+x);
    	}
    	 catch(Exception kk)
    	 {
    		 kk.printStackTrace();
    	 }
    	 }
     }
     void fetchid()
     {
    	 
    	  //d.removeAllItems();
		  nosa.addItem("");
		  try
		  {
		  pst=con.prepareStatement("select distinct namm from SchoolRegistration ");

		  ResultSet rs=pst.executeQuery();
		  while(rs.next())
		     {
			  String idd=rs.getString("namm");
			  nosa.addItem(idd+"");
			  //JOptionPane.showMessageDialog(null,idd+"" );
		     }
		  }
		  catch(Exception m)
		  {
			  m.printStackTrace();
		  }
     }
     //-----------
     void fetch()
	  {
		  try
		  {
			  //JOptionPane.showMessageDialog(null, "hiiii Mr kohli");
			  //SchoolRegistration(namm,ad,ci,noh,con,st,re)
		  int jasus=1;
		  String add="",city="",nameofhead="",contect="",stre="",req="";
		  pst=con.prepareStatement("select ad,ci,noh,con,st,re from SchoolRegistration where namm=?");
		  pst.setString(1,nosa.getSelectedItem().toString());
		  ResultSet rs=pst.executeQuery();
		  if(rs.next())
		     {
			  jasus=1;
			  add=rs.getString("ad");
			  city=rs.getString("ci");
			  nameofhead=rs.getString("noh");
			  contect=rs.getString("con");
			  stre=rs.getString("st");
			  req=rs.getString("re");
			  System.out.print("hi paras");
		     }
		  else
		  {
			  jasus=0;
		  }
		  if(jasus==1)
		  {
			 
			  adda.setText(add);
			  ca.setText(city);
			  noha.setText(nameofhead);
			  cda.setText(contect);
			  sa.setText(stre);
			  reqa.setText(req);
			  
		  }
		  
		  }
		  catch(Exception emn)
		  {
			  String a=emn.getMessage();
			  JOptionPane.showMessageDialog(null, a);
		  }
	  }
}
public class SchoolRegistration {


	public static void main(String[] args) {
		
		 pro p=new pro();
	}

}
