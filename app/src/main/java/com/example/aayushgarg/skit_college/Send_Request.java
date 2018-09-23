package com.example.aayushgarg.skit_college;

import android.content.Intent;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

/**
 * Created by aayushgarg on 9/18/18.
 */

public class Send_Request {
    private static DatabaseReference requestTable;
    private static DatabaseReference AnsData;
    private static String garg = "-1";

    static void hasRequest() {
        String aa = new String();
        int temp = 0;
        try {

            requestTable = FirebaseDatabase.getInstance().getReference("requestTable");
            aa = requestTable.push().getKey();
ArrayList<String> temp1=new ArrayList<String>();
            DataClass instance =DataClass.getInstance();

            temp1.add(instance.getLat());
            temp1.add(instance.getLon());

            Request_table table = new Request_table(instance.getData(),instance.getButtonData(), temp1, aa,"0");
            requestTable.child(aa).setValue(table);
            temp = 1;
       AayushGarg.setAns(aa);
        } catch (Exception e) {

            String aaaa=e.toString();
            temp = 0;
        }

    }

}


















