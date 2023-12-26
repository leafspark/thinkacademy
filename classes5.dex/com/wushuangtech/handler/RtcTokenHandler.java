package com.wushuangtech.handler;

import android.text.TextUtils;
import com.wushuangtech.api.RtcChannelManager;
import com.wushuangtech.bean.LogEvent;
import com.wushuangtech.jni.RoomJni;
import com.wushuangtech.library.GlobalHolder;
import com.wushuangtech.library.video.VideoStatus;
import com.wushuangtech.utils.OmniLog;
import java.lang.ref.WeakReference;
import java.util.Timer;
import java.util.TimerTask;

public class RtcTokenHandler {
    private static final String TAG = "RtcTokenHandler";
    private Timer mChannelKeyTimer;
    /* access modifiers changed from: private */
    public final WeakReference<RtcChannelManager> mChannelManagerRef;
    /* access modifiers changed from: private */
    public final String mChannelName;
    /* access modifiers changed from: private */
    public boolean mRefreshToken;
    /* access modifiers changed from: private */
    public String mToken;
    /* access modifiers changed from: private */
    public boolean mTokenExpiredAndExiting;
    /* access modifiers changed from: private */
    public final Object mTokenLock = new Object();

    public RtcTokenHandler(String str, RtcChannelManager rtcChannelManager) {
        this.mChannelName = str;
        this.mChannelManagerRef = new WeakReference<>(rtcChannelManager);
    }

