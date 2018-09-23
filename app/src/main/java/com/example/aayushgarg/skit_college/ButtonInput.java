package com.example.aayushgarg.skit_college;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;

import java.util.ArrayList;

public class ButtonInput extends AppCompatActivity {
private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_input);

        final RadioButton radioButton1=(RadioButton) findViewById(R.id.radioButton3);
        final RadioButton radioButton2=(RadioButton)findViewById(R.id.radioButton4);
        final  RadioButton radioButton3=(RadioButton)findViewById(R.id.radioButton5);
        final RadioButton radioButton4=(RadioButton)findViewById(R.id.radioButton6);
        final RadioButton radioButton5=(RadioButton)findViewById(R.id.radioButton7);
        final RadioButton radioButton6=(RadioButton)findViewById(R.id.radioButton8);
        final RadioButton radioButton7=(RadioButton)findViewById(R.id.radioButton9);
        final RadioButton radioButton8=(RadioButton)findViewById(R.id.radioButton10);

               button =(Button)findViewById(R.id.button_pre);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            ArrayList<String> data=new ArrayList<String >();

            if(radioButton2.isChecked())
                data.add("lift-0");
            else
                data.add("lift-1");
                if(radioButton4.isChecked())
                    data.add("gym-0");
                else
                    data.add("gym-1");

                if(radioButton6.isChecked())
                    data.add("swimming_pool-0");
                else
                    data.add("swimming_pool-1");
                if(radioButton8.isChecked())
                    data.add("parking-0");
                else
                    data.add("parking-1");
                DataClass instance =DataClass.getInstance();
                instance.setButtonData(data);
                 Send_Request.hasRequest();
                startActivity(new Intent(ButtonInput.this,price_result.class));
            }
        });

        radioButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(radioButton2.isChecked())
                    radioButton2.setChecked(false);
            }
        });

        radioButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(radioButton1.isChecked())
                    radioButton1.setChecked(false);
            }
        });
        radioButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(radioButton4.isChecked())
                    radioButton4.setChecked(false);
            }
        }); radioButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(radioButton3.isChecked())
                    radioButton3.setChecked(false);
            }
        }); radioButton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(radioButton6.isChecked())
                    radioButton6.setChecked(false);
            }
        }); radioButton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(radioButton5.isChecked())
                    radioButton5.setChecked(false);
            }
        }); radioButton7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(radioButton8.isChecked())
                    radioButton8.setChecked(false);
            }
        }); radioButton8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(radioButton7.isChecked())
                    radioButton7.setChecked(false);
            }
        });


    }
    }
