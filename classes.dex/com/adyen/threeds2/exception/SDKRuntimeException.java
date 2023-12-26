package com.adyen.threeds2.exception;

public final class SDKRuntimeException extends RuntimeException {
    private final String a;

    public SDKRuntimeException(String str, String str2, Throwable th) {
        super(str, th);
        this.a = str2;
    }

    public String getErrorCode() {
        return this.a;
    }
}
