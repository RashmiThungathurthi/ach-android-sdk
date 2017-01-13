package com.firstdata.ach.connectpay.net.services;

import com.firstdata.ach.connectpay.model.EstablishRequest;
import com.firstdata.ach.connectpay.model.EstablishResponse;
import com.firstdata.ach.connectpay.model.ValidateRequest;
import com.firstdata.ach.connectpay.model.ValidateResponse;

import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by Arjun Chinya on 6/12/16.
 */
public interface EstablishService {

    @POST("v1/ach/establish")
    @Headers({"Content-Type:application/json"})
    Observable<EstablishResponse> callEstablish(@Body EstablishRequest request);

    @POST("v1/ach/validate")
    @Headers({"Content-Type:application/json"})
    Observable<ValidateResponse> callValidate(@Body ValidateRequest request);
}
