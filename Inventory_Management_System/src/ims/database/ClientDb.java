package ims.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class ClientDb {
    Connection cn=null;
    Statement st=null;
    ResultSet rs=null;
    PreparedStatement ps=null;
    public ClientDb()
    {
	try
	{
            Class.forName("oracle.jdbc.driver.OracleDriver");//REGISTER AND LOAD THE JDBC DRIVER
            this.cn=DriverManager.getConnection("jdbc:oracle:oci:@localhost:1521:xe","b22","b22");//ESTABLISH THE CONNECTION	
	}catch(ClassNotFoundException ce){
            ce.printStackTrace();
	}catch(SQLException se){
            se.printStackTrace();
	}
    }
    
    public ResultSet getShowroomId()
    {
        String select_showroomid="select distinct sh_id from showroom";
        try
	{
            st=cn.createStatement();
            rs=st.executeQuery(select_showroomid);
            return rs;
        }
	catch(SQLException se)
	{
            se.printStackTrace();
	}
        return rs;
    }
        
    public ResultSet getProductId()
    {
        String select_pid="select distinct p_id from product";
	try
	{
            st=cn.createStatement();
            rs=st.executeQuery(select_pid);
            return rs;
        }
	catch(SQLException se)
	{
            se.printStackTrace();
        }
        return null;
    }
         
    public void saveBook(String cid,String cname,String cph,String pid,String pqty,String shid,String tdate)
    {
        String insert_sql="insert into booking values(?,?,?,?,?,?,?,?)";
        try
        {
            ps=cn.prepareStatement(insert_sql);
            ps.setString(1,cid);
            ps.setString(2,cname);
            ps.setString(3,cph);
            ps.setString(4,pid);
            ps.setString(5,pqty);
            ps.setString(6,shid);
            ps.setString(7,tdate);
            ps.executeUpdate();
            cn.commit();
        }
	catch(SQLException se)
	{
            se.printStackTrace();
	}
    }
          
    public ResultSet getData()
    {
        String select_sql="select * from booking";
    	try
    	{
            st=cn.createStatement();//CREATE THE STATEMENT
            //st=con.getStatement();
            rs=st.executeQuery(select_sql);//EXECUTE THE QUERY AND RETRIEVE DATA INTO RESULTSET
            //rs=con.getResultSet(select_sql);
            return rs;
	}
	catch(SQLException se)
	{
            se.printStackTrace();
	}
        return null;
    }
}
