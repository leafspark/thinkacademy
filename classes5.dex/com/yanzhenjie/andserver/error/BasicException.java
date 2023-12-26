package com.yanzhenjie.andserver.error;

public class BasicException extends RuntimeException {
    private int mStatusCode;

    public BasicException(int i, String str) {
        super(str);
        this.mStatusCode = i;
    }

    public BasicException(int i, String str, Throwable th) {
        super(str, th);
        this.mStatusCode = i;
    }

    public BasicException(int i, Throwable th) {
        super(th);
        this.mStatusCode = i;
    }

    public int getStatusCode() {
        return this.mStatusCode;
    }
}
