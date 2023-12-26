package com.sensorsdata.analytics.android.sdk.exceptions;

public class ResponseErrorException extends Exception {
    private int httpCode;

    public ResponseErrorException(String str, int i) {
        super(str);
        this.httpCode = i;
    }

    public ResponseErrorException(Throwable th, int i) {
        super(th);
        this.httpCode = i;
    }

    public int getHttpCode() {
        return this.httpCode;
    }
}
