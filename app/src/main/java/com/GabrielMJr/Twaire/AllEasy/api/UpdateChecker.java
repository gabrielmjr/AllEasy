package com.GabrielMJr.Twaire.AllEasy.api;


import android.app.DownloadManager;
import android.content.Context;
import android.net.Uri;
import com.GabrielMJr.Twaire.AllEasy.R;
import com.GabrielMJr.Twaire.AllEasy.util.Constants;
import com.GabrielMJr.Twaire.AllEasy.api.JARequest;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import android.os.Environment;

public class UpdateChecker
{
    // Attributes
    // URL to do the request
    private final String url = "https://api.github.com/repos/gabrielmjr/AllEasy/releases";

    // Map that contains some response values and response code
    private HashMap<String, Integer> api_info;

    // Json components
    private RequestQueue queue;
    private JARequest request;
    private JSONObject object;
    private JSONArray assets_array;
    private JSONObject assets_object;
    
    // Download url
    private String download_latest_app_url;
    
    // Download app object
    private DownloadApp downloadApp;
    
    // Release name
    private String releaseName;
    
    // Context 
    private Context context;
    
    // My response interface
    private final ResponseIF myResponse;
    
    // Constructor
    public UpdateChecker(Context context, ResponseIF myResponse)
    {
        this.context = context;
        queue = Volley.newRequestQueue(context);
        api_info = new HashMap<String, Integer>();
        this.myResponse = myResponse;
        
        downloadApp = new DownloadApp();
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
                        
                        // Get assets array to finally get the download url
                        assets_array = object.getJSONArray(Constants.ASSETS);
                        assets_object = (JSONObject)assets_array.get(0);
                        download_latest_app_url = assets_object.getString(Constants.GET_DOWNLOAD_URL);
                        
                        // Get version code and release name
                        api_info.put(Constants.TAG, object.getInt(Constants.TAG));
                        releaseName = object.getString(Constants.NAME);
                        
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
    
    
    // Getters and setters
    // Get download app method
    public DownloadApp getDownloadApp()
    {
        return downloadApp;
    }
    
    // Get release name
    public String getReleaseName()
    {
        return releaseName;
    }
    
    
    /*
     Download the latest version class
    */
    public class DownloadApp
    {
        // Download manager attributes
        private DownloadManager.Request request;
        private DownloadManager manager;
        
        // Start download method
        public void start()
        {
            // Initializing the download manager
            request = new DownloadManager.Request(Uri.parse(download_latest_app_url));
            manager = (DownloadManager)context.getSystemService(Context.DOWNLOAD_SERVICE);

            // Set notification info
            request.setTitle(context.getString(R.string.app_name));
            request.setDescription((CharSequence)context.getString(R.string.downloading) + " " + releaseName);
            request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
            request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, releaseName + Constants.APK_EXTENSION);
            manager.enqueue(request);
        }
    }
}
