package com.GabrielMJr.Twaire.AllEasy.api;

// Response code class
import com.android.volley.Response;
import com.android.volley.toolbox.JsonArrayRequest;
import org.json.JSONArray;
import com.android.volley.NetworkResponse;

public class JARequest extends JsonArrayRequest
{
    
    // Response code
    private int responseCode;
    
    public JARequest(int method,
                   String url,
                   Response.Listener<JSONArray> listener,
                   Response.ErrorListener error) 
    {
        super(method, url, null, listener, error);
    }

    @Override
    protected Response<JSONArray> parseNetworkResponse(NetworkResponse response)
    {
        setResponseCode(response.statusCode);
        return super.parseNetworkResponse(response);
    }
    
    // Getters and setters
    public int getResponseCode()
    {
        return responseCode;
    }
    
    private void setResponseCode(int status)
    {
        responseCode = status;
    }
}
