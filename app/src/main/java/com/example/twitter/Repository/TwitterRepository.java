package com.example.twitter.Repository;

import android.os.StrictMode;

import com.example.twitter.Model.TwitterModel;
import com.example.twitter.Retrofit.ApiRequest;
import com.example.twitter.Retrofit.RetrofitRequest;

import java.io.IOException;
import java.util.List;

public class TwitterRepository {
    private static TwitterRepository instance;
    private ApiRequest apiRequest;
    public TwitterRepository() {
        apiRequest = RetrofitRequest.getRetrofitInstance().create(ApiRequest.class);
    }
    public static TwitterRepository getInstance(){
        if(instance == null){
            instance = new TwitterRepository();
        }
        return instance;
    }
    public List<TwitterModel> getTweetDetails(){
        avoidNetworkOSThreadException();
        List<TwitterModel> response = null;
        try {
            response= apiRequest.getTweetList().execute().body().getData();
            System.out.println("####"+response.get(0).getName());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }
    public static void avoidNetworkOSThreadException() {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
    }
}
