package com.yanzhenjie.andserver.error;

import com.yanzhenjie.andserver.http.HttpMethod;

public class MethodNotSupportException extends BasicException {
    private static final String MESSAGE = "The request method [%s] is not supported.";

    public MethodNotSupportException(HttpMethod httpMethod) {
        super(405, String.format(MESSAGE, new Object[]{httpMethod.value()}));
    }

    public MethodNotSupportException(HttpMethod httpMethod, Throwable th) {
        super(405, String.format(MESSAGE, new Object[]{httpMethod.value()}), th);
    }
}
