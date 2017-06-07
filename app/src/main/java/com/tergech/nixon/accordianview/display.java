package com.tergech.nixon.accordianview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.webkit.WebView;
import android.widget.TextView;

/**
 * Created by Tonui on 6/7/2017.
 */

public class display extends AppCompatActivity {
    TextView tvDisplay;
    WebView webView;
    String topichead;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display);
        tvDisplay=(TextView) findViewById(R.id.tvDisplay);
        webView=(WebView) findViewById(R.id.webview);
        //getting the data passed from the other activity
        Intent intent=getIntent();
        Bundle bundle=intent.getExtras();
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);
        topichead=bundle.getString("topichead");
        this.setTitle(topichead);

        String data=bundle.getString("data");

        tvDisplay.setText(data);
        webView.loadUrl(“file:///android_asset/help/help.html”);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                display.this.finish();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }

    }


}
