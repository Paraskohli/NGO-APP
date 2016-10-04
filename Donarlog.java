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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

class doa extends JFrame implements papaclass
{
	JPanel pnl,pnl1;
	JLabel l,s,a,an;
	JComboBox co;
	JTextField aml;
	JButton fe,fet;
	Connection con;
	PreparedStatement pst;
	doa()
	{
		
		con=Connectfi.getconnect();
			setLayout(null);
			//----------------------pnl1
			pnl=new JPanel();
			pnl.setLayout(null);
			pnl.setBackground(Color.LIGHT_GRAY);
			pnl.setBounds(18, 15, 450, 520);
			add(pnl);
			//----
			pnl1=new JPanel();
			pnl1.setLayout(null);
			pnl1.setBackground(Color.white);
			pnl1.setBounds(25, 220, 400, 250);
			pnl.add(pnl1);
			//--------label
			l=new JLabel("Donar's Log");
			l.setBounds(145,20,190,40);
			l.setFont(new Font("serif",Font.BOLD,25));
			pnl.add(l);
			//--------
			s=new JLabel("Donar ID");
			s.setBounds(60,70,100,40);
			s.setFont(new Font("serif",Font.HANGING_BASELINE,18));
			pnl.add(s);
			//--------
			a=new JLabel("Amount >=");
			a.setBounds(60,120,130,40);
			a.setFont(new Font("serif",Font.HANGING_BASELINE,18));
			pnl.add(a);
			//------
			/*an=new JLabel("and");
			an.setBounds(240,120,50,40);
			an.setFont(new Font("serif",Font.HANGING_BASELINE,18));
			pnl.add(an);*/
			//-------- combobox
			co=new JComboBox();
			co.setBounds(150, 70, 150, 30);
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
			ImageIcon few=new ImageIcon("fet.jpg");
			fe=new JButton(few);
			fe.setBounds(340, 63, 70, 40);
			fe.setBorderPainted(false);
			pnl.add(fe);
			fe.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					
				   fetc();	
				}
			});
			//---------
			ImageIcon fee=new ImageIcon("few.jpg");
			fet=new JButton(fee);
			fet.setBounds(340, 121, 70, 30);
			fet.setBorderPainted(false);
			pnl.add(fet);
	         fet.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent arg0) {
				   fetcc();	
				}
			});
			
			//-------------------------window
	        
			setVisible(true);
			setSize(500,600);
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			fetchid();
			setResizable(false);
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
		  co.addItem("Select donarID");
		  try
	      {
		  pst=con.prepareStatement("select  Donar_ID from donardonation");

		  ResultSet rs=pst.executeQuery();
		  while(rs.next())
		     {
			  int me=rs.getInt("Donar_ID");
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
	void fetcc()//-------------->amount
	{
		try
		{
			//con=ConnectionToMysql.getconnection();
	        pst=con.prepareStatement("select * from donardonation where Amount>=?");
	        pst.setString(1,aml.getText());
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
	        while(rs.next())
	        {
	        	Vector<Object> row=new Vector<Object>(columns);
	        for(int i=1;i<=columns;i++)
	       {
	        	row.addElement(rs.getObject(i));
	        
	        
	       }	data.addElement(row);
	        
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
	void fetc()
	{
		try
		{
			//con=ConnectionToMysql.getconnection();
	        pst=con.prepareStatement("select * from donardonation where Donar_ID=?");
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
	        while(rs.next())
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
}
public class Donarlog {
	public static void main(String[] args) {
	    doa d=new doa();
	}

}
