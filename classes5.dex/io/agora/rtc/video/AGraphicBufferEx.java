package io.agora.rtc.video;

import android.graphics.Matrix;
import android.os.Build;
import android.os.Handler;
import io.agora.rtc.gl.EglBase;
import io.agora.rtc.gl.RendererCommon;
import io.agora.rtc.gl.VideoFrame;
import io.agora.rtc.gl.YuvConverter;
import io.agora.rtc.utils.ThreadUtils;
import java.util.concurrent.Callable;

public class AGraphicBufferEx implements VideoFrame.TextureBuffer {
    private final EglBase.Context eglContext;
    private int height;
    private final int id;
    /* access modifiers changed from: private */
    public long mHandler;
    private int refCount;
    private final Object refCountLock = new Object();
    private final Runnable releaseCallback;
    private final Handler toI420Handler;
    private Matrix transformMatrix;
    private final VideoFrame.TextureBuffer.Type type;
    private int width;

    private native byte[] getBuffer(long j);

    private native int getTextureId(long j);

    private native long initHardwareBuffer(int i, int i2, int i3);

    /* access modifiers changed from: private */
    public native boolean isValid(long j);

    private native void releaseHardwareBuffer(long j);

    private native void setBuffer(long j, byte[] bArr);

    public int getSequence() {
        return 0;
    }

    public YuvConverter getYuvConverter() {
        return null;
    }

    public VideoFrame.TextureBuffer toAGraphicBufferEx() {
        return this;
    }

    public VideoFrame.I420Buffer toI420() {
        return null;
    }

    public VideoFrame.TextureBuffer toTextureBuffer() {
        return this;
    }

    public AGraphicBufferEx(EglBase.Context context, int i, int i2, Handler handler, int i3, Matrix matrix, Runnable runnable) {
        this.eglContext = context;
        this.width = i;
        this.height = i2;
        this.type = VideoFrame.TextureBuffer.Type.OES;
        this.id = i3;
        this.transformMatrix = matrix;
        this.toI420Handler = handler;
        this.releaseCallback = runnable;
        this.refCount = 1;
        this.mHandler = initHardwareBuffer(i, i2, i3);
    }

    public VideoFrame.TextureBuffer.Type getType() {
        return this.type;
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

    public int getWidth() {
        return this.width;
    }

    public int getHeight() {
        return this.height;
    }

    public void retain() {
        synchronized (this.refCountLock) {
            this.refCount++;
        }
    }

    public void release() {
        Runnable runnable;
        synchronized (this.refCountLock) {
            int i = this.refCount - 1;
            this.refCount = i;
            if (i == 0 && (runnable = this.releaseCallback) != null) {
                runnable.run();
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
        this.transformMatrix = matrix2;
        this.width = i;
        this.height = i2;
        return this;
    }

    public void releaseNativeBuffer() {
        releaseHardwareBuffer(this.mHandler);
    }

    public int getTextureId() {
        return getTextureId(this.mHandler);
    }

    public int getTextureType() {
        return this.type == VideoFrame.TextureBuffer.Type.OES ? 11 : 10;
    }

    public boolean isValidNativeBuffer() {
        return ((Boolean) ThreadUtils.invokeAtFrontUninterruptibly(this.toI420Handler, new Callable<Boolean>() {
            public Boolean call() throws Exception {
                AGraphicBufferEx aGraphicBufferEx = AGraphicBufferEx.this;
                return Boolean.valueOf(aGraphicBufferEx.isValid(aGraphicBufferEx.mHandler));
            }
        })).booleanValue();
    }

    public byte[] getBuffer() {
        return getBuffer(this.mHandler);
    }

    public void setBuffer(byte[] bArr) {
        setBuffer(this.mHandler, bArr);
    }

    public long getNativeBuffer() {
        return ((Long) ThreadUtils.invokeAtFrontUninterruptibly(this.toI420Handler, new Callable<Long>() {
            public Long call() throws Exception {
                return Long.valueOf(AGraphicBufferEx.this.mHandler);
            }
        })).longValue();
    }

    public boolean isNativeBufferSupported() {
        return Build.VERSION.SDK_INT >= 26;
    }

    public String infoString() {
        return toString();
    }

    public String toString() {
        return "AGraphicBufferEx{eglContext=" + this.eglContext + ", width=" + this.width + ", height=" + this.height + ", type=" + this.type + ", id=" + this.id + ", transformMatrix=" + this.transformMatrix + ", toI420Handler=" + this.toI420Handler + ", releaseCallback=" + this.releaseCallback + ", refCountLock=" + this.refCountLock + ", refCount=" + this.refCount + ", mHandler=" + this.mHandler + '}';
    }
}
