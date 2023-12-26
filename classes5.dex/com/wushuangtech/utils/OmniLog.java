package com.wushuangtech.utils;

import android.content.Context;
import android.util.Log;
import com.wushuangtech.bean.FastLogCacheBean;
import com.wushuangtech.library.GlobalConfig;
import com.wushuangtech.library.GlobalHolder;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Locale;

public class OmniLog {
    private static final String ALLOCATE_MEMORY = "AllocateMemory";
    private static final String AUDIO_MIX_PLAY = "AUDIO_MIX_PLAY";
    public static final String AUDIO_SPEAK = "AUDIO_SPEAK";
    public static final String AUDIO_WATCH = "AUDIO_WATCH";
    public static final String CHANNEL_PUSH = "CHANNEL_PUSH";
    public static final String CHAT_SEND = "CHAT_WATCHER";
    public static final String CROSS_WATCH = "CROSS_WATCH";
    public static boolean DEBUG_MODE = false;
    public static final String DEVICE_WATCH = "DEVICE_WATCH";
    public static final String DUAL_VIDEO = "DUAL_WATCH";
    public static final String EXTERNAL_VIDEO_WATCH = "EXTERNAL_VIDEO_WATCH";
    private static final String FUN_ERROR = "FUN_ERROR";
    private static final String GLRENDERER = "OPENGL_WATCH|LocalPreview";
    public static final String INTER_CORRECT_WATCH = "INTER_CORRECT_WATCH";
    private static final String JNI_CALLBACK = "JNI_CALLBACK";
    public static final String LOCAL_PREVIEW = "LPW";
    public static final String LOG_WATCH = "LOG_WATCH";
    private static final String OMNI_CALLBACK = "OMNI_CALLBACK";
    private static final String OMNI_CHANNEL_CALLBACK = "OMNI_CHANNEL_CALLBACK";
    private static final String PBO_TEST = "PBO_TEST";
    private static final String PERMISSION_ERROR = "PERMISSION_ERROR";
    private static final String PLAY_EFFECT = "PlayEffect";
    public static boolean PRINT_FAST_MSG = false;
    public static final String RECORD_LOG_WATCH = "RECORD_LOG_WATCH";
    public static final String RELAY_WATCH = "RELAY_WATCH";
    public static final String REMOTE_VIDEO_WATCH = "RVW";
    public static final String REMOTE_VIEW = "RVW";
    public static final String ROOM_WATCH = "ROOM_WATCH";
    public static final String RTC_PUBLISH_WATCH = "RTC_PUBLISH_WATCH";
    public static final String RTMP_WATCH = "RTMP_WATCH";
    public static final String SCREEN_CAPTURE = "SCREEN_WATCH";
    public static final String SCREEN_ROTATE = "SCREEN_ROTATE";
    public static final String SESSION_WATCH = "SESSION_WATCH";
    public static final String TAG = "OMNI";
    public static final String TEST_WATCH = "TEST_WATCH";
    private static final String UNITY_VIDEO = "Unity Video Watch";
    public static final String USER_WATCH = "USER_WATCH";
    public static final String VIDEO_CAP_SPEED_WATCH = "VCSW";
    public static final String VIDEO_CAP_WATCH = "VCW";
    public static final String VIDEO_ENCODER_WATCH = "VEW";
    public static final String VIDEO_RENDER_WATCH = "VRW";
    private static final HashMap<String, FastLogCacheBean> fastLogCache = new HashMap<>();

    public static void gld(String str, String str2) {
    }

    public static void gldf(String str, String str2) {
    }

    public static void printFunInvoked(String str, Object... objArr) {
    }

    public static void debugD(String str, String str2) {
        if (DEBUG_MODE) {
            logD(TAG, formatLogMessage(str, str2));
        }
    }

    public static void debugD(String str, String str2, String str3) {
        if (DEBUG_MODE) {
            logD(TAG, formatWatchMessage(str, str2, str3));
        }
    }

    public static void i(String str) {
        logI(TAG, str);
    }

    public static void i(String str, String str2) {
        logI(TAG, formatLogMessage(str, str2));
    }

    public static void i(String str, String str2, String str3) {
        logI(TAG, formatWatchMessage(str, str2, str3));
    }

    public static void i2(String str, String str2) {
        logI2(TAG, formatLogMessage(str, str2));
    }

    public static void d(String str) {
        logD(TAG, str);
    }

    public static void w(String str) {
        logW(TAG, str);
    }

