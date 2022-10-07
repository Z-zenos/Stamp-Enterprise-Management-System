package com.icheck.backend.security;


import org.springframework.boot.configurationprocessor.json.JSONException;
import org.springframework.boot.configurationprocessor.json.JSONObject;

public class AuthorFailResponse {
	
    private static String jsonReturn;

    static {
        JSONObject response = new JSONObject();
        try {
			response.put("code", -1);
			response.put("message", "The access token is invalid or has expired");
			jsonReturn = response.toString();
		} catch (JSONException e) {
			e.printStackTrace();
		}
    }

    public static String toJson() {
        return jsonReturn;
    }
}
