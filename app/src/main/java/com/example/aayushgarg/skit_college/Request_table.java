package com.example.aayushgarg.skit_college;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aayushgarg on 9/18/18.
 */

public class Request_table {


    ArrayList<String> a;
    ArrayList<String> buttomData;

    ArrayList<String> codinates;
    String requestNumber;
String ans;

    public ArrayList<String> getA() {
        return a;
    }

    public void setA(ArrayList<String> a) {
        this.a = a;
    }

    public String getRequestNumber() {
        return requestNumber;
    }

    public void setRequestNumber(String requestNumber) {
        this.requestNumber = requestNumber;
    }

    public String getAns() {
        return ans;
    }

    public void setAns(String ans) {
        this.ans = ans;
    }

    public ArrayList<String> getCodinates() {
        return codinates;
    }

    public void setCodinates(ArrayList<String> codinates) {
        this.codinates = codinates;
    }

    public ArrayList<String> getButtomData() {
        return buttomData;
    }

    public void setButtomData(ArrayList<String> buttomData) {
        this.buttomData = buttomData;
    }

    public Request_table(ArrayList<String> a, ArrayList<String> buttomData, ArrayList<String> codinates, String requestNumber,String ans) {
        this.a = a;
        this.buttomData = buttomData;
        this.codinates = codinates;
        this.requestNumber = requestNumber;
this.ans=ans;
    }
}
