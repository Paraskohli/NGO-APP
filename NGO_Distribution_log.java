import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

class dist extends JFrame implements papaclass
{
	JPanel pnl,pnl1;
	JLabel l,s,a,an;
	JComboBox co;
	JTextField aml;
	JButton fe,fet;
	Connection con;
	PreparedStatement pst,ps;
	dist()
	{
		con=Connectfi.getconnect();
		setLayout(null);
		//----------------------pnl1
		pnl=new JPanel();
		pnl.setLayout(null);
		pnl.setBackground(Color.lightGray);
		pnl.setBounds(18, 15, 450, 520);
		add(pnl);
		//----
		pnl1=new JPanel();
		pnl1.setLayout(null);
		pnl1.setBackground(Color.white);
		pnl1.setBounds(25, 220, 400, 250);
		pnl.add(pnl1);
		//--------label
		l=new JLabel("Donation 's Log");
		l.setBounds(145,20,190,40);
		l.setFont(new Font("serif",Font.BOLD,25));
		pnl.add(l);
		//--------
		s=new JLabel("School");
		s.setBounds(60,70,100,40);
		s.setFont(new Font("serif",Font.HANGING_BASELINE,18));
		pnl.add(s);
		//--------
		a=new JLabel("Amount >=");
		a.setBounds(45,120,130,40);
		a.setFont(new Font("serif",Font.HANGING_BASELINE,18));
		pnl.add(a);
/*		//------
		an=new JLabel("and");
		an.setBounds(240,120,50,40);
		an.setFont(new Font("serif",Font.HANGING_BASELINE,18));
		pnl.add(an);*/
		//-------- combobox
		co=new JComboBox();
		co.setBounds(150, 70, 210, 30);
		pnl.add(co);
		//---------textfield
		aml=new JTextField("0");
		aml.setBounds(150, 125, 150, 30);
		pnl.add(aml);
		//-----
		/*amh=new JTextField();
		amh.setBounds(280, 125, 80, 30);
		pnl.add(amh);*/
		//----------------->button
		ImageIcon y=new ImageIcon("fet.jpg");
		fe=new JButton(y);
		fe.setBounds(370, 70, 60, 40);
		fe.setBorderPainted(false);
		pnl.add(fe);
		fe.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
			   fetc();	
			}
		});
		//---------
		ImageIcon ya=new ImageIcon("few.jpg");
		fet=new JButton(ya);
		fet.setBounds(370, 125, 70, 30);
		pnl.add(fet);
		fe.setBorderPainted(false);
        fet.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
			   fetcc();	
			}
		});
		//-------------------------window
       
 		
		 setUndecorated(true);
		setSize(500,600);
	//	setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setResizable(false);
		   getRootPane().setWindowDecorationStyle(JRootPane.FRAME);
		   setVisible(true);
		fetchid();
		//----------------
		aml.addFocusListener(new FocusListener() {
			
			@Override
			public void focusLost(FocusEvent e) {
				// TODO Auto-generated method stub
				aml.setBackground(Color.white);
			}
			
			@Override
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				aml.setText("");
				aml.setBackground(Color.LIGHT_GRAY);
			}
		});
		
	}
	void fetchid()
	{
		  co.addItem("Select School");
		  try
	{
		  pst=con.prepareStatement("select distinct School_Name from NGO_Distributions");

		  ResultSet rs=pst.executeQuery();
		  while(rs.next())
		     {
			  String me=rs.getString("School_Name");
			  co.addItem(me);
			  //JOptionPane.showMessageDialog(null,idd+"" );
		     }
		  }
		  catch(Exception emn)
		  {
			  String a=emn.getMessage();
			  JOptionPane.showMessageDialog(null, a);
		  }
	}
	void fetc()
	{
		try
		{
		//	con=ConnectionToMysql.getconnection();
	        pst=con.prepareStatement("select * from NGO_Distributions where School_Name=?");
	        pst.setString(1,co.getSelectedItem().toString());
	        ResultSet rs=pst.executeQuery();
	        java.sql.ResultSetMetaData md=rs.getMetaData();
	        Vector<String> columnNames=new Vector<String>();
	        int columns=md.getColumnCount();
	        System.out.println(columns);
	        for(int i=1;i<=columns;i++)
	        {
	        	columnNames.addElement(md.getColumnName(i));
	        }
	        //-----------------------------
	        Vector<Object> data=new Vector<Object>();
	        if(rs.next())
	        {
	        	Vector<Object> row=new Vector<Object>(columns);
	        for(int i=1;i<=columns;i++)
	        {
	        	row.addElement(rs.getObject(i));
	        	
	        }data.addElement(row);
	        
	        //rs.close();
	        //pst.close();
	        JTable tables=new JTable(data, columnNames);
	        JScrollPane scrollpane=new JScrollPane(tables);
	        tables.setBackground(Color.yellow);
	        tables.setSelectionBackground(Color.red);
	        tables.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
	        scrollpane.setBounds(70, 240, 350, 240);
	        add(scrollpane);
	        }
		}
		catch(Exception r)
		{
			r.printStackTrace();
			String nn=r.getMessage();
			JOptionPane.showMessageDialog(null, nn);
		}
	}
	void fetcc()//------------------------->amount
	{
		try
		{
			//con=ConnectionToMysql.getconnection();
	        pst=con.prepareStatement("select * from NGO_Distributions where Amount>=?");
	        pst.setString(1,aml.getText());
	        ResultSet rs=pst.executeQuery();
	        java.sql.ResultSetMetaData md=rs.getMetaData();
	        Vector<String> columnNames=new Vector<String>();
	        int columns=md.getColumnCount();
	        for(int i=1;i<=columns;i++)
	        {
	        	columnNames.addElement(md.getColumnName(i));
	        }
	        //-----------------------------
	        Vector<Object> data=new Vector<Object>();
	        if(rs.next())
	        {
	        	Vector<Object> row=new Vector<Object>(columns);
	        for(int i=1;i<=columns;i++)
	        {
	        	row.addElement(rs.getObject(i));
	        	
	        }
	        data.addElement(row);
	        //rs.close();
	        //pst.close();
	        JTable tables=new JTable(data, columnNames);
	        JScrollPane scrollpane=new JScrollPane(tables);
	        tables.setBackground(Color.yellow);
	        tables.setSelectionBackground(Color.red);
	        tables.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
	        scrollpane.setBounds(70, 240, 350, 240);
	        add(scrollpane);
	        }
		}
		catch(Exception r)
		{
			r.printStackTrace();
			String nn=r.getMessage();
			JOptionPane.showMessageDialog(null, nn);
		}
	}
}

public class NGO_Distribution_log 
{
	public static void main(String[] args)
	{
		new dist();
	}

}
