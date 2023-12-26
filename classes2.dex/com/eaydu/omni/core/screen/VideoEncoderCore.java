package com.eaydu.omni.core.screen;

import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Surface;
import com.eaydu.omni.core.screen.ScreenCapture;
import com.wushuangtech.api.AVRecorderModule;
import com.wushuangtech.api.ExternalVideoModule;
import com.wushuangtech.api.ExternalVideoModuleCallback;
import com.wushuangtech.library.GlobalConfig;
import com.wushuangtech.utils.OmniLog;
import java.io.File;
import java.nio.ByteBuffer;
import java.util.ArrayList;

public class VideoEncoderCore {
    private static final String ENCODER_TYPE = "video/avc";
    private static final String TAG = "SCREEN_WATCH";
    private static final int TIMEOUT_USEC = 10000;
    private static final boolean VERBOSE = false;
    private double draw_frame;
    private int encodeFrames;
    private double last_real_fps;
    private long last_time;
    private AVRecorderModule mAVRecorderModule;
    private ScreenCapture.RecordCallback mCallback;
    private ArrayList<byte[]> mEncodeDatas = new ArrayList<>();
    private String mFilePath;
    private boolean mFirstDataComing;
    private int mFps;
    private int mHeight;
    private Surface mInputSurface;
    private long mLastSendTime;
    private long mRecordStartedTime;
    private long mRecordTime;
    private MediaCodec.BufferInfo mVBufferInfo;
    private MediaCodec mVideoEncoder;
    private int mWidth;
    private final Object mWriteLock = new Object();
    private long prev_ts;
    private double real_fps;
    private long smooth_ts;
    private byte[] sps_pps_byte;
    private int sps_pps_len;

    VideoEncoderCore(ScreenCapture.RecordCallback recordCallback) {
        this.mCallback = recordCallback;
    }

    /* access modifiers changed from: package-private */
    public boolean initEncoder(ScreenEncoderConfig screenEncoderConfig) {
        if (GlobalConfig.mIsScreenRecording.get()) {
            this.mFilePath = screenEncoderConfig.mOutputFile.toString();
            this.mAVRecorderModule = new AVRecorderModule();
            OmniLog.screen_d(TAG, "save file path : " + this.mFilePath);
        }
        this.mVBufferInfo = new MediaCodec.BufferInfo();
        this.sps_pps_len = 0;
        this.mWidth = screenEncoderConfig.mWidth;
        this.mHeight = screenEncoderConfig.mHeight;
        this.mFps = screenEncoderConfig.mFrameRate;
        this.last_time = 0;
        this.draw_frame = 0.0d;
        this.last_real_fps = 0.0d;
        this.real_fps = (double) screenEncoderConfig.mFrameRate;
        try {
            openHardwareEncoder(screenEncoderConfig);
        } catch (Exception e) {
            e.printStackTrace();
            OmniLog.screen_e(TAG, "Screen encoder open exception ! " + e.getLocalizedMessage());
            if (screenEncoderConfig.mBitrateMode == 0) {
                try {
                    screenEncoderConfig.mBitrateMode = 1;
                    openHardwareEncoder(screenEncoderConfig);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    OmniLog.screen_e(TAG, "222 Screen encoder open exception ! " + e2.getLocalizedMessage());
                    return false;
                }
            }
            return false;
        }
        return true;
    }

    private void openHardwareEncoder(ScreenEncoderConfig screenEncoderConfig) throws Exception {
        synchronized (VideoEncoderCore.class) {
            this.sps_pps_len = 0;
            if (this.mVideoEncoder == null) {
                this.mVideoEncoder = MediaCodec.createByCodecName(chooseVideoEncoderInfo().getName());
            }
            MediaFormat createVideoFormat = MediaFormat.createVideoFormat(screenEncoderConfig.mMinType, screenEncoderConfig.mWidth, screenEncoderConfig.mHeight);
            createVideoFormat.setInteger("color-format", 2130708361);
            createVideoFormat.setInteger("bitrate", screenEncoderConfig.mBitRate);
            createVideoFormat.setInteger("frame-rate", screenEncoderConfig.mFrameRate);
            createVideoFormat.setInteger("i-frame-interval", screenEncoderConfig.mIFrameInterval);
            createVideoFormat.setInteger("bitrate-mode", screenEncoderConfig.mBitrateMode);
            this.mVideoEncoder.configure(createVideoFormat, (Surface) null, (MediaCrypto) null, 1);
            this.mInputSurface = this.mVideoEncoder.createInputSurface();
            this.mVideoEncoder.start();
            OmniLog.screen_d(TAG, "Screen encoder created! " + screenEncoderConfig.toString());
        }
    }

