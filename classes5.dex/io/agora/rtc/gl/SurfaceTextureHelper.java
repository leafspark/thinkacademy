package io.agora.rtc.gl;

import android.graphics.Matrix;
import android.graphics.SurfaceTexture;
import android.opengl.GLES20;
import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import com.bonree.sdk.agent.engine.external.AsynchronousInstrumentation;
import io.agora.rtc.gl.EglBase;
import io.agora.rtc.gl.VideoFrame;
import io.agora.rtc.internal.Logging;
import io.agora.rtc.utils.ThreadUtils;
import java.util.concurrent.Callable;

public class SurfaceTextureHelper {
    private static final String TAG = "SurfaceTextureHelper";
    private static final boolean VERBOSE = false;
    private final EglBase eglBase;
    /* access modifiers changed from: private */
    public final Handler handler;
    /* access modifiers changed from: private */
    public boolean hasPendingTexture;
    /* access modifiers changed from: private */
    public boolean isOesTextureInUse;
    /* access modifiers changed from: private */
    public boolean isQuitting;
    /* access modifiers changed from: private */
    public OnTextureFrameAvailableListener listener;
    /* access modifiers changed from: private */
    public final String name;
    private final int oesTextureId;
    /* access modifiers changed from: private */
    public OnTextureFrameAvailableListener pendingListener;
    final Runnable setListenerRunnable;
    private final SurfaceTexture surfaceTexture;
    /* access modifiers changed from: private */
    public final TextureBufferPool textureBufferPool;
    /* access modifiers changed from: private */
    public int textureCopyInUse;
    /* access modifiers changed from: private */
    public final YuvConverter yuvConverter;

    public interface OnTextureFrameAvailableListener {
        void onTextureFrameAvailable(int i, float[] fArr, long j);
    }

    static /* synthetic */ int access$808(SurfaceTextureHelper surfaceTextureHelper) {
        int i = surfaceTextureHelper.textureCopyInUse;
        surfaceTextureHelper.textureCopyInUse = i + 1;
        return i;
    }

    static /* synthetic */ int access$810(SurfaceTextureHelper surfaceTextureHelper) {
        int i = surfaceTextureHelper.textureCopyInUse;
        surfaceTextureHelper.textureCopyInUse = i - 1;
        return i;
    }

    public static SurfaceTextureHelper create(final String str, final EglBase.Context context, final int i) {
        HandlerThread handlerThread = new HandlerThread(str);
        handlerThread.start();
        final Handler handler2 = new Handler(handlerThread.getLooper());
        return (SurfaceTextureHelper) ThreadUtils.invokeAtFrontUninterruptibly(handler2, new Callable<SurfaceTextureHelper>() {
            public SurfaceTextureHelper call() {
                try {
                    return new SurfaceTextureHelper(str, context, handler2, i);
                } catch (RuntimeException e) {
                    Logging.e(SurfaceTextureHelper.TAG, str + " create failure", e);
                    return null;
                }
            }
        });
    }