    public static void e(String str) {
        logE(TAG, str);
    }

    public static void d(String str, String str2) {
        logD(TAG, formatLogMessage(str, str2));
    }

    public static void d(String str, String str2, boolean z) {
        if (z) {
            logD(TAG, formatLogMessage(str, str2));
        } else {
            logD2(TAG, formatLogMessage(str, str2));
        }
    }

    public static void d(String str, String str2, String str3) {
        logD(TAG, formatWatchMessage(str, str2, str3));
    }

    public static void d(String str, String str2, String str3, boolean z) {
        if (z) {
            logD(TAG, formatWatchMessage(str, str2, str3));
        } else {
            logD2(TAG, formatWatchMessage(str, str2, str3));
        }
    }

    public static void w(String str, String str2) {
        logW(TAG, formatLogMessage(str, str2));
    }

    public static void w(String str, String str2, String str3) {
        logW(TAG, formatWatchMessage(str, str2, str3));
    }

    public static void w(String str, String str2, boolean z) {
        if (z) {
            logW(TAG, formatLogMessage(str, str2));
        } else {
            logW2(TAG, formatLogMessage(str, str2));
        }
    }

    public static void w(String str, String str2, String str3, boolean z) {
        if (z) {
            logW(TAG, formatWatchMessage(str, str2, str3));
        } else {
            logW2(TAG, formatWatchMessage(str, str2, str3));
        }
    }

    public static void e(String str, String str2) {
        logE(TAG, formatLogMessage(str, str2));
    }

    public static void e(String str, String str2, String str3) {
        logE(TAG, formatWatchMessage(str, str2, str3));
    }

    public static void e(String str, String str2, boolean z) {
        if (z) {
            logE(TAG, formatLogMessage(str, str2));
        } else {
            logE2(TAG, formatLogMessage(str, str2));
        }
    }

    public static void e(String str, String str2, String str3, boolean z) {
        if (z) {
            logE(TAG, formatWatchMessage(str, str2, str3));
        } else {
            logE2(TAG, formatWatchMessage(str, str2, str3));
        }
    }

    public static void fd(FastLogCacheBean fastLogCacheBean) {
        long currentTimeMillis = System.currentTimeMillis();
        HashMap<String, FastLogCacheBean> hashMap = fastLogCache;
        FastLogCacheBean fastLogCacheBean2 = hashMap.get(fastLogCacheBean.mKey);
        if (fastLogCacheBean2 == null) {
            fastLogCacheBean.mTimestamp = currentTimeMillis;
            hashMap.put(fastLogCacheBean.mKey, fastLogCacheBean);
            printFd(fastLogCacheBean);
        } else if (currentTimeMillis - fastLogCacheBean2.mTimestamp >= ((long) fastLogCacheBean2.mInterval)) {
            fastLogCacheBean2.mMessage = fastLogCacheBean.mMessage;
            fastLogCacheBean2.mTimestamp = currentTimeMillis;
            printFd(fastLogCacheBean2);
        }
    }

    private static void printFd(FastLogCacheBean fastLogCacheBean) {
        String str;
        if (fastLogCacheBean.mWatcher != null) {
            str = formatWatchMessage(fastLogCacheBean.mWatcher, fastLogCacheBean.mTag, fastLogCacheBean.mMessage);
        } else {
            str = formatLogMessage(fastLogCacheBean.mTag, fastLogCacheBean.mMessage);
        }
        if (fastLogCacheBean.mLevel == 4) {
            logFastI(TAG, str, fastLogCacheBean.mInterval > 2000);
        } else {
            logFastD(TAG, str);
        }
    }

    public static void jniCall(String str, String str2) {
        logI(TAG, "[JNI_CALLBACK] -> METHOD = " + str + " --> " + str2);
    }

    public static void omniCall(String str, String str2) {
        logI(TAG, "[OMNI_CALLBACK] -> METHOD = " + str + " --> " + str2);
    }

    public static void omniCall(String str, String str2, String str3) {
        logI(TAG, "[OMNI_CHANNEL_CALLBACK] -> METHOD = " + str2 + " --> channelName : " + str + " | " + str3);
    }

    public static void funEmptyError(String str, String str2, String str3) {
        logW(FUN_ERROR, "Invoke <" + str + "> error , the var <" + str2 + "> is null! args : " + str3);
    }

    public static void lp(String str, String str2) {
        logD(TAG, "LPW -> " + str + " -> " + str2);
    }

