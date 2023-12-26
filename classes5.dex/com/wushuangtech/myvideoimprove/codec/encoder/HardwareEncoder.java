package com.wushuangtech.myvideoimprove.codec.encoder;

import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Build;
import android.os.Bundle;
import android.os.Process;
import android.view.Surface;
import com.bonree.sdk.agent.engine.external.AsynchronousInstrumentation;
import com.wushuangtech.api.ExternalVideoModuleCallback;
import com.wushuangtech.library.GlobalConfig;
import com.wushuangtech.library.video.LibYuvManager;
import com.wushuangtech.library.video.MediaCodecHelper;
import com.wushuangtech.library.video.VideoStatus;
import com.wushuangtech.library.video.bean.MediaCodecSurface;
import com.wushuangtech.myvideoimprove.bean.CodecConfigureBean;
import com.wushuangtech.myvideoimprove.bean.CodecHardwareEncoderConfigureBean;
import com.wushuangtech.myvideoimprove.codec.CodecLife;
import java.lang.ref.WeakReference;
import java.nio.ByteBuffer;

public class HardwareEncoder extends BaseEncoderImpl implements MediaCodecHelper.OnMediaCodecHelperCallBack {
    private static final int MEDIACODEC_TIMEOUT_US = 10000;
    private volatile MediaCodecSurface currentEncoderSurface;
    private HardwareEncoderMediaCallBack currentHardwareEncoderMediaCallBack;
    private volatile MediaCodec currentMediaCodec;
    protected int mExternalVideoFormat;
    private LibYuvManager mLibYuvManager;
    protected MediaCodecHelper mMediaCodecHelper;
    protected MediaCodecInfo mMediaCodecInfo;
    private OnHardwareSurfaceLifeListener mOnHardwareSurfaceLifeListener;
    private boolean mResetModeEnabled;
    private final Object mSurfaceLock = new Object();
    private boolean mSurfaceModeEnabled;
    protected int mVideoColorFormat;
    private Thread mVideoEncoderThread;
    private boolean mWaitIFrame;

    public interface OnHardwareSurfaceLifeListener {
        void onSurfaceCreated(MediaCodecSurface mediaCodecSurface);

        void onSurfaceReleased(MediaCodecSurface mediaCodecSurface);
    }

    public boolean isHardwareEncoder() {
        return true;
    }

    public HardwareEncoder(String str) {
        super(str);
        setTAG("HardwareEncoder<" + Integer.toHexString(hashCode()) + ">");
    }

    /* access modifiers changed from: package-private */
    public boolean checkEncoderStatus() {
        return this.mCodecLife.isCodecOpened();
    }

    public void setEnableRestMode() {
        if (!this.mCodecLife.isCodecOpened()) {
            this.currentMediaCodec = createVideoEncoder(this.mMediaCodecInfo);
            String str = this.TAG;
            log(str, "Set reset mode of the encoder, create a new encoder : " + this.currentMediaCodec);
            if (this.currentMediaCodec != null) {
                this.mResetModeEnabled = true;
            }
        }
    }

    public void setOnHardwareSurfaceLifeListener(OnHardwareSurfaceLifeListener onHardwareSurfaceLifeListener) {
        this.mOnHardwareSurfaceLifeListener = onHardwareSurfaceLifeListener;
    }

    public void setEncoderSurfaceMode(boolean z) {
        synchronized (this.mCodecLife.getLock()) {
            if (!this.mCodecLife.isCodecOpened()) {
                String str = this.TAG;
                log(str, "Set surface mode of the encoder... " + z);
                this.mSurfaceModeEnabled = z;
            }
        }
    }

