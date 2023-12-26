package io.agora.rtc.mediaio;

import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.util.Log;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.TextureView;
import io.agora.rtc.gl.EglBase;
import io.agora.rtc.gl.EglRenderer;
import io.agora.rtc.gl.GlRectDrawer;
import io.agora.rtc.gl.JavaI420Buffer;
import io.agora.rtc.gl.RendererCommon;
import io.agora.rtc.gl.RgbaBuffer;
import io.agora.rtc.gl.TextureBufferImpl;
import io.agora.rtc.gl.VideoFrame;
import io.agora.rtc.gl.YuvConverter;
import io.agora.rtc.mediaio.MediaIO;
import io.agora.rtc.utils.ThreadUtils;
import java.nio.ByteBuffer;
import java.util.concurrent.CountDownLatch;

public class BaseVideoRenderer implements SurfaceHolder.Callback, TextureView.SurfaceTextureListener {
    private static final String ERROR_EGL = "Only one egl surface allowed";
    private static final String TAG = "BaseVideoRenderer";
    private final EglRenderer eglRenderer;
    private int mBufferType = -1;
    private boolean mHasEglSurface = false;
    private int mPixelFormat = -1;
    private boolean mStarted = false;
    private Surface mSurface;
    private SurfaceTexture mSurfaceTexture;
    private TextureView.SurfaceTextureListener mSurfaceTextureListener;
    private SurfaceView mSurfaceView;
    private SurfaceHolder.Callback mSurfaceViewListener;
    private TextureView mTextureView;

    /* access modifiers changed from: private */
    public void releaseBuffer(ByteBuffer byteBuffer) {
    }

    public BaseVideoRenderer(String str) {
        this.eglRenderer = new EglRenderer(str);
    }

    public EglRenderer getEglRender() {
        return this.eglRenderer;
    }

    public long getEGLContextHandle() {
        return this.eglRenderer.getEglContext().getNativeEglContext();
    }

    public void init(EglBase.Context context) {
        init(context, EglBase.CONFIG_PLAIN, new GlRectDrawer());
    }

    public void init(EglBase.Context context, int[] iArr, RendererCommon.GlDrawer glDrawer) {
        this.eglRenderer.init(context, iArr, glDrawer);
    }

    public void setRenderView(SurfaceView surfaceView, SurfaceHolder.Callback callback) {
        ThreadUtils.checkIsOnMainThread();
        if (!this.mHasEglSurface) {
            this.mSurfaceView = surfaceView;
            this.mSurfaceViewListener = callback;
            surfaceView.getHolder().addCallback(this);
            return;
        }
        throw new IllegalStateException(ERROR_EGL);
    }

    public void setRenderView(TextureView textureView, TextureView.SurfaceTextureListener surfaceTextureListener) {
        ThreadUtils.checkIsOnMainThread();
        if (!this.mHasEglSurface) {
            this.mTextureView = textureView;
            this.mSurfaceTextureListener = surfaceTextureListener;
            textureView.setSurfaceTextureListener(this);
            return;
        }
        throw new IllegalStateException(ERROR_EGL);
    }

    public void setRenderSurface(Surface surface) {
        ThreadUtils.checkIsOnMainThread();
        if (!this.mHasEglSurface) {
            this.mSurface = surface;
            this.eglRenderer.createEglSurface(surface);
            this.mHasEglSurface = true;
            return;
        }
        throw new IllegalStateException(ERROR_EGL);
    }

    public void setRenderSurface(SurfaceTexture surfaceTexture) {
        ThreadUtils.checkIsOnMainThread();
        if (!this.mHasEglSurface) {
            this.mSurfaceTexture = surfaceTexture;
            this.eglRenderer.createEglSurface(surfaceTexture);
            this.mHasEglSurface = true;
            return;
        }
        throw new IllegalStateException(ERROR_EGL);
    }

    public void setBufferType(MediaIO.BufferType bufferType) {
        this.mBufferType = bufferType.intValue();
    }

    public void setPixelFormat(MediaIO.PixelFormat pixelFormat) {
        this.mPixelFormat = pixelFormat.intValue();
    }

    public void release() {
        this.eglRenderer.release();
    }

    public boolean start() {
        this.mStarted = true;
        return true;
    }

    public void stop() {
        this.mStarted = false;
    }

    public void consume(int i, int i2, int i3, int i4, int i5, long j, float[] fArr) {
        VideoFrame.TextureBuffer.Type type;
        int i6 = i2;
        if (this.mStarted) {
            if (i6 == 11) {
                type = VideoFrame.TextureBuffer.Type.OES;
            } else if (i6 == 10) {
                type = VideoFrame.TextureBuffer.Type.RGB;
            } else {
                return;
            }
            rendTextureFrame(i, type, i3, i4, i5, j, fArr);
        }
    }

    public void consume(ByteBuffer byteBuffer, int i, int i2, int i3, int i4, long j) {
        if (this.mStarted) {
            if (i == 1) {
                rendI420Frame(byteBuffer, i, i2, i3, i4, j);
            } else if (i == 4) {
                rendRGBAFrame(byteBuffer, i, i2, i3, i4, j);
            }
        }
    }

    public void consume(byte[] bArr, int i, int i2, int i3, int i4, long j) {
        if (this.mStarted) {
            if (i == 1) {
                rendI420Frame(bArr, i, i2, i3, i4, j);
            } else if (i == 4) {
                rendRGBAFrame(bArr, i, i2, i3, i4, j);
            }
        }
    }

    public int getBufferType() {
        int i = this.mBufferType;
        if (i != -1) {
            return i;
        }
        throw new IllegalArgumentException("Buffer type is not set");
    }