    public static void lpw(String str, String str2) {
        logW(TAG, "LPW -> " + str + " -> " + str2);
    }

    public static void lpe(String str, String str2) {
        logE(TAG, "LPW -> " + str + " -> " + str2);
    }

    public static void ped(String str, String str2) {
        logD(TAG, "PlayEffect -> " + str + " -> " + str2);
    }

    public static void amd(String str, String str2) {
        logD(TAG, "AllocateMemory -> " + str + " -> " + str2);
    }

    public static void gldw(String str, String str2) {
        logW(TAG, formatWatchMessage(GLRENDERER, str, str2));
    }

    public static void glde(String str, String str2) {
        logE(TAG, formatWatchMessage(GLRENDERER, str, str2));
    }

    public static void ptd(String str, String str2) {
        logD(TAG, "PBO_TEST -> " + str + " -> " + str2);
    }

    public static void pdw(String str, String str2) {
        logI(TAG, formatWatchMessage(DEVICE_WATCH, str, str2));
    }

    public static void pdww(String str, String str2) {
        logW(TAG, formatWatchMessage(DEVICE_WATCH, str, str2));
    }

    public static void pdwe(String str, String str2) {
        logE(TAG, formatWatchMessage(DEVICE_WATCH, str, str2));
    }

    public static void rv_i(String str, String str2) {
        logI(TAG, formatWatchMessage("RVW", str, str2));
    }

    public static void rv_d(String str, String str2) {
        logD(TAG, formatWatchMessage("RVW", str, str2));
    }

    public static void rv_w(String str, String str2) {
        logW(TAG, formatWatchMessage("RVW", str, str2));
    }

    public static void rv_e(String str, String str2) {
        logE(TAG, formatWatchMessage("RVW", str, str2));
    }

    public static void rw_i(String str, String str2) {
        logI(TAG, formatWatchMessage(ROOM_WATCH, str, str2));
    }

    public static void rw_d(String str, String str2) {
        logD(TAG, formatWatchMessage(ROOM_WATCH, str, str2));
    }

    public static void rw_w(String str, String str2) {
        logW(TAG, formatWatchMessage(ROOM_WATCH, str, str2));
    }

    public static void rw_e(String str, String str2) {
        logE(TAG, formatWatchMessage(ROOM_WATCH, str, str2));
    }

    public static void aw_i(String str, String str2) {
        logI(TAG, formatWatchMessage(AUDIO_WATCH, str, str2));
    }

    public static void aw_d(String str, String str2) {
        logD(TAG, formatWatchMessage(AUDIO_WATCH, str, str2));
    }

    public static void aw_e(String str, String str2) {
        logE(TAG, formatWatchMessage(AUDIO_WATCH, str, str2));
    }

    public static void rtmp_d(String str, String str2) {
        logD(TAG, formatWatchMessage(RTMP_WATCH, str, str2));
    }

    public static void rtmp_e(String str, String str2) {
        logE(TAG, formatWatchMessage(RTMP_WATCH, str, str2));
    }

    public static void screen_d(String str, String str2) {
        logD(TAG, formatWatchMessage(SCREEN_CAPTURE, str, str2));
    }

    public static void screen_e(String str, String str2) {
        logE(TAG, formatWatchMessage(SCREEN_CAPTURE, str, str2));
    }

    public static void uty_d(String str, String str2) {
        logD(TAG, formatWatchMessage(UNITY_VIDEO, str, str2));
    }

    public static void uty_e(String str, String str2) {
        logE(TAG, formatWatchMessage(UNITY_VIDEO, str, str2));
    }

    public static String getInvokedMethodName() {
        return Thread.currentThread().getStackTrace()[3].getMethodName();
    }

    public static String getInvokedMethodNameWithFormat() {
        return Thread.currentThread().getStackTrace()[3].getMethodName() + " -> ";
    }

    public static boolean isFastCallBackMessage(String str) {
        for (String equals : GlobalConfig.mFastCallBack) {
            if (str.equals(equals)) {
                return true;
            }
        }
        return false;
    }

    public static void testPrint(String str, Object... objArr) {
        String format = new SimpleDateFormat("HH:mm:ss:SSS", Locale.CHINA).format(Long.valueOf(System.currentTimeMillis()));
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        sb.append(format);
        sb.append("] ");
        sb.append(str);
        sb.append(" -> ");
        for (Object append : objArr) {
            sb.append(append);
        }
        GlobalHolder.getInstance().notifyCHTestString(sb.toString());
    }

