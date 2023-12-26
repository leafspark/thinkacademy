package com.xueersi.lib.graffiti.utils;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class CatchHandler extends Handler {
    private static final List<String> sThreadExceptionRecord = new CopyOnWriteArrayList();

    public static List<String> takeExceptionRecord() {
        List<String> list = sThreadExceptionRecord;
        if (ListUtil.isEmpty(list)) {
            return null;
        }
        ArrayList arrayList = new ArrayList(list);
        list.clear();
        return arrayList;
    }

    public CatchHandler() {
    }

    public CatchHandler(Handler.Callback callback) {
        super(callback);
    }

    public CatchHandler(Looper looper) {
        super(looper);
    }

    public CatchHandler(Looper looper, Handler.Callback callback) {
        super(looper, callback);
    }

    public void dispatchMessage(Message message) {
        try {
            super.dispatchMessage(message);
        } catch (Exception e) {
            e.printStackTrace();
            List<String> list = sThreadExceptionRecord;
            list.add(Thread.currentThread().getName() + ":" + Log.getStackTraceString(e));
            if (XesLog.isEnabled()) {
                XesLog.e("涂鸦线程内发生异常", e);
            }
        }
    }
}
