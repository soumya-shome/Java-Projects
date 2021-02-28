package rideara.controller;

import rideara.database.DB;

public class controller {
    private static controller controller;
    private final DB db;
    
    private controller(){
        this.db =new DB();
        this.db.openConn();
    }
    
    public static controller getController(){
        if (controller==null)
            controller=new controller();
        return controller;
    }

    public boolean signup(User user) {
        return this.db.newUser(user);
    }
    
    public User login(String username, String password) {
        return this.db.getUser(username, password);
    }
    
    public String baln(String username){
        return String.valueOf(this.db.getBalnc(username));
    }
    
    public Station Stations(){
        return this.db.getStation();
    }
}
