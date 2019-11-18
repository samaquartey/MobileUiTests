package com.missguided.Api;
import com.missguided.ApiObjects.LoginObjects;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import java.io.IOException;

public class LoginApi extends LoginObjects {

    public Response loginApiPost() throws IOException {
        MediaType mediaType = MediaType.parse("application/json");
        RequestBody body = RequestBody.create(mediaType, String.valueOf(loginApiJsonObject()));
        Request request = new Request.Builder()
                .url(readProperty.getData("loginApi"))
                .post(body)
                .addHeader("Content-Type", "application/json")
                .build();

        Response response = client.newCall(request).execute();
        return response;
    }
}
