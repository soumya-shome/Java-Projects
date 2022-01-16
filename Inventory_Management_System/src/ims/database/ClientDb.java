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
    public ClientDb(){
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
    
    private String getBookingID(){
        String sql="select count(*) as co from booking";
        int c=1;
        try{
            st=this.cn.createStatement();
            rs=st.executeQuery(sql);
            rs.next();
            c=Integer.parseInt(rs.getString("co"));
        }catch(SQLException se){
            se.printStackTrace();
        }
        System.out.println(c);
        return Integer.toString(10001+c);
    }
    
    public void saveBook(String cid,String cname,String cph,String pid,String pqty,String shid,String tdate){
        String insert_sql="insert into booking values(?,?,?,?,?,?,?,?)";
        try
        {
            String bid="B"+getBookingID();
            System.out.println(bid);
            ps=cn.prepareStatement(insert_sql);
            ps.setString(1,bid);
            ps.setString(2,cid);
            ps.setString(3,cname);
            ps.setString(4,cph);
            ps.setString(5,pid);
            ps.setString(6,pqty);
            ps.setString(7,shid);
            ps.setString(8,tdate);
            ps.executeUpdate();
            cn.commit();
            if(this.checkShStock(shid,pid)){
                this.updateShStock(pqty,shid,pid,1);
            }
        }
	catch(SQLException se)
	{
            se.printStackTrace();
	}
    }
          
    public ResultSet getData(String id){
        String select_sql="select * from booking where c_id=?";
    	try
    	{
            ps=cn.prepareStatement(select_sql);
            ps.setString(1,id);
            rs=ps.executeQuery();
            cn.commit();
            return rs;
	}
	catch(SQLException se)
	{
            se.printStackTrace();
	}
        return null;
    }
    
    public void updateShStock(String qty,String shid,String pid,int ch){
        
        String insert_sql="";
        if(ch==0)
            insert_sql="update shstock set qty=qty+to_number(?) where sh_id=? and p_id=?";
        else if(ch==1)
            insert_sql="update shstock set qty=qty-to_number(?) where sh_id=? and p_id=?";
        try{
            ps=cn.prepareStatement(insert_sql);
            ps.setString(1,qty);
            ps.setString(2,shid);
            ps.setString(3,pid);
            ps.executeUpdate();
            cn.commit();
        }catch(SQLException se){
            System.out.println("Update Error");
        }
    }
       
    public boolean checkShStock(String shid,String pid){
        try
        {
            String select_sql="select count(*) as count from shstock where sh_id=? and p_id=?";
            ps=cn.prepareStatement(select_sql);
            ps.setString(1,shid);
            ps.setString(2,pid);
            rs=ps.executeQuery();
            int count=0;
            while(rs.next())
                count=Integer.parseInt(rs.getString("count"));
            System.out.println(count);
            if(count != 0)
                return true;
        }catch(SQLException se){
            System.out.println("ERROR");
            return false;
        }
        return false;
    }
    
    public String getShCount(String shid,String pid){
        try
        {
            String select_sql="select qty from shstock where sh_id=? and p_id=?";
            ps=cn.prepareStatement(select_sql);
            ps.setString(1,shid);
            ps.setString(2,pid);
            rs=ps.executeQuery();
            String count="0";
            while(rs.next())
                count=rs.getString("qty");
            //System.out.println(count);
            return count;
        }catch(SQLException se){
            System.out.println("ERROR");
            return "0";
        }
    }
}
