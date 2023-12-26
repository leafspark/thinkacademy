package com.wushuangtech.myvideoimprove.screen;

import com.wushuangtech.library.video.bean.MediaCodecSurface;
import com.wushuangtech.myvideoimprove.bean.ScreenCaptureConfig;
import com.wushuangtech.myvideoimprove.codec.LocalVideoEncoder;
import com.wushuangtech.myvideoimprove.codec.encoder.HardwareEncoder;
import java.lang.ref.WeakReference;

class ScreenCodec implements HardwareEncoder.OnHardwareSurfaceLifeListener {
    private LocalVideoEncoder mLocalVideoEncoder;
    private final WeakReference<ScreenOpenGLRender> mScreenOpenGLRenderRef;

    public ScreenCodec(ScreenOpenGLRender screenOpenGLRender) {
        this.mScreenOpenGLRenderRef = new WeakReference<>(screenOpenGLRender);
    }

    public void init() {
        LocalVideoEncoder localVideoEncoder = new LocalVideoEncoder("Screen");
        this.mLocalVideoEncoder = localVideoEncoder;
        localVideoEncoder.init(LocalVideoEncoder.VideoEncoderType.MAIN);
        this.mLocalVideoEncoder.setOnHardwareSurfaceLifeListener(this);
    }

    public void setParams(ScreenCaptureConfig screenCaptureConfig) {
        this.mLocalVideoEncoder.setVideoEncoderParams(LocalVideoEncoder.VideoEncoderType.MAIN, screenCaptureConfig.mWidth, screenCaptureConfig.mHeight, screenCaptureConfig.mFrameRate, screenCaptureConfig.mBitRate, screenCaptureConfig.mIFrameInterval);
    }

    public void startEncode() {
        this.mLocalVideoEncoder.startEncoder(LocalVideoEncoder.VideoEncoderType.MAIN);
    }

    public void onSurfaceCreated(MediaCodecSurface mediaCodecSurface) {
        ScreenOpenGLRender screenOpenGLRender = (ScreenOpenGLRender) this.mScreenOpenGLRenderRef.get();
        if (screenOpenGLRender != null) {
            screenOpenGLRender.addEncodeSurfaceWindow(mediaCodecSurface.getSurface());
        }
    }

    public void onSurfaceReleased(MediaCodecSurface mediaCodecSurface) {
        ScreenOpenGLRender screenOpenGLRender = (ScreenOpenGLRender) this.mScreenOpenGLRenderRef.get();
        if (screenOpenGLRender != null) {
            screenOpenGLRender.removeEncodeSurfaceWindow(mediaCodecSurface.getSurface());
        }
    }
}
