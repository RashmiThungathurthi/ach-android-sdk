package com.firstdata.ach.connectpay.net.util;

import android.util.Base64;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

/**
 * Created by Arjun Chinya on 7/13/16.
 */
public class NetworkUtility {

    public static String calculateHMAC(String apiKey, String secret, String timeStamp, String nonce,String token, String payload) {
        String authorizeString = null;
        try {
            Mac mac = Mac.getInstance("HmacSHA256");
            SecretKeySpec secretKey = new SecretKeySpec(secret.getBytes(), "HmacSHA256");
            mac.init(secretKey);

            StringBuilder buffer = new StringBuilder();
            buffer.append(apiKey);
            buffer.append(nonce);
            buffer.append(timeStamp);
            buffer.append(token);
            buffer.append(payload);

            byte[] macHash = mac.doFinal(buffer.toString().getBytes("UTF-8"));
            authorizeString = Base64.encodeToString(bytesToHex(macHash).getBytes(), Base64.NO_WRAP);

        } catch (Exception e) {
        }
        return authorizeString;
    }

    public static String bytesToHex(byte[] a) {
        StringBuilder sb = new StringBuilder(a.length * 2);
        for (byte b : a)
            sb.append(String.format("%02x", b & 0xff));
        return sb.toString();
    }

}
