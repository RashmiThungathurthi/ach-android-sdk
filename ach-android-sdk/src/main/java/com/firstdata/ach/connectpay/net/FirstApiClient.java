package com.firstdata.ach.connectpay.net;


import okhttp3.OkHttpClient;
import retrofit2.CallAdapter;
import retrofit2.Converter;
import retrofit2.Retrofit;

/**
 * Created by Arjun Chinya on 6/12/16.
 */
public class FirstApiClient {

    private Retrofit retrofit;

    public FirstApiClient(OkHttpClient okHttpClient, CallAdapter.Factory callAdapterFactory, Converter.Factory converterFactory, String baseURL) {
        retrofit = new Retrofit.Builder().addConverterFactory(converterFactory).baseUrl(baseURL).
                addCallAdapterFactory(callAdapterFactory).client(okHttpClient).build();
    }

    public <T> T createService(Class<T> serviceClass) {
        try {
            return retrofit.create(serviceClass);
        } catch (Throwable e) {
            return null;
        }
    }

}
