package com.codepath.apps.restclienttemplate.models;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Tweet {
    public String body;
    public String createdAt;
    public User user;

    //this method takes in a JSONObject that we are getting from out API call, parses the JSON data to create a Tweet java model so that we can use in our UI
    public static Tweet fromJson(JSONObject jsonObject) throws JSONException {
        Tweet tweet = new Tweet();
        tweet.body = jsonObject.getString("text");
        tweet.createdAt = jsonObject.getString("created_at");
        //jsonObject.getString("user") returns a JSONObject because in the documentation "user" is mapped to another sub directory
        // we create a fromJson method in the User class so that we can parse the JSON object into a java model!
        tweet.user = User.fromJson(jsonObject.getJSONObject("user"));
        return tweet;
    }

    //makes an arraylist of the tweet objects from the jsonArray that we receive from the API call
    //we loop through the JSONArray, add each JSON object(aka 1 tweet object) to the array list tweets
    public static List<Tweet> fromJsonArray(JSONArray jsonArray) throws JSONException {
        List<Tweet> tweets = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++){
            tweets.add(fromJson(jsonArray.getJSONObject(i)));
        }
        return tweets;

    }
}
