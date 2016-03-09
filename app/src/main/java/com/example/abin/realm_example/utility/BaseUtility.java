package com.example.abin.realm_example.utility;

import android.util.Base64;

/**
 * An utility class for base operations.
 */
public class BaseUtility {

    public String encrypt(String data) {
        byte[]   bytesEncoded = Base64.encode(data.getBytes(), Base64.DEFAULT);
        return new String(bytesEncoded);
    }

    public String decrypt(String data) {
        byte[] decodedValue = Base64.decode(data.getBytes(), Base64.DEFAULT);
        return new String(decodedValue);
    }
}
