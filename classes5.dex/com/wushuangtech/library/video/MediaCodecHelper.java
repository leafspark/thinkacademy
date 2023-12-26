package com.wushuangtech.library.video;

import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.os.Build;
import com.wushuangtech.api.ExternalVideoModuleCallback;
import com.wushuangtech.utils.OmniLog;
import java.nio.ByteBuffer;
import java.util.Locale;

public class MediaCodecHelper {
    private static final String H264_ENCODER_TYPE = "video/avc";
    private static final String TAG = "MediaCodecHelper";
    private final OnMediaCodecHelperCallBack mOnMediaCodecHelperCallBack;
    private byte[] mPreSpsFrame;
    private byte[] mSpsPpsBuffer;
    private int mSpsPpsLength;

    public interface OnMediaCodecHelperCallBack {
        void onVideoEncodedDataReport(byte[] bArr, ExternalVideoModuleCallback.VideoFrameType videoFrameType, long j);
    }

    public MediaCodecHelper(OnMediaCodecHelperCallBack onMediaCodecHelperCallBack) {
        this.mOnMediaCodecHelperCallBack = onMediaCodecHelperCallBack;
    }

    public MediaCodecInfo findMediaCodecInfoToEncoding() {
        int i;
        try {
            i = MediaCodecList.getCodecCount();
        } catch (RuntimeException unused) {
            i = 0;
        }
        int i2 = 0;
        while (i2 < i) {
            try {
                MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i2);
                if (codecInfoAt == null || codecInfoAt.isEncoder()) {
                    for (String str : codecInfoAt.getSupportedTypes()) {
                        OmniLog.debugD(TAG, String.format("vencoder support %s types: %s", new Object[]{codecInfoAt.getName(), str}));
                        if (str.equalsIgnoreCase(H264_ENCODER_TYPE)) {
                            return codecInfoAt;
                        }
                    }
                    continue;
                    i2++;
                } else {
                    i2++;
                }
            } catch (RuntimeException unused2) {
            }
        }
        return null;
    }

    public int findVideoEncoderColorFormat(MediaCodecInfo mediaCodecInfo) {
        if (mediaCodecInfo == null) {
            return 0;
        }
        MediaCodecInfo.CodecCapabilities capabilitiesForType = mediaCodecInfo.getCapabilitiesForType(H264_ENCODER_TYPE);
        int i = 0;
        for (int i2 : capabilitiesForType.colorFormats) {
            OmniLog.debugD(TAG, String.format(Locale.CHINA, "vencoder %s supports color fomart 0x%x(%d)", new Object[]{mediaCodecInfo.getName(), Integer.valueOf(i2), Integer.valueOf(i2)}));
            if (i2 >= 19 && i2 <= 21 && i2 > i) {
                i = i2;
            }
        }
        return i;
    }

    public boolean checkVideoBitrateModeAvailable(MediaCodecInfo mediaCodecInfo, String str, int i) {
        if (Build.VERSION.SDK_INT < 21) {
            return false;
        }
        try {
            MediaCodecInfo.EncoderCapabilities encoderCapabilities = mediaCodecInfo.getCapabilitiesForType(str).getEncoderCapabilities();
            if (encoderCapabilities == null) {
                return false;
            }
            return encoderCapabilities.isBitrateModeSupported(i);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public byte[] getRawVideoFrame(MediaCodec mediaCodec, MediaCodec.BufferInfo bufferInfo, int i) {
        ByteBuffer byteBuffer;
        try {
            if (Build.VERSION.SDK_INT >= 21) {
                byteBuffer = mediaCodec.getOutputBuffer(i);
            } else {
                byteBuffer = mediaCodec.getOutputBuffers()[i];
            }
            if (byteBuffer == null) {
                return null;
            }
            byte[] bArr = new byte[bufferInfo.size];
            byteBuffer.get(bArr, bufferInfo.offset, bufferInfo.size);
            return bArr;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void handleRawVideoFrameToSend(byte[] bArr, MediaCodec.BufferInfo bufferInfo, long j) {
        ExternalVideoModuleCallback.VideoFrameType videoFrameType;
        OnMediaCodecHelperCallBack onMediaCodecHelperCallBack;
        byte b = (byte) (bArr[4] & 31);
        byte[] bArr2 = null;
        if (b == 5 || b == 6) {
            if (this.mSpsPpsBuffer != null) {
                int i = bufferInfo.size;
                int i2 = this.mSpsPpsLength;
                byte[] bArr3 = new byte[(i + i2)];
                System.arraycopy(this.mSpsPpsBuffer, 0, bArr3, 0, i2);
                System.arraycopy(bArr, 0, bArr3, this.mSpsPpsLength, bufferInfo.size);
                videoFrameType = ExternalVideoModuleCallback.VideoFrameType.FRAMETYPE_I;
                this.mPreSpsFrame = null;
                bArr2 = bArr3;
            } else {
                return;
            }
        } else if (b == 7) {
            int i3 = bufferInfo.size - 4;
            this.mSpsPpsLength = i3;
            byte[] bArr4 = new byte[i3];
            this.mPreSpsFrame = bArr4;
            System.arraycopy(bArr, 4, bArr4, 0, bufferInfo.size - 4);
            byte[] bArr5 = this.mSpsPpsBuffer;
            if (bArr5 == null || bArr5.length != this.mSpsPpsLength) {
                this.mSpsPpsBuffer = new byte[this.mSpsPpsLength];
            }
            System.arraycopy(bArr, 4, this.mSpsPpsBuffer, 0, this.mSpsPpsLength);
            videoFrameType = null;
        } else {
            byte[] bArr6 = this.mPreSpsFrame;
            if (bArr6 != null) {
                byte[] bArr7 = new byte[bArr6.length];
                System.arraycopy(bArr6, 0, bArr7, 0, bArr6.length);
                OnMediaCodecHelperCallBack onMediaCodecHelperCallBack2 = this.mOnMediaCodecHelperCallBack;
                if (onMediaCodecHelperCallBack2 != null) {
                    onMediaCodecHelperCallBack2.onVideoEncodedDataReport(bArr7, ExternalVideoModuleCallback.VideoFrameType.FRAMETYPE_I, System.currentTimeMillis());
                }
                this.mPreSpsFrame = null;
            }
            bArr2 = new byte[(bufferInfo.size - 4)];
            System.arraycopy(bArr, 4, bArr2, 0, bufferInfo.size - 4);
            videoFrameType = ExternalVideoModuleCallback.VideoFrameType.FRAMETYPE_P;
        }
        if (bArr2 != null && (onMediaCodecHelperCallBack = this.mOnMediaCodecHelperCallBack) != null) {
            onMediaCodecHelperCallBack.onVideoEncodedDataReport(bArr2, videoFrameType, j);
        }
    }

    public void clearResource() {
        this.mSpsPpsLength = 0;
        this.mPreSpsFrame = null;
        this.mSpsPpsBuffer = null;
    }

    public static boolean isMtk() {
        int i;
        try {
            i = MediaCodecList.getCodecCount();
        } catch (RuntimeException unused) {
            i = 0;
        }
        MediaCodecInfo mediaCodecInfo = null;
        int i2 = 0;
        while (i2 < i) {
            try {
                MediaCodecInfo codecInfoAt = MediaCodecList.getCodecInfoAt(i2);
                if (codecInfoAt == null || codecInfoAt.isEncoder()) {
                    String[] supportedTypes = codecInfoAt.getSupportedTypes();
                    int length = supportedTypes.length;
                    int i3 = 0;
                    while (true) {
                        if (i3 >= length) {
                            break;
                        } else if (supportedTypes[i3].equalsIgnoreCase(H264_ENCODER_TYPE)) {
                            mediaCodecInfo = codecInfoAt;
                            break;
                        } else {
                            i3++;
                        }
                    }
                    if (mediaCodecInfo != null) {
                        break;
                    }
                    i2++;
                } else {
                    i2++;
                }
            } catch (RuntimeException unused2) {
            }
        }
        if (mediaCodecInfo == null || !mediaCodecInfo.getName().contains("MTK")) {
            return false;
        }
        return true;
    }
}
