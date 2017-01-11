package com.example.administrator.retrofitdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.administrator.retrofitdemo.bean.QQData;
import com.example.administrator.retrofitdemo.interfac.RequestAPI;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void requestbaidu(View view) {
        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://www.baidu.com").addConverterFactory(ScalarsConverterFactory.create()).build();
        RequestAPI requestAPI = retrofit.create(RequestAPI.class);
        Call<String> baiDu = requestAPI.getBaiDu("http://www.baidu.com");
        baiDu.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Toast.makeText(MainActivity.this, "--"+response.body(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Toast.makeText(MainActivity.this, "--"+t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }

    public void baiduzhidao(View view) {
        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://zhidao.baidu.com/").addConverterFactory(ScalarsConverterFactory.create()).build();
        RequestAPI requestAPI = retrofit.create(RequestAPI.class);
        Call<String> baiDu = requestAPI.baiduZhiDao("view");
        baiDu.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                Toast.makeText(MainActivity.this, "--"+response.body(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Toast.makeText(MainActivity.this, "--"+t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }

    public void getQQData(View view) {
        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://japi.juhe.cn/").addConverterFactory(ScalarsConverterFactory.create()).build();
        RequestAPI requestAPI = retrofit.create(RequestAPI.class);
        Call<QQData> qqData = requestAPI.getQQData("96efc220a4196fafdfade0c9d1e897ac", "295424589");
        qqData.enqueue(new Callback<QQData>() {
            @Override
            public void onResponse(Call<QQData> call, Response<QQData> response) {
                QQData data = response.body();
                String conclusion = data.getResult().getData().getConclusion();
                Toast.makeText(MainActivity.this, "--"+conclusion, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<QQData> call, Throwable t) {
                Toast.makeText(MainActivity.this, "--"+t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });

    }

    public void postQQData(View view) {

    }

    public void getQQData2(View view) {

    }

    public void postQQData2(View view) {

    }
}
