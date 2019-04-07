package com.gkskfhdlstmapk.hanpinetree.bcsd_mvcpattern;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class WebViewActivity extends Fragment {
    private View mView;
    private WebView webView;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        mView = inflater.inflate(R.layout.activity_web_view, null);
        webView = (WebView)mView.findViewById(R.id.activity_web_view_webview);

        WebSettings webSettings = webView.getSettings();
        webView.loadUrl("https://www.google.com");


        return mView;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_web_view);
    }

}
