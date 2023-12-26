package com.wushuangtech.myvideoimprove;

public interface VideoRenderer {

    public interface OnVideoRendererAddSurfaceCallBack {
        void initVideoRendererResult(boolean z);

        void onScreenRotateChanged(int i);

        int onVideoFrameData(int i, byte[] bArr, int i2, int i3, int i4, long j);

        void onVideoFrameDrawingFailed(int i);

        boolean onVideoRendererFirstFrame();

        void onVideoRendererUninit();
    }

    void destroyVideoRenderer();

    void initRenderer();

    void pauseRender();

    void resumeRender();

    void setRenderMode(int i);

    void setVideoSize(int i, int i2);

    void setViewSize(int i, int i2);

    boolean startRender();

    void stopRender();

    void unInitVideoRenderer();
}
