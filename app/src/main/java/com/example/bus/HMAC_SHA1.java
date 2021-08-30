package com.example.bus;

import android.os.Build;

import androidx.annotation.RequiresApi;

import java.security.SignatureException;

import android.util.Base64;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class HMAC_SHA1 {

    public static String Signature(String xData, String AppKey) throws java.security.SignatureException {
        try {
            SecretKeySpec signingKey = new SecretKeySpec(AppKey.getBytes("UTF-8"), "HmacSHA1");
            Mac mac = Mac.getInstance("HmacSHA1");
            mac.init(signingKey);
            // compute the hmac on input data bytes
            byte[] rawHmac = mac.doFinal(xData.getBytes("UTF-8"));
            String result = Base64.encodeToString(rawHmac, Base64.DEFAULT); //這行要改成這樣，不然就只能在 Andorid 8.0 才能使用
            result = result.replace("\n", ""); // 要加這一行，不然會認證失敗
            return result;

        } catch (Exception e) {
            throw new SignatureException("Failed to generate HMAC : " + e.getMessage());
        }
    }
}