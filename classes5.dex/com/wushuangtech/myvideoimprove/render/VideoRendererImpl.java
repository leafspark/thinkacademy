package com.wushuangtech.myvideoimprove.render;

import com.wushuangtech.bean.CommonEventBean;
import com.wushuangtech.library.video.egl.OnEGLEventCallBack;
import com.wushuangtech.myvideoimprove.VideoRenderer;
import com.wushuangtech.myvideoimprove.view.VideoRenderView;
import java.lang.ref.WeakReference;

public abstract class VideoRendererImpl implements VideoRenderer {
    protected WeakReference<VideoRenderView> mVideoRenderViewRef;
    protected final Object mViewLock = new Object();
    protected VideoRenderer.OnVideoRendererAddSurfaceCallBack onVideoRendererAddSurfaceCallBack;

    /* access modifiers changed from: protected */
    public abstract void handleEGLRenderError(int i);

    /* access modifiers changed from: protected */
    public abstract void handleEGLRenderEvent(CommonEventBean commonEventBean);

    VideoRendererImpl(VideoRenderer.OnVideoRendererAddSurfaceCallBack onVideoRendererAddSurfaceCallBack2) {
        this.onVideoRendererAddSurfaceCallBack = onVideoRendererAddSurfaceCallBack2;
    }

    public void setVideoRenderView(VideoRenderView videoRenderView) {
        if (videoRenderView != null) {
            synchronized (this.mViewLock) {
                WeakReference<VideoRenderView> weakReference = this.mVideoRenderViewRef;
                if (weakReference != null) {
                    weakReference.clear();
                }
                this.mVideoRenderViewRef = new WeakReference<>(videoRenderView);
            }
        }
    }

    public static class LocalEGLEventCallBackImpl implements OnEGLEventCallBack {
        private final WeakReference<VideoRendererImpl> mOutReference;

        public LocalEGLEventCallBackImpl(VideoRendererImpl videoRendererImpl) {
            this.mOutReference = new WeakReference<>(videoRendererImpl);
        }

        public void onEGLRendererEvent(CommonEventBean commonEventBean) {
            VideoRendererImpl videoRendererImpl = (VideoRendererImpl) this.mOutReference.get();
            if (videoRendererImpl != null) {
                videoRendererImpl.handleEGLRenderEvent(commonEventBean);
            }
        }

        public void onEGLRendererError(int i) {
            VideoRendererImpl videoRendererImpl = (VideoRendererImpl) this.mOutReference.get();
            if (videoRendererImpl != null) {
                videoRendererImpl.handleEGLRenderError(i);
            }
        }
    }
}
