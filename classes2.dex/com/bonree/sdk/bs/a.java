package com.bonree.sdk.bs;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.widget.Toast;
import com.bonree.sdk.agent.Bonree;
import java.util.Iterator;
import java.util.List;

public final class a extends j {
    private static final short a = 1;
    private static Handler b;
    private static Context c;

    public static void a(Context context) {
        if (context != null) {
            c = context;
        }
    }

    public static Context a() {
        if (!(c instanceof Application)) {
            Object a2 = a("android.app.ActivityThread", "currentApplication", (Class<?>[]) null, (Object[]) null);
            if (a2 instanceof Application) {
                c = ((Application) a2).getApplicationContext();
            }
            if (c == null) {
                c = Bonree.getApplicationContext();
            }
        }
        return c;
    }

    public static boolean b(Context context) {
        if (context == null) {
            return false;
        }
        try {
            String c2 = c(context);
            if (TextUtils.isEmpty(c2)) {
                return false;
            }
            return c2.equals(c());
        } catch (Throwable unused) {
            return false;
        }
    }

    public static String c(Context context) {
        if (context != null) {
            return context.getPackageName();
        }
        Context context2 = c;
        return context2 != null ? context2.getPackageName() : "";
    }

    private static String a(int i, Context context) {
        ActivityManager activityManager;
        if (context != null) {
            activityManager = (ActivityManager) context.getSystemService("activity");
        } else {
            activityManager = (ActivityManager) a().getSystemService("activity");
        }
        if (activityManager == null) {
            return "";
        }
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
        if (runningAppProcesses == null) {
            return null;
        }
        for (ActivityManager.RunningAppProcessInfo next : runningAppProcesses) {
            if (next.pid == i) {
                return next.processName;
            }
        }
        return null;
    }

    public static synchronized Handler b() {
        Handler handler;
        synchronized (a.class) {
            if (b == null) {
                b = new C0018a();
            }
            handler = b;
        }
        return handler;
    }

    static void a(String str) {
        if (str != null) {
            b().sendMessage(b().obtainMessage(1, str));
        }
    }

    /* renamed from: com.bonree.sdk.bs.a$a  reason: collision with other inner class name */
    static class C0018a extends Handler {
        C0018a() {
            super(Looper.getMainLooper());
        }

        public final void handleMessage(Message message) {
            if (message.what == 1 && a.a() != null) {
                Toast.makeText(a.a(), (String) message.obj, 1).show();
            }
        }
    }

    private static String b(int i, Context context) {
        ActivityManager activityManager;
        String str;
        if (context != null) {
            activityManager = (ActivityManager) context.getSystemService("activity");
        } else {
            activityManager = (ActivityManager) a().getSystemService("activity");
        }
        if (activityManager == null) {
            str = "";
        } else {
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
            if (runningAppProcesses != null) {
                Iterator<ActivityManager.RunningAppProcessInfo> it = runningAppProcesses.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    ActivityManager.RunningAppProcessInfo next = it.next();
                    if (next.pid == i) {
                        str = next.processName;
                        break;
                    }
                }
            }
            str = null;
        }
        return TextUtils.isEmpty(str) ? a(i) : str;
    }
}
