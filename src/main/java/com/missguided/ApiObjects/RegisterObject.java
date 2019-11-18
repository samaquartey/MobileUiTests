package com.missguided.ApiObjects;
import com.missguided.Api.ApiBase;
import org.json.JSONObject;
import java.util.UUID;

public class RegisterObject extends ApiBase {
    private String form_key;
    private String area_of_site;
    private int is_subscribed;
    private String firstname;
    private String lastname;
    private String email;
    private String birth_date;
    private String password;
    private String confirmation;
    private int day;
    private String day_select;
    private int month;
    private String month_select;
    private int year;
    private String year_select;
    private String dob;
    private String ran = UUID.randomUUID().toString().replace("-","").substring(0,5);

    public JSONObject registerApiJsonObject(){
        JSONObject registerDetails = new JSONObject();

        registerDetails.put(form_key,"Iwgs4oOPdvTb2U01");
        registerDetails.put(area_of_site,"ACCOUNT_CREATION");
        registerDetails.put(String.valueOf(is_subscribed), 1);
        registerDetails.put(firstname,"Kay");
        registerDetails.put(lastname,"Smith");
        registerDetails.put(email,ran + "demo@msn.com");
        registerDetails.put(birth_date,"12/12/1980");
        registerDetails.put(password,"1234demo");
        registerDetails.put(confirmation,"1234demo");
        registerDetails.put(String.valueOf(day),12);
        registerDetails.put(day_select,"");
        registerDetails.put(String.valueOf(month),12);
        registerDetails.put(month_select,"");
        registerDetails.put(String.valueOf(year),1980);
        registerDetails.put(year_select,"");
        registerDetails.put(dob,"12/12/1980");

        return registerDetails;
    }
}
