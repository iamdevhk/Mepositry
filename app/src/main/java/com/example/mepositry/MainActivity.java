package com.example.mepositry;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static int user=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void enter(View view){

        RadioButton stud = (RadioButton) findViewById(R.id.Doctor);
        boolean s = stud.isChecked();
        RadioButton fac = (RadioButton) findViewById(R.id.patient);
        boolean f = fac.isChecked();

        if (s == true) {
            user=1;
            Intent log = new Intent(MainActivity.this, loginscreen.class);

            // Start the new activity
            startActivity(log);

        } else if (f == true) {
            user=0;
            Intent log = new Intent(MainActivity.this, loginscreen.class);

            // Start the new activity
            startActivity(log);
        }
        else
            Toast.makeText(this, "select either one", Toast.LENGTH_SHORT).show();
    }


}