    public void setExternalVideoFormat(int i) {
        this.mExternalVideoFormat = i;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0008, code lost:
        r4 = new com.wushuangtech.library.video.MediaCodecHelper(r3);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean initEncoder(java.lang.String r4) {
        /*
            r3 = this;
            boolean r4 = super.initEncoder(r4)
            r0 = 0
            if (r4 != 0) goto L_0x0008
            return r0
        L_0x0008:
            com.wushuangtech.library.video.MediaCodecHelper r4 = new com.wushuangtech.library.video.MediaCodecHelper
            r4.<init>(r3)
            android.media.MediaCodecInfo r1 = r4.findMediaCodecInfoToEncoding()
            if (r1 != 0) goto L_0x0014
            return r0
        L_0x0014:
            int r2 = r4.findVideoEncoderColorFormat(r1)
            if (r2 != 0) goto L_0x001b
            return r0
        L_0x001b:
            r3.mMediaCodecHelper = r4
            r3.mMediaCodecInfo = r1
            r3.mVideoColorFormat = r2
            com.wushuangtech.library.video.LibYuvManager r4 = new com.wushuangtech.library.video.LibYuvManager
            r4.<init>()
            r3.mLibYuvManager = r4
            com.wushuangtech.myvideoimprove.codec.encoder.HardwareEncoderExplore r4 = new com.wushuangtech.myvideoimprove.codec.encoder.HardwareEncoderExplore
            android.media.MediaCodecInfo r0 = r3.mMediaCodecInfo
            java.lang.String r1 = "video/avc"
            r4.<init>(r1, r0)
            r4.watchVideoEncodeMediaCodecInfo()
            r4 = 1
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wushuangtech.myvideoimprove.codec.encoder.HardwareEncoder.initEncoder(java.lang.String):boolean");
    }

    public void destroyEncoder() {
        super.destroyEncoder();
        MediaCodecHelper mediaCodecHelper = this.mMediaCodecHelper;
        if (mediaCodecHelper != null) {
            mediaCodecHelper.clearResource();
            this.mMediaCodecHelper = null;
        }
        this.mVideoColorFormat = 0;
    }

    public CodecConfigureBean onSyncCodecStartConfigure(int i, int i2) {
        CodecHardwareEncoderConfigureBean codecHardwareEncoderConfigureBean = new CodecHardwareEncoderConfigureBean();
        codecHardwareEncoderConfigureBean.mediaCodec = this.currentMediaCodec;
        codecHardwareEncoderConfigureBean.width = i;
        codecHardwareEncoderConfigureBean.height = i2;
        codecHardwareEncoderConfigureBean.fps = this.mVideoFps;
        codecHardwareEncoderConfigureBean.bitrate = this.mVideoBitrate;
        codecHardwareEncoderConfigureBean.gop = this.mVideoGop;
        codecHardwareEncoderConfigureBean.surfaceEnabled = this.mSurfaceModeEnabled;
        codecHardwareEncoderConfigureBean.notifySurfaceReleased = false;
        return codecHardwareEncoderConfigureBean;
    }

    public CodecConfigureBean onCodecConfiguring(CodecConfigureBean codecConfigureBean) {
        CodecHardwareEncoderConfigureBean codecHardwareEncoderConfigureBean = (CodecHardwareEncoderConfigureBean) codecConfigureBean;
        if (this.mResetModeEnabled) {
            codecHardwareEncoderConfigureBean.mediaCodec = this.currentMediaCodec;
            if (this.currentMediaCodec == null) {
                logE(this.TAG, "MediaCodec is null in reset mode!");
                return null;
            }
        } else if (this.currentMediaCodec != null) {
            codecHardwareEncoderConfigureBean.mediaCodec = this.currentMediaCodec;
            return null;
        }
        if (codecHardwareEncoderConfigureBean.mediaCodec == null) {
            codecHardwareEncoderConfigureBean.mediaCodec = createVideoEncoder(this.mMediaCodecInfo);
            if (codecHardwareEncoderConfigureBean.mediaCodec == null) {
                return null;
            }
        }
        try {
            boolean configCodec = configCodec(codecHardwareEncoderConfigureBean);
            if (!configCodec) {
                logE(this.TAG, "Config encoder failed!");
                if (!configCodec) {
                    if (this.mSurfaceModeEnabled && codecHardwareEncoderConfigureBean.mSurface != null) {
                        codecHardwareEncoderConfigureBean.mSurface.release();
                        codecHardwareEncoderConfigureBean.mSurface = null;
                    }
                    if (this.mResetModeEnabled) {
                        codecHardwareEncoderConfigureBean.mediaCodec.reset();
                    } else {
                        codecHardwareEncoderConfigureBean.mediaCodec.release();
                    }
                }
                return null;
            }
            if (!configCodec) {
                if (this.mSurfaceModeEnabled && codecHardwareEncoderConfigureBean.mSurface != null) {
                    codecHardwareEncoderConfigureBean.mSurface.release();
                    codecHardwareEncoderConfigureBean.mSurface = null;
                }
                if (this.mResetModeEnabled) {
                    codecHardwareEncoderConfigureBean.mediaCodec.reset();
                } else {
                    codecHardwareEncoderConfigureBean.mediaCodec.release();
                }
            }
            return codecHardwareEncoderConfigureBean;
        } catch (Exception e) {
            e.printStackTrace();
            String str = this.TAG;
            logE(str, "Config encoder exception! " + e.getLocalizedMessage());
            if (0 == 0) {
                if (this.mSurfaceModeEnabled && codecHardwareEncoderConfigureBean.mSurface != null) {
                    codecHardwareEncoderConfigureBean.mSurface.release();
                    codecHardwareEncoderConfigureBean.mSurface = null;
                }
                if (this.mResetModeEnabled) {
                    codecHardwareEncoderConfigureBean.mediaCodec.reset();
                } else {
                    codecHardwareEncoderConfigureBean.mediaCodec.release();
                }
            }
            return null;
        } catch (Throwable th) {
            if (0 == 0) {
                if (this.mSurfaceModeEnabled && codecHardwareEncoderConfigureBean.mSurface != null) {
                    codecHardwareEncoderConfigureBean.mSurface.release();
                    codecHardwareEncoderConfigureBean.mSurface = null;
                }
                if (this.mResetModeEnabled) {
                    codecHardwareEncoderConfigureBean.mediaCodec.reset();
                } else {
                    codecHardwareEncoderConfigureBean.mediaCodec.release();
                }
            }
            throw th;
        }
    }

    public boolean onSyncCodecStart(CodecConfigureBean codecConfigureBean) {
        CodecHardwareEncoderConfigureBean codecHardwareEncoderConfigureBean = (CodecHardwareEncoderConfigureBean) codecConfigureBean;
        try {
            codecHardwareEncoderConfigureBean.mediaCodec.start();
            String str = this.TAG;
            log(str, "Encoder opened successfully... " + Integer.toHexString(codecHardwareEncoderConfigureBean.mediaCodec.hashCode()) + " - bug1000");
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            String str2 = this.TAG;
            log(str2, "Failed to open the encoder... exception : " + e.getLocalizedMessage());
            return false;
        }
    }

    public void onSyncCodecAssignment(CodecConfigureBean codecConfigureBean) {
        CodecHardwareEncoderConfigureBean codecHardwareEncoderConfigureBean = (CodecHardwareEncoderConfigureBean) codecConfigureBean;
        this.currentMediaCodec = codecHardwareEncoderConfigureBean.mediaCodec;
        this.currentEncoderSurface = codecHardwareEncoderConfigureBean.mSurface;
        this.currentHardwareEncoderMediaCallBack = codecHardwareEncoderConfigureBean.hardwareEncoderMediaCallBack;
    }

    public void onCodecStartFinish(CodecConfigureBean codecConfigureBean) {
        OnHardwareSurfaceLifeListener onHardwareSurfaceLifeListener;
        String str = this.TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("Encoder has bean turned on... | sruface enabled? ");
        sb.append(this.currentEncoderSurface == null ? "null" : this.currentEncoderSurface.toString());
        sb.append("| callback? ");
        sb.append(this.mOnHardwareSurfaceLifeListener);
        sb.append(" - bug1000");
        log(str, sb.toString());
        if (this.mSurfaceModeEnabled) {
            synchronized (this.mSurfaceLock) {
                log(this.TAG, "Send notification surface has been created... - bug1000");
                if (!(this.currentEncoderSurface == null || (onHardwareSurfaceLifeListener = this.mOnHardwareSurfaceLifeListener) == null)) {
                    onHardwareSurfaceLifeListener.onSurfaceCreated(this.currentEncoderSurface);
                }
            }
        }
    }

    public CodecConfigureBean onSyncCodecPrepareRelease() {
        CodecHardwareEncoderConfigureBean buildHardwareEncoderReleaseBean = buildHardwareEncoderReleaseBean(this.currentMediaCodec, this.currentHardwareEncoderMediaCallBack, this.currentEncoderSurface, this.mResetModeEnabled, this.mSurfaceModeEnabled, true);
        if (!this.mResetModeEnabled) {
            this.currentMediaCodec = null;
        }
        synchronized (this.mSurfaceLock) {
            String str = this.TAG;
            log(str, "prepare release encoder surface... " + this.currentEncoderSurface + " - bug1000");
            this.currentEncoderSurface = null;
        }
        this.currentHardwareEncoderMediaCallBack = null;
        return buildHardwareEncoderReleaseBean;
    }

    public void onSyncCodecReleasing(CodecConfigureBean codecConfigureBean) {
        releaseCurrentMediaCodec((CodecHardwareEncoderConfigureBean) codecConfigureBean);
    }

    public boolean onCodecReleasing(CodecConfigureBean codecConfigureBean) {
        releaseCurrentMediaCodec((CodecHardwareEncoderConfigureBean) codecConfigureBean);
        return true;
    }

    public void requestIFrame() {
        MediaCodec mediaCodec;
        if (Build.VERSION.SDK_INT >= 19 && (mediaCodec = this.currentMediaCodec) != null) {
            try {
                Bundle bundle = new Bundle();
                bundle.putInt("request-sync", 0);
                this.mWaitIFrame = true;
                mediaCodec.setParameters(bundle);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void setDynamicBitrate(int i) {
        if (i != 0 && this.mVideoBitrate != i) {
            synchronized (this.mCodecLife.getLock()) {
                this.mVideoBitrate = i;
                MediaCodec mediaCodec = this.currentMediaCodec;
                if (mediaCodec == null) {
                    this.mEncoderParamsChanged = true;
                    return;
                }
                try {
                    Bundle bundle = new Bundle();
                    bundle.putInt("video-bitrate", i);
                    mediaCodec.setParameters(bundle);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0016, code lost:
        if (queueVideoDataFromYuv(r2, r6) != false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0018, code lost:
        restartEncoder();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void receiveVideoData(byte[] r2, int r3, int r4, int r5, long r6, int r8) {
        /*
            r1 = this;
            com.wushuangtech.myvideoimprove.codec.CodecLife r8 = r1.mCodecLife
            java.lang.Object r8 = r8.getLock()
            monitor-enter(r8)
            android.media.MediaCodec r0 = r1.currentMediaCodec     // Catch:{ all -> 0x001c }
            if (r0 != 0) goto L_0x000d
            monitor-exit(r8)     // Catch:{ all -> 0x001c }
            return
        L_0x000d:
            byte[] r2 = r1.getYuvData(r2, r3, r4, r5)     // Catch:{ all -> 0x001c }
            monitor-exit(r8)     // Catch:{ all -> 0x001c }
            boolean r2 = r1.queueVideoDataFromYuv(r2, r6)
            if (r2 != 0) goto L_0x001b
            r1.restartEncoder()
        L_0x001b:
            return
        L_0x001c:
            r2 = move-exception
            monitor-exit(r8)     // Catch:{ all -> 0x001c }
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wushuangtech.myvideoimprove.codec.encoder.HardwareEncoder.receiveVideoData(byte[], int, int, int, long, int):void");
    }

    private MediaCodec createVideoEncoder(MediaCodecInfo mediaCodecInfo) {
        if (mediaCodecInfo == null) {
            return null;
        }
        try {
            return MediaCodec.createByCodecName(mediaCodecInfo.getName());
        } catch (Exception e) {
            e.printStackTrace();
            String str = this.TAG;
            logE(str, "Create video encoder exception! " + e.getLocalizedMessage());
            return null;
        }
    }

    private boolean configCodec(CodecHardwareEncoderConfigureBean codecHardwareEncoderConfigureBean) throws Exception {
        int i;
        MediaFormat createVideoFormat = MediaFormat.createVideoFormat("video/avc", codecHardwareEncoderConfigureBean.width, codecHardwareEncoderConfigureBean.height);
        if (codecHardwareEncoderConfigureBean.surfaceEnabled) {
            i = 2130708361;
        } else {
            i = this.mVideoColorFormat;
            if (i == 0) {
                logE(this.TAG, "Config encoder failed! Video color format is zero!");
                return false;
            }
        }
        int i2 = this.mVideoBitrateMode;
        createVideoFormat.setInteger("color-format", i);
        createVideoFormat.setInteger("bitrate", codecHardwareEncoderConfigureBean.bitrate);
        createVideoFormat.setInteger("frame-rate", codecHardwareEncoderConfigureBean.fps);
        createVideoFormat.setInteger("i-frame-interval", codecHardwareEncoderConfigureBean.gop);
        if (Build.VERSION.SDK_INT >= 21) {
            createVideoFormat.setInteger("bitrate-mode", i2);
        }
        String str = this.TAG;
        log(str, "Prepare config mediacodec, encoder params list : width : " + codecHardwareEncoderConfigureBean.width + " | height : " + codecHardwareEncoderConfigureBean.height + " | fps : " + codecHardwareEncoderConfigureBean.fps + " | bitrate : " + codecHardwareEncoderConfigureBean.bitrate + " | gop : " + codecHardwareEncoderConfigureBean.gop + " | bitrate mode : " + i2);
        if (codecHardwareEncoderConfigureBean.surfaceEnabled) {
            codecHardwareEncoderConfigureBean.mediaCodec.configure(createVideoFormat, (Surface) null, (MediaCrypto) null, 1);
            MediaCodecSurface mediaCodecSurface = new MediaCodecSurface(codecHardwareEncoderConfigureBean.mediaCodec.createInputSurface(), this.mDualEncoder ? 2 : 1);
            String str2 = this.TAG;
            log(str2, "Create a new hardware surface : " + mediaCodecSurface.toString());
            codecHardwareEncoderConfigureBean.mSurface = mediaCodecSurface;
            if (Build.VERSION.SDK_INT >= 21) {
                HardwareEncoderMediaCallBack hardwareEncoderMediaCallBack = new HardwareEncoderMediaCallBack(this);
                hardwareEncoderMediaCallBack.setSurfaceId(mediaCodecSurface.getId());
                codecHardwareEncoderConfigureBean.mediaCodec.setCallback(hardwareEncoderMediaCallBack);
                codecHardwareEncoderConfigureBean.hardwareEncoderMediaCallBack = hardwareEncoderMediaCallBack;
                String str3 = this.TAG;
                log(str3, "Create a new callback : " + hardwareEncoderMediaCallBack);
            } else {
                initThread();
            }
        } else {
            codecHardwareEncoderConfigureBean.mediaCodec.configure(createVideoFormat, (Surface) null, (MediaCrypto) null, 1);
        }
        return true;
    }

    private void releaseCurrentMediaCodec(CodecHardwareEncoderConfigureBean codecHardwareEncoderConfigureBean) {
        String str = this.TAG;
        log(str, "Releasing hardware encoder... " + codecHardwareEncoderConfigureBean.toString());
        if (Build.VERSION.SDK_INT < 21) {
            unInitThread();
        }
        String str2 = this.TAG;
        StringBuilder sb = new StringBuilder();
        sb.append("Prepare to send release surface callBack... ");
        sb.append(codecHardwareEncoderConfigureBean.mSurface == null ? "null" : codecHardwareEncoderConfigureBean.mSurface.toString());
        sb.append(" - bug1000");
        log(str2, sb.toString());
        if (codecHardwareEncoderConfigureBean.surfaceEnabled && codecHardwareEncoderConfigureBean.mSurface != null) {
            if (codecHardwareEncoderConfigureBean.notifySurfaceReleased && this.mOnHardwareSurfaceLifeListener != null) {
                if (codecHardwareEncoderConfigureBean.mediaCodec != null) {
                    try {
                        codecHardwareEncoderConfigureBean.mediaCodec.signalEndOfInputStream();
                    } catch (Exception unused) {
                        logE(this.TAG, "signalEndOfInputStream failed!");
                    }
                }
                synchronized (this.mSurfaceLock) {
                    String str3 = this.TAG;
                    log(str3, "Sent release surface callBack... " + codecHardwareEncoderConfigureBean.mSurface.toString() + " - bug1000");
                    this.mOnHardwareSurfaceLifeListener.onSurfaceReleased(codecHardwareEncoderConfigureBean.mSurface);
                }
            }
            codecHardwareEncoderConfigureBean.mSurface.release();
            codecHardwareEncoderConfigureBean.mSurface = null;
        }
        if (codecHardwareEncoderConfigureBean.hardwareEncoderMediaCallBack != null) {
            codecHardwareEncoderConfigureBean.hardwareEncoderMediaCallBack.stopProcess();
            codecHardwareEncoderConfigureBean.hardwareEncoderMediaCallBack = null;
        }
        if (codecHardwareEncoderConfigureBean.mediaCodec != null) {
            try {
                codecHardwareEncoderConfigureBean.mediaCodec.stop();
                log(this.TAG, "Media codec stop success!");
            } catch (Exception e) {
                e.printStackTrace();
                String str4 = this.TAG;
                logW(str4, "Media codec stop exception! " + e.getLocalizedMessage());
            }
            if (codecHardwareEncoderConfigureBean.resetMode) {
                try {
                    codecHardwareEncoderConfigureBean.mediaCodec.reset();
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
            } else {
                try {
                    codecHardwareEncoderConfigureBean.mediaCodec.release();
                    log(this.TAG, "Media codec release success!");
                } catch (Exception e3) {
                    e3.printStackTrace();
                    String str5 = this.TAG;
                    logW(str5, "Media codec release exception! " + e3.getLocalizedMessage());
                }
            }
        }
        codecHardwareEncoderConfigureBean.mediaCodec = null;
        MediaCodecHelper mediaCodecHelper = this.mMediaCodecHelper;
        if (mediaCodecHelper != null) {
            mediaCodecHelper.clearResource();
        }
        LibYuvManager libYuvManager = this.mLibYuvManager;
        if (libYuvManager != null) {
            libYuvManager.clearResource();
            this.mLibYuvManager = null;
        }
        log(this.TAG, "Release hardware encoder success!");
    }

    private CodecHardwareEncoderConfigureBean buildHardwareEncoderReleaseBean(MediaCodec mediaCodec, HardwareEncoderMediaCallBack hardwareEncoderMediaCallBack, MediaCodecSurface mediaCodecSurface, boolean z, boolean z2, boolean z3) {
        CodecHardwareEncoderConfigureBean codecHardwareEncoderConfigureBean = new CodecHardwareEncoderConfigureBean();
        codecHardwareEncoderConfigureBean.mediaCodec = mediaCodec;
        codecHardwareEncoderConfigureBean.hardwareEncoderMediaCallBack = hardwareEncoderMediaCallBack;
        codecHardwareEncoderConfigureBean.surfaceEnabled = z2;
        codecHardwareEncoderConfigureBean.mSurface = mediaCodecSurface;
        codecHardwareEncoderConfigureBean.resetMode = z;
        codecHardwareEncoderConfigureBean.notifySurfaceReleased = z3;
        return codecHardwareEncoderConfigureBean;
    }

    private boolean queueVideoDataFromYuv(byte[] bArr, long j) {
        MediaCodec mediaCodec = this.currentMediaCodec;
        if (mediaCodec == null || bArr == null) {
            return true;
        }
        try {
            int dequeueInputBuffer = mediaCodec.dequeueInputBuffer(-1);
            if (dequeueInputBuffer >= 0) {
                ByteBuffer byteBuffer = mediaCodec.getInputBuffers()[dequeueInputBuffer];
                byteBuffer.clear();
                byteBuffer.put(bArr, 0, bArr.length);
                mediaCodec.queueInputBuffer(dequeueInputBuffer, 0, bArr.length, j, 0);
            }
            return executingDequeueOutputBuffer(mediaCodec, (String) null);
        } catch (Exception e) {
            e.printStackTrace();
            VideoStatus.mVideoEncodeErrorFrames++;
            return false;
        }
    }

    /* access modifiers changed from: private */
    public boolean queueVideoDataFromSurface() {
        if (!this.mCodecLife.isCodecOpened()) {
            return true;
        }
        MediaCodec mediaCodec = this.currentMediaCodec;
        MediaCodecSurface mediaCodecSurface = this.currentEncoderSurface;
        if (mediaCodec == null || mediaCodecSurface == null) {
            return true;
        }
        return executingDequeueOutputBuffer(mediaCodec, mediaCodecSurface.getId());
    }

    private boolean executingDequeueOutputBuffer(MediaCodec mediaCodec, String str) {
        try {
            MediaCodec.BufferInfo bufferInfo = new MediaCodec.BufferInfo();
            int dequeueOutputBuffer = mediaCodec.dequeueOutputBuffer(bufferInfo, 10000);
            while (dequeueOutputBuffer >= 0) {
                if (!handleOutputBuffer(mediaCodec, bufferInfo, dequeueOutputBuffer, str)) {
                    mediaCodec.releaseOutputBuffer(dequeueOutputBuffer, false);
                    return false;
                }
                mediaCodec.releaseOutputBuffer(dequeueOutputBuffer, false);
                dequeueOutputBuffer = mediaCodec.dequeueOutputBuffer(bufferInfo, 10000);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            VideoStatus.mVideoEncodeErrorFrames++;
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00ba, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00c2, code lost:
        r10 = r6.mMediaCodecHelper;
        r7 = r10.getRawVideoFrame(r7, r8, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00c8, code lost:
        if (r7 == null) goto L_0x00d3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00cc, code lost:
        if (r7.length >= 5) goto L_0x00cf;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00cf, code lost:
        r10.handleRawVideoFrameToSend(r7, r8, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00d2, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00d3, code lost:
        com.wushuangtech.library.video.VideoStatus.mVideoEncodeErrorFrames++;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00db, code lost:
        return false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean handleOutputBuffer(android.media.MediaCodec r7, android.media.MediaCodec.BufferInfo r8, int r9, java.lang.String r10) {
        /*
            r6 = this;
            long r0 = java.lang.System.currentTimeMillis()
            com.wushuangtech.myvideoimprove.codec.CodecLife r2 = r6.mCodecLife
            boolean r2 = r2.isCodecOpened()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = r6.TAG
            r3.append(r4)
            boolean r4 = r6.mDualEncoder
            if (r4 == 0) goto L_0x001b
            java.lang.String r4 = "-DUAL"
            goto L_0x001d
        L_0x001b:
            java.lang.String r4 = "-MAIN"
        L_0x001d:
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "Processing data... address : "
            r4.append(r5)
            int r5 = r6.hashCode()
            java.lang.String r5 = java.lang.Integer.toHexString(r5)
            r4.append(r5)
            java.lang.String r5 = " | target surface : "
            r4.append(r5)
            r4.append(r10)
            java.lang.String r5 = " | current surface : "
            r4.append(r5)
            com.wushuangtech.library.video.bean.MediaCodecSurface r5 = r6.currentEncoderSurface
            if (r5 != 0) goto L_0x004d
            java.lang.String r5 = "null"
            goto L_0x0057
        L_0x004d:
            com.wushuangtech.library.video.bean.MediaCodecSurface r5 = r6.currentEncoderSurface
            int r5 = r5.hashCode()
            java.lang.String r5 = java.lang.Integer.toHexString(r5)
        L_0x0057:
            r4.append(r5)
            java.lang.String r5 = " | open status : "
            r4.append(r5)
            r4.append(r2)
            java.lang.String r5 = " | codec : "
            r4.append(r5)
            android.media.MediaCodec r5 = r6.currentMediaCodec
            if (r5 != 0) goto L_0x006e
            java.lang.String r5 = "null"
            goto L_0x0078
        L_0x006e:
            android.media.MediaCodec r5 = r6.currentMediaCodec
            int r5 = r5.hashCode()
            java.lang.String r5 = java.lang.Integer.toHexString(r5)
        L_0x0078:
            r4.append(r5)
            java.lang.String r5 = " | callBack : "
            r4.append(r5)
            com.wushuangtech.myvideoimprove.codec.encoder.HardwareEncoderMediaCallBack r5 = r6.currentHardwareEncoderMediaCallBack
            if (r5 != 0) goto L_0x0087
            java.lang.String r5 = "null"
            goto L_0x008f
        L_0x0087:
            int r5 = r5.hashCode()
            java.lang.String r5 = java.lang.Integer.toHexString(r5)
        L_0x008f:
            r4.append(r5)
            java.lang.String r4 = r4.toString()
            r6.printSlow(r3, r4)
            com.wushuangtech.myvideoimprove.codec.CodecLife r3 = r6.mCodecLife
            java.lang.Object r3 = r3.getLock()
            monitor-enter(r3)
            r4 = 1
            if (r2 != 0) goto L_0x00a5
            monitor-exit(r3)     // Catch:{ all -> 0x00dc }
            return r4
        L_0x00a5:
            boolean r2 = r6.mSurfaceModeEnabled     // Catch:{ all -> 0x00dc }
            if (r2 == 0) goto L_0x00bb
            com.wushuangtech.library.video.bean.MediaCodecSurface r2 = r6.currentEncoderSurface     // Catch:{ all -> 0x00dc }
            if (r2 == 0) goto L_0x00b9
            com.wushuangtech.library.video.bean.MediaCodecSurface r2 = r6.currentEncoderSurface     // Catch:{ all -> 0x00dc }
            java.lang.String r2 = r2.getId()     // Catch:{ all -> 0x00dc }
            boolean r10 = r2.equals(r10)     // Catch:{ all -> 0x00dc }
            if (r10 != 0) goto L_0x00bb
        L_0x00b9:
            monitor-exit(r3)     // Catch:{ all -> 0x00dc }
            return r4
        L_0x00bb:
            android.media.MediaCodec r10 = r6.currentMediaCodec     // Catch:{ all -> 0x00dc }
            if (r7 == r10) goto L_0x00c1
            monitor-exit(r3)     // Catch:{ all -> 0x00dc }
            return r4
        L_0x00c1:
            monitor-exit(r3)     // Catch:{ all -> 0x00dc }
            com.wushuangtech.library.video.MediaCodecHelper r10 = r6.mMediaCodecHelper
            byte[] r7 = r10.getRawVideoFrame(r7, r8, r9)
            if (r7 == 0) goto L_0x00d3
            int r9 = r7.length
            r2 = 5
            if (r9 >= r2) goto L_0x00cf
            goto L_0x00d3
        L_0x00cf:
            r10.handleRawVideoFrameToSend(r7, r8, r0)
            return r4
        L_0x00d3:
            long r7 = com.wushuangtech.library.video.VideoStatus.mVideoEncodeErrorFrames
            r9 = 1
            long r7 = r7 + r9
            com.wushuangtech.library.video.VideoStatus.mVideoEncodeErrorFrames = r7
            r7 = 0
            return r7
        L_0x00dc:
            r7 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x00dc }
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wushuangtech.myvideoimprove.codec.encoder.HardwareEncoder.handleOutputBuffer(android.media.MediaCodec, android.media.MediaCodec$BufferInfo, int, java.lang.String):boolean");
    }

    private boolean waitNextFrame(MediaCodec.BufferInfo bufferInfo, int i) {
        if (this.mWaitIFrame) {
            if (bufferInfo.flags != 1 && i != 7) {
                return true;
            }
            this.mWaitIFrame = false;
        }
        return false;
    }

    private void initThread() {
        if (this.mVideoEncoderThread == null) {
            this.mVideoEncoderThread = new Thread(new LocalEncoderRunnable(this.TAG, this));
            if (this.mDualEncoder) {
                this.mVideoEncoderThread.setName("HardwareEncoder-Dual");
            } else {
                this.mVideoEncoderThread.setName("HardwareEncoder-Main");
            }
            Thread thread = this.mVideoEncoderThread;
            if (!(thread instanceof Thread)) {
                thread.start();
            } else {
                AsynchronousInstrumentation.threadStart(thread);
            }
            String str = this.TAG;
            log(str, "Crate new thread and start! : " + this.mVideoEncoderThread);
        }
    }

    private void unInitThread() {
        Thread thread = this.mVideoEncoderThread;
        if (thread != null) {
            thread.interrupt();
            try {
                this.mVideoEncoderThread.join();
            } catch (InterruptedException unused) {
                this.mVideoEncoderThread.interrupt();
            }
            String str = this.TAG;
            log(str, "Stop thread : " + this.mVideoEncoderThread);
            this.mVideoEncoderThread = null;
        }
    }

    /* access modifiers changed from: package-private */
    public void restartEncoder() {
        if (this.mOnCodecEventCallBack != null) {
            this.mOnCodecEventCallBack.onRestartCodec();
        }
    }

    /* access modifiers changed from: protected */
    public byte[] getYuvData(byte[] bArr, int i, int i2, int i3) {
        int i4 = 1;
        int i5 = 4;
        if (GlobalConfig.mExternalVideoSource) {
            int i6 = this.mExternalVideoFormat;
            if (i6 == 5) {
                i5 = 3;
            } else if (!(i6 == 4 || i6 == 10 || i6 == 11)) {
                if (i6 != 3) {
                    if (i6 == 1) {
                        i5 = 5;
                    } else {
                        i4 = 0;
                    }
                }
                i5 = i4;
            }
        }
        LibYuvManager libYuvManager = this.mLibYuvManager;
        if (libYuvManager == null) {
            return null;
        }
        return libYuvManager.transToNV12(bArr, i5, i, i2, GlobalConfig.mLocalVideoSentDataHorMirrorEnabled, i3);
    }

    public void onVideoEncodedDataReport(byte[] bArr, ExternalVideoModuleCallback.VideoFrameType videoFrameType, long j) {
        CodecLife codecLife = this.mCodecLife;
        if (codecLife != null) {
            int codecWidth = codecLife.getCodecWidth();
            int codecHeight = codecLife.getCodecHeight();
            VideoStatus.addVideoEncodedFrameTimes(this.mDualEncoder);
            if (videoFrameType != ExternalVideoModuleCallback.VideoFrameType.FRAMETYPE_P) {
                VideoStatus.addVideoEncodeIFrameTimes(this.mDualEncoder);
            }
            if (this.mOnCodecEventCallBack != null) {
                this.mOnCodecEventCallBack.onEncodedDataReport(this.mDualEncoder, bArr, videoFrameType.ordinal(), codecWidth, codecHeight, System.currentTimeMillis());
            }
        }
    }

    static class LocalEncoderRunnable implements Runnable {
        private final String TAG;
        private final WeakReference<HardwareEncoder> outReference;

        LocalEncoderRunnable(String str, HardwareEncoder hardwareEncoder) {
            this.outReference = new WeakReference<>(hardwareEncoder);
            this.TAG = str;
        }

        public void run() {
            HardwareEncoder hardwareEncoder;
            Process.setThreadPriority(10);
            while (!Thread.interrupted() && (hardwareEncoder = (HardwareEncoder) this.outReference.get()) != null) {
                if (!hardwareEncoder.queueVideoDataFromSurface()) {
                    hardwareEncoder.restartEncoder();
                    return;
                } else {
                    try {
                        Thread.sleep(15);
                    } catch (InterruptedException unused) {
                        return;
                    }
                }
            }
        }
    }
}
