package com.tal100.mars.xlog;

import android.content.Context;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.os.Process;
import android.widget.Toast;
import com.bonree.sdk.agent.engine.external.AsynchronousInstrumentation;

public class Log {
    public static final int LEVEL_DEBUG = 1;
    public static final int LEVEL_ERROR = 4;
    public static final int LEVEL_FATAL = 5;
    public static final int LEVEL_INFO = 2;
    public static final int LEVEL_NONE = 6;
    public static final int LEVEL_VERBOSE = 0;
    public static final int LEVEL_WARNING = 3;
    private static final String SYS_INFO;
    private static final String TAG = "mars.xlog.log";
    private static LogImp debugLog = null;
    /* access modifiers changed from: private */
    public static int level = 6;
    private static LogImp logImp;
    public static Context toastSupportContext;

    public interface LogImp {
        void appenderClose();

        void appenderFlush(boolean z);

        int getLogLevel();

        void logD(String str, String str2, String str3, int i, int i2, long j, long j2, String str4);

        void logE(String str, String str2, String str3, int i, int i2, long j, long j2, String str4);

        void logF(String str, String str2, String str3, int i, int i2, long j, long j2, String str4);

        void logI(String str, String str2, String str3, int i, int i2, long j, long j2, String str4);

        void logV(String str, String str2, String str3, int i, int i2, long j, long j2, String str4);

        void logW(String str, String str2, String str3, int i, int i2, long j, long j2, String str4);
    }

    static {
        System.loadLibrary("chat-native-lib");
        AnonymousClass1 r0 = new LogImp() {
            private Handler handler = new Handler(Looper.getMainLooper());

            public void appenderClose() {
            }

            public void appenderFlush(boolean z) {
            }

            public void logV(String str, String str2, String str3, int i, int i2, long j, long j2, String str4) {
                if (Log.level <= 0) {
                    android.util.Log.v(str, str4);
                }
            }

            public void logI(String str, String str2, String str3, int i, int i2, long j, long j2, String str4) {
                if (Log.level <= 2) {
                    android.util.Log.i(str, str4);
                }
            }

            public void logD(String str, String str2, String str3, int i, int i2, long j, long j2, String str4) {
                if (Log.level <= 1) {
                    android.util.Log.d(str, str4);
                }
            }

            public void logW(String str, String str2, String str3, int i, int i2, long j, long j2, String str4) {
                if (Log.level <= 3) {
                    android.util.Log.w(str, str4);
                }
            }

            public void logE(String str, String str2, String str3, int i, int i2, long j, long j2, String str4) {
                if (Log.level <= 4) {
                    android.util.Log.e(str, str4);
                }
            }

            public void logF(String str, String str2, String str3, int i, int i2, long j, long j2, final String str4) {
                if (Log.level <= 5) {
                    android.util.Log.e(str, str4);
                    if (Log.toastSupportContext != null) {
                        Handler handler2 = this.handler;
                        AnonymousClass1 r2 = new Runnable() {
                            public void run() {
                                Toast.makeText(Log.toastSupportContext, str4, 1).show();
                            }
                        };
                        if (!(handler2 instanceof Handler)) {
                            handler2.post(r2);
                        } else {
                            AsynchronousInstrumentation.handlerPost(handler2, r2);
                        }
                    }
                }
            }

            public int getLogLevel() {
                return Log.level;
            }
        };
        debugLog = r0;
        logImp = r0;
        StringBuilder sb = new StringBuilder();
        try {
            sb.append("VERSION.RELEASE:[" + Build.VERSION.RELEASE);
            sb.append("] VERSION.CODENAME:[" + Build.VERSION.CODENAME);
            sb.append("] VERSION.INCREMENTAL:[" + Build.VERSION.INCREMENTAL);
            sb.append("] BOARD:[" + Build.BOARD);
            sb.append("] DEVICE:[" + Build.DEVICE);
            sb.append("] DISPLAY:[" + Build.DISPLAY);
            sb.append("] FINGERPRINT:[" + Build.FINGERPRINT);
            sb.append("] HOST:[" + Build.HOST);
            sb.append("] MANUFACTURER:[" + Build.MANUFACTURER);
            sb.append("] MODEL:[" + Build.MODEL);
            sb.append("] PRODUCT:[" + Build.PRODUCT);
            sb.append("] TAGS:[" + Build.TAGS);
            sb.append("] TYPE:[" + Build.TYPE);
            sb.append("] USER:[" + Build.USER + "]");
        } catch (Throwable th) {
            th.printStackTrace();
        }
        SYS_INFO = sb.toString();
    }

