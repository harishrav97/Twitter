package com.example.twitter.Retrofit;

import com.example.twitter.Response.TwitterResponse;

import retrofit2.Call;
import retrofit2.http.GET;

import static com.example.twitter.Constants.PATH;

public interface ApiRequest {
    @GET(PATH)
    Call<TwitterResponse> getTweetList();
}
