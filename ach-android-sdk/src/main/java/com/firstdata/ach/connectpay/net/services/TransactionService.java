package com.firstdata.ach.connectpay.net.services;

import com.firstdata.ach.connectpay.model.TransactionRequest;
import com.firstdata.ach.connectpay.model.TransactionResponse;

import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by Arjun Chinya on 6/12/16.
 */
public interface TransactionService {

    @POST("v1/transactions")
    @Headers({"Content-Type:application/json"})
    Observable<TransactionResponse> primaryTransaction(@Body TransactionRequest request);

    @POST("v1/transactions/{transactionId}")
    @Headers({"Content-Type:application/json"})
    Observable<TransactionResponse> secondaryTransaction(@Path("transactionId") String transactionId, @Body TransactionRequest request);

}
