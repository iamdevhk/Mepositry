package com.example.mepositry;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class wv2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ei);
        WebView myWebView = (WebView) findViewById(R.id.webview);
        myWebView.loadUrl("http://mighty-savannah-74300.herokuapp.com/");
    }
}
