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
		cn=DriverManager.getConnection("jdbc:oracle:oci:@localhost:1521:xe","b22","b22");//ESTABLISH THE CONNECTION
		
	}
	catch(ClassNotFoundException ce)
	{
            System.out.println("Error !!!!!");
		ce.printStackTrace();
	}
	catch(SQLException se)
	{
            System.out.println("SQL Error !!!");
		se.printStackTrace();
	}
	return cn;
}  
}
