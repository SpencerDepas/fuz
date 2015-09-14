package com.clear.faun.fuzzyapp.Model;

import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;
import retrofit.converter.GsonConverter;

/**
 * Created by spencer on 9/8/2015.
 */
public class CallAndParse {


    public FuzzResponse delegate = null;

    private final String API = "http://quizzes.fuzzstaging.com";


    public CallAndParse(){


        Log.d("MyCallAndParse", "CallAndParse   ");
        Gson gson = new GsonBuilder()
                .create();


        //Retrofit
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(API)
              //.setLogLevel(RestAdapter.LogLevel.FULL)
                .setConverter(new GsonConverter(gson))
                .build();



        RetrofitFuzzAPI fuzzAPI = restAdapter.create(RetrofitFuzzAPI.class);


        fuzzAPI.getFeed(new Callback<List<FuzzPOJO>>() {


            @Override
            public void success(List<FuzzPOJO> fuzzPOJO, Response response) {

                Log.d("MyCallAndParse", "success");



                /*for(int i = 0; i < imgurContainers.getImgurData().size(); i ++){
                    Log.i("MyCallAndParse", "dC " + imgurContainers.getImgurData().get(i).getLink());
                }*/



                delegate.processFinish(fuzzPOJO);
            }

            @Override
            public void failure(RetrofitError error) {
                Log.d("MyCallAndParse", "error  " + error);
            }



        });



    }

}
