package com.yanzhenjie.andserver.error;

public class ParamValidateException extends BasicException {
    public ParamValidateException(String str) {
        super(403, str);
    }

    public ParamValidateException(String str, Throwable th) {
        super(403, str, th);
    }

    public ParamValidateException(Throwable th) {
        super(403, th);
    }
}
