package com.codezjx.dribbbledroid.network;

import com.codezjx.dribbbledroid.BuildConfig;
import com.codezjx.dribbbledroid.network.interceptor.HeaderInterceptor;
import com.facebook.stetho.okhttp3.StethoInterceptor;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by codezjx on 2016/6/13.<br/>
 * Manager object to control dribbble api and so on...
 */
public class DribbbleManager {

    private static volatile DribbbleManager sInstance;
    private DribbbleApi mDribbbleApi;

    private DribbbleManager() {
        initDribbbleApi();
    }

    public static DribbbleManager getInstance() {
        if (sInstance == null) {
            synchronized (DribbbleManager.class) {
                if (sInstance == null) {
                    sInstance = new DribbbleManager();
                }
            }
        }
        return sInstance;
    }

    private void initDribbbleApi() {
        if (mDribbbleApi == null) {
            OkHttpClient.Builder clientBuilder = new OkHttpClient.Builder()
                    .addInterceptor(new HeaderInterceptor(getAccessToken()));
            // Enable stetho interceptor just in debug mode
            if (BuildConfig.DEBUG) {
                clientBuilder.addNetworkInterceptor(new StethoInterceptor());
            }
            Retrofit.Builder retrofitBuilder = new Retrofit.Builder()
                    .baseUrl(DribbbleApi.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .client(clientBuilder.build());
            mDribbbleApi = retrofitBuilder.build().create(DribbbleApi.class);
        }
    }

    public DribbbleApi getDribbbleApi() {
        return mDribbbleApi;
    }

    private String getAccessToken() {
        return BuildConfig.DRIBBBLE_CLIENT_ACCESS_TOKEN;
    }
}
