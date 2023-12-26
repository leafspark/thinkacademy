package com.yanzhenjie.andserver.annotation;

public enum RequestMethod {
    GET("GET"),
    HEAD("HEAD"),
    POST("POST"),
    PUT("PUT"),
    PATCH("PATCH"),
    DELETE("DELETE"),
    OPTIONS("OPTIONS"),
    TRACE("TRACE");
    
    private String value;

    private RequestMethod(String str) {
        this.value = str;
    }

    public String value() {
        return this.value;
    }

    public String toString() {
        return this.value;
    }
}
