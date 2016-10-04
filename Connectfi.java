import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


 class Connectfi 
{
	 static Connection con;
	static public Connection getconnect()
	{
		try{
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://localhost:3306/ngo","root","bce");
	       }
	catch (ClassNotFoundException e)
	{
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return con;
	}

}
