package com.GabrielMJr.Twaire.AllEasy.api;


import android.content.Context;
import com.GabrielMJr.Twaire.AllEasy.api.Constants;
import com.GabrielMJr.Twaire.AllEasy.api.JARequest;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class UpdateChecker
{
    // Attributes
    // URL to do the request
    private final String url = "https://api.github.com/repos/gabrielmjr/AllEasy/releases";

    // Map that contains some response values and response code
    private HashMap<String, Integer> api_info;

    private RequestQueue queue;
    private JARequest request;
    private JSONObject object;
    
    // My response interface
    private final ResponseIF myResponse;
    
    // Constructor
    public UpdateChecker(Context context, ResponseIF myResponse)
    {
        queue = Volley.newRequestQueue(context);
        api_info = new HashMap<String, Integer>();
        this.myResponse = myResponse;
    }

    // Check update from my github releases
    public void checkUpdate()
    {
        request = new JARequest(JARequest.Method.GET, url,
            new Response.Listener<JSONArray>() {
                @Override
                public void onResponse(JSONArray response)
                {
                    try
                    {
                        // Get data from JSON, add to hashmap and call on response method
                        object = (JSONObject) response.get(0);
                        api_info.put(Constants.TAG, object.getInt(Constants.TAG));
                        myResponse.onResponse(api_info);
                        
                    }
                    catch (JSONException e)
                    {
                       // Call on json error method
                       myResponse.onJSONError();
                    }
                }

            } 
            // On error
            , new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error)
                {
                   // Call on error response from interface
                   myResponse.onErrorResponse();
                }
            });       

// Add the request to the RequestQueue.
        queue.add(request);
    }
}
