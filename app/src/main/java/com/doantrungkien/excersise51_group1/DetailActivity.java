package com.doantrungkien.excersise51_group1;

import androidx.appcompat.app.AppCompatActivity;
import android.webkit.WebView;
import android.util.Log;
import android.webkit.WebViewClient;

import android.os.Bundle;

public class DetailActivity extends AppCompatActivity {

    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_activity_layout);

        webView = findViewById(R.id.webView);

        webView.getSettings().setJavaScriptEnabled(true); // Bật JavaScript nếu cần thiết
        webView.getSettings().setDomStorageEnabled(true); // Bật lưu trữ DOM nếu cần thiết

        // Xử lý các sự kiện trong WebViewClient
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
                Log.e("WebView Error", "Error code: " + errorCode + ", Description: " + description);
            }
        });

        String url = getIntent().getStringExtra("url");
        if (url != null) {
            webView.loadUrl(url);
        }
    }
}

