package io.agora.rtc.gl;

import android.graphics.Matrix;
import android.os.Build;
import android.os.Handler;
import io.agora.rtc.gl.EglBase;
import io.agora.rtc.gl.VideoFrame;
import io.agora.rtc.utils.ThreadUtils;
import io.agora.rtc.video.AGraphicBufferEx;
import java.util.concurrent.Callable;

public class TextureBufferImpl implements VideoFrame.TextureBuffer {
    private static final boolean VERBOSE = false;
    private AGraphicBufferEx aGraphicBufferEx;
    private final EglBase.Context eglContext;
    private final int height;
    private final int id;
    private int oesTextureId;
    private int refCount;
    private final Object refCountLock;
    private final Runnable releaseCallback;
    private final int sequence;
    private TextureConverter textureConverter;
    private final Handler toI420Handler;
    private final Matrix transformMatrix;
    private final VideoFrame.TextureBuffer.Type type;
    private final int width;
    /* access modifiers changed from: private */
    public final YuvConverter yuvConverter;

    public long getNativeBuffer() {
        return 0;
    }

    public boolean isValidNativeBuffer() {
        return false;
    }

    public VideoFrame.TextureBuffer toTextureBuffer() {
        return this;
    }

    public TextureBufferImpl(EglBase.Context context, int i, int i2, VideoFrame.TextureBuffer.Type type2, int i3, Matrix matrix, Handler handler, YuvConverter yuvConverter2, Runnable runnable, int i4) {
        this.refCountLock = new Object();
        this.eglContext = context;
        this.width = i;
        this.height = i2;
        this.type = type2;
        this.id = i3;
        this.transformMatrix = matrix;
        this.toI420Handler = handler;
        this.yuvConverter = yuvConverter2;
        this.releaseCallback = runnable;
        this.refCount = 1;
        this.oesTextureId = -1;
        this.sequence = i4;
    }

    public TextureBufferImpl(EglBase.Context context, int i, int i2, VideoFrame.TextureBuffer.Type type2, int i3, Matrix matrix, Handler handler, YuvConverter yuvConverter2, Runnable runnable) {
        this(context, i, i2, type2, i3, matrix, handler, yuvConverter2, runnable, -1);
    }

    public VideoFrame.TextureBuffer.Type getType() {
        return this.type;
    }

    public int getTextureId() {
        return this.id;
    }

    public int getTextureType() {
        return this.type == VideoFrame.TextureBuffer.Type.OES ? 11 : 10;
    }

    public Matrix getTransformMatrix() {
        return this.transformMatrix;
    }

    public EglBase.Context getEglBaseContext() {
        return this.eglContext;
    }

    public long getNativeEglContext() {
        EglBase.Context context = this.eglContext;
        if (context != null) {
            return context.getNativeEglContext();
        }
        return 0;
    }

    public float[] getGlTransformMatrix() {
        return RendererCommon.convertMatrixFromAndroidGraphicsMatrix(this.transformMatrix);
    }

    public Object getRealEglContext() {
        return this.eglContext.getRealEglContext();
    }

    public int getEglType() {
        return this.eglContext.getEglType();
    }

    public Handler getToI420Handler() {
        return this.toI420Handler;
    }

    public YuvConverter getYuvConverter() {
        return this.yuvConverter;
    }

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public boolean isNativeBufferSupported() {
        return Build.VERSION.SDK_INT >= 26;
    }

    public int getSequence() {
        return this.sequence;
    }

    public String infoString() {
        return toString();
    }

    public VideoFrame.TextureBuffer toAGraphicBufferEx() {
        if (isNativeBufferSupported()) {
            return (VideoFrame.TextureBuffer) ThreadUtils.invokeAtFrontUninterruptibly(this.toI420Handler, new Callable<VideoFrame.TextureBuffer>() {
                public VideoFrame.TextureBuffer call() throws Exception {
                    return TextureBufferImpl.this.copyToAGraphicBufferEx();
                }
            });
        }
        throw new IllegalStateException("mini api level 26 is needed, curr: " + Build.VERSION.SDK_INT);
    }

