package ims.database;

import sample.ConnectionFactory;
import java.sql.*;

public class Conn {
    Connection cn=null;
    Statement st=null;
    ResultSet rs=null;
    public void openConn()
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
}