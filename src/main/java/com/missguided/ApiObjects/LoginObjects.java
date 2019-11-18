package com.missguided.ApiObjects;
import com.missguided.Api.ApiBase;
import org.json.JSONObject;

public class LoginObjects extends ApiBase {

    public JSONObject loginApiJsonObject(){
        JSONObject loginDetails = new JSONObject();
        loginDetails.put(readProperty.getData("loginUsername"),readProperty.getData("username"));
        loginDetails.put(readProperty.getData("loginPassword"), readProperty.getData("password"));
        return loginDetails;
    }
}
