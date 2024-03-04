package org.yeinp.animate.animate_backend.exception;

import org.json.simple.JSONObject;

public class ErrorResponse {
    public static JSONObject JsonErrorResponse(int errorCode, String errorMessage)
    {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("errorCode", errorCode);
        jsonObject.put("errorMessage", errorMessage);
        return jsonObject;
    }
}
