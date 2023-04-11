package com.gabrielmjr.alleasy.api;

import android.app.DownloadManager;
import android.content.Context;
import android.net.Uri;
import com.gabrielmjr.alleasy.R;
import com.gabrielmjr.alleasy.util.Constants;
import com.gabrielmjr.alleasy.api.JARequest;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import android.os.Environment;

public class UpdateChecker {
    private final String url = "https://api.github.com/repos/gabrielmjr/AllEasy/releases";
    private HashMap<String, Integer> api_info;

    private RequestQueue queue;
    private JARequest request;
    private JSONObject object;
    private JSONArray assets_array;
    private JSONObject assets_object;

    private String download_latest_app_url;
    private DownloadApp downloadApp;

    private String releaseName;
    private Context context;
    private ResponseIF myResponse;

    public UpdateChecker(Context context, ResponseIF myResponse) {
        this.context = context;
        queue = Volley.newRequestQueue(context);
        api_info = new HashMap<String, Integer>();
        this.myResponse = myResponse;
        downloadApp = new DownloadApp();
    }

    public void checkUpdate() {
        request = new JARequest(JARequest.Method.GET, url,
            new Response.Listener<JSONArray>() {
                @Override
                public void onResponse(JSONArray response) {
                    try {
                        object = (JSONObject) response.get(0);
                        assets_array = object.getJSONArray(Constants.ASSETS);
                        assets_object = (JSONObject)assets_array.get(0);
                        download_latest_app_url = assets_object.getString(Constants.GET_DOWNLOAD_URL);
                        api_info.put(Constants.TAG, object.getInt(Constants.TAG));
                        releaseName = object.getString(Constants.NAME);
                        myResponse.onResponse(api_info);
                    } catch (JSONException e) {
                        myResponse.onJSONError();
                    }
                }

            } 
            , new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    myResponse.onErrorResponse();
                }
            });
        queue.add(request);
    }
    
    public DownloadApp getDownloadApp() {
        return downloadApp;
    }

    public String getReleaseName() {
        return releaseName;
    }
    
    public class DownloadApp {
        private DownloadManager.Request request;
        private DownloadManager manager;

        public void start() {
            request = new DownloadManager.Request(Uri.parse(download_latest_app_url));
            manager = (DownloadManager)context.getSystemService(Context.DOWNLOAD_SERVICE);
            request.setTitle(context.getString(R.string.app_name));
            request.setDescription((CharSequence)context.getString(R.string.downloading) + " " + releaseName);
            request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
            request.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, releaseName + Constants.APK_EXTENSION);
            manager.enqueue(request);
        }
    }
}
