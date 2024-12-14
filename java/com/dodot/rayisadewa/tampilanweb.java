package com.dodot.rayisadewa;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class tampilanweb extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tampilanweb);
        String alamat="https://sidodot1.wordpress.com/";
        WebView web =(WebView) findViewById(R.id.website);
        web.getSettings().setJavaScriptEnabled(true);
        web.loadUrl(alamat);
        web.setWebViewClient(new WebViewClient());
    }
}