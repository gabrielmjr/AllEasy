package com.GabrielMJr.Twaire.AllEasy.api;


import com.android.volley.RequestQueue;
import org.json.JSONObject;
import com.GabrielMJr.Twaire.AllEasy.api.JARequest;
import com.android.volley.Request;
import com.android.volley.Response;
import org.json.JSONArray;
import com.android.volley.VolleyError;
import org.json.JSONException;
import com.android.volley.toolbox.Volley;
import com.GabrielMJr.Twaire.AllEasy.api.Constants;
import android.content.Context;
import java.util.HashMap;
import java.net.HttpURLConnection;

public class UpdateChecker
{
    // Attributes
    // URL to do the request
    private final String url = "https://api.github.com/repos/gabrielmjr/AllEasy/releases";

    // Latest version code
    
    // Map that contains some response values and response code
    private HashMap<String, Integer> api_info;
    public String toS;
    private RequestQueue queue;
    private JARequest request;
    private JSONObject object;
    
    // Constructor
    public UpdateChecker(Context context)
    {
        queue = Volley.newRequestQueue(context);
        api_info = new HashMap<String, Integer>();
    }

    // Check update from my github releases
    public void checkUpdate()
    {
        request = new JARequest(JARequest.Method.GET, url,
            new Response.Listener<JSONArray>() {
                @Override
                public void onResponse(JSONArray response) {
                    try
                    {
                        object = (JSONObject) response.get(0);
                        
                        // Save the code into response status
                        put_apiInfo(Constants.RESPONSE_STATUS, request.getResponseCode());
                        
                        // Save version code into map
                        put_apiInfo(Constants.VERSION_CODE, object.getInt(Constants.TAG));
                    }
                    catch (JSONException e)
                    {}
                }

            } 
            // On error
            , new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    // Put the error code into map      
                    put_apiInfo(Constants.RESPONSE_STATUS, request.getResponseCode());
                }
            });       
           
// Add the request to the RequestQueue.
        queue.add(request);
        put_apiInfo(Constants.RESPONSE_STATUS, request.getResponseCode());
    }
    
    // Getters and setters
    // get apiInfo from github
    public HashMap getApiInfo()
    {
        return api_info;
    }
    
    // Put value into api info map
    private void put_apiInfo(String key, int value)
    {
        remove_apiInfo(key);
        api_info.put(key, value);
    }
    
    private void remove_apiInfo(String key)
    {
        api_info.remove(key);
    }
}
