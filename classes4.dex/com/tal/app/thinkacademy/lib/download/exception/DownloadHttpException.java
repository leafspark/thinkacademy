package com.tal.app.thinkacademy.lib.download.exception;

import okhttp3.Response;

public class DownloadHttpException extends RuntimeException {
    private int code;
    private String message;
    private Response response;

    private static String getMessage(Response response2) {
        return "HTTP " + response2.code() + " " + response2.message();
    }

    public DownloadHttpException(Response response2) {
        super(getMessage(response2));
        this.code = response2.code();
        this.message = response2.message();
        this.response = response2;
    }

    public int code() {
        return this.code;
    }

    public String message() {
        return this.message;
    }

    public Response response() {
        return this.response;
    }
}
