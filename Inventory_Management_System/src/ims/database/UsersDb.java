package ims.database;

import java.sql.*;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

public class UsersDb {
    Connection cn=null;
    Statement st=null;
    ResultSet rs=null;
    PreparedStatement ps=null;
    public UsersDb(){
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
    
    private String getUserID(){
        String sql="SELECT count(*) as c FROM USERS ";
        int c=1;
        try{
            st=this.cn.createStatement();//CREATE THE STATEMENT
            rs=st.executeQuery(sql);//EXECUTE THE QUERY AND RETRIEVE DATA INTO RESULTSET
            rs.next();
            c=Integer.parseInt(rs.getString("c"));
        }catch(SQLException se){
            se.printStackTrace();
        }
        return Integer.toString(10000+c);
    }
    
    public String checkLogin(String username,String password){
        String sql="select * from users where username='"+username+"' and password='"+password+"'";
        String uid="";
        try{
            st=this.cn.createStatement();//CREATE THE STATEMENT
            rs=st.executeQuery(sql);//EXECUTE THE QUERY AND RETRIEVE DATA INTO RESULTSET
            rs.next();
            uid=rs.getString("u_id");
        }catch(SQLException se){
            se.printStackTrace();
        }
        return uid;
    }
    
    public void register(String username,String password,String name,String phno,String email){
        String insert_sql="insert into users values(?,?,?,?,?,?)";
        try{
            
            ps=cn.prepareStatement(insert_sql);
            ps.setString(1,"U"+getUserID());
            ps.setString(2,username);
            ps.setString(3,password);
            ps.setString(4,name);
            ps.setString(5,phno);
            ps.setString(6,email);
            ps.executeUpdate();
            cn.commit();
            JOptionPane.showMessageDialog(null, "User Registered !!","Success", JOptionPane.WARNING_MESSAGE);
        }catch(SQLException se){
            JOptionPane.showMessageDialog(null, "Cannot Be Added !!","Error", JOptionPane.WARNING_MESSAGE);
            se.printStackTrace();
        }
    }
}