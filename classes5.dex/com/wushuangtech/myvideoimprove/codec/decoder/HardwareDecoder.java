package com.wushuangtech.myvideoimprove.codec.decoder;

import android.media.MediaCodec;
import android.media.MediaFormat;
import android.view.Surface;
import com.wushuangtech.myvideoimprove.bean.CodecConfigureBean;
import com.wushuangtech.myvideoimprove.bean.CodecHardwareDecoderConfigureBean;
import com.wushuangtech.myvideoimprove.codec.BaseCodecImpl;
import com.wushuangtech.myvideoimprove.codec.CodecLife;
import com.wushuangtech.myvideoimprove.codec.OnCodecLifeListener;
import com.wushuangtech.myvideoimprove.codec.OnVideoDecoderEventCallBack;
import java.io.IOException;

public class HardwareDecoder extends BaseCodecImpl implements OnCodecLifeListener {
    private static final String MIME_TYPE = "video/avc";
    private static final String TAG = "HardwareDecoder";
    private MediaCodec currentMediaCodec;
    private MediaFormat mExternalMediaFormat;
    private OnVideoDecoderEventCallBack mOnVideoDecoderEventCallBack;
    private Surface mSurface;
    private boolean resetMode;
    private boolean surfaceEnabled = true;

    public void onCodecStartFinish(CodecConfigureBean codecConfigureBean) {
    }

    public boolean onSyncCodecStartCheck() {
        return true;
    }

    public HardwareDecoder(String str) {
        super(str);
        this.mCodecLife = new CodecLife(str, this);
    }

    public void setSurface(Surface surface) {
        this.mSurface = surface;
    }

    public void setOnVideoDecoderEventCallBack(OnVideoDecoderEventCallBack onVideoDecoderEventCallBack) {
        this.mOnVideoDecoderEventCallBack = onVideoDecoderEventCallBack;
    }

