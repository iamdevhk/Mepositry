package com.example.mepositry;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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



import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;



public class HealthGuide extends AppCompatActivity {
    ProductAdapter adapter;
    //a list to store all the products
    public  String result="";
    public int hk=0;
    public List<Product> productList;
    public List<Product> productLists;
    //the recyclerview
    int id1=1;
    int r1=3;
    String dist="45";
    String query="";
    SearchView searchView;
    RecyclerView recyclerView;
    RecyclerView.Adapter mAdapter;
    RecyclerView.LayoutManager layoutManager;
    // RequestQueue rq;
    public String titl="",author="",credits="",mail="";
    public int sno;
    //private qrDbHelper mDbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_guide);
        // To access our database, we instantiate our subclass of SQLiteOpenHelper
        // and pass the context, which is the current activity.
        //mDbHelper = new qrDbHelper(this);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        layoutManager = new LinearLayoutManager(this);
        //searchView = (SearchView) findViewById(R.id.searchView);
        recyclerView.setLayoutManager(layoutManager);
        //initializing the productlist
        //productList = new ArrayList<>();
        productLists = new ArrayList<>();
        //addsin();
        call();

    }
    public void addsin()
    {productList = new ArrayList<>();
        productList.add(
                new Product(
                        1,
                        "1.Underweight:",
                        "Have 5-6 mini meals instead of 3 meals.\n" +
                                "Fried and baked products like bakery products and chips can help in improving calorie intake.\n" +
                                "Inclusion of dairy products like milk, butter and ghee.\n"
                ));
        productList.add(
                new Product(
                        2,
                        "2.Overweight:",
                        "Whole grain and fruit intake.\n" +
                                "Avoid chicken and mutton. Prefer fish.\n" +
                                "Avoid drinking carbonated drinks. Instead drink fresh juices.\n" +
                                "Avoid fried and baked products like bakery products and chips.\n" +
                                "Exercise daily.\n"
                ));
        productList.add(
                new Product(
                        3,
                        "3.\tHaemoglobin:",
                        "Iron rich content intake.\n" +
                                "Dried fruits like dates,raisins,apricot.\n"
                ));
        productList.add(
                new Product(
                        4,
                        "4.\tRed Blood Cells deficiency(RBC):",
"Dried fruits like dates,raisins,apricot.\n" +
        "Pomegranate, Watermelon\n" +
        "Mushroom,Tomatoes,Beans\n" +
        "Pulses and nuts\n"                )

        );
        productList.add(
                new Product(
                        5,
                        "5.\tWhite Blood Cells deficiency(WBC):" ,
"Garlic\n" +
        "Ginger\n" +
        "Spinach \n" +
        "Almond\n" +
        "Papaya\n"                )
        );
        productList.add(
                new Product(
                        6,
                        "6.\tAnaemia:" ,
                        "Iron rich content intake\n" +
                                "\tSpinach\n" +
                                "\tBeans like peas and soybeans\n" +
                                "\tNuts and seeds\n" +
                                "\tRestrict meat consumption. Instead consume seafood\n"
                )
        );
        productList.add(
                new Product(
                        7,
                        "7.\tCholestrol:" ,
                        "Avacado\n" +
                                "Kidney beans\n" +
                                "Avoid fried items.\n"
                )
        );
        productList.add(
                new Product(
                        8,
                        "8.\tUric acid:" ,
                        "Fruits\n" +
                                "Garlic\n"
                )
        );
        productList.add(
                new Product(
                        9,
                        "9.\tHigh Erythrocyte Sedimentation Rate (ESR):" ,
                        "Blueberries\n" +
                                "\tPineapple\n" +
                                "\tTurmeric\n" +
                                "\tFlax Seeds\n" +
                                "\tSpinach\n"
                )
        );

        productList.add(
                new Product(
                        10,
                        "10.\tCalcium Deficiency:" ,
                        "Milk\n" +
                                "\tCheese\n" +
                                "\tBeans and lentils\n" +
                                "\tDried fig\n" +
                                "\tSesame\n" +
                                "\tCelery\n"
                )
        );

        productList.add(
                new Product(
                        11,
                        "11.\tFlouride Deficiency:" ,
                        "Fruit juice\n" +
                                "\tRaisins\n" +
                                "\tTea\n"
                )
        );
        productList.add(
                new Product(
                        12,
                        "12.\tVitamin A Deficiency:" ,
                        "Egg\n" +
                                "\tPumpkin\n" +
                                "\tMango\n" +
                                "\tWatermelon\n" +
                                "\tMilk\n" +
                                "\tButter\n" +
                                "\tFish liver oil capsule\n" +
                                "\tCarrot\n" +
                                "\tSpinach\n" +
                                "\tSweet Potato\n"
                )
        );
        productList.add(
                new Product(
                        13,
                        "13.\tVitamin B deficiency:" ,
                        "Cereals\n" +
                                "\tBeans\n" +
                                "\tEgg\n"
                )
        );
        productList.add(
                new Product(
                        14,
                        "14.\tVitamin C deficiency:" ,
                        "Papaya\n" +
                                "\tGuava\n" +
                                "\tLemon\n" +
                                "\tOrange\n" +
                                "\tCabbage\n" +
                                "\tPotato\n"
                )
        );
        productList.add(
                new Product(
                        15,
                        "15.\tVitamin D deficiency:" ,
                        "Cheese\n" +
                                "\tEgg yolk\n" +
                                "\tFish\n" +
                                "\tCereals\n"
                )
        );
        productList.add(
                new Product(
                        16,
                        "16.\tVitamin E deficiency:" ,
                        "Nuts\n" +
                                "\tEgg yolk\n" +
                                "\tMango\n" +
                                "\tMilk\n" +
                                "\tCheese\n"
                )
        );
        productList.add(
                new Product(
                        17,
                        "17.\tVitamin K deficiency:" ,
                        "Brocoli\n" +
                                "\tCabbage\n" +
                                "\tMilk\n" +
                                "\tCheese\n" +
                                "\tAsparagus\n"
                )
        );
        productList.add(
                new Product(
                        18,
                        "18.\tDiarrhea:" ,
                        "Banana\n" +
                                "\tPlain white rice" +
                                "\tBread\n" +
                                "\tCoconut water\n" +
                                "\tAvoid fried foods\n" +
                                "\tAvoid onion, garlic, cabbage and cauliflower\n"
                )
        );
        productList.add(
                new Product(
                        19,
                        "19.\tDiabetes:" ,
                        "Fish\n" +
                                "\tSpinach\n" +
                                "\tKale\n" +
                                "\tEggs\n"
                                +
                                "\tTurmeric\n" +
                                "\tAlmonds\n" +
                                "\tCashews\n" +
                                "\tWalnuts\n" +
                                "\t Brocoli\n" +
                                "\tGarilc\n"
                )
        );
        productList.add(
                new Product(
                        20,
                        "20.\tKidney Stone:" ,
                        "Drink plenty of water\n" +
                                "\tAvoid chocholate and tomato\n" +
                                "\tLimit egg, meat and seafood intake\n"
                )
        );
        productList.add(
                new Product(
                        21,
                        "21.\tEye Vision Problem:" ,
                        "Eggs\n" +
                                "\tSpinach\n" +
                                "\tBeans\n" +
                                "\tLemon\n"+
                        "\tOrange\n" +
                                "\tGrapes\n" +
                                "\tCarrot\n"
                )
        );
        productList.add(
                new Product(
                        22,
                        "22.\tHeart problems:" ,
                        "Olive oil\n" +
                                "\tWalnuts\n" +
                                "\tAlmonds\n" +
                                "\tOrange\n" +
                                "\tBarley\n" +
                                "\tOats\n" +
                                "\tFlax seeds\n"
                )
        );

    }




    public void call(){
        addsin();
        adapter = new ProductAdapter(this, productList);
        // Log.v("kk",productList.get(0).getTitle());
        //setting adapter to recyclerview
        recyclerView.setAdapter(adapter);

    }

}
