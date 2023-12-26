package io.agora.rtc.mediaio;

import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;
import com.bonree.sdk.agent.engine.external.AsynchronousInstrumentation;
import io.agora.rtc.gl.EglBase;
import io.agora.rtc.gl.GlUtil;
import io.agora.rtc.gl.TextureBufferImpl;
import io.agora.rtc.gl.TextureTransformer;
import io.agora.rtc.gl.VideoFrame;
import io.agora.rtc.gl.YuvConverter;
import io.agora.rtc.mediaio.MediaIO;
import io.agora.rtc.utils.ThreadUtils;
import java.util.concurrent.Callable;

public class SurfaceTextureHelper {
    private static final int MAX_TEXTURE_COPY = 2;
    private static final String TAG = "SurfaceTextureHelper";
    private final EglBase eglBase;
    private final Handler handler;
    /* access modifiers changed from: private */
    public boolean hasPendingTexture;
    /* access modifiers changed from: private */
    public boolean isQuitting;
    /* access modifiers changed from: private */
    public volatile boolean isTextureInUse;
    /* access modifiers changed from: private */
    public OnTextureFrameAvailableListener listener;
    private boolean mCopyTo2DTexture;
    private int mHeight;
    private int mWidth;
    private final int oesTextureId;
    /* access modifiers changed from: private */
    public OnTextureFrameAvailableListener pendingListener;
    final Runnable setListenerRunnable;
    private final SurfaceTexture surfaceTexture;
    private TextureTransformer textureTransformer;
    /* access modifiers changed from: private */
    public YuvConverter yuvConverter;

    public interface OnTextureFrameAvailableListener {
        void onTextureFrameAvailable(int i, MediaIO.PixelFormat pixelFormat, float[] fArr, long j);

        void onTextureFrameAvailable(int i, float[] fArr, long j);
    }

    public static SurfaceTextureHelper create(final String str, final EglBase.Context context) {
        HandlerThread handlerThread = new HandlerThread(str);
        handlerThread.start();
        final Handler handler2 = new Handler(handlerThread.getLooper());
        return (SurfaceTextureHelper) ThreadUtils.invokeAtFrontUninterruptibly(handler2, new Callable<SurfaceTextureHelper>() {
            public SurfaceTextureHelper call() {
                try {
                    return new SurfaceTextureHelper(context, handler2);
                } catch (RuntimeException e) {
                    Log.e(SurfaceTextureHelper.TAG, str + " create failure", e);
                    return null;
                }
            }
        });
    }

    public static SurfaceTextureHelper create(String str, EglBase.Context context, boolean z, int i, int i2) {
        HandlerThread handlerThread = new HandlerThread(str);
        handlerThread.start();
        Handler handler2 = new Handler(handlerThread.getLooper());
        final EglBase.Context context2 = context;
        final Handler handler3 = handler2;
        final boolean z2 = z;
        final int i3 = i;
        final int i4 = i2;
        final String str2 = str;
        return (SurfaceTextureHelper) ThreadUtils.invokeAtFrontUninterruptibly(handler2, new Callable<SurfaceTextureHelper>() {
            public SurfaceTextureHelper call() {
                try {
                    return new SurfaceTextureHelper(context2, handler3, z2, i3, i4);
                } catch (RuntimeException e) {
                    Log.e(SurfaceTextureHelper.TAG, str2 + " create failure", e);
                    return null;
                }
            }
        });
    }

