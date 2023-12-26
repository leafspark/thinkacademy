package io.flutter.plugin.common;

import io.flutter.Log;
import io.flutter.plugin.common.MethodChannel;

public class ErrorLogResult implements MethodChannel.Result {
    private int level;
    private String tag;

    public void success(Object obj) {
    }

    public ErrorLogResult(String str) {
        this(str, Log.WARN);
    }

    public ErrorLogResult(String str, int i) {
        this.tag = str;
        this.level = i;
    }

    public void error(String str, String str2, Object obj) {
        String str3;
        if (obj != null) {
            str3 = " details: " + obj;
        } else {
            str3 = "";
        }
        if (this.level >= Log.WARN) {
            Log.println(this.level, this.tag, str2 + str3);
        }
    }

    public void notImplemented() {
        if (this.level >= Log.WARN) {
            Log.println(this.level, this.tag, "method not implemented");
        }
    }
}
