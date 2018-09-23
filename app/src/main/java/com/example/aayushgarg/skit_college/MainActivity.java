package com.example.aayushgarg.skit_college;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.text.Spanned;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {
    private TextView signup_b;
    private EditText email_id;
    private  EditText password;
    private  Button login_b;

    private FirebaseAuth firebase_auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textViewCreateAccount = (TextView) findViewById(R.id.textViewCreateAccount);
        textViewCreateAccount.setText(fromHtml("<font color='#ffffff'>I don't have account yet. </font><font color='#00b8d4'>create one</font>"));
        textViewCreateAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,resiter.class);
                startActivity(intent);
            }
        });
        signup_b = (TextView) findViewById(R.id.textViewCreateAccount);

        email_id = (EditText) findViewById(R.id.editTextEmail);

        password = (EditText) findViewById(R.id.editTextPassword);

        login_b = (Button) findViewById(R.id.buttonLogin);


        firebase_auth = FirebaseAuth.getInstance();



        if (firebase_auth.getCurrentUser() != null) {
            startActivity(new Intent(MainActivity.this, First_Page.class));      //id allready login
            finish();
        }

        signup_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, resiter.class));
                finish();
            }
        });

        login_b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (true) {

                    String email = email_id.getText().toString();
                    final String password1 = password.getText().toString();

                    if (TextUtils.isEmpty(email)) {
                        Toast.makeText(getApplicationContext(), "Enter email address!", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    if (TextUtils.isEmpty(password1)) {
                        Toast.makeText(getApplicationContext(), "Enter password!", Toast.LENGTH_SHORT).show();
                        return;
                    }

                    try {


                        //authenticate user
                        firebase_auth.signInWithEmailAndPassword(email, password1)
                                .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {

                                    public void onComplete(@NonNull Task<AuthResult> task) {


                                        if (!task.isSuccessful()) {
                                            // there was an error
                                            if (password1.length() < 6) {
                                                password.setError("Weak Password");
                                            } else {
                                                Toast.makeText(MainActivity.this, "Incorrect PassWord Or Email", Toast.LENGTH_LONG).show();
                                            }
                                        } else {
                                            Intent intent = new Intent(MainActivity.this, First_Page.class);
                                            startActivity(intent);
                                            finish();
                                        }
                                    }
                                });
                    } catch (Exception e) {
                        Toast.makeText(MainActivity.this, "Unable to Login at this time", Toast.LENGTH_LONG).show();

                    } finally {

                    }
                } else {
                    Toast.makeText(MainActivity.this, "Check Your Internet Cnnection", Toast.LENGTH_LONG).show();

                }

            }
        });


    }

    @SuppressWarnings("deprecation")
    public static Spanned fromHtml(String html) {
        Spanned result;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            result = Html.fromHtml(html, Html.FROM_HTML_MODE_LEGACY);
        } else {
            result = Html.fromHtml(html);
        }
        return result;
    }
}


