package com.sensorsdata.analytics.android.sdk.exceptions;

public class ConnectErrorException extends Exception {
    private int mRetryAfter;

    public ConnectErrorException(String str) {
        super(str);
        this.mRetryAfter = 30000;
    }

    public ConnectErrorException(String str, String str2) {
        super(str);
        try {
            this.mRetryAfter = Integer.parseInt(str2);
        } catch (NumberFormatException unused) {
            this.mRetryAfter = 0;
        }
    }

    public ConnectErrorException(Throwable th) {
        super(th);
    }

    public int getRetryAfter() {
        return this.mRetryAfter;
    }
}
