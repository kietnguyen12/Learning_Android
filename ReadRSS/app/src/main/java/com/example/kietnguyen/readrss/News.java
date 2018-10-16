package com.example.kietnguyen.readrss;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class News extends AppCompatActivity {
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        Intent intent = getIntent();
        String url = intent.getStringExtra("linkTinTuc");
//        Toast.makeText(this, url, Toast.LENGTH_LONG).show();
        webView = findViewById(R.id.webviewTinTuc);
        webView.loadUrl(url);

        //cai dat de nguoi dung co nhap vao URL moi trong giao dien van o trong app
        webView.setWebViewClient(new WebViewClient());
    }
}
