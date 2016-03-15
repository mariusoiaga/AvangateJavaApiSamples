package com.avangate.api.samples;

import com.avangate.api.rest.ApiClient;
import javax.ws.rs.core.Response;

public class PlaceTestOrderCC
{
    public static void main( String[] args )
    {
        String merchantCode = "";
        String merchantSecret = "";
        String apiUrl = "";

        ApiClient client = new ApiClient(merchantCode, merchantSecret, apiUrl);

        String orderData = "{\"Currency\":\"EUR\",\"Language\":\"RO\",\"CountryCode\":\"BR\",\"CustomerIP\":\"91.220.121.21\",\"Source\":\"sourceAPI.net\",\"LocalTime\":\"2015-08-20 11:54:59\",\"Items\":[{\"Code\":\"my_subscription_1\",\"Quantity\":1,\"PriceOptions\":[\"red\"]}],\"Discount\":null,\"ExternalReference\":null,\"BillingDetails\":{\"Address1\":\"Address Api Bil\",\"Address2\":\"Address Api Bil2\",\"City\":\"Api City Bil\",\"State\":\"Santa Catarina\",\"CountryCode\":\"BR\",\"Phone\":\"12345\",\"Email\":\"shopper123@avangate.com\",\"FirstName\":\"Api First Name Bil\",\"LastName\":\"Api Last Name Bil\",\"Company\":\"Api Last Name Bil\",\"Zip\":\"12345\",\"FiscalCode\":13205628845},\"DeliveryDetails\":{\"Address1\":\"Address Api Del\",\"Address2\":\"Address Api Del2\",\"City\":\"Api City Del\",\"State\":\"SC\",\"CountryCode\":\"BR\",\"Phone\":\"12345\",\"Email\":\"\",\"FirstName\":\"Api First Name Del\",\"LastName\":\"Api Last Name Del\",\"Zip\":12345},\"PaymentDetails\":{\"Type\":\"TEST\",\"Currency\":\"EUR\",\"CustomerIP\":\"91.220.121.21\",\"PaymentMethod\":{\"CardNumber\":\"4984123412341234\",\"CardType\":\"VISA\",\"InstallmentsNumber\":1,\"ExpirationYear\":\"2019\",\"ExpirationMonth\":\"12\",\"CCID\":\"123\",\"HolderName\":\"John Doe\",\"RecurringEnabled\":true,\"HolderNameTime\":2,\"CardNumberTime\":2}}}";

        Response response = client.post("orders/", orderData);

        String orderResponse = response.readEntity(String.class);

        System.out.println("status: " + response.getStatus());
        System.out.println("headers: " + response.getHeaders());
        System.out.println("body:" + orderResponse);

    }
}
