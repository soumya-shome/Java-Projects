package ims.database;

import java.sql.*;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

public class SWShDb {
    Connection cn=null;
    Statement st=null;
    ResultSet rs=null;
    PreparedStatement ps=null;
    public SWShDb()
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
    
    public ResultSet getS2W()
      {
        try
        {
            String select_sql="select * from stow order by r_date";
            st=cn.createStatement();//CREATE THE STATEMENT
            rs=st.executeQuery(select_sql);//EXECUTE THE QUERY AND RETRIEVE DATA INTO RESULTSET
            return rs;
        }
	catch(SQLException se)
        {
            return null;
	}
    }
    
    public ResultSet getW2Sh()
    {
        try
        {
            String select_sql="select * from wtosh order by d_date";
            st=cn.createStatement();
            rs=st.executeQuery(select_sql);
            return rs;
        }
	catch(SQLException se)
        {
            return null;
	}
    }
    
    public void saveS2W(String sid,String pid,String pqty,String wid,String rdate)
    {
        String insert_sql="insert into stow values(?,?,?,?,?)";
        try{
            if(this.checkStock(wid,pid)){
                this.updateWStock(pqty,wid,pid,0);
            }
            else
            {
                this.addStock(wid,pid,pqty);
            }
            ps=cn.prepareStatement(insert_sql);
            ps.setString(1,sid);
            ps.setString(2,pid);
            ps.setString(3,pqty);
            ps.setString(4,wid);
            ps.setString(5,rdate);
            ps.executeUpdate();
            cn.commit();
            JOptionPane.showMessageDialog(null, "Data Inserted !!","Success", JOptionPane.WARNING_MESSAGE);
        }catch(SQLException se){
            JOptionPane.showMessageDialog(null, "Cannot Be Added !!","Error", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public void saveW2Sh(String wid,String pid,String pqty,String shid,String ddate)
    {
        String insert_sql="insert into wtosh values(?,?,?,?,?)";
        try{
            if(this.checkStock(wid,pid)){
                this.updateWStock(pqty,wid,pid,1);
            }
            ps=cn.prepareStatement(insert_sql);
            ps.setString(1,wid);
            ps.setString(2,pid);
            ps.setString(3,pqty);
            ps.setString(4,shid);
            ps.setString(5,ddate);
            ps.executeUpdate();
            cn.commit();
            JOptionPane.showMessageDialog(null, "Data Inserted !!","Success", JOptionPane.WARNING_MESSAGE);
        }catch(SQLException se){
            System.out.println(se);
            JOptionPane.showMessageDialog(null, "Cannot Be Added !!","Error", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    public void updateWStock(String qty,String wid,String pid,int ch)
    {
        
        String insert_sql="";
        if(ch==0)
            insert_sql="update wstock set qty=qty+to_number(?) where w_id=? and p_id=?";
        else if(ch==1)
            insert_sql="update wstock set qty=qty-to_number(?) where w_id=? and p_id=?";
        try{
            ps=cn.prepareStatement(insert_sql);
            ps.setString(1,qty);
            ps.setString(2,wid);
            ps.setString(3,pid);
            ps.executeUpdate();
            cn.commit();
        }catch(SQLException se){
            System.out.println("Update Error");
        }
    }
    
    public void addStock(String wid,String pid,String pqty)
    {
        String insert_sql="insert into wstock values(?,?,?)";
        try{
            ps=cn.prepareStatement(insert_sql);
            ps.setString(1,wid);
            ps.setString(2,pid);
            ps.setString(3,pqty);
            ps.executeUpdate();
            cn.commit();
        }catch(SQLException se){
            System.out.println("Add Error");
        }
    }
    
    public boolean checkStock(String wid,String pid)
    {
        try
        {
            String select_sql="select count(*) as count from wstock where w_id=? and p_id=?";
            ps=cn.prepareStatement(select_sql);
            ps.setString(1,wid);
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
    
    public String getCount(String wid,String pid){
        try
        {
            String select_sql="select qty from wstock where w_id=? and p_id=?";
            ps=cn.prepareStatement(select_sql);
            ps.setString(1,wid);
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