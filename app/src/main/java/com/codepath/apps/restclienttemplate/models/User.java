package com.codepath.apps.restclienttemplate.models;

import org.json.JSONException;
import org.json.JSONObject;

public class User {

    public String name;
    public String screenName; //the users handle
    public String profileImageUrl;

    //fromJson takes in a jsonObject representing the json data of the user from the API call, We create the User data model and populate the fields by parsing the json data,
    //we throw a JSONException in the case that the json field does not exist
    public static User fromJson(JSONObject jsonObject) throws JSONException {
        User user = new User();
        user.name = jsonObject.getString("name");
        user.screenName = jsonObject.getString("screen_name");
        user.profileImageUrl = jsonObject.getString("profile_image_url_https");
        return user;
    }
}
