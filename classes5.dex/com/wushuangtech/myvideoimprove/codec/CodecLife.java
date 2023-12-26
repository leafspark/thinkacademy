package com.wushuangtech.myvideoimprove.codec;

import com.wushuangtech.myvideoimprove.bean.CodecConfigureBean;
import com.wushuangtech.utils.OmniLog;

public class CodecLife implements BaseCodec {
    private final String TAG;
    private volatile boolean codecOpened;
    private final Object lock = new Object();
    private int mHeight;
    private final String mLogWatcher;
    private final OnCodecLifeListener mOnCodecLifeListener;
    private int mWidth;
    private volatile boolean paused;
    private volatile boolean sizeConfiged;

    public CodecLife(String str, OnCodecLifeListener onCodecLifeListener) {
        this.TAG = "CodecLife<" + str + ">";
        this.mOnCodecLifeListener = onCodecLifeListener;
        this.mLogWatcher = "LPW][VEW";
    }

    public int getCodecWidth() {
        return this.mWidth;
    }

    public int getCodecHeight() {
        return this.mHeight;
    }

    public Object getLock() {
        return this.lock;
    }

    public boolean isCodecOpened() {
        return this.codecOpened;
    }

    public boolean isPaused() {
        return this.paused;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0022, code lost:
        r0 = r4.mOnCodecLifeListener.onCodecConfiguring(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0028, code lost:
        if (r0 != null) goto L_0x002c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x002a, code lost:
        return -3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x002c, code lost:
        r1 = r4.lock;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x002e, code lost:
        monitor-enter(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0031, code lost:
        if (r4.codecOpened != false) goto L_0x003b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0033, code lost:
        r4.mOnCodecLifeListener.onSyncCodecReleasing(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0039, code lost:
        monitor-exit(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x003a, code lost:
        return -4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0041, code lost:
        if (r4.mOnCodecLifeListener.onSyncCodecStart(r0) != false) goto L_0x004b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0043, code lost:
        r4.mOnCodecLifeListener.onSyncCodecReleasing(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0049, code lost:
        monitor-exit(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x004a, code lost:
        return -5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x004b, code lost:
        r4.mOnCodecLifeListener.onSyncCodecAssignment(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0050, code lost:
        monitor-exit(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0051, code lost:
        r4.mOnCodecLifeListener.onCodecStartFinish(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0057, code lost:
        return 0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int tryOpenCodec() {
        /*
            r4 = this;
            java.lang.Object r0 = r4.lock
            monitor-enter(r0)
            boolean r1 = r4.startCheck()     // Catch:{ all -> 0x005b }
            if (r1 != 0) goto L_0x000c
            r1 = -1
            monitor-exit(r0)     // Catch:{ all -> 0x005b }
            return r1
        L_0x000c:
            com.wushuangtech.myvideoimprove.codec.OnCodecLifeListener r1 = r4.mOnCodecLifeListener     // Catch:{ all -> 0x005b }
            boolean r1 = r1.onSyncCodecStartCheck()     // Catch:{ all -> 0x005b }
            if (r1 != 0) goto L_0x0017
            r1 = -2
            monitor-exit(r0)     // Catch:{ all -> 0x005b }
            return r1
        L_0x0017:
            com.wushuangtech.myvideoimprove.codec.OnCodecLifeListener r1 = r4.mOnCodecLifeListener     // Catch:{ all -> 0x005b }
            int r2 = r4.mWidth     // Catch:{ all -> 0x005b }
            int r3 = r4.mHeight     // Catch:{ all -> 0x005b }
            com.wushuangtech.myvideoimprove.bean.CodecConfigureBean r1 = r1.onSyncCodecStartConfigure(r2, r3)     // Catch:{ all -> 0x005b }
            monitor-exit(r0)     // Catch:{ all -> 0x005b }
            com.wushuangtech.myvideoimprove.codec.OnCodecLifeListener r0 = r4.mOnCodecLifeListener
            com.wushuangtech.myvideoimprove.bean.CodecConfigureBean r0 = r0.onCodecConfiguring(r1)
            if (r0 != 0) goto L_0x002c
            r0 = -3
            return r0
        L_0x002c:
            java.lang.Object r1 = r4.lock
            monitor-enter(r1)
            boolean r2 = r4.codecOpened     // Catch:{ all -> 0x0058 }
            if (r2 != 0) goto L_0x003b
            com.wushuangtech.myvideoimprove.codec.OnCodecLifeListener r2 = r4.mOnCodecLifeListener     // Catch:{ all -> 0x0058 }
            r2.onSyncCodecReleasing(r0)     // Catch:{ all -> 0x0058 }
            r0 = -4
            monitor-exit(r1)     // Catch:{ all -> 0x0058 }
            return r0
        L_0x003b:
            com.wushuangtech.myvideoimprove.codec.OnCodecLifeListener r2 = r4.mOnCodecLifeListener     // Catch:{ all -> 0x0058 }
            boolean r2 = r2.onSyncCodecStart(r0)     // Catch:{ all -> 0x0058 }
            if (r2 != 0) goto L_0x004b
            com.wushuangtech.myvideoimprove.codec.OnCodecLifeListener r2 = r4.mOnCodecLifeListener     // Catch:{ all -> 0x0058 }
            r2.onSyncCodecReleasing(r0)     // Catch:{ all -> 0x0058 }
            r0 = -5
            monitor-exit(r1)     // Catch:{ all -> 0x0058 }
            return r0
        L_0x004b:
            com.wushuangtech.myvideoimprove.codec.OnCodecLifeListener r2 = r4.mOnCodecLifeListener     // Catch:{ all -> 0x0058 }
            r2.onSyncCodecAssignment(r0)     // Catch:{ all -> 0x0058 }
            monitor-exit(r1)     // Catch:{ all -> 0x0058 }
            com.wushuangtech.myvideoimprove.codec.OnCodecLifeListener r1 = r4.mOnCodecLifeListener
            r1.onCodecStartFinish(r0)
            r0 = 0
            return r0
        L_0x0058:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0058 }
            throw r0
        L_0x005b:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x005b }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wushuangtech.myvideoimprove.codec.CodecLife.tryOpenCodec():int");
    }

    private boolean startCheck() {
        if (!this.codecOpened) {
            OmniLog.w(this.mLogWatcher, this.TAG, "Codec config first check failed! not open!");
            return false;
        } else if (this.sizeConfiged) {
            return true;
        } else {
            OmniLog.w(this.mLogWatcher, this.TAG, "Codec config first check failed! size or params not setting or changed!");
            return false;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0040, code lost:
        r7 = tryOpenCodec();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0044, code lost:
        if (r7 == 0) goto L_0x0062;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0046, code lost:
        r1 = r6.mLogWatcher;
        r2 = r6.TAG;
        com.wushuangtech.utils.OmniLog.e(r1, r2, r0 + "Try open codec failed, error : " + r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0061, code lost:
        return false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0062, code lost:
        log(r0 + "Start codec result = " + r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0079, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean open(com.wushuangtech.myvideoimprove.bean.CodecConfigureBean r7) {
        /*
            r6 = this;
            java.lang.String r0 = com.wushuangtech.utils.OmniLog.getInvokedMethodNameWithFormat()
            java.lang.Object r1 = r6.lock
            monitor-enter(r1)
            boolean r2 = r6.codecOpened     // Catch:{ all -> 0x007a }
            r3 = 0
            if (r2 == 0) goto L_0x0026
            java.lang.String r7 = r6.mLogWatcher     // Catch:{ all -> 0x007a }
            java.lang.String r2 = r6.TAG     // Catch:{ all -> 0x007a }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x007a }
            r4.<init>()     // Catch:{ all -> 0x007a }
            r4.append(r0)     // Catch:{ all -> 0x007a }
            java.lang.String r0 = "Start mark was wrong!"
            r4.append(r0)     // Catch:{ all -> 0x007a }
            java.lang.String r0 = r4.toString()     // Catch:{ all -> 0x007a }
            com.wushuangtech.utils.OmniLog.e((java.lang.String) r7, (java.lang.String) r2, (java.lang.String) r0)     // Catch:{ all -> 0x007a }
            monitor-exit(r1)     // Catch:{ all -> 0x007a }
            return r3
        L_0x0026:
            r2 = 1
            r6.codecOpened = r2     // Catch:{ all -> 0x007a }
            int r4 = r6.mWidth     // Catch:{ all -> 0x007a }
            int r5 = r7.width     // Catch:{ all -> 0x007a }
            if (r4 != r5) goto L_0x0035
            int r4 = r6.mHeight     // Catch:{ all -> 0x007a }
            int r5 = r7.height     // Catch:{ all -> 0x007a }
            if (r4 == r5) goto L_0x003f
        L_0x0035:
            int r4 = r7.width     // Catch:{ all -> 0x007a }
            r6.mWidth = r4     // Catch:{ all -> 0x007a }
            int r7 = r7.height     // Catch:{ all -> 0x007a }
            r6.mHeight = r7     // Catch:{ all -> 0x007a }
            r6.sizeConfiged = r2     // Catch:{ all -> 0x007a }
        L_0x003f:
            monitor-exit(r1)     // Catch:{ all -> 0x007a }
            int r7 = r6.tryOpenCodec()
            if (r7 == 0) goto L_0x0062
            java.lang.String r1 = r6.mLogWatcher
            java.lang.String r2 = r6.TAG
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r0)
            java.lang.String r0 = "Try open codec failed, error : "
            r4.append(r0)
            r4.append(r7)
            java.lang.String r7 = r4.toString()
            com.wushuangtech.utils.OmniLog.e((java.lang.String) r1, (java.lang.String) r2, (java.lang.String) r7)
            return r3
        L_0x0062:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            java.lang.String r0 = "Start codec result = "
            r1.append(r0)
            r1.append(r7)
            java.lang.String r7 = r1.toString()
            r6.log(r7)
            return r2
        L_0x007a:
            r7 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x007a }
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wushuangtech.myvideoimprove.codec.CodecLife.open(com.wushuangtech.myvideoimprove.bean.CodecConfigureBean):boolean");
    }

    public int restart(CodecConfigureBean codecConfigureBean) {
        CodecConfigureBean onSyncCodecPrepareRelease;
        synchronized (this.lock) {
            if (!(this.mWidth == codecConfigureBean.width && this.mHeight == codecConfigureBean.height)) {
                this.mWidth = codecConfigureBean.width;
                this.mHeight = codecConfigureBean.height;
                log("Recv video size : " + this.mWidth + " * " + this.mHeight);
                this.sizeConfiged = true;
            }
            onSyncCodecPrepareRelease = this.mOnCodecLifeListener.onSyncCodecPrepareRelease();
        }
        this.mOnCodecLifeListener.onCodecReleasing(onSyncCodecPrepareRelease);
        int executingOpen = executingOpen();
        if (executingOpen != 0) {
            String str = this.mLogWatcher;
            String str2 = this.TAG;
            OmniLog.e(str, str2, "Restart failed, error : " + executingOpen);
        }
        return executingOpen;
    }

    public boolean pause() {
        synchronized (this.lock) {
            if (this.paused) {
                return true;
            }
            this.paused = true;
            log("Pause codec... ");
            return true;
        }
    }

    public boolean resume() {
        synchronized (this.lock) {
            if (!this.paused) {
                return true;
            }
            this.paused = false;
            log("Resume codec... ");
            return true;
        }
    }

    public boolean release() {
        synchronized (this.lock) {
            if (!this.codecOpened) {
                OmniLog.w(this.mLogWatcher, this.TAG, "Code already closed! flag error!");
                return false;
            }
            this.codecOpened = false;
            CodecConfigureBean onSyncCodecPrepareRelease = this.mOnCodecLifeListener.onSyncCodecPrepareRelease();
            log("Prepare release codec over!");
            this.mOnCodecLifeListener.onCodecReleasing(onSyncCodecPrepareRelease);
            log("Release codec over!");
            return true;
        }
    }

    private int executingOpen() {
        CodecConfigureBean onCodecConfiguring = this.mOnCodecLifeListener.onCodecConfiguring(this.mOnCodecLifeListener.onSyncCodecStartConfigure(this.mWidth, this.mHeight));
        if (onCodecConfiguring == null) {
            return -1;
        }
        synchronized (this.lock) {
            if (!this.codecOpened) {
                this.mOnCodecLifeListener.onSyncCodecReleasing(onCodecConfiguring);
                return 0;
            } else if (!this.mOnCodecLifeListener.onSyncCodecStart(onCodecConfiguring)) {
                this.mOnCodecLifeListener.onSyncCodecReleasing(onCodecConfiguring);
                return -2;
            } else {
                this.mOnCodecLifeListener.onSyncCodecAssignment(onCodecConfiguring);
                this.mOnCodecLifeListener.onCodecStartFinish(onCodecConfiguring);
                return 0;
            }
        }
    }

    private void log(String str) {
        OmniLog.i(this.mLogWatcher, this.TAG, str);
    }
}
