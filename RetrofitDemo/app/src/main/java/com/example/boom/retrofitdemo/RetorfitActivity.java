package com.example.boom.retrofitdemo;

import android.util.Log;
import android.widget.Button;

import com.example.boom.retrofitdemo.base.BaseActivity;
import com.example.boom.retrofitdemo.bean.Weather;
import com.example.boom.retrofitdemo.retrofit.GetInfoService;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Created by Boom on 2017/2/8.
 */

@EActivity(R.layout.activity_retorfit)
public class RetorfitActivity extends BaseActivity {
    @ViewById(R.id.get_id)
    Button get_id;

    @Click(R.id.get_id)
    void getIdInfo() {
        Retrofit retrofit =new Retrofit.Builder()
                .baseUrl("http://jisutqybmf.market.alicloudapi.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        GetInfoService gitHubService=retrofit.create(GetInfoService.class);
        gitHubService.listRepos().enqueue(new Callback<Weather>() {
            @Override
            public void onResponse(Call<Weather> call, Response<Weather> response) {
                Log.d("", "onResponse: "+response);
            }

            @Override
            public void onFailure(Call<Weather> call, Throwable t) {

            }
        });
    }

}
