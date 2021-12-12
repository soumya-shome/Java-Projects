/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SWING;

/**
 *
 * @author ARINDAM
 */
import java.sql.*;
public class ConnectionFactory {
    Connection cn=null;
public Connection getConn()
{
	try
	{
		Class.forName("oracle.jdbc.driver.OracleDriver");//REGISTER AND LOAD THE JDBC DRIVER
		cn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:ORCL","b22","b22");//ESTABLISH THE CONNECTION
		
	}
	catch(ClassNotFoundException ce)
	{
		ce.printStackTrace();
	}
	catch(SQLException se)
	{
		se.printStackTrace();
	}
	return cn;
}  
}
