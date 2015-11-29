package SQL;

import java.sql.*;
import javax.swing.*;

public class sqlConnection {
	Connection conn = null;

	public static Connection dbconnector()
	{
		try{
			Class.forName("org.sqlite.JDBC");
			Connection conn=DriverManager.getConnection("jdbc:sqlite:E:\\SSDI Project\\db\\ssdi.sqlite");
//			JOptionPane.showMessageDialog(null, "Connection Successful!");
			return conn;
		}
		catch(Exception e)
		{
			JOptionPane.showMessageDialog(null, "pls select option");
			return null;
		}
	}

}

