package ims.database;

import java.sql.*;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

public class Conn {
    Connection cn=null;
    Statement st=null;
    ResultSet rs=null;
    PreparedStatement ps=null;
    public Conn()
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
    
    public boolean checkLogin(String username,String password)
    {
        String sql="select * from registration where username='"+username+"' and password='"+password+"'";
        boolean flag=false;
        try{
            st=this.cn.createStatement();//CREATE THE STATEMENT
            rs=st.executeQuery(sql);//EXECUTE THE QUERY AND RETRIEVE DATA INTO RESULTSET
            if(rs.next()){
                flag=true;
            }
        }catch(SQLException se){
            se.printStackTrace();
        }
        return flag;
    }
    
    public void saveSupp(String sid,String sname,String sph,String email)
    {
        String insert_sql="insert into supplier values(?,?,?,?)";
        try{
            
            ps=cn.prepareStatement(insert_sql);
            ps.setString(1,sid);
            ps.setString(2,sname);
            ps.setString(3,sph);
            ps.setString(4,email);
            ps.executeUpdate();
            cn.commit();
            JOptionPane.showMessageDialog(null, "Data Inserted !!","Success", JOptionPane.WARNING_MESSAGE);
        }catch(SQLException se){
            JOptionPane.showMessageDialog(null, "Cannot Be Added !!","Error", JOptionPane.WARNING_MESSAGE);
            se.printStackTrace();
        }
    }
    
    public ResultSet getSupp()
      {
        try
        {
            String select_sql="select * from supplier order by s_id";
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
    
    public void deleteSupp(String sid)
    {
        try
	{
            String delete_sql="delete from supplier where s_id=?";
            ps=cn.prepareStatement(delete_sql);
            ps.setString(1,sid);
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
    
    public void updateSupp(String sid,String sname,String sph,String email)
    {
    	try
    	{
            String update_sql="update supplier set name=?,ph_no=?,email=? where s_id=?";
            ps=cn.prepareStatement(update_sql);
            ps.setString(1,sid);
            ps.setString(2,sname);
            ps.setString(3,sph);
            ps.setString(4,email);
            ps.executeUpdate();
            cn.commit();
            JOptionPane.showMessageDialog(null, "Data Updated !!","Success", JOptionPane.WARNING_MESSAGE);
        }catch(SQLException se){
            JOptionPane.showMessageDialog(null, "Something Went Wrong !!","Error", JOptionPane.WARNING_MESSAGE);
            se.printStackTrace();
	}
    }
}