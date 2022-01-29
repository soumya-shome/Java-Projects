package rideara.controller;

public class Station {
    private String[] station,s_id;
    private int count=0;
    
    public void setSi(int n){
        this.station=new String[n];
        this.s_id=new String[n];
    } 
    
    public void incre(){
        this.count+=1;
    }
    public void setStation(String stats){
        this.station[this.count]=stats;
    }
    
    public void setSID(String sid){
        this.s_id[this.count]=sid;
    }
    
    public String[] getStation(){
        return this.station;
    }
    
    public String[] getSID(){
        return this.s_id;
    }

}
