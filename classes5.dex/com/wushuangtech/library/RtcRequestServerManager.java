package com.wushuangtech.library;

import android.os.Handler;
import android.os.Message;
import android.util.SparseArray;
import com.wushuangtech.jni.RoomJni;
import com.wushuangtech.jni.callback.BaseRtcChannelSignalCallBack;
import com.wushuangtech.jni.response.ChannelJoinResponse;
import com.wushuangtech.library.JNIResponse;
import com.wushuangtech.utils.OmniLog;
import java.lang.ref.WeakReference;
import java.util.Timer;
import java.util.TimerTask;

public class RtcRequestServerManager {
    private static final String TAG = "RtcRequestServerManager";
    private static final int TIME_OUT = 1200000;
    private static final String WATCHER_TAG = "ROOM_WATCH|CROSS_WATCH]";
    private final String mChannelName;
    private boolean mDestroyed;
    private final Object mLock = new Object();
    private SparseArray<LocalTimer> mTasks = new SparseArray<>();

    public interface OnRequestEventCallBack {
        void onJoinChannelEvent(JNIResponse jNIResponse);
    }

    public RtcRequestServerManager(String str) {
        this.mChannelName = str;
    }

    public void requestServer(int i, Object[] objArr, OnRequestEventCallBack onRequestEventCallBack) {
        requestServer(i, objArr, (Handler) null, onRequestEventCallBack);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0067, code lost:
        if (r4 != 501) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0069, code lost:
        com.wushuangtech.jni.RoomJni.getInstance().invokeNativeMethod(com.wushuangtech.jni.RoomJni.RoomNativeEvent.ENTER_ROOM, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void requestServer(int r4, java.lang.Object[] r5, android.os.Handler r6, com.wushuangtech.library.RtcRequestServerManager.OnRequestEventCallBack r7) {
        /*
            r3 = this;
            java.lang.Object r0 = r3.mLock
            monitor-enter(r0)
            boolean r1 = r3.mDestroyed     // Catch:{ all -> 0x0073 }
            if (r1 == 0) goto L_0x0009
            monitor-exit(r0)     // Catch:{ all -> 0x0073 }
            return
        L_0x0009:
            android.util.SparseArray<com.wushuangtech.library.RtcRequestServerManager$LocalTimer> r1 = r3.mTasks     // Catch:{ all -> 0x0073 }
            java.lang.Object r1 = r1.get(r4)     // Catch:{ all -> 0x0073 }
            java.util.Timer r1 = (java.util.Timer) r1     // Catch:{ all -> 0x0073 }
            if (r1 == 0) goto L_0x003b
            java.lang.String r5 = "ROOM_WATCH|CROSS_WATCH]"
            java.lang.String r6 = "RtcRequestServerManager"
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x0073 }
            r7.<init>()     // Catch:{ all -> 0x0073 }
            java.lang.String r1 = "Request failed! already requesting. size : "
            r7.append(r1)     // Catch:{ all -> 0x0073 }
            android.util.SparseArray<com.wushuangtech.library.RtcRequestServerManager$LocalTimer> r1 = r3.mTasks     // Catch:{ all -> 0x0073 }
            int r1 = r1.size()     // Catch:{ all -> 0x0073 }
            r7.append(r1)     // Catch:{ all -> 0x0073 }
            java.lang.String r1 = " | requestType : "
            r7.append(r1)     // Catch:{ all -> 0x0073 }
            r7.append(r4)     // Catch:{ all -> 0x0073 }
            java.lang.String r4 = r7.toString()     // Catch:{ all -> 0x0073 }
            com.wushuangtech.utils.OmniLog.e((java.lang.String) r5, (java.lang.String) r6, (java.lang.String) r4)     // Catch:{ all -> 0x0073 }
            monitor-exit(r0)     // Catch:{ all -> 0x0073 }
            return
        L_0x003b:
            r3.initTimeOut(r4, r5, r6, r7)     // Catch:{ all -> 0x0073 }
            java.lang.String r6 = "ROOM_WATCH|CROSS_WATCH]"
            java.lang.String r7 = "RtcRequestServerManager"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0073 }
            r1.<init>()     // Catch:{ all -> 0x0073 }
            java.lang.String r2 = "Starting request task , task size : "
            r1.append(r2)     // Catch:{ all -> 0x0073 }
            android.util.SparseArray<com.wushuangtech.library.RtcRequestServerManager$LocalTimer> r2 = r3.mTasks     // Catch:{ all -> 0x0073 }
            int r2 = r2.size()     // Catch:{ all -> 0x0073 }
            r1.append(r2)     // Catch:{ all -> 0x0073 }
            java.lang.String r2 = " | requestType : "
            r1.append(r2)     // Catch:{ all -> 0x0073 }
            r1.append(r4)     // Catch:{ all -> 0x0073 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0073 }
            com.wushuangtech.utils.OmniLog.d((java.lang.String) r6, (java.lang.String) r7, (java.lang.String) r1)     // Catch:{ all -> 0x0073 }
            monitor-exit(r0)     // Catch:{ all -> 0x0073 }
            r6 = 501(0x1f5, float:7.02E-43)
            if (r4 != r6) goto L_0x0072
            com.wushuangtech.jni.RoomJni r4 = com.wushuangtech.jni.RoomJni.getInstance()
            com.wushuangtech.jni.RoomJni$RoomNativeEvent r6 = com.wushuangtech.jni.RoomJni.RoomNativeEvent.ENTER_ROOM
            r4.invokeNativeMethod(r6, r5)
        L_0x0072:
            return
        L_0x0073:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0073 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wushuangtech.library.RtcRequestServerManager.requestServer(int, java.lang.Object[], android.os.Handler, com.wushuangtech.library.RtcRequestServerManager$OnRequestEventCallBack):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x003c, code lost:
        if (android.text.TextUtils.isEmpty(r3.mChannelName) != false) goto L_0x0062;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x003e, code lost:
        com.wushuangtech.utils.OmniLog.i(WATCHER_TAG, TAG, "Cannel current joining room task success! " + r3.mChannelName);
        com.wushuangtech.jni.RoomJni.getInstance().RoomExit(r3.mChannelName);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0062, code lost:
        com.wushuangtech.utils.OmniLog.e(WATCHER_TAG, TAG, "Cannel current joining room task failed! " + r3.mChannelName);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void cannelRequest(int r4) {
        /*
            r3 = this;
            java.lang.Object r0 = r3.mLock
            monitor-enter(r0)
            boolean r1 = r3.mDestroyed     // Catch:{ all -> 0x007d }
            if (r1 == 0) goto L_0x0009
            monitor-exit(r0)     // Catch:{ all -> 0x007d }
            return
        L_0x0009:
            r1 = 501(0x1f5, float:7.02E-43)
            if (r4 != r1) goto L_0x0035
            android.util.SparseArray<com.wushuangtech.library.RtcRequestServerManager$LocalTimer> r1 = r3.mTasks     // Catch:{ all -> 0x007d }
            java.lang.Object r1 = r1.get(r4)     // Catch:{ all -> 0x007d }
            com.wushuangtech.library.RtcRequestServerManager$LocalTimer r1 = (com.wushuangtech.library.RtcRequestServerManager.LocalTimer) r1     // Catch:{ all -> 0x007d }
            if (r1 != 0) goto L_0x0022
            java.lang.String r4 = "ROOM_WATCH|CROSS_WATCH]"
            java.lang.String r1 = "RtcRequestServerManager"
            java.lang.String r2 = "Cannel current joining room task failed!"
            com.wushuangtech.utils.OmniLog.e((java.lang.String) r4, (java.lang.String) r1, (java.lang.String) r2)     // Catch:{ all -> 0x007d }
            monitor-exit(r0)     // Catch:{ all -> 0x007d }
            return
        L_0x0022:
            r1.cancel()     // Catch:{ all -> 0x007d }
            android.util.SparseArray<com.wushuangtech.library.RtcRequestServerManager$LocalTimer> r2 = r3.mTasks     // Catch:{ all -> 0x007d }
            r2.delete(r4)     // Catch:{ all -> 0x007d }
            com.wushuangtech.library.RtcRequestServerManager$LocalTimerTask r4 = r1.getTimerTask()     // Catch:{ all -> 0x007d }
            if (r4 != 0) goto L_0x0032
            monitor-exit(r0)     // Catch:{ all -> 0x007d }
            return
        L_0x0032:
            r4.cannelTimer()     // Catch:{ all -> 0x007d }
        L_0x0035:
            monitor-exit(r0)     // Catch:{ all -> 0x007d }
            java.lang.String r4 = r3.mChannelName
            boolean r4 = android.text.TextUtils.isEmpty(r4)
            if (r4 != 0) goto L_0x0062
            java.lang.String r4 = "ROOM_WATCH|CROSS_WATCH]"
            java.lang.String r0 = "RtcRequestServerManager"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Cannel current joining room task success! "
            r1.append(r2)
            java.lang.String r2 = r3.mChannelName
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            com.wushuangtech.utils.OmniLog.i(r4, r0, r1)
            com.wushuangtech.jni.RoomJni r4 = com.wushuangtech.jni.RoomJni.getInstance()
            java.lang.String r0 = r3.mChannelName
            r4.RoomExit(r0)
            goto L_0x007c
        L_0x0062:
            java.lang.String r4 = "ROOM_WATCH|CROSS_WATCH]"
            java.lang.String r0 = "RtcRequestServerManager"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Cannel current joining room task failed! "
            r1.append(r2)
            java.lang.String r2 = r3.mChannelName
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            com.wushuangtech.utils.OmniLog.e((java.lang.String) r4, (java.lang.String) r0, (java.lang.String) r1)
        L_0x007c:
            return
        L_0x007d:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x007d }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wushuangtech.library.RtcRequestServerManager.cannelRequest(int):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0014, code lost:
        r0 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0019, code lost:
        if (r0 >= r1.size()) goto L_0x0031;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001b, code lost:
        r2 = r1.get(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0021, code lost:
        if (r2 != null) goto L_0x0024;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0024, code lost:
        r2 = r2.getTimerTask();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0028, code lost:
        if (r2 != null) goto L_0x002b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x002b, code lost:
        com.wushuangtech.library.RtcRequestServerManager.LocalTimerTask.access$000(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x002e, code lost:
        r0 = r0 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0031, code lost:
        r1.clear();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0012, code lost:
        if (r1 == null) goto L_?;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void clearResource() {
        /*
            r3 = this;
            java.lang.Object r0 = r3.mLock
            monitor-enter(r0)
            boolean r1 = r3.mDestroyed     // Catch:{ all -> 0x0035 }
            if (r1 == 0) goto L_0x0009
            monitor-exit(r0)     // Catch:{ all -> 0x0035 }
            return
        L_0x0009:
            r1 = 1
            r3.mDestroyed = r1     // Catch:{ all -> 0x0035 }
            android.util.SparseArray<com.wushuangtech.library.RtcRequestServerManager$LocalTimer> r1 = r3.mTasks     // Catch:{ all -> 0x0035 }
            r2 = 0
            r3.mTasks = r2     // Catch:{ all -> 0x0035 }
            monitor-exit(r0)     // Catch:{ all -> 0x0035 }
            if (r1 == 0) goto L_0x0034
            r0 = 0
        L_0x0015:
            int r2 = r1.size()
            if (r0 >= r2) goto L_0x0031
            java.lang.Object r2 = r1.get(r0)
            com.wushuangtech.library.RtcRequestServerManager$LocalTimer r2 = (com.wushuangtech.library.RtcRequestServerManager.LocalTimer) r2
            if (r2 != 0) goto L_0x0024
            goto L_0x002e
        L_0x0024:
            com.wushuangtech.library.RtcRequestServerManager$LocalTimerTask r2 = r2.getTimerTask()
            if (r2 != 0) goto L_0x002b
            goto L_0x002e
        L_0x002b:
            r2.clearResource()
        L_0x002e:
            int r0 = r0 + 1
            goto L_0x0015
        L_0x0031:
            r1.clear()
        L_0x0034:
            return
        L_0x0035:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0035 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wushuangtech.library.RtcRequestServerManager.clearResource():void");
    }

    private void initTimeOut(int i, Object[] objArr, Handler handler, OnRequestEventCallBack onRequestEventCallBack) {
        LocalRtcChannelSignalCallBackImpl localRtcChannelSignalCallBackImpl = new LocalRtcChannelSignalCallBackImpl(i, objArr, handler, onRequestEventCallBack);
        RoomJni.getInstance().addCallback(localRtcChannelSignalCallBackImpl);
        LocalTimerTask localTimerTask = new LocalTimerTask(localRtcChannelSignalCallBackImpl, this);
        LocalTimer localTimer = new LocalTimer(localTimerTask);
        localTimer.schedule(localTimerTask, 1200000);
        this.mTasks.put(i, localTimer);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x004a, code lost:
        if (r1 != 501) goto L_0x0055;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x004c, code lost:
        com.wushuangtech.jni.RoomJni.getInstance().RoomExit(r4.mChannelName);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0055, code lost:
        if (r6 == false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0057, code lost:
        r5.sendTimeOutMessage();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void handleTimeoutEvent(com.wushuangtech.library.RtcRequestServerManager.LocalRtcChannelSignalCallBackImpl r5, boolean r6) {
        /*
            r4 = this;
            java.lang.String r0 = "ROOM_WATCH|CROSS_WATCH]"
            java.lang.String r1 = "RtcRequestServerManager"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Timout task started! send timeout? : "
            r2.append(r3)
            r2.append(r6)
            java.lang.String r2 = r2.toString()
            com.wushuangtech.utils.OmniLog.d((java.lang.String) r0, (java.lang.String) r1, (java.lang.String) r2)
            java.lang.Object r0 = r4.mLock
            monitor-enter(r0)
            android.util.SparseArray<com.wushuangtech.library.RtcRequestServerManager$LocalTimer> r1 = r4.mTasks     // Catch:{ all -> 0x005d }
            if (r1 == 0) goto L_0x005b
            int r1 = r1.size()     // Catch:{ all -> 0x005d }
            if (r1 > 0) goto L_0x0026
            goto L_0x005b
        L_0x0026:
            int r1 = r5.mRequestType     // Catch:{ all -> 0x005d }
            android.util.SparseArray<com.wushuangtech.library.RtcRequestServerManager$LocalTimer> r2 = r4.mTasks     // Catch:{ all -> 0x005d }
            java.lang.Object r2 = r2.get(r1)     // Catch:{ all -> 0x005d }
            java.util.Timer r2 = (java.util.Timer) r2     // Catch:{ all -> 0x005d }
            if (r2 != 0) goto L_0x003f
            java.lang.String r5 = "ROOM_WATCH|CROSS_WATCH]"
            java.lang.String r6 = "RtcRequestServerManager"
            java.lang.String r1 = "Sending timeout msg failed... Timer is null..."
            com.wushuangtech.utils.OmniLog.e((java.lang.String) r5, (java.lang.String) r6, (java.lang.String) r1)     // Catch:{ all -> 0x005d }
            monitor-exit(r0)     // Catch:{ all -> 0x005d }
            return
        L_0x003f:
            r2.cancel()     // Catch:{ all -> 0x005d }
            android.util.SparseArray<com.wushuangtech.library.RtcRequestServerManager$LocalTimer> r2 = r4.mTasks     // Catch:{ all -> 0x005d }
            r2.delete(r1)     // Catch:{ all -> 0x005d }
            monitor-exit(r0)     // Catch:{ all -> 0x005d }
            r0 = 501(0x1f5, float:7.02E-43)
            if (r1 != r0) goto L_0x0055
            com.wushuangtech.jni.RoomJni r0 = com.wushuangtech.jni.RoomJni.getInstance()
            java.lang.String r1 = r4.mChannelName
            r0.RoomExit(r1)
        L_0x0055:
            if (r6 == 0) goto L_0x005a
            r5.sendTimeOutMessage()
        L_0x005a:
            return
        L_0x005b:
            monitor-exit(r0)     // Catch:{ all -> 0x005d }
            return
        L_0x005d:
            r5 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x005d }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wushuangtech.library.RtcRequestServerManager.handleTimeoutEvent(com.wushuangtech.library.RtcRequestServerManager$LocalRtcChannelSignalCallBackImpl, boolean):void");
    }

    /* access modifiers changed from: private */
    public void handleTimeOutMessage(int i, Object[] objArr, Handler handler, OnRequestEventCallBack onRequestEventCallBack) {
        if (i == 501) {
            long longValue = objArr[1].longValue();
            int intValue = objArr[3].intValue();
            ChannelJoinResponse channelJoinResponse = new ChannelJoinResponse(JNIResponse.Result.ERR_CONF_TIMEOUT, objArr[2], longValue, intValue);
            if (handler != null) {
                Message.obtain(handler, i, objArr).sendToTarget();
            } else if (onRequestEventCallBack != null) {
                onRequestEventCallBack.onJoinChannelEvent(channelJoinResponse);
            }
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0033, code lost:
        r5 = r10[1].longValue();
        r7 = r10[2].intValue();
        r1 = r10[3].intValue();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x004e, code lost:
        if (r11 == null) goto L_0x0058;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0050, code lost:
        android.os.Message.obtain(r11, r9, r10).sendToTarget();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0057, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0058, code lost:
        if (r12 == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x005c, code lost:
        if (r9 != 501) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0060, code lost:
        if (com.wushuangtech.library.GlobalConfig.mVideoEnabled == false) goto L_0x0071;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0064, code lost:
        if (com.wushuangtech.library.GlobalConfig.mVideoLocalEnabled == false) goto L_0x0071;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0066, code lost:
        com.wushuangtech.library.GlobalHolder.getInstance().sendSyncGlobalMessage(com.wushuangtech.constants.RtcGlobalMessage.VIDEO_LOCAL_CAP_START, new java.lang.Object[0]);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0071, code lost:
        r12.onJoinChannelEvent(new com.wushuangtech.jni.response.ChannelJoinResponse(com.wushuangtech.library.JNIResponse.Result.fromInt(r1), r4, r5, r7));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void recvJoinChannelEvent(int r9, java.lang.Object[] r10, android.os.Handler r11, com.wushuangtech.library.RtcRequestServerManager.OnRequestEventCallBack r12) {
        /*
            r8 = this;
            r0 = 0
            r1 = r10[r0]
            r4 = r1
            java.lang.String r4 = (java.lang.String) r4
            java.lang.Object r1 = r8.mLock
            monitor-enter(r1)
            android.util.SparseArray<com.wushuangtech.library.RtcRequestServerManager$LocalTimer> r2 = r8.mTasks     // Catch:{ all -> 0x007f }
            if (r2 != 0) goto L_0x000f
            monitor-exit(r1)     // Catch:{ all -> 0x007f }
            return
        L_0x000f:
            java.lang.String r2 = r8.mChannelName     // Catch:{ all -> 0x007f }
            boolean r2 = r2.equals(r4)     // Catch:{ all -> 0x007f }
            if (r2 != 0) goto L_0x0019
            monitor-exit(r1)     // Catch:{ all -> 0x007f }
            return
        L_0x0019:
            android.util.SparseArray<com.wushuangtech.library.RtcRequestServerManager$LocalTimer> r2 = r8.mTasks     // Catch:{ all -> 0x007f }
            java.lang.Object r2 = r2.get(r9)     // Catch:{ all -> 0x007f }
            com.wushuangtech.library.RtcRequestServerManager$LocalTimer r2 = (com.wushuangtech.library.RtcRequestServerManager.LocalTimer) r2     // Catch:{ all -> 0x007f }
            if (r2 == 0) goto L_0x0032
            com.wushuangtech.library.RtcRequestServerManager$LocalTimerTask r3 = r2.getTimerTask()     // Catch:{ all -> 0x007f }
            r3.cannelTimer()     // Catch:{ all -> 0x007f }
            r2.cancel()     // Catch:{ all -> 0x007f }
            android.util.SparseArray<com.wushuangtech.library.RtcRequestServerManager$LocalTimer> r2 = r8.mTasks     // Catch:{ all -> 0x007f }
            r2.delete(r9)     // Catch:{ all -> 0x007f }
        L_0x0032:
            monitor-exit(r1)     // Catch:{ all -> 0x007f }
            r1 = 1
            r1 = r10[r1]
            java.lang.Long r1 = (java.lang.Long) r1
            long r5 = r1.longValue()
            r1 = 2
            r1 = r10[r1]
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r7 = r1.intValue()
            r1 = 3
            r1 = r10[r1]
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r1 = r1.intValue()
            if (r11 == 0) goto L_0x0058
            android.os.Message r9 = android.os.Message.obtain(r11, r9, r10)
            r9.sendToTarget()
            return
        L_0x0058:
            if (r12 == 0) goto L_0x007e
            r10 = 501(0x1f5, float:7.02E-43)
            if (r9 != r10) goto L_0x007e
            boolean r9 = com.wushuangtech.library.GlobalConfig.mVideoEnabled
            if (r9 == 0) goto L_0x0071
            boolean r9 = com.wushuangtech.library.GlobalConfig.mVideoLocalEnabled
            if (r9 == 0) goto L_0x0071
            com.wushuangtech.library.GlobalHolder r9 = com.wushuangtech.library.GlobalHolder.getInstance()
            r10 = 3001(0xbb9, float:4.205E-42)
            java.lang.Object[] r11 = new java.lang.Object[r0]
            r9.sendSyncGlobalMessage(r10, r11)
        L_0x0071:
            com.wushuangtech.jni.response.ChannelJoinResponse r9 = new com.wushuangtech.jni.response.ChannelJoinResponse
            com.wushuangtech.library.JNIResponse$Result r3 = com.wushuangtech.library.JNIResponse.Result.fromInt(r1)
            r2 = r9
            r2.<init>(r3, r4, r5, r7)
            r12.onJoinChannelEvent(r9)
        L_0x007e:
            return
        L_0x007f:
            r9 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x007f }
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wushuangtech.library.RtcRequestServerManager.recvJoinChannelEvent(int, java.lang.Object[], android.os.Handler, com.wushuangtech.library.RtcRequestServerManager$OnRequestEventCallBack):void");
    }

    private static class LocalTimer extends Timer {
        private final WeakReference<LocalTimerTask> mLocalTimerTaskRef;

        private LocalTimer(LocalTimerTask localTimerTask) {
            this.mLocalTimerTaskRef = new WeakReference<>(localTimerTask);
        }

        /* access modifiers changed from: package-private */
        public LocalTimerTask getTimerTask() {
            return (LocalTimerTask) this.mLocalTimerTaskRef.get();
        }
    }

    private static class LocalTimerTask extends TimerTask {
        private boolean mIsDispatchTimeOutMsg;
        private LocalRtcChannelSignalCallBackImpl mLocalRtcChannelSignalCallBackImpl;
        private WeakReference<RtcRequestServerManager> mOutReference;

        private LocalTimerTask(LocalRtcChannelSignalCallBackImpl localRtcChannelSignalCallBackImpl, RtcRequestServerManager rtcRequestServerManager) {
            this.mIsDispatchTimeOutMsg = true;
            this.mLocalRtcChannelSignalCallBackImpl = localRtcChannelSignalCallBackImpl;
            this.mOutReference = new WeakReference<>(rtcRequestServerManager);
        }

        /* access modifiers changed from: package-private */
        public void cannelTimer() {
            LocalRtcChannelSignalCallBackImpl localRtcChannelSignalCallBackImpl = this.mLocalRtcChannelSignalCallBackImpl;
            if (localRtcChannelSignalCallBackImpl != null && localRtcChannelSignalCallBackImpl.mRequestType == 501) {
                long longValue = ((Long) localRtcChannelSignalCallBackImpl.mArgs[1]).longValue();
                OmniLog.d(RtcRequestServerManager.WATCHER_TAG, RtcRequestServerManager.TAG, "Cannel current task, uid : " + longValue + " | room id: " + ((String) localRtcChannelSignalCallBackImpl.mArgs[2]));
            }
            clearResource();
        }

        public void run() {
            RtcRequestServerManager rtcRequestServerManager = (RtcRequestServerManager) this.mOutReference.get();
            if (rtcRequestServerManager == null) {
                OmniLog.e(RtcRequestServerManager.WATCHER_TAG, RtcRequestServerManager.TAG, "RtcRequestServerManager is null...");
                return;
            }
            LocalRtcChannelSignalCallBackImpl localRtcChannelSignalCallBackImpl = this.mLocalRtcChannelSignalCallBackImpl;
            if (localRtcChannelSignalCallBackImpl == null) {
                OmniLog.e(RtcRequestServerManager.WATCHER_TAG, RtcRequestServerManager.TAG, "LocalConfApiCallBack is null...");
                return;
            }
            rtcRequestServerManager.handleTimeoutEvent(localRtcChannelSignalCallBackImpl, this.mIsDispatchTimeOutMsg);
            clearResource();
        }

        /* access modifiers changed from: private */
        public void clearResource() {
            if (this.mLocalRtcChannelSignalCallBackImpl != null) {
                RoomJni.getInstance().removeCallback(this.mLocalRtcChannelSignalCallBackImpl);
                this.mLocalRtcChannelSignalCallBackImpl.clearHandler();
                this.mLocalRtcChannelSignalCallBackImpl = null;
            }
            WeakReference<RtcRequestServerManager> weakReference = this.mOutReference;
            if (weakReference != null) {
                weakReference.clear();
                this.mOutReference = null;
            }
            this.mIsDispatchTimeOutMsg = false;
        }
    }

    private static class LocalRtcChannelSignalCallBackImpl extends BaseRtcChannelSignalCallBack {
        /* access modifiers changed from: private */
        public Object[] mArgs;
        private Handler mHandler;
        private final OnRequestEventCallBack mOnRequestEventCallBack;
        private WeakReference<RtcRequestServerManager> mOutReference;
        /* access modifiers changed from: private */
        public final int mRequestType;

        private LocalRtcChannelSignalCallBackImpl(RtcRequestServerManager rtcRequestServerManager, int i, Object[] objArr, Handler handler, OnRequestEventCallBack onRequestEventCallBack) {
            this.mOutReference = new WeakReference<>(rtcRequestServerManager);
            this.mRequestType = i;
            this.mHandler = handler;
            this.mOnRequestEventCallBack = onRequestEventCallBack;
            this.mArgs = objArr;
        }

        public void sendTimeOutMessage() {
            RtcRequestServerManager rtcRequestServerManager;
            WeakReference<RtcRequestServerManager> weakReference = this.mOutReference;
            if (weakReference != null && (rtcRequestServerManager = (RtcRequestServerManager) weakReference.get()) != null) {
                rtcRequestServerManager.handleTimeOutMessage(this.mRequestType, this.mArgs, this.mHandler, this.mOnRequestEventCallBack);
            }
        }

        /* access modifiers changed from: private */
        public void clearHandler() {
            WeakReference<RtcRequestServerManager> weakReference = this.mOutReference;
            if (weakReference != null) {
                weakReference.clear();
                this.mOutReference = null;
            }
            this.mHandler = null;
            this.mArgs = null;
        }

        public void OnRoomEnter(String str, int i, int i2, long j, int i3, int i4, long j2, long j3, long j4, long j5, long j6, long j7, String str2) {
            Object[] objArr;
            String str3 = str;
            StringBuilder sb = new StringBuilder();
            sb.append("Receive join channel result... channelName : ");
            sb.append(str);
            sb.append(" | result : ");
            int i5 = i;
            sb.append(i);
            OmniLog.i(RtcRequestServerManager.WATCHER_TAG, RtcRequestServerManager.TAG, sb.toString());
            RtcRequestServerManager rtcRequestServerManager = getRtcRequestServerManager();
            if (rtcRequestServerManager != null && (objArr = this.mArgs) != null) {
                rtcRequestServerManager.recvJoinChannelEvent(this.mRequestType, new Object[]{str3, Long.valueOf(((Long) objArr[1]).longValue()), Integer.valueOf(i2), Integer.valueOf(i)}, this.mHandler, this.mOnRequestEventCallBack);
            }
        }

        public void OnConnectServerResult(String str, int i, String str2) {
            Object[] objArr;
            RtcRequestServerManager rtcRequestServerManager = getRtcRequestServerManager();
            if (rtcRequestServerManager != null && i != 0 && (objArr = this.mArgs) != null) {
                rtcRequestServerManager.recvJoinChannelEvent(this.mRequestType, new Object[]{str, Long.valueOf(((Long) objArr[1]).longValue()), Integer.valueOf(((Integer) objArr[4]).intValue()), Integer.valueOf(i)}, this.mHandler, this.mOnRequestEventCallBack);
            }
        }

        private RtcRequestServerManager getRtcRequestServerManager() {
            WeakReference<RtcRequestServerManager> weakReference = this.mOutReference;
            if (weakReference == null) {
                return null;
            }
            return (RtcRequestServerManager) weakReference.get();
        }
    }
}
