package com.dianping.logan;

import android.text.TextUtils;

class WriteAction {
    int fileLine;
    String fileName = "";
    int flag;
    String funcName = "";
    boolean isMainThread;
    long localTime;
    String log;
    String tagName = "";
    long threadId;
    String threadName = "";

    WriteAction() {
    }

    /* access modifiers changed from: package-private */
    public boolean isValid() {
        return !TextUtils.isEmpty(this.log);
    }
}
