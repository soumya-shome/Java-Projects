package ims.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class StockDb {
    Connection cn=null;
    Statement st=null;
    ResultSet rs=null;
    PreparedStatement ps=null;
    public StockDb()
    {
	try
	{
            Class.forName("oracle.jdbc.driver.OracleDriver");//REGISTER AND LOAD THE JDBC DRIVER
            this.cn=DriverManager.getConnection("jdbc:oracle:oci:@localhost:1521:xe","b22","b22");//ESTABLISH THE CONNECTION	
	}catch(ClassNotFoundException | SQLException ce){
            ce.printStackTrace();
	}
    }
    
    public ResultSet getStock(int id)
    {
        String select_sql="";
        if(id==0)
            select_sql="select * from wstock order by w_id";
        else if(id==1)
            select_sql="select * from shstock order by sh_id";
         
        try
        {
            st=cn.createStatement();//CREATE THE STATEMENT
            rs=st.executeQuery(select_sql);//EXECUTE THE QUERY AND RETRIEVE DATA INTO RESULTSET
            return rs;
        }
	catch(SQLException se)
        {
            se.printStackTrace();
            return null;
	}
    }
}
