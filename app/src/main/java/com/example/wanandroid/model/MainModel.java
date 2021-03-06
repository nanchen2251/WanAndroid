package com.example.wanandroid.model;

import com.example.wanandroid.bean.BannerBean;
import com.example.wanandroid.contract.Contract;
import com.example.wanandroid.retrofit.IRetrofitData;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainModel implements Contract.IMainModel {
    private static final String BASE_URL = "https://www.wanandroid.com/";

    @Override
    public Observable<BannerBean> loadBanner() {
        Retrofit retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        IRetrofitData retrofitData = retrofit.create(IRetrofitData.class);

        return retrofitData.loadBanner();
    }
}
