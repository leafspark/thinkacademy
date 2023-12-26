package com.tal.app.thinkacademy.lib.download.exception;

import java.net.ConnectException;

public class NetException extends ConnectException {
    public String getMessage() {
        return "本地无网络";
    }
}