    public int getPixelFormat() {
        int i = this.mPixelFormat;
        if (i != -1) {
            return i;
        }
        throw new IllegalArgumentException("Pixel format is not set");
    }

    private void rendTextureFrame(int i, VideoFrame.TextureBuffer.Type type, int i2, int i3, int i4, long j, float[] fArr) {
        int i5 = i2;
        int i6 = i3;
        VideoFrame.TextureBuffer.Type type2 = type;
        int i7 = i;
        VideoFrame videoFrame = new VideoFrame(new TextureBufferImpl(this.eglRenderer.getEglContext(), i5, i6, type2, i7, RendererCommon.convertMatrixToAndroidGraphicsMatrix(fArr), (Handler) null, (YuvConverter) null, new Runnable() {
            public void run() {
            }
        }), i4, j);
        this.eglRenderer.renderFrame(videoFrame);
        videoFrame.release();
    }

    private void rendI420Frame(ByteBuffer byteBuffer, int i, int i2, int i3, int i4, long j) {
        if (byteBuffer != null) {
            int remaining = byteBuffer.remaining();
            byte[] bArr = new byte[remaining];
            byteBuffer.get(bArr, 0, remaining);
            JavaI420Buffer createYUV = JavaI420Buffer.createYUV(bArr, i2, i3);
            if (createYUV != null) {
                VideoFrame videoFrame = new VideoFrame(createYUV, i4, j);
                this.eglRenderer.renderFrame(videoFrame);
                videoFrame.release();
            }
        }
    }

    private void rendI420Frame(byte[] bArr, int i, int i2, int i3, int i4, long j) {
        JavaI420Buffer createYUV;
        if (bArr != null && bArr.length != 0 && (createYUV = JavaI420Buffer.createYUV(bArr, i2, i3)) != null) {
            VideoFrame videoFrame = new VideoFrame(createYUV, i4, j);
            this.eglRenderer.renderFrame(videoFrame);
            videoFrame.release();
        }
    }

    private void rendRGBAFrame(final ByteBuffer byteBuffer, int i, int i2, int i3, int i4, long j) {
        if (byteBuffer != null) {
            VideoFrame videoFrame = new VideoFrame(new RgbaBuffer(byteBuffer, i2, i3, new Runnable() {
                public void run() {
                    BaseVideoRenderer.this.releaseBuffer(byteBuffer);
                }
            }), i4, j);
            this.eglRenderer.renderFrame(videoFrame);
            videoFrame.release();
        }
    }

    private void rendRGBAFrame(byte[] bArr, int i, int i2, int i3, int i4, long j) {
        if (bArr != null && bArr.length != 0) {
            final ByteBuffer wrap = ByteBuffer.wrap(bArr);
            VideoFrame videoFrame = new VideoFrame(new RgbaBuffer(wrap, i2, i3, new Runnable() {
                public void run() {
                    BaseVideoRenderer.this.releaseBuffer(wrap);
                }
            }), i4, j);
            this.eglRenderer.renderFrame(videoFrame);
            videoFrame.release();
        }
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        ThreadUtils.checkIsOnMainThread();
        this.eglRenderer.createEglSurface(surfaceHolder.getSurface());
        this.mHasEglSurface = true;
        SurfaceHolder.Callback callback = this.mSurfaceViewListener;
        if (callback != null) {
            callback.surfaceCreated(surfaceHolder);
        }
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i2, int i3) {
        ThreadUtils.checkIsOnMainThread();
        String str = TAG;
        Log.e(str, "surfaceChanged: format: " + i + " size: " + i2 + "x" + i3);
        SurfaceHolder.Callback callback = this.mSurfaceViewListener;
        if (callback != null) {
            callback.surfaceChanged(surfaceHolder, i, i2, i3);
        }
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        ThreadUtils.checkIsOnMainThread();
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        this.eglRenderer.releaseEglSurface(new Runnable() {
            public void run() {
                countDownLatch.countDown();
            }
        });
        ThreadUtils.awaitUninterruptibly(countDownLatch);
        SurfaceHolder.Callback callback = this.mSurfaceViewListener;
        if (callback != null) {
            callback.surfaceDestroyed(surfaceHolder);
        }
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i, int i2) {
        ThreadUtils.checkIsOnMainThread();
        this.eglRenderer.createEglSurface(surfaceTexture);
        this.mHasEglSurface = true;
        TextureView.SurfaceTextureListener surfaceTextureListener = this.mSurfaceTextureListener;
        if (surfaceTextureListener != null) {
            surfaceTextureListener.onSurfaceTextureAvailable(surfaceTexture, i, i2);
        }
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i, int i2) {
        String str = TAG;
        Log.e(str, "onSurfaceTextureSizeChanged: width- " + i + ", height: " + i2);
        TextureView.SurfaceTextureListener surfaceTextureListener = this.mSurfaceTextureListener;
        if (surfaceTextureListener != null) {
            surfaceTextureListener.onSurfaceTextureSizeChanged(surfaceTexture, i, i2);
        }
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        ThreadUtils.checkIsOnMainThread();
        final CountDownLatch countDownLatch = new CountDownLatch(1);
        this.eglRenderer.releaseEglSurface(new Runnable() {
            public void run() {
                countDownLatch.countDown();
            }
        });
        ThreadUtils.awaitUninterruptibly(countDownLatch);
        TextureView.SurfaceTextureListener surfaceTextureListener = this.mSurfaceTextureListener;
        if (surfaceTextureListener != null) {
            surfaceTextureListener.onSurfaceTextureDestroyed(surfaceTexture);
        }
        return true;
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
        TextureView.SurfaceTextureListener surfaceTextureListener = this.mSurfaceTextureListener;
        if (surfaceTextureListener != null) {
            surfaceTextureListener.onSurfaceTextureUpdated(surfaceTexture);
        }
    }
}
