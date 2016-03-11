package com.avangate.api.samples;

import com.avangate.api.rest.ApiClient;
import com.avangate.api.rest.Authenticator;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Response;

public class GetProduct
{
    public static void main( String[] args )
    {

        String merchantCode = "";
        String merchantSecret = "";
        String apiUrl = "";

        ApiClient client = new ApiClient(merchantCode, merchantSecret, apiUrl);
        Response response = client.get("products/XXXXXX/");

        String product = response.readEntity(String.class);

        System.out.println("status: " + response.getStatus());
        System.out.println("headers: " + response.getHeaders());
        System.out.println("body:" + product);

    }
}
