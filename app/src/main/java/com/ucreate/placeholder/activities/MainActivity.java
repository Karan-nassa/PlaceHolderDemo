package com.ucreate.placeholder.activities;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.ucreate.placeholder.R;
import com.ucreate.placeholder.utils.AppUtils;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.wvWebPage)
    WebView wvWebPage;

    @Bind(R.id.pbLoading)
    ProgressBar pbLoading;

    private String strURL = "https://www.ucreate.it/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        updateUI();
    }

    private void updateUI() {
        if (AppUtils.isOnline(MainActivity.this)) {
            wvWebPage.setWebViewClient(new myWebClient());
            wvWebPage.getSettings().setJavaScriptEnabled(true);
            wvWebPage.getSettings().setBuiltInZoomControls(true);
            wvWebPage.getSettings().setSupportZoom(true);
            wvWebPage.setFocusableInTouchMode(false);
            wvWebPage.setFocusable(false);
            wvWebPage.loadUrl(strURL);
        } else {
            AppUtils.callIntent(MainActivity.this,
                    NoDataActivity.class, false);
        }
    }

    /**
     * Implements a class to Handle and display progress in
     * Web View.
     */
    public class myWebClient extends WebViewClient {
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            super.onPageStarted(view, url, favicon);
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            pbLoading.setVisibility(View.VISIBLE);
            view.loadUrl(url);
            return true;
        }

        @Override
        public void onPageFinished(WebView view, String url) {
            super.onPageFinished(view, url);
            pbLoading.setVisibility(View.GONE);
        }
    }
}
