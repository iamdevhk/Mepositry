package com.example.mepositry;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class alert extends AppCompatActivity {
    public static String namee, service, phnum, emails, password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert);
    }

    public void login(View view) {
       // Log.isLoggable("po", vj);
        EditText text2 = (EditText) findViewById(R.id.input_email);
        emails = text2.getText().toString();
        Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_EMAIL,new String[]{"teammediaamritasoe@gmail.com"});
        emailIntent.putExtra(Intent.EXTRA_CC, new String[]{""});
        emailIntent.putExtra(Intent.EXTRA_BCC, new String[]{""});
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Alert");
        emailIntent.putExtra(Intent.EXTRA_TEXT, emails);
        startActivity(emailIntent);


    }
}
