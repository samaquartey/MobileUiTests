package com.missguided.Api;
import com.missguided.Helpers.ReadProperty;
import okhttp3.OkHttpClient;
import okhttp3.Response;

public class ApiBase {

    public OkHttpClient client;
    public ReadProperty readProperty;
    public Response Response;

    public ApiBase() {
        client = new OkHttpClient();
        readProperty = new ReadProperty();
    }
}
