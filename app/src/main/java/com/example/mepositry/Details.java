package com.example.mepositry;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
public class Details extends AppCompatActivity {
    String dist = "45";
    String query = "";
    SearchView searchView;
    RecyclerView recyclerView;
    RecyclerView.Adapter mAdapter;
    RecyclerView.LayoutManager layoutManager;
    public String e_mail = loginscreen.emails;
    public String password = loginscreen.password;
    RequestQueue rq;
    public String name, gender, email, pass, age, school, phone, height, weight, bmi, ph, pulse, ur, br, er;
    String request_url = "http://bulbcontrol.000webhostapp.com/rakathon/disp_book.php?search=";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
       // rq = Volley.newRequestQueue(this);
        //sendRequest();
        detresponse hu = new detresponse(this.getApplicationContext());
        hu.execute();
       // TextView tv = (TextView) findViewById(R.id.texty);
       // tv.setText(name + gender);


    }
    public void gen(View view)
    {
        Intent log = new Intent(Details.this, generated.class);

        // Start the new activity
        startActivity(log);
    }



}





