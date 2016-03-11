package com.avangate.api.crypto;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class Hmac {

    /**
     *
     * @param string The complete string to hash
     * @param key Secret key to compute the hash
     * @return String
     * @throws Exception
     */
    public static String makeHash (String string, String key) throws Exception
    {
        String hash = "";

        Mac mac = Mac.getInstance("HmacMD5");
        SecretKeySpec secret = new SecretKeySpec(key.getBytes(),"HmacMD5");
        mac.init(secret);

        byte[] digest = mac.doFinal(string.getBytes());
        for (byte b : digest) {
            hash += String.format("%02x", b);
        }

        return hash;
    }

}
