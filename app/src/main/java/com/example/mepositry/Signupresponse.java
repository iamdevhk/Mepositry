package com.example.mepositry;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;
import org.json.JSONException;
import org.json.JSONObject;




public class Signupresponse extends AsyncTask<Void, Void, Void> {
    Context context; //context for opening intents from afterexecute

    public Signupresponse(Context context) {
        this.context = context;
    }


    public static String response="";
    public String name=Signup.name;
    public String email=Signup.email;
    public String phnnum=Signup.phnnum;
    public String password=Signup.pass;
    public String height=Signup.height;
    public String sex=Signup.sex;
    public String weight=Signup.weight;
    public String school=Signup.school;
    public String age=Signup.agee;
    public float bmi=Signup.bmi;
    public static String hk="";

    @Override
    protected Void doInBackground(Void... voids) {
        Log.v("Hk", "Back");
        HttpHandler sh = new HttpHandler();
        // Making a request to url and getting response


        String url ="https://myhkdev.000webhostapp.com/stusignup.php?name="+ name+"&gender="+ sex+"&user="+ email+"&pass="+ password+"&age="+ age+"&school="+ school+"&phn="+ phnnum+"&height="+ height+"&weight="+ weight+"&bmi="+bmi;
        //hk=0;
        //hk=1;
        Log.v("Hk", url);
        String jsonStr = sh.makeServiceCall(url);

        if (jsonStr != null) {
            try {
                JSONObject jsonObj = new JSONObject(jsonStr);
                Log.v("po", jsonStr);
                response =jsonObj.getString("status");
                Log.v("po", response);

            } catch (final JSONException e) {
                Log.e("MainActivity", "Json parsing error: " + e.getMessage());
            }

        } else {
            Log.e("MainActivity", "Couldn't get json from server.");
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {

        if(response.equals("1")) {


            Toast.makeText(this.context, "sign in Successfully", Toast.LENGTH_SHORT).show();
            context.startActivity(new Intent(context, loginscreen.class));//the website should return the samed number if theres no entry for it
        }
        if(response.equals("0")) {


            Toast.makeText(this.context, "signup failed", Toast.LENGTH_SHORT).show();
            context.startActivity(new Intent(context, Signup.class));//the website should return the samed number if theres no entry for it
        }

    }

}


