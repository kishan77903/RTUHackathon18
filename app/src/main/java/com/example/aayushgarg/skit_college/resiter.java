package com.example.aayushgarg.skit_college;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class resiter extends AppCompatActivity {

    private Button signup_b;
    private EditText email_id;
    private EditText password;
    private FirebaseAuth firebase_auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resiter);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TextView textViewLogin = (TextView) findViewById(R.id.textViewLogin);
        textViewLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        Button buttonRegister = (Button) findViewById(R.id.buttonRegister);
        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        signup_b=(Button)findViewById(R.id.buttonRegister);

        email_id=(EditText)findViewById(R.id.editTextEmail);
        password=(EditText)findViewById(R.id.editTextPassword);
        firebase_auth = FirebaseAuth.getInstance();







        signup_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (true) {

                    final String email = email_id.getText().toString().trim();
                    String passwordIn = password.getText().toString().trim();

                    if (TextUtils.isEmpty(email)) {
                        Toast.makeText(getApplicationContext(), "Enter email address!", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    if (TextUtils.isEmpty(passwordIn)) {
                        Toast.makeText(getApplicationContext(), "Enter password!", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    if (password.length() < 6) {
                        Toast.makeText(getApplicationContext(), "Password too short, enter minimum 6 characters!", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    String test1= email;
                    String text21=passwordIn;

                    //create user
                    firebase_auth.createUserWithEmailAndPassword(email, passwordIn)
                            .addOnCompleteListener(resiter.this, new OnCompleteListener<AuthResult>() {

                                public void onComplete(@NonNull Task<AuthResult> task) {


                                    // If sign in fails, display a message to the user. If sign in succeeds
                                    // the auth state listener will be notified and logic to handle the
                                    // signed in user can be handled in the listener.
                                    if (task.isSuccessful()) {
                                        Toast.makeText(resiter.this, "Welcome",
                                                Toast.LENGTH_SHORT).show();
                                        startActivity(new Intent(resiter.this, First_Page.class));

                                        finish();
                                    } else {

                                        Toast.makeText(resiter.this, "User Present or Check your email id ",
                                                Toast.LENGTH_SHORT).show();

                                    }

                                }
                            }).addOnFailureListener(resiter.this, new OnFailureListener() {

                                public void onFailure(@NonNull Exception e) {
                                    Toast.makeText(resiter.this, "Unable to SignUp at this time", Toast.LENGTH_LONG).show();

                                }
                            }
                    );
                }else{
                    Toast.makeText(resiter.this,"Check Your Internet Cnnection",Toast.LENGTH_LONG).show();

                }
            }
        });

    }
}




