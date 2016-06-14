package com.codezjx.dribbbledroid.network.interceptor;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by codezjx on 2016/6/14.<br/>
 * Interceptor that add the oauth header for all request.
 */
public class HeaderInterceptor implements Interceptor{

    private String mAccessToken;

    public HeaderInterceptor(String accessToken) {
        mAccessToken = accessToken;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        // Add request headers
        final Request request = chain.request().newBuilder()
                .addHeader("Authorization", "Bearer " + mAccessToken)
                .build();
        return chain.proceed(request);
    }

}
