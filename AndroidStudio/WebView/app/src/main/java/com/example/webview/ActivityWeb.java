package com.example.webview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class ActivityWeb extends AppCompatActivity {

    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        webView = (WebView)findViewById(R.id.webView);
        String dato = getIntent().getStringExtra("url");

        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("http://" + dato);
    }

    public void cerrar(View view){
        finish();
    }
}
