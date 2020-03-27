package com.example.mepositry;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Sponsor extends AppCompatActivity {
    public static String namee, service, phnum, emails, password,place,clg,website;
    public int vj = MainActivity.user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sponsor);

    }

    public void login(View view) {
        Log.isLoggable("po", vj);
        EditText text2 = (EditText) findViewById(R.id.input_email);
        emails = text2.getText().toString();
        EditText text3 = (EditText) findViewById(R.id.input_place);
        place = text3.getText().toString();
        EditText text4= (EditText) findViewById(R.id.input_clg);
        clg = text4.getText().toString();
        EditText text5= (EditText) findViewById(R.id.input_web);
        website = text5.getText().toString();
        Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_EMAIL,new String[]{"teammediaamritasoe@gmail.com"});
        emailIntent.putExtra(Intent.EXTRA_CC, new String[]{""});
        emailIntent.putExtra(Intent.EXTRA_BCC, new String[]{""});
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Sponsor");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "Name of the Hospital: "+place+"\n"+
                                                       "Address: "+clg+"\n"+
                                                        "Motive: "+emails+"\n"+
                                                        "Website: "+website+"\n");
        startActivity(emailIntent);


    }


    public void siggn(View view) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:9790018937"));
        startActivity(intent);
    }
}
