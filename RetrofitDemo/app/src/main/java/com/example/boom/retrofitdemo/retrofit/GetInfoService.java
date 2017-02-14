package com.example.boom.retrofitdemo.retrofit;

import com.example.boom.retrofitdemo.bean.Weather;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;

/**
 * Created by Boom on 2017/2/14.
 */

public interface GetInfoService {
    @Headers("Authorization:APPCODE 8fe7629b82174d51a9a32144e7c69b8d")
    @GET("/weather/city")
    Call<Weather> listRepos();

    @GET("/weather/city")
    Call<Weather> listRepos1(@Header("Authorization") String authorization);
}
