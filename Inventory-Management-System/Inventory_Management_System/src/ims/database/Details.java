package ims.database;

import java.sql.*;

public class Details {
    Connection cn=null;
    Statement st=null;
    ResultSet rs=null;
    PreparedStatement ps=null;
    public Details()
    {
	try
	{
            Class.forName("oracle.jdbc.driver.OracleDriver");//REGISTER AND LOAD THE JDBC DRIVER
            this.cn=DriverManager.getConnection("jdbc:oracle:oci:@localhost:1521:xe","b22","b22");//ESTABLISH THE CONNECTION	
	}catch(ClassNotFoundException | SQLException ce){
            ce.printStackTrace();
	}
    }
    
    public ResultSet getSID()
    {
        try
        {
            String select_sql="select * from supplier order by s_id";
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
    
    public ResultSet getPID()
    {
        try
        {
            String select_sql="select * from product order by p_id";
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
    
    public ResultSet getWID()
    {
        try
        {
            String select_sql="select * from warehouse order by w_id";
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
    
    public ResultSet getShID()
    {
        try
        {
            String select_sql="select * from Showroom order by sh_id";
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