    public static boolean isApkDebugable(Context context) {
        try {
            if ((context.getApplicationInfo().flags & 2) != 0) {
                return true;
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public static void printStackTrace() {
        Log.d("wzgtest", Log.getStackTraceString(new Throwable()));
    }

    public static void logStackTrace() {
        logI(TAG, Log.getStackTraceString(new Throwable()));
    }

    public static String formatLogMessage(String str, String str2) {
        return "[" + str + "] - " + str2;
    }

    private static String formatWatchMessage(String str, String str2, String str3) {
        return "[" + str + "][" + str2 + "] -> " + str3;
    }

    private static String formatImportLogMessage(int i, String str) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS", Locale.getDefault());
        String str2 = i != 2 ? i != 3 ? i != 4 ? i != 5 ? null : "D" : "I" : "W" : "E";
        if (str2 == null) {
            return null;
        }
        long id = Thread.currentThread().getId();
        return str2 + "/" + TAG + ": [" + simpleDateFormat.format(Long.valueOf(System.currentTimeMillis())) + "][" + id + "] " + str;
    }

    private static void logFastI(String str, String str2, boolean z) {
        if (z) {
            String formatImportLogMessage = formatImportLogMessage(4, str2);
            GlobalHolder.getInstance().sendSyncRtcEngineEvent(1, 4, formatImportLogMessage);
        }
        if (GlobalConfig.mLogFilterLevel != 0) {
            if (GlobalConfig.mLogFilterLevel == 15 || GlobalConfig.mLogFilterLevel == 2063) {
                Log.i(str, str2);
            }
        }
    }

    private static void logFastD(String str, String str2) {
        if (GlobalConfig.mLogFilterLevel != 0 && GlobalConfig.mLogFilterLevel == 2063) {
            Log.d(str, str2);
        }
    }

    private static void logI(String str, String str2) {
        String formatImportLogMessage = formatImportLogMessage(4, str2);
        GlobalHolder.getInstance().sendSyncRtcEngineEvent(1, 4, formatImportLogMessage);
        if (GlobalConfig.mLogFilterLevel != 0) {
            if (GlobalConfig.mLogFilterLevel == 15 || GlobalConfig.mLogFilterLevel == 2063) {
                Log.i(str, str2);
            }
        }
    }

    private static void logI2(String str, String str2) {
        if (GlobalConfig.mLogFilterLevel != 0) {
            if (GlobalConfig.mLogFilterLevel == 15 || GlobalConfig.mLogFilterLevel == 2063) {
                Log.i(str, str2);
            }
        }
    }

    private static void logD(String str, String str2) {
        String formatImportLogMessage = formatImportLogMessage(5, str2);
        GlobalHolder.getInstance().sendSyncRtcEngineEvent(1, 5, formatImportLogMessage);
        if (GlobalConfig.mLogFilterLevel != 0 && GlobalConfig.mLogFilterLevel == 2063) {
            Log.d(str, str2);
        }
    }

    private static void logD2(String str, String str2) {
        if (GlobalConfig.mLogFilterLevel != 0 && GlobalConfig.mLogFilterLevel == 2063) {
            Log.d(str, str2);
        }
    }

    private static void logW(String str, String str2) {
        String formatImportLogMessage = formatImportLogMessage(3, str2);
        GlobalHolder.getInstance().sendSyncRtcEngineEvent(1, 3, formatImportLogMessage);
        if (GlobalConfig.mLogFilterLevel != 0 && GlobalConfig.mLogFilterLevel != 12 && GlobalConfig.mLogFilterLevel != 8) {
            Log.w(str, str2);
        }
    }

    private static void logW2(String str, String str2) {
        if (GlobalConfig.mLogFilterLevel != 0 && GlobalConfig.mLogFilterLevel != 12 && GlobalConfig.mLogFilterLevel != 8) {
            Log.w(str, str2);
        }
    }

    private static void logE(String str, String str2) {
        String formatImportLogMessage = formatImportLogMessage(2, str2);
        GlobalHolder.getInstance().sendSyncRtcEngineEvent(1, 2, formatImportLogMessage);
        if (GlobalConfig.mLogFilterLevel != 0 && GlobalConfig.mLogFilterLevel != 8) {
            Log.e(str, str2);
        }
    }

    private static void logE2(String str, String str2) {
        if (GlobalConfig.mLogFilterLevel != 0 && GlobalConfig.mLogFilterLevel != 8) {
            Log.e(str, str2);
        }
    }
}
