package com.firstdata.ach.connectpay.module;

import com.firstdata.ach.connectpay.net.FirstApiClient;
import com.firstdata.ach.connectpay.net.HeaderInterceptor;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import retrofit2.CallAdapter;
import retrofit2.Converter;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;
import rx.schedulers.Schedulers;

/**
 * Created by Arjun Chinya on 7/13/16.
 */
@Singleton
@Module
public class NetworkModule {

    private String baseURL;
    private String apiKey;
    private String apiSecret;
    private String token;

    public NetworkModule(String apiBaseURL, String apiKey, String apiSecret, String token) {
        this.baseURL = apiBaseURL;
        this.apiKey = apiKey;
        this.apiSecret = apiSecret;
        this.token = token;
    }

    @Provides
    @Singleton
    public FirstApiClient providesCloverGoApiClient(OkHttpClient okHttpClient, CallAdapter.Factory callFactory, Converter.Factory converterFactory) {
        return new FirstApiClient(okHttpClient, callFactory, converterFactory, baseURL);
    }

    @Provides
    @Singleton
    public OkHttpClient providesHttpClient(Interceptor interceptor) {
        return new OkHttpClient.Builder().addInterceptor(interceptor).readTimeout(30, TimeUnit.SECONDS).retryOnConnectionFailure(false).build();
    }

    @Provides
    @Singleton
    public CallAdapter.Factory providesRxJavaAdapterFactory() {
        return RxJavaCallAdapterFactory.createWithScheduler(Schedulers.io());
    }

    @Provides
    @Singleton
    public Converter.Factory providesJacksonConverterFactory() {
        return JacksonConverterFactory.create();
    }

    @Provides
    @Singleton
    public Interceptor providesIntercetor() {
        return new HeaderInterceptor(apiKey, apiSecret, token);
    }


}
