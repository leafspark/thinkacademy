package com.wushuangtech.myvideoimprove.view;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.TextureView;
import com.wushuangtech.myvideoimprove.bean.VideoRenderViewLifeBean;
import com.wushuangtech.myvideoimprove.view.VideoRenderView;
import com.wushuangtech.utils.OmniLog;

public class OmniTextureView extends TextureView implements TextureView.SurfaceTextureListener, VideoRenderView {
    private static final String TAG = "TextureView";
    private String mDeviceId;
    private VideoRenderView.OnVideoRenderViewCallBack videoRenderViewCallBack;

    public Object getNativeWindow() {
        return null;
    }

    public int[] getViewSize() {
        return new int[0];
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    public void resetSurface() {
    }

    public OmniTextureView(Context context) {
        this(context, (AttributeSet) null);
    }

    public OmniTextureView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setSurfaceTextureListener(this);
        setOpaque(false);
        OmniLog.d(TAG, "TextureView is created!");
    }

    public void setDeviceId(String str) {
        this.mDeviceId = str;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        OmniLog.d(TAG, "TextureView onDetachedFromWindow!");
        super.onDetachedFromWindow();
        VideoRenderView.OnVideoRenderViewCallBack onVideoRenderViewCallBack = this.videoRenderViewCallBack;
        if (onVideoRenderViewCallBack != null) {
            onVideoRenderViewCallBack.onViewRenderDetachedFromWindow(this);
        }
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        OmniLog.d(TAG, "TextureView onAttachedToWindow!");
        super.onAttachedToWindow();
        VideoRenderView.OnVideoRenderViewCallBack onVideoRenderViewCallBack = this.videoRenderViewCallBack;
        if (onVideoRenderViewCallBack != null) {
            onVideoRenderViewCallBack.onViewRenderAttachedToWindow(this);
        }
    }

    public void setVideoRenderViewCallBack(VideoRenderView.OnVideoRenderViewCallBack onVideoRenderViewCallBack) {
        this.videoRenderViewCallBack = onVideoRenderViewCallBack;
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        OmniLog.d(TAG, "TextureView onSurfaceTextureAvailable... " + surfaceTexture + " | " + i + " | " + i2);
        if (this.videoRenderViewCallBack != null) {
            VideoRenderViewLifeBean videoRenderViewLifeBean = new VideoRenderViewLifeBean();
            videoRenderViewLifeBean.mRenderView = this;
            videoRenderViewLifeBean.mSurface = surfaceTexture;
            videoRenderViewLifeBean.mWidth = i;
            videoRenderViewLifeBean.mHeight = i2;
            videoRenderViewLifeBean.mDeviceId = this.mDeviceId;
            this.videoRenderViewCallBack.onVideoRenderSurfaceAvailable(videoRenderViewLifeBean);
        }
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        OmniLog.d(TAG, "TextureView onSurfaceTextureSizeChanged... " + surfaceTexture + " | " + i + " | " + i2);
        if (this.videoRenderViewCallBack != null) {
            VideoRenderViewLifeBean videoRenderViewLifeBean = new VideoRenderViewLifeBean();
            videoRenderViewLifeBean.mWidth = i;
            videoRenderViewLifeBean.mHeight = i2;
            videoRenderViewLifeBean.mDeviceId = this.mDeviceId;
            this.videoRenderViewCallBack.onVideoRenderSurfaceSizeChanged(videoRenderViewLifeBean);
        }
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        OmniLog.d(TAG, "TextureView onSurfaceTextureDestroyed... " + surfaceTexture);
        if (this.videoRenderViewCallBack == null) {
            return true;
        }
        VideoRenderViewLifeBean videoRenderViewLifeBean = new VideoRenderViewLifeBean();
        videoRenderViewLifeBean.mRenderView = this;
        videoRenderViewLifeBean.mSurface = surfaceTexture;
        videoRenderViewLifeBean.mDeviceId = this.mDeviceId;
        this.videoRenderViewCallBack.onVideoRenderSurfaceDestroyed(videoRenderViewLifeBean);
        return true;
    }
}
