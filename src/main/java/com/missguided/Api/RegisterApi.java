package com.missguided.Api;

import com.missguided.ApiObjects.RegisterObject;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import java.io.IOException;

public class RegisterApi extends RegisterObject {

    public Response RegisterApiValidation(){
        MediaType mediaType = MediaType.parse("application/json");

        /** json object **/
        RequestBody body = RequestBody.create(mediaType, String.valueOf(registerApiJsonObject()));
        Request request = new Request.Builder()
                .url(readProperty.getData("registerApi"))
                .post(body)
                .addHeader("Content-Type", "application/json")
                .build();

        try {
            Response = client.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Response;
    }
}

