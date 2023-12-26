package com.sensorsdata.analytics.android.sdk.exceptions;

public class DebugModeException extends RuntimeException {
    public DebugModeException(String str) {
        super(str);
    }

    public DebugModeException(Throwable th) {
        super(th);
    }
}
