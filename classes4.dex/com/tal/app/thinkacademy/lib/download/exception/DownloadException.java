package com.tal.app.thinkacademy.lib.download.exception;

public class DownloadException extends Exception {
    public int code;
    public String errorMsg;

    public DownloadException(Throwable th, int i, String str) {
        super(str, th);
        this.code = i;
        this.errorMsg = str;
    }
}
