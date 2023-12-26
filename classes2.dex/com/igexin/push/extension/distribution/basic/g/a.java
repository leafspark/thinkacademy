package com.igexin.push.extension.distribution.basic.g;

import android.content.Context;
import com.igexin.b.a.c.b;

public class a {
    private static int a;
    private static int b;

    public static boolean a(Context context) {
        int i = b;
        boolean z = false;
        if ((i & 1) != 0) {
            return (i & 2) != 0;
        }
        try {
            z = ((Boolean) Class.forName("com.igexin.assist.control.xiaomi.MiuiPushManager").getMethod("checkXMDevice", new Class[]{Context.class}).invoke((Object) null, new Object[]{context})).booleanValue();
            if (z) {
                b |= 2;
            }
        } catch (Throwable unused) {
        }
        b |= 1;
        return z;
    }

    public static boolean b(Context context) {
        int i = a;
        boolean z = false;
        if ((i & 1) != 0) {
            return (i & 2) != 0;
        }
        try {
            z = ((Boolean) Class.forName("com.igexin.assist.control.meizu.FlymePushManager").getMethod("checkMZDevice", new Class[]{Context.class}).invoke((Object) null, new Object[]{context})).booleanValue();
            if (z) {
                a |= 2;
            }
        } catch (Throwable unused) {
        }
        a |= 1;
        return z;
    }

    public static void c(Context context) {
        try {
            if (a(context)) {
                Class.forName("com.xiaomi.mipush.sdk.MiPushClient").getDeclaredMethod("clearNotification", new Class[]{Context.class}).invoke((Object) null, new Object[]{context});
                b.a("AssistUtil | cancelAllAssistNotification() XM ", new Object[0]);
            } else if (b(context)) {
                Class.forName("com.meizu.cloud.pushsdk.PushManager").getDeclaredMethod("clearNotification", new Class[]{Context.class}).invoke((Object) null, new Object[]{context});
                b.a("AssistUtil | cancelAllAssistNotification() MZ ", new Object[0]);
            }
        } catch (Throwable th) {
            b.a("AssistUtil | cancelAllAssistNotification() err " + th.toString(), new Object[0]);
        }
    }
}
