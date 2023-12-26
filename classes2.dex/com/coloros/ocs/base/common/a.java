package com.coloros.ocs.base.common;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

public class a extends Handler {
    public a(Looper looper) {
        super(looper);
    }

    public a(Looper looper, Handler.Callback callback) {
        super(looper, callback);
    }

    public void dispatchMessage(Message message) {
        super.dispatchMessage(message);
    }
}