    /* access modifiers changed from: private */
    public AGraphicBufferEx copyToAGraphicBufferEx() {
        int i;
        int i2;
        if (getType() == VideoFrame.TextureBuffer.Type.OES) {
            i = 0;
            i2 = 36197;
        } else {
            i2 = 3553;
            i = 1;
        }
        if (this.textureConverter == null) {
            this.textureConverter = new TextureConverter(getTextureId(), i2, i);
        }
        if (this.oesTextureId < 0) {
            this.oesTextureId = this.textureConverter.getOneTexture(36197);
        }
        if (this.aGraphicBufferEx == null) {
            this.aGraphicBufferEx = new AGraphicBufferEx(getEglBaseContext(), getWidth(), getHeight(), this.toI420Handler, this.oesTextureId, getTransformMatrix(), this.releaseCallback);
        }
        this.textureConverter.convert(36197, this.oesTextureId);
        return this.aGraphicBufferEx;
    }

    private void releaseAGraphicBufferEx() {
        TextureConverter textureConverter2 = this.textureConverter;
        if (textureConverter2 != null) {
            textureConverter2.release();
            this.textureConverter = null;
        }
        AGraphicBufferEx aGraphicBufferEx2 = this.aGraphicBufferEx;
        if (aGraphicBufferEx2 != null) {
            aGraphicBufferEx2.releaseNativeBuffer();
            this.aGraphicBufferEx = null;
        }
    }

    public VideoFrame.I420Buffer toI420() {
        return (VideoFrame.I420Buffer) ThreadUtils.invokeAtFrontUninterruptibly(this.toI420Handler, new Callable<VideoFrame.I420Buffer>() {
            public VideoFrame.I420Buffer call() throws Exception {
                return TextureBufferImpl.this.yuvConverter.convert(TextureBufferImpl.this);
            }
        });
    }

    public void retain() {
        synchronized (this.refCountLock) {
            this.refCount++;
        }
    }

    public void release() {
        synchronized (this.refCountLock) {
            int i = this.refCount - 1;
            this.refCount = i;
            if (i == 0 && this.releaseCallback != null) {
                releaseAGraphicBufferEx();
                this.releaseCallback.run();
            }
        }
    }

    public VideoFrame.Buffer cropAndScale(int i, int i2, int i3, int i4, int i5, int i6) {
        Matrix matrix = new Matrix();
        int i7 = this.height;
        matrix.preTranslate(((float) i) / ((float) this.width), ((float) (i7 - (i2 + i4))) / ((float) i7));
        matrix.preScale(((float) i3) / ((float) this.width), ((float) i4) / ((float) this.height));
        return applyTransformMatrix(matrix, i5, i6);
    }

    public VideoFrame.TextureBuffer rotate(int i) {
        boolean z = i == 90 || i == 270;
        int i2 = z ? this.height : this.width;
        int i3 = z ? this.width : this.height;
        Matrix matrix = new Matrix();
        matrix.preTranslate(0.5f, 0.5f);
        matrix.preRotate((float) i);
        matrix.preTranslate(-0.5f, -0.5f);
        return applyTransformMatrix(matrix, i2, i3);
    }

    public VideoFrame.TextureBuffer flip(boolean z) {
        return applyTransformMatrix(RendererCommon.convertMatrixToAndroidGraphicsMatrix(z ? RendererCommon.verticalFlipMatrix() : RendererCommon.horizontalFlipMatrix()), this.width, this.height);
    }

    public VideoFrame.TextureBuffer applyTransformMatrix(Matrix matrix, int i, int i2) {
        Matrix matrix2 = new Matrix(this.transformMatrix);
        matrix2.preConcat(matrix);
        retain();
        return new TextureBufferImpl(this.eglContext, i, i2, this.type, this.id, matrix2, this.toI420Handler, this.yuvConverter, new Runnable() {
            public void run() {
                TextureBufferImpl.this.release();
            }
        }, this.sequence);
    }

    public String toString() {
        return "TextureBufferImpl{eglContext=" + this.eglContext + ", " + this.width + "x" + this.height + ", type=" + this.type + ", seq=" + this.sequence + ", id=" + this.id + ", refCount=" + this.refCount + '}';
    }
}
