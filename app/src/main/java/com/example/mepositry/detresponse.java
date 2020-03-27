package com.example.mepositry;


import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;
import org.json.JSONException;
import org.json.JSONObject;




public class detresponse extends AsyncTask<Void, Void, Void> {
    Context context; //context for opening intents from afterexecute
    public int vj = MainActivity.user;
    public String url="";
    public detresponse(Context context) {
        this.context = context;
    }

    public static String name, gender, email, pass, age, school, phone, height, weight, bmi, ph, pulse, ur, br, er;
    public static String response="";

    public  String e_mail=loginscreen.emails;
    public String password=loginscreen.password;

    public int hk=0;

    @Override
    protected Void doInBackground(Void... voids) {
        Log.v("Hk", "Back");
        HttpHandler sh = new HttpHandler();
        // Making a request to url and getting response



        url = "https://myhkdev.000webhostapp.com/disp.php?user=" + e_mail + "&pass=" + password;

        hk=1;
        Log.v("Hk", url);
        String jsonStr = sh.makeServiceCall(url);

        if (jsonStr != null) {
            try {
                JSONObject jsonObject = new JSONObject(jsonStr);
                Log.v("po", jsonStr);
                name =jsonObject.getString("name");
                Log.v("po", name);
                gender = jsonObject.getString("gender");
                email = jsonObject.getString("email");
                pass = jsonObject.getString("pass");
                age = jsonObject.getString("age");
                school = jsonObject.getString("school");
                phone = jsonObject.getString("phone");
                height = jsonObject.getString("height");
                weight = jsonObject.getString("weight");
                bmi = jsonObject.getString("bmi");
                ph = jsonObject.getString("ph");
                pulse = jsonObject.getString("pulse");
                ur = jsonObject.getString("ur");
                br = jsonObject.getString("br");
                er = jsonObject.getString("er");

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
        Toast.makeText(this.context, "Logged in Successfully", Toast.LENGTH_SHORT).show();
        context.startActivity(new Intent(context, generated.class));


    }

}