    public void refreshToken(String str) {
        synchronized (this.mTokenLock) {
            if (this.mTokenExpiredAndExiting) {
                OmniLog.rw_e(TAG, "authDoing -> renewToken invoked! but failed! room exiting!");
                return;
            }
            OmniLog.rw_d(TAG, "authDoing -> renewToken invoked! channelKey : " + str);
            GlobalHolder.getInstance().handleRtcEventReport(this.mChannelName, LogEvent.CHANNEL_RENEW_TOKEN, str, this.mChannelName);
            RoomJni.getInstance().RenewToken(this.mChannelName, str);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0019, code lost:
        com.wushuangtech.utils.OmniLog.d("Room Watcher -> server authDoing, result token : " + r3 + " | code : " + r4 + " | remain : " + r5 + " | mask : " + r6);
        com.wushuangtech.constants.LocalSDKConstants.OMNI_DEFAULT_TOKEN.equals(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x004a, code lost:
        if (r4 == 0) goto L_0x0075;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x004c, code lost:
        com.wushuangtech.utils.OmniLog.d("Room Watcher -> server authDoing, failed code : " + r4);
        notifyJoinChannelAuth(r3, "AUTH_ERROR_" + r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0074, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x007b, code lost:
        if (com.wushuangtech.constants.LocalSDKConstants.OMNI_DEFAULT_TOKEN.equals(r3) != false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x007d, code lost:
        if (r5 <= 0) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x007f, code lost:
        notifyJoinChannelAuth(r3, "");
        r2.mToken = r3;
        checkAuthenticateTime((long) (r5 * 1000));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void receiveTokenAuthResult(java.lang.String r3, int r4, int r5, int r6) {
        /*
            r2 = this;
            boolean r0 = com.wushuangtech.library.GlobalConfig.mIsServerAuth
            if (r0 != 0) goto L_0x0005
            return
        L_0x0005:
            java.lang.Object r0 = r2.mTokenLock
            monitor-enter(r0)
            boolean r1 = r2.mTokenExpiredAndExiting     // Catch:{ all -> 0x008d }
            if (r1 == 0) goto L_0x0013
            java.lang.String r3 = "Room Watcher -> authDoing, OnConfRefreshToken invoked! but failed! room exiting!"
            com.wushuangtech.utils.OmniLog.w(r3)     // Catch:{ all -> 0x008d }
            monitor-exit(r0)     // Catch:{ all -> 0x008d }
            return
        L_0x0013:
            if (r4 != 0) goto L_0x0018
            r1 = 1
            r2.mRefreshToken = r1     // Catch:{ all -> 0x008d }
        L_0x0018:
            monitor-exit(r0)     // Catch:{ all -> 0x008d }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Room Watcher -> server authDoing, result token : "
            r0.append(r1)
            r0.append(r3)
            java.lang.String r1 = " | code : "
            r0.append(r1)
            r0.append(r4)
            java.lang.String r1 = " | remain : "
            r0.append(r1)
            r0.append(r5)
            java.lang.String r1 = " | mask : "
            r0.append(r1)
            r0.append(r6)
            java.lang.String r6 = r0.toString()
            com.wushuangtech.utils.OmniLog.d(r6)
            java.lang.String r6 = "VGhpcyBpcyBhbiBpbnZhbGlkIHRva2Vu77yB"
            r6.equals(r3)
            if (r4 == 0) goto L_0x0075
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "Room Watcher -> server authDoing, failed code : "
            r5.append(r6)
            r5.append(r4)
            java.lang.String r5 = r5.toString()
            com.wushuangtech.utils.OmniLog.d(r5)
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "AUTH_ERROR_"
            r5.append(r6)
            r5.append(r4)
            java.lang.String r4 = r5.toString()
            r2.notifyJoinChannelAuth(r3, r4)
            return
        L_0x0075:
            java.lang.String r4 = "VGhpcyBpcyBhbiBpbnZhbGlkIHRva2Vu77yB"
            boolean r4 = r4.equals(r3)
            if (r4 != 0) goto L_0x008c
            if (r5 <= 0) goto L_0x008c
            java.lang.String r4 = ""
            r2.notifyJoinChannelAuth(r3, r4)
            r2.mToken = r3
            int r5 = r5 * 1000
            long r3 = (long) r5
            r2.checkAuthenticateTime(r3)
        L_0x008c:
            return
        L_0x008d:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x008d }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wushuangtech.handler.RtcTokenHandler.receiveTokenAuthResult(java.lang.String, int, int, int):void");
    }

    public void clearResource() {
        synchronized (this.mTokenLock) {
            Timer timer = this.mChannelKeyTimer;
            if (timer != null) {
                timer.cancel();
                this.mChannelKeyTimer = null;
            }
        }
    }

    private void notifyJoinChannelAuth(String str, String str2) {
        RtcChannelManager rtcChannelManager;
        GlobalHolder.getInstance().handleRtcEventReport(this.mChannelName, LogEvent.CHANNEL_TOKEN_AUTH, str, str2, this.mChannelName);
        if (!TextUtils.isEmpty(str2) && (rtcChannelManager = (RtcChannelManager) this.mChannelManagerRef.get()) != null) {
            rtcChannelManager.leaveChannel();
        }
    }

    private void checkAuthenticateTime(long j) {
        synchronized (this.mTokenLock) {
            OmniLog.d("Room Watcher -> authDoing, checkAuthenticateTime timer release!");
            Timer timer = this.mChannelKeyTimer;
            if (timer != null) {
                timer.cancel();
                this.mChannelKeyTimer = null;
            }
            Timer timer2 = new Timer(VideoStatus.THREAD_TOKEN_CHECK_CHANNEL);
            LocalTimerTask localTimerTask = new LocalTimerTask(this);
            OmniLog.i("Room Watcher -> authDoing, new task : " + localTimerTask.toString());
            int i = (int) (j / 1000);
            OmniLog.i("Room Watcher -> authDoing, time : " + j + " | tokenTime : " + i);
            int i2 = 2;
            if (i >= 6) {
                int i3 = i / 6;
                if (i3 > 60) {
                    i3 = 60;
                }
                if (i3 >= 2) {
                    i2 = i3;
                }
                long j2 = (long) (i - i2);
                OmniLog.i("Room Watcher -> authDoing, firstExecute : " + j2 + " | delayTime : " + i2);
                timer2.schedule(localTimerTask, 1000 * j2, (long) (i2 * 1000));
            } else if (i < 2) {
                timer2.schedule(localTimerTask, 1000, 1000);
            } else {
                timer2.schedule(localTimerTask, (long) ((i - 2) * 1000), 2000);
            }
            this.mChannelKeyTimer = timer2;
        }
    }

    private static class LocalTimerTask extends TimerTask {
        private final WeakReference<RtcTokenHandler> mOutReference;
        boolean willKickUser = false;

        public LocalTimerTask(RtcTokenHandler rtcTokenHandler) {
            this.mOutReference = new WeakReference<>(rtcTokenHandler);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:25:0x0066, code lost:
            com.wushuangtech.library.GlobalHolder.getInstance().handleRtcEventReport(com.wushuangtech.handler.RtcTokenHandler.access$500(r0), com.wushuangtech.bean.LogEvent.CHANNEL_TOKEN_EXPIRED, com.wushuangtech.handler.RtcTokenHandler.access$500(r0));
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x007b, code lost:
            if (r1 == null) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x007d, code lost:
            r1.onChannelError(109);
            r1.onConnectionStateChanged(1, 9);
            r1.onChannelRequestToken();
            r1.leaveChannel();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:38:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:41:?, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r8 = this;
                java.lang.ref.WeakReference<com.wushuangtech.handler.RtcTokenHandler> r0 = r8.mOutReference
                java.lang.Object r0 = r0.get()
                com.wushuangtech.handler.RtcTokenHandler r0 = (com.wushuangtech.handler.RtcTokenHandler) r0
                if (r0 != 0) goto L_0x000b
                return
            L_0x000b:
                java.lang.ref.WeakReference r1 = r0.mChannelManagerRef
                java.lang.Object r1 = r1.get()
                com.wushuangtech.api.RtcChannelManager r1 = (com.wushuangtech.api.RtcChannelManager) r1
                boolean r2 = r8.willKickUser
                r3 = 0
                r4 = 1
                if (r2 != 0) goto L_0x0038
                java.lang.String r2 = "Room Watcher -> authDoing, TimerTask first invoked! token will expire!"
                com.wushuangtech.utils.OmniLog.d(r2)
                java.lang.Object r2 = r0.mTokenLock
                monitor-enter(r2)
                boolean unused = r0.mRefreshToken = r3     // Catch:{ all -> 0x0035 }
                r8.willKickUser = r4     // Catch:{ all -> 0x0035 }
                monitor-exit(r2)     // Catch:{ all -> 0x0035 }
                if (r1 == 0) goto L_0x008d
                java.lang.String r0 = r0.mToken
                r1.onChannelTokenWillExpire(r0)
                goto L_0x008d
            L_0x0035:
                r0 = move-exception
                monitor-exit(r2)     // Catch:{ all -> 0x0035 }
                throw r0
            L_0x0038:
                java.lang.Object r2 = r0.mTokenLock
                monitor-enter(r2)
                java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x008e }
                r5.<init>()     // Catch:{ all -> 0x008e }
                java.lang.String r6 = "Room Watcher -> authDoing, TimerTask second invoked! token refresh? : "
                r5.append(r6)     // Catch:{ all -> 0x008e }
                boolean r6 = r0.mRefreshToken     // Catch:{ all -> 0x008e }
                r5.append(r6)     // Catch:{ all -> 0x008e }
                java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x008e }
                com.wushuangtech.utils.OmniLog.d(r5)     // Catch:{ all -> 0x008e }
                boolean r5 = r0.mRefreshToken     // Catch:{ all -> 0x008e }
                if (r5 == 0) goto L_0x005d
                monitor-exit(r2)     // Catch:{ all -> 0x008e }
                return
            L_0x005d:
                java.lang.String r5 = "Room Watcher -> authDoing, token expire!"
                com.wushuangtech.utils.OmniLog.d(r5)     // Catch:{ all -> 0x008e }
                boolean unused = r0.mTokenExpiredAndExiting = r4     // Catch:{ all -> 0x008e }
                monitor-exit(r2)     // Catch:{ all -> 0x008e }
                com.wushuangtech.library.GlobalHolder r2 = com.wushuangtech.library.GlobalHolder.getInstance()
                java.lang.String r5 = r0.mChannelName
                com.wushuangtech.bean.LogEvent r6 = com.wushuangtech.bean.LogEvent.CHANNEL_TOKEN_EXPIRED
                java.lang.Object[] r7 = new java.lang.Object[r4]
                java.lang.String r0 = r0.mChannelName
                r7[r3] = r0
                r2.handleRtcEventReport((java.lang.String) r5, (com.wushuangtech.bean.LogEvent) r6, (java.lang.Object[]) r7)
                if (r1 == 0) goto L_0x008d
                r0 = 109(0x6d, float:1.53E-43)
                r1.onChannelError(r0)
                r0 = 9
                r1.onConnectionStateChanged(r4, r0)
                r1.onChannelRequestToken()
                r1.leaveChannel()
            L_0x008d:
                return
            L_0x008e:
                r0 = move-exception
                monitor-exit(r2)     // Catch:{ all -> 0x008e }
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.wushuangtech.handler.RtcTokenHandler.LocalTimerTask.run():void");
        }
    }
}
