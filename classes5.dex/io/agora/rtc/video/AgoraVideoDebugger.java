package io.agora.rtc.video;

import android.os.Handler;
import android.os.HandlerThread;
import io.agora.rtc.gl.EglBase;
import io.agora.rtc.gl.VideoFrame;
import io.agora.rtc.mediaio.AgoraSurfaceView;

public class AgoraVideoDebugger {
    public static final boolean DIRECT_OES = false;
    public static final boolean ENABLE_DEBUG = false;
    static final String TAG = "AgoraVideoDebugger";
    public static final boolean VERBOSE = false;
    public static final boolean VERBOSE_DETAIL = false;
    static boolean applyRotation = false;
    static AgoraSurfaceView debugViewForTexture = null;
    static int droppedTextureFrameCnt = 0;
    static boolean followSourceDimension = false;
    static boolean isDebugViewInitialized = false;
    static int lastTextureHeight = 0;
    static int lastTextureWidth = 0;
    static boolean mirror = false;
    static Handler renderHandler;
    static HandlerThread renderThread;
    static int textureFrameCnt;

    static void onDropTextureBuffer(long j) {
    }

    static void onRawBufferAvailable(VideoCapture videoCapture, byte[] bArr, int i) {
    }

    static void onTextureAndRawBufferAvailable(VideoCapture videoCapture, VideoFrame.TextureBuffer textureBuffer, int i, long j, byte[] bArr, int i2) {
    }

    static void onTextureBufferAvailable(VideoCapture videoCapture, EglBase.Context context, VideoFrame.TextureBuffer textureBuffer, int i, long j) {
    }

    static void reset() {
    }

    public static void setDebugViewForTexture(AgoraSurfaceView agoraSurfaceView, boolean z, boolean z2, boolean z3) {
    }
}
