package ims.database;

import java.sql.*;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

public class PDb {
    Connection cn=null;
    Statement st=null;
    ResultSet rs=null;
    PreparedStatement ps=null;
    public PDb()
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
    
    public void saveProd(String pid,String pname,String pprice,String pmodel,String pcolor)
    {
        String insert_sql="insert into product values(?,?,?,?,?)";
        try{
            ps=cn.prepareStatement(insert_sql);
            ps.setString(1,pid);
            ps.setString(2,pname);
            ps.setString(3,pprice);
            ps.setString(4,pmodel);
            ps.setString(5,pcolor);
            ps.executeUpdate();
            cn.commit();
            JOptionPane.showMessageDialog(null, "Data Inserted !!","Success", JOptionPane.WARNING_MESSAGE);
        }catch(SQLException se){
            JOptionPane.showMessageDialog(null, "Cannot Be Added !!","Error", JOptionPane.WARNING_MESSAGE);
            se.printStackTrace();
        }
    }
    
    public ResultSet getProd()
      {
        try
        {
            String select_sql="select * from product order by p_id";
            st=cn.createStatement();//CREATE THE STATEMENT
            rs=st.executeQuery(select_sql);//EXECUTE THE QUERY AND RETRIEVE DATA INTO RESULTSET
            return rs;
            //supplier_table.setModel(DbUtils.resultSetToTableModel(rs));
        }
	catch(SQLException se)
        {
            se.printStackTrace();
            return null;
	}
    }
    
    public void deleteProd(String pid)
    {
        try
	{
            String delete_sql="delete from product where pid=?";
            ps=cn.prepareStatement(delete_sql);
            ps.setString(1,pid);
            ps.executeUpdate();
            cn.commit();
            JOptionPane.showMessageDialog(null, "Data Deleted !!","Success", JOptionPane.WARNING_MESSAGE);
        }
	catch(SQLException se)
        {
            JOptionPane.showMessageDialog(null, "Something Went Wrong !!","Error", JOptionPane.WARNING_MESSAGE);
            se.printStackTrace();
	}
    }
    
    public void updateProd(String pid,String pname,String pprice,String pmodel,String pcolor)
    {
    	try
    	{
            String update_sql="update product set name=?,price=?,model=?,color=? where pid=?";
            ps=cn.prepareStatement(update_sql);
            ps.setString(1,pid);
            ps.setString(2,pname);
            ps.setString(3,pprice);
            ps.setString(4,pmodel);
            ps.setString(5,pcolor);
            ps.executeUpdate();
            cn.commit();
            JOptionPane.showMessageDialog(null, "Data Updated !!","Success", JOptionPane.WARNING_MESSAGE);
        }catch(SQLException se){
            JOptionPane.showMessageDialog(null, "Something Went Wrong !!","Error", JOptionPane.WARNING_MESSAGE);
            se.printStackTrace();
	}
    }
}