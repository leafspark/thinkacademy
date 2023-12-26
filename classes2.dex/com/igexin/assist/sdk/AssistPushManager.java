package com.igexin.assist.sdk;

import android.content.Context;
import com.igexin.assist.control.AbstractPushManager;
import com.igexin.push.core.b.i;
import com.igexin.push.core.d;

public class AssistPushManager {
    private AbstractPushManager a;

    private AssistPushManager() {
    }

    public static boolean checkSupportDevice(Context context) {
        return a.h(context);
    }

    public static AssistPushManager getInstance() {
        return c.a;
    }

    public static String getToken() {
        return d.B;
    }

    public String getSpToken() {
        try {
            return new com.igexin.push.core.b.d(d.g).e();
        } catch (Throwable unused) {
            return null;
        }
    }

    public void initialize(Context context) {
        this.a = a.a(context);
    }

    public void register(Context context) {
        AbstractPushManager abstractPushManager = this.a;
        if (abstractPushManager != null) {
            abstractPushManager.register(context);
        }
    }

    public void saveToken(String str) {
        i.a().c(str);
    }

    public void setSilentTime(Context context, int i, int i2) {
        AbstractPushManager abstractPushManager = this.a;
        if (abstractPushManager != null) {
            abstractPushManager.setSilentTime(context, i, i2);
        }
    }

    public void turnOffPush(Context context) {
        AbstractPushManager abstractPushManager = this.a;
        if (abstractPushManager != null) {
            abstractPushManager.turnOffPush(context);
        }
    }

    public void turnOnPush(Context context) {
        AbstractPushManager abstractPushManager = this.a;
        if (abstractPushManager != null) {
            abstractPushManager.turnOnPush(context);
        }
    }

    public void unregister(Context context) {
        AbstractPushManager abstractPushManager = this.a;
        if (abstractPushManager != null) {
            abstractPushManager.unregister(context);
        }
    }
}
