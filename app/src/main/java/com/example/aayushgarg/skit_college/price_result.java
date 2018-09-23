package com.example.aayushgarg.skit_college;

import android.app.ProgressDialog;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.animation.OvershootInterpolator;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.robinhood.ticker.TickerUtils;
import com.robinhood.ticker.TickerView;

import java.util.Locale;

public class price_result extends AppCompatActivity {
private TextToSpeech textToSpeech;
private TextView textView2;
private TextView getTextView3;
    TextView textView3;
  //   TickerView tickerView ;
   ProgressDialog progressDialog;
     private DatabaseReference responce;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_price_result);
   progressDialog=new ProgressDialog(this);
        progressDialog.setMessage("Wait...");
        progressDialog.show();
        textToSpeech=new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
      @Override
      public void onInit(int i) {
          if(i!=TextToSpeech.ERROR)
              textToSpeech.setLanguage(Locale.US);
      }
  });
        responce = FirebaseDatabase.getInstance().getReference("ResponceTable");
     //    tickerView = findViewById(R.id.tickerView);

        textToSpeech.speak("Your House Price Rent Is",TextToSpeech.QUEUE_FLUSH,null);

    TextView textView2=findViewById(R.id.textView2);
     textView3=findViewById(R.id.textView3);

      /*  final TickerView tickerView = findViewById(R.id.tickerView);
        tickerView.setAnimationDuration(500);
        tickerView.setAnimationInterpolator(new OvershootInterpolator());
        tickerView.setGravity(Gravity.START);
        tickerView.setCharacterLists(TickerUtils.provideNumberList());*/
    }

    @Override
    protected void onStart() {
        super.onStart();

        responce = responce.child(AayushGarg.getAns()).child("Ans");

        responce.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                try {
                    String temp1="-1";
                    temp1=dataSnapshot.getValue().toString();
                    String garg=temp1;

                    textView3.setText(garg);
                    //tickerView.setCharacterLists(TickerUtils.provideNumberList());
                 //   tickerView.setText(garg);
                progressDialog.dismiss();
                }
                catch (Exception e)

                {
                    String aaaa=e.toString();
                }


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }


        });}
}