    private SurfaceTextureHelper(EglBase.Context context, Handler handler2) {
        this.mCopyTo2DTexture = false;
        this.textureTransformer = null;
        this.hasPendingTexture = false;
        this.isTextureInUse = false;
        this.isQuitting = false;
        this.setListenerRunnable = new Runnable() {
            public void run() {
                Log.d(SurfaceTextureHelper.TAG, "Setting listener to " + SurfaceTextureHelper.this.pendingListener);
                SurfaceTextureHelper surfaceTextureHelper = SurfaceTextureHelper.this;
                OnTextureFrameAvailableListener unused = surfaceTextureHelper.listener = surfaceTextureHelper.pendingListener;
                OnTextureFrameAvailableListener unused2 = SurfaceTextureHelper.this.pendingListener = null;
                if (SurfaceTextureHelper.this.hasPendingTexture) {
                    SurfaceTextureHelper.this.updateTexImage();
                    boolean unused3 = SurfaceTextureHelper.this.hasPendingTexture = false;
                }
            }
        };
        if (handler2.getLooper().getThread() == Thread.currentThread()) {
            this.handler = handler2;
            EglBase create = EglBase.create(context, EglBase.CONFIG_PIXEL_BUFFER);
            this.eglBase = create;
            try {
                create.createDummyPbufferSurface();
                create.makeCurrent();
                int generateTexture = GlUtil.generateTexture(36197);
                this.oesTextureId = generateTexture;
                SurfaceTexture surfaceTexture2 = new SurfaceTexture(generateTexture);
                this.surfaceTexture = surfaceTexture2;
                setOnFrameAvailableListener(surfaceTexture2, new SurfaceTexture.OnFrameAvailableListener() {
                    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
                        boolean unused = SurfaceTextureHelper.this.hasPendingTexture = true;
                        SurfaceTextureHelper.this.tryDeliverTextureFrame();
                    }
                }, handler2);
            } catch (RuntimeException e) {
                Log.e(TAG, "SurfaceTextureHelper: failed to create pbufferSurface!!");
                this.eglBase.release();
                handler2.getLooper().quit();
                throw e;
            }
        } else {
            throw new IllegalStateException("SurfaceTextureHelper must be created on the handler thread");
        }
    }

    private SurfaceTextureHelper(EglBase.Context context, Handler handler2, boolean z, int i, int i2) {
        this.mCopyTo2DTexture = false;
        this.textureTransformer = null;
        this.hasPendingTexture = false;
        this.isTextureInUse = false;
        this.isQuitting = false;
        this.setListenerRunnable = new Runnable() {
            public void run() {
                Log.d(SurfaceTextureHelper.TAG, "Setting listener to " + SurfaceTextureHelper.this.pendingListener);
                SurfaceTextureHelper surfaceTextureHelper = SurfaceTextureHelper.this;
                OnTextureFrameAvailableListener unused = surfaceTextureHelper.listener = surfaceTextureHelper.pendingListener;
                OnTextureFrameAvailableListener unused2 = SurfaceTextureHelper.this.pendingListener = null;
                if (SurfaceTextureHelper.this.hasPendingTexture) {
                    SurfaceTextureHelper.this.updateTexImage();
                    boolean unused3 = SurfaceTextureHelper.this.hasPendingTexture = false;
                }
            }
        };
        if (handler2.getLooper().getThread() == Thread.currentThread()) {
            this.handler = handler2;
            EglBase create = EglBase.create(context, EglBase.CONFIG_PIXEL_BUFFER);
            this.eglBase = create;
            try {
                create.createDummyPbufferSurface();
                create.makeCurrent();
                this.mCopyTo2DTexture = z;
                if (z) {
                    this.mWidth = i;
                    this.mHeight = i2;
                    this.textureTransformer = new TextureTransformer(2);
                }
                int generateTexture = GlUtil.generateTexture(36197);
                this.oesTextureId = generateTexture;
                SurfaceTexture surfaceTexture2 = new SurfaceTexture(generateTexture);
                this.surfaceTexture = surfaceTexture2;
                setOnFrameAvailableListener(surfaceTexture2, new SurfaceTexture.OnFrameAvailableListener() {
                    public void onFrameAvailable(SurfaceTexture surfaceTexture) {
                        boolean unused = SurfaceTextureHelper.this.hasPendingTexture = true;
                        SurfaceTextureHelper.this.tryDeliverTextureFrame();
                    }
                }, handler2);
            } catch (RuntimeException e) {
                Log.e(TAG, "SurfaceTextureHelper: failed to create pbufferSurface!!");
                this.eglBase.release();
                handler2.getLooper().quit();
                throw e;
            }
        } else {
            throw new IllegalStateException("SurfaceTextureHelper must be created on the handler thread");
        }
    }

    private static void setOnFrameAvailableListener(SurfaceTexture surfaceTexture2, SurfaceTexture.OnFrameAvailableListener onFrameAvailableListener, Handler handler2) {
        if (Build.VERSION.SDK_INT >= 21) {
            surfaceTexture2.setOnFrameAvailableListener(onFrameAvailableListener, handler2);
        } else {
            surfaceTexture2.setOnFrameAvailableListener(onFrameAvailableListener);
        }
    }

    public EglBase.Context getEglContext() {
        return this.eglBase.getEglBaseContext();
    }

    public void startListening(OnTextureFrameAvailableListener onTextureFrameAvailableListener) {
        if (this.listener == null && this.pendingListener == null) {
            this.pendingListener = onTextureFrameAvailableListener;
            Handler handler2 = this.handler;
            Runnable runnable = this.setListenerRunnable;
            if (!(handler2 instanceof Handler)) {
                handler2.post(runnable);
            } else {
                AsynchronousInstrumentation.handlerPost(handler2, runnable);
            }
        } else {
            throw new IllegalStateException("SurfaceTextureHelper listener has already been set.");
        }
    }

    public void stopListening() {
        Log.d(TAG, "stopListening()");
        this.handler.removeCallbacks(this.setListenerRunnable);
        ThreadUtils.invokeAtFrontUninterruptibly(this.handler, (Runnable) new Runnable() {
            public void run() {
                OnTextureFrameAvailableListener unused = SurfaceTextureHelper.this.listener = null;
                OnTextureFrameAvailableListener unused2 = SurfaceTextureHelper.this.pendingListener = null;
            }
        });
    }

    public SurfaceTexture getSurfaceTexture() {
        return this.surfaceTexture;
    }

    public Handler getHandler() {
        return this.handler;
    }

    public void returnTextureFrame() {
        Handler handler2 = this.handler;
        AnonymousClass7 r1 = new Runnable() {
            public void run() {
                boolean unused = SurfaceTextureHelper.this.isTextureInUse = false;
                if (SurfaceTextureHelper.this.isQuitting) {
                    SurfaceTextureHelper.this.release();
                } else {
                    SurfaceTextureHelper.this.tryDeliverTextureFrame();
                }
            }
        };
        if (!(handler2 instanceof Handler)) {
            handler2.post(r1);
        } else {
            AsynchronousInstrumentation.handlerPost(handler2, r1);
        }
    }

    public boolean isTextureInUse() {
        return this.isTextureInUse;
    }

    public void dispose() {
        Log.d(TAG, "dispose()");
        ThreadUtils.invokeAtFrontUninterruptibly(this.handler, (Runnable) new Runnable() {
            public void run() {
                boolean unused = SurfaceTextureHelper.this.isQuitting = true;
                if (!SurfaceTextureHelper.this.isTextureInUse) {
                    SurfaceTextureHelper.this.release();
                }
            }
        });
    }

    public VideoFrame.I420Buffer textureToYuv(final VideoFrame.TextureBuffer textureBuffer) {
        if (textureBuffer.getTextureId() == this.oesTextureId) {
            final VideoFrame.I420Buffer[] i420BufferArr = new VideoFrame.I420Buffer[1];
            ThreadUtils.invokeAtFrontUninterruptibly(this.handler, (Runnable) new Runnable() {
                public void run() {
                    if (SurfaceTextureHelper.this.yuvConverter == null) {
                        YuvConverter unused = SurfaceTextureHelper.this.yuvConverter = new YuvConverter();
                    }
                    i420BufferArr[0] = SurfaceTextureHelper.this.yuvConverter.convert(textureBuffer);
                }
            });
            return i420BufferArr[0];
        }
        throw new IllegalStateException("textureToByteBuffer called with unexpected textureId");
    }

    /* access modifiers changed from: private */
    public void updateTexImage() {
        try {
            synchronized (EglBase.lock) {
                this.surfaceTexture.updateTexImage();
            }
        } catch (IllegalStateException unused) {
            Log.e(TAG, "SurfaceTextureHelper: failed to updateTexImage!!");
        }
    }

    /* access modifiers changed from: private */
    public void tryDeliverTextureFrame() {
        TextureTransformer textureTransformer2;
        if (this.handler.getLooper().getThread() != Thread.currentThread()) {
            throw new IllegalStateException("Wrong thread.");
        } else if (!this.isQuitting && this.hasPendingTexture && !this.isTextureInUse && this.listener != null) {
            this.isTextureInUse = true;
            this.hasPendingTexture = false;
            updateTexImage();
            float[] fArr = new float[16];
            this.surfaceTexture.getTransformMatrix(fArr);
            long timestamp = this.surfaceTexture.getTimestamp();
            if (!this.mCopyTo2DTexture || (textureTransformer2 = this.textureTransformer) == null) {
                this.listener.onTextureFrameAvailable(this.oesTextureId, fArr, timestamp);
                return;
            }
            this.listener.onTextureFrameAvailable(textureTransformer2.copy(this.oesTextureId, MediaIO.PixelFormat.TEXTURE_OES.intValue(), this.mWidth, this.mHeight), MediaIO.PixelFormat.TEXTURE_2D, fArr, timestamp);
        }
    }

    /* access modifiers changed from: private */
    public void release() {
        if (this.handler.getLooper().getThread() != Thread.currentThread()) {
            throw new IllegalStateException("Wrong thread.");
        } else if (this.isTextureInUse || !this.isQuitting) {
            throw new IllegalStateException("Unexpected release.");
        } else {
            YuvConverter yuvConverter2 = this.yuvConverter;
            if (yuvConverter2 != null) {
                yuvConverter2.release();
            }
            TextureTransformer textureTransformer2 = this.textureTransformer;
            if (textureTransformer2 != null) {
                textureTransformer2.release();
            }
            GLES20.glDeleteTextures(1, new int[]{this.oesTextureId}, 0);
            this.surfaceTexture.release();
            this.eglBase.release();
            this.handler.getLooper().quit();
        }
    }

    public VideoFrame.TextureBuffer createTextureBuffer(int i, int i2, Matrix matrix) {
        return new TextureBufferImpl(getEglContext(), i, i2, VideoFrame.TextureBuffer.Type.OES, this.oesTextureId, matrix, this.handler, this.yuvConverter, new Runnable() {
            public void run() {
                SurfaceTextureHelper.this.returnTextureFrame();
            }
        });
    }
}
