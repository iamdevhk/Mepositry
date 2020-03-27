package com.example.mepositry;

import android.content.Intent;
import android.graphics.Bitmap;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Environment;
import android.os.StrictMode;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class generated extends AppCompatActivity {
    prooductadapter adapter;
    TextView NewText;
    //a list to store all the products
    public String result = "";
    public int hk = 0;
    public List<Prooduct> productList;
    public List<Prooduct> productLists;
    //the recyclerview
    int id1 = 1;
    int r1 = 3;
    String dist = "45";
    String query = "";
    SearchView searchView;
    RecyclerView recyclerView;
    RecyclerView.Adapter mAdapter;
    RecyclerView.LayoutManager layoutManager;
    // RequestQueue rq;
    public String titl = "", author = "", credits = "", mail = "";
    public int sno;
    //private qrDbHelper mDbHelper;
    // public String result = "";
    Bitmap bitmap;
    Uri uri = null;
    public String email = detresponse.email;
    public String gender = detresponse.gender;
    public String name = detresponse.name;
    public String age = detresponse.age;
    public String school = detresponse.school;
    public String phone = detresponse.phone;
    public String height = detresponse.height;
    public String weight = detresponse.weight;
    public float bmi = Float.parseFloat(detresponse.bmi);
    public String ph = detresponse.ph;
    public String pulse = detresponse.pulse;
    public String ur = detresponse.ur;
    public String br = detresponse.br;
    public String er = detresponse.er;
    public String status ="";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_generated);
        TextView tv = (TextView) findViewById(R.id.texty);
     /*   tv.setText("email" + email + "\n" +
                "gender" + gender + "\n" +
                "name: " + name + "\n" +
                "age" + age + "\n" +
                "school : " + school + "\n" +
                "phone : " + phone + "\n" +
                "height : " + height + "\n" +
                "weight:" + weight + "\n" +
                "bmi:" + bmi + "\n" +
                "ph:" + ph + "\n" +
                "pulse:" + pulse + "\n" +
                "Blood report :" + br + "\n" +
                "urine report:" + ur + "\n" +
                "eye test:" + er + "\n");*/
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        layoutManager = new LinearLayoutManager(this);
        //searchView = (SearchView) findViewById(R.id.searchView);
        recyclerView.setLayoutManager(layoutManager);
        //initializing the productlist
        //productList = new ArrayList<>();
        productLists = new ArrayList<>();
        call();
        life();

        result = "email" + email + "\n" +
                "gender" + gender + "\n" +
                "name: " + name + "\n" +
                "age" + age + "\n" +
                "school : " + school + "\n" +
                "phone : " + phone + "\n" +
                "height : " + height + "\n" +
                "weight:" + weight + "\n" +
                "bmi:" + bmi + "\n" +
                "ph:" + ph + "\n" +
                "pulse:" + pulse + "\n" +
                "Blood report :" + br + "\n" +
                "urine report:" + ur + "\n" +
                "eye test:" + er + "\n";
        ImageView ht = (ImageView) findViewById(R.id.ht);
        // Whatever you need to encode in the QR code
        StrictMode.VmPolicy.Builder builder = new StrictMode.VmPolicy.Builder();
        StrictMode.setVmPolicy(builder.build());
        ;
        MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
        try {
            BitMatrix bitMatrix = multiFormatWriter.encode(result, BarcodeFormat.QR_CODE, 200, 200);
            BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
            bitmap = barcodeEncoder.createBitmap(bitMatrix);
            ht.setImageBitmap(bitmap);
        } catch (WriterException e) {
            e.printStackTrace();
        }
        Button button = findViewById(R.id.htg);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                ImageView imageView = findViewById(R.id.ht);


                saveImage(bitmap);

                send(uri);

            }


        });
    }

    private Uri saveImage(Bitmap image) {
        //TODO - Should be processed in another thread
        File imagesFolder = new File(getCacheDir(), "images");

        try {
            imagesFolder.mkdirs();
            File file = new File(imagesFolder, "shared_image.png");

            FileOutputStream stream = new FileOutputStream(file);
            image.compress(Bitmap.CompressFormat.PNG, 90, stream);
            stream.flush();
            stream.close();
            uri = FileProvider.getUriForFile(this, "com.example.mepositry.provider", file);
        } catch (Exception e) {
            //Log.d(TAG, "IOException while trying to write file for sharing: " + e.getMessage());
        }
        return uri;
    }

    private void send(Uri uri) {
        Intent intent = new Intent(android.content.Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_STREAM, uri);
        intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        intent.setType("image/png");
        startActivity(Intent.createChooser(intent, "Share using"));
        //startActivity(intent);
    }

    public void downloads(View view) {
        SaveImage(bitmap);
    }

    private void SaveImage(Bitmap finalBitmap) {
        Toast.makeText(this, "Your QR-Code is successfully downloaded", Toast.LENGTH_SHORT).show();
        String root = Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_PICTURES).toString();
        File myDir = new File(root + "/qr_codes");
        myDir.mkdirs();
        Random generator = new Random();

        int n = 10000;
        n = generator.nextInt(n);
        String fname = "Image-" + n + ".jpg";
        File file = new File(myDir, fname);
        if (file.exists()) file.delete();
        try {
            FileOutputStream out = new FileOutputStream(file);
            finalBitmap.compress(Bitmap.CompressFormat.JPEG, 90, out);
            // sendBroadcast(new Intent(Intent.ACTION_MEDIA_MOUNTED,
            //     Uri.parse("file://"+ Environment.getExternalStorageDirectory())));
            out.flush();
            out.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
// Tell the media scanner about the new file so that it is
// immediately available to the user.
        MediaScannerConnection.scanFile(this, new String[]{file.toString()}, null,
                new MediaScannerConnection.OnScanCompletedListener() {
                    public void onScanCompleted(String path, Uri uri) {
                        Log.i("ExternalStorage", "Scanned " + path + ":");
                        Log.i("ExternalStorage", "-> uri=" + uri);
                    }
                });
    }

    public void addsin() {
        productList = new ArrayList<>();
        productList.add(
                new Prooduct(
                        1,
                        "Name: "+name,
                        "Gender: "+gender,
                       "E-mail: "+email,
                        "Age: "+age,
                        "School: "+school,
                        "Phone: "+phone,
                        "Height: "+height,
                       "Weight: "+weight,
                        "Bmi: "+bmi ,
                        "Phone no: "+ph,
                       "Pulse: "+ pulse,
                       "Blood report:"+ br,
                       "Urine report: " +ur,
                        "Eye report: "+er

                ));
    }
    public void call(){
        addsin();
        adapter = new prooductadapter(this, productList);
        // Log.v("kk",productList.get(0).getTitle());
        //setting adapter to recyclerview
        recyclerView.setAdapter(adapter);

    }
    public void life()
    {NewText = (TextView)findViewById(R.id.texj);
        if(bmi<18.5){
            NewText.setText("BMI REPORT: "+"Underweight");
        }
        if(bmi>18.5&&bmi<24.9){
            //status="Healthy";
            NewText.setText("BMI REPORT: "+"Healthy");
        }
        if(bmi>25&&bmi<29.9){
            //status="Overweight";
            NewText.setText("BMI REPORT: "+"Overweight");
        }
        if(bmi>30)
        {
            //status="obese";
            NewText.setText("BMI REPORT: "+"Obese");
        }

    }
}
