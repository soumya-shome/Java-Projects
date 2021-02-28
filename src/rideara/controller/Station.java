package rideara.controller;

public class Station {
    private String[] station,s_id;
    private int[] capacity,bike_avail;
    private int size;
    private int count=0;
    public void setSi(int n){
        this.size=n;
        this.station=new String[n];
        this.s_id=new String[n];
        this.capacity=new int[n];
        this.bike_avail=new int[n];
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
    
    public void setCapacity(int cap){
        this.capacity[this.count]=cap;
    }
    
    public void setAvail(int avail){
        this.bike_avail[this.count]=avail;
    }
    
    public String[] getStation(){
        return this.station;
    }
    
    public String[] getSID(){
        return this.s_id;
    }
    
    public int[] getCapacity(){
        return this.capacity;
    }
    
    public int[] getAvail(){
        return this.bike_avail;
    }
}
