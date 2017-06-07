package com.tergech.nixon.accordianview;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by Tonui on 6/7/2017.
 */

public class display extends AppCompatActivity {
    TextView tvDisplay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display);
        tvDisplay=(TextView) findViewById(R.id.tvDisplay);
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        actionBar.setHomeButtonEnabled(true);
        actionBar.setDisplayHomeAsUpEnabled(true);

        //getting the data passed from the other activity
        Intent intent=getIntent();
        Bundle bundle=intent.getExtras();
        String data=bundle.getString("data");
        tvDisplay.setText(data);
    }
}
