package com.example.aayushgarg.skit_college;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by aayushgarg on 9/21/18.
 */
public class DataClass {

    String lat;
    String lon;
    ArrayList<String> buttonData;
    ArrayList<String> data;
   static DataClass instance=new DataClass();
    private  DataClass(){}
    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public ArrayList<String> getButtonData() {
        return buttonData;
    }

    public void setButtonData(ArrayList<String> buttonData) {
        this.buttonData = buttonData;
    }

    public ArrayList<String> getData() {
        return data;
    }

    public void setData(ArrayList<String> data) {
        this.data = data;
    }

    public static  DataClass getInstance() {
        return instance;
    }
}