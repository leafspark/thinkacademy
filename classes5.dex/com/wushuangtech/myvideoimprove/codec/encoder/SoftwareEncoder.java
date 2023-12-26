package com.wushuangtech.myvideoimprove.codec.encoder;

import com.wushuangtech.api.ExternalVideoModuleCallback;
import com.wushuangtech.library.GlobalConfig;
import com.wushuangtech.library.video.VideoStatus;
import com.wushuangtech.library.video.codec.NativeVideoEncodeHelper;
import com.wushuangtech.myvideoimprove.bean.CodecBaseEncoderConfigureBean;
import com.wushuangtech.myvideoimprove.bean.CodecConfigureBean;

public class SoftwareEncoder extends BaseEncoderImpl implements NativeVideoEncodeHelper.OnNativeVideoEncodeCallBack {
    private static NativeVideoEncodeHelper mNativeVideoEncodeHelper;
    private boolean mEncoding;
    private int mLastTargetHeight;
    private int mLastTargetWidth;
    private final Object mLock = new Object();
    private int nBSlicedThreads = 0;

    public boolean isHardwareEncoder() {
        return false;
    }

    public CodecConfigureBean onCodecConfiguring(CodecConfigureBean codecConfigureBean) {
        return codecConfigureBean;
    }

    public void onCodecStartFinish(CodecConfigureBean codecConfigureBean) {
    }

    public void onSyncCodecAssignment(CodecConfigureBean codecConfigureBean) {
    }

    public CodecConfigureBean onSyncCodecPrepareRelease() {
        return null;
    }

    public void requestIFrame() {
    }

    public SoftwareEncoder(String str) {
        super(str);
        setTAG("SoftwareEncoder<" + Integer.toHexString(hashCode()) + ">");
    }

    public boolean initEncoder(String str) {
        super.initEncoder(str);
        if (mNativeVideoEncodeHelper != null) {
            return true;
        }
        NativeVideoEncodeHelper nativeVideoEncodeHelper = new NativeVideoEncodeHelper();
        mNativeVideoEncodeHelper = nativeVideoEncodeHelper;
        nativeVideoEncodeHelper.setOnNativeVideoEncodeCallBack(this);
        return true;
    }

    public CodecConfigureBean onSyncCodecStartConfigure(int i, int i2) {
        super.onSyncCodecStartConfigure(i, i2);
        CodecBaseEncoderConfigureBean codecBaseEncoderConfigureBean = new CodecBaseEncoderConfigureBean();
        codecBaseEncoderConfigureBean.width = i;
        codecBaseEncoderConfigureBean.height = i2;
        codecBaseEncoderConfigureBean.fps = this.mVideoFps;
        codecBaseEncoderConfigureBean.bitrate = this.mVideoBitrate;
        codecBaseEncoderConfigureBean.gop = this.mVideoGop;
        codecBaseEncoderConfigureBean.verticalMirror = false;
        return codecBaseEncoderConfigureBean;
    }

    public boolean onSyncCodecStart(CodecConfigureBean codecConfigureBean) {
        CodecBaseEncoderConfigureBean codecBaseEncoderConfigureBean = (CodecBaseEncoderConfigureBean) codecConfigureBean;
        synchronized (this.mLock) {
            if (this.mEncoding) {
                return true;
            }
            this.mEncoding = true;
            this.nBSlicedThreads = GlobalConfig.getEncoderBSlicedThread();
            boolean openSoftEncoder = mNativeVideoEncodeHelper.openSoftEncoder(codecBaseEncoderConfigureBean.width, codecBaseEncoderConfigureBean.height, this.mVideoFps, codecBaseEncoderConfigureBean.bitrate, codecBaseEncoderConfigureBean.gop, GlobalConfig.getEncoderBSlicedThread());
            return openSoftEncoder;
        }
    }

    public void onSyncCodecReleasing(CodecConfigureBean codecConfigureBean) {
        synchronized (this.mLock) {
            if (this.mEncoding) {
                mNativeVideoEncodeHelper.closeSoftEncoder();
                this.mEncoding = false;
            }
        }
    }

    public boolean onCodecReleasing(CodecConfigureBean codecConfigureBean) {
        synchronized (this.mLock) {
            if (!this.mEncoding) {
                return true;
            }
            mNativeVideoEncodeHelper.closeSoftEncoder();
            this.mEncoding = false;
            return true;
        }
    }

