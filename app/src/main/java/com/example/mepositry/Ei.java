package com.example.mepositry;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class Ei extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ei);
        WebView myWebView = (WebView) findViewById(R.id.webview);
        myWebView.loadUrl("http://emotional-intelligence-test.herokuapp.com/");
    }
}
