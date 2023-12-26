package com.wushuangtech.myvideoimprove.view;

import com.wushuangtech.myvideoimprove.bean.VideoRenderViewLifeBean;

public interface VideoRenderView {

    public interface OnVideoRenderViewCallBack {
        void onVideoRenderSurfaceAvailable(VideoRenderViewLifeBean videoRenderViewLifeBean);

        void onVideoRenderSurfaceDestroyed(VideoRenderViewLifeBean videoRenderViewLifeBean);

        void onVideoRenderSurfaceSizeChanged(VideoRenderViewLifeBean videoRenderViewLifeBean);

        void onViewRenderAttachedToWindow(VideoRenderView videoRenderView);

        void onViewRenderDetachedFromWindow(VideoRenderView videoRenderView);
    }

    Object getNativeWindow();

    int[] getViewSize();

    void resetSurface();

    void setDeviceId(String str);

    void setVideoRenderViewCallBack(OnVideoRenderViewCallBack onVideoRenderViewCallBack);
}
