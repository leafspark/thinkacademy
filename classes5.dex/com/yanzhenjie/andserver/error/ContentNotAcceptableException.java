package com.yanzhenjie.andserver.error;

import com.yanzhenjie.andserver.util.StatusCode;

public class ContentNotAcceptableException extends BasicException {
    private static final String MESSAGE = "Could not find acceptable representation.";

    public ContentNotAcceptableException() {
        super((int) StatusCode.SC_NOT_ACCEPTABLE, MESSAGE);
    }

    public ContentNotAcceptableException(String str, Throwable th) {
        super(StatusCode.SC_NOT_ACCEPTABLE, str, th);
    }
}
