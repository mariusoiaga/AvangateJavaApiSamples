package com.avangate.api.samples;

        import com.avangate.api.rest.ApiClient;
        import javax.ws.rs.core.Response;

public class getSubscription
{
    public static void main( String[] args )
    {
        String merchantCode = "";
        String merchantSecret = "";
        String apiUrl = "";

        ApiClient client = new ApiClient(merchantCode, merchantSecret, apiUrl);

        String subscriptionReference = "A111F12D33/";

        Response response = client.get("subscriptions/"+subscriptionReference);

        String subscriptionResponse = response.readEntity(String.class);

        System.out.println("status: " + response.getStatus());
        System.out.println("headers: " + response.getHeaders());
        System.out.println("body:" + subscriptionResponse);

    }
}
