package com.GabrielMJr.Twaire.AllEasy.api;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import org.json.JSONObject;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.Request;
import com.android.volley.Response;
import org.json.JSONArray;
import com.android.volley.VolleyError;
import org.json.JSONException;
import com.android.volley.toolbox.HttpResponse;
import javax.microedition.khronos.opengles.GL11Ext;
import com.android.volley.toolbox.Volley;
import android.content.Context;
import java.util.Map;
import java.util.HashMap;
import com.android.volley.NetworkResponse;

public class UpdateChecker
{
    // Attributes
    // URL to do the request
    private final String url = "https://api.github.com/repos/gabrielmjr/AllEasy/releases";

    // Latest version code
    private Integer latestVC = -1;

    // Map that contains some json values and response code
    private Map<String, Integer> api_info;
    
    
    private RequestQueue queue;
    private JsonArrayRequest request;
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
        
        request = new JsonArrayRequest(Request.Method.GET, url, null,
            new Response.Listener<JSONArray>() {
                @Override
                public void onResponse(JSONArray response) {
                    try
                    {
                        object = (JSONObject) response.get(0);
                        setVersionCode(object.getInt("tag_name"));
                        
                    }
                    catch (JSONException e)
                    {}
                }

            } 
            , new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    setVersionCode(error.networkResponse.statusCode);
                }
            });       

// Add the request to the RequestQueue.
        queue.add(request);
    }
    
    // Getters and setters
    // Latest version code from github
    public int getVersionCode()
    {
        return latestVC;
    }
    
    private void setVersionCode(int latestVC)
    {
        this.latestVC = latestVC;
    }
}
