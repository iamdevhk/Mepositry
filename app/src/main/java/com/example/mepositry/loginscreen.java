package com.example.mepositry;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class loginscreen extends AppCompatActivity {
    public static String namee, service, phnum, emails, password;
    public int vj = MainActivity.user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginscreen);

    }

    public void login(View view) {
        Log.isLoggable("po", vj);
        EditText text2 = (EditText) findViewById(R.id.input_email);
        emails = text2.getText().toString();
        EditText text3 = (EditText) findViewById(R.id.input_password);
        password = text3.getText().toString();
        if (vj == 0) {
           // Intent al = new Intent(loginscreen.this, Component.class);

            // Start the new activity
            //startActivity(al);
           response hu = new response(this.getApplicationContext());
            hu.execute();
        } else if (vj == 1) {//1 is for doc da
            //Intent al = new Intent(loginscreen.this, Component.class);

            // Start the new activity
            //startActivity(al);
            docresponse hu = new docresponse(this.getApplicationContext());
            hu.execute();

        }


    }


    public void siggn(View view) {
        if (vj == 0) {
            Intent al = new Intent(loginscreen.this, Signup.class);

            // Start the new activity
            startActivity(al);
        }
        if (vj == 1) {
            Toast.makeText(this, "please contact the admin", Toast.LENGTH_SHORT).show();
        }
    }
}
