package com.example.administrator.retrofitdemo.interfac;

import com.example.administrator.retrofitdemo.bean.QQData;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Url;

/**
 * Created by ${郭艳杰} on 2017/1/11.
 */

public interface RequestAPI {
    @GET
    Call<String> getBaiDu(@Url String url);
    @GET("daily/{v}")
    Call<String> baiduZhiDao(@Path("v") String v);
    @GET("qqevaluate/qq")
    Call<QQData> getQQData(@Query("key") String key,@Query("qq") String qq);
}
