import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.BorderFactory;
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
import javax.swing.border.Border;

class Tabel extends JFrame implements papaclass
{
	JPanel pnl1,pnl2;
	JButton fetchall,fetch,print;
	JLabel name_hint;
	JComboBox  tname_hint;
	Border bdr;
	Connection con;
	PreparedStatement pst;
	JTable table;
    Tabel()
	{
		setLayout(null);
		con=Connectfi.getconnect();
	/*	if(con==null)
			JOptionPane.showMessageDialog(null,"connection error");
		else{
			JOptionPane.showMessageDialog(null,"connection establish");
		}*/
		bdr=BorderFactory.createLineBorder(Color.gray,2,true);
		
		//=========panel-------------
				pnl2=new JPanel();
				pnl2.setSize(765,610);
				pnl2.setLocation(15,30);
				pnl2.setBorder(bdr);
				pnl2.setLayout(null);
				pnl2.setBackground(Color.LIGHT_GRAY);
				add(pnl2);
				pnl1=new JPanel();
				pnl1.setSize(600,350);
				pnl1.setLocation(80,180);
				pnl1.setBorder(bdr);
				pnl1.setLayout(null);
				pnl1.setBackground(Color.green);
				pnl2.add(pnl1);
				//-------------------------
				fetchall=new JButton("Load ALL");
			    fetchall.setBounds(310, 50, 140,50);
				pnl2.add(fetchall);
                fetchall.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
					/*	if(tname_hint.getSelectedIndex()==0)
							JOptionPane.showMessageDialog(null, "This is not a item");		
						else*/
							fetchAll();	
					}
				});
			    fetch=new JButton("Fetch");
			    fetch.setBounds(510, 130, 90,25);
				pnl2.add(fetch);
				
				 fetch.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						if(tname_hint.getSelectedIndex()==0)
							JOptionPane.showMessageDialog(null, "This is not a item");		
						else
							fetchiddata();
						
					}
				});
			/*	print=new JButton("Print");
				print.setBounds(310, 540, 140,50);
			    pnl2.add(print);*/
					//-------------label
					name_hint=new JLabel("Name Hint");
					name_hint.setSize(130,25);
					name_hint.setFont(new Font("Arival",Font.BOLD|Font.ITALIC,15));
					name_hint.setLocation(130, 130);
					pnl2.add(name_hint);
					//---------------combobox
					tname_hint=new JComboBox();
					tname_hint.setBounds(280, 130, 210,25);
					tname_hint.setEditable(true);
					pnl2.add(tname_hint);
					//====
				
					fetchidA();
				/*	tname_hint.addFocusListener(new FocusListener() {
						
						@Override
						public void focusLost(FocusEvent e) {
							// TODO Auto-generated method stub
							
							//while(true)
							//{
							fetchidB();
						//	}
						}
						
						@Override
						public void focusGained(FocusEvent e) {
							// TODO Auto-generated method stub
							
							tname_hint.setEditable(true);
							fetchidA();
						}
					});*/
					/*tname_hint.addActionListener(new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							// TODO Auto-generated method stub
							System.out.println("hlo");
							fetchidA();
							System.out.println("hi");
						}
					});*/
					//fetchidA();
				//===========set window size
				setSize(815,700);
				setVisible(true);
				
				//getContentPane().setBackground(Color.BLACK);
	}
 
 void fetchidA()
	{
		try
		{
			
		tname_hint.addItem("----Select ID----");
		  pst=con.prepareStatement("select Name from donardonation");
		  ResultSet rs=pst.executeQuery();
		while(rs.next())
		 { 
			String txt=rs.getString("Name");
			tname_hint.addItem(txt);
		 }
	    }
	    catch (Exception e)
	    {// TODO: handle exception
		e.printStackTrace();
	    }
	}
 
	void fetchAll()
	{
		try {
			pst=con.prepareStatement("select * from donardonation");
			
			ResultSet rs=pst.executeQuery();
			java.sql.ResultSetMetaData md=rs.getMetaData();
			Vector<String> columname=new Vector<String>();
			int coloum=md.getColumnCount();
			for(int i=1;i<=coloum;i++ )
			{
				columname.addElement(md.getColumnName(i));
			}
			Vector<Object> data=new Vector<Object>();
			while(rs.next())
			{
				Vector<Object> row=new Vector<Object>();
				for(int i=1;i<=coloum;i++)
				{
				row.addElement(rs.getObject(i));
				}
				data.addElement(row);
			}
			rs.close();
			pst.close();
			table=new JTable(data,columname);
			JScrollPane sbar=new JScrollPane(table);
			table.setBackground(Color.yellow);
			table.setSelectionBackground(Color.red);
			table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			sbar.setBounds(10, 10, 580,330);
			pnl1.add(sbar);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	void fetchiddata()
	{
		try {
			pst=con.prepareStatement("SELECT * FROM donardonation WHERE Name LIKE '%' ? '%'");
			pst.setString(1, String.valueOf(tname_hint.getSelectedItem()));
			ResultSet rs=pst.executeQuery();
			java.sql.ResultSetMetaData md=rs.getMetaData();
			Vector<String> columname=new Vector<String>();
			int coloum=md.getColumnCount();
			for(int i=1;i<=coloum;i++ )
			{
				columname.addElement(md.getColumnName(i));
			}
			Vector<Object> data=new Vector<Object>();
			while(rs.next())
			{
				Vector<Object> row=new Vector<Object>();
				for(int i=1;i<=coloum;i++)
				{
				row.addElement(rs.getObject(i));
				}
				data.addElement(row);
			}
			rs.close();
			pst.close();
			table=new JTable(data,columname);
			JScrollPane sbar=new JScrollPane(table);
			table.setBackground(Color.yellow);
			table.setSelectionBackground(Color.red);
			table.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			sbar.setBounds(10, 10, 580,330);
			pnl1.add(sbar);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
public class LoadAllDonation 
{
	public static void main(String[] args)
	{
		Tabel t=new Tabel();
	}

}
