package com.firstdata.ach.connectpay.net;

import com.firstdata.ach.connectpay.net.util.NetworkUtility;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okio.Buffer;

/**
 * Created by Arjun Chinya on 7/13/16.
 */
public class HeaderInterceptor implements Interceptor {
    private String apiKey;
    private String secret;
    private String token;

    public HeaderInterceptor(String apiKey, String secret, String token) {
        this.apiKey = apiKey;
        this.secret = secret;
        this.token = token;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        Request.Builder requestBuilder = request.newBuilder();
        requestBuilder = requestBuilder.addHeader("apikey", apiKey).addHeader("token", token);

        if (chain.request().method().equalsIgnoreCase("post") || chain.request().method().equalsIgnoreCase("put")) {
            try {
                String body;
                if (request.body() != null) {
                    Buffer buffer = new Buffer();
                    request.body().writeTo(buffer);
                    body = buffer.readUtf8();
                } else
                    body = "";
                String nonce = Long.toString(Math.abs(SecureRandom.getInstance("SHA1PRNG").nextLong()));
                String timestamp = Long.toString(System.currentTimeMillis());
                String hmac = NetworkUtility.calculateHMAC(apiKey, secret, timestamp, nonce,token, body);
                requestBuilder.addHeader("nonce", nonce).addHeader("timestamp", timestamp).addHeader("Authorization", hmac);
            } catch (NoSuchAlgorithmException nse) {
            }
        }
        return chain.proceed(requestBuilder.build());
    }
}
