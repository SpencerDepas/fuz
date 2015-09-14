package com.clear.faun.fuzzyapp.Model;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;
import retrofit.http.Headers;
import retrofit.http.Path;

/**
 * Created by spencer on 9/8/2015.
 */
public interface RetrofitFuzzAPI {


    @GET("/quizzes/mobile/1/data.json")//here is the other url part.best way is to start using /
    public void getFeed( Callback <List<FuzzPOJO>> response);

}
