package com.wushuangtech.myvideoimprove.codec.encoder;

import android.media.MediaCodec;
import android.media.MediaFormat;
import com.wushuangtech.bean.FastLogCacheBean;
import com.wushuangtech.library.video.VideoStatus;
import com.wushuangtech.utils.OmniLog;
import java.lang.ref.WeakReference;

public class HardwareEncoderMediaCallBack extends MediaCodec.Callback {
    private static final String TAG = "HardwareEncoderMediaCallBack";
    private boolean mDestroyCallBack;
    private final Object mLock = new Object();
    private final String mLogWatcher;
    private final WeakReference<HardwareEncoder> mOutReference;
    private final FastLogCacheBean mProcessDataWatcher;
    private String mSurfaceId;

    HardwareEncoderMediaCallBack(HardwareEncoder hardwareEncoder) {
        this.mOutReference = new WeakReference<>(hardwareEncoder);
        this.mLogWatcher = "LPW][VEW";
        this.mProcessDataWatcher = new FastLogCacheBean("HardwareEncoderMediaCallBack-onOutputBufferAvailable", TAG, 4);
    }

    /* access modifiers changed from: package-private */
    public void setSurfaceId(String str) {
        this.mSurfaceId = str;
    }

    /* access modifiers changed from: package-private */
    public void stopProcess() {
        synchronized (this.mLock) {
            this.mDestroyCallBack = true;
            this.mOutReference.clear();
        }
        String str = this.mLogWatcher;
        String str2 = TAG;
        OmniLog.i(str, str2, "Stop process encoding..." + this);
    }

    public void onInputBufferAvailable(MediaCodec mediaCodec, int i) {
        String str = this.mLogWatcher;
        String str2 = TAG;
        OmniLog.i(str, str2, "onInputBufferAvailable..." + i);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0019, code lost:
        if (r0.checkEncoderStatus() != false) goto L_0x001c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001c, code lost:
        r2 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001e, code lost:
        r2 = true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x001f, code lost:
        if (r8 >= 0) goto L_0x0022;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0021, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0022, code lost:
        if (r2 == false) goto L_0x0045;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0024, code lost:
        com.wushuangtech.utils.OmniLog.w(r6.mLogWatcher, TAG, "Drop data to encode... " + r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        r7.releaseOutputBuffer(r8, false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0040, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0041, code lost:
        r7.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0045, code lost:
        r6.mProcessDataWatcher.mMessage = "Process data to encode ..." + r8 + " | " + r6 + " | " + java.lang.System.nanoTime() + " | " + r9.presentationTimeUs;
        com.wushuangtech.utils.OmniLog.fd(r6.mProcessDataWatcher);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0083, code lost:
        if (r0.handleOutputBuffer(r7, r9, r8, r6.mSurfaceId) != false) goto L_0x0088;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0085, code lost:
        r0.restartEncoder();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
        r7.releaseOutputBuffer(r8, false);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x008c, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x008d, code lost:
        r7.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x000a, code lost:
        r0 = (com.wushuangtech.myvideoimprove.codec.encoder.HardwareEncoder) r6.mOutReference.get();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0013, code lost:
        if (r0 == null) goto L_0x001e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onOutputBufferAvailable(android.media.MediaCodec r7, int r8, android.media.MediaCodec.BufferInfo r9) {
        /*
            r6 = this;
            java.lang.Object r0 = r6.mLock
            monitor-enter(r0)
            boolean r1 = r6.mDestroyCallBack     // Catch:{ all -> 0x0091 }
            if (r1 == 0) goto L_0x0009
            monitor-exit(r0)     // Catch:{ all -> 0x0091 }
            return
        L_0x0009:
            monitor-exit(r0)     // Catch:{ all -> 0x0091 }
            java.lang.ref.WeakReference<com.wushuangtech.myvideoimprove.codec.encoder.HardwareEncoder> r0 = r6.mOutReference
            java.lang.Object r0 = r0.get()
            com.wushuangtech.myvideoimprove.codec.encoder.HardwareEncoder r0 = (com.wushuangtech.myvideoimprove.codec.encoder.HardwareEncoder) r0
            r1 = 0
            if (r0 == 0) goto L_0x001e
            boolean r2 = r0.checkEncoderStatus()
            if (r2 != 0) goto L_0x001c
            goto L_0x001e
        L_0x001c:
            r2 = r1
            goto L_0x001f
        L_0x001e:
            r2 = 1
        L_0x001f:
            if (r8 >= 0) goto L_0x0022
            return
        L_0x0022:
            if (r2 == 0) goto L_0x0045
            java.lang.String r9 = r6.mLogWatcher
            java.lang.String r0 = TAG
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Drop data to encode... "
            r2.append(r3)
            r2.append(r8)
            java.lang.String r2 = r2.toString()
            com.wushuangtech.utils.OmniLog.w((java.lang.String) r9, (java.lang.String) r0, (java.lang.String) r2)
            r7.releaseOutputBuffer(r8, r1)     // Catch:{ Exception -> 0x0040 }
            goto L_0x0044
        L_0x0040:
            r7 = move-exception
            r7.printStackTrace()
        L_0x0044:
            return
        L_0x0045:
            com.wushuangtech.bean.FastLogCacheBean r2 = r6.mProcessDataWatcher
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Process data to encode ..."
            r3.append(r4)
            r3.append(r8)
            java.lang.String r4 = " | "
            r3.append(r4)
            r3.append(r6)
            java.lang.String r4 = " | "
            r3.append(r4)
            long r4 = java.lang.System.nanoTime()
            r3.append(r4)
            java.lang.String r4 = " | "
            r3.append(r4)
            long r4 = r9.presentationTimeUs
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            r2.mMessage = r3
            com.wushuangtech.bean.FastLogCacheBean r2 = r6.mProcessDataWatcher
            com.wushuangtech.utils.OmniLog.fd(r2)
            java.lang.String r2 = r6.mSurfaceId
            boolean r9 = r0.handleOutputBuffer(r7, r9, r8, r2)
            if (r9 != 0) goto L_0x0088
            r0.restartEncoder()
        L_0x0088:
            r7.releaseOutputBuffer(r8, r1)     // Catch:{ Exception -> 0x008c }
            goto L_0x0090
        L_0x008c:
            r7 = move-exception
            r7.printStackTrace()
        L_0x0090:
            return
        L_0x0091:
            r7 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0091 }
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wushuangtech.myvideoimprove.codec.encoder.HardwareEncoderMediaCallBack.onOutputBufferAvailable(android.media.MediaCodec, int, android.media.MediaCodec$BufferInfo):void");
    }

    public void onError(MediaCodec mediaCodec, MediaCodec.CodecException codecException) {
        codecException.printStackTrace();
        VideoStatus.mVideoEncodeErrorFrames++;
        OmniLog.e(this.mLogWatcher, TAG, "onError..." + codecException.getLocalizedMessage());
    }

    public void onOutputFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat) {
        String str = this.mLogWatcher;
        String str2 = TAG;
        OmniLog.i(str, str2, "onOutputFormatChanged..." + mediaFormat.toString());
    }
}
