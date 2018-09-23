package com.example.aayushgarg.skit_college;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.provider.ContactsContract;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class fetur extends AppCompatActivity {
    private Button addButton;
    private Button goButton;
    private DatabaseReference refrence;
    private  ProgressDialog progressDialog;
    private List<key_table> datafield;
    private  RecyclerView recyclerView;
    ArrayList<String> list;
    ArrayList<String> garg;
    private Button button;
    Addapter_class adapter;
    @SuppressLint("WrongViewCast")
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fetur);
        datafield = new ArrayList<>();
        progressDialog = new ProgressDialog(this);
//list1=new ArrayList<String>();
        list=new ArrayList<String>();
        recyclerView = (RecyclerView) findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


      addButton =(Button)findViewById(R.id.button102);
goButton=(Button)findViewById(R.id.button101);


garg = getIntent().getStringArrayListExtra("list");

if(garg==null||garg.size()==0){
    garg=new ArrayList<>();
    garg.add("");
}







        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final AlertDialog.Builder mBuilder =new AlertDialog.Builder(fetur.this);
                View mView=getLayoutInflater().inflate(R.layout.addfetur,null);

                final EditText name_of_fun=(EditText) mView.findViewById(R.id.edit1212);
                button=(Button)mView.findViewById(R.id.garg1212);
                mBuilder.setView(mView);

                final   AlertDialog  d=mBuilder.create();



                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(name_of_fun.getText().toString()!=null)
                            DataBase.adddata(name_of_fun.getText().toString());
                   d.dismiss();
                    }
                });

                d.show();


            }


        });

goButton.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {

Intent i=new Intent();
garg=adapter.getSetupList();


        ArrayList<String> datafield1 = new ArrayList<String >();


        for(int j=0;j<datafield.size();j++) {

            String temp = datafield.get(j).getName();
            datafield1.add(temp.toString() + "-" + garg.get(j));

        }
       DataClass instance =DataClass.getInstance();
        instance.setData(datafield1);
        //Send_Request.hasRequest(datafield1);



/*
        ArrayList<String> datafield = new ArrayList<String >();


  list1=Addapter_class.getSetupList();


        for(int i=0;i<list.size();i++)
            datafield.add(datafield.get(i).substring(6,datafield.get(i).length()-1)+"-"+list1.get(i));
        Send_Request.hasRequest(datafield);

*/
        startActivity(new Intent(fetur.this,ButtonInput.class));
    }
});



    }

    protected void onStart() {
    super.onStart();


        progressDialog.setMessage("progress....");
        progressDialog.show();

        refrence= FirebaseDatabase.getInstance().getReference("AttributeTable").child("attr");
        refrence.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                try {
datafield.clear();
                    for (DataSnapshot ayush : dataSnapshot.getChildren()) {
                        String aa= ayush.getValue().toString();
                        key_table paperTable = new key_table(aa);
                        datafield.add(0,paperTable);

                    }
                    adapter = new Addapter_class(datafield, fetur.this,new ArrayList<String>());
                    recyclerView.setAdapter(adapter);
                    progressDialog.dismiss();
                } catch (Exception e)

                {
                    Toast.makeText(fetur.this, e.toString(), Toast.LENGTH_LONG).show();
                    progressDialog.dismiss();
                }


    }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }


        });
    }}