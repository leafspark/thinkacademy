package com.didi.hummer.core.exception;

import android.text.TextUtils;

public class JSException extends Exception {
    private String errMsg;
    private String errStack;
    private String errType;

    public JSException(String str) {
        super(str);
        try {
            setStackTrace(new StackTraceElement[0]);
            parseStackTrace(str);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void parseStackTrace(String str) {
        this.errStack = str;
        if (TextUtils.isEmpty(str)) {
            this.errMsg = str;
            this.errType = "unknown";
            return;
        }
        int indexOf = str.indexOf("\n");
        if (indexOf <= 0) {
            this.errMsg = str;
            this.errType = "unknown";
            return;
        }
        String substring = str.substring(0, indexOf);
        this.errMsg = substring;
        if (TextUtils.isEmpty(substring)) {
            this.errType = "unknown";
            return;
        }
        int indexOf2 = this.errMsg.indexOf(":");
        if (indexOf2 <= 0) {
            this.errType = "unknown";
        } else {
            this.errType = this.errMsg.substring(0, indexOf2);
        }
    }

    public String getErrType() {
        return this.errType;
    }

    public String getErrMsg() {
        return this.errMsg;
    }

    public String getErrStack() {
        return this.errStack;
    }
}
