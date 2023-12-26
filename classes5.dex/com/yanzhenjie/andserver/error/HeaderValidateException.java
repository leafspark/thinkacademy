package com.yanzhenjie.andserver.error;

public class HeaderValidateException extends BasicException {
    public HeaderValidateException(String str) {
        super(403, str);
    }

    public HeaderValidateException(String str, Throwable th) {
        super(403, str, th);
    }

    public HeaderValidateException(Throwable th) {
        super(403, th);
    }
}