    public static void setLogImp(LogImp logImp2) {
        logImp = logImp2;
    }

    public static LogImp getImpl() {
        return logImp;
    }

    public static void appenderClose() {
        LogImp logImp2 = logImp;
        if (logImp2 != null) {
            logImp2.appenderClose();
        }
    }

    public static void appenderFlush(boolean z) {
        LogImp logImp2 = logImp;
        if (logImp2 != null) {
            logImp2.appenderFlush(z);
        }
    }

    public static int getLogLevel() {
        LogImp logImp2 = logImp;
        if (logImp2 != null) {
            return logImp2.getLogLevel();
        }
        return 6;
    }

    public static void setLevel(int i, boolean z) {
        level = i;
        android.util.Log.w(TAG, "new log level: " + i);
        if (z) {
            Xlog.setLogLevel(i);
        }
    }

    public static void f(String str, String str2) {
        f(str, str2, (Object[]) null);
    }

    public static void e(String str, String str2) {
        e(str, str2, (Object[]) null);
    }

    public static void w(String str, String str2) {
        w(str, str2, (Object[]) null);
    }

    public static void i(String str, String str2) {
        i(str, str2, (Object[]) null);
    }

    public static void d(String str, String str2) {
        d(str, str2, (Object[]) null);
    }

    public static void v(String str, String str2) {
        v(str, str2, (Object[]) null);
    }

    public static void f(String str, String str2, Object... objArr) {
        if (logImp != null) {
            if (objArr != null) {
                str2 = String.format(str2, objArr);
            }
            String str3 = str;
            logImp.logF(str3, "", "", 0, Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), str2);
        }
    }

    public static void e(String str, String str2, Object... objArr) {
        if (logImp != null) {
            if (objArr != null) {
                str2 = String.format(str2, objArr);
            }
            if (str2 == null) {
                str2 = "";
            }
            String str3 = str;
            logImp.logE(str3, "", "", 0, Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), str2);
        }
    }

    public static void w(String str, String str2, Object... objArr) {
        if (logImp != null) {
            if (objArr != null) {
                str2 = String.format(str2, objArr);
            }
            if (str2 == null) {
                str2 = "";
            }
            String str3 = str;
            logImp.logW(str3, "", "", 0, Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), str2);
        }
    }

    public static void i(String str, String str2, Object... objArr) {
        if (logImp != null) {
            if (objArr != null) {
                str2 = String.format(str2, objArr);
            }
            if (str2 == null) {
                str2 = "";
            }
            String str3 = str;
            logImp.logI(str3, "", "", 0, Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), str2);
        }
    }

    public static void d(String str, String str2, Object... objArr) {
        if (logImp != null) {
            if (objArr != null) {
                str2 = String.format(str2, objArr);
            }
            if (str2 == null) {
                str2 = "";
            }
            String str3 = str;
            logImp.logD(str3, "", "", 0, Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), str2);
        }
    }

    public static void v(String str, String str2, Object... objArr) {
        if (logImp != null) {
            if (objArr != null) {
                str2 = String.format(str2, objArr);
            }
            if (str2 == null) {
                str2 = "";
            }
            String str3 = str;
            logImp.logV(str3, "", "", 0, Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), str2);
        }
    }

    public static void printErrStackTrace(String str, Throwable th, String str2, Object... objArr) {
        if (logImp != null) {
            if (objArr != null) {
                str2 = String.format(str2, objArr);
            }
            if (str2 == null) {
                str2 = "";
            }
            String str3 = str;
            logImp.logE(str3, "", "", 0, Process.myPid(), Thread.currentThread().getId(), Looper.getMainLooper().getThread().getId(), str2 + "  " + android.util.Log.getStackTraceString(th));
        }
    }

    public static String getSysInfo() {
        return SYS_INFO;
    }
}
