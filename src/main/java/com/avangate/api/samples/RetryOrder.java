package com.avangate.api.samples;

import com.avangate.api.rest.ApiClient;
import javax.ws.rs.core.Response;

public class RetryOrder
{
    public static void main( String[] args )
    {
        String merchantCode = "";
        String merchantSecret = "";
        String apiUrl = "";

        ApiClient client = new ApiClient(merchantCode, merchantSecret, apiUrl);

        String orderData = "{\"RefNo\":\"11321141\",\"PaymentDetails\":{\"Type\":\"TEST\",\"Currency\":\"EUR\",\"CustomerIP\":\"91.220.121.21\",\"PaymentMethod\":{\"CardNumber\":\"4984123412341234\",\"CardType\":\"VISA\",\"InstallmentsNumber\":1,\"ExpirationYear\":\"2019\",\"ExpirationMonth\":\"12\",\"CCID\":\"123\",\"HolderName\":\"John Doe\",\"RecurringEnabled\":true,\"HolderNameTime\":2,\"CardNumberTime\":2}}}";

        Response response = client.post("orders/", orderData);

        String orderResponse = response.readEntity(String.class);

        System.out.println("status: " + response.getStatus());
        System.out.println("headers: " + response.getHeaders());
        System.out.println("body:" + orderResponse);

    }
}
