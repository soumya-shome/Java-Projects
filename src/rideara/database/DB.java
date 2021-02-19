package rideara.database;

import com.mysql.jdbc.Connection;
import java.sql.*;
import rideara.controller.User;


public class DB {
    private Connection conn;

    public void openConn(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            this.conn=(Connection) DriverManager.getConnection("jdbc:mysql://localhost/rideara?useSSL=false","root","");
            System.out.println("Connection Established");
            
        }catch(ClassNotFoundException | SQLException e){
            System.err.println("Error"+e.getMessage());
        }
    }

    public boolean newUser(User user) {
        try {
            String query;
            query = "INSERT INTO `users`(`username`, `Fname`, `Lname`, `password`) VALUES ('" + user.getUserName() + "','" + user.getName() + "','" + user.getLastName() + "','" + user.getPassword() + "')";
            Statement statement = this.conn.createStatement();
            statement.executeUpdate(query);
            statement.close();
            query = "INSERT INTO `wallet`(`username`, `balance`) VALUES ('"+user.getUserName()+"',0)";
            statement = this.conn.createStatement();
            statement.executeUpdate(query);
            statement.close();
            return true;
        } catch (SQLException ex) {
            return false;
        }
    }

    public User getUser(String userName, String password)  {
        try {
            String query = "SELECT * FROM `users` WHERE `username`='" + userName + "' AND `password`='" + password + "'";
            Statement st = this.conn.createStatement();
            ResultSet resultSet = st.executeQuery(query);

            User user = null;
            if (resultSet.next()) {
                user = new User();
                user.setUserName(resultSet.getString("username"));
                user.setName(resultSet.getString("Fname"));
                user.setLastName(resultSet.getString("Lname"));
                user.setPassword(resultSet.getString("password"));
            }
            st.close();
            resultSet.close();
            return user;
        } catch (SQLException ex) {
            return null;
        }
    }
    
    public int getBalnc(String usr){
        try{
            String query = "SELECT `balance` FROM `wallet` WHERE `username`='"+usr+"'";
            Statement st = this.conn.createStatement();
            ResultSet resultSet = st.executeQuery(query);
            resultSet.next();
            int balance=resultSet.getInt("balance");
            st.close();
            resultSet.close();
            return balance;
        }catch(SQLException ex){
            return -1;
        }
    }
}
