package com.example.mepositry;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;



import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Signup extends AppCompatActivity implements AdapterView.OnItemSelectedListener{
    public static String name, email, phnnum, dept,sex,pass,height,weight,school,agee,status;
    public static int w,l;
    public static float h,bmi;
    public static String namee, service, phnum, emails,branch;
    private Spinner spinner,spinnerone;
    //Button btnDatePicker, btnTimePicker, btnservicee;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        // spinner = findViewById(R.id.spinner);
        //ArrayAdapter<CharSequence> bb = ArrayAdapter.createFromResource(this, R.array.Department, android.R.layout.simple_spinner_item);
        //bb.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //spinner.setAdapter(bb);
        //spinner.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);
        //spinnerone = findViewById(R.id.spinnertwo);
        //ArrayAdapter<CharSequence> cc = ArrayAdapter.createFromResource(this, R.array.Year, android.R.layout.simple_spinner_item);
        //cc.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //spinnerone.setAdapter(cc);
        //spinnerone.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);

        Spinner spin = (Spinner) findViewById(R.id.spinner);
        //ArrayAdapter<String> aa = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item, Depa);
        ArrayAdapter<CharSequence> bb = ArrayAdapter.createFromResource(this, R.array.sex, android.R.layout.simple_spinner_item);
        bb.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spin.setAdapter(bb);
        // spin.setOnItemSelectedListener(new CountriesSpinnerClass());
        spin.setOnItemSelectedListener(this);


    }
    public void login(View view) {
        EditText text2 = (EditText) findViewById(R.id.input_name);
        name = text2.getText().toString();
        EditText t = (EditText) findViewById(R.id.input_email);
        email = t.getText().toString();
        EditText text3 = (EditText) findViewById(R.id.input_num);
        phnnum = text3.getText().toString();
        EditText text4 = (EditText) findViewById(R.id.input_height);
        height = text4.getText().toString();
        EditText text5 = (EditText) findViewById(R.id.input_weight);
        weight = text5.getText().toString();
        EditText text6 = (EditText) findViewById(R.id.input_school);
        school = text6.getText().toString();
        EditText text7 = (EditText) findViewById(R.id.input_password);
        pass = text7.getText().toString();
        EditText text8 = (EditText) findViewById(R.id.input_age);
        agee = text8.getText().toString();
        h = Float.valueOf(height);
        w=Integer.parseInt(weight);
        bmi=(w/(h*h));

        //Log.v("po", bmi);
        if(name.length()==0||email.length()==0||phnnum.length()<10||phnnum.length()>10)
        {
            Toast.makeText(this, "please enter all the fields", Toast.LENGTH_SHORT).show();
        }

        else {
            Signupresponse hu = new Signupresponse(this.getApplicationContext());
            hu.execute();

        }
    }




    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        if(adapterView.getId() == R.id.spinner)
        {
            sex=adapterView.getItemAtPosition(i).toString();
        }
       // else if(adapterView.getId() == R.id.spinnertwo)
       // {
        //    sem=adapterView.getItemAtPosition(i).toString();

       // }
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }


}

