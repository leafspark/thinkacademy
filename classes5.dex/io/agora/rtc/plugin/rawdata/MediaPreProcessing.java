package io.agora.rtc.plugin.rawdata;

import java.nio.ByteBuffer;

public class MediaPreProcessing {
    static boolean load = true;

    public interface InternalProgressCallback {
        void onCaptureVideoFrame(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, long j);

        void onMixedAudioFrame(int i, int i2, int i3, int i4, int i5, long j, int i6);

        void onNeedToReconfigVideoBuffer(int i, int i2, int i3);

        void onPlaybackAudioFrame(int i, int i2, int i3, int i4, int i5, long j, int i6);

        void onPlaybackAudioFrameBeforeMixing(int i, int i2, int i3, int i4, int i5, int i6, long j, int i7);

        void onRecordAudioFrame(int i, int i2, int i3, int i4, int i5, long j, int i6);

        void onRenderVideoFrame(String str, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, long j);
    }

    public static native void release();

    public static native void setAudioCapturingBuffer(ByteBuffer byteBuffer);

    public static native void setAudioMixedBuffer(ByteBuffer byteBuffer);

    public static native void setAudioMixingBuffer(int i, ByteBuffer byteBuffer);

    public static native void setAudioPlayingBuffer(ByteBuffer byteBuffer);

    public static native void setDataCallback(InternalProgressCallback internalProgressCallback);

    public static native void setVideoBuffer(int i, ByteBuffer byteBuffer);

    @Deprecated
    public static native void setVideoCapturingBuffer(ByteBuffer byteBuffer);

    static {
        try {
            System.loadLibrary("apm-plugin-raw-data");
        } catch (Throwable unused) {
        }
    }

    public static boolean isLoad() {
        return load;
    }
}
