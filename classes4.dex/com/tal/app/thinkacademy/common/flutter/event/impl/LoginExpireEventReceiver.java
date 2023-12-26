package com.tal.app.thinkacademy.common.flutter.event.impl;

import com.tal.app.thinkacademy.common.flutter.event.FlutterEventReceiver;
import kotlin.Metadata;

@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\u0012\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\t"}, d2 = {"Lcom/tal/app/thinkacademy/common/flutter/event/impl/LoginExpireEventReceiver;", "Lcom/tal/app/thinkacademy/common/flutter/event/FlutterEventReceiver;", "()V", "getEventKey", "", "onEventReceive", "", "data", "", "common_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* compiled from: LoginExpireEventReceiver.kt */
public final class LoginExpireEventReceiver implements FlutterEventReceiver {
    public String getEventKey() {
        return "eventLoginExpire";
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v3, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onEventReceive(java.lang.Object r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof java.util.Map
            r1 = 0
            if (r0 == 0) goto L_0x0008
            java.util.Map r5 = (java.util.Map) r5
            goto L_0x0009
        L_0x0008:
            r5 = r1
        L_0x0009:
            android.os.Bundle r0 = new android.os.Bundle
            r0.<init>()
            if (r5 != 0) goto L_0x0011
            goto L_0x0027
        L_0x0011:
            r2 = 1
            java.lang.String r3 = "isToken"
            r0.putBoolean(r3, r2)
            java.lang.String r2 = "message"
            java.lang.Object r5 = r5.get(r2)
            boolean r3 = r5 instanceof java.lang.String
            if (r3 == 0) goto L_0x0024
            r1 = r5
            java.lang.String r1 = (java.lang.String) r1
        L_0x0024:
            r0.putString(r2, r1)
        L_0x0027:
            com.tal.app.thinkacademy.lib.route.XesRoute r5 = com.tal.app.thinkacademy.lib.route.XesRoute.getInstance()
            java.lang.String r1 = "/home/main_activity"
            r5.navigation(r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tal.app.thinkacademy.common.flutter.event.impl.LoginExpireEventReceiver.onEventReceive(java.lang.Object):void");
    }
}
