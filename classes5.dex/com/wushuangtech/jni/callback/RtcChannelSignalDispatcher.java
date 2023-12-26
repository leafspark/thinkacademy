package com.wushuangtech.jni.callback;

import com.wushuangtech.constants.RtcNativeCallBackFun;
import com.wushuangtech.library.GlobalConfig;
import com.wushuangtech.library.GlobalHolder;
import com.wushuangtech.log.ReportLogger;
import com.wushuangtech.utils.OmniLog;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RtcChannelSignalDispatcher<T> {
    public static final int CLASS_TYPE_GLOBAL_SERVER_MESSAGE = 2;
    public static final int CLASS_TYPE_ROOM_JNI = 1;
    private static final String ERROR_MSG_PREFIX = "Failed to Dispatch signal message! ";
    private static final String TAG = "RtcChannelSignalDispatcher";
    private final List<T> mCallBacks = new ArrayList();
    private final String mClassTag;
    private int mClassType;
    private final Object mLock = new Object();

    public RtcChannelSignalDispatcher(String str) {
        this.mClassTag = str;
    }

    public void addCallback(T t) {
        if (t == null) {
            logE("Failed to add new signal callback object. the callback is null!");
            return;
        }
        synchronized (this.mLock) {
            boolean z = true;
            Iterator<T> it = this.mCallBacks.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                T next = it.next();
                if (next != null) {
                    if (next == t) {
                        z = false;
                        break;
                    }
                }
            }
            if (z) {
                this.mCallBacks.add(t);
                logI("Succeed in adding a new signal callback: " + t);
                if (this.mCallBacks.size() > 50) {
                    logE("The signal callback list has too many elements! size: " + this.mCallBacks.size());
                }
            }
        }
    }

    public void removeCallback(T t) {
        if (t == null) {
            logE("Failed to remove signal callBack. the callBack is null!");
            return;
        }
        synchronized (this.mLock) {
            int i = 0;
            Iterator<T> it = this.mCallBacks.iterator();
            while (true) {
                if (!it.hasNext()) {
                    i = -1;
                    break;
                }
                T next = it.next();
                if (next != null) {
                    if (next == t) {
                        break;
                    }
                    i++;
                }
            }
            if (i != -1) {
                logI("Succeed in removing the signal callback: " + t);
                this.mCallBacks.remove(i);
            }
        }
    }

    public void setClassType(int i) {
        this.mClassType = i;
    }

    public void receiveChannelSignalEvent(Object... objArr) {
        String str;
        ReportLogger rtcEventReporter;
        long currentTimeMillis = System.currentTimeMillis();
        try {
            str = Thread.currentThread().getStackTrace()[3].getMethodName();
        } catch (Exception e) {
            e.printStackTrace();
            str = null;
        }
        receiveChannelSignalEventWidthName(str, objArr);
        if (((int) (System.currentTimeMillis() - currentTimeMillis)) > 200 && (rtcEventReporter = GlobalHolder.getInstance().getRtcEventReporter(GlobalConfig.mLocalRoomName)) != null) {
            rtcEventReporter.reportCallBackSlowWarn(str);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0051, code lost:
        if (r4.mClassType != 1) goto L_0x0060;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0057, code lost:
        if (com.wushuangtech.utils.OmniLog.isFastCallBackMessage(r5) != false) goto L_0x0060;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0059, code lost:
        com.wushuangtech.utils.OmniLog.jniCall(r5, java.util.Arrays.toString(r6));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0060, code lost:
        r0 = r4.mClassType;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0062, code lost:
        if (r0 != 1) goto L_0x006a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0064, code lost:
        reportCallBack(com.wushuangtech.jni.RoomJni.RoomJniCallback.class, r1, r5, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x006b, code lost:
        if (r0 != 2) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x006d, code lost:
        reportCallBack(com.wushuangtech.inter.OnRtcGlobalServerMessageCallBack.class, r1, r5, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void receiveChannelSignalEventWidthName(java.lang.String r5, java.lang.Object... r6) {
        /*
            r4 = this;
            boolean r0 = android.text.TextUtils.isEmpty(r5)
            if (r0 == 0) goto L_0x0039
            java.lang.String r5 = "Failed to Dispatch signal message! target method name is null..."
            r4.logE(r5)
            java.lang.Thread r5 = java.lang.Thread.currentThread()     // Catch:{ Exception -> 0x0034 }
            java.lang.StackTraceElement[] r5 = r5.getStackTrace()     // Catch:{ Exception -> 0x0034 }
            int r6 = r5.length     // Catch:{ Exception -> 0x0034 }
            r0 = 0
        L_0x0015:
            if (r0 >= r6) goto L_0x0038
            r1 = r5[r0]     // Catch:{ Exception -> 0x0034 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0034 }
            r2.<init>()     // Catch:{ Exception -> 0x0034 }
            java.lang.String r3 = "Function call stack... "
            r2.append(r3)     // Catch:{ Exception -> 0x0034 }
            java.lang.String r1 = r1.getMethodName()     // Catch:{ Exception -> 0x0034 }
            r2.append(r1)     // Catch:{ Exception -> 0x0034 }
            java.lang.String r1 = r2.toString()     // Catch:{ Exception -> 0x0034 }
            r4.logE(r1)     // Catch:{ Exception -> 0x0034 }
            int r0 = r0 + 1
            goto L_0x0015
        L_0x0034:
            r5 = move-exception
            r5.printStackTrace()
        L_0x0038:
            return
        L_0x0039:
            java.lang.Object r0 = r4.mLock
            monitor-enter(r0)
            java.util.List<T> r1 = r4.mCallBacks     // Catch:{ all -> 0x0073 }
            int r1 = r1.size()     // Catch:{ all -> 0x0073 }
            if (r1 > 0) goto L_0x0046
            monitor-exit(r0)     // Catch:{ all -> 0x0073 }
            return
        L_0x0046:
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ all -> 0x0073 }
            java.util.List<T> r2 = r4.mCallBacks     // Catch:{ all -> 0x0073 }
            r1.<init>(r2)     // Catch:{ all -> 0x0073 }
            monitor-exit(r0)     // Catch:{ all -> 0x0073 }
            int r0 = r4.mClassType
            r2 = 1
            if (r0 != r2) goto L_0x0060
            boolean r0 = com.wushuangtech.utils.OmniLog.isFastCallBackMessage(r5)
            if (r0 != 0) goto L_0x0060
            java.lang.String r0 = java.util.Arrays.toString(r6)
            com.wushuangtech.utils.OmniLog.jniCall(r5, r0)
        L_0x0060:
            int r0 = r4.mClassType
            if (r0 != r2) goto L_0x006a
            java.lang.Class<com.wushuangtech.jni.RoomJni$RoomJniCallback> r0 = com.wushuangtech.jni.RoomJni.RoomJniCallback.class
            r4.reportCallBack(r0, r1, r5, r6)
            goto L_0x0072
        L_0x006a:
            r2 = 2
            if (r0 != r2) goto L_0x0072
            java.lang.Class<com.wushuangtech.inter.OnRtcGlobalServerMessageCallBack> r0 = com.wushuangtech.inter.OnRtcGlobalServerMessageCallBack.class
            r4.reportCallBack(r0, r1, r5, r6)
        L_0x0072:
            return
        L_0x0073:
            r5 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0073 }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wushuangtech.jni.callback.RtcChannelSignalDispatcher.receiveChannelSignalEventWidthName(java.lang.String, java.lang.Object[]):void");
    }

    private void reportCallBack(Class<T> cls, List<T> list, String str, Object... objArr) {
        Method method;
        Method[] methods = cls.getMethods();
        int length = methods.length;
        int i = 0;
        int i2 = 0;
        while (true) {
            if (i2 >= length) {
                method = null;
                break;
            }
            method = methods[i2];
            if (str.equals(method.getName())) {
                break;
            }
            i2++;
        }
        if (method == null) {
            logE("Failed to Dispatch signal message! Not found method... " + str);
            try {
                StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
                int length2 = stackTrace.length;
                while (i < length2) {
                    StackTraceElement stackTraceElement = stackTrace[i];
                    logE("Function call stack... " + stackTraceElement.getMethodName());
                    i++;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            reportEvent(str, objArr);
            while (i < list.size()) {
                T t = list.get(i);
                if (t != null) {
                    try {
                        method.invoke(t, objArr);
                    } catch (IllegalAccessException e2) {
                        e2.printStackTrace();
                        logE("Failed to Dispatch signal message! <" + str + "> IllegalAccessException : " + e2.getLocalizedMessage());
                    } catch (InvocationTargetException e3) {
                        e3.printStackTrace();
                        logE("Failed to Dispatch signal message! <" + str + "> InvocationTargetException : " + e3.getLocalizedMessage());
                    }
                }
                i++;
            }
        }
    }

    private void reportEvent(String str, Object[] objArr) {
        String str2;
        if (RtcNativeCallBackFun.CHANNEL_JOINED.equals(str)) {
            str2 = String.valueOf(objArr[0]);
        } else if (RtcNativeCallBackFun.CHANNEL_JOIN_TIMEOUT.equals(str)) {
            str2 = String.valueOf(objArr[0]);
        } else if (RtcNativeCallBackFun.CHANNEL_USER_JOINED.equals(str)) {
            str2 = String.valueOf(objArr[0]);
        } else if (RtcNativeCallBackFun.CHANNEL_USER_OFFLINE.equals(str)) {
            str2 = String.valueOf(objArr[0]);
        } else {
            str2 = RtcNativeCallBackFun.CHANNEL_SESSION_ID.equals(str) ? String.valueOf(objArr[0]) : "";
        }
        GlobalHolder.getInstance().handleRtcEventReport(str2, str, objArr);
    }

    private void logI(String str) {
        OmniLog.i(TAG + "<" + this.mClassTag + ">", str);
    }

    private void logE(String str) {
        OmniLog.e(TAG + "<" + this.mClassTag + ">", str);
    }
}
