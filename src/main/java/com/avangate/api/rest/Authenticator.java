package com.avangate.api.rest;

import com.avangate.api.crypto.Hmac;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Authenticator
{
    /**
     * API Merchant Code
     */
    protected String merchantCode;

    /**
     * API Merchant Secret
     */
    protected String merchantSecret;

    /**
     *
     * @param merchantCode      API Merchant Code
     * @param merchantSecret    API Merchant Secret
     */
    public Authenticator(String merchantCode, String merchantSecret)
    {
        this.merchantCode = merchantCode;
        this.merchantSecret = merchantSecret;
    }

    /**
     *
     * @return String
     */
    public String getAuthToken()
    {
        String date = getDate();
        String hash = buildHash(date);

        return String.format("code=\"%s\" date=\"%s\" hash=\"%s\"", merchantCode, date, hash);
    }

    /**
     *
     * @param date              Date used to build the hash
     * @return String
     */
    protected String buildHash(String date)
    {

        String hash;
        String hashString = merchantCode.length() + merchantCode + date.length() + date;

        try {
            hash = Hmac.makeHash(hashString, merchantSecret);
        } catch (Exception e) {
            hash = "";
        }

        return hash;
    }

    /**
     *
     * @return String
     */
    protected String getDate()
    {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return formatter.format(new Date());
    }

}
