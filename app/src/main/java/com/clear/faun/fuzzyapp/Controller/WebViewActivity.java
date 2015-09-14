package com.clear.faun.fuzzyapp.Controller;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.clear.faun.fuzzyapp.R;

/**
 * Created by spencer on 9/8/2015.
 */
public class WebViewActivity extends AppCompatActivity {


    final String REGISTER_TO_VOTE_URL = "https://fuzzproductions.com/";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.web_view);

        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        WebView wv = (WebView) findViewById(R.id.webview);
        //wv.getSettings().setJavaScriptEnabled(true);
        wv.setWebViewClient(new WebViewClient());
        wv.loadUrl(REGISTER_TO_VOTE_URL);



    }





    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Log.d("MyPoliticianDetail", "onOptionsItemSelected");

        Log.d("MyPoliticianDetail", "item.getItemId():" + item.getItemId());

        switch (item.getItemId()) {

            /*case R.id.fuzz_id:
                this.finish();
                return true;*/
        }

        return super.onOptionsItemSelected(item);

    }



}
