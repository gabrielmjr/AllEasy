package com.gabrielmjr.alleasy.api;

import java.util.HashMap;

// Used to call methods from requester api
public interface ResponseIF {
    public abstract void onResponse(HashMap api_info);
    public abstract void onErrorResponse();
    public abstract void onJSONError();
}
