package com.example.mchp.api;

import android.app.Application;

import com.example.mchp.api.UmoriliApi;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class App extends Application {

    private UmoriliApi umoriliApi;
    private Retrofit retrofit;

    @Override
    public void onCreate() {
        super.onCreate();

        Gson gson = new GsonBuilder().setLenient().create();
        retrofit = new Retrofit.Builder().baseUrl("http://umorili.herokuapp.com")
                .addConverterFactory(GsonConverterFactory.create(gson)).build();
        umoriliApi = retrofit.create(UmoriliApi.class);
    }

    public UmoriliApi getUmoriliApi() {
        return umoriliApi;
    }
}
