package com.mjr.twaire.app.alleasy.api;

import java.util.HashMap;

public interface ResponseIF {
    public abstract void onResponse(HashMap api_info);
    public abstract void onErrorResponse();
    public abstract void onJSONError();
}