    private SurfaceTextureHelper(final String str, EglBase.Context context, Handler handler2, int i) {
        this.hasPendingTexture = false;
        this.isOesTextureInUse = false;
        this.textureCopyInUse = 0;
        this.isQuitting = false;
        this.setListenerRunnable = new Runnable() {
            public void run() {
                Logging.i(SurfaceTextureHelper.TAG, "Setting listener to " + SurfaceTextureHelper.this.pendingListener);
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
            Logging.i(TAG, str + " create, this: " + this);
            this.name = str;
            this.handler = handler2;
            EglBase create = EglBase.create(context, EglBase.CONFIG_PIXEL_BUFFER);
            this.eglBase = create;
            try {
                create.createDummyPbufferSurface();
                create.makeCurrent();
                YuvConverter yuvConverter2 = new YuvConverter();
                this.yuvConverter = yuvConverter2;
                this.textureBufferPool = TextureBufferPool.createWithinGlThread(str, handler2, i, create, yuvConverter2, false);
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
                Logging.e(TAG, "SurfaceTextureHelper: failed to create pbufferSurface!!");
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
        Logging.i(TAG, this.name + " stopListening()");
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
        AnonymousClass5 r1 = new Runnable() {
            public void run() {
                boolean unused = SurfaceTextureHelper.this.isOesTextureInUse = false;
                if (!SurfaceTextureHelper.this.isQuitting) {
                    SurfaceTextureHelper.this.tryDeliverTextureFrame();
                } else if (SurfaceTextureHelper.this.textureCopyInUse == 0) {
                    SurfaceTextureHelper.this.release();
                }
            }
        };
        if (!(handler2 instanceof Handler)) {
            handler2.post(r1);
        } else {
            AsynchronousInstrumentation.handlerPost(handler2, r1);
        }
    }

    public void dispose() {
        Logging.i(TAG, this.name + " dispose(), this: " + this);
        ThreadUtils.invokeAtFrontUninterruptibly(this.handler, (Runnable) new Runnable() {
            public void run() {
                boolean unused = SurfaceTextureHelper.this.isQuitting = true;
                if (SurfaceTextureHelper.this.isOesTextureInUse || SurfaceTextureHelper.this.textureCopyInUse != 0) {
                    Logging.i(SurfaceTextureHelper.TAG, SurfaceTextureHelper.this.name + " not release yet, this: " + SurfaceTextureHelper.this + " isOesTextureInUse: " + SurfaceTextureHelper.this.isOesTextureInUse + " textureCopyInUse: " + SurfaceTextureHelper.this.textureCopyInUse);
                    return;
                }
                SurfaceTextureHelper.this.release();
            }
        });
    }

    public VideoFrame.I420Buffer textureToYuv(final VideoFrame.TextureBuffer textureBuffer) {
        if (textureBuffer.getTextureId() == this.oesTextureId) {
            final VideoFrame.I420Buffer[] i420BufferArr = new VideoFrame.I420Buffer[1];
            ThreadUtils.invokeAtFrontUninterruptibly(this.handler, (Runnable) new Runnable() {
                public void run() {
                    i420BufferArr[0] = SurfaceTextureHelper.this.yuvConverter.convert(textureBuffer);
                }
            });
            return i420BufferArr[0];
        }
        throw new IllegalStateException("textureToYuv called with unexpected textureId");
    }

    public VideoFrame.TextureBuffer textureCopy(final VideoFrame.TextureBuffer textureBuffer) {
        if (textureBuffer.getTextureId() == this.oesTextureId) {
            return (VideoFrame.TextureBuffer) ThreadUtils.invokeAtFrontUninterruptibly(this.handler, new Callable<VideoFrame.TextureBuffer>() {
                public VideoFrame.TextureBuffer call() {
                    VideoFrame.TextureBuffer textureCopy = SurfaceTextureHelper.this.textureBufferPool.textureCopy(textureBuffer, new Runnable() {
                        public void run() {
                            Handler access$1200 = SurfaceTextureHelper.this.handler;
                            AnonymousClass1 r1 = new Runnable() {
                                public void run() {
                                    SurfaceTextureHelper.access$810(SurfaceTextureHelper.this);
                                    if (SurfaceTextureHelper.this.isQuitting && !SurfaceTextureHelper.this.isOesTextureInUse && SurfaceTextureHelper.this.textureCopyInUse == 0) {
                                        SurfaceTextureHelper.this.release();
                                    }
                                }
                            };
                            if (!(access$1200 instanceof Handler)) {
                                access$1200.post(r1);
                            } else {
                                AsynchronousInstrumentation.handlerPost(access$1200, r1);
                            }
                        }
                    });
                    if (textureCopy != null) {
                        SurfaceTextureHelper.access$808(SurfaceTextureHelper.this);
                    }
                    return textureCopy;
                }
            });
        }
        throw new IllegalStateException("textureCopy called with unexpected textureId");
    }

    /* access modifiers changed from: private */
    public void updateTexImage() {
        try {
            synchronized (EglBase.lock) {
                this.surfaceTexture.updateTexImage();
            }
        } catch (IllegalStateException unused) {
            Logging.e(TAG, "SurfaceTextureHelper: failed to updateTexImage!!");
        }
    }

    /* access modifiers changed from: private */
    public void tryDeliverTextureFrame() {
        if (this.handler.getLooper().getThread() != Thread.currentThread()) {
            throw new IllegalStateException("Wrong thread.");
        } else if (!this.isQuitting && this.hasPendingTexture && !this.isOesTextureInUse && this.listener != null) {
            this.isOesTextureInUse = true;
            this.hasPendingTexture = false;
            updateTexImage();
            float[] fArr = new float[16];
            this.surfaceTexture.getTransformMatrix(fArr);
            this.listener.onTextureFrameAvailable(this.oesTextureId, fArr, this.surfaceTexture.getTimestamp());
        }
    }

    /* access modifiers changed from: private */
    public void release() {
        Logging.i(TAG, this.name + " release(), this: " + this);
        if (this.handler.getLooper().getThread() != Thread.currentThread()) {
            throw new IllegalStateException("Wrong thread.");
        } else if (this.isOesTextureInUse || this.textureCopyInUse > 0 || !this.isQuitting) {
            throw new IllegalStateException("Unexpected release.");
        } else {
            this.yuvConverter.release();
            this.textureBufferPool.dispose();
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
