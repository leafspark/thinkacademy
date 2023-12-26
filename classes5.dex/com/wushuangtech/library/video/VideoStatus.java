package com.wushuangtech.library.video;

public class VideoStatus {
    public static final String THREAD_LOG_RTMP_REPORT = "LogRepForRTMP";
    public static final String THREAD_TOKEN_CHECK = "TokenForEngine";
    public static final String THREAD_TOKEN_CHECK_CHANNEL = "TokenForChannel";
    public static final String THREAD_VIDEO_EXTERNAL_GLENV = "EXTERNAL";
    public static final String THREAD_VIDEO_LOCAL_GLENV = "VLocal";
    public static final String THREAD_VIDEO_LOCAL_GLRATE = "VideoLocalGLRate";
    public static final String THREAD_VIDEO_LOCAL_MODULE = "VideoLocalWork";
    public static final String THREAD_VIDEO_OLD_REMOTE_GLENV = "OVRTE";
    public static final String THREAD_VIDEO_REMOTE_GLENV = "VRTE";
    public static final String THREAD_VIDEO_STATS_FOR_UI = "VideoStatsThread";
    public static int faceUnityBeautfySpendTime;
    public static OpenglESRenderStatus mEglRenderStatus;
    public static int mLocalVideoEGLDisplaySurfaceNum;
    public static int mLocalVideoEGLEncodeSurfaceNum;
    public static String mLocalVideoRenderViewAttachSize;
    public static int mTestCount;
    public static long mVideoCapFrameTimes;
    public static long mVideoDisplayRenderErrorNum;
    public static long mVideoDualEncodeRenderErrorNum;
    public static long mVideoEncodeErrorFrames;
    public static long mVideoEncodeFrames;
    public static long mVideoEncodeFramesDual;
    public static long mVideoEncodeIFrames;
    public static long mVideoEncodeIFramesDual;
    public static long mVideoEncodeRecvFrameTimes;
    public static long mVideoEncodeRenderErrorNum;
    public static long mVideoExternalEncodeRecvFrameTimes;
    public static long mVideoReadPixelSpendTime;
    public static long mVideoReadPixelSpendTimePBO;
    public static OpenglESVideoReadPixelType mVideoReadPixelType;
    public static int mVideoRecvErrorNum;
    public static long mVideoRenderDisplayFrmes;
    public static long mVideoSendFrames;
    public static long mVideoSendFramesDual;
    public static long notifyVideoFrameAvgTime;
    public static long notifyVideoFrameTimes;
    public static int videoCapBeforeFrameRate;
    public static int videoCapFrameEffectBufferSurface;
    public static int videoCapFrameEffectDisplay;
    public static int videoCapFrameEffectDualEncoder;
    public static int videoCapFrameEffectEncoder;
    public static long videoYuvChangeFormatSpendTimes;

    public enum OpenglESRenderStatus {
        RENDERING,
        PAUSE,
        STOP
    }

    public enum OpenglESVideoReadPixelType {
        FBO,
        PBO
    }

    public static void printStatus() {
    }

    public static void resetStats() {
        mVideoCapFrameTimes = 0;
        mVideoEncodeFrames = 0;
        mVideoEncodeFramesDual = 0;
        mVideoEncodeIFrames = 0;
        mVideoEncodeIFramesDual = 0;
        mVideoEncodeErrorFrames = 0;
        mVideoSendFrames = 0;
        mVideoSendFramesDual = 0;
        mVideoEncodeRecvFrameTimes = 0;
        mVideoExternalEncodeRecvFrameTimes = 0;
        mVideoRenderDisplayFrmes = 0;
        mLocalVideoEGLDisplaySurfaceNum = 0;
        mLocalVideoEGLEncodeSurfaceNum = 0;
        mVideoRecvErrorNum = 0;
    }

    public static void addVideoCapFrameTimes() {
        mVideoCapFrameTimes++;
    }

    public static void addVideoEncodedFrameTimes(boolean z) {
        if (z) {
            mVideoEncodeFramesDual++;
        } else {
            mVideoEncodeFrames++;
        }
    }

    public static void addVideoEncodeIFrameTimes(boolean z) {
        if (z) {
            mVideoEncodeIFramesDual++;
        } else {
            mVideoEncodeIFrames++;
        }
    }

    public static void addVideoSendFrames(boolean z) {
        if (z) {
            mVideoSendFramesDual++;
        } else {
            mVideoSendFrames++;
        }
    }

    public static long getVideoEncodedFrames() {
        return mVideoEncodeFrames + mVideoEncodeFramesDual;
    }
}
