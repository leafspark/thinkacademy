package com.igexin.assist.sdk;

import android.content.Context;
import android.util.Log;
import com.igexin.assist.control.AbstractPushManager;
import com.igexin.b.a.c.b;
import com.igexin.push.config.l;
import com.igexin.push.core.b.i;

public class a {
    private static int a;
    private static int b;
    private static int c;
    private static int d;
    private static int e;
    private static int f;
    private static int g;
    private static int h;

    static AbstractPushManager a(Context context) {
        try {
            if (b(context)) {
                if (l.C) {
                    Log.d("Assist_PM", "support xm device");
                    b.a("Assist_PM|MiuiPushManager checkDevice flag = true", new Object[0]);
                    return a("com.igexin.assist.control.xiaomi.MiuiPushManager", context);
                }
            }
            if (c(context) && l.D) {
                Log.d("Assist_PM", "support mz device");
                b.a("Assist_PM|FlymePushManager checkDevice flag = true", new Object[0]);
                return a("com.igexin.assist.control.meizu.FlymePushManager", context);
            } else if (d(context) && l.E) {
                Log.d("Assist_PM", "support hw device");
                b.a("Assist_PM|HmsPushManager checkDevice flag = true", new Object[0]);
                return a("com.igexin.assist.control.huawei.HmsPushManager", context);
            } else if (e(context) && l.F) {
                Log.d("Assist_PM", "support oppo device");
                b.a("Assist_PM|OppoPushManager checkDevice flag = true", new Object[0]);
                return a("com.igexin.assist.control.oppo.OppoPushManager", context);
            } else if (f(context) && l.G) {
                Log.d("Assist_PM", "support vivo device");
                b.a("Assist_PM|VivoPushManager checkDevice flag = true", new Object[0]);
                return a("com.igexin.assist.control.vivo.VivoPushManager", context);
            } else if (g(context) && com.igexin.push.util.a.f()) {
                Log.d("Assist_PM", "support smartisan device");
                b.a("Assist_PM|SmartisanPushManager checkDevice flag = true", new Object[0]);
                return a("com.igexin.assist.control.st.SmartisanPushManager", context);
            } else if (!i(context) || !l.H) {
                b.a("Assist_PM|getPushManager = null, setToken = false", new Object[0]);
                i.a().c("false");
                b.a("Assist_PM|OtherPushManager = null", new Object[0]);
                return null;
            } else {
                b.a("Assist_PM|FcmPushManager checkDevice flag = true", new Object[0]);
                return a("com.igexin.assist.control.fcm.FcmPushManager", context);
            }
        } catch (Throwable unused) {
        }
    }

    private static AbstractPushManager a(String str, Context context) {
        try {
            return (AbstractPushManager) Class.forName(str).getConstructor(new Class[]{Context.class}).newInstance(new Object[]{context});
        } catch (Exception unused) {
            return null;
        }
    }

    public static boolean b(Context context) {
        int i = d;
        boolean z = false;
        if ((i & 1) != 0) {
            return (i & 2) != 0;
        }
        try {
            z = ((Boolean) Class.forName("com.igexin.assist.control.xiaomi.MiuiPushManager").getMethod("checkXMDevice", new Class[]{Context.class}).invoke((Object) null, new Object[]{context})).booleanValue();
            if (z) {
                d |= 2;
            }
        } catch (Throwable unused) {
        }
        d |= 1;
        return z;
    }

    public static boolean c(Context context) {
        int i = c;
        boolean z = false;
        if ((i & 1) != 0) {
            return (i & 2) != 0;
        }
        try {
            z = ((Boolean) Class.forName("com.igexin.assist.control.meizu.FlymePushManager").getMethod("checkMZDevice", new Class[]{Context.class}).invoke((Object) null, new Object[]{context})).booleanValue();
            if (z) {
                c |= 2;
            }
        } catch (Throwable unused) {
        }
        c |= 1;
        return z;
    }

    public static boolean d(Context context) {
        int i = a;
        boolean z = false;
        if ((i & 1) != 0) {
            return (i & 2) != 0;
        }
        try {
            z = ((Boolean) Class.forName("com.igexin.assist.control.huawei.HmsPushManager").getMethod("checkHWDevice", new Class[]{Context.class}).invoke((Object) null, new Object[]{context})).booleanValue();
            if (z) {
                a |= 2;
            }
        } catch (Throwable unused) {
        }
        a |= 1;
        return z;
    }

    public static boolean e(Context context) {
        int i = b;
        boolean z = false;
        if ((i & 1) != 0) {
            return (i & 2) != 0;
        }
        try {
            z = ((Boolean) Class.forName("com.igexin.assist.control.oppo.OppoPushManager").getMethod("checkOppoDevice", new Class[]{Context.class}).invoke((Object) null, new Object[]{context})).booleanValue();
            if (z) {
                b |= 2;
            }
        } catch (Throwable unused) {
        }
        b |= 1;
        return z;
    }

    public static boolean f(Context context) {
        int i = e;
        boolean z = false;
        if ((i & 1) != 0) {
            return (i & 2) != 0;
        }
        try {
            z = ((Boolean) Class.forName("com.igexin.assist.control.vivo.VivoPushManager").getMethod("checkVivoDevice", new Class[]{Context.class}).invoke((Object) null, new Object[]{context})).booleanValue();
            if (z) {
                e |= 2;
            }
        } catch (Throwable unused) {
        }
        e |= 1;
        return z;
    }

    public static boolean g(Context context) {
        int i = f;
        boolean z = false;
        if ((i & 1) != 0) {
            return (i & 2) != 0;
        }
        try {
            z = ((Boolean) Class.forName("com.igexin.assist.control.st.SmartisanPushManager").getMethod("checkSTDevice", new Class[]{Context.class}).invoke((Object) null, new Object[]{context})).booleanValue();
            if (z) {
                f |= 2;
            }
        } catch (Throwable unused) {
        }
        f |= 1;
        return z;
    }

    public static boolean h(Context context) {
        int i = h;
        boolean z = false;
        if ((i & 1) != 0) {
            return (i & 2) != 0;
        }
        if (c(context) || b(context) || d(context) || e(context) || f(context) || g(context)) {
            z = true;
        }
        if (z) {
            h |= 2;
        }
        h |= 1;
        return z;
    }

    public static boolean i(Context context) {
        int i = g;
        boolean z = false;
        if ((i & 1) != 0) {
            return (i & 2) != 0;
        }
        try {
            z = ((Boolean) Class.forName("com.igexin.assist.control.fcm.FcmPushManager").getMethod("checkFcmDevice", new Class[]{Context.class}).invoke((Object) null, new Object[]{context})).booleanValue();
            if (z) {
                g |= 2;
            }
        } catch (Throwable unused) {
        }
        g |= 1;
        return z;
    }

    public static void j(Context context) {
        try {
            if (b(context)) {
                Class.forName("com.xiaomi.mipush.sdk.MiPushClient").getDeclaredMethod("clearNotification", new Class[]{Context.class}).invoke((Object) null, new Object[]{context});
                b.a("Assist_PM | cancelAllAssistNotification() XM ", new Object[0]);
            } else if (c(context)) {
                Class.forName("com.meizu.cloud.pushsdk.PushManager").getDeclaredMethod("clearNotification", new Class[]{Context.class}).invoke((Object) null, new Object[]{context});
                b.a("Assist_PM | cancelAllAssistNotification() MZ ", new Object[0]);
            }
        } catch (Throwable th) {
            b.a("Assist_PM | cancelAllAssistNotification() err " + th.toString(), new Object[0]);
        }
    }
}
