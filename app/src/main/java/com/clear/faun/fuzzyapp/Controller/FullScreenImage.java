package com.clear.faun.fuzzyapp.Controller;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.clear.faun.fuzzyapp.R;

/**
 * Created by spencer on 9/8/2015.
 */
public class FullScreenImage extends AppCompatActivity {

    private String imageURL;
    private ImageView imageview;
    private Context mContext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.full_screen_image);
        Log.i("MyFullScreenImage", "onCreateViewHolder");


        final Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        mContext = getApplicationContext();
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if(extras == null) {
                imageURL = null;
            } else {
                imageURL = extras.getString("URL");
            }
        } else {
            imageURL= (String) savedInstanceState.getSerializable("URL");
        }

        imageview = (ImageView) findViewById(R.id.big_image_view);

        //imageview.setImageResource(R.drawable.fuzz_logo);


        Glide.with(mContext)
                .load(imageURL)
                .crossFade()
                .placeholder(R.drawable.fuzz_logo)
                .into(imageview);




        Log.i("MyFullScreenImage", "imageURL : " + imageURL);

        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });






    }









}
