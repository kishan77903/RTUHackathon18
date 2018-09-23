package com.example.aayushgarg.skit_college;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by aayushgarg on 9/17/18.
 */

public class DataBase {

   private static DatabaseReference referenceOrder;


   public  static  boolean  adddata(String aaa){

      try {

         referenceOrder = FirebaseDatabase.getInstance().getReference("AttributeTable");
         String aa=referenceOrder.push().getKey();
         key_table table = new key_table(aaa);
         referenceOrder.child(aa).setValue(table);

      return true;
      }
      catch (Exception e)
      {
         return false;
      }

   }

}
