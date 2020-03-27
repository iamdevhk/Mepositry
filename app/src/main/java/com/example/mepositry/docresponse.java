package com.example.mepositry;





import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;
import org.json.JSONException;
import org.json.JSONObject;




public class docresponse extends AsyncTask<Void, Void, Void> {
    Context context; //context for opening intents from afterexecute
    public int vj = MainActivity.user;
    public String url="";
    public docresponse(Context context) {
        this.context = context;
    }


    public static String response="";

    public String e_mail=loginscreen.emails;
    public  String password=loginscreen.password;

    public int hk=0;

    @Override
    protected Void doInBackground(Void... voids) {
        Log.v("Hk", "Back");
        HttpHandler sh = new HttpHandler();
        // Making a request to url and getting response



        url = "https://myhkdev.000webhostapp.com/login.php?user="+ e_mail+"&pass="+ password;

        hk=1;
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


            Toast.makeText(this.context, "Logged in Successfully", Toast.LENGTH_SHORT).show();
            context.startActivity(new Intent(context, docscreen.class));//the website should return the samed number if theres no entry for it
        }
        if(response.equals("0")) {


            Toast.makeText(this.context, "Logged in failed", Toast.LENGTH_SHORT).show();
            //context.startActivity(new Intent(context, Component.class));//the website should return the samed number if theres no entry for it
        }

    }

}