    private void closeHardwareEncoder() {
        synchronized (VideoEncoderCore.class) {
            try {
                MediaCodec mediaCodec = this.mVideoEncoder;
                if (mediaCodec != null) {
                    mediaCodec.signalEndOfInputStream();
                    this.mVideoEncoder.reset();
                }
                OmniLog.screen_d(TAG, "Screen encoder reset! ");
            } catch (Exception e) {
                OmniLog.screen_e(TAG, "Invoke MediaCodec <reset> Exception! release it!");
                e.printStackTrace();
                MediaCodec mediaCodec2 = this.mVideoEncoder;
                if (mediaCodec2 != null) {
                    mediaCodec2.release();
                    this.mVideoEncoder = null;
                }
            }
        }
    }

    private MediaCodecInfo chooseVideoEncoderInfo() {
        int codecCount = MediaCodecList.getCodecCount();
        for (int i = 0; i < codecCount; i++) {
            MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i);
            if (codecInfoAt.isEncoder()) {
                for (String str : codecInfoAt.getSupportedTypes()) {
                    OmniLog.lp(TAG, String.format("vencoder support %s types: %s", new Object[]{codecInfoAt.getName(), str}));
                    if (str.equalsIgnoreCase("video/avc")) {
                        return codecInfoAt;
                    }
                }
                continue;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public Surface getInputSurface() {
        return this.mInputSurface;
    }

    public void release() {
        OmniLog.screen_d(TAG, "releasing encoder objects!");
        MediaCodec mediaCodec = this.mVideoEncoder;
        if (mediaCodec != null) {
            mediaCodec.stop();
            this.mVideoEncoder.release();
            this.mVideoEncoder = null;
        }
        if (GlobalConfig.mIsScreenRecording.get()) {
            synchronized (this.mWriteLock) {
            }
            reportRecordFinish();
        }
    }

    private void reportRecordFinish() {
        File file = new File(this.mFilePath);
        ScreenCapture.RecordCallback recordCallback = this.mCallback;
        if (recordCallback != null) {
            if (file.exists()) {
                String name = file.getName();
                OmniLog.screen_d(TAG, "Record File mResultCheck: " + name);
                String substring = name.substring(0, name.indexOf("."));
                OmniLog.screen_d(TAG, "Record File substring: " + substring);
                String str = file.getParent() + File.separator + substring + ".mp4";
                if (file.renameTo(new File(str))) {
                    OmniLog.screen_d(TAG, "Record File rename success : " + str);
                } else {
                    OmniLog.screen_d(TAG, "Record File rename failed : " + str);
                }
                if (Build.VERSION.SDK_INT >= 29) {
                    String onRecordMoveFile = recordCallback.onRecordMoveFile(str);
                    if (!TextUtils.isEmpty(onRecordMoveFile)) {
                        recordCallback.onRecordSuccess(onRecordMoveFile, this.mRecordTime);
                    } else {
                        recordCallback.onRecordFailed("Move file failed!", this.mRecordTime);
                    }
                } else {
                    recordCallback.onRecordSuccess(this.mFilePath, this.mRecordTime);
                }
            } else {
                recordCallback.onRecordFailed("File not exist!", this.mRecordTime);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void drainEncoder(boolean z) {
        MediaCodec mediaCodec;
        if (!this.mFirstDataComing) {
            this.mFirstDataComing = true;
            this.mRecordStartedTime = System.currentTimeMillis();
        }
        if (z && (mediaCodec = this.mVideoEncoder) != null) {
            mediaCodec.signalEndOfInputStream();
        }
        synchronized (VideoEncoderCore.class) {
            try {
                drainVideo();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (this.mCallback != null) {
            long currentTimeMillis = (System.currentTimeMillis() - this.mRecordStartedTime) / 1000;
            this.mRecordTime = currentTimeMillis;
            if (this.mLastSendTime != currentTimeMillis) {
                this.mCallback.onRecordedDurationChanged(currentTimeMillis);
                this.mLastSendTime = this.mRecordTime;
            }
        }
    }

    private void drainVideo() {
        byte b;
        MediaCodec mediaCodec = this.mVideoEncoder;
        if (mediaCodec != null) {
            int dequeueOutputBuffer = mediaCodec.dequeueOutputBuffer(this.mVBufferInfo, 10000);
            if (dequeueOutputBuffer != -1 && dequeueOutputBuffer == -2) {
                MediaFormat outputFormat = this.mVideoEncoder.getOutputFormat();
                OmniLog.screen_d(TAG, "drainVideo INFO_OUTPUT_FORMAT_CHANGED -> format changed! " + outputFormat.toString());
            }
            while (dequeueOutputBuffer >= 0) {
                ByteBuffer outputBuffer = this.mVideoEncoder.getOutputBuffer(dequeueOutputBuffer);
                if (outputBuffer == null) {
                    this.mVideoEncoder.releaseOutputBuffer(dequeueOutputBuffer, false);
                    dequeueOutputBuffer = this.mVideoEncoder.dequeueOutputBuffer(this.mVBufferInfo, 10000);
                } else {
                    try {
                        b = (byte) (outputBuffer.get(4) & 31);
                    } catch (Exception unused) {
                        b = -1;
                    }
                    if (b == -1) {
                        this.mVideoEncoder.releaseOutputBuffer(dequeueOutputBuffer, false);
                        dequeueOutputBuffer = this.mVideoEncoder.dequeueOutputBuffer(this.mVBufferInfo, 10000);
                    } else {
                        outputBuffer.position(this.mVBufferInfo.offset);
                        byte b2 = (byte) (outputBuffer.get(4) & 31);
                        byte[] bArr = new byte[this.mVBufferInfo.size];
                        outputBuffer.get(bArr);
                        byte[] bArr2 = null;
                        if (b2 == 5 || b2 == 6) {
                            int i = this.mVBufferInfo.size;
                            int i2 = this.sps_pps_len;
                            bArr2 = new byte[(i + i2)];
                            System.arraycopy(this.sps_pps_byte, 0, bArr2, 0, i2);
                            System.arraycopy(bArr, 0, bArr2, this.sps_pps_len, this.mVBufferInfo.size);
                        } else if (b2 == 7) {
                            int i3 = this.mVBufferInfo.size - 4;
                            this.sps_pps_len = i3;
                            byte[] bArr3 = new byte[i3];
                            this.sps_pps_byte = bArr3;
                            System.arraycopy(bArr, 4, bArr3, 0, i3);
                        } else {
                            bArr2 = new byte[(this.mVBufferInfo.size - 4)];
                            System.arraycopy(bArr, 4, bArr2, 0, this.mVBufferInfo.size - 4);
                        }
                        if (bArr2 == null) {
                            this.mVideoEncoder.releaseOutputBuffer(dequeueOutputBuffer, false);
                            dequeueOutputBuffer = this.mVideoEncoder.dequeueOutputBuffer(this.mVBufferInfo, 10000);
                        } else {
                            this.mEncodeDatas.clear();
                            this.mEncodeDatas.add(bArr2);
                            this.encodeFrames++;
                            if (!GlobalConfig.mIsScreenRecording.get()) {
                                long currentTimeMillis = System.currentTimeMillis();
                                if (GlobalConfig.mIsScreenRecordShare.get()) {
                                    if (b2 == 5 || b2 == 6) {
                                        ExternalVideoModule.getInstance().pushEncodedVideoData(this.mEncodeDatas, ExternalVideoModuleCallback.VideoFrameType.FRAMETYPE_I, this.mWidth, this.mHeight, currentTimeMillis);
                                    } else {
                                        ExternalVideoModule.getInstance().pushEncodedVideoData(this.mEncodeDatas, ExternalVideoModuleCallback.VideoFrameType.FRAMETYPE_P, this.mWidth, this.mHeight, currentTimeMillis);
                                    }
                                }
                            }
                            this.mVideoEncoder.releaseOutputBuffer(dequeueOutputBuffer, false);
                            dequeueOutputBuffer = this.mVideoEncoder.dequeueOutputBuffer(this.mVBufferInfo, 10000);
                        }
                    }
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public long smoothTimestamp() {
        long currentTimeMillis = System.currentTimeMillis();
        boolean z = currentTimeMillis - this.prev_ts > 1000;
        this.prev_ts = currentTimeMillis;
        double d = this.last_real_fps;
        double d2 = this.real_fps;
        if (d != d2 || z) {
            this.last_real_fps = d2;
            this.last_time = currentTimeMillis;
            this.draw_frame = 1.0d;
            this.smooth_ts = currentTimeMillis;
            return currentTimeMillis;
        }
        double d3 = this.draw_frame;
        if (((double) (currentTimeMillis - this.last_time)) < (d3 * 1000.0d) / d2) {
            return -1;
        }
        this.draw_frame = d3 + 1.0d;
        long j = (long) (((double) this.smooth_ts) + (1000.0d / d2));
        this.smooth_ts = j;
        long j2 = currentTimeMillis - j;
        if (((double) Math.abs(j2)) > 200.0d / d2) {
            this.smooth_ts += j2;
        }
        return this.smooth_ts;
    }

    private void changeEncParam(int i, int i2) {
        if (this.mFps != 0) {
            synchronized (VideoEncoderCore.class) {
                if (this.mVideoEncoder != null) {
                    Bundle bundle = new Bundle();
                    bundle.putInt("video-bitrate", i);
                    this.mVideoEncoder.setParameters(bundle);
                }
            }
        }
    }
}