    public void setDynamicBitrate(int i) {
        mNativeVideoEncodeHelper.setDynamicBitrate(i);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v3, resolved type: java.lang.Object[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void receiveVideoData(byte[] r19, int r20, int r21, int r22, long r23, int r25) {
        /*
            r18 = this;
            r0 = r18
            r6 = r22
            r1 = r25
            com.wushuangtech.library.video.codec.NativeVideoEncodeHelper r8 = mNativeVideoEncodeHelper
            if (r8 == 0) goto L_0x0118
            if (r19 != 0) goto L_0x000e
            goto L_0x0118
        L_0x000e:
            r2 = 1000(0x3e8, double:4.94E-321)
            long r9 = r23 * r2
            long r11 = java.lang.System.currentTimeMillis()
            long r2 = java.lang.System.currentTimeMillis()
            long r2 = r2 - r11
            com.wushuangtech.library.video.VideoStatus.videoYuvChangeFormatSpendTimes = r2
            r13 = 3
            r14 = 5
            r15 = 4
            r7 = 1
            if (r1 != r7) goto L_0x0025
            r2 = r14
            goto L_0x002e
        L_0x0025:
            if (r1 != r15) goto L_0x0029
            r2 = r15
            goto L_0x002e
        L_0x0029:
            if (r1 != r14) goto L_0x002d
            r2 = r13
            goto L_0x002e
        L_0x002d:
            r2 = r7
        L_0x002e:
            com.wushuangtech.library.GlobalHolder r1 = com.wushuangtech.library.GlobalHolder.getInstance()
            com.wushuangtech.library.video.LibYuvManager r1 = r1.getYuvManager()
            r3 = 90
            if (r6 == r3) goto L_0x0044
            r3 = 270(0x10e, float:3.78E-43)
            if (r6 != r3) goto L_0x003f
            goto L_0x0044
        L_0x003f:
            r5 = r20
            r4 = r21
            goto L_0x0048
        L_0x0044:
            r4 = r20
            r5 = r21
        L_0x0048:
            boolean r16 = com.wushuangtech.library.GlobalConfig.mLocalVideoSentDataHorMirrorEnabled
            r3 = r19
            r14 = r4
            r4 = r20
            r15 = r5
            r5 = r21
            r6 = r22
            r17 = r7
            r7 = r16
            byte[] r1 = r1.commonToI420(r2, r3, r4, r5, r6, r7)
            int r2 = r0.mLastTargetWidth
            if (r2 != r15) goto L_0x0064
            int r2 = r0.mLastTargetHeight
            if (r2 == r14) goto L_0x0090
        L_0x0064:
            r0.mLastTargetWidth = r15
            r0.mLastTargetHeight = r14
            com.wushuangtech.library.video.codec.NativeVideoEncodeHelper r2 = mNativeVideoEncodeHelper
            r2.closeSoftEncoder()
            int r2 = com.wushuangtech.library.GlobalConfig.getEncoderBSlicedThread()
            r0.nBSlicedThreads = r2
            com.wushuangtech.library.video.codec.NativeVideoEncodeHelper r2 = mNativeVideoEncodeHelper
            int r3 = r0.mVideoFps
            int r4 = r0.mVideoBitrate
            int r5 = r0.mVideoGop
            int r6 = com.wushuangtech.library.GlobalConfig.getEncoderBSlicedThread()
            r19 = r2
            r20 = r15
            r21 = r14
            r22 = r3
            r23 = r4
            r24 = r5
            r25 = r6
            r19.openSoftEncoder(r20, r21, r22, r23, r24, r25)
        L_0x0090:
            int r2 = r0.nBSlicedThreads
            int r3 = com.wushuangtech.library.GlobalConfig.getEncoderBSlicedThread()
            if (r2 == r3) goto L_0x00c0
            int r2 = com.wushuangtech.library.GlobalConfig.getEncoderBSlicedThread()
            r0.nBSlicedThreads = r2
            com.wushuangtech.library.video.codec.NativeVideoEncodeHelper r2 = mNativeVideoEncodeHelper
            r2.closeSoftEncoder()
            com.wushuangtech.library.video.codec.NativeVideoEncodeHelper r2 = mNativeVideoEncodeHelper
            int r3 = r0.mVideoFps
            int r4 = r0.mVideoBitrate
            int r5 = r0.mVideoGop
            int r6 = com.wushuangtech.library.GlobalConfig.getEncoderBSlicedThread()
            r19 = r2
            r20 = r15
            r21 = r14
            r22 = r3
            r23 = r4
            r24 = r5
            r25 = r6
            r19.openSoftEncoder(r20, r21, r22, r23, r24, r25)
        L_0x00c0:
            boolean r2 = com.wushuangtech.library.GlobalConfig.mExternalVideoSource
            if (r2 == 0) goto L_0x0115
            com.wushuangtech.library.GlobalHolder r2 = com.wushuangtech.library.GlobalHolder.getInstance()
            r3 = 15004(0x3a9c, float:2.1025E-41)
            r4 = 10
            java.lang.Object[] r4 = new java.lang.Object[r4]
            r5 = 0
            r4[r5] = r1
            java.lang.Integer r6 = java.lang.Integer.valueOf(r5)
            r4[r17] = r6
            java.lang.Integer r6 = java.lang.Integer.valueOf(r15)
            r7 = 2
            r4[r7] = r6
            java.lang.Integer r6 = java.lang.Integer.valueOf(r14)
            r4[r13] = r6
            java.lang.Integer r6 = java.lang.Integer.valueOf(r5)
            r13 = 4
            r4[r13] = r6
            java.lang.Integer r6 = java.lang.Integer.valueOf(r15)
            r13 = 5
            r4[r13] = r6
            r6 = 6
            int r7 = r15 / 2
            java.lang.Integer r13 = java.lang.Integer.valueOf(r7)
            r4[r6] = r13
            r6 = 7
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            r4[r6] = r7
            r6 = 8
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            r4[r6] = r5
            r5 = 9
            java.lang.Long r6 = java.lang.Long.valueOf(r11)
            r4[r5] = r6
            r2.sendSyncRtcEngineEvent(r3, r4)
        L_0x0115:
            r8.encodeYuvFrame(r1, r9)
        L_0x0118:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.wushuangtech.myvideoimprove.codec.encoder.SoftwareEncoder.receiveVideoData(byte[], int, int, int, long, int):void");
    }

    public void onVideoDataEncoded(Object... objArr) {
        int intValue = objArr[1].intValue();
        VideoStatus.addVideoEncodedFrameTimes(this.mDualEncoder);
        if (intValue != ExternalVideoModuleCallback.VideoFrameType.FRAMETYPE_P.ordinal()) {
            VideoStatus.addVideoEncodeIFrameTimes(this.mDualEncoder);
        }
        if (this.mOnCodecEventCallBack != null) {
            this.mOnCodecEventCallBack.onEncodedDataReport(this.mDualEncoder, objArr[0], intValue, objArr[2].intValue(), objArr[3].intValue(), objArr[4].longValue());
        }
    }
}
