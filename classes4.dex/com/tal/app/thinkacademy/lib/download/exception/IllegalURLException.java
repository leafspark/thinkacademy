package com.tal.app.thinkacademy.lib.download.exception;

public class IllegalURLException extends IllegalArgumentException {
    public String getMessage() {
        return "无效的url";
    }
}
