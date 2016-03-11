package com.avangate.api.rest;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class ApiClient
{
    /**
     * API Client
     */
    protected Client client;

    /**
     * API endpoint
     */
    protected String url;

    /**
     * API Merchant code
     */
    protected String merchantCode;

    /**
     * API Merchant secret
     */
    protected String merchantSecret;

    /**
     * REST Authenticator class that builds the auth token
     */
    protected Authenticator authenticator;

    /**
     *
     * @param merchantCode      API Merchant Code
     * @param merchantSecret    API Merchant Secret
     * @param apiEndpoint       API Endpoint URL
     */
    public ApiClient(String merchantCode, String merchantSecret, String apiEndpoint)
    {
        this.url = apiEndpoint;
        this.merchantCode = merchantCode;
        this.merchantSecret = merchantSecret;
        this.client = ClientBuilder.newClient();
        this.authenticator = new Authenticator(merchantCode, merchantSecret);
    }

    /**
     *
     * @param path      REST API path to be called
     * @return String
     */
    public Response get(String path)
    {
        return client.target(buildFullApiUrl(path))
                .request(MediaType.APPLICATION_JSON_TYPE)
                .header("X-Avangate-Authentication", authenticator.getAuthToken())
                .get();
    }

    /**
     *
     * @param path      REST API path to be called
     * @param payload   Request body
     * @return String
     */
    public Response post(String path, String payload)
    {
        return client.target(buildFullApiUrl(path))
                .request(MediaType.APPLICATION_JSON_TYPE)
                .header("X-Avangate-Authentication", authenticator.getAuthToken())
                .post(this.entityFromJsonString(payload));
    }

    /**
     *
     * @param path      REST API path to be called
     * @param payload   Request body
     * @return String
     */
    public Response put(String path, String payload)
    {
        return client.target(buildFullApiUrl(path))
                .request(MediaType.APPLICATION_JSON_TYPE)
                .header("X-Avangate-Authentication", authenticator.getAuthToken())
                .put(this.entityFromJsonString(payload));
    }

    /**
     *
     * @param path      REST API path to be called
     * @return String
     */
    public Response delete(String path)
    {
        return client.target(buildFullApiUrl(path))
                .request(MediaType.APPLICATION_JSON_TYPE)
                .header("X-Avangate-Authentication", authenticator.getAuthToken())
                .delete();
    }

    /**
     *
     * @param jsonString    JSON String to be converted
     * @return Entity
     */
    public Entity entityFromJsonString(String jsonString)
    {
        return Entity.json(jsonString);
    }

    /**
     *
     * @param path  API path to be called
     * @return String
     */
    public String buildFullApiUrl(String path)
    {
        String pathSeparator = "/";

        if (url.substring(url.length() - 1).equals(pathSeparator)) {
            url = url.substring(0, url.length() - 1);
        }

        if (path.substring(0, 1).equals(pathSeparator)) {
            path = path.substring(1, url.length());
        }

        return url + pathSeparator + path;
    }
}
