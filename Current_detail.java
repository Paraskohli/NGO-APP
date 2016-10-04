import java.awt.Color;
import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.border.Border;

class detail extends JFrame implements papaclass
{
	 JPanel pnl;
	 JLabel cd,Amount,copy,geo,book,uni,sh,tiff,cyc,spo,toy;
	 JLabel Amounta,copya,geoa,booka,unia,sha,tiffa,cyca,spoa,toya;
	 String a;
	 Connection con;
	 PreparedStatement pst,ps;
	 Border bdr;
	 public static int aaaa,bbbb,cccc,dddd,eeee,ffff,gggg,hhhh,iiii,jjjj;
	 int aaa=0,bbb=0,ccc=0,ddd=0,eee=0,fff=0,ggg=0,hhh=0,iii=0,jjj=0
			 ,kkk=0,lll=0,mmm=0,nnn=0,ooo=0,ppp=0,qqq=0,rrr=0,sss=0,ttt=0;
     detail()
     {
    		bdr=BorderFactory.createLineBorder(Color.gray,2,true);
    	 con=Connectfi.getconnect();
    	 setLayout(null);
    	 cd =new JLabel("Current Details");
    	 cd.setForeground(Color.DARK_GRAY);
         cd.setBounds(120, 20, 200, 50);
         cd.setFont(new Font("serif",Font.PLAIN,25));
         add(cd);
         //-------------
         
    	 Amount =new JLabel("Amount   -----------------");
         Amount.setBounds(20, 70, 350, 40);
         Amount.setFont(new Font("serif",Font.BOLD,25));
         add(Amount);
         //==2
   	  try
	  {
	  pst=con.prepareStatement("select Amount from donardonation");
      ps=con.prepareStatement("select Amount from NGO_Distributions");
	  ResultSet rs=pst.executeQuery();
	  ResultSet ts=ps.executeQuery();
	  while(rs.next())
	     {
		  int idd=rs.getInt("Amount");
		  aaa=aaa+idd;
	     }
	  while(ts.next())
	     {
		  int ida=ts.getInt("Amount");
		  bbb=bbb+ida;
	     }
	  }
	  catch(Exception emn)
	  {
		  String a=emn.getMessage();
		  JOptionPane.showMessageDialog(null, a);
		  emn.printStackTrace();
		  
	  }
   	    aaaa=aaa-bbb;
       String aas=String.valueOf(aaaa);
         Amounta=new JLabel(aas);
         Amounta.setBounds(260, 75, 140, 20);
         Amounta.setFont(new Font("serif",Font.BOLD,25));
         add(Amounta);
         //-------------
    	 copy =new JLabel("Copy        -----------------");
         copy.setBounds(20, 120, 350, 30);
         copy.setFont(new Font("serif",Font.HANGING_BASELINE,25));
         add(copy);
         //==2
   	  try
   	  {
   	  pst=con.prepareStatement("select Copy from donardonation");
      ps=con.prepareStatement("select Copy from NGO_Distributions");
   	  ResultSet rs=pst.executeQuery();
   	  ResultSet ts=ps.executeQuery();
   	  while(rs.next())
   	     {
   		  int idb=rs.getInt("Copy");
   		  ccc=ccc+idb;
   	     }
   	  while(ts.next())
   	     {
   		  int idc=ts.getInt("Copy");
   		  ddd=ddd+idc;
   	     }
   	  }
   	  catch(Exception emn)
   	  {
   		  String a=emn.getMessage();
   		  JOptionPane.showMessageDialog(null, a);
   		  
   	  }
      	    bbbb=ccc-ddd;
          String aam=String.valueOf(bbbb);
         copya=new JLabel(aam);
         copya.setBounds(290, 125, 80, 20);
         copya.setFont(new Font("serif",Font.BOLD,25));
         add(copya);
         //-------------
    	 geo =new JLabel("Geometry-----------------");
         geo.setBounds(20, 170, 350, 30);
         geo.setFont(new Font("serif",Font.HANGING_BASELINE,25));
         add(geo);
         //==2
   	  try
   	  {
   	  pst=con.prepareStatement("select Geometry from donardonation");
         ps=con.prepareStatement("select Geometry from NGO_Distributions");
   	  ResultSet rs=pst.executeQuery();
   	  ResultSet ts=ps.executeQuery();
   	  while(rs.next())
   	     {
   		  int idd=rs.getInt("Geometry");
   		  eee=eee+idd;
   	     }
   	  while(ts.next())
   	     {
   		  int ida=ts.getInt("Geometry");
   		  fff=fff+ida;
   	     }
   	  }
   	  catch(Exception emn)
   	  {
   		  String a=emn.getMessage();
   		  JOptionPane.showMessageDialog(null, a);
   		  
   	  }
      	    cccc=eee-fff;
          String aak=String.valueOf(cccc);
         geoa=new JLabel(aak);
         geoa.setBounds(290, 175, 70, 20);
         geoa.setFont(new Font("serif",Font.BOLD,25));
         add(geoa);
         //-------------
    	 book =new JLabel("Book       ------------------");
         book.setBounds(20, 220, 350, 30);
         book.setFont(new Font("serif",Font.HANGING_BASELINE,25));
         add(book);
         //==2
   	  try
   	  {
   	  pst=con.prepareStatement("select Book from donardonation");
         ps=con.prepareStatement("select Book from NGO_Distributions");
   	  ResultSet rs=pst.executeQuery();
   	  ResultSet ts=ps.executeQuery();
   	  while(rs.next())
   	     {
   		  int idd=rs.getInt("Book");
   		  ggg=ggg+idd;
   	     }
   	  while(ts.next())
   	     {
   		  int ida=ts.getInt("Book");
   		  hhh=hhh+ida;
   	     }
   	  }
   	  catch(Exception emn)
   	  {
   		  String aa=emn.getMessage();
   		  JOptionPane.showMessageDialog(null, a);
   		  
   	  }
      	    dddd=ggg-hhh;
          String aal=String.valueOf(dddd);
         booka=new JLabel(aal);
         booka.setBounds(290, 225, 80, 20);
         booka.setFont(new Font("serif",Font.BOLD,25));
         add(booka);
         //-------------
    	 uni =new JLabel("Uniform  -----------------");
         uni.setBounds(20, 270, 350, 30);
         uni.setFont(new Font("serif",Font.HANGING_BASELINE,25));
         add(uni);
         //==2
   	  try
   	  {
   	  pst=con.prepareStatement("select Uniform from donardonation");
         ps=con.prepareStatement("select Uniform from NGO_Distributions");
   	  ResultSet rs=pst.executeQuery();
   	  ResultSet ts=ps.executeQuery();
   	  while(rs.next())
   	     {
   		  int idd=rs.getInt("Uniform");
   		  iii=iii+idd;
   	     }
   	  while(ts.next())
   	     {
   		  int ida=ts.getInt("Uniform");
   		  jjj=jjj+ida;
   	     }
   	  }
   	  catch(Exception emn)
   	  {
   		  String a=emn.getMessage();
   		  JOptionPane.showMessageDialog(null, a);
   		  
   	  }
      	    eeee=iii-jjj;
          String aap=String.valueOf(eeee);
         unia=new JLabel(aap);
         unia.setBounds(290, 275, 80, 20);
         unia.setFont(new Font("serif",Font.BOLD,25));
         add(unia);
         //-------------
    	 sh =new JLabel("shoes       -----------------");
         sh.setBounds(20, 320, 350, 30);
         sh.setFont(new Font("serif",Font.HANGING_BASELINE,25));
         add(sh);
         //==2
   	  try
   	  {
   	  pst=con.prepareStatement("select Shoes from donardonation");
         ps=con.prepareStatement("select Shoes from NGO_Distributions");
   	  ResultSet rs=pst.executeQuery();
   	  ResultSet ts=ps.executeQuery();
   	  while(rs.next())
   	     {
   		  int idd=rs.getInt("Shoes");
   		  kkk=kkk+idd;
   	     }
   	  while(ts.next())
   	     {
   		  int ida=ts.getInt("Shoes");
   		  lll=lll+ida;
   	     }
   	  }
   	  catch(Exception emn)
   	  {
   		  String a=emn.getMessage();
   		  JOptionPane.showMessageDialog(null, a);
   		  
   	  }
      	    ffff=kkk-lll;
          String aat=String.valueOf(ffff);
         sha=new JLabel(aat);
         sha.setBounds(290, 325, 80, 20);
         sha.setFont(new Font("serif",Font.BOLD,25));
         add(sha);
         //-------------
    	 tiff =new JLabel("Tiffin Box ----------------");
         tiff.setBounds(20, 370, 350, 30);
         tiff.setFont(new Font("serif",Font.HANGING_BASELINE,25));
         add(tiff);
         //==2
   	  try
   	  {
   	  pst=con.prepareStatement("select Tiffin_Box from donardonation");
         ps=con.prepareStatement("select Tiffin_Box from NGO_Distributions");
   	  ResultSet rs=pst.executeQuery();
   	  ResultSet ts=ps.executeQuery();
   	  while(rs.next())
   	     {
   		  int idd=rs.getInt("Tiffin_Box");
   		  mmm=mmm+idd;
   	     }
   	  while(ts.next())
   	     {
   		  int ida=ts.getInt("Tiffin_Box");
   		  nnn=nnn+ida;
   	     }
   	  }
   	  catch(Exception emn)
   	  {
   		  String a=emn.getMessage();
   		  JOptionPane.showMessageDialog(null, a);
   		  
   	  }
      	    gggg=mmm-nnn;
          String aan=String.valueOf(gggg);
         tiffa=new JLabel(aan);
         tiffa.setBounds(290, 375, 80, 20);
         tiffa.setFont(new Font("serif",Font.BOLD,25));
         add(tiffa);
         //-------------
    	 cyc =new JLabel("cycle         -----------------");
         cyc.setBounds(20, 420, 350, 30);
         cyc.setFont(new Font("serif",Font.HANGING_BASELINE,25));
         add(cyc);
         //==2
   	  try
   	  {
   	  pst=con.prepareStatement("select Cycle from donardonation");
         ps=con.prepareStatement("select Cycle from NGO_Distributions");
   	  ResultSet rs=pst.executeQuery();
   	  ResultSet ts=ps.executeQuery();
   	  while(rs.next())
   	     {
   		  int idd=rs.getInt("Cycle");
   		  ooo=ooo+idd;
   	     }
   	  while(ts.next())
   	     {
   		  int ida=ts.getInt("Cycle");
   		  ppp=ppp+ida;
   	     }
   	  }
   	  catch(Exception emn)
   	  {
   		  String a=emn.getMessage();
   		  JOptionPane.showMessageDialog(null, a);
   		  
   	  }
      	    hhhh=ooo-ppp;
          String aao=String.valueOf(hhhh);
         cyca=new JLabel(aao);
         cyca.setBounds(290, 425, 80, 20);
         cyca.setFont(new Font("serif",Font.BOLD,25));
         add(cyca);
         //-------------
    	 spo =new JLabel("Sports Kit ----------------");
         spo.setBounds(20, 470, 350, 30);
         spo.setFont(new Font("serif",Font.HANGING_BASELINE,25));
         add(spo);
         //==2
   	  try
   	  {
   	  pst=con.prepareStatement("select Sports_kit from donardonation");
         ps=con.prepareStatement("select Sports_Kits from NGO_Distributions");
   	  ResultSet rs=pst.executeQuery();
   	  ResultSet ts=ps.executeQuery();
   	  while(rs.next())
   	     {
   		  int idd=rs.getInt("Sports_kit");
   		  qqq=qqq+idd;
   	     }
   	  while(ts.next())
   	     {
   		  int ida=ts.getInt("Sports_Kits");
   		  rrr=rrr+ida;
   	     }
   	  }
   	  catch(Exception emn)
   	  {
   		  String a=emn.getMessage();
   		  JOptionPane.showMessageDialog(null, a);
   		  
   	  }
      	    iiii=qqq-rrr;
          String aaq=String.valueOf(iiii);
         spoa=new JLabel(aaq);
         spoa.setBounds(290, 475, 80, 20);
         spoa.setFont(new Font("serif",Font.BOLD,25));
         add(spoa);
         //-------------
    	 toy =new JLabel("Toy            ----------------");
         toy.setBounds(20, 520, 350, 30);
         toy.setFont(new Font("serif",Font.HANGING_BASELINE,25));
         add(toy);
         //==2
   	  try
   	  {
   	  pst=con.prepareStatement("select Toy from donardonation");
         ps=con.prepareStatement("select Toyes from NGO_Distributions");
   	  ResultSet rs=pst.executeQuery();
   	  ResultSet ts=ps.executeQuery();
   	  while(rs.next())
   	     {
   		  int idd=rs.getInt("Toy");
   		  sss=sss+idd;
   	     }
   	  while(ts.next())
   	     {
   		  int ida=ts.getInt("Toyes");
   		  ttt=ttt+ida;
   	     }
   	  }
   	  catch(Exception emn)
   	  {
   		  String a=emn.getMessage();
   		  JOptionPane.showMessageDialog(null, a);
   		  
   	  }
      	    jjjj=sss-ttt;
          String aaz=String.valueOf(jjjj);
         toya=new JLabel(aaz);
         toya.setBounds(290, 525, 80, 20);
         toya.setFont(new Font("serif",Font.BOLD,25));
         add(toya);
         
    	 //---------------------         <===========panel
         pnl=new JPanel();
         pnl.setLayout(null);
         pnl.setBounds(10, 20, 370, 570);
         pnl.setBackground(Color.LIGHT_GRAY);
         pnl.setBorder(bdr);
         add(pnl);
    	 //------------------            <==========window
    	 
    	 setUndecorated(true);
    	 getRootPane().setWindowDecorationStyle(JRootPane.FRAME );    	 
    	 setVisible(true);
    	 setSize(400,640);
    	 setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    	setResizable(false);
    	 
     }
     
}
public class Current_detail 
{
	public static void main(String[] args) 
	{
		  detail d=new detail();
	}

}
