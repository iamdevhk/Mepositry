package com.example.mepositry;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class docscreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_docscreen);
    }
    public void spon(View view) {
        Intent log = new Intent(docscreen.this, Sponsor.class);

        // Start the new activity
        startActivity(log);

    }
    public void alert(View view){
        Intent log = new Intent(docscreen.this, alert.class);

        // Start the new activity
        startActivity(log);
    }
    public void nt(View view){
        Intent log = new Intent(docscreen.this, wv2.class);

        // Start the new activity
        startActivity(log);
    }
}