    public void setExternalMediaFormat(MediaFormat mediaFormat) {
        synchronized (HardwareDecoder.class) {
            this.mExternalMediaFormat = mediaFormat;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:?, code lost:
        r2 = r8.dequeueInputBuffer(-1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0017, code lost:
        if (r2 >= 0) goto L_0x001a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0019, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001a, code lost:
        r1 = r8.getInputBuffers()[r2];
        r1.clear();
        r1.put(r0, 0, r0.length);
        r8.queueInputBuffer(r2, 0, r0.length, r5, 0);
        r0 = new android.media.MediaCodec.BufferInfo();
        r3 = r8.dequeueOutputBuffer(r0, 0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x003b, code lost:
        if (r3 != -2) goto L_0x0070;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x003d, code lost:
        r4 = r8.getOutputFormat().getInteger("width");
        r5 = r8.getOutputFormat().getInteger("height");
        r6 = TAG;
        com.wushuangtech.utils.OmniLog.rv_d(r6, "mediacodec format changed! " + r4 + " | " + r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0071, code lost:
        if (r3 != -3) goto L_0x007a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0073, code lost:
        com.wushuangtech.utils.OmniLog.rv_d(TAG, "mediacodec buffer changed!");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x007a, code lost:
        if (r3 < 0) goto L_0x0087;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x007c, code lost:
        r4 = r10.mOnVideoDecoderEventCallBack;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x007e, code lost:
        if (r4 == null) goto L_0x0087;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0080, code lost:
        r4.onVideoFirstFrameDecoded(r11.width, r11.height);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0087, code lost:
        r4 = r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0088, code lost:
        if (r4 < 0) goto L_0x0093;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x008a, code lost:
        r8.releaseOutputBuffer(r4, true);
        r4 = r8.dequeueOutputBuffer(r0, 0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0097, code lost:
        if (android.os.Build.VERSION.SDK_INT >= 23) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0099, code lost:
        if (r3 <= 0) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x009b, code lost:
        r0 = r10.mOnVideoDecoderEventCallBack;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x009d, code lost:
        if (r0 == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x009f, code lost:
        r0.onVideoFirstFrameDrawn(r11.width, r11.height);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00a7, code lost:
        r11 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00a8, code lost:
        r11.printStackTrace();
        r0 = TAG;
        com.wushuangtech.utils.OmniLog.rv_e(r0, "Hardware decode exception! " + r11.getLocalizedMessage());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x000a, code lost:
        r0 = r11.data;
        r5 = r11.timeStamp;
        java.lang.System.currentTimeMillis();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void decodingFrame(com.wushuangtech.library.video.bean.VideoFrame r11) {
        /*
            r10 = this;
            java.lang.Class<com.wushuangtech.myvideoimprove.codec.decoder.HardwareDecoder> r0 = com.wushuangtech.myvideoimprove.codec.decoder.HardwareDecoder.class
            monitor-enter(r0)
            android.media.MediaCodec r8 = r10.currentMediaCodec     // Catch:{ all -> 0x00c6 }
            if (r8 != 0) goto L_0x0009
            monitor-exit(r0)     // Catch:{ all -> 0x00c6 }
            return
        L_0x0009:
            monitor-exit(r0)     // Catch:{ all -> 0x00c6 }
            byte[] r0 = r11.data
            long r5 = r11.timeStamp
            java.lang.System.currentTimeMillis()
            r1 = -1
            int r2 = r8.dequeueInputBuffer(r1)     // Catch:{ Exception -> 0x00a7 }
            if (r2 >= 0) goto L_0x001a
            return
        L_0x001a:
            java.nio.ByteBuffer[] r1 = r8.getInputBuffers()     // Catch:{ Exception -> 0x00a7 }
            r1 = r1[r2]     // Catch:{ Exception -> 0x00a7 }
            r1.clear()     // Catch:{ Exception -> 0x00a7 }
            r3 = 0
            int r4 = r0.length     // Catch:{ Exception -> 0x00a7 }
            r1.put(r0, r3, r4)     // Catch:{ Exception -> 0x00a7 }
            r3 = 0
            int r4 = r0.length     // Catch:{ Exception -> 0x00a7 }
            r7 = 0
            r1 = r8
            r1.queueInputBuffer(r2, r3, r4, r5, r7)     // Catch:{ Exception -> 0x00a7 }
            android.media.MediaCodec$BufferInfo r0 = new android.media.MediaCodec$BufferInfo     // Catch:{ Exception -> 0x00a7 }
            r0.<init>()     // Catch:{ Exception -> 0x00a7 }
            r1 = 0
            int r3 = r8.dequeueOutputBuffer(r0, r1)     // Catch:{ Exception -> 0x00a7 }
            r4 = -2
            if (r3 != r4) goto L_0x0070
            android.media.MediaFormat r4 = r8.getOutputFormat()     // Catch:{ Exception -> 0x00a7 }
            java.lang.String r5 = "width"
            int r4 = r4.getInteger(r5)     // Catch:{ Exception -> 0x00a7 }
            android.media.MediaFormat r5 = r8.getOutputFormat()     // Catch:{ Exception -> 0x00a7 }
            java.lang.String r6 = "height"
            int r5 = r5.getInteger(r6)     // Catch:{ Exception -> 0x00a7 }
            java.lang.String r6 = TAG     // Catch:{ Exception -> 0x00a7 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x00a7 }
            r7.<init>()     // Catch:{ Exception -> 0x00a7 }
            java.lang.String r9 = "mediacodec format changed! "
            r7.append(r9)     // Catch:{ Exception -> 0x00a7 }
            r7.append(r4)     // Catch:{ Exception -> 0x00a7 }
            java.lang.String r4 = " | "
            r7.append(r4)     // Catch:{ Exception -> 0x00a7 }
            r7.append(r5)     // Catch:{ Exception -> 0x00a7 }
            java.lang.String r4 = r7.toString()     // Catch:{ Exception -> 0x00a7 }
            com.wushuangtech.utils.OmniLog.rv_d(r6, r4)     // Catch:{ Exception -> 0x00a7 }
            goto L_0x007a
        L_0x0070:
            r4 = -3
            if (r3 != r4) goto L_0x007a
            java.lang.String r4 = TAG     // Catch:{ Exception -> 0x00a7 }
            java.lang.String r5 = "mediacodec buffer changed!"
            com.wushuangtech.utils.OmniLog.rv_d(r4, r5)     // Catch:{ Exception -> 0x00a7 }
        L_0x007a:
            if (r3 < 0) goto L_0x0087
            com.wushuangtech.myvideoimprove.codec.OnVideoDecoderEventCallBack r4 = r10.mOnVideoDecoderEventCallBack     // Catch:{ Exception -> 0x00a7 }
            if (r4 == 0) goto L_0x0087
            int r5 = r11.width     // Catch:{ Exception -> 0x00a7 }
            int r6 = r11.height     // Catch:{ Exception -> 0x00a7 }
            r4.onVideoFirstFrameDecoded(r5, r6)     // Catch:{ Exception -> 0x00a7 }
        L_0x0087:
            r4 = r3
        L_0x0088:
            if (r4 < 0) goto L_0x0093
            r5 = 1
            r8.releaseOutputBuffer(r4, r5)     // Catch:{ Exception -> 0x00a7 }
            int r4 = r8.dequeueOutputBuffer(r0, r1)     // Catch:{ Exception -> 0x00a7 }
            goto L_0x0088
        L_0x0093:
            int r0 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x00a7 }
            r1 = 23
            if (r0 >= r1) goto L_0x00c5
            if (r3 <= 0) goto L_0x00c5
            com.wushuangtech.myvideoimprove.codec.OnVideoDecoderEventCallBack r0 = r10.mOnVideoDecoderEventCallBack     // Catch:{ Exception -> 0x00a7 }
            if (r0 == 0) goto L_0x00c5
            int r1 = r11.width     // Catch:{ Exception -> 0x00a7 }
            int r11 = r11.height     // Catch:{ Exception -> 0x00a7 }
            r0.onVideoFirstFrameDrawn(r1, r11)     // Catch:{ Exception -> 0x00a7 }
            goto L_0x00c5
        L_0x00a7:
            r11 = move-exception
            r11.printStackTrace()
            java.lang.String r0 = TAG
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Hardware decode exception! "
            r1.append(r2)
            java.lang.String r11 = r11.getLocalizedMessage()
            r1.append(r11)
            java.lang.String r11 = r1.toString()
            com.wushuangtech.utils.OmniLog.rv_e(r0, r11)
        L_0x00c5:
            return
        L_0x00c6:
            r11 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x00c6 }
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wushuangtech.myvideoimprove.codec.decoder.HardwareDecoder.decodingFrame(com.wushuangtech.library.video.bean.VideoFrame):void");
    }

    public CodecConfigureBean onSyncCodecStartConfigure(int i, int i2) {
        CodecHardwareDecoderConfigureBean codecHardwareDecoderConfigureBean = new CodecHardwareDecoderConfigureBean();
        codecHardwareDecoderConfigureBean.mediaCodec = this.currentMediaCodec;
        codecHardwareDecoderConfigureBean.width = i;
        codecHardwareDecoderConfigureBean.height = i2;
        codecHardwareDecoderConfigureBean.surfaceEnabled = this.surfaceEnabled;
        return codecHardwareDecoderConfigureBean;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0044, code lost:
        if (r9.surfaceEnabled == false) goto L_0x0051;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0048, code lost:
        if (r0.surface == null) goto L_0x0051;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x004a, code lost:
        r0.surface.release();
        r0.surface = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0053, code lost:
        if (r9.resetMode == false) goto L_0x005b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0055, code lost:
        r0.mediaCodec.reset();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x005b, code lost:
        r0.mediaCodec.release();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0060, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0062, code lost:
        if (r7 != null) goto L_0x006a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:?, code lost:
        r7 = android.media.MediaFormat.createVideoFormat(MIME_TYPE, r4, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x006b, code lost:
        if (r3 == false) goto L_0x0071;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x006d, code lost:
        r1.configure(r7, r8, (android.media.MediaCrypto) null, 0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0071, code lost:
        r1.configure(r7, (android.view.Surface) null, (android.media.MediaCrypto) null, 0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0074, code lost:
        r1.setVideoScalingMode(2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x007c, code lost:
        if (android.os.Build.VERSION.SDK_INT < 23) goto L_0x0086;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x007e, code lost:
        r1.setOnFrameRenderedListener(new com.wushuangtech.myvideoimprove.codec.decoder.HardwareDecoder.AnonymousClass1(r9), (android.os.Handler) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0086, code lost:
        return r10;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.wushuangtech.myvideoimprove.bean.CodecConfigureBean onCodecConfiguring(com.wushuangtech.myvideoimprove.bean.CodecConfigureBean r10) {
        /*
            r9 = this;
            r0 = r10
            com.wushuangtech.myvideoimprove.bean.CodecHardwareDecoderConfigureBean r0 = (com.wushuangtech.myvideoimprove.bean.CodecHardwareDecoderConfigureBean) r0
            boolean r1 = r9.resetMode
            r2 = 0
            if (r1 == 0) goto L_0x0018
            android.media.MediaCodec r1 = r9.currentMediaCodec
            r0.mediaCodec = r1
            android.media.MediaCodec r1 = r9.currentMediaCodec
            if (r1 != 0) goto L_0x001f
            java.lang.String r10 = TAG
            java.lang.String r0 = "MediaCodec is null in reset mode!"
            r9.logE(r10, r0)
            return r2
        L_0x0018:
            android.media.MediaCodec r1 = r9.currentMediaCodec
            if (r1 == 0) goto L_0x001f
            r0.mediaCodec = r1
            return r2
        L_0x001f:
            android.media.MediaCodec r1 = r0.mediaCodec
            if (r1 != 0) goto L_0x002e
            android.media.MediaCodec r1 = r9.createVideoDecoder()
            r0.mediaCodec = r1
            android.media.MediaCodec r1 = r0.mediaCodec
            if (r1 != 0) goto L_0x002e
            return r2
        L_0x002e:
            android.media.MediaCodec r1 = r0.mediaCodec     // Catch:{ Exception -> 0x008c }
            boolean r3 = r0.surfaceEnabled     // Catch:{ Exception -> 0x008c }
            int r4 = r0.width     // Catch:{ Exception -> 0x008c }
            int r5 = r0.height     // Catch:{ Exception -> 0x008c }
            java.lang.Class<com.wushuangtech.myvideoimprove.codec.decoder.HardwareDecoder> r6 = com.wushuangtech.myvideoimprove.codec.decoder.HardwareDecoder.class
            monitor-enter(r6)     // Catch:{ Exception -> 0x008c }
            android.media.MediaFormat r7 = r9.mExternalMediaFormat     // Catch:{ all -> 0x0087 }
            android.view.Surface r8 = r9.mSurface     // Catch:{ all -> 0x0087 }
            if (r8 != 0) goto L_0x0061
            if (r3 == 0) goto L_0x0061
            monitor-exit(r6)     // Catch:{ all -> 0x0087 }
            boolean r10 = r9.surfaceEnabled
            if (r10 == 0) goto L_0x0051
            android.view.Surface r10 = r0.surface
            if (r10 == 0) goto L_0x0051
            android.view.Surface r10 = r0.surface
            r10.release()
            r0.surface = r2
        L_0x0051:
            boolean r10 = r9.resetMode
            if (r10 == 0) goto L_0x005b
            android.media.MediaCodec r10 = r0.mediaCodec
            r10.reset()
            goto L_0x0060
        L_0x005b:
            android.media.MediaCodec r10 = r0.mediaCodec
            r10.release()
        L_0x0060:
            return r2
        L_0x0061:
            monitor-exit(r6)     // Catch:{ all -> 0x0087 }
            if (r7 != 0) goto L_0x006a
            java.lang.String r6 = "video/avc"
            android.media.MediaFormat r7 = android.media.MediaFormat.createVideoFormat(r6, r4, r5)     // Catch:{ Exception -> 0x008c }
        L_0x006a:
            r4 = 0
            if (r3 == 0) goto L_0x0071
            r1.configure(r7, r8, r2, r4)     // Catch:{ Exception -> 0x008c }
            goto L_0x0074
        L_0x0071:
            r1.configure(r7, r2, r2, r4)     // Catch:{ Exception -> 0x008c }
        L_0x0074:
            r3 = 2
            r1.setVideoScalingMode(r3)     // Catch:{ Exception -> 0x008c }
            int r3 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x008c }
            r4 = 23
            if (r3 < r4) goto L_0x0086
            com.wushuangtech.myvideoimprove.codec.decoder.HardwareDecoder$1 r3 = new com.wushuangtech.myvideoimprove.codec.decoder.HardwareDecoder$1     // Catch:{ Exception -> 0x008c }
            r3.<init>()     // Catch:{ Exception -> 0x008c }
            r1.setOnFrameRenderedListener(r3, r2)     // Catch:{ Exception -> 0x008c }
        L_0x0086:
            return r10
        L_0x0087:
            r10 = move-exception
            monitor-exit(r6)     // Catch:{ all -> 0x0087 }
            throw r10     // Catch:{ Exception -> 0x008c }
        L_0x008a:
            r10 = move-exception
            goto L_0x00af
        L_0x008c:
            r10 = move-exception
            r10.printStackTrace()     // Catch:{ all -> 0x008a }
            boolean r10 = r9.surfaceEnabled
            if (r10 == 0) goto L_0x009f
            android.view.Surface r10 = r0.surface
            if (r10 == 0) goto L_0x009f
            android.view.Surface r10 = r0.surface
            r10.release()
            r0.surface = r2
        L_0x009f:
            boolean r10 = r9.resetMode
            if (r10 == 0) goto L_0x00a9
            android.media.MediaCodec r10 = r0.mediaCodec
            r10.reset()
            goto L_0x00ae
        L_0x00a9:
            android.media.MediaCodec r10 = r0.mediaCodec
            r10.release()
        L_0x00ae:
            return r0
        L_0x00af:
            boolean r1 = r9.surfaceEnabled
            if (r1 == 0) goto L_0x00be
            android.view.Surface r1 = r0.surface
            if (r1 == 0) goto L_0x00be
            android.view.Surface r1 = r0.surface
            r1.release()
            r0.surface = r2
        L_0x00be:
            boolean r1 = r9.resetMode
            if (r1 == 0) goto L_0x00c8
            android.media.MediaCodec r0 = r0.mediaCodec
            r0.reset()
            goto L_0x00cd
        L_0x00c8:
            android.media.MediaCodec r0 = r0.mediaCodec
            r0.release()
        L_0x00cd:
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wushuangtech.myvideoimprove.codec.decoder.HardwareDecoder.onCodecConfiguring(com.wushuangtech.myvideoimprove.bean.CodecConfigureBean):com.wushuangtech.myvideoimprove.bean.CodecConfigureBean");
    }

    public boolean onSyncCodecStart(CodecConfigureBean codecConfigureBean) {
        try {
            ((CodecHardwareDecoderConfigureBean) codecConfigureBean).mediaCodec.start();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void onSyncCodecAssignment(CodecConfigureBean codecConfigureBean) {
        CodecHardwareDecoderConfigureBean codecHardwareDecoderConfigureBean = (CodecHardwareDecoderConfigureBean) codecConfigureBean;
        this.currentMediaCodec = codecHardwareDecoderConfigureBean.mediaCodec;
        this.mSurface = codecHardwareDecoderConfigureBean.surface;
    }

    public CodecConfigureBean onSyncCodecPrepareRelease() {
        CodecHardwareDecoderConfigureBean buildHardwareEncoderReleaseBean = buildHardwareEncoderReleaseBean(this.currentMediaCodec, this.mSurface, this.surfaceEnabled);
        if (!this.resetMode) {
            this.currentMediaCodec = null;
        }
        this.mSurface = null;
        return buildHardwareEncoderReleaseBean;
    }

    public void onSyncCodecReleasing(CodecConfigureBean codecConfigureBean) {
        releaseCurrentMediaCodec((CodecHardwareDecoderConfigureBean) codecConfigureBean);
    }

    public boolean onCodecReleasing(CodecConfigureBean codecConfigureBean) {
        releaseCurrentMediaCodec((CodecHardwareDecoderConfigureBean) codecConfigureBean);
        return true;
    }

    private CodecHardwareDecoderConfigureBean buildHardwareEncoderReleaseBean(MediaCodec mediaCodec, Surface surface, boolean z) {
        CodecHardwareDecoderConfigureBean codecHardwareDecoderConfigureBean = new CodecHardwareDecoderConfigureBean();
        codecHardwareDecoderConfigureBean.mediaCodec = mediaCodec;
        codecHardwareDecoderConfigureBean.surfaceEnabled = z;
        codecHardwareDecoderConfigureBean.surface = surface;
        return codecHardwareDecoderConfigureBean;
    }

    private void releaseCurrentMediaCodec(CodecHardwareDecoderConfigureBean codecHardwareDecoderConfigureBean) {
        if (codecHardwareDecoderConfigureBean.mediaCodec != null) {
            try {
                codecHardwareDecoderConfigureBean.mediaCodec.stop();
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (codecHardwareDecoderConfigureBean.resetMode) {
                try {
                    codecHardwareDecoderConfigureBean.mediaCodec.reset();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            } else {
                try {
                    codecHardwareDecoderConfigureBean.mediaCodec.release();
                } catch (Exception e3) {
                    e3.printStackTrace();
                }
            }
        }
        codecHardwareDecoderConfigureBean.mediaCodec = null;
    }

    private MediaCodec createVideoDecoder() {
        try {
            return MediaCodec.createDecoderByType(MIME_TYPE);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
