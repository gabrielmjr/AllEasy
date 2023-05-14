package com.mjr.twaire.app.alleasy.api;

import com.android.volley.NetworkResponse;
import com.android.volley.Response;
import com.android.volley.toolbox.JsonArrayRequest;
import org.json.JSONArray;

public class JARequest extends JsonArrayRequest {
    private int responseCode;

    public JARequest(int method,
                     String url,
                     Response.Listener<JSONArray> listener,
                     Response.ErrorListener error) {
        super(method, url, null, listener, error);
    }

    @Override
    protected Response<JSONArray> parseNetworkResponse(NetworkResponse response) {
        setResponseCode(response.statusCode);
        return super.parseNetworkResponse(response);
    }

    public int getResponseCode() {
        return responseCode;
    }

    private void setResponseCode(int status) {
        responseCode = status;
    }
}
