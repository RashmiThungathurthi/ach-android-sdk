package com.firstdata.ach.connectpay.net.services;

import com.firstdata.ach.connectpay.model.BAARequest;
import com.firstdata.ach.connectpay.model.EnrollmentRequest;
import com.firstdata.ach.connectpay.model.TokenResponse;

import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by Arjun Chinya on 6/12/16.
 */
public interface EnrollmentService {

    @POST("v1/ach/consumer/enrollment")
    @Headers({"Content-Type:application/json"})
    Observable<TokenResponse> create(@Body EnrollmentRequest request);

    @POST("v1/ach/consumer/enrollment/pwmb")
    @Headers({"Content-Type:application/json"})
    Observable<TokenResponse> createWithPWMB(@Body EnrollmentRequest request);

    @POST("v1/ach/consumer/enrollment/baa")
    @Headers({"Content-Type:application/json"})
    Observable<TokenResponse> callMicroValidate(@Body BAARequest request);
}
